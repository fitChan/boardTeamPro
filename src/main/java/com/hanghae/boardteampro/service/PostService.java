package com.hanghae.boardteampro.service;

import com.hanghae.boardteampro.dto.req.PostRequestDto;
import com.hanghae.boardteampro.dto.res.PostDetailRes;
import com.hanghae.boardteampro.dto.res.PostSimpleRes;
import com.hanghae.boardteampro.model.Post;
import com.hanghae.boardteampro.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
    }
//    @Transactional(readOnly = true)
//    public List<Board> getBoard() {
//        return boardRepository.findAll();
//    }
    //java board라는 자료형만 들어올 수있어 타입이 제한당함.

    @Transactional(readOnly = true)
    public List<PostSimpleRes> getPost() {
        List<Post> posts = postRepository.findAll();
        return PostSimpleRes.listOf(posts);
    }

    public PostDetailRes getDatailPostInfo(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("해당 아이디값이 없습니다.")
        );
        return PostDetailRes.of(post);
    }

    public void updatePost(Long id,PostRequestDto postRequestDto){
        Post post = postRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당 아이디 값이 없습니다.")
        );
        post.updatePost(postRequestDto);
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

}

