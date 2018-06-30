package com.catseller.catstore.service;

import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.entity.OrderEntity;

import java.util.List;

public interface OrderService {
  List<OrderEntity> findAllByMember(MemberEntity memberEntity);
  OrderEntity save(OrderEntity orderEntity);
}
