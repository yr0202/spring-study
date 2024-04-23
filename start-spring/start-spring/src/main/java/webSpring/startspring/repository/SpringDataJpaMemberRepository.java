package webSpring.startspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webSpring.startspring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    //인터페이스가 인터페이스를 받을때는 implements가 아니라 extends

    // findByName => JPQL : select m from Member m where m.name = ? 이렇게 쿼리를 짜줌
    @Override
    Optional<Member> findByName(String name);
}
