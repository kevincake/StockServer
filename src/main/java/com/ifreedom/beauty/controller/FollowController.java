package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @atuhor:eavawu
 * @date:5/8/16
 * @todo:
 */
@RestController
@RequestMapping(HttpConstants.FOLLOW_CONTROL_PATH)
public class FollowController {
    @Autowired
    FollowService followService;

    @Authorization
    @ResponseBody
    @RequestMapping(value = HttpConstants.USERID_PATH, method = RequestMethod.POST)
    public HttpResult followStatus(@PathVariable(HttpConstants.USERID) long beFollowId, @RequestParam(HttpConstants.FOLLOW_STATUS_KEY) int status, @CurrentUser UserEntity user) {
        HttpResult httpResult = new HttpResult();
        boolean followResult = false;
        if (status == DataBaseConstants.FOLLOWED) {
            followResult = followService.addFollow(user.getId(), beFollowId);
        } else {
            httpResult.getData().put(HttpConstants.USERID,beFollowId);
            followResult = followService.deleteFollow(user.getId(), beFollowId);
        }
        httpResult.setResultCode(followResult ? HttpConstants.SUCCESS : HttpConstants.FAILED);
        return httpResult;
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = HttpConstants.USERID_PATH, method = RequestMethod.GET)
    public HttpResult getFollowList(@CurrentUser UserEntity userEntity){
        HttpResult result = new HttpResult();
        result.setResultCode(HttpConstants.SUCCESS);
        result.getData().put(HttpConstants.FOLLOW_LIST,followService.getFollowers(userEntity.getId()));
        result.getData().put(HttpConstants.BEFOLLOW_LIST,followService.getBeFollowers(userEntity.getId()));
        return result;
    }


}
