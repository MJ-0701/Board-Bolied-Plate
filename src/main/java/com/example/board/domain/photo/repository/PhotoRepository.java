package com.example.board.domain.photo.repository;

import com.example.board.domain.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
