package com.moveon.server.repository.School;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SchoolQueryRepository {
    private final JPAQueryFactory queryFactory;


}
