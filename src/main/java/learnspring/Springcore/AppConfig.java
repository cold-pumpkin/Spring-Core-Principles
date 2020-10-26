package learnspring.Springcore;

import learnspring.discount.FixedDiscountPolicy;
import learnspring.member.MemberService;
import learnspring.member.MemberServiceImpl;
import learnspring.member.MemoryMemberRepository;
import learnspring.order.OrderService;
import learnspring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
    }
}
