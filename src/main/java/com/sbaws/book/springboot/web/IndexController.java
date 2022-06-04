package com.sbaws.book.springboot.web;

import com.sbaws.book.springboot.config.auth.LoginUser;
import com.sbaws.book.springboot.config.auth.dto.SessionUser;
import com.sbaws.book.springboot.domain.posts.Posts;
import com.sbaws.book.springboot.service.posts.PostsService;
import com.sbaws.book.springboot.web.dto.PostsListResponseDto;
import com.sbaws.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
/*
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //로그인성공시 값을 세션에 SessionUser를 저장하도록 구성
        if(user!=null){
            model.addAttribute("userName", user.getName()); //세션에 저장된 값이 없으면 로그인버튼이 보이도록..
        }
        return "index";
    }
*/
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if(user!=null){
            model.addAttribute("userName", user.getName()); //세션에 저장된 값이 없으면 로그인버튼이 보이도록..
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
