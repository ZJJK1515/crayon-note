package com.crayon.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.crayon.common.rest.Result;
import com.crayon.gateway.auth.RSAEncrypt;
import com.crayon.pojo.po.auth.PublicKey;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api")
public class CrayonAuthController {

    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public Result<PublicKey> publicKey() {
        try {
            return Result.ok(new PublicKey(RSAEncrypt.genKeyPair()));
        } catch (NoSuchAlgorithmException e) {
            return Result.error("");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return JSON.parseObject("{code: 200, msg: 'success', data: { accessToken: 'admin-accessToken' },}").toJSONString();
    }

}
