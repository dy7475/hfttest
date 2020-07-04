package com.myfun.repository.support.mybatis.cache;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.myfun.utils.BeanUtilsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;

import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.utils.StringUtil;

/**
 * 尽量使用 framework中的CacheUtils 在未来版本可能会进行删除
 */
public class CacheUtilExt {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(CacheUtilExt.class);
    /**
     * 会话过期时间 单位：秒
     **/
    public static final int SESSION_TIME_OUT = 60 * 60 * 24;
    /**
     * 会话已过期，设置表示会话无效的时间 单位：秒
     **/
    public static final int INVALID_TIME_OUT = 60 * 30;

    private static CacheManager cacheManager = null;

    public synchronized static CacheManager getCacheManager() {
        if (cacheManager == null) {
            cacheManager = SpringContextUtil.getBean(CacheManager.class);
        }
        return cacheManager;
    }


    /**
     * 修改信息，比较新旧数据
     *
     * @param newBean
     * @param oldBean
     * @return
     */
    public static String updateTrack(Object newBean, Object oldBean) {
        String trackStr = "";
        try {
            Map<String, Object> newJsonArray = BeanUtilsHelper.bean2Map(newBean);
            Map<String, Object> oldJsonArray = BeanUtilsHelper.bean2Map(oldBean);
            for (String key : newJsonArray.keySet()) {
                if (key.contains("Name") || key.contains("User") || key.contains("Addr") || key.contains("tele")
                        || key.contains("Contact") || key.contains("Sex") || key.contains("Phone") || key.contains("Qq")
                        || key.contains("Region") || key.contains("deptLevel")) {
                    Object oldValue = oldJsonArray.get(key) == null ? "" : oldJsonArray.get(key);
                    Object newValue = newJsonArray.get(key) == null ? "" : newJsonArray.get(key);
                    if (!oldValue.equals(newValue)) {
                        if (key.contains("Sex")) {
                            oldValue = "1".equals(String.valueOf(oldValue)) ? "男" : "女";
                            newValue = "1".equals(String.valueOf(newValue)) ? "男" : "女";
                        }
                        trackStr += oldValue + ">>" + newValue + ";";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackStr;
    }

    /**
     * 获取默认cache
     *
     * @return
     */
    public static Cache getRootRediscacheCache() {
        return getCache("ROOT");
    }

    public static Cache getCache(String name) {
        return getCacheManager().getCache(name);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void expire(String cacheName, Object key, long timeOut) {
        Cache cache = getCache(cacheName);
        Object redisOperations = cache.getNativeCache();
        if (redisOperations instanceof RedisOperations) {
            RedisOperations redisCache = (RedisOperations) redisOperations;
            redisCache.expire(key, timeOut, TimeUnit.SECONDS);
        } else {
            Object objectVal = get(cacheName, key);
            put(cacheName, key, objectVal, timeOut);
        }
    }

    public static void expire(Object key, long timeOut) {
        expire("ROOT", key, timeOut);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void delete(String cacheName, Object key) {
        Cache cache = getCache(cacheName);
        Object redisOperations = cache.getNativeCache();
        if (redisOperations instanceof RedisOperations) {
            RedisOperations redisCache = (RedisOperations) redisOperations;
            redisCache.delete(key);
        } else {
            cache.evict(key);
        }
    }

    public static void delete(Object key) {
        delete("ROOT", key);
    }

    /**
     * 往默认cache里面存储
     *
     * @param key
     * @param value
     * @param timeOut
     */
    public static void put(Object key, Object value, long timeOut) {
        Cache cache = getRootRediscacheCache();
        cache.put(key, value);
    }

    public static void put(Object key, Object value) {
        getRootRediscacheCache().put(key, value);
    }

    /**
     * 往制定cache里面存储
     *
     * @param cacheName
     * @param key
     * @param value
     * @param timeOut
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void put(String cacheName, Object key, Object value, long timeOut) {
        Cache cache = getCache(cacheName);
        Object redisOperations = cache.getNativeCache();
        if (redisOperations instanceof RedisOperations) {
            RedisOperations redisCache = (RedisOperations) redisOperations;
            redisCache.boundValueOps(key.toString()).set(value, timeOut, TimeUnit.SECONDS);
        } else {
            cache.put(key, value);
        }
    }

    public static void put(String cacheName, Object key, Object value) {
        getCache(cacheName).put(key, value);
    }

    public static Object get(String cacheName, Object key) {
        if (StringUtil.isEmpty(cacheName) || (key == null)) {
            return null;
        }
        ValueWrapper valueWrapper = getCache(cacheName).get(key);
        if (valueWrapper != null) {
            return valueWrapper.get();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key, Class<T> clz) {
        Object result = get(key);
        try {
            return (T) result;
        } catch (Exception e) {
        }
        return null;
    }

    public static Object get(String key) {
        return get("ROOT", key);
    }

    public static Object getOpenApi(String key) {
        return get(CacheStructure.BS_OpenApi_ROOT_Cache, key);
    }

    public static void evict(String cacheName, Object key) {
        getCache(cacheName).evict(key);
    }

    public static void evict(Object key) {
        getCache("ROOT").evict(key);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static long getDbSize(String cacheName) {
        Cache cache = getCache(cacheName);
        Object redisOperations = cache.getNativeCache();
        if (redisOperations instanceof RedisOperations) {
            RedisOperations redisCache = (RedisOperations) redisOperations;
            redisCache.execute(new RedisCallback<Long>() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.dbSize();
                }
            });
        }
        return 0;
    }

    public static String getCacheName(String cacheName) {
        Cache cache = getCache(cacheName);
        return cache.getName();
    }

    public static void evictByPattern(String cacheName, String pattern) {
        throw new RuntimeException("暂未实现");
    }

    public static void evictByPattern(String pattern) {
        evictByPattern("ROOT", pattern);
    }

    @SuppressWarnings("rawtypes")
    public static RedisOperations getRedisTemplate(String cacheName) {
        Cache cache = getCache(cacheName);
        Object redisOperations = cache.getNativeCache();
        if (redisOperations instanceof RedisOperations) {
            RedisOperations redisCache = (RedisOperations) redisOperations;
            return redisCache;
        }
        return null;
    }

}
