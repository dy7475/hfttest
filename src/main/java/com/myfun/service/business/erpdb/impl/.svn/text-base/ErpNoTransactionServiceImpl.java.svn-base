package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.repository.erpdb.dao.ErpCompRoleOpersMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpNoTransactionService;


/**
  * @Title  : 这个类不要事务，要事务的新建一个service
  * @author : lcb
  * @Time   ： 2018/7/19
  *
  **/
@Service
public class ErpNoTransactionServiceImpl extends AbstractService<ErpUserOpers, Integer> implements ErpNoTransactionService {

	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired
	ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired
	private CacheUtil cacheUtil;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpUserOpersMapper;
	}


	/**
	  * @Title  : 清理用户的权限信息缓存
	  * @author : lcb
	  * @Time   ： 2018/7/23
	  *
	  **/
	@Override
	public void evictCacheableModelData(Integer cityId, Integer userId) {
	    cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID + userId+"_CITY_ID_" + cityId);
	}

	@Override
	public void evictBaseInfoByCompId(Integer cityId, Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
	    cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
	}

	/**
	 * @tag 获取角色权限列表
	 * @author 邓永洪
	 * @since 2018/8/15
	 */
	@Cacheable(value = "hfterpdb_roleOpersCache1",
			key = "'" + CacheStructure.hfterpdb_roleOpersCache_compRoleOpers_by_Role_ID + "'+#cityId+'_'+#compId+'_'+#roleId")
	@Override
	public List<ErpCompRoleOpers> getCompRoleOpersByRoleId(Integer cityId, Integer compId, String roleId) {
		return erpCompRoleOpersMapper.getCompRoleOpersByRoleId(cityId, compId, roleId);
	}

	/*@Override
	public void evictWorkCountTargetData(String key) {
		Set<String> keys = redisTemplate.keys(key);
		for (String k : keys) {
			redisTemplate.delete(k);
		}
	}*/
}
