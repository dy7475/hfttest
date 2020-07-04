package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.extension.framework.web.ExceptionResolver.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelative;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelativeExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSalePeopleRelativeService;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;

@Service
public class ErpSalePeopleRelativeServiceImpl extends AbstractService<ErpSalePeopleRelative, ErpSalePeopleRelative>implements ErpSalePeopleRelativeService {
	@Autowired ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = this.erpSalePeopleRelativeMapper;
	}
	
	/**
	 * 房源相关人的增删改
	 * @author 熊刚
	 * @since 2017年9月8日
	 * @param param	 */
	@Transactional
	@Override
	public void updateHousePeopleRelative(HousePeopleRelativeParam param) {
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
		if (null == param.getSaleRelativeId()) {
			// 添加
			judgeSalePeopleRelative(param.getCityId(), param.getCaseId(), erpFunUsers.getUserId(), param.getPeopleType(), param.getSaleRelativeId());
			ErpSalePeopleRelative addErpSalePeopleRelative = new ErpSalePeopleRelative();
			addErpSalePeopleRelative.setUserId(erpFunUsers.getUserId());
			addErpSalePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
			addErpSalePeopleRelative.setUserName(erpFunUsers.getUserName());
			addErpSalePeopleRelative.setCreationTime(new Date());
			addErpSalePeopleRelative.setShardCityId(param.getCityId());
			addErpSalePeopleRelative.setPeopleType(param.getPeopleType());
			addErpSalePeopleRelative.setSaleId(param.getCaseId());
			addErpSalePeopleRelative.setDelFlag(0);
			addErpSalePeopleRelative.setDeptName(funDepts.getDeptName());
			addErpSalePeopleRelative.setEntrustType(param.getEntrustType());
			addErpSalePeopleRelative.setGrName(grName);
			addErpSalePeopleRelative.setOrganizationId(param.getOrganizationId());
			addErpSalePeopleRelative.setOrganizationName(param.getOrganizationName());
			erpSalePeopleRelativeMapper.insertSelective(addErpSalePeopleRelative);
			// 写跟进日志
			erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
		} else {
			if (param.getDelFlag() == 0) {
				// 修改
				judgeSalePeopleRelative(param.getCityId(), param.getCaseId(), erpFunUsers.getUserId(), param.getPeopleType(), param.getSaleRelativeId());
				ErpSalePeopleRelative erpSalePeopleRelative = new ErpSalePeopleRelative();
				erpSalePeopleRelative.setId(param.getSaleRelativeId());
				erpSalePeopleRelative.setUserId(erpFunUsers.getUserId());
				erpSalePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
				erpSalePeopleRelative.setUserName(erpFunUsers.getUserName());
				erpSalePeopleRelative.setUpdateTime(new Date());
				erpSalePeopleRelative.setShardCityId(param.getCityId());
				erpSalePeopleRelative.setDelFlag(param.getDelFlag());
				erpSalePeopleRelative.setDeptName(funDepts.getDeptName());
				erpSalePeopleRelative.setEntrustType(param.getEntrustType());
				erpSalePeopleRelative.setGrName(grName);
				erpSalePeopleRelative.setOrganizationId(param.getOrganizationId());
				erpSalePeopleRelative.setOrganizationName(param.getOrganizationName());
				erpSalePeopleRelativeMapper.updateByPrimaryKeySelective(erpSalePeopleRelative);
				// 写跟进日志
				erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
			} else {
				// 删除
				ErpSalePeopleRelative erpSalePeopleRelative = new ErpSalePeopleRelative();
				erpSalePeopleRelative.setDelFlag(param.getDelFlag());
				erpSalePeopleRelative.setId(param.getSaleRelativeId());
				erpSalePeopleRelative.setShardCityId(param.getCityId());
				erpSalePeopleRelative.setDelTime(new Date());
				erpSalePeopleRelativeMapper.updateByPrimaryKeySelective(erpSalePeopleRelative);
				// 写跟进日志
				erpFunTrackService.insertHousePeopleRelativeTrack(param, erpFunUsers);
			}
		}
	}
	
	/**
	 * 添加或修改相关人，每个分类最多5个，同一分类判重
	 */
	private void judgeSalePeopleRelative(Integer cityId, Integer caseId, Integer userId, Integer peopleType, Integer saleRelativeId) {
		ErpSalePeopleRelativeExample erpSalePeopleRelativeExample = new ErpSalePeopleRelativeExample();
		erpSalePeopleRelativeExample.setShardCityId(cityId);
		erpSalePeopleRelativeExample.createCriteria().andPeopleTypeEqualTo(peopleType).andSaleIdEqualTo(caseId).andDelFlagEqualTo(0);
		List<ErpSalePeopleRelative> erpSalePeopleRelativeList = erpSalePeopleRelativeMapper.selectByExample(erpSalePeopleRelativeExample);
		if (null == saleRelativeId) {
			Assert.isTrueThrow(erpSalePeopleRelativeList.size() >= 5, "可选人数已达上限");
		}
		erpSalePeopleRelativeList.stream().forEach(a -> {
			Assert.isTrueThrow(userId.equals(a.getUserId()), "不可重复选择房源相关人");
		});
	}
	
	/**
	 * 创建房源相关人
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param cityId
	 * @param caseId
	 * @param userId
	 * @param houseRelativeType
	 * @param entrustType
	 */
	@Override
	public void insertSalePeopleRelative(Integer cityId,Integer caseId, Integer userId, Integer houseRelativeType, String entrustType) {
		ErpSalePeopleRelative erpSalePeopleRelative = erpSalePeopleRelativeMapper.getErpSalePeopleRelativeByCaseIdAndHouseType(cityId, caseId, houseRelativeType);
		if (erpSalePeopleRelative == null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			ErpSalePeopleRelative addErpSalePeopleRelative = new ErpSalePeopleRelative();
			addErpSalePeopleRelative.setEntrustType(StringUtil.parseInteger(entrustType, null));
			addErpSalePeopleRelative.setUserId(erpFunUsers.getUserId());
			addErpSalePeopleRelative.setUserName(erpFunUsers.getUserName());
			addErpSalePeopleRelative.setSaleId(caseId);
			addErpSalePeopleRelative.setPeopleType(houseRelativeType);
			addErpSalePeopleRelative.setCreationTime(new Date());
			addErpSalePeopleRelative.setUserMobile(erpFunUsers.getUserMobile());
			addErpSalePeopleRelative.setDelFlag(0);
			addErpSalePeopleRelative.setDeptName(erpFunDepts.getDeptName());
			addErpSalePeopleRelative.setShardCityId(cityId);
			erpSalePeopleRelativeMapper.insertSelective(addErpSalePeopleRelative);
		}
	}

	/**
	 * 转私盘时变更售维护人
	 * @author 朱科
	 * @since 2018/4/19
	 */
	@Transactional
	@Override
	public void privatePlateUpdatePeopleRelative(Integer cityId, Integer saleId, Integer userId, String userName,
			String userMobile, String deptName) {
		
		ErpSalePeopleRelative erpSalePeopleRelative = new ErpSalePeopleRelative();
		erpSalePeopleRelative.setUserId(userId);
		erpSalePeopleRelative.setUserName(userName);
		erpSalePeopleRelative.setSaleId(saleId);
		erpSalePeopleRelative.setPeopleType(2);
		erpSalePeopleRelative.setCreationTime(new Date());
		erpSalePeopleRelative.setUserMobile(userMobile);
		erpSalePeopleRelative.setDelFlag(0);
		erpSalePeopleRelative.setShardCityId(cityId);
		if(null != deptName){
			erpSalePeopleRelative.setDeptName(deptName);
		}else{
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			erpSalePeopleRelative.setDeptName(erpFunDepts.getDeptName());
		}
		erpSalePeopleRelativeMapper.insertSelective(erpSalePeopleRelative);
	}
	
	/**
	 * 转出售时变更售登记人、变更售维护人
	 * @author 朱科
	 * @since 2018/5/4
	 */
	@Transactional
	@Override
	public void transSaleUpdateRegisterPeopleRelative(Integer cityId, Integer saleId, Integer userId, String userName,
			String userMobile, String deptName) {
		// 有登记人，先删除登记人
		ErpSalePeopleRelative erpSalePeopleRelative = erpSalePeopleRelativeMapper.getErpSalePeopleRelativeByCaseIdAndHouseType(cityId, saleId, 1);
		if(null != erpSalePeopleRelative && erpSalePeopleRelative.getDelFlag() == 0 && null != erpSalePeopleRelative.getId()){
			ErpSalePeopleRelative updateModel = new ErpSalePeopleRelative();
			updateModel.setId(erpSalePeopleRelative.getId());
			updateModel.setDelFlag(1);
			updateModel.setShardCityId(cityId);
			erpSalePeopleRelativeMapper.updateByPrimaryKeySelective(updateModel);
		}
		ErpSalePeopleRelative insertRelative = new ErpSalePeopleRelative();
		insertRelative.setUserId(userId);
		insertRelative.setUserName(userName);
		insertRelative.setSaleId(saleId);
		insertRelative.setPeopleType(1);
		insertRelative.setCreationTime(new Date());
		insertRelative.setUserMobile(userMobile);
		insertRelative.setDelFlag(0);
		insertRelative.setShardCityId(cityId);
		if(StringUtil.isBlank(deptName)){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			deptName = erpFunDepts.getDeptName();
		}
		insertRelative.setDeptName(deptName);
		erpSalePeopleRelativeMapper.insertSelective(insertRelative);
		// 有售维护人、先删除售维护人
		ErpSalePeopleRelative maintainSalePeopleRelative = erpSalePeopleRelativeMapper.getErpSalePeopleRelativeByCaseIdAndHouseType(cityId, saleId, 2);
		if(null != maintainSalePeopleRelative && maintainSalePeopleRelative.getDelFlag() == 0 && null != maintainSalePeopleRelative.getId()){
			ErpSalePeopleRelative updateModel = new ErpSalePeopleRelative();
			updateModel.setId(maintainSalePeopleRelative.getId());
			updateModel.setDelFlag(1);
			updateModel.setShardCityId(cityId);
			erpSalePeopleRelativeMapper.updateByPrimaryKeySelective(updateModel);
		}
		insertRelative.setId(null);
		insertRelative.setPeopleType(2);
		erpSalePeopleRelativeMapper.insertSelective(insertRelative);
	}
}