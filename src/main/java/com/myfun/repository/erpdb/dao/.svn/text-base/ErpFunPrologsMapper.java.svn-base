package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetSysLoginLogsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.ZtGetAppLoginLogsParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ZtAppLoginListVo;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import com.myfun.repository.erpdb.po.ErpFunPrologsExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPrologsMapper extends BaseMapper<ErpFunPrologs, ErpFunPrologs> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPrologsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPrologsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPrologs> selectByExample(ErpFunPrologsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPrologs record, @Param("example") ErpFunPrologsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPrologs record, @Param("example") ErpFunPrologsExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunPrologs> getSysLoginLogs(@Param("pMap") GetSysLoginLogsParam pMap, @Param("shardCityId") Integer cityId);

	int countModelData(@Param("shardCityId") Integer cityId, @Param("nowTime") Date nowTime,
			@Param("compId") Integer compId, @Param("userId") Integer userId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunPrologs getListData(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,@Param("isPer") String isPer);
	
	/**
	 * 通过ID修改日志
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return 
	 * 
	 */
	void logout(@Param("shardCityId") Integer cityId,@Param("prologsId") Integer prologsId, @Param("outType") String outType);

	/**
	 * 掌�?�端获取手机登录日志列表
	 * @author HuangJiang
	 * @since 2019�?7�?1�? 上午10:14:53
	 * @param param
	 * @param cityId
	 * @return
	 * Modified XXX HuangJiang 2019�?7�?1�?
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ZtAppLoginListVo> getZtAppLoginLogList(@Param("pMap") ZtGetAppLoginLogsParam pMap, @Param("shardCityId") Integer cityId);
}