package com.hanghae.boardteampro.dto.res;

import com.hanghae.boardteampro.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostSimpleRes {

    private String title;
    private String author;


    //정적 팩토리 메서드 (?) 제네릭 (?)
    public static PostSimpleRes of(Post post) {
        return new PostSimpleRes(post.getTitle(), post.getAuthor());
    }

    //람다
    public static List<PostSimpleRes> listOf(List<Post> posts) {
        ArrayList<PostSimpleRes> simpleRes = new ArrayList<>();
        for (Post post : posts) {
            simpleRes.add(of(post));
        }
        return simpleRes;
    }

}
