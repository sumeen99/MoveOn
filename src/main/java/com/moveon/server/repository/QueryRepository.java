package com.moveon.server.repository;

import com.moveon.server.repository.School.School;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.moveon.server.repository.School.QSchool.school;

@RequiredArgsConstructor
@Repository
public class QueryRepository {
    private final JPAQueryFactory queryFactory;

    public School findByContent(String content){
        return queryFactory.selectFrom(school).where(school.content.eq(content)).fetchOne();
    }




}
