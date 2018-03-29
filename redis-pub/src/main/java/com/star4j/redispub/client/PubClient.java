package com.star4j.redispub.client;

import com.star4j.rediscommon.helper.JedisConnectionHelper;
import redis.clients.jedis.Jedis;

/**
 * @Author: WuYL
 * @Description: 发布端实现
 * @Date: Create in 2018/3/29 15:41
 * @Modified By:
 */
public class PubClient {

    /**
     * 发布消息
     * @param channel
     * @param message
     */
    public static void pub(String channel, String message){
        Jedis jedis = JedisConnectionHelper.get();
        jedis.publish(channel, message);
        JedisConnectionHelper.close(jedis);
    }
}
