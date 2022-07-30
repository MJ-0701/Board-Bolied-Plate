package com.example.board.service.board;

import com.example.board.domain.board.Board;
import com.example.board.domain.board.repository.BoardRepository;
import com.example.board.web.board.dto.req.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long boardSave(BoardRequestDto requestDto, List<MultipartFile> files){
        Board board = Board
                .builder()
                .contents(requestDto.getContents())
                .name(requestDto.getName())
                .build();
        boardRepository.save(board);

        return board.getIdx();
    }

}
