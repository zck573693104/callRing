package com.callRing.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageQueue {
	private static final RedisCache redisCache=new RedisCache();
	private static final Logger logger= LoggerFactory.getLogger(MessageQueue.class);
	private static long MAX_MESSAGE_QUEUE=0L;
	private String cacheIp=redisCache.cacheIp;
	/**
	 * 最大可以存储多少条消息记录
	 * @return
	 */
	public  long getMaxMessageQueue(){
		Properties p=new Properties();
		InputStream in= this.getClass().getResourceAsStream("/MessageQueue.properties");
		try {
			p.load(in);
			MAX_MESSAGE_QUEUE=Long.valueOf(p.getProperty("MAX_MESSAGE_QUEUE"));
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		return MAX_MESSAGE_QUEUE;
	}
	/**
	 * 保存聊天记录到redis 采用队列形式 获取0-MAX_MESSAGE_QUEUE条记录
	 * @param userName
	 * @param message
	 */
	public void saveMessageToRedis(String userName,TextMessage message){
		JedisPool pool = new JedisPool(redisCache.getPoolConfig(),cacheIp);
		Jedis jedis=pool.getResource();
		jedis.lpush(userName, message.toString());
		jedis.ltrim(userName,0,getMaxMessageQueue());
	}
	
}
