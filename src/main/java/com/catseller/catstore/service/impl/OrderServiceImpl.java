package com.catseller.catstore.service.impl;

import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.entity.OrderEntity;
import com.catseller.catstore.repository.OrderRepository;
import com.catseller.catstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Override
  public List<OrderEntity> findAllByMember(MemberEntity memberEntity) {
    return this.orderRepository.findAllByMemberOrderByCreatedDateDesc(memberEntity);
  }

  @Override
  public OrderEntity save(OrderEntity orderEntity) {
    return this.orderRepository.save(orderEntity);
  }
}
