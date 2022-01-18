package com.moveon.server.dto;

import com.moveon.server.repository.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostsRequestDto {
    private Long schoolId;
    private Long departmentId;
    private Long userId;
    private String content;
    private String imgUrl;

    public Posts toPosts(){
        return Posts.builder()
                .schoolId(schoolId)
                .departmentId(departmentId)
                .userId(userId)
                .content(content)
                .imgUrl(imgUrl)
                .likeNum(0)
                .build();
    }
}
