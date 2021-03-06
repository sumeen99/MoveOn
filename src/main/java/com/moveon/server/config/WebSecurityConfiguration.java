package com.moveon.server.config;

import com.moveon.server.config.Jwt.JwtAccessDeniedHandler;
import com.moveon.server.config.Jwt.JwtAuthenticationEntryPoint;
import com.moveon.server.config.Jwt.JwtSecurityConfiguration;
import com.moveon.server.config.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic().disable()//rest api 만을 고려하여 기본 설정 해제
                .csrf().disable()//csrf 보안 토큰 disable 처리

                .exceptionHandling()//오류처리
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용 x

                .and()
                .authorizeRequests()//권한
                .antMatchers("/api/auth/**").permitAll() //로그인 부분
                .anyRequest().authenticated()// 그밖에 모든 부분은 인증받아야함

                .and()
                .apply(new JwtSecurityConfiguration(jwtTokenProvider)); //jwtFilter 적용

    }
}
