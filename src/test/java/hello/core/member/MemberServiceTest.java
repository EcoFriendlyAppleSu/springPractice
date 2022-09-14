package hello.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    @Test
    public void memberSaveTest() throws Exception {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member1 = new Member(1L, "Lee", Grade.VIP);

        memberService.join(member1);
        Member member = memberService.findMember(1L);
        assertThat(member).isEqualTo(member1);
    }

}