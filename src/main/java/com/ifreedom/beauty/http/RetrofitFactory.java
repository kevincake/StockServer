package com.ifreedom.beauty.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.http.interceptoer.SJTLHeaderInterceptor;
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
    public static final String IFENG = "http://api.finance.ifeng.com/";
    public static final String FQ_LINE = "http://web.ifzq.gtimg.cn";
    public static final String SINA = "http://vip.stock.finance.sina.com.cn";
    public static Retrofit getRetrofit(int type) {
        switch (type) {
            case RetrofitConstants.TECENT_QUERY_TYPE:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_QUERY_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            case RetrofitConstants.TECENT_SEARCH_TYPE:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_SEARCH_BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
            case RetrofitConstants.SJTL_TYPE:
                OkHttpClient SJTLOKClient = new OkHttpClient().newBuilder()
                        .readTimeout(100, TimeUnit.SECONDS)
//                        hostnameVerifier(new HostnameVerify())
                        .addInterceptor(new SJTLHeaderInterceptor()).build();
                return new Retrofit.Builder().baseUrl(SJTL)
                        .addConverterFactory(GsonConverterFactory.create()).
                                client(SJTLOKClient).build();
            case RetrofitConstants.IFENG_TYPE:
                return new Retrofit.Builder()
                        .baseUrl(IFENG)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            case RetrofitConstants.FQ_LINETYPE:
                return new Retrofit.Builder()
                        .baseUrl(FQ_LINE)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
            case RetrofitConstants.SINA_TYPE:
                OkHttpClient SINAOKClient = new OkHttpClient().newBuilder()
                        .readTimeout(100, TimeUnit.SECONDS).build();
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                return new Retrofit.Builder()
                        .client(SINAOKClient)
                        .baseUrl(SINA)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            default:
                return new Retrofit.Builder()
                        .baseUrl(TECENT_QUERY_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
    }
}
