package com.crayonnote.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.crayonnote.common.entity.CrayonArticle;
import com.crayonnote.common.exception.CrayonException;
import com.crayonnote.common.utils.CrayonResult;
import com.crayonnote.modules.article.service.ICrayonArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/article")
public class CrayonArticleController {

    @Autowired
    private ICrayonArticleService articleService;

    /**
     * 获取文章内容，如果 ID 传空则生成一个新的文章 ID
     *
     * @param articleId 文章 ID
     * @return 文章 | 文章 ID
     */
    @GetMapping("/getArticle")
    public CrayonResult getArticle(String articleId) {
        return CrayonResult.ok(articleService.getArticle(articleId));
    }

    /**
     * 保存文章
     *
     * @param crayonArticle 文章
     * @return ok flag
     */
    @PostMapping("/saveArticle")
    public CrayonResult saveArticle(@RequestBody CrayonArticle crayonArticle) {

        log.info("{}", JSON.toJSONString(crayonArticle));
        articleService.saveArticle(crayonArticle);
        return CrayonResult.ok();

    }

}
