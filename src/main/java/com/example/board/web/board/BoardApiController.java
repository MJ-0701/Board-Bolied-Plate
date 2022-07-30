package com.example.board.web.board;

import com.example.board.service.board.BoardService;
import com.example.board.web.board.dto.req.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/board-save")
    public ResponseEntity<?> boardSaveController(@RequestBody BoardRequestDto requestDto) throws Exception {
        System.out.println("컨트롤러 :" + requestDto.getName());
        Long boardIdx = boardService.boardSave(requestDto, requestDto.getFile());
        URI uriLocation = new URI("/board/" + boardIdx);
        return ResponseEntity.created(uriLocation).body("{}");
    }

}
