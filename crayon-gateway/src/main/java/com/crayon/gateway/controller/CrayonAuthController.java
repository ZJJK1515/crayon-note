package com.crayon.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crayon.common.core.Result;
import com.crayon.common.core.UserInfo;
import com.crayon.common.redis.RedisUtil;
import com.crayon.gateway.auth.*;
import com.crayon.user.clientobject.CrayonLoginCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.feign.CrayonUserClientFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/api")
public class CrayonAuthController {

    @Resource
    private CrayonUserClientFeign crayonUserClientFeign;

    @Resource
    private RedisUtil redisUtil;


    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public Result<PublicKey> publicKey() {
        return Result.ok(new PublicKey(RSAEncrypt.PUBLIC_KEY));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<CrayonTokenCO> login(@RequestBody String json) {
        try {
            String param = JSON.parseObject(json).getString("param");
            String decryptJson = RSAEncrypt.decrypt(param, RSAEncrypt.PRIVATE_KEY);

            log.info("调用 user-api 登录开始...{}", decryptJson);
            CrayonUserLoginCommand crayonUserLoginCommand = JSON.parseObject(decryptJson, CrayonUserLoginCommand.class);

            Result<CrayonLoginCO> loginResult = crayonUserClientFeign.login(crayonUserLoginCommand);
            if (!loginResult.isOK()) {
                return Result.error(loginResult.getMsg());
            }

            CrayonLoginCO loginCO = loginResult.getData();
            Map<String, String> claimMap = new HashMap<>(2);
            claimMap.put("username", loginCO.getUsername());
            claimMap.put("userId", loginCO.getUserId().toString());

            String accessToken = JWTUtil.buildJWT(claimMap);
            Long remainMills = JWTUtil.getRemainMills(accessToken);

            UserInfo current = new UserInfo();
            BeanUtils.copyProperties(loginCO, current);
            current.setToken(accessToken);

            redisUtil.set(CrayonGatewayKeyConstant.buildUserAccessTokenKey(loginCO.getUserId()), current, remainMills, TimeUnit.MILLISECONDS);

            CrayonTokenCO crayonTokenCO = new CrayonTokenCO();
            crayonTokenCO.setAccessToken(accessToken);

            return Result.ok(crayonTokenCO);

        } catch (Exception e) {
            log.error("系统异常", e);
            return Result.error("系统异常");
        }
    }
    // 将jwt token 存入redis


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Void> logout(@RequestHeader("accessToken") String accessToken) {
        Long userId = JWTUtil.parseJWTClaimAsLong(accessToken, "userId");
        boolean result = redisUtil.del(CrayonGatewayKeyConstant.buildUserAccessTokenKey(userId));
        log.info("删除 userId token: {}", result);
        return Result.ok();
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public Result<UserInfo> userInfo(@RequestBody String accessTokenBody) {
        String accessToken = JSON.parseObject(accessTokenBody).getString("accessToken");
        Long userId = JWTUtil.parseJWTClaimAsLong(accessToken, "userId");
        UserInfo userInfo = redisUtil.get(CrayonGatewayKeyConstant.buildUserAccessTokenKey(userId), UserInfo.class);
        return Result.ok(userInfo);
    }
}
