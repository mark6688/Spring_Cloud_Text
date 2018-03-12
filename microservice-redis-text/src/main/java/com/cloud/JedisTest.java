package com.cloud;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by mk on 2018/2/5.
 */
public class JedisTest {

    public static void main(String[] args) {
        JedisTest jedisTest = new JedisTest();
        try {
            jedisTest.testJedisSingle();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //单机版
    public void testJedisSingle() throws Exception{
        //创建一个jedis对象
        Jedis jedis = new Jedis("59.110.242.106",6379);
        //jedis.set("test", "hello jedis");
        String string = jedis.get("a");
        System.out.println(string);
        jedis.close();
    }

    //使用连接池
    public void testJedisPool() throws Exception{
        //创建一个链接池对象
        //系统中应该是单例的
        JedisPool jedisPool = new JedisPool("192.168.37.10",6379);
        //从连接池中获得一个连接
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("test");
        System.out.println(result);
        //jedis必须关闭
        jedis.close();



        //系统关闭时关闭连接池
        jedisPool.close();
    }
}
