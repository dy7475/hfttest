package com.myfun.service.business.admindb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminJrFinanceInfoMapper;
import com.myfun.repository.admindb.param.EditOrCreateFnanceRecordParam;
import com.myfun.repository.admindb.po.AdminJrFinanceInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminJrFinanceInfoService;
import com.myfun.utils.BeanUtil;
@Service
public class AdminJrFinanceInfoServiceImpl extends AbstractService<AdminJrFinanceInfo, Integer> implements AdminJrFinanceInfoService{
	@Autowired AdminJrFinanceInfoMapper adminJrFinanceInfoMapper;
	
	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminJrFinanceInfoMapper;
	}

	@Override
	public List<String> insertOrEditFinanceRecord(EditOrCreateFnanceRecordParam param, Map<String, Object> pMap) {
		String photoIds = param.getPhotoIds();
		AdminJrFinanceInfo model = (AdminJrFinanceInfo) param;
		pMap.putAll(BeanUtil.objToKeyMap(model));
		String financeInfoId = "";
		// 修改
		if (model.getId()!=null) {
			financeInfoId = model.getId().toString();
		}
		List<String> returnList = new ArrayList<String>();
		return null;
	}

}
