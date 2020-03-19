package com.crayonnote.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crayonnote.modules.common.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    void addUser(SysUser sysUser);
}
