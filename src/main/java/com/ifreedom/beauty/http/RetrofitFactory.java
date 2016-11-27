package com.ifreedom.beauty.http;

import com.ifreedom.beauty.constants.RetrofitConstants;
import com.sun.javafx.iio.common.ScalerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class RetrofitFactory {
    public static final String TECENT_QUERY_BASE_URL = "http://123.151.15.200/";
    public static final String TECENT_SEARCH_BASE_URL = "http://proxy.finance.qq.com";

    public static Retrofit getRetrofit(int type) {
        switch (type) {
            case RetrofitConstants.TECENT_QUERY:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_QUERY_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            case RetrofitConstants.TECENT_SEARCH:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_SEARCH_BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
            default:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_QUERY_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
    }
}
