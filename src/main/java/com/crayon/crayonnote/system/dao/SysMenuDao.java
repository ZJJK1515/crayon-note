package com.crayon.crayonnote.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crayon.crayonnote.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {
}
