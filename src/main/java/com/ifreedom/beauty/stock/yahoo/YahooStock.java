package com.ifreedom.beauty.stock.yahoo;

import com.ifreedom.beauty.bean.MyStockQueryInfo;
import com.ifreedom.beauty.constants.StockConstants;
import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.stock.IStock;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class YahooStock implements IStock {
    @Override
    public List<MyStockQueryInfo> queryStockInfo(List<StockEntity> stockList) {
        String[] stockArr = new String[stockList.size()];
        List<String> symbolList = getSymbolList(stockList);
        symbolList.toArray(stockArr);
        List<MyStockQueryInfo> stockQueryInfos = new ArrayList<>();
        try {
            Map<String, Stock> stockMap = YahooFinance.get(stockArr);
            for (Map.Entry<String, Stock> entry : stockMap.entrySet()) {
                MyStockQueryInfo myStockQueryInfo = new MyStockQueryInfo();
                String key = entry.getKey();
                Stock stock = entry.getValue();
                StockQuote quote = stock.getQuote();
                if (quote != null && quote.getPrice() != null) {
                    myStockQueryInfo.setPrecent(quote.getChangeInPercent() + "");
                    myStockQueryInfo.setChange(quote.getChange() + "");
                    myStockQueryInfo.setStockCode(stock.getSymbol());
                    myStockQueryInfo.setStockName(stock.getName());
                    myStockQueryInfo.setPrice(quote.getPrice() + "");
                    stockQueryInfos.add(myStockQueryInfo);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockQueryInfos;
    }

    @Override
    public List<String> getSymbolList(List<StockEntity> stockList) {
        List<String> symbolList = new ArrayList<>();
        for (int i = 0; i < stockList.size(); i++) {
            StockEntity stockEntity = stockList.get(i);
            String symbol = "";
            if (stockEntity.getStockChannel().equals(StockConstants.STOCK_SH) || stockEntity.getStockChannel().equals(StockConstants.STOCK_SZ) || stockEntity.getStockChannel().equals(StockConstants.STOCK_HK)) {
                symbol = stockList.get(i).getStockCode() + "." + stockEntity.getStockChannel();
            } else {
                symbol = stockList.get(i).getStockCode();
            }

            symbolList.add(symbol);
        }
        return symbolList;
    }

    @Override
    public List<MyStockQueryInfo> searchStock(String searchkey) {
        return null;
    }
}
