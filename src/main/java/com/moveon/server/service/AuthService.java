package com.moveon.server.service;

import com.moveon.server.config.Jwt.JwtTokenProvider;
import com.moveon.server.dto.LoginDto;
import com.moveon.server.dto.SignUpDto;
import com.moveon.server.dto.TokenDto;
import com.moveon.server.dto.UserResponseDto;
import com.moveon.server.repository.Authority;
import com.moveon.server.repository.QueryRepository;
import com.moveon.server.repository.RefreshToken.RefreshToken;
import com.moveon.server.repository.RefreshToken.RefreshTokenRepository;
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
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenDto login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = loginDto.toAuthentication(); // ID/PW로 AuthenticationToken 생성
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); // 사용자 비밀번호 체크, CustomUserDetailsService에서의 loadUserByUsername 메서드가 실행됨
        SecurityContextHolder.getContext().setAuthentication(authentication);//securityContext에 저장

        TokenDto tokenDto = jwtTokenProvider.createToken(authentication);
        RefreshToken refreshToken = RefreshToken.builder()
                .userId(authentication.getName())
                .token(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);
        return tokenDto;

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

    @Transactional
    public TokenDto reissue(TokenDto tokenDto) {
        // 1. Refresh Token 검증
        if (!jwtTokenProvider.validateToken(tokenDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token 에서 User ID 가져오기
        Authentication authentication = jwtTokenProvider.getAuthentication(tokenDto.getAccessToken());

        // 3. 저장소에서 User ID 를 기반으로 Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getUserId().equals(tokenDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto newTokenDto = jwtTokenProvider.createToken(authentication);

        // 6. 저장소 정보 업데이트
        refreshToken.update(tokenDto.getRefreshToken());

        // 토큰 발급
        return tokenDto;
    }


}
