package com.ifreedom.beauty.http.interceptoer;

import com.ifreedom.beauty.constants.SJTLConstants;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:数据通联的Header参数
 */
public class SJTLHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder()
                .addHeader(SJTLConstants.TOKEN_KEY, SJTLConstants.TOKEN)
                .build();
        return chain.proceed(newRequest);

    }
}
