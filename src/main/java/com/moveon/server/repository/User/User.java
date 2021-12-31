package com.moveon.server.repository.User;

import com.moveon.server.repository.Authority;
import com.moveon.server.repository.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="school_id",nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String school;

    private String introduction;

    private String profileUrl;

    @ManyToMany
    @JoinTable(
            name= "user_authority",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name" , referencedColumnName = "authority_name")}
    )private Set<Authority> authorities;

}

//enum Authority{//나중에 문제 생기면 원래는 public이 와야했다는거 다시 생각해보자 지금은 문제 생겨서 public없애놓은 상황
//    ROLE_USER,ROLE_ADMIN;
//}