package learnspring.Springcore;

import learnspring.member.Grade;
import learnspring.member.Member;
import learnspring.member.MemberService;
import learnspring.member.MemberServiceImpl;
import learnspring.order.Order;
import learnspring.order.OrderService;
import learnspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // 회원 등록 후 주문
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order);
        System.out.println(order.calculatePrice());

    }
}
