package webSpring.startspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webSpring.startspring.domain.Member;
import webSpring.startspring.repository.MemberRepository;
import webSpring.startspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /*
    회원가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    //        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { // result에 만약 값이 있으면 함수 실행
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//        memberRepository.findByName(member.getName()) // 이렇게 쓰는걸 권장
//            .ifPresent(m -> {
//                throw new IllegalStateException("이미 존재하는 회원입니다.");
//            }); // findByName이라는 로직이 쭉 나오면 method로 뽑는게 좋음 => ctrl+alt+m

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
