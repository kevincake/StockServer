package com.ifreedom.beauty.repository;

import com.ifreedom.beauty.bean.ArticleCommon;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
@Component
public class ArticleRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    UserService userService;

    public List<ArticleCommon> getPopularArticles(int pageIndex) {
        String sql = "select * from article where isPopular = :isPopular limit :pageIndex,:pageSize";
        Query nativeQuery = entityManager.createNativeQuery(sql, ArticleEntity.class);
        nativeQuery.setParameter("isPopular", 1);
        nativeQuery.setParameter(DataBaseConstants.PAGESIZE_KEY, DataBaseConstants.PAGE_SIZE);
        nativeQuery.setParameter(DataBaseConstants.PAGEINDEX_KEY, (pageIndex-1)*DataBaseConstants.PAGE_SIZE);
        List<ArticleEntity> articleEntities = nativeQuery.getResultList();
        List<ArticleCommon> commentEntities = new ArrayList<>();
        for (ArticleEntity article :
                articleEntities) {
            ArticleCommon articleCommon = new ArticleCommon();
            articleCommon.setArticle(article);
            articleCommon.setUser(userService.getUser(article.getUserId()));
            commentEntities.add(articleCommon);
        }
        return commentEntities;
    }


    @Transactional
    public ArticleEntity addArticle(ArticleEntity entity) {
        return entityManager.merge(entity);
    }
}
