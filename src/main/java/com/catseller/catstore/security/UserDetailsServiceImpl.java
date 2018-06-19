package com.catseller.catstore.security;

import com.catseller.catstore.entity.MemberEntity;
import com.catseller.catstore.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MemberEntity member = this.memberRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("user not found"));

    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

    UserDetails userDetails = new User(username, member.getPassword(), Arrays.asList(authority));

    return userDetails;
  }
}
