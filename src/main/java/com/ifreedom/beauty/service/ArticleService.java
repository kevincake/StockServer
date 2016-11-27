package com.ifreedom.beauty.service;

import com.ifreedom.beauty.bean.ArticleCommon;
import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.iservice.IArticleService;
import com.ifreedom.beauty.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
@Service
public class ArticleService implements IArticleService{
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public List<ArticleCommon> getPopularArticles(int pageIndex) {
        return articleRepository.getPopularArticles(pageIndex);
    }

    @Override
    public ArticleEntity addArticle(ArticleEntity entity) {
        return articleRepository.addArticle(entity);
    }


}
