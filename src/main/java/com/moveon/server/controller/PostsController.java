package com.moveon.server.controller;

import com.moveon.server.dto.PostsRequestDto;
import com.moveon.server.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @ResponseBody
    @GetMapping("/api/v1/posts/select")
    public List<PostsRequestDto> select(@RequestParam("department_id")Long departmentId,@RequestParam("size") int size){
        return postsService.selectPosts(departmentId,size);
    }
}
