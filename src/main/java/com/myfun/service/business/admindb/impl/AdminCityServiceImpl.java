package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCityService;
import com.myfun.utils.StringUtil;

/**
 * 城市
 * 
 * @author Administrator
 *
 */
@Service
public class AdminCityServiceImpl extends AbstractService<AdminFunCity, Short>implements AdminFunCityService {
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;

	@Override
	public AdminFunCity getCity(Integer cityId) {
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		return adminFunCity;
	}

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunCityMapper;
	}

	/**
	 * 查询城市列表
	 * 
	 * @cityName 城市拼音
	 * @provinceId 省份
	 */
	@Override
	public List<AdminFunCity> selectByCityAll(String cityName, Integer provinceId) {
		List<AdminFunCity> cities = adminFunCityMapper.selectByCityAll(provinceId, cityName);
		return cities;
	}

	@Override
	public List<AdminFunCity> getCityByProId(String provinceId, String cityName) {
		List<AdminFunCity> list = adminFunCityMapper.getCityByProId(provinceId, cityName);
		return list;
	}

	@Override
	public List<SelectDto> getCityAll(String inputValue) {
		List<SelectDto> list = adminFunCityMapper.getCityAll(inputValue);
		return list;
	}

	@Override
	public AdminFunCity selectByFid(Short fid) {

		return adminFunCityMapper.selectByFid(String.valueOf(fid));
	}

	@Override
	public String getCityIdNameByCompId(String compId) {
		List<SelectDto> list = adminFunCityMapper.getCityIdNameByCompId(compId);
		String name = "";
		for (SelectDto adminFunCity : list) {
			name += adminFunCity.getValue() + ",";
		}
		if (!"".equals(name)) {
			name = name.substring(0, name.length() - 1);
		}
		return name;
	}

	@Override
	public void saveCity(AdminCrmUser adminCrmUser, AdminFunCity adminFunCity) {
		adminFunCityMapper.updateByPrimaryKeySelective(adminFunCity);
	}

	@Transactional
	@Override
	public void saveBatchCity(AdminCrmUser adminCrmUser, AdminFunCity adminFunCity, String cityType, String cityIds) {
		if ("0".equals(cityType)) {
			// 更新勾选的
			String ids[] = cityIds.split(",");
			for (int i = 0; i < ids.length; i++) {
				adminFunCity.setCityId(Short.valueOf(ids[i]));
				adminFunCityMapper.updateByPrimaryKeySelective(adminFunCity);
			}
		} else if ("1".equals(cityType) || "2".equals(cityType)) {
			Integer superUser = StringUtil.parseInteger(cityType);
			adminFunCityMapper.updateBySuperUser(adminFunCity, superUser - 1);
		} else {
			// 所有城市
			adminFunCityMapper.updateAll(adminFunCity);
		}
	}

	@Override
	public List<AdminFunCity> getCitysBySuperComp() {
		return adminFunCityMapper.getCitysBySuperComp();
	}

	@Override
	public List<AdminFunCity> getCitysByNoSuperComp(Integer compId) {
		return adminFunCityMapper.getCitysByNoSuperComp(compId);
	}

	@Override
	public List<AdminFunCity> getCitys() {
		return adminFunCityMapper.getCitys();
	}

	@Override
	public List<AdminFunCity> getCitysByCompId(String crmCompId) {
		return adminFunCityMapper.getCitysByCompId(crmCompId);
	}

	/**
	 * @see com.myfun.service.business.admindb.AdminFunCityService#getCityList(Short,
	 *      String, Integer)
	 */
	@Override
	public List<AdminFunCity> getCityList(Short provinceId, String cityName, Integer limit) {
		PageHelper.startPage(1, limit == null ? Const.PAGE_NUMBER : limit);
		AdminFunCity city = new AdminFunCity();
		city.setProvinceId(provinceId);
		city.setCityName(cityName);
		return adminFunCityMapper.getCityListByNotNull(city);
	}

	@Override
	public AdminFunCity getCityByFid(String fId) {
		return adminFunCityMapper.getCityByFid(fId);
	}

}
