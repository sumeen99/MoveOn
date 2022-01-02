package com.moveon.server.dto;

import com.moveon.server.repository.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String email;

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user.getEmail());
    }

}
