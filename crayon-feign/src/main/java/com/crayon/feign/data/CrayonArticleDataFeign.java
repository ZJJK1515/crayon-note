package com.crayon.feign.data;

import com.crayon.pojo.po.CrayonArticle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "CRAYON-DATA-SERVICE")
public interface CrayonArticleDataFeign {

    @RequestMapping(value = "/crayonArticleData/saveArticle", method = RequestMethod.POST)
    Boolean saveArticle(@RequestBody CrayonArticle crayonArticle);

    @RequestMapping(value = "/crayonArticleData/findById", method = RequestMethod.GET)
    CrayonArticle findByArticleId(Long articleId);

    @RequestMapping(value = "/crayonArticleData/deleteById", method = RequestMethod.DELETE)
    Boolean deleteById(Long articleId);

    @RequestMapping(value = "/crayonArticleData/updateById", method = RequestMethod.PUT)
    Boolean updateById(CrayonArticle crayonArticle) ;

    @RequestMapping(value = "/crayonArticleData/findArticleList", method = RequestMethod.POST)
    List<CrayonArticle> findArticleList();

}
