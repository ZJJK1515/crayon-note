package com.crayon.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("crayon_article")
public class CrayonArticle {

    @TableId(type = IdType.NONE)
    private String articleId;
    private String articleTitle;
    private String articleContent;
    private String createUserId;
    private String createUsername;
    private String updateUserId;
    private String updateUsername;
    private String createTime;
    private String modifyTime;

}
