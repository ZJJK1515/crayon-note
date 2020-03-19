package com.crayonnote.controller;

import com.crayonnote.modules.common.entity.SysUser;
import com.crayonnote.modules.common.vo.SysUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return subject.isAuthenticated() ? "home" : "login";
    }

    @PostMapping("/login")
    public String login(SysUserVO sysUserVO) {

        SysUser sysUser = sysUserVO.toEntity();
        log.info("转化后: {}", sysUser);

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                sysUser.getUsername(),
                sysUser.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "";
        }
        return "redirect:home";
    }

}
