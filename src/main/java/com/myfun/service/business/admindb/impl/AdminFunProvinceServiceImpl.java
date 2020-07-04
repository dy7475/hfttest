package com.myfun.service.business.admindb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunProvinceMapper;
import com.myfun.repository.admindb.po.AdminFunProvince;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunProvinceService;

/**
 * 省份
 * @author Administrator
 *
 */
@Service
public class AdminFunProvinceServiceImpl extends AbstractService<AdminFunProvince, Short> implements AdminFunProvinceService {
	@Autowired
	private AdminFunProvinceMapper adminFunProvinceMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunProvinceMapper;
	}

	@Override
	public AdminFunProvince getAdminFunProvince(String provinceId) {
		return adminFunProvinceMapper.selectByPrimaryKey(Short.parseShort(provinceId));
	}

	/**
	 * 查询省份列表
	 * @param pageNumber
	 * @return
	 */
	@Override
	public List<AdminFunProvince> selectByProvinceAll(String provinceName) {
		List<AdminFunProvince> provinces = adminFunProvinceMapper.selectByProvinceAll(provinceName);
		return provinces;
	}

	@Override
	public List<AdminFunProvince> getProvinceAll(String proviceName) {
		List<AdminFunProvince> list = adminFunProvinceMapper.getProvinceAll(proviceName);
		return list;
	}

}
