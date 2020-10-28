package learnspring.Springcore;

import learnspring.discount.DiscountPolicy;
import learnspring.discount.FixedDiscountPolicy;
import learnspring.discount.RateDiscountPolicy;
import learnspring.member.MemberRepository;
import learnspring.member.MemberService;
import learnspring.member.MemberServiceImpl;
import learnspring.member.MemoryMemberRepository;
import learnspring.order.OrderService;
import learnspring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {  // 역할에 따른 구현으로 리팩토링

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();  // 구현체 바뀌면 이 부분만 수정
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());  // 구현체 바뀌면 이 부분만 수정
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixedDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
