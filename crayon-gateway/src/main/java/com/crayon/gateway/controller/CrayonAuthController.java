package com.crayon.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crayon.common.rest.Result;
import com.crayon.gateway.auth.RSAEncrypt;
import com.crayon.pojo.po.auth.PublicKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("/api")
public class CrayonAuthController {

    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public Result<PublicKey> publicKey() {
        try {
            log.info("获取 publicKey....");
            return Result.ok(new PublicKey(RSAEncrypt.genKeyPair()));
        } catch (NoSuchAlgorithmException e) {
            return Result.error("");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        log.info("调用登陆开始...");
        return JSON.parseObject("{code: 200, msg: 'success', data: { accessToken: 'admin-accessToken' },}").toJSONString();
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public Result<JSONObject> userInfo(@RequestBody String accessTokenBody) {
        log.info("获取用户信息...{}", accessTokenBody);
        Object accessToken = JSON.parseObject(accessTokenBody).get("accessToken");
        return Result.ok(JSON.parseObject("{\n" +
                "          permissions: ['admin'],\n" +
                "          username: 'admin',\n" +
                "          'avatar|1': [\n" +
                "            'https://i.gtimg.cn/club/item/face/img/2/15922_100.gif',\n" +
                "            'https://i.gtimg.cn/club/item/face/img/8/15918_100.gif',\n" +
                "          ],\n" +
                "        }"));
    }
}
