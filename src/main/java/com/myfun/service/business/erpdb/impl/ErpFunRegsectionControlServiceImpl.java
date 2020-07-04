package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegsectionControlMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunRegsectionControl;
import com.myfun.repository.erpdb.po.ErpFunRegsectionControlExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRegsectionControlService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;


@Service
public class ErpFunRegsectionControlServiceImpl extends AbstractService<ErpFunRegsectionControl, ErpFunRegsectionControl> implements ErpFunRegsectionControlService {
	@Autowired ErpFunRegsectionControlMapper erpFunRegsectionControlMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRegsectionControlMapper;
	}

	@Transactional
	@Override
	public void saveFunRegsectionControlOffDept(Integer cityId, Integer compId, Integer deptId, Integer creatorUid, Integer creatorDeptId,String cotrolJsonListStr, String currentUserName , String controllType) {
		ErpFunRegsectionControlExample example = new ErpFunRegsectionControlExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId);
		ErpFunDepts id = new ErpFunDepts();
		id.setDeptId(deptId);
		id.setShardCityId(cityId);
		ErpFunDepts deptDto = erpFunDeptsMapper.selectByPrimaryKey(id);
		List<ErpFunRegsectionControl> list = erpFunRegsectionControlMapper.selectByExample(example);
		List<ErpFunRegsectionControl> updateList = new ArrayList<>(0);
		if (!StringUtil.isBlank(cotrolJsonListStr)) {
			updateList = JSON.parseArray(cotrolJsonListStr, ErpFunRegsectionControl.class);	
			List<Integer> haveIds = new ArrayList<>();
			if (!updateList.isEmpty()) {
				Date date = new Date();
				for (ErpFunRegsectionControl erpFunRegsectionControl : updateList) {
					if (erpFunRegsectionControl.getId() != null) {
						erpFunRegsectionControl.setShardCityId(cityId);
						erpFunRegsectionControlMapper.updateByPrimaryKeySelective(erpFunRegsectionControl);
						haveIds.add(erpFunRegsectionControl.getId());
					} else if (erpFunRegsectionControl.getId() == null) {
						erpFunRegsectionControl.setShardCityId(cityId);
						erpFunRegsectionControl.setCreateUid(creatorUid);
						erpFunRegsectionControl.setCreationTime(date);
						erpFunRegsectionControl.setCompId(compId);
						erpFunRegsectionControlMapper.insertSelective(erpFunRegsectionControl);
						haveIds.add(erpFunRegsectionControl.getId());
					}
				}
				example = new ErpFunRegsectionControlExample(); 
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andControlTypeEqualTo(Integer.valueOf(controllType)).andIdNotIn(haveIds);
				erpFunRegsectionControlMapper.deleteByExample(example);
			} else {
				example = new ErpFunRegsectionControlExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andControlTypeEqualTo(Integer.valueOf(controllType));
				//执行删除操作
				erpFunRegsectionControlMapper.deleteByExample(example);
			}
		} else {
			example = new ErpFunRegsectionControlExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andControlTypeEqualTo(Integer.valueOf(controllType));
			//执行删除操作
			erpFunRegsectionControlMapper.deleteByExample(example);
		}
		String trackContent = currentUserName+" 修改了"+deptDto.getDeptCname()+"的"+("1".equals(controllType)?"核心":"基本")+"信息查看范围";
		erpSystemSettingLogsService.insertSysLog(SSL_TYPE.SYSTEM_RUN_MODEL.REGSECTION_SWITCH, null,deptDto.getDeptId(), trackContent, JSON.toJSONString(list), JSON.toJSONString(updateList), cityId, compId, creatorDeptId, creatorUid);
		erpFunUsersService.endLoginDeptUser(cityId, compId, deptId, LogInEnum.SystemPara_UP);
	}

	@Override
	public Integer buildHouseListQueryRegSection(QueryHouseCustListParam queryParam, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, String userId, String range, Integer cityId, Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGrId, Integer selfUserId) {
		Integer result = 1;
		String queryRange = "COMP_ID";
		Integer queryRangeId = compId;
		if(null != grId){
			queryRange = "GR_ID";
			queryRangeId = grId;
		} else if(null != deptId){
			queryRange = "DEPT_ID";
			queryRangeId = deptId;
		} else if(null != regId){
			queryRange = "REG_ID";
			queryRangeId = regId;
		} else if(null != areaId){
			queryRange = "AREA_ID";
			queryRangeId = areaId;
		}
		if (StringUtil.isNotBlank(userId) && !userId.equals("PUBLIC") && !userId.equals("SHARE")) {
			queryRange = "USER_ID";
			queryRangeId = StringUtil.parseInteger(userId);
		}
		Integer queryLevel = Const.RANGE_LEVEL.get(queryRange);
		Integer operQueryLevel = Const.RANGE_LEVEL.get(range);
		if ("COMP_ID".equals(queryRange)) {
			if ("COMP_ID".equals(range)) {
				return 0;
			}
		} else {
			if("AREA_ID".equals(queryRange)){
				queryParam.setRegSectionAreaId(queryRangeId);
			} else if("REG_ID".equals(queryRange)){
				queryParam.setRegSectionRegId(queryRangeId);
			} else if("DEPT_ID".equals(queryRange)){
				queryParam.setRegSectionDeptId(queryRangeId);
			} else if("GR_ID".equals(queryRange)){
				queryParam.setRegSectionGrId(queryRangeId);
			}
			boolean flag = true;
			if(!"COMP_ID".equals(range)){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getIsOperator(cityId, compId, selfAreaId, selfRegId, selfDeptId, selfGrId, selfUserId, range, queryRange, queryRangeId, operQueryLevel);
				if(null == erpFunUsers){
					flag = false;
				}
			}
			if (!flag) {
				result = 2;
			} else if (queryLevel <= operQueryLevel) {
				return 0;
			}
		}
		List<ErpFunRegsectionControl> funRegsectionControlList = erpFunRegsectionControlMapper.getRegionAndSection(cityId, compId, selfDeptId);
		if(null != funRegsectionControlList && funRegsectionControlList.size() > 0){
			queryParam.setRegSectionCompId(compId);
			List<Integer[]> regSectionList = new LinkedList<>();
			Set<Integer> regFlagSet = new HashSet<>();
			for (ErpFunRegsectionControl erpFunRegsectionControl : funRegsectionControlList) {
				Integer[] regSectionArr = new Integer[] { 0, 0 };
				if (!regFlagSet.contains(erpFunRegsectionControl.getRegionId())) {
					regFlagSet.add(erpFunRegsectionControl.getRegionId());
					regSectionArr[0] = erpFunRegsectionControl.getRegionId();
				}
				if (null != erpFunRegsectionControl.getSectionId()) {
					regSectionArr[1] = erpFunRegsectionControl.getSectionId();
				}
				regSectionList.add(regSectionArr);
			}
			queryParam.setRegSectionList(regSectionList);
		}
		return result;
	}
}
