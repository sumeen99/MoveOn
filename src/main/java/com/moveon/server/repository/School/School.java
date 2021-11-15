package com.moveon.server.repository.School;

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
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="school_id")
    public Collection<Department> departments;



}
