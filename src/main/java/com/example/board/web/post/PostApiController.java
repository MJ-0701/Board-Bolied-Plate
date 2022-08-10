package com.example.board.web.post;

import com.example.board.service.post.PostService;
import com.example.board.web.post.dto.PostFileVo;
import com.example.board.web.post.dto.req.PostDeleteDto;
import com.example.board.web.post.dto.req.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post/file/upload")
    public Long create(PostFileVo fileVo) throws Exception{
        PostSaveDto dto = PostSaveDto
                .builder()
                .contents(fileVo.getContents())
                .title(fileVo.getTitle())
                .nickName(fileVo.getNickName())
                .password(fileVo.getPassword())
                .build();

        return postService.create(dto, fileVo.getFiles());
    }

    @DeleteMapping("/post/delete/{id}")
    public void delete(@RequestBody  PostDeleteDto dto, @PathVariable Long id){

        postService.deletePost(dto.getPassword(), id);
    }
}
