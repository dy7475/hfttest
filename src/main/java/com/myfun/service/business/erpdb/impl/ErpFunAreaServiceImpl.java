package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.sysmanager.param.CreateAreaParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DeleteAreaDataParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateAreaData;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.ErpCompRoleOpersMapper;
import com.myfun.repository.erpdb.dao.ErpFunAreaMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPersonnelLevelsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.po.ErpCompRoleOpersExample;
import com.myfun.repository.erpdb.po.ErpFunArea;
import com.myfun.repository.erpdb.po.ErpFunAreaExample;
import com.myfun.repository.erpdb.po.ErpFunRegionExample;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAreaService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;

/**
 * @TODO 大区
 * @author lcb
 * @2016-10-19 上午11:10:39
 */

@Service
public class ErpFunAreaServiceImpl extends AbstractService<ErpFunArea, ErpFunArea> implements ErpFunAreaService {
	@Autowired
	ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
	ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired
    ErpFunPersonnelLevelsMapper erpFunPersonnelLevelsMapper;
	@Autowired
	private CacheUtil cacheUtil;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAreaMapper;
	}

	/**
	 * @TODO 新增大区
	 * @author lcb
	 * @2016-10-19 上午11:48:23
	 * @param param
	 */
	@Transactional
	@Override
	public Integer insertMgrArea(CreateAreaParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String areaName = param.getAreaName();
		ErpFunArea erpFunArea = new ErpFunArea();
		// 插入数据时,刷新缓存
		erpFunArea.setShardCityId(cityId);
		erpFunArea.setAreaAdmin(param.getAreaAdmin());
		erpFunArea.setAreaDesc(param.getAreaDesc());
		erpFunArea.setAreaName(areaName);
		erpFunArea.setAdminUser(param.getAdminUser());
		erpFunArea.setAreaTele(param.getAreaTele());
		erpFunArea.setCompId(compId);
		erpFunArea.setCreationTime(new Date());
		erpFunArea.setCreatorUid(param.getUserId());
		erpFunArea.setSeqNo(param.getSeqNo());
		// 大区新增判定重复 areaName
		Integer count = erpFunAreaMapper.countByAreaName(cityId, compId, areaName.trim());
		if (count > 0) {
			throw new BusinessException("大区名称重复请重新输入");
		}
		String content = "创建了" + areaName + "大区";
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.CREATE_REGION, null, null, content, null,
				null, cityId, compId, param.getDeptId(), param.getUserId());
		erpFunAreaMapper.insertSelective(erpFunArea);
		this.evictAreaByCompId(erpFunArea.getShardCityId(), erpFunArea.getCompId());
		return erpFunArea.getAreaId();
	}

    /**
     * 编辑大区
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/17
     */
	@Transactional
    @Override
	public void updateMgrArea(UpdateAreaData param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String areaName = param.getAreaName();
		Integer areaId = param.getAreaId();
		ErpFunArea erpFunArea = new ErpFunArea();
		// 插入数据时,刷新缓存
		erpFunArea.setShardCityId(cityId);
		erpFunArea.setAreaAdmin(param.getAreaAdmin());
		erpFunArea.setAreaDesc(param.getAreaDesc());
		erpFunArea.setAreaId(areaId);
		erpFunArea.setAreaName(areaName);
		erpFunArea.setAdminUser(param.getAdminUser());
		erpFunArea.setAreaTele(param.getAreaTele());
		erpFunArea.setCompId(compId);
		erpFunArea.setUpdateTime(new Date());
		erpFunArea.setUpdateUid(param.getUserId());
		erpFunArea.setSeqNo(param.getSeqNo());
		ErpFunArea erpFunArea1 = erpFunAreaMapper.getAreaByAreaId(cityId, compId, areaId);
		// 大区编辑判定重复 areaName
		Integer count = erpFunAreaMapper.countByAreaName(cityId, compId, areaName);
		if (StringUtil.isNotBlank(areaName) && !erpFunArea1.getAreaName().equals(areaName.trim())) {
			if (count > 0) {
				throw new BusinessException("大区名称重复请重新输入");
			}
		}
		String content = "修改了" + param.getAreaName() + "大区信息";
		BaseMapParam mapParam = new BaseMapParam();
		mapParam.setInteger("cityId", param.getCityId());
		mapParam.setInteger("compId", param.getCompId());
		mapParam.setInteger("deptId", param.getDeptId());
		mapParam.setInteger("userId", param.getUserId());
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.UPDATE_AREA, null, content, erpFunArea1,
				erpFunArea, mapParam);
		erpFunAreaMapper.updateByPrimaryKeySelective(erpFunArea);
		// 表示要去掉负责人
		if(null == param.getAdminUser()){
			erpFunAreaMapper.updateByAdminUser(cityId, compId, areaId);
		}
		this.evictAreaByCompId(erpFunArea.getShardCityId(), erpFunArea.getCompId());
	}

	private ErpFunArea createFunArea(Map<String, Object> pMap, Operator operator) {
		ErpFunArea erpFunArea = new ErpFunArea();
		erpFunArea.setCompId(operator.getCompId());
		erpFunArea.setCreatorUid(operator.getUserId());
		erpFunArea.setCreationTime(new Date());
		erpFunArea.setAdminUser(Integer.valueOf(pMap.get("adminUser")+""));
		erpFunArea.setAreaDesc(pMap.get("areaDesc")+"");
		erpFunArea.setAreaName(pMap.get("areaName")+"");
		erpFunArea.setAreaTele(pMap.get("areaTel")+"");
		erpFunArea.setSeqNo(Integer.valueOf(pMap.get("seqNo")+""));
		return erpFunArea;
	}

    /**
     * 清空缓存
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/18
     */
	@Override
	public void evictAreaByCompId(Integer cityId,Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funAreaCache_by_COMP_ID+compId+"_CITY_ID_"+cityId);
	}


    /**
	 * @tag 删除大区
	 * @author 邓永洪
	 * @since 2018/5/17
	 */
	@Transactional
	@Override
	public void deleteMgrArea(DeleteAreaDataParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer areaId = param.getAreaId();
		Integer userId = param.getUserId();
		ErpFunAreaExample funAreaExample = new ErpFunAreaExample();
		funAreaExample.setShardCityId(cityId);
		funAreaExample.setOrderByClause("CREATION_TIME DESC ,SEQ_NO DESC");
		funAreaExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0);
		List<ErpFunArea> funAreas = erpFunAreaMapper.selectByExample(funAreaExample);
		if (funAreas.size() == 1) {
			throw new BusinessException("至少要保留一个大区", "-4029");
		}
		ErpFunRegionExample funRegionExample = new ErpFunRegionExample();
		funRegionExample.setShardCityId(cityId);
		funRegionExample.createCriteria().andCompIdEqualTo(compId).andAreaIdEqualTo(areaId).andIsDelEqualTo((byte) 0);
		Integer funRegionCount = erpFunRegionMapper.countByExample(funRegionExample);
		if (funRegionCount > 0) {
			throw new BusinessException("检测到大区下还存在片区,不能删除！", "-4029");
		}
		String content = null;
		for (ErpFunArea funAreaPO : funAreas) {
			if (areaId.equals(funAreaPO.getAreaId())) {
				content = "删除了" + funAreaPO.getAreaName() + "大区";
				break;
			}
		}
		BaseMapParam mapParam = new BaseMapParam();
		mapParam.setInteger("cityId", param.getCityId());
		mapParam.setInteger("compId", param.getCompId());
		mapParam.setInteger("deptId", param.getDeptId());
		mapParam.setInteger("userId", param.getUserId());
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.DELETE_AREA, null, content, null, null, mapParam);
		ErpFunAreaExample updateExample = new ErpFunAreaExample();
		updateExample.setShardCityId(cityId);
		updateExample.createCriteria().andCompIdEqualTo(compId).andAreaIdEqualTo(areaId);
		ErpFunArea updateModel = new ErpFunArea();
		updateModel.setIsDel((byte) 1);
		updateModel.setUpdateTime(new Date());
		updateModel.setUpdateUid(userId);
		updateModel.setUpdateTime(new Date());
		erpFunAreaMapper.updateByExampleSelective(updateModel, updateExample);
		ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
		compRoleOpersExample.setShardCityId(cityId);
		compRoleOpersExample.createCriteria().andCompIdEqualTo(compId).andRegIdEqualTo(areaId);
		erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample);
		this.evictAreaByCompId(updateModel.getShardCityId(), updateModel.getCompId());
	}
}
