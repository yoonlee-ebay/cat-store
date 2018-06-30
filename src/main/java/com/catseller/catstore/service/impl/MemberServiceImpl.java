package com.catseller.catstore.service.impl;

import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.repository.MemberRepository;
import com.catseller.catstore.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberRepository memberRepository;

  @Override
  public Optional<MemberEntity> findByEmail(String email) {
    return this.memberRepository.findByEmail(email);
  }
}
