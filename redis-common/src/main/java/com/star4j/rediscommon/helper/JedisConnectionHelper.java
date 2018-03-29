package com.star4j.rediscommon.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: WuYL
 * @Description: 用于提供 Jedis 及常用操作
 * @Date: Create in 2018/3/29 13:23
 * @Modified By:
 */
@PropertySource({"classpath:redis-config.properties"})
@ConfigurationProperties(prefix = "redis")
public class JedisConnectionHelper {

    private static int maxTotal = 10;

    private static int maxIdle = 5;

    private static long maxWaitMillis = 3000;

    private static String PASSWORD = "654321";

    private static String host = "192.168.1.116";

    private static int port = 6379;

    private static int timeOut = 0;

    private static JedisPool jedisPool = null;

    static {
        System.out.println(maxTotal + "---" + maxIdle + "--"  + PASSWORD + "--"  + host);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(poolConfig, host, port, timeOut, PASSWORD);
    }

    /**
     * 获取 Jedis 对象
     * @return
     */
    public static Jedis get(){
        return jedisPool.getResource();
    }

    /**
     * jedis 关闭的方法
     * @param jedis
     */
    public static void close(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public static void setJedisPool(JedisPool jedisPool) {
        JedisConnectionHelper.jedisPool = jedisPool;
    }
}
