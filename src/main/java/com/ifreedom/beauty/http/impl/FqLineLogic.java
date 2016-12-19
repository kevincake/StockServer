package com.ifreedom.beauty.http.impl;

import com.google.gson.Gson;
import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.entity.AllStockHistoryEntity;
import com.ifreedom.beauty.http.RetrofitFactory;
import com.ifreedom.beauty.http.api.FqLineApi;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:09/12/2016
 * @todo:获取单只股票的所有历史
 */
public class FqLineLogic {
    public static List<AllStockHistoryEntity> getOneStockHistory(String channel, String code) {
        List<AllStockHistoryEntity> allStockHistoryList = new ArrayList<>();
        Gson gson = new Gson();
        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.FQ_LINETYPE);
        FqLineApi fqLineApi = retrofit.create(FqLineApi.class);
        Call<String> oneStockHistoryCall = fqLineApi.getOneStockHistory(channel + code + ",day,,,640,qfq");
        try {
            String body = oneStockHistoryCall.execute().body();
            JSONObject jsonObject = new JSONObject(body);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray codeInfo = data.getJSONObject(channel + code).getJSONArray("qfqday");
            for (int i = 0; i < codeInfo.length(); i++) {
                JSONArray oneRecord = codeInfo.getJSONArray(i);
                AllStockHistoryEntity oneStockHistory = new AllStockHistoryEntity();
                oneStockHistory.setStockChannel(channel);
                oneStockHistory.setStockCode(code);
                oneStockHistory.setDate(oneRecord.get(0).toString());
                oneStockHistory.setOpen(Double.parseDouble(oneRecord.get(1).toString()));
                oneStockHistory.setHigh(Double.parseDouble(oneRecord.get(2).toString()));
                oneStockHistory.setClose(Double.parseDouble(oneRecord.get(3).toString()));
                oneStockHistory.setLow(Double.parseDouble(oneRecord.get(4).toString()));
                oneStockHistory.setVolume(Double.parseDouble(oneRecord.get(5).toString()));
                allStockHistoryList.add(oneStockHistory);
            }
            return allStockHistoryList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<AllStockHistoryEntity> sz = FqLineLogic.getOneStockHistory("sz", "000001");
        System.out.println(sz);
    }

}
