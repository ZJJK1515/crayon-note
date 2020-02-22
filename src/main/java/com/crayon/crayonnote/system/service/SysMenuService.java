package com.crayon.crayonnote.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crayon.crayonnote.entity.SysMenu;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> listSysMenu();
}
