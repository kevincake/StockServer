package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.manager.TokenManager;
import com.ifreedom.beauty.authorization.model.TokenModel;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.UserService;
import com.ifreedom.beauty.sms.SMSManager;
import com.ifreedom.beauty.sms.SMSSender;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by eavawu on 4/26/16.
 */

@RestController
@RequestMapping(HttpConstants.SIGN_CONTROL_PATH)
public class SignController {
    @Autowired
    UserService userService;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    SMSSender smsSender;


    @ResponseBody
    @RequestMapping(value = HttpConstants.SIGN_UP, method = RequestMethod.POST)
    public HttpResult signUp(@RequestBody  Map<String, String> params) {
        HttpResult result = new HttpResult();
        String userName = params.get(HttpConstants.NAME);
        String phone = params.get(HttpConstants.PHONE);
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);
        userEntity.setPhone(phone);
        userEntity.setSex(Integer.parseInt(params.get(HttpConstants.SEX)));
        userEntity.setAvatar(params.get(HttpConstants.AVATAR));
        userEntity.setSignature(PropertyUtil.getProperty("signtureDefault"));
        userEntity.setPassword(params.get(HttpConstants.PASSWORD));
        UserEntity saveUser = userService.saveUser(userEntity);
        if (userName == null || StringUtils.isEmpty(userName)) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("userNameNotNull"));
        } else if (StringUtils.isEmpty(userEntity.getPhone())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("phoneNotNull"));
        } else if (StringUtils.isEmpty(userEntity.getAvatar())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("avatarNotNull"));
        } else if (!com.ifreedom.beauty.util.StringUtils.isPwdValid(userEntity.getPassword())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("passwordFormatError"));
        } else {
            TokenModel model = tokenManager.createToken(saveUser.getId());
            result.setResultCode(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER, saveUser);
            result.getData().put(HttpConstants.TOKEN, model.getToken());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = HttpConstants.SIGN_IN, method = RequestMethod.GET)
    public HttpResult signIn(@RequestParam(name = HttpConstants.PHONE) String phone, @RequestParam(HttpConstants.PASSWORD) String password) {
        UserEntity userEntity = userService.findByPhoneAndPassword(phone, password);
        HttpResult result = new HttpResult();
        if (userEntity == null) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("accountOrPasswordError"));
        } else {
            TokenModel model = tokenManager.createToken(userEntity.getId());
            result.getData().put(HttpConstants.TOKEN, model.getToken());
            result.setResultCode(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER, userEntity);

        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = HttpConstants.AUTO_SIGN_IN, method = RequestMethod.GET)
    public HttpResult atuoSignIn(@RequestParam("token") String token) {
        TokenModel tokenModel = tokenManager.getToken(token);
        String userId = tokenModel.getUserId();
        HttpResult result = new HttpResult();
        UserEntity userEntity = null;
        if (com.ifreedom.beauty.util.StringUtils.isEmpty(userId)) {
            userEntity = userService.getUser(Long.parseLong(userId));
        }
        if (userEntity == null) {
            result.setResultCode(HttpConstants.AUTO_SIGN_FAILED_CODE);
            result.setMsg(PropertyUtil.getProperty("autoSignFailed"));
        } else {
            result.getData().put(HttpConstants.TOKEN, tokenModel.getToken());
            result.setResultCode(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER, userEntity);

        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/isPhoneRegister", method = RequestMethod.GET)
    public HttpResult getIsPhoneRegister(@RequestParam("phone") String phone) {
        HttpResult result = new HttpResult();
        boolean isRegister = userService.isPhoneRegister(phone);
        if (isRegister) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("phoneHasRegister"));
        } else {
            result.setResultCode(HttpConstants.SUCCESS);

        }
        ;
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.GET)
    public HttpResult getVerifyCode(@RequestParam("phone") String phone) {
        HttpResult result = new HttpResult();
        boolean isRegister = userService.isPhoneRegister(phone);
        if (isRegister) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("phoneHasRegister"));
        } else {
            smsSender.sendVerifyCode(phone);
            result.setResultCode(HttpConstants.SUCCESS);

        }
        return result;
    }

}
