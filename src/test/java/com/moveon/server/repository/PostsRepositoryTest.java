package com.moveon.server.repository;

import com.moveon.server.repository.Posts.Posts;
import com.moveon.server.repository.Posts.PostsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void save(){
        //given
        String content="오랜만에 대면이라서 학교에서 밥먹을 사람이 없네요ㅠ 혹시 학관에서 같이 밥먹을사람?";
        Long schoolId=1L;
        Long departmentId=2L;
        Long userId=2L;
        int likeNum=2;
        String imgUrl=null;
        String userNickname="나는야숨";
        //when
        Posts posts=Posts.builder().content(content).schoolId(schoolId).departmentId(departmentId).userId(userId).likeNum(likeNum).imgUrl(imgUrl).userNikcname(userNickname).build();
        postsRepository.save(posts);
        //then
        Posts post=postsRepository.findById(posts.getId()).orElseThrow(()->new IllegalArgumentException("NO POST"));
        assertThat(posts.getContent()).isEqualTo(post.getContent());
    }


}
