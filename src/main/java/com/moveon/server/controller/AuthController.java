package com.moveon.server.controller;


import com.moveon.server.config.Jwt.JwtAuthenticationFilter;
import com.moveon.server.dto.LoginDto;
import com.moveon.server.dto.SignUpDto;
import com.moveon.server.dto.TokenDto;
import com.moveon.server.dto.UserResponseDto;
import com.moveon.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) {
        String jwt = authService.login(loginDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody SignUpDto signUpDto){
        return ResponseEntity.ok(authService.signUp(signUpDto));
    }
}
