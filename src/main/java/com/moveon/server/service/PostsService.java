package com.moveon.server.service;

import com.moveon.server.dto.PostsRequestDto;
import com.moveon.server.dto.PostsListResponseDto;
import com.moveon.server.repository.Posts.PostsRepository;
import com.moveon.server.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final QueryRepository queryRepository;

    public List<PostsListResponseDto> selectPosts(Long departmentId, int size){
        return queryRepository.findPostsByDepartmentId(departmentId,size);
    }

    public Long postsSave(PostsRequestDto postsRequestDto){
        return postsRepository.save(postsRequestDto.toPosts()).getId();
    }






}
