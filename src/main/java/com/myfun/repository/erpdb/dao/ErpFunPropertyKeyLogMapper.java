package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPropertyKeyLog;
import com.myfun.repository.erpdb.po.ErpFunPropertyKeyLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPropertyKeyLogMapper extends BaseMapper<ErpFunPropertyKeyLog, ErpFunPropertyKeyLog> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPropertyKeyLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPropertyKeyLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPropertyKeyLog> selectByExample(ErpFunPropertyKeyLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPropertyKeyLog record,
			@Param("example") ErpFunPropertyKeyLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPropertyKeyLog record,
			@Param("example") ErpFunPropertyKeyLogExample example);

	ErpFunPropertyKeyLog selectKeyStatus(@Param("shardCityId") Integer cityId,@Param("logId") Integer keyId);

    void updatePropertyKeyLogByIdIn(@Param("shardCityId")Integer cityId,@Param("ids") List<Integer> outTimeIds,@Param("keyStatus") Integer outTime);
}