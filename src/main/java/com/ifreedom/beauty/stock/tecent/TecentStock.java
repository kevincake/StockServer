package com.ifreedom.beauty.stock.tecent;

import com.ifreedom.beauty.bean.MyStockQueryInfo;
import com.ifreedom.beauty.bean.TecentMyStockInfo;
import com.ifreedom.beauty.constants.StockConstants;
import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.http.HttpManager;
import com.ifreedom.beauty.stock.IStock;

import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class TecentStock implements IStock {
    @Override
    public List<MyStockQueryInfo> queryStockInfo(List<StockEntity> stockList) {
        List<MyStockQueryInfo> myStockQueryInfoList = new ArrayList<>();

        List<String> symbolList = getSymbolList(stockList);
        TecentMyStockInfo tecentMyStockInfo = HttpManager.getInstance().queryTecentMyStockInfo(symbolList);
        for (int i = 0; i < tecentMyStockInfo.getData().getList().size(); i++) {
            TecentMyStockInfo.DataBean.ListBean listBean = tecentMyStockInfo.getData().getList().get(i);
            MyStockQueryInfo myStockQueryInfo = new MyStockQueryInfo();
            myStockQueryInfo.setStockCode(listBean.getSymbol());
            myStockQueryInfo.setStockChannel(listBean.getCode().substring(0, listBean.getCode().indexOf(listBean.getSymbol())));
            myStockQueryInfo.setStockName(listBean.getName());
            myStockQueryInfo.setPrecent(listBean.getZdf());
            myStockQueryInfo.setChange(listBean.getZd());
            myStockQueryInfo.setPrice(listBean.getZxj());
            myStockQueryInfoList.add(myStockQueryInfo);
        }
        return myStockQueryInfoList;
    }


    @Override
    public List<String> getSymbolList(List<StockEntity> stockList) {
        List<String> symbolList = new ArrayList<>();
        for (int i = 0; i < stockList.size(); i++) {
            StockEntity stockEntity = stockList.get(i);
            String channel = stockEntity.getStockChannel();
            if (channel.equals(StockConstants.STOCK_SZ) || channel.equals(StockConstants.STOCK_SH)) {
                symbolList.add(channel + stockEntity.getStockCode());
            }
        }
        return symbolList;
    }

    @Override
    public List<MyStockQueryInfo> searchStock(String searchkey) {
        List<MyStockQueryInfo> stockQueryInfos = HttpManager.getInstance().searchTecentMyStockInfo(searchkey);
        return stockQueryInfos;
    }

    @Override
    public List<MyStockQueryInfo> queryAllStock() {
        return null;
    }
}
