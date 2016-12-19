package com.ifreedom.beauty.push;

import com.ifreedom.beauty.push.mi.MiSender;
import com.xiaomi.xmpush.server.Constants;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:10/12/2016
 * @todo:push服务
 */
public class PushManager {
    private IPushSender iPushSender;
    private static PushManager pushManager = new PushManager();

    private PushManager() {

        iPushSender = new MiSender();

    }

    public static PushManager getInstance() {
        return pushManager;
    }

    public void send(BaseMessage baseMessage) {
        iPushSender.send(baseMessage);
    }

    public void send(List<BaseMessage> baseMessages){

    }

    public static void main(String[] args) {
        BaseMessage message = new BaseMessage();
        message.setAccount("18311362506");
        message.setCustom("自定义内容");
        message.setMessage("消息体");
        message.setTitle("标题");
        PushManager.getInstance().send(message);
    }



}
