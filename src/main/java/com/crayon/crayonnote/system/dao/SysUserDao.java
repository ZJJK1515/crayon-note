package com.crayon.crayonnote.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crayon.crayonnote.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
}
