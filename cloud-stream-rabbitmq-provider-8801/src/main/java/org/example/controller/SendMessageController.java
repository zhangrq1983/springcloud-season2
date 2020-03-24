package org.example.controller;

import org.example.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: SendMessageController
 * @Package org.example.controller
 * @Description:
 * @date 2020-03-24 23:16
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return  iMessageProvider.send();
    }

}
