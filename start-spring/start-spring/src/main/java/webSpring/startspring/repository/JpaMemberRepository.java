package webSpring.startspring.repository;

import jakarta.persistence.EntityManager;
import webSpring.startspring.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //jpa는 EntityManager라는걸로 모든게 동작함
                                    // 결론: jap를 쓰려면 EntityManager를 주입 받아야한다

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // 영구 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //.class는 특정 클래스의 메타데이터를 참조하는 방식
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { //jpql이라는 객체지향 쿼리를 사용해야함
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() { //객체를 대상으로 쿼리를 날림
        return em.createQuery("select m from Member as m", Member.class)
                .getResultList();
        /* 위 코드랑 똑같음 Inline variable로 합침
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
         */
    }
}
