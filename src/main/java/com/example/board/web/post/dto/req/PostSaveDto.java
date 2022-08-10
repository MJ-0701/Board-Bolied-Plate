package com.example.board.web.post.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSaveDto {

    private String title;

    private String contents;

    @JsonProperty("nick_name")
    private String nickName;

    private String password;

    private List<MultipartFile> files;
}

