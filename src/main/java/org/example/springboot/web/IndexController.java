package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.LoginUser;
import org.example.springboot.config.auth.dto.SessionUser;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
//    private final HttpSession httpSession;
//
//    @GetMapping("/")
//    public String index(Model model){
//        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        if(user != null) {
//            model.addAttribute("userName", user.getName());
//        }
//
//        return "index";   // src/main/resources/templates 가 기본경로이고, return된 "index" 뒤에 .mustache를 붙이고 View Resolver가 처리함
//    }

    @GetMapping("/")  //위의 함수에서 세션 유저를 가져오는 부분을 리팩토링함 (위처럼 하면 index메소드 외에 다른 컨트롤러와 메소드에서 세션값이 필요할때마다 직접 세션에서 값을 가져와야하는 반복작업이 생기게 됨)
    public String index(Model model, @LoginUser SessionUser user){  //@LoginUser 어노테이션 생성한 것을 이용함. 다른 컨트롤러에서도 @LoginUser만 사용하면 세션정보 가져올 수 있게 됨.
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
