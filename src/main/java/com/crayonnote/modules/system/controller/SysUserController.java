package com.crayonnote.modules.system.controller;

import com.crayonnote.common.entity.SysUser;
import com.crayonnote.common.vo.SysUserVO;
import com.crayonnote.modules.system.service.SysUserService;
import com.crayonnote.common.utils.CrayonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/adduser")
    public CrayonResult addUser(@RequestBody SysUserVO sysUserVO) {
        SysUser sysUser = sysUserVO.toEntity();
        log.info("转化后: {}", sysUser);
        return sysUserService.save(sysUser) ? CrayonResult.ok() : CrayonResult.error("");
    }

    @GetMapping("/finduser")
    public CrayonResult findUser() {
        return CrayonResult.ok(sysUserService.list());
    }



}
