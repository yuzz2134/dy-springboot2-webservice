package com.sbaws.book.springboot.domain.user;

import com.sbaws.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@NoArgsConstructor //-500오류로 제거
@Entity
public class User extends BaseTimeEntity {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    //@Enumerated(EnumType.STRING) : JPA를 DB로 저장할 때 Enum값을 어떤형태로 저장할지 결정(기본 int)이나
    // DB확인시 무슨코드를 의미하는지 알수 없어서 문자열로 저장
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
