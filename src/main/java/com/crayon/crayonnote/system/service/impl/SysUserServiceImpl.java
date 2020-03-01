package com.crayon.crayonnote.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayon.crayonnote.entity.SysUser;
import com.crayon.crayonnote.system.dao.SysUserDao;
import com.crayon.crayonnote.system.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}
