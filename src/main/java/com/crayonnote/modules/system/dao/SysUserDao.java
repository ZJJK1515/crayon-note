package com.crayonnote.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crayonnote.modules.common.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
}
