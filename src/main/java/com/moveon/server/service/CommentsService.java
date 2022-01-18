package com.moveon.server.service;

import com.moveon.server.dto.CommentsRequestDto;
import com.moveon.server.repository.Comments.Comments;
import com.moveon.server.repository.Comments.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;

    @Transactional
    public Long commentsSave(CommentsRequestDto commentsRequestDto){
        return commentsRepository.save(commentsRequestDto.toComments()).getId();
    }

    @Transactional
    public List<Comments>(Long postId){

    }


}
