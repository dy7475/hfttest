package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrInstallListParam;
import com.myfun.repository.erpdb.dto.ErpFunMacDto;
import com.myfun.repository.erpdb.po.ErpFunMac;
import com.myfun.repository.erpdb.po.ErpFunMacExample;
import com.myfun.repository.erpdb.po.ErpFunViewLog;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunMacMapper extends BaseMapper<ErpFunMac, ErpFunMac> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunMacExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunMacExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunMac> selectByExample(ErpFunMacExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunMac record, @Param("example") ErpFunMacExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunMac record, @Param("example") ErpFunMacExample example);

	/**
	 * 删除mac
	 * @param erpCompId
	 * @param erpDeptId
	 */
	void deleteByCompIdAndDeptid(@Param("shardCityId")Integer cityId, @Param("erpCompId")Integer erpCompId, @Param("erpDeptId")Integer erpDeptId);
	
	/**
	 * 去掉公司mac的漫游记�?
	 * @param cityId 
	 * @param enterCompId
	 */
	void updateRecords(@Param("shardCityId") short cityId, @Param("compId") String compId);
	/**
	* @Date:2016-10-20
	* @Athor:方李�?
	* @Title: selectMgrInstallList 
	* @Description: TODO(查询当前公司的安装列�?) 
	* @param cityId
	* @param param
	* @return   
	* @return List<ErpFunMac>    返回类型 
	* @throws
	 */
	List<ErpFunMacDto> selectMgrInstallList(@Param("shardCityId")Integer cityId,@Param("param") GetMgrInstallListParam param);

	/**
	 * @Date:2016-10-20
	 * @Athor:方李�?
	 * @Title: updateFunMacLoginStatusOrReg 
	 * @Description: TODO
	 * @param cityId
	 * @param param
	 * @return   
	 * @return void   返回类型 
	 * @throws
	 */
	void updateFunMacLoginStatusOrReg(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	
	/**
	 * @Date:2016-10-20
	 * @Athor:方李�?
	 * @Title: getRoamCountByDeptId 
	 * @Description: TODO(查询门店的漫游数�?) 
	 * @param cityId
	 * @param param
	 * @return   
	 * @return int   返回类型 
	 * @throws
	 */
	int getRoamCountByDeptId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * @Date:2016-10-20
	 * @Athor:方李�?
	 * @Title: getRoamCountByDeptId 
	 * @Description: TODO(查询门店的漫游数�?) 
	 * @param cityId
	 * @param param
	 * @return   
	 * @return int   返回类型 
	 * @throws
	 */
	void updateMacInfoByMacAddr(@Param("shardCityId") Integer cityId, @Param("roam") Integer roam,
			@Param("roamUser") Integer roamUser, @Param("macaddr") String macaddr);

	void deleteByMacAddr(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	* @Date:2017-1-14
	* @Athor:张雨
	* @Title: getMgrPhoneList 
	* @Description: TODO(查询电话列表) 
	* @param compId
	* @param param
	* @return   
	* @return List<ErpFunViewLog>    返回类型 
	* @throws
	 */
	List<ErpFunViewLog> getMgrPhoneList(@Param("compId")Integer compId,@Param("param")Map<String,Object> param);

    Integer judgeIsReamUser(@Param("shardCityId")Integer cityId, @Param("macaddr") String macaddr);

	ErpFunMac getFunMacByMacaddr(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("macaddr")String macaddr);
}