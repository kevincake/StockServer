package com.ifreedom.beauty.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
public class SMSUtil {
    public static void getVerifyCode(String phone) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "HEYmS4mYhGgv1z99", "2xTFsD3y9sOCuleI8OESJamkNmskRS");
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendSmsRequest request = new SingleSendSmsRequest();
        try {
            request.setSignName("hacker科技");
            request.setTemplateCode("SMS_30125106");
            request.setParamString("{}");
            request.setRecNum(phone);
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
            System.out.println("r");
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getVerifyCode("18311362505");
    }
}
