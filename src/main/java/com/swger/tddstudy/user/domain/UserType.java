package com.swger.tddstudy.user.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserType {

    USER("일반회원"), ADMIN("관리자");

    private final String text;
}
