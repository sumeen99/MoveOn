package com.moveon.server.repository;

import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.School.School;
import com.moveon.server.repository.Tag.Tag;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.moveon.server.repository.PostsTagRelationShip.QPostsTagRelationShip.postsTagRelationShip;
import static com.moveon.server.repository.School.QSchool.school;
import static com.moveon.server.repository.Tag.QTag.tag;

@RequiredArgsConstructor
@Repository
public class QueryRepository {
    private final JPAQueryFactory queryFactory;

    public School findByContent(String content){
        return queryFactory.selectFrom(school).where(school.content.eq(content)).fetchOne();
    }

    public List<Tag> findTagByDepartmentId(Long departmentId){
        //List<Tag> tags=queryFactory.selectFrom(tag).where(tag.id.eq(queryFactory.selectFrom(postsTagRelationShip).where(postsTagRelationShip.departmentId.eq(departmentId)))).fetch();
        return queryFactory.selectFrom(tag).where(tag.id.in(
                JPAExpressions.select(postsTagRelationShip.tagId).from(postsTagRelationShip)
                .where(postsTagRelationShip.departmentId.eq(departmentId))
        )).fetch();
    }




}
