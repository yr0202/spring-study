package webSpring.startspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webSpring.startspring.repository.MemberRepository;
import webSpring.startspring.repository.MemoryMemberRepository;
import webSpring.startspring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
