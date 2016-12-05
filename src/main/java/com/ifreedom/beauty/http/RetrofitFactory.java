package com.ifreedom.beauty.http;

import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.http.interceptoer.SJTLHeaderInterceptor;
import com.sun.javafx.iio.common.ScalerFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @atuhor:eavawu
 * @date:27/11/2016
 * @todo:
 */
public class RetrofitFactory {
    public static final String TECENT_QUERY_BASE_URL = "http://123.151.15.200/";
    public static final String TECENT_SEARCH_BASE_URL = "http://proxy.finance.qq.com";
    public static final String SJTL = "https://api.wmcloud.com";

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
            case RetrofitConstants.SJTL_HOST:
                OkHttpClient SJTLOKClient = new OkHttpClient().newBuilder()
                        .readTimeout(100, TimeUnit.SECONDS)
//                        hostnameVerifier(new HostnameVerify())
                        .addInterceptor(new SJTLHeaderInterceptor()).build();
                return new Retrofit.Builder().baseUrl(SJTL)
                        .addConverterFactory(GsonConverterFactory.create()).
                                client(SJTLOKClient).build();


            default:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_QUERY_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
    }
}
