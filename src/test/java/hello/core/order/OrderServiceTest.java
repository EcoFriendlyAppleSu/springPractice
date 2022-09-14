package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

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

}