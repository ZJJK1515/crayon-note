package com.crayonnote.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crayonnote.common.entity.SysUser;
import com.crayonnote.common.utils.CrayonPageVO;

public interface SysUserService extends IService<SysUser> {
    void addUser(SysUser sysUser);

    IPage<SysUser> findUser(CrayonPageVO<SysUser> page);
}
