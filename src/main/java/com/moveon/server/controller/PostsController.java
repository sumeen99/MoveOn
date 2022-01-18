package com.moveon.server.controller;

import com.moveon.server.dto.PostsRequestDto;
import com.moveon.server.dto.PostsListResponseDto;
import com.moveon.server.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @ResponseBody
    @GetMapping("/api/v1/posts/select")
    public List<PostsListResponseDto> select(@RequestParam("department_id") Long departmentId, @RequestParam("size") int size) {
        return postsService.selectPosts(departmentId, size);
    }

    @ResponseBody
    @PostMapping("/api/v1/posts/select")
    public Long save(@RequestBody PostsRequestDto postsRequestDto) {
        return postsService.postsSave(postsRequestDto);
    }


}
