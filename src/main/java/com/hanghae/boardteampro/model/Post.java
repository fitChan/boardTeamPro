package com.hanghae.boardteampro.model;

import com.hanghae.boardteampro.dto.req.PostRequestDto;
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
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
//    private User user;

//    @Column(nullable = false)
//    private Long userId;
//    @Column(nullable = false)
//    private Long categoryId;
//    @Column(nullable = false)
//    private double grade;


    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private boolean isOpen = false;
    @Column(nullable = false)
    private String author;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.isOpen = requestDto.isOpen();
        this.author = requestDto.getAuthor();
    }

    public void updatePost(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.isOpen = requestDto.isOpen();
        this.author = requestDto.getAuthor();
    }


}
