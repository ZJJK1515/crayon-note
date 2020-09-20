package com.crayonnote.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CrayonArticle {

    @TableId(type = IdType.INPUT)
    private String articleId;
    private String articleTitle;
    private String articleText;
    private String articleHtml;
    private String articleTags;

    public CrayonArticle() {
    }

    public CrayonArticle(String articleId) {
        this.articleId = articleId;
    }


}
