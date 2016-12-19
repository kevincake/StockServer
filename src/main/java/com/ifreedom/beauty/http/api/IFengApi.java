package com.ifreedom.beauty.http.api;

import com.ifreedom.beauty.bean.IFengStock;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @atuhor:eavawu
 * @date:06/12/2016
 * @todo:
 */
public interface IFengApi {
    @GET("http://web.ifzq.gtimg.cn/appstock/app/fqkline/get?_var=kline_dayqfq&param=sz000002,day,,,640,qfq&r=0.82995229180902508")
    Call<IFengStock> getOneStockHistory(@Query("code") String code, @Query("type") String type);
}
