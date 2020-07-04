package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.sysmanager.param.InsertFunRegData;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateRangeData;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpCompRoleOpersMapper;
import com.myfun.repository.erpdb.dao.ErpFunAreaMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersInvitedMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunRegion;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpCompRoleOpersService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunRegionService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;

@Service
public class ErpFunRegionServiceImpl extends AbstractService<ErpFunRegion, ErpFunRegion> implements ErpFunRegionService {
	@Autowired ErpFunRegionMapper erpFunRegionMapper;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired ErpFunDeptsService erpFunDeptsService;
	@Autowired ErpCompRoleOpersService erpCompRoleOpersService;
	@Autowired ErpFunRegionService erpFunRegionService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired ErpFunUsersInvitedMapper erpFunUsersInvitedMapper;
	@Autowired ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
	private CacheUtil cacheUtil;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRegionMapper;
	}

	/**
	 * 新增片区
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/18
	 */
	@Transactional
	@Override
	public void insertMgrRegion(ErpFunRegion erpFunRegion, InsertFunRegData param) {
		erpFunRegionMapper.insertSelective(erpFunRegion);
		String content = "创建了" + erpFunRegion.getRegName() + "片区";
		BaseMapParam mapParam = new BaseMapParam();
		mapParam.setInteger("cityId", param.getCityId());
		mapParam.setInteger("compId", param.getCompId());
		mapParam.setInteger("deptId", param.getDeptId());
		mapParam.setInteger("userId", param.getUserId());
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.CREATE_REGION, null, content, null, null, mapParam);
		this.evictRegionByCompId(erpFunRegion.getShardCityId(),erpFunRegion.getCompId());
	}

	/**
	 * 编辑片区
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/18
	 */
	@Transactional
	@Override
	public void updateMgrRegion(UpdateRangeData param) {
		// 初始化数据
		Integer regId = param.getRegId();
		Integer areaId = param.getAreaId();
		String regName = param.getRegName();
		Integer userId = param.getUserId();
		Integer compId = param.getCompId();
		Integer cityId = param.getCityId();
		if(null == areaId){
			areaId = erpFunAreaMapper.getCompAreaId(cityId, compId);
		}
		ErpFunRegion erpFunRegion = erpFunRegionMapper.selectByRegId(cityId, compId, areaId, regId);
		if (erpFunRegion != null && StringUtil.isNotBlank(regName) && !erpFunRegion.getRegName().equals(regName.trim())) {
			// 编辑片区判重
			Integer count = erpFunRegionMapper.countRegionByRegName(cityId, compId, areaId, regName);
			if (count > 0) {
				throw new BusinessException("片区名称重复请重新输入");
			}
		}
		ErpFunRegion region = new ErpFunRegion();
		region.setUpdateUid(userId);
		region.setRegId(regId);
		region.setAreaId(areaId);
		region.setCompId(compId);
		region.setShardCityId(cityId);
		region.setRegName(regName);
		region.setRegDesc(param.getRegDesc());
		region.setAdminUser(param.getAdminUser());
		region.setRegAdmin(param.getRegAdmin());
		region.setSeqNo(param.getSeqNo());
		region.setRegTele(param.getRegTele());
		region.setUpdateTime(DateUtil.DateToString(new Date()));
		ErpFunRegion beforeRegion = erpFunRegionMapper.getDataById(cityId, regId);
		boolean flag = true;
		// 更换了片区的大区ID
		if (beforeRegion != null) {
			if (beforeRegion.getAreaId() != null && areaId != null) {
				flag = beforeRegion.getAreaId().equals(areaId);
			}
		}
		erpFunRegionMapper.updateByPrimaryKeySelective(region);
		// 表示要去掉负责人
		if (null == param.getAdminUser()) {
			erpFunRegionMapper.updateByAdminUser(cityId, compId, areaId, regId);
		}
		/** 级联处理所有的areaID */
		if (!flag && areaId != null) {
			// 门店下的抢盘和公盘数据，只能跟着门店进行级联更新，其他的通过用户信息修改时级联更新 陈文超
			erpFunRegionMapper.updateRegforArea(cityId, compId, regId, areaId);
			erpFunDeptsMapper.updateDeptforArea(cityId, compId, regId, areaId);
			erpFunUsersMapper.updateUserForArea(cityId, compId, regId, areaId);
			// 同步房客源数据
			erpFunUsersMapper.updateDataForArea(cityId, compId, areaId, regId);
			//修改邀请用户
			erpFunUsersInvitedMapper.updateDataForArea(cityId, compId, areaId, regId);
		}
		String content = "修改了" + region.getRegName() + "片区信息";
		BaseMapParam mapParam = new BaseMapParam();
		mapParam.setInteger("cityId", param.getCityId());
		mapParam.setInteger("compId", param.getCompId());
		mapParam.setInteger("deptId", param.getDeptId());
		mapParam.setInteger("userId", param.getUserId());
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.UPDATE_REGION, null, content, beforeRegion, region, mapParam);
		this.evictRegionByCompId(region.getShardCityId(), region.getCompId());
	}

	/**
	 * 删除片区信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/28
	 */
	@Transactional
	@Override
	public void deleteRegionInfo(BaseMapParam param, Integer regId, String content) {
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.DELETE_REGION, null, content, null, null, param);
		erpFunRegionMapper.deleteByCompIdAndRegId(param.getInteger("cityId"), param.getInteger("compId"), regId);
		this.evictRegionByCompId(param.getInteger("cityId"), param.getInteger("compId"));
		erpCompRoleOpersMapper.deleteCompRoleOpersByRegId(param.getInteger("cityId"), param.getInteger("compId"),regId);
	}

	/**
	 * 清空缓存
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/18
	 */
	@Override
	public void evictRegionByCompId(Integer cityId,Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funRegionCache_by_COMP_ID+compId+"_CITY_ID_"+cityId);
	}

	@Transactional
	@Override
	public void updateRegInfo(BaseMapParam param) {
		Integer cityId = param.getInteger("cityId");
		Integer userId = param.getInteger("userId");
		Integer compId = param.getInteger("compId");
		Integer regId = param.getInteger("regId");
		Integer areaId = param.getInteger("areaId");
		String regName = param.getString("regName");
		String regDesc = param.getString("regDesc");
		Integer adminUser = param.getInteger("adminUser");
		String regAdmin = param.getString("regAdmin");
		Integer seqNo = param.getInteger("seqNo");
		String regTele = param.getString("regTele");
		
		ErpFunRegion region = new ErpFunRegion();
		region.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		region.setUpdateUid(userId);
		region.setRegId(regId);
		region.setAreaId(areaId);
		region.setCompId(compId);
		region.setShardCityId(cityId);
		region.setRegName(regName);
		region.setRegDesc(regDesc);
		region.setAdminUser(adminUser);
		region.setRegAdmin(regAdmin);
		region.setSeqNo(seqNo);
		region.setRegTele(regTele);
		
		ErpFunRegion beforeRegion = erpFunRegionMapper.getDataById(cityId, regId);
		// 编辑片区判重
		if (StringUtil.isNotBlank(regName) && !beforeRegion.getRegName().equals(regName.trim())) {
			Integer count = erpFunRegionMapper.countRegionByRegName(cityId, compId, areaId, regName);
			if (count > 0) {
				throw new BusinessException("片区名称重复请重新输入");
			}
		}
		region.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunRegionMapper.updateByPrimaryKeySelective(region);
		this.evictRegionByCompId(cityId, compId);
		// 大区变了，修改相关数据
		if (!beforeRegion.getAreaId().equals(areaId)) {
			erpFunRegionMapper.updateAreaByRegChange(cityId, compId, areaId, regId);
		}
		String content = "修改了" + region.getRegName() + "片区信息";
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.UPDATE_REGION, null, content, beforeRegion, region, param);
	}


}
