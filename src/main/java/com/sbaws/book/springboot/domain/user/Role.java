package com.sbaws.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    //스프링 시큐리티에서 권한코드에 항상 ROLE_을 앞에 붙여주어야 한다.
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String Key;
    private final String title;
}
