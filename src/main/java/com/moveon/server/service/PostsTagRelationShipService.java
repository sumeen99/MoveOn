package com.moveon.server.service;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShipRepository;
import com.moveon.server.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsTagRelationShipService {
    private final PostsTagRelationShipRepository postsTagRelationShipRepository;
    private final QueryRepository queryRepository;



}
