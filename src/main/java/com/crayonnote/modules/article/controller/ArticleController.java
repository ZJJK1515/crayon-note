package com.crayonnote.modules.article.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {



    @RequestMapping("/")
    public void saveArticle() {

    }

}
