package com.ifreedom.beauty.stock;

import com.ifreedom.beauty.bean.MyStockQueryInfo;
import com.ifreedom.beauty.entity.StockEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:stock基础类
 */
public interface IStock {
    List<MyStockQueryInfo> queryStockInfo(List<StockEntity> stockList);
    List<String> getSymbolList(List<StockEntity> stockList);
    List<MyStockQueryInfo> searchStock(String searchkey);
}
