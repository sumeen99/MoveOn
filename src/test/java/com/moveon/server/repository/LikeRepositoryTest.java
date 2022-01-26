package com.moveon.server.repository;

import com.moveon.server.repository.Like.Like;
import com.moveon.server.repository.Like.LikeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class LikeRepositoryTest {

    @Autowired
    LikeRepository likeRepository;

    @Test
    public void save() {
        //given
        Long schoolId = 1L;
        Long departmentId = 2L;
        Long postId = 6L;
        Long userId = 10L;

        //when
        Like like = Like.builder().schoolId(schoolId).departmentId(departmentId).postId(postId).userId(userId).build();
        likeRepository.save(like);

        //then
        Like like1 = likeRepository.findById(like.getId()).orElseThrow(() -> new IllegalArgumentException("NO LIKE"));
        assertThat(like1.getId()).isEqualTo(like.getId());
    }
}
