package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    @Test
    public void springContainerOrderServiceTest() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getTotalPrice()).isEqualTo(9000);
    }

    @Test
    public void createOrderTest() throws Exception {
        //given
        MemberRepository memberRepository = new MemoryMemberRepository();
        // 회원 가입, 조회를 할 수 있는 MemberService
        MemberService memberService = new MemberServiceImpl(memberRepository);

        // 가입한 회원의 주문을 다루는 OrderService
        OrderService orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());

        //when
        // 회원 생성
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(order.getTotalPrice()).isEqualTo(9000);
    }

    @Test
    public void usingAppConfigOrderServiceTest() throws Exception {
        //given
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        //when
        // 회원 생성
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(order.getTotalPrice()).isEqualTo(9000);
    }

}
