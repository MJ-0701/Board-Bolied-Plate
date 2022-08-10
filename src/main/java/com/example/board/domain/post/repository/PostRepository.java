package com.example.board.domain.post.repository;

import com.example.board.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

    Post findByNickNameAndPassword(String nikName, String password);

    Post findByPasswordAndId(String password, Long id);
}
