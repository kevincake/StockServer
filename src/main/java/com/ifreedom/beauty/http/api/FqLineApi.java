package com.ifreedom.beauty.http.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @atuhor:eavawu
 * @date:09/12/2016
 * @todo:
 */
public interface FqLineApi {
    @GET("http://web.ifzq.gtimg.cn/appstock/app/fqkline/get")
    Call<String> getOneStockHistory(@Query("param")String param);
}
