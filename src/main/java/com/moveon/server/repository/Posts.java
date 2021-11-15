package com.moveon.server.repository;

import javax.persistence.*;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(name = "school_id",nullable = false)
    private Long schoolId;

    @Column(name = "department_id",nullable = false)
    private Long departmentId;



}
