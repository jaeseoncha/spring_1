package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy =new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10프로할인적용해야한다")
    void vip_0(){
        //givne
        Member member =new Member(1L ,"memberVip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member,10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
//    @Test
//    @DisplayName("vip아니면 10프로할인적용되면안된다")
//    void vip_x(){
//        //givne
//        Member member =new Member(1L ,"memberBasic", Grade.BASIC);
//        //when
//        int discount = discountPolicy.discount(member,10000);
//
//        // then
//        Assertions.assertThat(discount).isEqualTo(1000);
//    }



}