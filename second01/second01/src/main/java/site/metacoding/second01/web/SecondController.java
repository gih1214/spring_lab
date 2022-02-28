package site.metacoding.second01.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController는 Data를 리턴해준다. (PrintWriter로 리턴)
@RestController
public class SecondController {

    // CRUD : 대부분의 컴퓨터 소프트웨어가 가지는 기본적인 데이터 처리 기능을 묶어서 일컫는 말

    // GET : 주세요 (Read - SELECT)

    @GetMapping("/user") // 주소는 보통 테이블명 적음 -> 요청할 때 문장 만들어짐 (test 주세요)
    public String test1() {
        return "<h1>test1</h1>";
    }

    // POST : 줄게요 (Create - INSERT)
    @PostMapping("/user")
    public String test2() {
        return "<h1>test2</h1>";
    }

    // PUT : 수정해주세요 (Update - UPDATE)
    @PutMapping("/user")
    public String test3() {
        return "<h1>test3</h1>";
    }

    // DELETE : 삭제해주세요 (Delete - DELETE)
    @DeleteMapping("/user")
    public String test4() {
        return "<h1>test4</h1>";
    }

}
