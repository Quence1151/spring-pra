package com.practice.springpra.service;

import com.practice.springpra.repository.JdbcMemberRepository;
import com.practice.springpra.repository.JpaMemberRepository;
import com.practice.springpra.repository.MemberRepository;
import com.practice.springpra.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
        //return new JdbcMemberRepository(dataSource);
    }

}
