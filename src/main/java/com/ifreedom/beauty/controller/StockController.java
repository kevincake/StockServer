package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.service.StockService;
import com.ifreedom.beauty.stock.IStock;
import com.ifreedom.beauty.stock.tecent.TecentStock;
import com.ifreedom.beauty.stock.yahoo.YahooStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
@RestController
@RequestMapping("stock")
public class StockController {
    @Autowired
    StockService stockService;

    @ResponseBody
    @RequestMapping(value = "/addStock", method = RequestMethod.POST)
    public HttpResult addStock(@RequestParam String stockCode, String channel) {
        HttpResult result = new HttpResult();
        StockEntity stockEntity = new StockEntity();
        stockEntity.setCountry(channel);
        stockEntity.setStockCode(stockCode);
        stockEntity = stockService.addStock(stockEntity);
        if (stockEntity != null) {
            result.setResultCode(HttpConstants.SUCCESS);
        } else {
            result.setResultCode(HttpConstants.FAILED);
        }
        result.getData().put("stock", stockEntity);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/queryStockInfo", method = RequestMethod.POST)
    public HttpResult queryStockInfo(@RequestBody List<StockEntity> stockList) {
        HttpResult result = new HttpResult();
        IStock iStock = new YahooStock();
        result.getData().put("stocks", iStock.queryStockInfo(stockList));
        result.setResultCode(HttpConstants.SUCCESS);
        return result;
    }

}
