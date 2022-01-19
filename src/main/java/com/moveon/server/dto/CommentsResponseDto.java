package com.moveon.server.dto;

import com.moveon.server.repository.Comments.Comments;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class CommentsResponseDto {
    private Long userId;
    private String nickname;
    private String content;
    private LocalDateTime createdDate;
    private List<CommentsResponseDto> commentsResponseDtoList;


}
