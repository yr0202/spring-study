package webSpring.startspring.domain;

/*
jpa = 객체 + ORM(Object, Relation, Mapping)
 */

import jakarta.persistence.*;

@Entity
public class Member {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에서 스스로 값을 증가해주는 것 아이덴티티 전략이라함
    private Long id;

    // 만약 db 명이 username이면 @Column(name = "username") 붙이기
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
