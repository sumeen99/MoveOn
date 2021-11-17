package com.moveon.server.repository.Department;

import com.moveon.server.repository.Posts;
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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(name = "school_id",nullable = false)
    private Long schoolId;

    @Column(nullable = false)
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="school_id")
    private Collection<Posts> posts;


}
