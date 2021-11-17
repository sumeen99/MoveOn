package com.moveon.server.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "post_id",nullable = false)
    private Long postId;

    @Column(name="department_id",nullable = false)
    private Long departmentId;

    @Column(name="school_id",nullable = false)
    private Long schoolId;

    @Column(name="user_id",nullable = false)
    private Long userId;

}
