package com.moveon.server.service;

import com.moveon.server.dto.TagPostsRequestDto;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShipRepository;
import com.moveon.server.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsTagRelationShipService {
    private final PostsTagRelationShipRepository postsTagRelationShipRepository;
    private final QueryRepository queryRepository;

    @Transactional(readOnly = true)
    public List<TagPostsRequestDto> selectTagPosts(Long departmentId,int cnt){
        return queryRepository.findTagPostsByDepartmentId(departmentId,cnt);
    }


}
