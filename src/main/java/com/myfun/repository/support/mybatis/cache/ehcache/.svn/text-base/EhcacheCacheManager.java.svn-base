package com.myfun.repository.support.mybatis.cache.ehcache;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

/**
 * 重写ehcache获取cache接口 如果没有获取到cache则重新新建一个
 * 
 * @ClassName: EhcacheCacheManager
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月9日 下午5:40:40
 *
 */
public class EhcacheCacheManager extends EhCacheCacheManager {

	public EhcacheCacheManager() {
		super();
	}

	public EhcacheCacheManager(CacheManager cacheManager) {
		super(cacheManager);
	}

	@Override
	protected Cache getMissingCache(String name) {
		Ehcache ehcache = getCacheManager().getEhcache(name);
		if (ehcache != null) {
			return new EhCacheCache(ehcache);
		} else {
			getCacheManager().addCache(name);
			ehcache = getCacheManager().getEhcache(name);
			if (ehcache != null) {
				return new EhCacheCache(ehcache);
			}
		}
		return null;
	}
}
