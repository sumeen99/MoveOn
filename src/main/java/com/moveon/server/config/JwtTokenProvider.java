package com.moveon.server.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private String secretKey = "webfirewood";

    //
}
