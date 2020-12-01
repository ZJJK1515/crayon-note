package com.crayonnote.modules.system.controller;

import com.crayonnote.common.entity.SysUser;
import com.crayonnote.common.utils.CrayonPageVO;
import com.crayonnote.common.utils.CrayonResult;
import com.crayonnote.modules.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/adduser")
    public CrayonResult addUser(@RequestBody SysUser sysUser) {
        log.info("转化后: {}", sysUser);
        return sysUserService.save(sysUser) ? CrayonResult.ok() : CrayonResult.error("");
    }

    @PostMapping("/findUser")
    public CrayonResult findUser(@RequestBody CrayonPageVO<SysUser> pageVO) {
        log.info("{}", pageVO);
        return CrayonResult.ok(sysUserService.findUser(pageVO));
    }



}
