package com.phang.webservice.web;

import com.phang.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController: @ResponseBody를 모든 메소드에 적용해준다.

@RestController
/*
@AllArgsConstructor
    : 모든 필드를 인자값으로 하는 생성자를 Lombok의 @AllArgsConstructor가
    대신 생성해 준다.

    Q> 생성자를 직접 사용하지 않고 Lombok 어노테이션인 @AllArgsConstructor를 사용하는 이유?
    해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정해야 하는 번거로움을
    해결하기 위해서이다.
    -> ex) Lombok 어노테이션이 있을 경우,
    1) 해당 컨트롤러에 새로운 서비스를 추가하거나
    2) 기존 컴포넌트를 제거하는 등이
     발생해도 생성자 코드는 전혀 손대지 않아도 된다.
 */
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    // hello 메소드의 결과인 "HelloWorld" 문자열이 JSON 형태로 반환된다.
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
