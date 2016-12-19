package com.ifreedom.beauty.http.api;

import com.ifreedom.beauty.bean.RealTimeStock;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:09/12/2016
 * @todo:
 */
public interface SinaApi {
    @POST("http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?sort=code&asc=0&node=hs_a")
    Call<List<RealTimeStock>> getRealTimeStock(@Query("page") int pageNum, @Query("num") int pageSize);
}
