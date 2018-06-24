package com.catseller.catstore.controller;

import com.catseller.catstore.entity.ItemEntity;
import com.catseller.catstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
  @Autowired
  private ItemService itemService;

  @GetMapping
  public String index(ModelMap modelMap) {
    List<ItemEntity> items = this.itemService.getItems();

    modelMap.addAttribute("items", items);

    return "home/index";
  }
}
