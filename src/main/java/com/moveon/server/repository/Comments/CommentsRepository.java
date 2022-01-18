package com.moveon.server.repository.Comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    Optional<Comments> findCommentsById(Long id);
}
