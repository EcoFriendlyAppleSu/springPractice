package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @DisplayName("vip discount pass test")
    @Test
    public void rateDiscountTest() throws Exception {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        //then
        assertThat(rateDiscountPolicy.discount(memberVIP, 10000)).isEqualTo(1000);
    }

    @Test
    public void rateDiscountFailTest() throws Exception {
        //given
        Member memberBasic = new Member(2L, "memberBasic", Grade.BASIC);

        //then
        Assertions.assertThat(rateDiscountPolicy.discount(memberBasic, 10000)).isEqualTo(0);
    }

}