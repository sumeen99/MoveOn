package com.moveon.server.dto;

import com.moveon.server.repository.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class LoginDto {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email,password);
    }

}
