package learnspring.order;

import learnspring.discount.DiscountPolicy;
import learnspring.discount.FixedDiscountPolicy;
import learnspring.discount.RateDiscountPolicy;
import learnspring.member.Member;
import learnspring.member.MemberRepository;
import learnspring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /** 할인 정책 변경 시 클라이언트 코드를 바꿔야하는 문제 발생 **/
    //private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 회원 찾아서 할인 정책 적용 후 주문 객체 리턴
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
