package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    public void singletonConfigurationTest() throws Exception {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //when
        // interface 로 데이터를 꺼내면 특정 Method를 사용할 수 없어
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        MemoryMemberRepository memoryMemberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        //then
        System.out.println(orderService.getMemberRepository());
        System.out.println(memberService.getMemberRepository());
        System.out.println(memoryMemberRepository);

        Assertions.assertThat(orderService.getMemberRepository()).isEqualTo(memberService.getMemberRepository());
    } // 모두 같은 인스턴스가 공유되어 사용된다.
    
    @Test
    public void configurationDeepTest() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
    } // CGLIB -> 내가 만든 클래스가 아니야 Spring이 byteCode를 조작한다.

}
