package myApp.boardApp.entity;

import jakarta.persistence.*;

@Entity
public class UserEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String userId;

    @Column
    private String userName;

    @Column
    private String userPwd;
}
