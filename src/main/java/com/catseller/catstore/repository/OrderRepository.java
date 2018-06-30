package com.catseller.catstore.repository;

import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  List<OrderEntity> findAllByMemberOrderByCreatedDateDesc(MemberEntity memberEntity);
}
