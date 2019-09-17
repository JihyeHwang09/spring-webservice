package com.phang.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController: @ResponseBody를 모든 메소드에 적용해준다.
 */
@RestController
public class WebRestController {
    // hello 메소드의 결과인 "HelloWorld" 문자열이 JSON 형태로 반환된다.
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
