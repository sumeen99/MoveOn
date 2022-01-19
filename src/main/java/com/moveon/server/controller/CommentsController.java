package com.moveon.server.controller;

import com.moveon.server.dto.CommentsRequestDto;
import com.moveon.server.dto.CommentsResponseDto;
import com.moveon.server.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @ResponseBody
    @PostMapping("/save")
    public Long save(@RequestBody CommentsRequestDto commentsRequestDto){
        return commentsService.commentsSave(commentsRequestDto);
    }

    @ResponseBody
    @GetMapping("/select")
    public List<CommentsResponseDto> select(@RequestParam("post-id") Long postId){
        return commentsService.selectComments(postId);
    }



}
