package com.myfun.repository.support.mybatis.cache.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import com.myfun.framework.util.SpringContextUtil;

/**
 * mybatis扩展redis缓存 和 spring cache公用一套 方便后期维护 <br/>
 * (注意如果springcache没有初始化完成 就先使用当前缓存 则默认返回空,请先配置spring cache)
 *
 * @author jiangsonggui
 * @ClassName: RedisCache
 * @Description: TODO
 * @date 2015年11月19日 下午5:47:52
 */
public class MybatisCacheRedisImpl implements Cache {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisCacheRedisImpl.class);

    private String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private org.springframework.cache.Cache cache;

    public MybatisCacheRedisImpl(String id) {
        this.id = id;
        // 这里必为空
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSize() {
        if (cache == null) {
            initCache();
        }
        return 0;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (cache == null) {
            initCache();
        } else {
            cache.put(unwrapperCacheKey(key), value);
            //LOGGER.debug("putObject:key->" + key);
            //LOGGER.debug("putObject:value->" + value);
        }
    }

    @Override
    public Object getObject(Object key) {
        Object value = null;
        if (cache == null) {
            initCache();
        } else {
            value = cache.get(unwrapperCacheKey(key));
            if (value instanceof ValueWrapper) {
                ValueWrapper wrapper = (ValueWrapper) value;
                value = wrapper.get();
            }
            //LOGGER.debug("getObject:key->" + key);
            //LOGGER.debug("getObject:value->" + value);
        }
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        if (cache == null) {
            initCache();
        } else {
            cache.evict(unwrapperCacheKey(key));
            //LOGGER.debug("removeObject:key->" + key);
        }
        return null;
    }

    @Override
    public void clear() {
        if (cache == null) {
            initCache();
        } else {
            cache.clear();
            //LOGGER.debug("clear");
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        //LOGGER.debug("getReadWriteLock");
        return readWriteLock;
    }

    /**
     * 初始化缓存
     */
    public void initCache() {
        if(cache == null){
            cache = SpringContextUtil.getBean(CacheManager.class).getCache(id);
        }
    }

    public String unwrapperCacheKey(Object obj) {
        return obj == null ? "" : obj.toString();
    }

}
