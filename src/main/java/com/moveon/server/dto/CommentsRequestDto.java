package com.moveon.server.dto;

import com.moveon.server.repository.Comments.Comments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CommentsRequestDto {
    private Long schoolId;
    private Long departmentId;
    private Long userId;
    private Long postId;
    private String nickname;
    private String content;
    private int classNum;
    private Long groupId;

    public Comments toComments(){
        return Comments.builder()
                .schoolId(schoolId)
                .departmentId(departmentId)
                .userId(userId)
                .postId(postId)
                .nickname(nickname)
                .content(content)
                .classNum(classNum)
                .groupId(groupId)
                .build();
    }

}
