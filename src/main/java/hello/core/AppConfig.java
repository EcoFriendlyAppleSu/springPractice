package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 구현 객체 생성을 담당하는 AppConfig
* @Configuration Bean 정보를 DI Container에 등록
* CoreApplication 실행 시 AppConfig가 AutoAppConfig보다 먼저 수행되는 이유는
* 수동 Bean 등록이 우선권을 갖기 때문이다.
* */

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memoryMemberRepository");
        return new MemoryMemberRepository();
    }
}
