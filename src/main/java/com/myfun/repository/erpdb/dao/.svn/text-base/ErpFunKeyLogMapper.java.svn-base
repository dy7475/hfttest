package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.house.vo.FunKeyLogDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunKeyLogDto;
import com.myfun.repository.erpdb.po.ErpFunKeyLog;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunKeyLogMapper extends BaseMapper<ErpFunKeyLog, ErpFunKeyLog> {

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param keyId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunKeyLogDto> getKeyLogList(@Param("shardCityId")Integer cityId, @Param("keyId")Integer keyId);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param keyId
	 */	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteFunKeyLog(@Param("shardCityId")Integer cityId, @Param("keyId")Integer keyId);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param keyId
	 */	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunKeyLog> getErpFunKeyLogByIds(@Param("shardCityId")Integer cityId, @Param("keyIds")Set<Integer> logIds);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param keyId
	 */	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteFunKeyLogByKeyIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("keyIds") Object[] keyIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunKeyLogDto> getKeyBorrowLogList(@Param("shardCityId")Integer cityId, @Param("paramMap")Map<String, Object> paramMap);
	
	/**
	 * 归还钥匙时更新钥匙日志的归还信息
	 * @author 张宏利
	 * @since 2017年10月30日
	 * @param cityId 城市分库ID
	 * @param keyLogId 钥匙日志ID
	 * @param createUserId 归还人
	 * @param selfUserId 审核人
	 * @param returnDesc 说明
	 */
	void updateByReturnKey(@Param("shardCityId")Integer cityId, @Param("keyLogId")Integer keyLogId, 
			@Param("createUserId") Integer createUserId, @Param("selfUserId")Integer selfUserId,
			@Param("returnDesc")String returnDesc);

	ErpFunKeyLog getByKeyLogId(@Param("shardCityId")Integer cityId,@Param("keyLogId")Integer keyLogId);

    FunKeyLogDto getFunKeyLogDto(@Param("shardCityId")Integer cityId,@Param("keyLogId")Integer keyLogId);
}


