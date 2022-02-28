package site.metacoding.second01.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import site.metacoding.second01.domain.Post;

// View (글쓰기 페이지, 글 목록 페이지, 글 상세보기 페이지)
@Controller
public class PostController {

    // 글쓰기 페이지 만들기
    @GetMapping("/post/writeForm")
    public String writeForm() {
        return "post/writeForm";
    }

    @GetMapping("/post/list")
    public String list(Model model) {

        // 1. DB에 연결해서 SELECT 해야 함.
        // 2. ResultSet을 JavaObject로 변경
        Post post1 = new Post(1, "제목1", "내용1");
        Post post2 = new Post(2, "제목2", "내용2");
        Post post3 = new Post(3, "제목3", "내용3");
        Post post4 = new Post(4, "제목4", "내용4");
        Post post5 = new Post(5, "제목5", "내용5");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);

        // 3. request에 담기
        model.addAttribute("posts", posts); // 키값이 "posts" 니까 보내는 변수도 posts

        return "post/list";
    }

    @GetMapping("/post/detail")
    public String detail(Model model) { // Spring은 request를 model을 쓴다.

        // 1. DB에 연결해서 SELECT 해야 함.
        // 2. ResultSet을 JavaObject로 변경
        Post post = new Post(1, "제목1", "내용1");

        // 3. request에 담기
        model.addAttribute("post", post);

        return "post/detail"; // RequestDispatcher로 forward 해줌 = request가 복제됨.
    }
}
