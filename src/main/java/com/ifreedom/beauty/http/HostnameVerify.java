package com.ifreedom.beauty.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @atuhor:eavawu
 * @date:05/12/2016
 * @todo:https主机是否验证
 */
public class HostnameVerify implements HostnameVerifier {
    private String[] hostUrl = new String[]{"https://api.wmcloud.com"};

    @Override
    public boolean verify(String s, SSLSession sslSession) {
        for (int i = 0; i < hostUrl.length; i++) {
            if (hostUrl[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
}
