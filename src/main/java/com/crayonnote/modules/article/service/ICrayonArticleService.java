package com.crayonnote.modules.article.service;

import com.crayonnote.common.entity.CrayonArticle;

public interface ICrayonArticleService {


    /**
     * 根据文章 ID 获取内容
     *
     * @param articleId 文章 ID
     * @return 文章
     */
    CrayonArticle getArticle(String articleId);

    void saveArticle(CrayonArticle crayonArticle);
}
