//package com.crayon.data.controller;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.crayon.data.service.CrayonArticleDataService;
//import com.crayon.pojo.po.CrayonArticle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/crayonArticleData")
//public class CrayonArticleDataController {
//
//    @Autowired
//    private CrayonArticleDataService crayonArticleDataService;
//
//    @RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
//    public Boolean saveArticle(@RequestBody CrayonArticle crayonArticle) {
//        return true;
//    }
//
//    @RequestMapping(value = "/findById", method = RequestMethod.GET)
//    public CrayonArticle findByArticleId(Long articleId) {
//        return crayonArticleDataService.getById(articleId);
//    }
//
//    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
//    public Boolean deleteById(Long articleId) {
//        return true;
//    }
//
//    @RequestMapping(value = "/updateById", method = RequestMethod.PUT)
//    public Boolean updateById(CrayonArticle crayonArticle) {
//        return true;
//    }
//
//    @RequestMapping(value = "/findArticleList", method = RequestMethod.POST)
//    public Page<CrayonArticle> findArticleList() {
//        Page<CrayonArticle> page = new Page<>();
//        page.setSize(12);
//        page.setTotal(12);
//        Page<CrayonArticle> page1 = crayonArticleDataService.page(page);
//        return page1;
//    }
//
//
//}
