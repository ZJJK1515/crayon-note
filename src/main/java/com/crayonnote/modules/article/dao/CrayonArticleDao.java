package com.crayonnote.modules.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crayonnote.common.entity.CrayonArticle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrayonArticleDao extends BaseMapper<CrayonArticle> {

}
