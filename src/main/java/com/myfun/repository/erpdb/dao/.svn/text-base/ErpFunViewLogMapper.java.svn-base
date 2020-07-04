package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrPhoneListParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunViewLogDto;
import com.myfun.repository.erpdb.po.ErpFunMac;
import com.myfun.repository.erpdb.po.ErpFunViewLog;
import com.myfun.repository.erpdb.po.ErpFunViewLogKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunViewLogExample;
@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpFunViewLogMapper extends BaseMapper<ErpFunViewLog, ErpFunViewLogKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunViewLogExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunViewLogExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunViewLog> selectByExample(ErpFunViewLogExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunViewLog record, @Param("example") ErpFunViewLogExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunViewLog record, @Param("example") ErpFunViewLogExample example);
	/**
	* @Date:2016-10-20
	* @Athor:方李骥
	* @Title: selectMgrInstallList 
	* @Description: TODO(查询当前公司的安装列表) 
	* @param cityId
	* @param param
	* @return   
	* @return List<ErpFunMac>    返回类型 
	* @throws
	 */
	List<ErpFunMac> selectMgrInstallList(@Param("shardCityId")Integer cityId,@Param("param")Map<String,Object> param);
	/**
	* 
	* 张雨
	* 查询电话列表
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)	
	List<ErpFunViewLogDto> getMgrPhoneList(@Param("pMap")GetMgrPhoneListParam pMap, @Param("shardCityId")Integer cityId);
	
	/**
	 * 查询查看记录
	 * @author 张宏利
	 * @since 2017年10月30日
	 * @param cityId
	 * @param viewUserId
	 * @param caseId
	 * @param caseType
	 * @param dateNow
	 * @return
	 */
	ErpFunViewLog getViewLog(@Param("shardCityId")Integer cityId, @Param("viewUserId")Integer viewUserId, 
			@Param("caseId")Integer caseId, @Param("caseType")Integer caseType, @Param("dateNow")String dateNow);
	
}