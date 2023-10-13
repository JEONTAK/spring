package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
//Qualifier 1.qualifier끼리 매칭
//2. 빈 이름 매칭
//3. NoSuchBeanDefinitionException 발생
@Primary
//퀄리파이어보다 이것을 더 자주 씀
//@MainDiscountPolicy
//annotation을 사용한 qualifier
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else{
            return 0;
        }
    }
}
