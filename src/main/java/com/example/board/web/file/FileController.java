package com.example.board.web.file;

import com.example.board.domain.board.Board;
import com.example.board.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FileController {

    private final BoardService boardService;

    @GetMapping("/view-file")
    public String viewController(){
        return "file";
    }

    @PostMapping("/board/file")
    public String boardFileTest(Board board, Model model, MultipartFile files) throws IOException {
        boardService.write(board, files);
        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/index");

        return "message";
    }

    @GetMapping("/board/index")
    public String boardIndex(){
        return "index";
    }
}
