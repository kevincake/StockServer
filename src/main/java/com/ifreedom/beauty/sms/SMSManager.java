package com.ifreedom.beauty.sms;

/**
 * @atuhor:eavawu
 * @date:30/11/2016
 * @todo:
 */
public interface SMSManager {
    public void createSMS(String phone, String code);
    public String getSMS(String phone);
}
