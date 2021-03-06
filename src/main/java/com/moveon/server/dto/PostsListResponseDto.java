package com.moveon.server.dto;

import com.moveon.server.repository.Tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class PostsListResponseDto {
    private final Long userId;
    private final String nickname;
    private final String profileUrl;
    private final Long postId;
    private final String imgUrl;
    private final String content;
    private final Boolean like;
    private final List<Tag> tags;
    private final LocalDateTime createdDate;

}
