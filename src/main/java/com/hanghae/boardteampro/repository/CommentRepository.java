package com.hanghae.boardteampro.repository;

import com.hanghae.boardteampro.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardId(Long id);
}
