package com.ifreedom.beauty.http;

import com.ifreedom.beauty.bean.*;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.entity.AllStockEntity;
import com.ifreedom.beauty.entity.AllStockHistory;
import com.ifreedom.beauty.http.stock.IFengApi;
import com.ifreedom.beauty.http.stock.SJTLApi;
import com.ifreedom.beauty.http.stock.TecentApi;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class HttpManager {

    private static HttpManager httpManager = new HttpManager();
    private Retrofit retrofit;

    private HttpManager() {
        retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.TECENT_QUERY_TYPE);
    }


    public static HttpManager getInstance() {
        return httpManager;
    }

    //根据股票代码.在腾讯服务器查询股票信息
    public TecentMyStockInfo queryTecentMyStockInfo(List<String> symbolList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < symbolList.size(); i++) {
            if (i == symbolList.size() - 1) {
                stringBuilder.append(symbolList.get(i));
                break;
            }
            stringBuilder.append(symbolList.get(i) + "|");
        }
        Call<TecentMyStockInfo> tecentMyStockInfoCall = retrofit.create(TecentApi.class).queryStockInfo("3G", "qq", "0", "0", "310df57a3dfd6c8342c792f58d1b4b3007085ed6"
                , "36E399A614ED6DB197B9CF2337E990B9", "9a86ba61eb8b2b4059c87e9b8862864da1160010211a04", "a78456ade6c74143f61b1b5029dae015ee750140211a04"
                , "5.1.8", "65", "6.0", "82850", stringBuilder.toString());
        try {
            return tecentMyStockInfoCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //从腾讯服务器搜索股票信息
    public List<MyStockQueryInfo> searchTecentMyStockInfo(String searchkey) {
        List<MyStockQueryInfo> myStockQueryInfoList = new ArrayList<>();
        Call<String> searchResult = RetrofitFactory.getRetrofit(RetrofitConstants.TECENT_SEARCH_TYPE).create(TecentApi.class).searchStock(searchkey, "all");
        try {
            String body = searchResult.execute().body();
            String content = body.substring("v_hint=".length(), body.length());
            String[] stockStrArr = content.split("\\^");
            for (int i = 0; i < stockStrArr.length; i++) {
                String oneStockStr = stockStrArr[i];
                String[] oneStockArr = oneStockStr.split("~");
                MyStockQueryInfo myStockQueryInfo = new MyStockQueryInfo();
                myStockQueryInfo.setStockChannel(oneStockArr[0]);
                myStockQueryInfo.setStockCode(oneStockArr[1]);
                myStockQueryInfo.setStockName(oneStockArr[2]);
                myStockQueryInfoList.add(myStockQueryInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myStockQueryInfoList;
    }

    //从数据通联服务器获取所有的股票代码
    public static List<AllStockEntity> getAllStockInfoFromSJTL() {
        List<AllStockEntity> stockList = new ArrayList<>();
        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.SJTL_TYPE);
        Call<SJTLAllStock> result = retrofit.create(SJTLApi.class).getAllStockInfo("A");

        try {
            SJTLAllStock body = result.execute().body();
            if (body.getRetCode() != HttpConstants.SUCCESS) {
                return null;
            }

            List<AllStockEntity> allStockEntities = covertSJTL(body);
            System.out.println(allStockEntities);
            return allStockEntities;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static List<AllStockEntity> covertSJTL(SJTLAllStock sjtlAllStock) {
        List<AllStockEntity> allStockEntityList = new ArrayList<>();
        for (int i = 0; i < sjtlAllStock.getData().size(); i++) {
            AllStockEntity allStockEntity = new AllStockEntity();
            SJTLAllStock.DataBean dataBean = sjtlAllStock.getData().get(i);
            if (dataBean.getExchangeCD().equals("XSHG")) {
                allStockEntity.setStockChannel("sh");
            } else {
                allStockEntity.setStockChannel("sz");
            }
            allStockEntity.setToMaketDate(dataBean.getListDate());
            allStockEntity.setStockName(dataBean.getSecShortName());
            allStockEntity.setStockCode(dataBean.getTicker());
            allStockEntityList.add(allStockEntity);
        }
        return allStockEntityList;
    }


    //从凤凰财经的服务器拉取的单只股票的历史信息
    public static List<AllStockHistory> getOneStockAllHistory(String channel, String code, String type) {
        List<AllStockHistory> allStockHistory = new ArrayList<>();
        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.IFENG_TYPE);
        Call<IFengStock> call = retrofit.create(IFengApi.class).getOneStockHistory(channel+code, type);
        IFengStock iFengStock = null;
        try {
            iFengStock = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (iFengStock == null || iFengStock.getRecord() == null || iFengStock.getRecord().size() <= 0) {
            return null;
        }
        for (int i = 0; i < iFengStock.getRecord().size(); i++) {
            List<String> oneRecord = iFengStock.getRecord().get(i);
            AllStockHistory oneStockHistory = new AllStockHistory();
            oneStockHistory.setStockCode(code);
            oneStockHistory.setStockChannel(channel);
            oneStockHistory.setDate(oneRecord.get(0));
            oneStockHistory.setOpen(Double.parseDouble(oneRecord.get(1)));
            oneStockHistory.setHigh(Double.parseDouble(oneRecord.get(2)));
            oneStockHistory.setClose(Double.parseDouble(oneRecord.get(3)));
            oneStockHistory.setLow(Double.parseDouble(oneRecord.get(4)));
            oneStockHistory.setVolume(Double.parseDouble(oneRecord.get(5)));
            oneStockHistory.setAmount(Double.parseDouble(oneRecord.get(6)));
            allStockHistory.add(oneStockHistory);
        }
        return allStockHistory;
    }

    public static void main(String[] args) {
        List<AllStockHistory> oneStockAllHistory = getOneStockAllHistory("sz", "000875", "last");
        System.out.println(oneStockAllHistory);
    }
}

