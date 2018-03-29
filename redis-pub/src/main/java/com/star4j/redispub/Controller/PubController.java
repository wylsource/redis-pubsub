package com.star4j.redispub.Controller;

import com.star4j.redispub.client.PubClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2018/3/29 15:43
 * @Modified By:
 */
@RestController
public class PubController {

    @PostMapping("/pub")
    public void publish(String message){
        PubClient.pub("chat", message);
    }
}
