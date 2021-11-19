package com.moveon.server.controller;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
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

}
