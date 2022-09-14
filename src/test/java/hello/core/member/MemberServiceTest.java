package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    @Test
    public void usingSpringContainerTest() throws Exception {
        // spring container bean 설정 정보를 담아 사용한다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);// param : beanName, return type

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(memberA);
    }
    @Test
    public void appConfigUsingTest() throws Exception {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(memberA);
    }

    @Test
    public void memberSaveTest() throws Exception {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member1 = new Member(1L, "Lee", Grade.VIP);

        memberService.join(member1);
        Member member = memberService.findMember(1L);
        assertThat(member).isEqualTo(member1);
    }

}