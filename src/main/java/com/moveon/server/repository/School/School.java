package com.moveon.server.repository.School;

import com.moveon.server.repository.BaseTimeEntity;
import com.moveon.server.repository.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class School extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="school_id")
    private Collection<Department> departments;



}
