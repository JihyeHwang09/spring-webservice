package com.phang.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//URL요청시 main.hbs 파일을 호출할수 있도록 Controller를 생성
@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main() {
        /*
        Q> URL 요청시 main.hbs 파일을 호출하려는데 경로를 다 주지 않고,
        왜 "main"만 return 하는가?
        -> handlebars-spring-boot-starter 덕분에,
         컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정된다.
         (prefix: src/main/resources/templates, suffix: .hbs)가 생략된 것임

         Q> "main"을 반환이후 과정?
         ->  src/main/resources/templates/main.hbs로 전환됨
         -> View Resolver가 처리
         (cf) ViewResolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격으로 보면 된다.)
         */
        return "main";
    }
}
