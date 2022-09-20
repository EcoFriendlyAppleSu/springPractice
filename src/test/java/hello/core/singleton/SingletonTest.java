package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @DisplayName("스프링 없는 순수한 DI 컨테이너 - 조회")
    @Test
    public void javaPlainDIContainerTest() throws Exception {
        
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);


        assertThat(memberService1).isNotSameAs(memberService2);
    } // 매 요청마다 새로운 객체가 생성되어 DI에 쌓이게됨

    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    @Test
    public void singletonServiceTest() throws Exception {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        assertThat(instance1).isSameAs(instance2); // 참조 비교
    } // 요청에 상관 없이 생성된 객체를 참조하면서 사용
}
