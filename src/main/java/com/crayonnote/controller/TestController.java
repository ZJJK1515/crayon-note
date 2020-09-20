package com.crayonnote.controller;

import com.crayonnote.common.entity.CrayonArticle;
import com.crayonnote.common.utils.CrayonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testAxios")
    public CrayonResult testAxios(@RequestBody CrayonArticle article) {
        log.info("{}", article);
        return CrayonResult.ok();
    }

}
