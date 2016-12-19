package com.ifreedom.beauty.push.mi;

import com.ifreedom.beauty.push.BaseMessage;
import com.ifreedom.beauty.push.IPushSender;
import com.xiaomi.xmpush.server.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @atuhor:eavawu
 * @date:10/12/2016
 * @todo:
 */
public class MiSender implements IPushSender {
    public MiSender() {
        Constants.useSandbox();
    }

    @Override
    public void send(BaseMessage baseMessage) {
        Sender sender = new Sender("Ie7VLTBhpXaCGPpmKo6FNw==");
        Message message = new Message.IOSBuilder()
                .description(baseMessage.getTitle())
                .soundURL("default")    // 消息铃声
                .badge(1)               // 数字角标
                .category("action")     // 快速回复类别
                .extra("key", "value")  // 自定义键值对
                .build();

        try {
            Result sendResult = sender.send(message, baseMessage.getAccount(), 3);
            String reason = sendResult.getReason();
            System.out.println(reason);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
