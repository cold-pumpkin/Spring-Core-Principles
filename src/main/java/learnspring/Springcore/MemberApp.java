package learnspring.Springcore;

import learnspring.member.Grade;
import learnspring.member.Member;
import learnspring.member.MemberService;
import learnspring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        // ** 1) 직접 서비스 생성
        //MemberService memberService = new MemberServiceImpl();

        // ** 2) AppConfig를 통해 의존성 주입
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // ** 3) 스프링 컨테이너 활용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // 회원 가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원 조회
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
