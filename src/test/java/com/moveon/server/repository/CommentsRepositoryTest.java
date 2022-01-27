package com.moveon.server.repository;

import com.moveon.server.repository.Comments.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class CommentsRepositoryTest {

    @Autowired
    CommentsRepository commentsRepository;



}
