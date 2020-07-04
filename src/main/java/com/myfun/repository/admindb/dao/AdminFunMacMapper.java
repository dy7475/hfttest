package com.myfun.repository.admindb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminFunMacDto;
import com.myfun.repository.admindb.po.AdminFunMac;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunMacExample;
import java.util.List;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface AdminFunMacMapper extends BaseMapper<AdminFunMac, String> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunMacExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunMacExample example);
	/**
	 * @mbggenerated
	 */
	List<AdminFunMac> selectByExample(AdminFunMacExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunMac record, @Param("example") AdminFunMacExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunMac record, @Param("example") AdminFunMacExample example);
	AdminFunMacDto getCompInfoByMacAddr(String macAddr);
	/**
	 * 删除门店mac
	 * @param deptId
	 */
	void deleteByDeptId(Integer deptId);
	
	/**
	 * 删除公司的漫游信息
	 * @param compId
	 */
	void updateRecordsBycompId(Integer compId);
	
	void updateMacInfoByMacAddr(@Param("shardCityId") Integer cityId, @Param("roam") Integer roam,
			@Param("roamUser") Integer roamUser, @Param("macaddr") String macaddr);
	
	void deleteByMacAddr(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	void updateFunMacLoginStatusOrReg(@Param("param") Map<String, Object> param);
	
	/**
	 * 通过MacAddr查询
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return
	 *
	 */
	AdminFunMac selectByMacAddr(@Param("shardCityId")Integer cityId,@Param("macAddr")String macAddr);
}

