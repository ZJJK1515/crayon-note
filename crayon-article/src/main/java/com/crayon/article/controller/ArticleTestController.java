package com.crayon.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleTestController {

    @RequestMapping("/test")
    public String test() {
        return "article service ok!";
    }

    @RequestMapping("/testLog")
    public String testLog() {
        for (int i = 0; i < 100; i++) {
            log.info("test log : {}", i);
        }
        return "data service ok!";
    }
}
