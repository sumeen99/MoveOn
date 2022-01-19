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
        return commentsRepository.save(commentsRequestDto.toComments()).getId();
    }

    @Transactional
    public List<CommentsResponseDto> selectComments(Long postId){
        return queryRepository.findAllCommentsByPostId(postId);
    }


}
