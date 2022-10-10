package com.crayon.gateway.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    private static final String SECRET = "CRAYON_NOTE_SECRET";
    private static final long _15_DAYS_SECONDS = Duration.ofDays(15).get(ChronoUnit.SECONDS);


    /**
     * 创建 jwt token
     *
     * @param claimMap claimMap
     * @return token
     */
    public static String buildJWT(Map<String, String> claimMap) {
        Date signDate = new Date();
        Date expireAt = new Date(signDate.getTime() + _15_DAYS_SECONDS * 1000);//过期时间
        Algorithm algorithm = Algorithm.HMAC256(SECRET);//进行加密算法
        //token的Header信息
        Map<String, Object> jwtHeader = new HashMap<>();
        jwtHeader.put("alg", "HS256");
        jwtHeader.put("typ", "JWT");
        JWTCreator.Builder builder = JWT.create()
                .withHeader(jwtHeader)
                .withIssuedAt(signDate)
                .withExpiresAt(expireAt);
        for (String key : claimMap.keySet()) {
            builder.withClaim(key, claimMap.get(key));
        }
        return builder.sign(algorithm);
    }

    public static Claim parseJWTClaim(String token, String claimKey) {
        DecodedJWT decodedJWT = getJWTVerifier(token);
        return decodedJWT.getClaim(claimKey);
    }

    public static String parseJWTClaimAsString(String token, String claimKey) {
        return parseJWTClaim(token, claimKey).asString();
    }

    public static Long parseJWTClaimAsLong(String token, String claimKey) {
        return parseJWTClaim(token, claimKey).asLong();
    }

    public static Date getExpireAt(String token) {
        DecodedJWT jwtVerifier = getJWTVerifier(token);
        return jwtVerifier.getExpiresAt();
    }

    public static Date getIssuedAt(String token) {
        DecodedJWT jwtVerifier = getJWTVerifier(token);
        return jwtVerifier.getIssuedAt();
    }

    public static Long getRemainMills(String token) {
        Date expireAt = getExpireAt(token);
        Date issuedAt = getIssuedAt(token);
        return expireAt.getTime() - issuedAt.getTime();
    }

    private static DecodedJWT getJWTVerifier(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);//进行加密算法
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }



}
