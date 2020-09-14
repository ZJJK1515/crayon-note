package com.crayonnote.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayonnote.common.entity.SysUser;
import com.crayonnote.modules.system.service.SysUserService;
import com.crayonnote.modules.system.dao.SysUserDao;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {


    @Override
    public void addUser(SysUser sysUser) {

    }


}
