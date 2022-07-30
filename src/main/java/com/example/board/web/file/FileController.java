package com.example.board.web.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/file")
public class FileController {

    @GetMapping("/view-file")
    public String viewController(){
        return "file";
    }
}
