package com.example.board.web.post;

import com.example.board.domain.post.Post;
import com.example.board.service.post.PostService;
import com.example.board.web.post.dto.res.PostListResponseDto;
import com.example.board.web.post.dto.res.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post-file")
    public String viewPost(){
        return "post-file";
    }

    @GetMapping("/post-list")
    public String postList(Model model){
        List<PostListResponseDto> posts = postService.postList();
        model.addAttribute("posts", posts);
        return "/post/post-list";

    }

    @GetMapping("/post-detail/{id}")
    public String postDetail(@PathVariable Long id, Model model){
        PostResponseDto postResponse = postService.postDetail(id);
        model.addAttribute("post", postResponse);
        return "/post/post-detail";
    }
}
