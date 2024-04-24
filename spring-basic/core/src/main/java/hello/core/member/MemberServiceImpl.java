package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //여기서 MemberServiceImpl는 MemberRepository와 MemoryMemberRepository 둘 다에 의존하고 있다.
    // dip를 위반한 코드

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}