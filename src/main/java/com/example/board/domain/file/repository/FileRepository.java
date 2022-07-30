package com.example.board.domain.file.repository;

import com.example.board.domain.file.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<ImageFile, Long> {

}
