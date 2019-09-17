package com.phang.webservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/*
DB Layer 접근자
: ibatis/MyBatis 등 Dao
    JPA에서는 Repository라고 부르며 인터페이스로 생성한다.

사용법: 단순히 인터페이스로 생성 후,  JpaRepository<Entity 클래스명, PK타입>을 상속하면,
    기본적인 CRUD 메소드가 자동생성된다.
    @Repository를 추가할 필요도 없다!
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
