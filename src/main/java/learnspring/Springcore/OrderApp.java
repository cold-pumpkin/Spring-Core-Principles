package learnspring.Springcore;

import learnspring.member.Grade;
import learnspring.member.Member;
import learnspring.member.MemberService;
import learnspring.member.MemberServiceImpl;
import learnspring.order.Order;
import learnspring.order.OrderService;
import learnspring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        // ** 1) 직접 서비스 생성
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        // ** 2) AppConfig를 통해 의존성 주입
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        // ** 3) 스프링 컨테이너 활용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        // 회원 등록 후 주문
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order);
        System.out.println(order.calculatePrice());

    }
}
