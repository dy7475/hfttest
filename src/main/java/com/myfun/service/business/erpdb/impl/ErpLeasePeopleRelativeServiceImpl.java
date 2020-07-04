package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpLeasePeopleRelativeMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpLeasePeopleRelative;
import com.myfun.repository.erpdb.po.ErpLeasePeopleRelativeExample;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelative;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelativeExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpLeasePeopleRelativeService;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;

@Service
public class ErpLeasePeopleRelativeServiceImpl extends AbstractService<ErpLeasePeopleRelative, ErpLeasePeopleRelative>implements ErpLeasePeopleRelativeService {

	@Autowired
	ErpLeasePeopleRelativeMapper erpLeasePeopleRelativeMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = this.erpLeasePeopleRelativeMapper;
	}

	// 房源相关人更新和清空
	@Transactional
	@Override
	public void updateErpLeasePeopleRelative(HousePeopleRelativeParam param) {
		String grName = "";
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(param.getCityId(), param.getUserId());
		ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getDeptId());
		if(null != erpFunUsers.getGrId() && 0 != erpFunUsers.getGrId()) {
			ErpFunDeptsgroup dataByGrId = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), erpFunUsers.getGrId());
			grName = dataByGrId.getGrName();
		}
		if(null == param.getDeptName()){
			param.setDeptName(funDepts.getDeptName());
		}
		if (null == param.getLeaseRelativeId()) {
			// 添加
			judgeSalePeopleRelative(param.getCityId(), param.getCaseId(), erpFunUsers.getUserId(), param.getPeopleType(), param.getLeaseRelativeId());
			ErpLeasePeopleRelative addErpLeasePeopleRelative = new ErpLeasePeopleRelative();
			addErpLeasePeopleRelative.setUserId(erpFunUsers.getUserId());
			addErpLeasePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
			addErpLeasePeopleRelative.setUserName(erpFunUsers.getUserName());
			addErpLeasePeopleRelative.setLeaseId(param.getCaseId());
			addErpLeasePeopleRelative.setCreationTime(new Date());
			addErpLeasePeopleRelative.setShardCityId(param.getCityId());
			addErpLeasePeopleRelative.setPeopleType(param.getPeopleType());
			addErpLeasePeopleRelative.setDelFlag(0);
			addErpLeasePeopleRelative.setDeptName(funDepts.getDeptName());
			addErpLeasePeopleRelative.setEntrustType(param.getEntrustType());
			addErpLeasePeopleRelative.setGrName(grName);
			addErpLeasePeopleRelative.setOrganizationId(param.getOrganizationId());
			addErpLeasePeopleRelative.setOrganizationName(param.getOrganizationName());
			erpLeasePeopleRelativeMapper.insertSelective(addErpLeasePeopleRelative);
			// 写跟进日志
			erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
		} else {
			if (param.getDelFlag() == 0) {
				// 修改
				judgeSalePeopleRelative(param.getCityId(), param.getCaseId(), erpFunUsers.getUserId(), param.getPeopleType(), param.getLeaseRelativeId());
				ErpLeasePeopleRelative erpLeasePeopleRelative = new ErpLeasePeopleRelative();
				erpLeasePeopleRelative.setId(param.getLeaseRelativeId());
				erpLeasePeopleRelative.setUserId(erpFunUsers.getUserId());
				erpLeasePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
				erpLeasePeopleRelative.setUserName(erpFunUsers.getUserName());
				erpLeasePeopleRelative.setLeaseId(param.getCaseId());
				erpLeasePeopleRelative.setUpdateTime(new Date());
				erpLeasePeopleRelative.setShardCityId(param.getCityId());
				erpLeasePeopleRelative.setDelFlag(param.getDelFlag());
				erpLeasePeopleRelative.setDeptName(funDepts.getDeptName());
				erpLeasePeopleRelative.setEntrustType(param.getEntrustType());
				erpLeasePeopleRelative.setGrName(grName);
				erpLeasePeopleRelative.setOrganizationId(param.getOrganizationId());
				erpLeasePeopleRelative.setOrganizationName(param.getOrganizationName());
				erpLeasePeopleRelativeMapper.updateByPrimaryKeySelective(erpLeasePeopleRelative);
				// 写跟进日志
				erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
			} else {
				// 删除
				ErpLeasePeopleRelative erpLeasePeopleRelative = new ErpLeasePeopleRelative();
				erpLeasePeopleRelative.setId(param.getLeaseRelativeId());
				erpLeasePeopleRelative.setShardCityId(param.getCityId());
				erpLeasePeopleRelative.setDelFlag(param.getDelFlag());
				erpLeasePeopleRelative.setDelTime(new Date());
				erpLeasePeopleRelativeMapper.updateByPrimaryKeySelective(erpLeasePeopleRelative);
				// 写跟进日志
				erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
			}
		}
	}
	
	/**
	 * 添加或修改相关人，每个分类最多5个，同一分类判重
	 */
	private void judgeSalePeopleRelative(Integer cityId, Integer caseId, Integer userId, Integer peopleType, Integer leaseRelativeId) {
		ErpLeasePeopleRelativeExample erpLeasePeopleRelativeExample = new ErpLeasePeopleRelativeExample();
		erpLeasePeopleRelativeExample.setShardCityId(cityId);
		erpLeasePeopleRelativeExample.createCriteria().andPeopleTypeEqualTo(peopleType).andLeaseIdEqualTo(caseId).andDelFlagEqualTo(0);
		List<ErpLeasePeopleRelative> erpLeasePeopleRelativeList = erpLeasePeopleRelativeMapper.selectByExample(erpLeasePeopleRelativeExample);
		if (null == leaseRelativeId) {
			Assert.isTrueThrow(erpLeasePeopleRelativeList.size() >= 5, "可选人数已达上限");
		}
		erpLeasePeopleRelativeList.stream().forEach(a -> {
			Assert.isTrueThrow(userId.equals(a.getUserId()), "不可重复选择房源相关人");
		});
	}

	@Override
	public void insertLeasePeopleRelative(Integer cityId, Integer caseId, Integer userId, Integer houseRelativeType, String entrustType) {
		ErpLeasePeopleRelative erpLeasePeopleRelative = erpLeasePeopleRelativeMapper.getErpLeasePeopleRelativeByCaseIdAndHouseType(cityId, caseId, houseRelativeType);
		if (erpLeasePeopleRelative == null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			ErpLeasePeopleRelative addErpLeasePeopleRelative = new ErpLeasePeopleRelative();
			addErpLeasePeopleRelative.setEntrustType(StringUtil.parseInteger(entrustType, null));
			addErpLeasePeopleRelative.setUserId(erpFunUsers.getUserId());
			addErpLeasePeopleRelative.setUserName(erpFunUsers.getUserName());
			addErpLeasePeopleRelative.setLeaseId(caseId);
			addErpLeasePeopleRelative.setPeopleType(houseRelativeType);
			addErpLeasePeopleRelative.setCreationTime(new Date());
			addErpLeasePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
			addErpLeasePeopleRelative.setDelFlag(0);
			addErpLeasePeopleRelative.setDeptName(erpFunDepts.getDeptName());
			addErpLeasePeopleRelative.setShardCityId(cityId);
			erpLeasePeopleRelativeMapper.insertSelective(addErpLeasePeopleRelative);
		}
	}

	/**
	 * 转私盘时变更租维护人
	 * @author 朱科
	 * @since 2018/4/19
	 */
	@Transactional
	@Override
	public void privatePlateUpdatePeopleRelative(Integer cityId, Integer leaseId, Integer userId, String userName,
			String userMobile, String deptName) {
		ErpLeasePeopleRelative erpLeasePeopleRelative = new ErpLeasePeopleRelative();
		erpLeasePeopleRelative.setUserId(userId);
		erpLeasePeopleRelative.setUserName(userName);
		erpLeasePeopleRelative.setLeaseId(leaseId);
		erpLeasePeopleRelative.setPeopleType(2);
		erpLeasePeopleRelative.setCreationTime(new Date());
		erpLeasePeopleRelative.setUserMobile(userMobile);
		erpLeasePeopleRelative.setDelFlag(0);
		erpLeasePeopleRelative.setShardCityId(cityId);
		if (null != deptName) {
			erpLeasePeopleRelative.setDeptName(deptName);
		} else {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			erpLeasePeopleRelative.setDeptName(erpFunDepts.getDeptName());
		}
		erpLeasePeopleRelativeMapper.insertSelective(erpLeasePeopleRelative);
	}
	
	/**
	 * 转出租时变更租维护人、租登记人
	 * @author 朱科
	 * @since 2018/5/4
	 */
	@Transactional
	@Override
	public void transLeaseUpdateRegisterPeopleRelative(Integer cityId, Integer leaseId, Integer userId, String userName,
			String userMobile, String deptName) {
		// 有登记人，先删除登记人
		ErpLeasePeopleRelative erpSalePeopleRelative = erpLeasePeopleRelativeMapper.getErpLeasePeopleRelativeByCaseIdAndHouseType(cityId, leaseId, 1);
		if (null != erpSalePeopleRelative && erpSalePeopleRelative.getDelFlag() == 0 && null != erpSalePeopleRelative.getId()) {
			ErpLeasePeopleRelative updateModel = new ErpLeasePeopleRelative();
			updateModel.setId(erpSalePeopleRelative.getId());
			updateModel.setDelFlag(1);
			updateModel.setShardCityId(cityId);
			erpLeasePeopleRelativeMapper.updateByPrimaryKeySelective(updateModel);
		}
		ErpLeasePeopleRelative insertRelative = new ErpLeasePeopleRelative();
		insertRelative.setUserId(userId);
		insertRelative.setUserName(userName);
		insertRelative.setLeaseId(leaseId);
		insertRelative.setPeopleType(1);
		insertRelative.setCreationTime(new Date());
		insertRelative.setUserMobile(userMobile);
		insertRelative.setDelFlag(0);
		insertRelative.setShardCityId(cityId);
		if (StringUtil.isBlank(deptName)) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			deptName = erpFunDepts.getDeptName();
		}
		insertRelative.setDeptName(deptName);
		erpLeasePeopleRelativeMapper.insertSelective(insertRelative);
		// 有售维护人、先删除售维护人
		ErpLeasePeopleRelative maintainSalePeopleRelative = erpLeasePeopleRelativeMapper.getErpLeasePeopleRelativeByCaseIdAndHouseType(cityId, leaseId, 2);
		if (null != maintainSalePeopleRelative && maintainSalePeopleRelative.getDelFlag() == 0 && null != maintainSalePeopleRelative.getId()) {
			ErpLeasePeopleRelative updateModel = new ErpLeasePeopleRelative();
			updateModel.setId(maintainSalePeopleRelative.getId());
			updateModel.setDelFlag(1);
			updateModel.setShardCityId(cityId);
			erpLeasePeopleRelativeMapper.updateByPrimaryKeySelective(updateModel);
		}
		insertRelative.setId(null);
		insertRelative.setPeopleType(2);
		erpLeasePeopleRelativeMapper.insertSelective(insertRelative);
	}
}



