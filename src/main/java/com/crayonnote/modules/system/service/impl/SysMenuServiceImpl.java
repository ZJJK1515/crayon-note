package com.crayonnote.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayonnote.modules.common.entity.SysMenu;
import com.crayonnote.modules.system.dao.SysMenuDao;
import com.crayonnote.modules.system.service.SysMenuService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {


    @Override
    public List<SysMenu> listSysMenu() {
        // 查询父菜单
        List<SysMenu> sysMenuList = this.list(new QueryWrapper<SysMenu>().eq("parent_id", "0"));
        for (SysMenu menu : sysMenuList) {
            //查询子菜单
            menu.setChildMenuList(this.list(new QueryWrapper<SysMenu>().eq("parent_id", menu.getMenuId())));
        }
        log.info(sysMenuList.toString());
        return sysMenuList;
    }
}
