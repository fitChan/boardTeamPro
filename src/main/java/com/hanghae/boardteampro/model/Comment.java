package com.hanghae.boardteampro.model;

import com.hanghae.boardteampro.dto.req.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long boardId;
    @Column(nullable = false)
    private String comment;

//    public Comment(CommentRequestDto requestDto, Long userId, Long boardId) {
//        this.userId = userId;
//        this.boardId = boardId;
//        this.comment = requestDto.getComment();
//    }
    public Comment(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }
    public void updateComment(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }
}
