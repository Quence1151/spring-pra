package com.practice.springpra.service;

import com.practice.springpra.domain.Member;

import com.practice.springpra.repository.MemberRepository;
import com.practice.springpra.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){ //테스트는 독립적으로 시행되어야함으로 매번 테스트 종료시에는 공용공간을 초기화 해줘야함.
        memberRepository.clearStroe();
    }

    @Test
    void 회원가입() { //테스트코드는 외국인과 작업하는 경우가 아니면 한국어로 만들어도 무관.
        //given(~이 있을때)
        Member member = new Member();
        member.setName("spring");

        //when(~을 사용하면)
        Long saveId = memberService.join(member);

        //then(~결과가 나와야함)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*

        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
        }

*/
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}