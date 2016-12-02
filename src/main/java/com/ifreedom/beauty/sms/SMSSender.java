package com.ifreedom.beauty.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @atuhor:eavawu
 * @date:26/11/2016
 * @todo:
 */
@Component
public class SMSSender {
    @Autowired
    private  SMSManager smsManager;
    public  void sendVerifyCode(String phone) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIrEydNfYJIeOb", "UIJ3onncXzrDyabhFUNfZxSMHJssG5");
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendSmsRequest request = new SingleSendSmsRequest();
        try {
            request.setActionName("SingleSendSms");
            request.setSignName("hacker科技");
            request.setTemplateCode("SMS_31585019");
            int sendCode = new Random().nextInt(1000000);
            request.setParamString("{'name':'" + sendCode + "'}");
            smsManager.createSMS(phone, sendCode + "");
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
//        sendVerifyCode("18311362506");
    }
}
