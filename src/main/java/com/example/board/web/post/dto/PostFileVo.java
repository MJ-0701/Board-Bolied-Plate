package com.example.board.web.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PostFileVo {

    private String contents;

    private String title;

    @JsonProperty("nick_name")
    private String nickName;

    private String password;

    private List<MultipartFile> files;
}
