package com.moveon.server.repository;

import com.moveon.server.repository.Tag.Tag;
import com.moveon.server.repository.Tag.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class TagRepositoryTest {

    @Autowired
    TagRepository tagRepository;


    @Test
    public void save(){
        //given
        String content="선거";
        //when
        Tag realTag=tagRepository.save(Tag.builder().content(content).build());

        //then
        Tag tag=tagRepository.findById(realTag.getId()).orElseThrow(()->new IllegalArgumentException("NO TAG"));
        assertThat(tag).isEqualTo(realTag);
    }
}
