package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.ErpAccountMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceFestivalMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceUserClassDetailMapper;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.param.AttendanceBaseInfo;
import com.myfun.repository.erpdb.param.ErpFunAttendanceClassParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunAttendanceClassExample.Criteria;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAccountService;
import com.myfun.service.business.erpdb.ErpFunAttendanceClassService;
import com.myfun.utils.DateTimeHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunAttendanceClassServiceImpl extends AbstractService<ErpFunAttendanceClass, ErpFunAttendanceClass>
		implements ErpFunAttendanceClassService {

	@Autowired
	ErpFunAttendanceClassMapper erpFunAttendanceClassMapper;
	@Autowired
	ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	ErpFunAttendanceGroupMapper erpFunAttendanceGroupMapper;
	@Autowired
	ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	ErpFunAttendanceFestivalMapper erpFunAttendanceFestivalMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceClassMapper;
	}

	/**
	 * @Title 新增编辑班次
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param erpFunAttendanceClassParam 班次对象
	 **/
	@Transactional
	@Override
	public Integer addEditAttendance(Integer cityId, Integer compId, Integer deptId, ErpFunAttendanceClassParam erpFunAttendanceClassParam) {
		Integer res = 0;
		// 判断名字重复
		ErpFunAttendanceClassExample erpFunAttendanceClassExample = new ErpFunAttendanceClassExample();
		ErpFunAttendanceClassExample.Criteria criteria = erpFunAttendanceClassExample.createCriteria();
		criteria.andClassNameEqualTo(erpFunAttendanceClassParam.getClassName()).andDelFlagEqualTo((byte )0).andDeptIdEqualTo(deptId);
		if(null != erpFunAttendanceClassParam.getId()) {
			criteria.andIdNotEqualTo(erpFunAttendanceClassParam.getId());
		}
		erpFunAttendanceClassExample.setShardCityId(cityId);
		int i = erpFunAttendanceClassMapper.countByExample(erpFunAttendanceClassExample);
		if(i > 0) {
			throw new BusinessException("班次名称不能重复");
		}
		erpFunAttendanceClassParam.setShardCityId(cityId);
		if (null != erpFunAttendanceClassParam.getId()) {
			res = erpFunAttendanceClassMapper.updateByPrimaryKeySelective(erpFunAttendanceClassParam);
		} else {
			erpFunAttendanceClassParam.setCompId(compId);
			erpFunAttendanceClassParam.setCreateTime(new Date());
			erpFunAttendanceClassParam.setDeptId(deptId);
			erpFunAttendanceClassMapper.insertSelective(erpFunAttendanceClassParam);
			res = erpFunAttendanceClassParam.getId();
		}
		return res;
	}

	/**
	 * @Title 删除班次
	 * @Author lcb
	 * @Date 2017/11/23
	 * @Param
	 **/
	@Override
	public Integer delAttendanceClass(Integer cityId, Integer compId,ErpFunAttendanceClassParam erpFunAttendanceClassParam) {

		// 判断是否有人应用次班次
		ErpFunAttendanceClass erpFunAttendanceClass = new ErpFunAttendanceClass();
		erpFunAttendanceClass.setShardCityId(cityId);
		erpFunAttendanceClass.setId(erpFunAttendanceClassParam.getId());
		erpFunAttendanceClass.setDelFlag((byte) 1);
		Integer resCount = erpFunAttendanceClassMapper.updateByPrimaryKeySelective(erpFunAttendanceClass);
		return resCount;
	}

}
