package com.moveon.server.repository;

import com.moveon.server.repository.Comments.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;



}
