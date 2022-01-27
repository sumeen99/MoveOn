package com.moveon.server.repository;

import com.moveon.server.repository.Posts.Posts;
import com.moveon.server.repository.Posts.PostsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void save() {
        //given
        String content = "나만 대면하기 싫음?ㅠㅠ";
        Long schoolId = 1L;
        Long departmentId = 2L;
        Long userId = 3L;
        int likeNum = 1;
        String imgUrl = null;

        //when
        Posts posts = Posts.builder().content(content).schoolId(schoolId).departmentId(departmentId).userId(userId).likeNum(likeNum).imgUrl(imgUrl).build();
        postsRepository.save(posts);

        //then
        Posts post = postsRepository.findById(posts.getId()).orElseThrow(() -> new IllegalArgumentException("NO POST"));
        assertThat(posts.getId()).isEqualTo(post.getId());
    }


}
