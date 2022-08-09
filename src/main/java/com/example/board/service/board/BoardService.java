package com.example.board.service.board;

import com.example.board.domain.board.Board;
import com.example.board.domain.board.repository.BoardRepository;
import com.example.board.web.board.dto.req.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public void write(Board board , MultipartFile file) throws IOException {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; // 프로젝트 경로 + 스태틱 하위의 files 디렉토리
        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);
        file.transferTo(saveFile);
        Board imgFile = Board
                .builder()
                .fileName(fileName)
                .filePath("/files/" + fileName)
                .build();


        boardRepository.save(imgFile);
    }

}
