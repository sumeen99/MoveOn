package com.moveon.server.repository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comments {

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(name = "post_id",nullable = false)
    private Long postId;

    @Column(name = "department_id",nullable = false)
    private Long departmentId;

    @Column(name = "school_id",nullable = false)
    private Long schoolId;

    @Column(name = "user_id",nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String content;

    @Column(name="class",nullable = false)
    private int classNum;

    @Column(nullable = false)
    private int num;

    @Column(name="group_id",nullable = false)
    private int groupId;






}
