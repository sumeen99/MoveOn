package com.moveon.server.repository;

import com.moveon.server.dto.CommentsResponseDto;
import com.moveon.server.dto.PostsListResponseDto;
import com.moveon.server.dto.TagPostsResponseDto;
import com.moveon.server.repository.Comments.Comments;
import com.moveon.server.repository.Comments.CommentsRepository;
import com.moveon.server.repository.Posts.Posts;
import com.moveon.server.repository.PostsTagRelationShip.PostsTagRelationShip;
import com.moveon.server.repository.School.School;
import com.moveon.server.repository.Tag.Tag;
import com.moveon.server.repository.User.User;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.moveon.server.repository.Like.QLike.like;
import static com.moveon.server.repository.Posts.QPosts.posts;
import static com.moveon.server.repository.PostsTagRelationShip.QPostsTagRelationShip.postsTagRelationShip;
import static com.moveon.server.repository.School.QSchool.school;
import static com.moveon.server.repository.Tag.QTag.tag;
import static com.moveon.server.repository.User.QUser.user;
import static com.moveon.server.repository.Comments.QComments.comments;

@RequiredArgsConstructor
@Repository
public class QueryRepository {
    private final JPAQueryFactory queryFactory;
    private final CommentsRepository commentsRepository;


    public School findByContent(String content) {
        return queryFactory.selectFrom(school)
                .where(school.content.eq(content))
                .fetchOne();
    }

    /**
     * 건물ID로 추천 TAG 불러오기
     *
     * @param departmentId 건물ID
     * @return Tag모음
     */
    public List<Tag> findTagByDepartmentId(Long departmentId) {
        return queryFactory.selectFrom(tag).where(tag.id.in(
                JPAExpressions.select(postsTagRelationShip.tagId).from(postsTagRelationShip)
                        .where(postsTagRelationShip.departmentId.eq(departmentId))
        )).fetch();
    }

    /**
     * 태그관련게시글 불러오기
     * 건물ID로 TagPostsRelationShip에서 tagId,postId,userId를 추출해 각 테이블에서 데이터 추출
     *
     * @param departmentId 건물ID
     * @param size         data 개수
     * @return 태그관련게시글에 들어가는 데이터들
     */
    public List<TagPostsResponseDto> findTagPostsByDepartmentId(Long departmentId, int size) {
        List<PostsTagRelationShip> postsTagRelationShips = queryFactory.selectFrom(postsTagRelationShip)
                .where(postsTagRelationShip.departmentId.eq(departmentId))
                .limit(size)
                .orderBy(postsTagRelationShip.createdDate.desc())
                .fetch();
        List<TagPostsResponseDto> tagPostsResponseDtos = new ArrayList<>();
        for (PostsTagRelationShip i : postsTagRelationShips) {
            Long tagId = i.getTagId();
            Long postId = i.getPostId();
            Long userId = i.getUserId();
            String tagContent = queryFactory.select(tag.content).from(tag).where(tag.id.eq(tagId)).fetchOne();
            String postContent = queryFactory.select(posts.content).from(posts).where(posts.id.eq(postId)).fetchOne();
            User users = queryFactory.selectFrom(user).where(user.id.eq(userId)).fetchOne();
            String userNickname = users.getNickname();
            String usersProfileUrl = users.getProfileUrl();
            tagPostsResponseDtos.add(TagPostsResponseDto.builder().tagId(tagId).postId(postId).userId(userId).tagContent(tagContent).postsContent(postContent).userNickname(userNickname).profileUrl(usersProfileUrl).tags(findTagByPostId(postId)).build());
        }
        return tagPostsResponseDtos;
    }

    public List<PostsListResponseDto> findPostsByDepartmentId(Long departmentId, int size) {
        List<Posts> post = queryFactory.selectFrom(posts).where(posts.departmentId.eq(departmentId)).limit(size).orderBy(posts.createdDate.desc()).fetch();
        List<PostsListResponseDto> postsListResponseDtos = new ArrayList<>();
        for (Posts i : post) {
            Long userId = i.getUserId();
            Long postId = i.getId();
            User users = queryFactory.selectFrom(user).where(user.id.eq(userId)).fetchOne();
            postsListResponseDtos.add(
                    PostsListResponseDto.builder()
                            .userId(userId)
                            .profileUrl(users.getProfileUrl())
                            .nickname(users.getNickname())
                            .postId(postId)
                            .imgUrl(i.getImgUrl())
                            .content(i.getContent())
                            .like(whetherLike(postId, userId))
                            .tags(findTagByPostId(postId))
                            .createdDate(i.getCreatedDate())
                            .build());
        }
        return postsListResponseDtos;
    }



    /**
     * user가 해당 Posts를 좋아요했는지 안했는지 여부
     * @param postId 해당 postId
     * @param userId 보고있는 userId
     * @return true,false 여부
     */
    public Boolean whetherLike(Long postId, Long userId) {
        return queryFactory.selectFrom(like).where(like.postId.eq(postId), like.userId.eq(userId)).fetchOne() != null;
    }

    public List<Tag> findTagByPostId(Long postId) {
        return queryFactory.selectFrom(tag).where(tag.id.in(
                JPAExpressions.select(postsTagRelationShip.tagId).from(postsTagRelationShip)
                        .where(postsTagRelationShip.postId.eq(postId))
        )).fetch();
    }

    public List<CommentsResponseDto> findAllCommentsByPostId(Long postId){
        queryFactory.selectFrom(comments).where(comments.postId.eq(postId), comments.classNum.eq(0)).fetch().stream().

    }

    public List<CommentsResponseDto> findAllSubCommentsByGroupId(int groupId, Long postId){
        return queryFactory.selectFrom(comments).where(comments.postId.eq(postId), comments.groupId.eq(groupId)).fetch()
                .stream().forEach(x-> x.toCommentsResponseDto(commentsRepository.findCommentsById(comments.id)));
    }



}
