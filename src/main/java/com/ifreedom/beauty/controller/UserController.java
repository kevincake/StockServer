package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.authorization.model.TokenModel;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.UserService;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @atuhor:eavawu
 * @date:5/17/16
 * @todo:
 */
@RestController
@RequestMapping(HttpConstants.USER_CONTROL_PATH)
public class UserController {
    @Autowired
    UserService userService;

    @Authorization
    @ResponseBody
    @RequestMapping(value = HttpConstants.UPDATE_USER, method = RequestMethod.GET)
    public HttpResult updateUser(@CurrentUser UserEntity userEntity,@RequestParam Map<String, String> params) {
        HttpResult result = new HttpResult();
        String userName = params.get(HttpConstants.NAME);
//        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);
        userEntity.setAvatar(params.get(HttpConstants.AVATAR));
        userEntity.setSignature(PropertyUtil.getProperty("signtureDefault"));
        userEntity.setPassword(params.get(HttpConstants.PASSWORD));

        if (userName == null || StringUtils.isEmpty(userName)) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("userNameNotNull"));
        } else if (StringUtils.isEmpty(userEntity.getAvatar())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("avatarNotNull"));
        } else if (!com.ifreedom.beauty.util.StringUtils.isPwdValid(userEntity.getPassword())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("passwordFormatError"));
        } else {
            UserEntity saveUser = userService.saveUser(userEntity);
            result.setResultCode(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER, saveUser);
        }
        return result;
    }
}
