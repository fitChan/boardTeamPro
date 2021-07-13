package com.hanghae.boardteampro.controller;

import com.hanghae.boardteampro.dto.req.CommentRequestDto;
import com.hanghae.boardteampro.dto.req.PostRequestDto;
import com.hanghae.boardteampro.dto.res.CommentRes;
import com.hanghae.boardteampro.dto.res.PostDetailRes;
import com.hanghae.boardteampro.model.Comment;
import com.hanghae.boardteampro.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    @Autowired
    private final CommentService commentService;

//    @PostMapping("/board")
//    public Comment createComment(@RequestBody CommentRequestDto requestDto, Long userId, Long boardId) {
//        Comment comment = commentService.createComment(requestDto, userId, boardId);
//        return comment;
//    }

    @PostMapping("")
    public ResponseEntity<Void> createComment(@RequestBody CommentRequestDto requestDto){
        commentService.createComment(requestDto);
        return ResponseEntity.created(URI.create("/api/posts")).build(); //외우자 create 201이야
    }

    @GetMapping("/board/{id}/comment")
    public ResponseEntity<List<CommentRes>> getComments(@PathVariable Long id) {
        return ResponseEntity.ok().body(commentService.getComment(id));
    }

    @PutMapping("/board/{id}/comment")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.updateComment(id,requestDto);
        return ResponseEntity.created(URI.create("/board/{id}/comment")).build();
    }

    @DeleteMapping("/board/{id}/comment")
    public Long deletePost(@PathVariable Long id){
        commentService.deleteComment(id);
        return id;
    }


}
