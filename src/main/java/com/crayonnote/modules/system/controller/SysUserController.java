package com.crayonnote.modules.system.controller;

import com.crayonnote.modules.common.entity.SysUser;
import com.crayonnote.modules.system.service.SysUserService;
import com.crayonnote.modules.common.utils.CrayonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/save")
    public CrayonResult save(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser) ? CrayonResult.ok() : CrayonResult.error("");
    }



}
