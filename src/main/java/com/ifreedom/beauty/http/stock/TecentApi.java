package com.ifreedom.beauty.http.stock;

import com.ifreedom.beauty.bean.TecentMyStockInfo;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public interface TecentApi {


    @POST("http://123.151.15.200/stockapp/pstock/api/appstockshow.php?")
    Call<TecentMyStockInfo> queryStockInfo(
            @Query("appn") String appn,
            @Query("stktype") String last,
            @Query("grpid") String grpid,
            @Query("isdelay") String isdelay,
            @Query("_mid") String _mid,
            @Query("_md5mid") String _md5mid,
            @Query("_omgid") String _omgid,
            @Query("_omgbizid") String _omgbizid,
            @Query("_appver") String _appver,
            @Query("_ifChId") String _ifChId,
            @Query("_osVer") String _osVer,
            @Query("__random_suffix") String __random_suffix,
            @Query("code") String code
    );

    @POST("http://proxy.finance.qq.com/smartboxgtimg/s3/index_app.php")
    Call<String> searchStock(@Query("q") String searchKey,@Query("t")String isAll);

}
