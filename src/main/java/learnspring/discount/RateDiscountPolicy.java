package learnspring.discount;

import learnspring.member.Grade;
import learnspring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private static final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
