package com.example.board.web.photo.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoDto {

    @JsonProperty("origin_file_name")
    private String originFileName;

    @JsonProperty("file_path")
    private String filePath;

    @JsonProperty("file_size")
    private Long fileSize;
}
