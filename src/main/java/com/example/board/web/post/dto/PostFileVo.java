package com.example.board.web.post.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostFileVo {

    private String contents;

    private String title;

    private List<MultipartFile> files;
}
