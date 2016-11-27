package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.bean.ArticleCommon;
import com.ifreedom.beauty.entity.ArticleEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
public interface IArticleService {
     List<ArticleCommon> getPopularArticles(int pageIndex);

    ArticleEntity addArticle(ArticleEntity entity);
}
