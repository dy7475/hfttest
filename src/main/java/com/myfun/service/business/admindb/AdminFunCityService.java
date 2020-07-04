package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.param.ProvinceParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunCityService extends BaseMapper<AdminFunCity, Short> {

	/**
	 * 跟进id查询城市
	 * 
	 * @param cityId
	 * @return
	 */
	public AdminFunCity getCity(Integer cityId);

	/**
	 * 条件查询城市列表
	 * 
	 * @param cityName
	 * @param provinceId
	 * @return
	 */
	public List<AdminFunCity> selectByCityAll(String cityName, Integer provinceId);

	/**
	 * 查询省份下面的城市信息
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<AdminFunCity> getCityByProId(String provinceId, String cityName);

	/**
	 * 查询全部城市列表
	 * 
	 * @return
	 */
	public List<SelectDto> getCityAll(String inputValue);

	/**
	 * 根据Fid查询实体对象
	 * 
	 * @param valueOf
	 * @return
	 */
	public AdminFunCity selectByFid(Short valueOf);

	/**
	 * 区域管理中城市名称转化
	 * 
	 * @param compId
	 * @return
	 */
	public String getCityIdNameByCompId(String compId);

	public void saveCity(AdminCrmUser adminCrmUser, AdminFunCity adminFunCity);

	public void saveBatchCity(AdminCrmUser adminCrmUser, AdminFunCity adminFunCity, String cityType, String ids);

	public List<AdminFunCity> getCitysBySuperComp();

	public List<AdminFunCity> getCitysByNoSuperComp(Integer compId);

	/**
	 * 查询全部城市
	 * 
	 * @return
	 */
	public List<AdminFunCity> getCitys();

	/**
	 * 根据公司查询城市
	 * 
	 * @param crmCompId
	 * @return
	 */
	public List<AdminFunCity> getCitysByCompId(String crmCompId);

	/**
	 * jquery自动完成插件调用
	 * 
	 * @param provinceId
	 *            省份
	 * @param cityName
	 *            输入名称 -城市名称 或者城市简称
	 * @param limit
	 *            查询条数
	 * @return
	 */
	public List<AdminFunCity> getCityList(Short provinceId, String cityName, Integer limit);
	
	/**
	 * 腾讯城市查询转化
	 * @param fId
	 * @return
	 */
	public AdminFunCity getCityByFid(String fId);
}
