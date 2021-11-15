package com.moveon.server.repository;

import com.moveon.server.repository.School.School;
import com.moveon.server.repository.School.SchoolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class SchoolRepositoryTest {

    @Autowired
    SchoolRepository schoolRepository;

    @Test
    public void save(){
        //given
        String content="이화여자대학교";

        //when
        School school=schoolRepository.save(School.builder().content(content).build());

        //then
        School school1=schoolRepository.findById(school.getId()).orElseThrow(()->new IllegalArgumentException("No School!"));
        assertThat(school).isEqualTo(school1);
    }
}
