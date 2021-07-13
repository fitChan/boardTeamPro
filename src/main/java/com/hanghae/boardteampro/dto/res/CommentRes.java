package com.hanghae.boardteampro.dto.res;


import com.hanghae.boardteampro.model.Comment;
import com.hanghae.boardteampro.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentRes {

    private String comment;

    public static CommentRes of(Comment comment) {
        return new CommentRes(comment.getComment());
    }


    public static List<CommentRes> listOf(List<Comment> comments) {
        ArrayList<CommentRes> commentRes = new ArrayList<>();
        for (Comment comment : comments) {
            commentRes.add(of(comment));
        }
        return commentRes;
    }
    //댓글은 리스트(?)로 불러와야할 것같아서 ... 이렇게 가져옴
    //listOf는 parameter로 Comment를 받는 list인 comments를 받아
    //commentRes라는 CommentRes클래스를 담은 ArrayList 생성
    //for each로 Comment클레스 comment에 comments를 넣고
    //  해당 comment를 commentRes에 추가 .
}
