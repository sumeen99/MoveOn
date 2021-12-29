package com.moveon.server.service;

import com.moveon.server.dto.UserResponseDto;
import com.moveon.server.repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
