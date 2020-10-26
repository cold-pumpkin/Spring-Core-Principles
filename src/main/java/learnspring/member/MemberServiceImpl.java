package learnspring.member;

public class MemberServiceImpl implements MemberService {

    // 인터페이스에만 의존하도록 수정
    private final MemberRepository memberRepository;

    // 생성자를 통한 의존관계 주입 (AppConfig를 통해 구현체가 주입됨)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
