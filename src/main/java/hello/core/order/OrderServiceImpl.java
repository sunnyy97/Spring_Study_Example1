package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 할인 정책 애플리케이션

/*
    생성자 주입
    - 이름 그대로 생성자를 통해서 의존 관계를 주입 받는 방법
    - 지금까지 우리가 진행했던 방법이 바로 생성자 주입이다.
    - 특징
        1. 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
        2. 불변, 필수 의존관계에 사용
 */
@Component
public class OrderServiceImpl implements OrderService{
    // 인터페이스에서만 의존하도록 설정
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // @Autowired --> 생성자가 딱 1개일 경우엔 @Autowired 생략 가능! 자등으로 의존관계 주입이 일어남(물론 스프링 빈에서만!)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
