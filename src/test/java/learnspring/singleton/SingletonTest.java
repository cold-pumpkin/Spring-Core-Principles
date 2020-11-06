package learnspring.singleton;

import learnspring.Springcore.AppConfig;
import learnspring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 호출할 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 객체 참조값이 다름
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }
}
