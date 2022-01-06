package com.moveon.server.repository.RefreshToken;

import com.moveon.server.repository.RefreshToken.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByUserId(String userId);
}
