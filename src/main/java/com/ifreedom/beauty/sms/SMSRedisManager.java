package com.ifreedom.beauty.sms;

import com.ifreedom.beauty.authorization.manager.impl.RedisTokenManager;
import com.ifreedom.beauty.redis.RedisBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @atuhor:eavawu
 * @date:30/11/2016
 * @todo:短信一分钟有效
 */
@Component
public class SMSRedisManager implements SMSManager {
    @Autowired
    RedisTokenManager tokenManager;

    @Override
    public void createSMS(String phone, String code) {
        tokenManager.getRedis().boundValueOps("SMS_" + phone).set(code + "", SMSConstans.SMS_ALIVE_MINUTE, TimeUnit.MINUTES);
    }

    @Override
    public String getSMS(String phone) {
        return tokenManager.getRedis().boundValueOps("SMS_" + phone).get();
    }


}
