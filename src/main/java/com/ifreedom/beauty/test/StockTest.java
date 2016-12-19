package com.ifreedom.beauty.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifreedom.beauty.bean.MyStockQueryInfo;
import com.ifreedom.beauty.entity.StockEntity;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.stock.tecent.TecentStock;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
public class StockTest {
    private RestTemplate template = new TestRestTemplate();

    @Test
    public void testSignIn() {
//        String url = "http://localhost:8080/stock/queryStockInfo";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
//        List<String> stockList = new ArrayList<>();
//        stockList.addOrUpdate("INTC");
//        stockList.addOrUpdate("AIR.PA");
//
////        String result = template.postForObject(url, request, String.class);
//        System.out.println(result);
    }

    @Test
    public void testStock() {
//        Stock api = null;
//        try {
//            api = YahooFinance.get("INTC");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        BigDecimal price = api.getQuote().getPrice();


//        Calendar from = Calendar.getInstance();
//        Calendar to = Calendar.getInstance();
//        from.addOrUpdate(Calendar.YEAR, -1); // from 1 year ago
//
//        Stock google = null;
//        try {
//            google = YahooFinance.get("GOOG");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BigDecimal change = api.getQuote().getChangeInPercent();
//        BigDecimal peg = api.getStats().getPeg();
//        BigDecimal dividend = api.getDividend().getAnnualYieldPercent();
//        List<HistoricalQuote> historicalQuotes = null;
//        try {
//         //   historicalQuotes = api.getHistory();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        api.print();
//        System.out.println(price);
    }


    @Test
    public void testTecentQuery() {
        TecentStock tecentStock = new TecentStock();
        List<StockEntity> stockEntityList = new ArrayList<>();
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStockCode("000001");
        stockEntity.setStockChannel("sz");
        stockEntityList.add(stockEntity);
        List<MyStockQueryInfo> stockQueryInfos = tecentStock.queryStockInfo(stockEntityList);
        System.out.println(stockQueryInfos.toString());
    }

    @Test
    public void testTecentSearch() {
        TecentStock tecentStock = new TecentStock();
        List<MyStockQueryInfo> stockQueryInfos = tecentStock.searchStock("a");
        System.out.println(stockQueryInfos.toString());
    }


}
