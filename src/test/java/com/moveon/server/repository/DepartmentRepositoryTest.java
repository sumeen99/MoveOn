package com.moveon.server.repository;

import com.moveon.server.repository.Department.Department;
import com.moveon.server.repository.Department.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void save(){
        //given
        Long schoolId=1L;
        String content="우정당";

        //when
        Department department=departmentRepository.save(Department.builder().schoolId(schoolId).content(content).build());

        //then
        Department department1=departmentRepository.findById(department.getId()).orElseThrow(()->new IllegalArgumentException("NO DEPARTMENT"));
        assertThat(department).isEqualTo(department1);
    }

}
