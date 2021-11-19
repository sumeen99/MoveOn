package com.moveon.server.repository;

import com.moveon.server.repository.School.School;
import com.moveon.server.repository.School.SchoolRepository;
import com.moveon.server.repository.Tag.Tag;
import org.assertj.core.api.LocalDateTimeAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
@SpringBootTest
public class QueryRepositoryTest {

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    public void findByContent(){
        //given
        String content="광운대학교";
        //LocalDateTime now= LocalDateTime.of(2021,11,19,0,0,0);
        schoolRepository.save(School.builder().content(content).build());
        //when
        School school=queryRepository.findByContent(content);
        //then
        assertThat(school.getContent()).isEqualTo(content);

    }

    @Test
    public void findByTagDepartmentId(){
        //given
        Long departmentId=2L;
        //when
        List<Tag> tags= queryRepository.findTagByDepartmentId(departmentId);
        //
        System.out.println(tags);
    }

}
