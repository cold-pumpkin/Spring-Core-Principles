package learnspring.order;

import learnspring.discount.DiscountPolicy;
import learnspring.member.Member;
import learnspring.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // 인터페이스에만 의존하도록 수정
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 생성자를 통한 의존관계 주입 (AppConfig를 통해 구현체가 주입됨)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 찾아서 할인 정책 적용 후 주문 객체 리턴
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
