package com.moveon.server.controller;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.Tag.Tag;
import com.moveon.server.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TagController {

    private final TagService tagService;

    @ResponseBody
    @GetMapping("/api/v1/tag/select")
    public List<Tag> select(@RequestParam("department-id")Long departmentId){
        return tagService.selectTags(departmentId);
    }

}
