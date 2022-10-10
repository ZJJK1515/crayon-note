package com.crayon.common.core;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Getter
@Setter
@Slf4j
public class UserInfo {

    private final static ThreadLocal<UserInfo> THREAD_LOCAL_USER_INFO = new ThreadLocal<>();

    private Long userId;
    private String username;
    private String email;
    private String avatar;
    private Set<String> permissions;
    private String token;


    public static void setUser(UserInfo user) {
        log.info("thread: {} setting user..{}", Thread.currentThread().getName(), user);
        THREAD_LOCAL_USER_INFO.set(user);
    }

    public UserInfo current() {
        return THREAD_LOCAL_USER_INFO.get();
    }

    public static void remove() {
        log.info("thread: {} removing user..", Thread.currentThread().getName());
        THREAD_LOCAL_USER_INFO.remove();
    }

}
