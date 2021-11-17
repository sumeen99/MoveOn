package com.moveon.server.repository;

import com.moveon.server.repository.School.School;
import com.moveon.server.repository.School.SchoolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QueryRepositoryTest {

    @Autowired
    private QueryRepository QueryRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    public void findByContent(){
        //given
        String content="광운대학교";
        schoolRepository.save(School.builder().content(content).build());
        //when
        School school=QueryRepository.findByContent(content);
        //then
        assertThat(school.getContent()).isEqualTo(content);
    }
}
