package com.cache.redis;

import org.apache.ibatis.cache.decorators.LoggingCache;

/**
 * LoggingCache类 用于日志记录处理，主要输出缓存命中率信息。 源码是注释部分
 * @author kcz
 *
 */
public class LoggingRedisCache extends LoggingCache{
 /**
  * id 为这个mapper.xml的路径
  * @param id
  */
    public LoggingRedisCache(String id) {
        super(new RedisCache(id));
    }
//   public Object getObject(Object key) {  
//    requests++; // 每调用一次该方法，则获取次数+1  
//    final Object value = delegate.getObject(key);  
//    if (value != null) {  // 命中！ 命中+1  
//      hits++;  
//    }  
//    if (log.isDebugEnabled()) {  
//      // 输出命中率。计算方法为： hits / requets 则为命中率  
//      log.debug("Cache Hit Ratio [" + getId() + "]: " + getHitRatio());  
//    }  
//    return value;

//}  
 
}
