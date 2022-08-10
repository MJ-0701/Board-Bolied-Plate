package com.example.board.web.post.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDeleteDto {

    @JsonProperty("nick_name")
    private String nickName;

    private String password;
}
