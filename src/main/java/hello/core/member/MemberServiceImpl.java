package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    // 생성자를 통해서 memberRepository에 들어갈 것을 구현
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
    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
