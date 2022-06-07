package com.sbaws.book.springboot.domain.posts;

import com.sbaws.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
//@NoArgsConstructor //기본생성자 자동추가
@Entity             //엔티티클래스에서는 setter를 만들지 않음
public class Posts extends BaseTimeEntity {

    public Posts(){}

    @Id  //해당 테이블의 pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk의 생성규칙 identity옵션을 추가해야 자동증가사용가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당클래스의 빌더패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
