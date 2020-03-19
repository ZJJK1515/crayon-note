package com.crayonnote.modules.common.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysMenu {

  @TableId(type = IdType.ID_WORKER_STR)
  private String menuId;
  private String menuName;
  private String uri;
  private String icon;
  private long parentId;
  private Date createTime;
  private Date updateTime;

  //子菜单集合, 表中无此字段
  @TableField(exist = false)
  private List<SysMenu> childMenuList;

}
