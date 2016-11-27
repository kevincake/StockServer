package com.ifreedom.beauty.bean;

import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.entity.UserEntity;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
public class ArticleCommon{
    private ArticleEntity article;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }
}
