package com.moveon.server.repository;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class PostsTagRelationShipRepositoryTest {

    @Autowired
    PostsTagRelationShipRepository postsTagRelationShipRepository;

    @Test
    public void save() {
        //given
        Long schoolId = 1L;
        Long departmentId = 2L;
        Long postId = 2L;
        Long userId = 2L;
        Long tagId = 1L;

        //when
        PostsTagRelationShip postsTagRelationShip = PostsTagRelationShip.builder().schoolId(schoolId).departmentId(departmentId).postId(postId).userId(userId).tagId(tagId).build();
        postsTagRelationShipRepository.save(postsTagRelationShip);

        //then
        PostsTagRelationShip postsTagRelationShip1 = postsTagRelationShipRepository.findById(postsTagRelationShip.getId()).orElseThrow(() -> new IllegalArgumentException("NO POSTS_TAG_RELATIONSHIP"));
        assertThat(postsTagRelationShip.getId()).isEqualTo(postsTagRelationShip1.getId());
    }
}
