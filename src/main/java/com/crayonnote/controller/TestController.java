package com.crayonnote.controller;

import com.crayonnote.common.utils.CrayonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/testAxios")
    public CrayonResult testAxios() {
        return CrayonResult.ok();
    }

}
