package com.moveon.server.repository.User;

import com.moveon.server.repository.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="school_id",nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String school;

    private String introduction;

    private String profileUrl;
}
