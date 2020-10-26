package learnspring.member;

import learnspring.Springcore.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 각 테스트 실행 전에 먼저 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
