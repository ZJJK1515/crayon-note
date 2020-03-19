package com.crayonnote.modules.system.controller;

import com.crayonnote.modules.common.entity.SysMenu;
import com.crayonnote.modules.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/list")
    public List<SysMenu> list() {
        return sysMenuService.listSysMenu();
    }


}
