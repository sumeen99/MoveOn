package com.moveon.server.controller;

import com.moveon.server.dto.TagPostsResponseDto;
import com.moveon.server.service.PostsTagRelationShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostsTagRelationShipController {
    private final PostsTagRelationShipService postsTagRelationShipService;

    @ResponseBody
    @GetMapping("/api/v1/posts-tag-relationship/select")
    public List<TagPostsResponseDto> select(@RequestParam("department-id") Long departmentId, @RequestParam("size") int size) {
        return postsTagRelationShipService.selectTagPosts(departmentId, size);
    }

}
