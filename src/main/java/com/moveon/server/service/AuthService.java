package com.moveon.server.service;

import com.moveon.server.config.Jwt.JwtTokenProvider;
import com.moveon.server.dto.LoginDto;
import com.moveon.server.dto.SignUpDto;
import com.moveon.server.dto.TokenDto;
import com.moveon.server.dto.UserResponseDto;
import com.moveon.server.repository.Authority;
import com.moveon.server.repository.QueryRepository;
import com.moveon.server.repository.School.School;
import com.moveon.server.repository.User.User;
import com.moveon.server.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final QueryRepository queryRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenDto login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = loginDto.toAuthentication(); // ID/PW로 AuthenticationToken 생성
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); // 사용자 비밀번호 체크, CustomUserDetailsService에서의 loadUserByUsername 메서드가 실행됨
        SecurityContextHolder.getContext().setAuthentication(authentication);//securityContext에 저장
        return jwtTokenProvider.createToken(authentication);

    }

    @Transactional
    public UserResponseDto signUp(SignUpDto signUpDto) {
        if (userRepository.findOneWithAuthoritiesByEmail(signUpDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        School school = queryRepository.findByContent(signUpDto.getSchool());

        User user = User.toUser(school, signUpDto, authority, passwordEncoder.encode(signUpDto.getPassword()));

        return UserResponseDto.of(userRepository.save(user));
    }


}
