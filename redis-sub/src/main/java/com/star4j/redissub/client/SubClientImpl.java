package com.star4j.redissub.client;

import org.springframework.stereotype.Service;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2018/3/29 15:29
 * @Modified By:
 */
public class SubClientImpl extends SubClient{

    @Override
    public void message(String channel, String message) {
        System.out.println("------ 收到消息 -----");
        System.out.println("通道： " + channel + "  --发送信息 ： " + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("----订阅通道：" + channel + "成功!----");
    }
}
