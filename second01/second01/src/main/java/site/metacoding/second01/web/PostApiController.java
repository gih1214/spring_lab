package site.metacoding.second01.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    // SELECT * FROM test WHERE id = ?
    // 구체적으로 뭘 달라고 요청 - body X
    @GetMapping("/post/{id}") // PK를 요청할 때 "/테이블명/PK"
    // 주소에서 id값을 넣으려면 중괄호 사용 & 메서드 매개변수에 @PathVariable 타입 변수
    // DS가 {}를 파싱해주고, 매개변수에 넣어서 호출해줌
    // 그래서 중괄호 안의 값이랑 매개변수명이랑 일치 시켜줘야 함
    public String test1(@PathVariable int id) {
        return "주세요 : id : " + id;
    }

    // SELECT * FROM test WHERE title = ?
    // 구체적으로 뭘 달라고 요청 - body X
    // http://localhost:8000/post?title=?
    @GetMapping("/post")
    public String search(String title) { // 쿼리스트링으로 인식해줌
        return "주세요 title : " + title;
    }

    // http://localhost:8000/post
    // header : Content-Type : application/x-www-form-urlencoded
    // body : title=제목1&content=내용1
    // 뭘 줘야 함 - body O
    // request.getParameter() 메서드가 스프링 기본 파싱 전략임
    @PostMapping("/post")
    public String test2(String title, String content) {
        return "줄께요 : title : " + title + ", content : " + content;
    }

    // UPDATE post SET title = ?, content = ? WHERE id = ?
    // title, content (primary key : id)
    // 뭘 줘야 함 - body O
    // API 문서
    // WHERE 절은 주소, 수정을 원하는 데이터는 body에 담아 보내기
    @PutMapping("/post/{id}") // 수정은 PK도 같이 보내줘야 한다. (얘꺼 수정해줘)
    public String test3(String title, String content, @PathVariable int id) {
        return "수정해주세요 : title : " + title + ", content : " + content + ", id : " + id;
    }

    // http://localhost:8000/post?title=제목1
    // DELETE FROM post WHERE title = ?

    // http://localhost:8000/post/1
    // DELETE FROM post WHERE id = ?
    // 구체적으로 삭제해주세요(PK) - body X
    @DeleteMapping("/post/{id}")
    public String test4(@PathVariable int id) {
        return "삭제해주세요 : id : " + id;
    }

}
