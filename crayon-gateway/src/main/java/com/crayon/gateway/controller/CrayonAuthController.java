package com.crayon.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crayon.common.core.Result;
import com.crayon.gateway.auth.RSAEncrypt;
import com.crayon.gateway.auth.PublicKey;
import com.crayon.user.clientobject.CrayonTokenCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.feign.CrayonUserClientFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api")
public class CrayonAuthController {

    @Autowired
    private CrayonUserClientFeign crayonUserClientFeign;

    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public Result<PublicKey> publicKey() {
        return Result.ok(new PublicKey(RSAEncrypt.PUBLIC_KEY));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<CrayonTokenCO> login(@RequestBody String json) {
        try {
            String param = JSON.parseObject(json).getString("param");
            String decryptJson = RSAEncrypt.decrypt(param, RSAEncrypt.PRIVATE_KEY);

            log.info("调用登陆开始...{}", decryptJson);
            CrayonUserLoginCommand crayonUserLoginCommand = JSON.parseObject(decryptJson, CrayonUserLoginCommand.class);

            return crayonUserClientFeign.login(crayonUserLoginCommand);
        } catch (Exception e) {
            log.error("系统异常", e);
            return Result.error("系统异常");
        }
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
