package com.catseller.catstore.service;

import com.catseller.catstore.entity.ItemEntity;

import java.util.List;

public interface ItemService {
  List<ItemEntity> getItems();
}
