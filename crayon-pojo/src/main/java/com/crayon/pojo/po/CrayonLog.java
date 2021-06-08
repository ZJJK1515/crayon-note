package com.crayon.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("crayon_log")
public class CrayonLog {

    @TableId(type = IdType.ASSIGN_ID)
    private Long logId;
    private String logContent;

}
