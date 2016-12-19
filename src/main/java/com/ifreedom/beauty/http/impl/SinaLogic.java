package com.ifreedom.beauty.http.impl;

import com.ifreedom.beauty.bean.RealTimeStock;
import com.ifreedom.beauty.constants.RetrofitConstants;
import com.ifreedom.beauty.http.RetrofitFactory;
import com.ifreedom.beauty.http.api.SinaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

/**
 * @atuhor:eavawu
 * @date:10/12/2016
 * @todo:
 */
public class SinaLogic {
    public static void getRealTimeStock(int pageNum, int pageSize, Callback<List<RealTimeStock>> cb) {
        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.SINA_TYPE);
        retrofit.create(SinaApi.class).getRealTimeStock(pageNum, pageSize).enqueue(new Callback<List<RealTimeStock>>() {
            @Override
            public void onResponse(Call<List<RealTimeStock>> call, Response<List<RealTimeStock>> response) {
                if (cb != null) {
                    cb.onResponse(call, response);
                }
            }

            @Override
            public void onFailure(Call<List<RealTimeStock>> call, Throwable throwable) {
                if (cb != null) {
                    cb.onFailure(call, throwable);
                }
            }
        });


//        Retrofit retrofit = RetrofitFactory.getRetrofit(RetrofitConstants.SINA_TYPE);
//        SinaApi sinaApi = retrofit.create(SinaApi.class);
//        Call<String> realTimeStock = sinaApi.getRealTimeStock(1, 1);
//        try {
//            String body = realTimeStock.execute().body();
//            System.out.println(body);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


    public static void main(String[] args) {
//        SinaLogic.getRealTimeStock(1,1,null);
//        SinaLogic.getRealTimeStock(1, 1, new Callback<List<RealTimeStock>>() {
//            @Override
//            public void onResponse(Call<List<RealTimeStock>> call, Response<List<RealTimeStock>> response) {
//                System.out.println(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<RealTimeStock>> call, Throwable throwable) {
//                System.out.println("exception===>" + throwable.toString());
//            }
//        });
    }
}
