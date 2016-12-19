package com.ifreedom.beauty.http.impl;

import com.ifreedom.beauty.bean.IFengStock;
import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import com.ifreedom.beauty.http.RetrofitFactory;
import com.ifreedom.beauty.http.api.IFengApi;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:09/12/2016
 * @todo:
 */
public class IFengLogic {
    //从凤凰财经的服务器拉取的单只股票的历史信息
    public static List<AllStockHistoryEntity> getOneStockAllHistoryIfeng(String channel, String code, String type) {
        List<AllStockHistoryEntity> allStockHistory = new ArrayList<>();
        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.IFENG_TYPE);
        Call<IFengStock> call = retrofit.create(IFengApi.class).getOneStockHistory(channel + code, type);
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
            AllStockHistoryEntity oneStockHistory = new AllStockHistoryEntity();
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
}
