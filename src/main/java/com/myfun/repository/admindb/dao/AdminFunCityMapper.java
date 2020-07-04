package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunCityExample;

public interface AdminFunCityMapper extends BaseMapper<AdminFunCity, Short> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunCityExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunCityExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunCity> selectByExample(AdminFunCityExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunCity record, @Param("example") AdminFunCityExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunCity record, @Param("example") AdminFunCityExample example);

	List<AdminFunCity> selectByCityAll(@Param("provinceId") Integer provinceId, @Param("pyCode") String pyCode);

	/**
	 * 查询每个省下面的城市信息
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<AdminFunCity> getCityByProId(@Param("provinceId")String provinceId, @Param("cityName")String cityName);

	/**
	 * 查询全部城市信息
	 * 
	 * @return
	 */
	public List<SelectDto> getCityAll(@Param("inputValue") String inputValue);

	/**
	 * 根据fid查询对象信息
	 * 
	 * @param fid
	 * @return
	 */
	public AdminFunCity selectByFid(String fid);

	List<SelectDto> getCityIdNameByCompId(String compId);

	/**
	 * 城市控制列表查询
	 * 
	 * @param adminFunCity
	 * @return
	 */
	List<AdminFunCity> getRecords(@Param("provinceId")Short provinceId, @Param("compId") Integer compId, @Param("isSuperComp") boolean isSuperComp);

	void updateBySuperUser(@Param("adminFunCity") AdminFunCity adminFunCity, @Param("superuser") int superuser);

	void updateAll(AdminFunCity adminFunCity);

	List<AdminFunCity> getCitysBySuperComp();

	List<AdminFunCity> getCitysByNoSuperComp(Integer compId);

	/**
	 * 查询全部城市
	 * 
	 * @return
	 */
	List<AdminFunCity> getCitys();

	/**
	 * 根据公司查询城市
	 * 
	 * @param crmCompId
	 * @return
	 */
	List<AdminFunCity> getCitysByCompId(String crmCompId);

	List<AdminFunCity> getCityListByNotNull(AdminFunCity city);
	
	/**
	 * 腾讯库城市转化
	 * @param fId
	 * @return
	 */
	AdminFunCity getCityByFid(@Param("fId")String fId);

	AdminFunCity selectCitybyCityName(@Param("cityName")String cityName);
	/**
	 * 根据省份id,查询该省份下的所有城市(城市ID,城市名称)
	 * @author 何传强
	 * @since 2017年6月19日
	 * @param provinceId
	 * @return
	 */
	List<AdminFunCity> getCityByProviceId(@Param("provinceId")Integer provinceId);
	
	/**
	 * 根据城市ID获取城市数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	AdminFunCity getDataByCityId(@Param("cityId")Integer cityId);
}