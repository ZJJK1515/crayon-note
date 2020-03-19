package com.crayonnote.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crayonnote.modules.common.entity.SysMenu;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> listSysMenu();
}
