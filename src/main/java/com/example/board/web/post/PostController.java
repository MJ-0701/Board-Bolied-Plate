package com.example.board.web.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/post-file")
    public String viewPost(){
        return "post-file";
    }
}
