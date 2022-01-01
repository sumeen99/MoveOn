package com.moveon.server.Util;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {

    private SecurityUtil(){

    }

    public static Optional<String> getCurrentEmail(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null){
            throw  new RuntimeException("Security Context 에 인증 정보가 없습니다.");
        }
        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
        String username = springSecurityUser.getUsername();
        return Optional.ofNullable(username); //이부분에서 userDetails의 getUsername()메소드와 authentication의 getName()이 뭐가 다른걸까?



    }
}
