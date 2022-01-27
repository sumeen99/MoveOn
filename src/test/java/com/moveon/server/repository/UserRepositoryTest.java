package com.moveon.server.repository;

import com.moveon.server.repository.User.User;
import com.moveon.server.repository.User.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void save() {
        //given
        String nickname = "나는야숨";
        String role = "USER";
        String email = "sumeen123@naver.com";
        Long schoolId = 1L;
        String school = "세종대학교";
        String password = "sumeen123";
        String name = "이수민";
        String introduction = "안녕하세요 저는 세종대랍니다";

        //when
        User user = User.builder().nickname(nickname).role(role).email(email).schoolId(schoolId).school(school).password(password).name(name).introduction(introduction).build();
        userRepository.save(user);

        //then
        User realUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("NO USER"));
        assertThat(realUser.getId()).isEqualTo(user.getId());

    }

}
