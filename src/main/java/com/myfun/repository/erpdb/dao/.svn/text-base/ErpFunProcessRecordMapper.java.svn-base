package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunProcessRecord;
import com.myfun.repository.erpdb.po.ErpFunProcessRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunProcessRecordMapper extends BaseMapper<ErpFunProcessRecord, ErpFunProcessRecord> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProcessRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProcessRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunProcessRecord> selectByExample(ErpFunProcessRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunProcessRecord record,
			@Param("example") ErpFunProcessRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunProcessRecord record,
			@Param("example") ErpFunProcessRecordExample example);

	/**
	 * 查询合同流程日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param dealId
	 * @param compId
	 * @return
	 */
	List<ErpFunProcessRecord> getMgrDealProcessLogList(@Param("shardCityId") Integer cityId, @Param("dealId") Integer dealId, @Param("compId") Integer compId);

	ErpFunProcessRecord getMgrDealProcessLog(@Param("shardCityId") Integer cityId, @Param("dealId") Integer dealId, @Param("compId") Integer compId,@Param("recordId") Integer recordId);

	Integer getFronRecordId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("runstepId") Integer runstepId);
}

