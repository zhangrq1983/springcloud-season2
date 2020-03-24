package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: ConfigClientController
 * @Package org.example.controller
 * @Description:
 * @date 2020-03-24 16:37
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo(){
        return "serverPort: "+serverPort+"\t\n\n configInfo: "+configInfo;
    }

}
