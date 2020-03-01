package com.crayon.crayonnote.system.controller;

import com.crayon.crayonnote.entity.SysUser;
import com.crayon.crayonnote.system.service.SysUserService;
import com.crayon.crayonnote.utils.CrayonResult;
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
