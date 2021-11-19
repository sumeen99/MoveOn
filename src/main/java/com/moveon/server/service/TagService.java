package com.moveon.server.service;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.QueryRepository;
import com.moveon.server.repository.Tag.Tag;
import com.moveon.server.repository.Tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final QueryRepository queryRepository;


    public List<Tag> select(Long departmentId){
        return queryRepository.findTagByDepartmentId(departmentId);
    }

}