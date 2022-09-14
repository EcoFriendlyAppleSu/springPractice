package hello.core.domain.member;

import hello.core.repository.MemoryMemberRepository;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    public void memberSaveTest() throws Exception {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member1 = new Member(1L, "Lee", Grade.VIP);

        memberService.join(member1);
        Member member = memberService.findMember(1L);
        assertThat(member).isEqualTo(member1);
    }

}