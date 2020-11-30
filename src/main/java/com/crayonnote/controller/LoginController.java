package com.crayonnote.controller;

import com.crayonnote.common.entity.SysUser;
import com.crayonnote.common.utils.CrayonResult;
import com.crayonnote.common.vo.SysUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 登录控制器
 */
@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() ? "admin" : "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public CrayonResult login(@RequestBody SysUserVO sysUserVO) {

//        SysUser sysUser = sysUserVO.toEntity();
//        log.info("转化后: {}", sysUser);

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                sysUserVO.getUsername(),
                sysUserVO.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            log.error("用户：{} 登陆失败...", sysUserVO.getUsername());
            return CrayonResult.error("用户名或密码错误...");
        }
        return CrayonResult.ok();
    }

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

}
