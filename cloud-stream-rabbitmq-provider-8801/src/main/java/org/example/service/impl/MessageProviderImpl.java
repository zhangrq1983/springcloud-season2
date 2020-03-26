package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: MessageProviderImpl
 * @Package org.example.service.impl
 * @Description:
 * @date 2020-03-24 23:05
 */
@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial = " + serial);
//        log.info("serial = " + serial);
        return serial;
    }
}
