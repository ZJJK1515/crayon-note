package com.crayonnote.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crayonnote.common.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {
}
