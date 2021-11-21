package com.moveon.server.dto;

import com.moveon.server.repository.Tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class TagPostsRequestDto {
    private final Long tagId;
    private final String tagContent;
    private final Long postId;
    private final Long userId;
    private final String userNickname;
    private final String postsContent;
    private final String profileUrl;
    private final List<Tag> tags;
}
