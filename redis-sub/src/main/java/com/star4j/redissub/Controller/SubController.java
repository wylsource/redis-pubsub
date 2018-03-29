package com.star4j.redissub.Controller;

import com.star4j.redissub.client.SubClient;
import com.star4j.redissub.client.SubClientImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2018/3/29 15:27
 * @Modified By:
 */
@RestController
public class SubController {

    @GetMapping("/sub")
    public void subscribe(){
        SubClient client = new SubClientImpl();
        Thread thread = new Thread(() -> {
            client.sub("chat");
        });
        thread.start();
    }
}
