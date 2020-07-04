package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeService;
import com.myfun.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunAttendanceScopeServiceImpl extends AbstractService<ErpFunAttendanceScope, ErpFunAttendanceScope> implements ErpFunAttendanceScopeService {

	@Autowired
	private ErpFunAttendanceScopeMapper erpFunAttendanceScopeMapper;
	@Autowired
	private ErpFunAttendanceScopeBizMapper erpFunAttendanceScopeBizMapper;
	@Autowired
	private ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceScopeMapper;
	}

	@Transactional
	@Override
	public Integer addEditDetail(Integer cityId, Integer compId, Integer deptId, ErpAttendanceScopeParam erpAttendanceScopeParam) {

		// 判断是编辑还是新增
		Integer attScopeId = erpAttendanceScopeParam.getAttScopeId();

		if(null != attScopeId ) {
			erpAttendanceScopeParam.setShardCityId(cityId);
			erpFunAttendanceScopeMapper.updateByPrimaryKeySelective(erpAttendanceScopeParam);
			if(null != erpAttendanceScopeParam.getIsUpdateUser() && 1 == erpAttendanceScopeParam.getIsUpdateUser().intValue()) {
				editAttendanceScope(cityId, compId, attScopeId, erpAttendanceScopeParam);
			}
		}else {
			attScopeId = addAttendanceScope(cityId, compId, deptId, erpAttendanceScopeParam);
		}
		return attScopeId;
	}

	/**
	 * @Title 新增考勤地址
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param 
	 **/
	private Integer addAttendanceScope(Integer cityId, Integer compId, Integer deptId, ErpAttendanceScopeParam erpAttendanceScopeParam) {
		erpAttendanceScopeParam.setShardCityId(cityId);
		erpAttendanceScopeParam.setCreateTime(new Date());
		erpAttendanceScopeParam.setCompId(compId);
		erpAttendanceScopeParam.setCalDel((byte) 1);
		erpAttendanceScopeParam.setDeptId(deptId);
		if (StringUtil.isBlank(erpAttendanceScopeParam.getAttScopeX()) || StringUtil.isBlank(erpAttendanceScopeParam.getAttScopeY())) {
			throw new BusinessException("获取定位失败，请联系在线客服");
		}
		erpFunAttendanceScopeMapper.insertSelective(erpAttendanceScopeParam);

		Integer attScopeId = erpAttendanceScopeParam.getAttScopeId();
		addBizAndBizPerson(cityId, compId, attScopeId, erpAttendanceScopeParam);
		return erpAttendanceScopeParam.getAttScopeId();
	}

	private void addBizAndBizPerson(Integer cityId, Integer compId, Integer attScopeId, ErpAttendanceScopeParam erpAttendanceScopeParam) {

		// 写关联关系
		String attdanceScopeBizList = erpAttendanceScopeParam.getAttdanceScopeBizList();
		List<ErpFunAttendanceScopeBiz> erpFunAttendanceScopeBizs = JSON.parseObject(attdanceScopeBizList, new TypeReference<List<ErpFunAttendanceScopeBiz>>() {});

		if (erpFunAttendanceScopeBizs.size() > 0) {
			for (ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz : erpFunAttendanceScopeBizs) {
				// 写入关联组织机构关系
				erpFunAttendanceScopeBiz.setAttScopeId(attScopeId);
				erpFunAttendanceScopeBiz.setCompId(compId);
				erpFunAttendanceScopeBiz.setShardCityId(cityId);
				erpFunAttendanceScopeBizMapper.insertSelective(erpFunAttendanceScopeBiz);

				// 判断关联类型来组装个人详细数据
				Integer chooseType = erpFunAttendanceScopeBiz.getChooseType();
				List<ErpFunUsers> erpFunUsersList = new ArrayList<>();
				if(3 == chooseType) {
					ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunAttendanceScopeBiz.getBizId());
					erpFunUsersList.add(erpFunUsers);
				}else {
					OrganizationDefinitionVO organizationManagerVO = erpFunOrganizationDefinitionMapper.selectOrganizationDefVO(cityId, erpFunAttendanceScopeBiz.getBizId());
					erpFunUsersList = erpFunUsersMapper.getUserListByScopeType(cityId, compId, organizationManagerVO.getMappingDbField(), erpFunAttendanceScopeBiz.getBizId());
				}
				if (erpFunUsersList.size() == 0) {
					continue;
				}

				// 批量添加关联详细人
				erpFunAttendanceScopeBizPersonMapper.insertBatch(cityId, erpFunUsersList, attScopeId, erpFunAttendanceScopeBiz.getId());
			}
		}

	}

	/**
	 * @Title 删除考勤地点
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param
	 **/
	@Override
	public Integer delAttendanceScope(Integer cityId, Integer compId, ErpAttendanceScopeParam erpAttendanceScopeParam) {
		Integer res = 0;
		// 先删除以前的关联关系
		ErpFunAttendanceScope erpFunAttendanceScope = new ErpFunAttendanceScope();
		erpFunAttendanceScope.setShardCityId(cityId);
		erpFunAttendanceScope.setAttScopeId(erpAttendanceScopeParam.getAttScopeId());
		erpFunAttendanceScope = erpFunAttendanceScopeMapper.selectByPrimaryKey(erpFunAttendanceScope);
		erpFunAttendanceScope.setShardCityId(cityId);
		if(null == erpFunAttendanceScope) {
			throw new BusinessException("删除失败,请检查数据");
		}

		if(0 == erpFunAttendanceScope.getCalDel().intValue()) {
			throw new BusinessException("系统默认考勤地点，无法删除");
		}

		ErpFunAttendanceScopeBizPersonExample erpFunAttendanceScopeBizPersonExample = new ErpFunAttendanceScopeBizPersonExample();
		erpFunAttendanceScopeBizPersonExample.setShardCityId(cityId);
		erpFunAttendanceScopeBizPersonExample.createCriteria().andAttScopeIdEqualTo(erpAttendanceScopeParam.getAttScopeId()).andIsDelEqualTo((byte)0);

		Integer count = erpFunAttendanceScopeBizPersonMapper.countByExample(erpFunAttendanceScopeBizPersonExample);
		if(count > 0) {
			throw new BusinessException("当前考勤地点正在使用中,无法删除");
		}

		erpFunAttendanceScope.setIsDel((byte)1);
		res = erpFunAttendanceScopeMapper.updateByPrimaryKeySelective(erpFunAttendanceScope);

//		ErpFunAttendanceScopeBizExample erpFunAttendanceScopeBizExample = new ErpFunAttendanceScopeBizExample();
//		erpFunAttendanceScopeBizExample.setShardCityId(cityId);
//		erpFunAttendanceScopeBizExample.createCriteria().andAttScopeIdEqualTo(erpAttendanceScopeParam.getAttScopeId());
//		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz = new ErpFunAttendanceScopeBiz();
//		erpFunAttendanceScopeBiz.setIsDel((byte) 1);
//		erpFunAttendanceScopeBizMapper.updateByExampleSelective(erpFunAttendanceScopeBiz, erpFunAttendanceScopeBizExample);
//
//		ErpFunAttendanceScopeBizPersonExample erpFunAttendanceScopeBizPersonExample = new ErpFunAttendanceScopeBizPersonExample();
//		erpFunAttendanceScopeBizPersonExample.setShardCityId(cityId);
//		erpFunAttendanceScopeBizPersonExample.createCriteria().andAttScopeIdEqualTo(erpAttendanceScopeParam.getAttScopeId());
//		ErpFunAttendanceScopeBizPerson erpFunAttendanceScopeBizPerson = new ErpFunAttendanceScopeBizPerson();
//		erpFunAttendanceScopeBizPerson.setIsDel((byte) 1);
//		erpFunAttendanceScopeBizPersonMapper.updateByExampleSelective(erpFunAttendanceScopeBizPerson, erpFunAttendanceScopeBizPersonExample);
		return res;

	}

	/**
	 * @Title 编辑考勤地址
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param
	 **/
	private void editAttendanceScope(Integer cityId, Integer compId, Integer attScopeId, ErpAttendanceScopeParam erpAttendanceScopeParam) {
		// 先删除以前的关联关系
		ErpFunAttendanceScopeBizExample erpFunAttendanceScopeBizExample = new ErpFunAttendanceScopeBizExample();
		erpFunAttendanceScopeBizExample.setShardCityId(cityId);
		erpFunAttendanceScopeBizExample.createCriteria().andAttScopeIdEqualTo(attScopeId);
		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBiz = new ErpFunAttendanceScopeBiz();
		erpFunAttendanceScopeBiz.setIsDel((byte) 1);
		erpFunAttendanceScopeBizMapper.updateByExampleSelective(erpFunAttendanceScopeBiz, erpFunAttendanceScopeBizExample);

		ErpFunAttendanceScopeBizPersonExample erpFunAttendanceScopeBizPersonExample = new ErpFunAttendanceScopeBizPersonExample();
		erpFunAttendanceScopeBizPersonExample.setShardCityId(cityId);
		erpFunAttendanceScopeBizPersonExample.createCriteria().andAttScopeIdEqualTo(attScopeId);
		ErpFunAttendanceScopeBizPerson erpFunAttendanceScopeBizPerson = new ErpFunAttendanceScopeBizPerson();
		erpFunAttendanceScopeBizPerson.setIsDel((byte) 1);
		erpFunAttendanceScopeBizPersonMapper.updateByExampleSelective(erpFunAttendanceScopeBizPerson, erpFunAttendanceScopeBizPersonExample);

		ErpFunAttendanceScope erpFunAttendanceScope = new ErpFunAttendanceScope();
		BeanUtils.copyProperties(erpAttendanceScopeParam, erpFunAttendanceScope);
		erpFunAttendanceScope.setShardCityId(cityId);
		if (StringUtil.isBlank(erpAttendanceScopeParam.getAttScopeX()) || StringUtil.isBlank(erpAttendanceScopeParam.getAttScopeY())) {
			throw new BusinessException("获取定位失败，请联系在线客服");
		}
		erpFunAttendanceScopeMapper.updateByPrimaryKeySelective(erpFunAttendanceScope);

		attScopeId = erpFunAttendanceScope.getAttScopeId();
		// 写关联关系
		addBizAndBizPerson(cityId, compId, attScopeId, erpAttendanceScopeParam);

	}

}
