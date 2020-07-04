package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.usercenter.vo.ErpFunKeyOperationLogDto;
import com.myfun.repository.erpdb.po.ErpFunKeyOperationLog;
import com.myfun.repository.erpdb.po.ErpFunKeyOperationLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunKeyOperationLogMapper extends BaseMapper<ErpFunKeyOperationLog, ErpFunKeyOperationLog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunKeyOperationLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunKeyOperationLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunKeyOperationLog> selectByExample(ErpFunKeyOperationLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunKeyOperationLog record,
			@Param("example") ErpFunKeyOperationLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunKeyOperationLog record,
			@Param("example") ErpFunKeyOperationLogExample example);

	ErpFunKeyOperationLog getFunKeyOperationLogByKeyId(@Param("shardCityId")Integer cityId, @Param("keyId")Integer keyId);
	
	void deleteFunKeyOperationLogByKeyIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("keyIds") Object[] keyIds);
	
	List<ErpFunKeyOperationLogDto> getFunKeyOperationLogList(@Param("shardCityId")Integer cityId, @Param("paramMap")Map<String, Object> paramMap);
	
	List<ErpFunKeyOperationLogDto> getFunKeyOperationLogRecordList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("keyId")Integer keyId);
	
	/**
	 * 业务工具钥匙管理列表
	 *@author 朱科
	 *@param 
	 *@return List<ErpFunKeyOperationLog>
	 *@since 2018年7月4日
	 */
	List<ErpFunKeyOperationLog> getListByKeyIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("keyIds")Set<Integer> keyIds);
}