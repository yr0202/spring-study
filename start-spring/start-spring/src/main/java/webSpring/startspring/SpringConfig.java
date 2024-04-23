package webSpring.startspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webSpring.startspring.repository.JdbcMemberRepository;
import webSpring.startspring.repository.JdbcTemplateMemberRepository;
import webSpring.startspring.repository.MemberRepository;
import webSpring.startspring.repository.MemoryMemberRepository;
import webSpring.startspring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
