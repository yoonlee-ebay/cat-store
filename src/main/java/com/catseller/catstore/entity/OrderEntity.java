package com.catseller.catstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  private String orderStatus;
  private String address;
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
