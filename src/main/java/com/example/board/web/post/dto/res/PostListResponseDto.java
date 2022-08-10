package com.example.board.web.post.dto.res;

import com.example.board.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostListResponseDto {

    private final Long id;
    private final String title;

    private final String contents;

    @JsonProperty("nick_name")
    private String nickName;

    public PostListResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.nickName = entity.getNickName();
    }
}
