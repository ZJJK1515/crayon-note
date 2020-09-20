package com.crayonnote.modules.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayonnote.common.entity.CrayonArticle;
import com.crayonnote.common.exception.CrayonException;
import com.crayonnote.common.utils.CrayonIdWorker;
import com.crayonnote.modules.article.dao.CrayonArticleDao;
import com.crayonnote.modules.article.service.ICrayonArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class CrayonArticleServiceImpl extends ServiceImpl<CrayonArticleDao, CrayonArticle>
        implements ICrayonArticleService {


    /**
     * 获取文章内容，如果 articleId 为空则生成一个文章 ID 返回给前端
     *
     * @param articleId 文章 ID
     * @return 文章
     */
    @Override
    public CrayonArticle getArticle(String articleId) {

        return StringUtils.isEmpty(articleId) ?
                new CrayonArticle(CrayonIdWorker.getIdStr()) : this.getBaseMapper().selectById(articleId);
    }

    /**
     * 保存文章
     *
     * @param crayonArticle 文章对象
     */
    @Override
    @Transactional
    public void saveArticle(CrayonArticle crayonArticle) {
        this.saveOrUpdate(crayonArticle);
    }


}
