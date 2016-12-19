package com.ifreedom.beauty.controller;

/**
 * @atuhor:eavawu
 * @date:17/12/2016
 * @todo:策略的controller
 */

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.StrategyEntity;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.StrategyService;
import com.ifreedom.beauty.util.PropertyUtil;
import com.ifreedom.beauty.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("strategy")
public class StrategyController {
    @Autowired
    StrategyService strategyService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public HttpResult add(@RequestBody StrategyEntity strategyEntity) {
        HttpResult<StrategyEntity> strategyEntityHttpResult = new HttpResult<>();
        if (strategyEntity == null) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("param_not_null"));
            return strategyEntityHttpResult;
        }
        strategyService.addOrUpdate(strategyEntity);
        strategyEntityHttpResult.setResultCode(HttpConstants.SUCCESS);
        strategyEntityHttpResult.getData().put("strategy", strategyEntity);
        return strategyEntityHttpResult;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public HttpResult delete(@RequestParam("strategyId") String strategyId) {
        HttpResult<StrategyEntity> strategyEntityHttpResult = new HttpResult<>();

        if (StringUtils.isEmpty(strategyId)) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("param_not_null"));
            return strategyEntityHttpResult;
        }
        StrategyEntity strategyEntity = strategyService.get(strategyId);
        if (strategyEntity == null) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("not_this_record"));
            return strategyEntityHttpResult;
        }
        strategyService.delete(strategyEntity);
        strategyEntityHttpResult.setResultCode(HttpConstants.SUCCESS);
        strategyEntityHttpResult.getData().put("strategy", strategyEntity);
        return strategyEntityHttpResult;
    }


    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public HttpResult update(@RequestBody StrategyEntity strategyEntity) {
        HttpResult<StrategyEntity> strategyEntityHttpResult = new HttpResult<>();
        if (strategyEntity == null) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("param_not_null"));
            return strategyEntityHttpResult;
        }
        StrategyEntity strategyEntityFind = strategyService.get(strategyEntity.getId() + "");
        if (strategyEntityFind == null) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("not_this_record"));
            return strategyEntityHttpResult;
        }
        strategyService.addOrUpdate(strategyEntity);
        strategyEntityHttpResult.setResultCode(HttpConstants.SUCCESS);
        strategyEntityHttpResult.getData().put("strategy", strategyEntity);
        return strategyEntityHttpResult;
    }


    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public HttpResult query(String strategyId, @CurrentUser UserEntity userEntity) {
        HttpResult<StrategyEntity> strategyEntityHttpResult = new HttpResult<>();

        if (StringUtils.isEmpty(strategyId)) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("param_not_null"));
            return strategyEntityHttpResult;
        }
        StrategyEntity strategyEntity = strategyService.get(strategyId);
        if (strategyEntity == null) {
            strategyEntityHttpResult.setResultCode(HttpConstants.FAILED);
            strategyEntityHttpResult.setMsg(PropertyUtil.getProperty("param_not_null"));
            return strategyEntityHttpResult;
        }
        strategyEntityHttpResult.setResultCode(HttpConstants.SUCCESS);
        strategyEntityHttpResult.getData().put("strategy", strategyEntity);
        return strategyEntityHttpResult;
    }

}
