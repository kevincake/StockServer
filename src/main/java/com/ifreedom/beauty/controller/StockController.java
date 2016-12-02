package com.ifreedom.beauty.controller;import com.ifreedom.beauty.authorization.annotation.Authorization;import com.ifreedom.beauty.authorization.annotation.CurrentUser;import com.ifreedom.beauty.bean.HttpResult;import com.ifreedom.beauty.constants.HttpConstants;import com.ifreedom.beauty.entity.StockEntity;import com.ifreedom.beauty.entity.UserEntity;import com.ifreedom.beauty.service.StockService;import com.ifreedom.beauty.stock.IStock;import com.ifreedom.beauty.stock.tecent.TecentStock;import com.ifreedom.beauty.stock.yahoo.YahooStock;import com.ifreedom.beauty.util.PropertyUtil;import com.ifreedom.beauty.util.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.core.io.support.PropertiesLoaderUtils;import org.springframework.web.bind.annotation.*;import java.util.*;/** * @atuhor:eavawu * @date:26/11/2016 * @todo: */@RestController@RequestMapping("stock")public class StockController {    @Autowired    StockService stockService;    @Authorization    @ResponseBody    @RequestMapping(value = "/addStock", method = RequestMethod.POST)    public HttpResult addStock(@RequestParam("stockCode") String stockCode, @RequestParam("stockChannel") String stockChannel, @CurrentUser UserEntity userEntity) {        HttpResult result = new HttpResult();        StockEntity queryStockEntity = stockService.queryByStockCode(stockCode);        if (queryStockEntity != null) {            result.setResultCode(HttpConstants.FAILED);            result.setMsg(PropertyUtil.getProperty("stockExist"));            return result;        }        if (StringUtils.isEmpty(stockCode) || StringUtils.isEmpty(stockChannel)) {            result.setResultCode(HttpConstants.FAILED);            result.setMsg(PropertyUtil.getProperty("stockParamInvalid"));            return result;        }        StockEntity stockEntity = new StockEntity();        stockEntity.setStockChannel(stockChannel);        stockEntity.setStockCode(stockCode);        stockEntity.setUserId(userEntity.getId());        stockEntity = stockService.addStock(stockEntity);        if (stockEntity != null) {            result.setResultCode(HttpConstants.SUCCESS);        } else {            result.setResultCode(HttpConstants.FAILED);        }        result.getData().put("stock", stockEntity);        return result;    }    @Authorization    @ResponseBody    @RequestMapping(value = "/queryStockInfo", method = RequestMethod.POST)    public HttpResult queryStockInfo(@RequestBody List<StockEntity> stockList) {        HttpResult result = new HttpResult();        IStock iStock = new TecentStock();        result.getData().put("stocks", iStock.queryStockInfo(stockList));        result.setResultCode(HttpConstants.SUCCESS);        return result;    }    @ResponseBody    @RequestMapping(value = "/querySingleStockInfo", method = RequestMethod.POST)    public HttpResult queryMyStockInfo(@RequestBody StockEntity stockEntity) {        HttpResult result = new HttpResult();        result.getData().put("stocks", stockService.queryByStockCode(stockEntity.getStockCode()));        result.setResultCode(HttpConstants.SUCCESS);        return result;    }    @Authorization    @ResponseBody    @RequestMapping(value = "/queryMyAllStocks", method = RequestMethod.POST)    public HttpResult queryMyAllStocks(@CurrentUser UserEntity currentUser) {        HttpResult result = new HttpResult();        result.getData().put("stocks", stockService.queryMyAllStocks(currentUser.getId()));        result.setResultCode(HttpConstants.SUCCESS);        return result;    }    @Authorization    @ResponseBody    @RequestMapping(value = "/deleteStock", method = RequestMethod.POST)    public HttpResult deleteStock(@CurrentUser UserEntity userEntity,@RequestParam("stockId") Long stockId) {        HttpResult result = new HttpResult();        StockEntity stockEntity = stockService.deleteStock(stockId);        if (stockEntity == null) {            result.setMsg("noThisRecorder");            result.setResultCode(HttpConstants.FAILED);            return result;        }        result.getData().put("stock", stockEntity);        result.setResultCode(HttpConstants.SUCCESS);        return result;    }}