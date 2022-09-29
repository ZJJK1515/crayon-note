//package com.crayon.admin.controller;
//
//import com.crayon.feign.data.CrayonArticleDataFeign;
//import com.crayon.pojo.po.CrayonArticle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/crayonArticle")
//public class CrayonArticleController {
//
//    @Autowired
//    private CrayonArticleDataFeign crayonArticleDataFeign;
//
//    @RequestMapping("/saveArticle")
//    public Boolean saveArticle(String content) {
//        CrayonArticle crayonArticle = new CrayonArticle();
//        crayonArticle.setArticleTitle("testTitle");
//        crayonArticle.setArticleContent("内容。");
//        crayonArticleDataFeign.saveArticle(crayonArticle);
//        return true;
//    }
//
//
//}
