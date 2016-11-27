package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.entity.ArticleEntity;
import com.ifreedom.beauty.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BeautyApplication.class)
@WebIntegrationTest
public class ArticleTest {
    @Autowired
    ArticleService articleService;

    @Test
    public void addTestData() {
        for (int i = 0; i < 10; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setCommentCount(10L + i);
            entity.setContent("测不出bug你请我吃饭");
            entity.setDeployTime(System.currentTimeMillis());
            entity.setIsPopular(1);
            entity.setReadCount(10L);
            entity.setReplyCount(10L + i);
            entity.setUserId(1L);
            entity.setTitle("小伙,测一发");
            articleService.addArticle(entity);

        }
    }
}
