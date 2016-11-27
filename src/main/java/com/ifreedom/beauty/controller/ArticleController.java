package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @atuhor:eavawu
 * @date:5/19/16
 * @todo:
 */
@RestController
@RequestMapping(HttpConstants.ARTICLE_CONTROL_PATH)
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/getPopularArticle",method = RequestMethod.GET)
    public HttpResult getPopularArticle(@RequestParam(DataBaseConstants.PAGEINDEX_KEY)int pageIndex){
        HttpResult result = new HttpResult();
        result.setResultCode(HttpConstants.SUCCESS);
        result.getData().put(HttpConstants.ARTICLE_LIST,articleService.getPopularArticles(pageIndex));
        return result;
    }
}

