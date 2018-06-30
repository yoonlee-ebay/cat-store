package com.catseller.catstore.service.impl;

import com.catseller.catstore.entity.ItemEntity;
import com.catseller.catstore.repository.ItemRepository;
import com.catseller.catstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
  @Autowired
  private ItemRepository itemRepository;

  @Override
  public List<ItemEntity> getItems() {
    return this.itemRepository.findAll();
  }

  @Override
  public Optional<ItemEntity> getItemById(Long itemId) {
    return this.itemRepository.findById(itemId);
  }
}
