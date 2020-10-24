package learnspring.discount;

import learnspring.member.Grade;
import learnspring.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private final int discountFixedAmount = 1000;  // 1000원 고정 할인금액

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        }
        return 0;
    }
}
