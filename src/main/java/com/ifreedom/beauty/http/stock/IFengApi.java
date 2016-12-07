package com.ifreedom.beauty.http.stock;

import com.ifreedom.beauty.bean.IFengStock;
import com.ifreedom.beauty.bean.SJTLAllStock;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @atuhor:eavawu
 * @date:06/12/2016
 * @todo:
 */
public interface IFengApi {
    @GET("akdaily")
    Call<IFengStock> getOneStockHistory(@Query("code") String code, @Query("type") String type);
}
