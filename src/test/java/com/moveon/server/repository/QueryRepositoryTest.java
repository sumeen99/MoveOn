package com.moveon.server.repository;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShipRepository;
import com.moveon.server.repository.School.School;
import com.moveon.server.repository.School.SchoolRepository;
import com.moveon.server.repository.Tag.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class QueryRepositoryTest {

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PostsTagRelationShipRepository postsTagRelationShipRepository;

    @Test
    public void findByContent() {
        //given
        String content = "광운대학교";
        //LocalDateTime now= LocalDateTime.of(2021,11,19,0,0,0);
        //schoolRepository.save(School.builder().content(content).build());
        //when
        School school = queryRepository.findByContent(content);
        //then
        assertThat(school.getContent()).isEqualTo(content);

    }

    @Test
    public void findTagByDepartmentId() {
        //given
        Long departmentId = 2L;
        Long schoolId = 1L;
        Long postId = 2L;
        Long tagId = 3L;
        Long userId = 2L;
        PostsTagRelationShip postsTagRelationShip = postsTagRelationShipRepository.save(PostsTagRelationShip.builder().departmentId(departmentId).schoolId(schoolId).postId(postId).userId(userId).tagId(tagId).build());

        //when
        List<Tag> tags = queryRepository.findTagByDepartmentId(departmentId);


        //then
        assertThat(tags.get(tags.size() - 1).getId()).isEqualTo(postsTagRelationShip.getTagId());
    }


}
