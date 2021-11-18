package com.moveon.server.repository;

import com.moveon.server.repository.User.User;
import com.moveon.server.repository.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
@Transactional
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void save(){
        //given
        String nickname="나는야쥼";
        String role="USER";
        String email="joomi@naver.com";
        Long schoolId=1L;
        String school="세종대학교";
        String password="abcde";
        String name="심주미";
        String introduction="안녕하세요 저는 소융대생이랍니다";

        //when
        User user=User.builder().nickname(nickname).role(role).email(email).schoolId(schoolId).school(school).password(password).name(name).introduction(introduction).build();
        userRepository.save(user);
        //then
        User realUser=userRepository.findById(user.getId()).orElseThrow(()->new IllegalArgumentException("NO USER"));
        assertThat(realUser).isEqualTo(user);

    }

}
