package com.ifreedom.beauty.http.api;

import com.ifreedom.beauty.bean.SJTLAllStock;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HomorSmith on 2016/12/5.
 */
public interface SJTLApi {
    @GET("https://api.wmcloud.com/data/v1/api/equity/getEqu.json")
    Call<SJTLAllStock> getAllStockInfo(@Query("equTypeCD")String equTypeCD);
}
