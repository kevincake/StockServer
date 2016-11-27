package com.ifreedom.beauty.stock.sina;

import com.ifreedom.beauty.bean.MyStockQueryInfo;
import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.stock.IStock;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class SinaStock implements IStock {
    @Override
    public List<MyStockQueryInfo> queryStockInfo(List<StockEntity> stockList) {
        return null;
    }

    @Override
    public List<String> getSymbolList(List<StockEntity> stockList) {
        return null;
    }

    @Override
    public List<MyStockQueryInfo> searchStock(String searchkey) {
        return null;
    }
}
