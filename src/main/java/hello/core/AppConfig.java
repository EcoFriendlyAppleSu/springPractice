package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
* 구현 객체 생성을 담당하는 AppConfig
* */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryMemberRepository(), fixDiscountPolicy());
    }

    private DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }
    private MemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
