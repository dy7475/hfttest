package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetSysLoginLogsParam;
import com.myfun.erpWeb.usercenter.session.param.LoginParam;
import com.myfun.framework.session.Operator;
import com.myfun.service.business.erpdb.ErpOutLogService;
import com.myfun.utils.DateTimeHelper;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunPrologsMapper;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPrologsService;
import com.myfun.utils.StringUtil;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

@Service
public class ErpFunPrologsServiceImpl extends AbstractService<ErpFunPrologs, ErpFunPrologs> implements ErpFunPrologsService{
	@Autowired
	private ErpFunPrologsMapper erpFunPrologsMapper;//outLogService
	@Autowired
	private ErpOutLogService erpOutLogService;
	@Override
	public void setBaseMapper() {
	}

	@Override
	public PageInfo<ErpFunPrologs> getSysLoginLogs(GetSysLoginLogsParam param, Integer compId, Integer cityId) {
		param.setCompId(compId);
		param.setDeviceType(0);// 默认为erp端登陆
		if (param.getDate2() != null) {
			param.setDate2(param.getDate2() + " 23:59:59");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, cityId);
		PageInfo<ErpFunPrologs> pageInfo = new PageInfo<ErpFunPrologs>(sysLoginLogs);
		return pageInfo;
	}

	@Override
	public PageInfo<ErpFunPrologs> getAppLoginLogs(GetSysLoginLogsParam param, Integer compId, Integer cityId) {
		param.setCompId(compId);
		if (param.getDate2() != null) {
			param.setDate2(param.getDate2() + " 23:59:59");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, cityId);
		PageInfo<ErpFunPrologs> pageInfo = new PageInfo<ErpFunPrologs>(sysLoginLogs);
		return pageInfo;
	}

	@Override
	public int countModelData(Integer cityId, Date nowTime, Integer compId, Integer userId) {
		int todayLoginCount = erpFunPrologsMapper.countModelData(cityId, nowTime, compId, userId);
		return todayLoginCount;
	}
	
	@Override
	public void logout(Integer cityId, Integer prologsId, String outType) {
		erpFunPrologsMapper.logout(cityId, prologsId, outType);
	}
	
}
