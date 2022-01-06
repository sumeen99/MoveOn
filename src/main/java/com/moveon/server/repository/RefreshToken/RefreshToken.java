package com.moveon.server.repository.RefreshToken;

import com.moveon.server.repository.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseTimeEntity {

    @Id
    private String userId;

    private String token;

    public void update(String token) {
        this.token = token;
    }

}
