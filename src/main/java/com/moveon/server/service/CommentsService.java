package com.moveon.server.service;

import com.moveon.server.dto.CommentsRequestDto;
import com.moveon.server.dto.CommentsResponseDto;
import com.moveon.server.repository.Comments.Comments;
import com.moveon.server.repository.Comments.CommentsRepository;
import com.moveon.server.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final QueryRepository queryRepository;

    @Transactional
    public Long commentsSave(CommentsRequestDto commentsRequestDto){
        Comments comments = commentsRepository.save(commentsRequestDto.toComments());
         if(comments.getClassNum()==0){
            comments.updateGroupId();
         }
         return comments.getId();
    }

    @Transactional
    public List<CommentsResponseDto> selectComments(Long postId){
        return queryRepository.findAllCommentsByPostId(postId);
    }


}
