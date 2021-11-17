package com.moveon.server.repository.Posts;

import com.moveon.server.repository.Comments.Comments;
import com.moveon.server.repository.Like.Like;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(name = "school_id",nullable = false)
    private Long schoolId;

    @Column(name = "department_id",nullable = false)
    private Long departmentId;

    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name = "user_nickname",nullable = false)
    private String userNikcname;

    @Column(nullable = false)
    private String content;

    @Column(name="like_num",nullable = false)
    private int likeNum;

    @Column(name="img_url")
    private String imgUrl;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="school_id")
    private Collection<Comments> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="school_id")
    private Collection<Like> likes;

}
