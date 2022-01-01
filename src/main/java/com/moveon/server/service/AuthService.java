package com.moveon.server.service;

import com.moveon.server.config.Jwt.JwtTokenProvider;
import com.moveon.server.dto.LoginDto;
import com.moveon.server.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = loginDto.toAuthentication(); // ID/PW로 AuthenticationToken 생성
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); // 사용자 비밀번호 체크, CustomUserDetailsService에서의 loadUserByUsername 메서드가 실행됨
        SecurityContextHolder.getContext().setAuthentication(authentication);//securityContext에 저장
        return jwtTokenProvider.createToken(authentication);

    }

}
