package com.moveon.server.repository.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moveon.server.dto.SignUpDto;
import com.moveon.server.repository.Authority;
import com.moveon.server.repository.BaseTimeEntity;
import com.moveon.server.repository.School.School;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name="school_id",nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false,unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String school;

    private String introduction;

    private String profileUrl;

    @JsonIgnore
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name= "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_name")
    )private Set<Authority> authorities;

    public static User toUser(School school, SignUpDto signUpDto, Authority authority, String password){
        return User.builder()
                .schoolId(school.getId())
                .school(school.getContent())
                .nickname("익명")
                .role("이거곧지울부분")
                .email(signUpDto.getEmail())
                .password(password)
                .name(signUpDto.getName())
                .activated(true)
                .authorities(Collections.singleton(authority))
                .build();
    }



}
