package com.catseller.catstore.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class ItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;
  private String itemStatus;
  private String name;
  private BigDecimal price;
  private String imageUrl;
  @CreatedDate
  private LocalDateTime createdDate;
  @CreatedBy
  private String createdBy;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;
  @LastModifiedBy
  private String lastModifiedBy;
}
