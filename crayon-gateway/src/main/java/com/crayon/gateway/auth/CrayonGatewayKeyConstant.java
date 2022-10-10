package com.crayon.gateway.auth;

public class CrayonGatewayKeyConstant {

    public final static String USER_ACCESS_TOKEN = "user:access:token:";


    public static String buildUserAccessTokenKey(Long userId) {
        return USER_ACCESS_TOKEN + userId;
    }
}
