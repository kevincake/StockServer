package com.ifreedom.beauty.sms;

/**
 * @atuhor:eavawu
 * @date:30/11/2016
 * @todo:
 */
public interface SMSManager {
    void createSMS(String phone, String code);
    String getSMSCode(String phone);
    void remove(String phone);
}
