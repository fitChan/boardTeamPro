package com.hanghae.boardteampro.controller;

import com.hanghae.boardteampro.dto.req.PostRequestDto;
import com.hanghae.boardteampro.dto.res.PostDetailRes;
import com.hanghae.boardteampro.dto.res.PostSimpleRes;
import com.hanghae.boardteampro.model.Post;
import com.hanghae.boardteampro.repository.PostRepository;
import com.hanghae.boardteampro.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/posts")
@RestController
@RequiredArgsConstructor
//생성자 만들어줌 new
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;



    // service 로 다 바꾸자 && repository 빼버리자
    //data를 원하는 대로 가공하는 service business logic
    @GetMapping("")
    public ResponseEntity<List<PostSimpleRes>> getPost() { // 여기 이상함 이따가 함 봐야함
        return ResponseEntity.ok().body(postService.getPost()); //reponse는 (ok)200이야
    }

//    @PostMapping("")
//    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
//
//        Board board = boardService.createBoard(requestDto);
//        return board;
//    }
    @PostMapping("")
    public ResponseEntity<Void> createPost(@RequestBody PostRequestDto requestDto){ //외우자
        postService.createPost(requestDto);
        return ResponseEntity.created(URI.create("/api/posts")).build(); //외우자 create 201이야
    }
    //런타임 에러 일어날거임
    //상세정보는 id받기

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailRes> getDetailPostInfo(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.getDatailPostInfo(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.updatePost(id, requestDto);
        return ResponseEntity.created(URI.create("/api/posts/{id}")).build();
    }

    @DeleteMapping("/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.deletePost(id);
        return id;
    }


}
