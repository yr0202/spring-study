package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 스프링 빈으로 자동 설정 해주는 @
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Autowired //@Component를 쓰면 빈에 자동으로 들어가지만 의존관계 설정하기 어려움 @Autowired로 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
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

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
