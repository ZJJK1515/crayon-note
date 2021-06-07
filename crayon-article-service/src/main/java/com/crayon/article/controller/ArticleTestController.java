package com.crayon.article.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleTestController {

    @RequestMapping("/test")
    public String test() {
        return "article service ok!";
    }
}
