package com.hanghae.boardteampro.dto.res;


import com.hanghae.boardteampro.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDetailRes {
    private String title;
    private String author;
    private String content;

//    private boolean isOpen;

    public static PostDetailRes of(Post post){
        return new PostDetailRes(post.getTitle(), post.getAuthor(), post.getContent());
    }
}
