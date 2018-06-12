package com.catseller.catstore.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  private String orderStatus;
  @CreatedDate
  private LocalDateTime createdDate;
  @CreatedBy
  private String createdBy;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;
  @LastModifiedBy
  private String lastModifiedBy;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "item_id")
  private ItemEntity item;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "member_id")
  private MemberEntity member;
}
