package com.example.board.domain.photo;

import com.example.board.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "file")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    @Column(nullable = false)
    private String originFileName; // 파일 원본명

    @Column(nullable = false)
    private String filePath; // 파일 저장경로

    private Long fileSize;

    @Builder
    public Photo(String originFileName, String filePath, Long fileSize){
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    // Board 정보 저장
    public void setPost(Post post){
        this.post = post;

        // 게시글에 현재 파일이 존재하지 않는다면
        if(!post.getPhotos().contains(this))
            // 파일 추가
            post.getPhotos().add(this);
    }
}
