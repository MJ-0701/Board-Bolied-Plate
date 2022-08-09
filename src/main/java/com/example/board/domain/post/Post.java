package com.example.board.domain.post;

import com.example.board.domain.photo.Photo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    @Lob
    private String contents;

    @OneToMany(mappedBy = "post", cascade ={CascadeType.PERSIST, CascadeType.REMOVE} ,orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();

    @Builder
    public Post(String title, String contents) {

        this.title = title;
        this.contents = contents;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // Post에서 파일 처리 위함
    public void addPhoto(Photo photo) { // 연관관계 매핑
        this.photos.add(photo);
        // 게시글에 파일이 저장되어있지 않은 경우
        if(photo.getPost() != this)
            // 파일 저장
            photo.setPost(this);
    }

}
