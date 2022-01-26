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
    public void save() {
        //given
        String content = "홍익대학교";
        String emailForm = "hongik.ac.kr";


        //when
        School school = schoolRepository.save(School.builder().content(content).emailForm(emailForm).build());

        //then
        School school1 = schoolRepository.findById(school.getId()).orElseThrow(() -> new IllegalArgumentException("No School!"));
        assertThat(school.getId()).isEqualTo(school1.getId());
    }
}
