package com.catseller.catstore.service;

import com.catseller.catstore.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {
  Optional<MemberEntity> findByEmail(String email);
}
