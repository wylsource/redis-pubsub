package com.star4j.redissub.client;

import com.star4j.rediscommon.helper.JedisConnectionHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author: WuYL
 * @Description: 实现订阅功能
 * @Date: Create in 2018/3/29 15:21
 * @Modified By:
 */
public abstract class SubClient extends JedisPubSub{

    private Jedis jedis = null;

    public SubClient(Jedis jedis){
        this.jedis = jedis;
    }

    protected SubClient(){
        jedis = JedisConnectionHelper.get();
    }

    /**
     * 订阅一个通道 (必须实现该类才行)
     * @param channal
     */
    public final void sub(String channal){
        jedis.subscribe(this, channal);
    }

    /**
     * 有消息被推送过来时调用（子类实现）
     * @param channel
     * @param message
     */
    public abstract void message(String channel, String message);

    @Override
    public  void onMessage(String channel, String message) {
        this.message(channel, message);
    }

}
