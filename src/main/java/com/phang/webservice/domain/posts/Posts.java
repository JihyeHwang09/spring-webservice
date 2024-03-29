package com.phang.webservice.domain.posts;

import com.phang.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/*
 @NoArgsConstructor: 기본 생성자(파라미터가 없는 생성자) 자동 추가
    (access = AccessLevel.PROTECTED): 기본 생성자의 접근 권한을 protected로 제한
    생성자로 protected Posts() {}와 같은 효과
    Entity 클래스를 프로젝트 코드상에서 기본 생성자로 생성하는 것은 막되,
    JPA에서 Entity 클래스를 생성하는 것은 허용하기 위해서 추가한다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)

//@Getter: 클래스 내의 모든 필드의 Getter 메소드를 자동 생성
@Getter
@Entity
/*
 @Entity
 : 테이블과 링크될 클래스
 언더스코어 네이밍(_)으로 이름을 매칭한다.
 ex) SalesManager.java -> sales_manager table
 */

/*
JPA를 사용하면, DB 데이터에 작업할 때 실제 쿼리를 날리기보다는
이 Entity 클래스를 수정하여 작업한다.
 */
public class Posts extends BaseTimeEntity {
    // @Id: 해당 테이블의 PK 필드를 나타냄
    @Id

/*
    @GeneratedValue
    : PK의 생성 규칙을 나타냄
    기본값: AUTO, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 된다.
    스프링 부트 2.0 이상에서는 옵션을 추가해야만 auto_increment가 된다.
 */
/*
Tip> Entity의 PK는 Long 타입의 auto_increment를 추천
    주민등록번호와 같은 비지니스상의 유니크키나, 여러 키를 조합한 복합키로 PK를 잡을 경우
    난감한 상황이 종종 발생한다.
    1) FK 맺을 때, 다른 테이블에서 복합키 전부를 갖고 있거나 중간 테이블을 하나 더 둬야 하는 상황 발생
    2) 인덱스에 좋은 영향을 끼치지 못한다.
    3) 유니크한 조건이 변경될 경우, PK 전체를 수정해야하는 일이 발생
    -> 주민등록번호, 복합키 등은 유니크키로 별도로 추가하는 것을 추천
 */
    @GeneratedValue
    private Long id;

    /*
    @Column
    : 테이블의 컬럼을 나타내면, 굳이 선언하지 않아도 해당 클래스의 필드가 모두 컬럼이 된다.
    * 사용 이유: 기본값 외에 추가로 변경이 필요한 옵션이 있을 경우 사용
    ex) 문자열의 경우 VARCHAR(255)가 기본값이다.
        글 제목의 사이즈를 500으로 늘리고 싶을 때(title),
        타입을 TEXT로 변경하고 싶을 때(content) 등의 경우에 사용한다.
     */
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    @Builder: 해당 클래스의 빌더 패턴 클래스를 생성
         생성자 상단에 선언시, 생성자에 포함된 필드만 빌더에 포함한다.
     */
    @Builder
    public Posts (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
/*
서비스 구축단계에서는 테이블 설계(여기선 Entity설계)가 빈번하게 변경된다.
 이때 Lombok의 어노테이션들은 코드 변경량을 최소화시켜주기 때문에 Lombok 어노테이션을 추천!
 */