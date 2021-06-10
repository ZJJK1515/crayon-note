package com.crayon.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayon.data.dao.CrayonArticleMapper;
import com.crayon.data.service.CrayonArticleDataService;
import com.crayon.pojo.po.CrayonArticle;
import org.springframework.stereotype.Service;

@Service
public class CrayonArticleDataServiceImpl extends ServiceImpl<CrayonArticleMapper, CrayonArticle> implements CrayonArticleDataService {


}
