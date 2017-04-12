package com.cache.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisCache implements Cache {

	private static final Logger logger= LoggerFactory.getLogger(RedisCache.class);

	public static String cacheIp=null;
    //这里可以根据不同的构造方法去构造链接
    private JedisPool pool = new JedisPool(getPoolConfig(),getCacheIp());
    /** The ReadWriteLock. */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
 
    private String id;

    public RedisCache(){
    	}
    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("保存缓存ID");
        }
        logger.debug("缓存:id=" + id);
        this.id = id;

    }

	/**
	 * 得到cacheIp
	 * @return
	 */

	public  String getCacheIp(){
		Properties p=new Properties();
		InputStream in= this.getClass().getResourceAsStream("/cache.properties");
		try {
			p.load(in);
			cacheIp=p.getProperty("cacheIp");
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
		return cacheIp;
	}

	/**
	 * 获取对象id 进行存储
	 * @return
     */
    public String getId() {
        return this.id;
    }

	/**
	 * 计算缓存的大小
	 * @return
     */
    public int getSize() {
	Jedis jedis = pool.getResource();
	try {
	    return Integer.valueOf(jedis.dbSize().toString()); 
	} finally {
		jedis.close();
	}
        
    }

	/**
	 * 对象放入缓存
	 * @param key
	 * @param value
     */
    public void putObject(Object key, Object value) {
	Jedis jedis = pool.getResource();
	try {
	    logger.debug("对象放入缓存调用putObject:" + key + "=" + value);
	    jedis.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
	} finally {
		jedis.close();
	}
    }

	/**
	 * 取得缓存对象  先将要处理的key通过序列化返回字节流，jedis去查找。然后判断是否为空又返回
	 * @param key
	 * @return
     */
    public Object getObject(Object key) {
	Jedis jedis = pool.getResource();
	try {
	    Object value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.toString())));
	    logger.debug("得到缓存对象调用getObject()" +"key:"+ key + "=" +"value:"+value);
	    return value;
	} finally {
		jedis.close();
	}
    }

	/**
	 * expire设置过期时间来达到清空这个key
	 * @param key
	 * @return
     */
    public Object removeObject(Object key) {
	Jedis jedis = pool.getResource();
	try {
	    return jedis.expire(SerializeUtil.serialize(key.toString()), 0);
	} finally {
		jedis.close();
	}
    }

	/**
	 * 清空所有数据库的缓存
	 */
    public void clear() {
	Jedis jedis = pool.getResource();
	try {
	    jedis.flushDB();
	} finally {
		jedis.close();
	}
    }

	/**
	 * 读写锁
	 * @return
     */
    public ReadWriteLock getReadWriteLock() {

		return readWriteLock;
    }
 
    

    /** @description 获取连接池参数	
	 *返回类型:void
     */
    public JedisPoolConfig getPoolConfig() {
	JedisPoolConfig config = new JedisPoolConfig();
	config.setMaxTotal(300);
	config.setMaxIdle(6);
	config.setMaxWaitMillis(18000);
	config.setMinEvictableIdleTimeMillis(300000);
	config.setNumTestsPerEvictionRun(3);
	config.setTimeBetweenEvictionRunsMillis(60000);
	config.setTestOnBorrow(true);
	return config;
    }
}
