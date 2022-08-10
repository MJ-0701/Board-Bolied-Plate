package com.example.board.service.post;

import com.example.board.domain.file.ImageFile;
import com.example.board.domain.photo.Photo;
import com.example.board.domain.photo.repository.PhotoRepository;
import com.example.board.domain.post.Post;
import com.example.board.domain.post.repository.PostRepository;
import com.example.board.service.file.FileHandler;
import com.example.board.service.file.FileService;
import com.example.board.web.post.dto.req.PostDeleteDto;
import com.example.board.web.post.dto.req.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final FileService fileService;
    private final PhotoRepository photoRepository;
    private final PostRepository postRepository;

    @Transactional
    public Long create(PostSaveDto dto, List<MultipartFile> files) throws Exception {
        Post post = Post
                .builder()
                .contents(dto.getContents())
                .title(dto.getTitle())
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .build();

        List<Photo> photoList = fileService.fileInfo(files);
        // 파일이 존재할 때에만 처리
        if(!photoList.isEmpty()) {
            for(Photo photo : photoList) {
                // 파일을 DB에 저장
                post.addPhoto(photoRepository.save(photo));
            }
        }
        return postRepository.save(post).getId();
    }
    @Transactional
    public void deletePost(String password, Long id){
        Post post = postRepository.findByPasswordAndId(password, id);
        postRepository.delete(post);
    }

}
