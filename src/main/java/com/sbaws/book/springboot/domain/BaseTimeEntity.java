package com.sbaws.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //해당 클래스를 상속하는경우 클래스내 필드들을 칼럼으로 인식하도록 해줌
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing기능을 포함시킴
public class BaseTimeEntity {

    @CreatedDate  //Entity가 생성될때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할때 시간 자동저장
    private LocalDateTime modifiedDate;
}
