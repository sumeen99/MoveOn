package com.moveon.server.repository.Department;

import com.moveon.server.repository.BaseTimeEntity;
import com.moveon.server.repository.Posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "school_id",nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="school_id")
    private Collection<Posts> posts;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private double y;

    @Column(nullable = false)
    private double distance;


}
