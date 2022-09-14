package hello.core.member;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    @Test
    public void joinTest() throws Exception {
        //given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);
        Member memberB = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(findMember).isEqualTo(memberA);
    }

}