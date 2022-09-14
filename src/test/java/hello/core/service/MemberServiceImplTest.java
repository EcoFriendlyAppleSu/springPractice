package hello.core.service;

import hello.core.domain.member.Grade;
import hello.core.domain.member.Member;
import hello.core.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    public void joinTest() throws Exception {
        //given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(findMember).isEqualTo(memberA);
    }

}