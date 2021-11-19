package com.moveon.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class TagPostsRequestDto {
    private final Long tagId;
    private final String tagContent;
    private final Long userId;
    private final String userNickname;
    private final String postsContent;
}
