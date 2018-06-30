package com.catseller.catstore.service;

import com.catseller.catstore.entity.ItemEntity;

import java.util.List;
import java.util.Optional;

public interface ItemService {
  List<ItemEntity> getItems();
  Optional<ItemEntity> getItemById(Long itemId);
}
