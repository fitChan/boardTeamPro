package com.hanghae.boardteampro.service;

import com.hanghae.boardteampro.dto.req.CommentRequestDto;
import com.hanghae.boardteampro.dto.req.PostRequestDto;
import com.hanghae.boardteampro.dto.res.CommentRes;
import com.hanghae.boardteampro.dto.res.PostDetailRes;
import com.hanghae.boardteampro.model.Comment;
import com.hanghae.boardteampro.model.Post;
import com.hanghae.boardteampro.repository.PostRepository;
import com.hanghae.boardteampro.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void createComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
    }
//    @Transactional
//    public Comment createComment(CommentRequestDto requestDto, Long userId, Long boardId){
//        Comment comment = new Comment(requestDto, userId, boardId);
//        commentRepository.save(comment);
//        return comment;
//    }

    @Transactional(readOnly = true)
    public List<CommentRes> getComment(Long id) {
        List<Comment> comment = commentRepository.findAllByBoardId(id);
        return CommentRes.listOf(comment);
    }

    //
//    public List<Comment> getComment(Long id){
//        List<Comment> commentList = commentRepository.findAllByBoardId(id);
//        return commentList;
//    }

    public void updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디 값이 없습니다.")
        );
        comment.updateComment(requestDto);
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


}
