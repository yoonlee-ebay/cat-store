package com.catseller.catstore.controller;

import com.catseller.catstore.entity.ItemEntity;
import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.entity.OrderEntity;
import com.catseller.catstore.service.ItemService;
import com.catseller.catstore.service.MemberService;
import com.catseller.catstore.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {
  @Autowired
  private OrderService orderService;

  @Autowired
  private ItemService itemService;

  @Autowired
  private MemberService memberService;

  @GetMapping
  public String index(Principal principal, ModelMap modelMap) {
    String email = principal.getName();

    Optional<MemberEntity> memberEntity = this.memberService.findByEmail(email);

    return memberEntity.map(o -> {
      List<OrderEntity> orderEntities = this.orderService.findAllByMember(o);

      modelMap.addAttribute("orders", orderEntities);

      return "order/index";
    }).orElse("redirect:/logout");
  }

  @GetMapping("/orderForm")
  public String orderForm(@RequestParam Long itemId, ModelMap modelMap) {
    Optional<ItemEntity> itemEntity = this.itemService.getItemById(itemId);

    return itemEntity.map(o -> {
      modelMap.addAttribute("item", o);

      return "order/orderForm";
    }).orElse("redirect:/orders");
  }

  @PostMapping("/orderForm")
  public String submitOrderForm(Principal principal,
                                @RequestParam Long itemId,
                                @RequestParam String address) {
    String email = principal.getName();

    Optional<MemberEntity> memberEntity = this.memberService.findByEmail(email);

    Optional<ItemEntity> itemEntity = this.itemService.getItemById(itemId);

    if (memberEntity.isPresent() && itemEntity.isPresent()) {
      OrderEntity orderEntity = OrderEntity.builder()
          .orderStatus("ORDERED")
          .address(address)
          .createdDate(LocalDateTime.now())
          .createdBy(email)
          .lastModifiedDate(LocalDateTime.now())
          .lastModifiedBy(email)
          .item(itemEntity.get())
          .member(memberEntity.get())
          .build();

      this.orderService.save(orderEntity);

      return "redirect:/orders";
    } else {
      throw new RuntimeException("error");
    }
  }
}
