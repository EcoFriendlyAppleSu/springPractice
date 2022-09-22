package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //final : 무조건 값이 존재해야한다.
    private final DiscountPolicy discountPolicy;

    /*
    @RequiredArgsConstructor 기능을 사용하면 final이 붙은 필드를 모아서 생성자를 자동으로 만들어준다.
    @Autowired 생성자 하나면 생략 가능
    DiscountPolicy 앞에 @MainDiscountPolicy를 사용해 @Bean 중복 등록을 해결할 수 있다.
     */

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discount);
    }

    //test에 사용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
