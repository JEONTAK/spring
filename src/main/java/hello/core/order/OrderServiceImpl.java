package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//롬복의 anootation
//final이 되면 무조건 필수값이 되어버림.
//따라서 필수값인 final이 붙은 것을 가지고 아래에 있는
//public OrderServiceImpl 생성자를 만들어줌!
//진짜진짜 편리하고 유용하니깐 잘 쓰면 좋음!
//특히 의존관계 추가할 때 정말 유용함!
public class OrderServiceImpl implements OrderService{

    //Autowired를 쓸경우 코드가 간결해지지만, 차라리 private final 쓰는 것이 훨씬 안전!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*@Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //위와 같이 코드를 바꿀경우 DiscountPolicy(추상)과 Rate,Fix (구체)클래스 둘다 의존하기때문에, DIP, OCP를 위반하게 된다
    //따라서 오직 추상 클래스인 DiscountPolicy만 의존하게 만들어야 하는 것이 중요!

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
