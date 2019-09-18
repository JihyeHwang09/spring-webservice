package com.phang.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
//@MappedSuperclass: JPA Enitity 클래스들이 BaseTimeEntity를 상속할 경우,
//  필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 한다.
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class): JPA Entity 클래스에 Auditing 기능을 포함시킨다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /*
    LocalDateTime: Java8부터 LocalDate와 LocalDateTime이 등장
    -> Java의 기본 날짜 타입인 Date의 문제점을 제대로 고친 타입이므로 Java8일 경우 사용하기!
    (이유: Java8이 나오기전까진 JodaTime이라는 오픈소스를 사용해서 문제점들을 피했었고, Java8에선 LocalDate를 통해 해결했었음.)
     */

//    @CreatedDate: Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    @CreatedDate
    private LocalDateTime createDate;

//    @LastModifiedDate: 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
