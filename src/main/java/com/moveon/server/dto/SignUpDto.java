package com.moveon.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveon.server.repository.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {

    @NotNull
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String school;

    private Set<Authority> authoritySet;

}
