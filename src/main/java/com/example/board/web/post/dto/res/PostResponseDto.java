package com.example.board.web.post.dto.res;

import com.example.board.domain.photo.Photo;
import com.example.board.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponseDto {

    @JsonProperty("nick_name")
    private String nickName;

    private final String contents;

    private final String title;

//    private final List<String> fileName;
    private final List<String> filePath;

    public PostResponseDto(Post entity){
        this.nickName = entity.getNickName();
        this.contents = entity.getContents();
        this.title = entity.getTitle();
//        this.fileName = entity.getPhotos().stream().map(Photo::getOriginFileName).collect(Collectors.toList()); // 파일 이름만.
        this.filePath = entity.getPhotos().stream().map(Photo::getFilePath).collect(Collectors.toList()); // 실제 파일 경로

    }
}
