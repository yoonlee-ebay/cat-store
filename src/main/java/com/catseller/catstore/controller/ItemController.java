package com.catseller.catstore.controller;

import com.catseller.catstore.entity.ItemEntity;
import com.catseller.catstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {
  @Autowired
  private ItemService itemService;

  @GetMapping("/{itemId}")
  public String index(@PathVariable Long itemId, ModelMap modelMap) {
    Optional<ItemEntity> itemEntity = this.itemService.getItemById(itemId);

    return itemEntity.map(o -> {
      modelMap.addAttribute("item", o);

      return "item/index";
    }).orElse("redirect:/");
  }
}
