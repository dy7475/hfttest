package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunFinanceStatus;
import com.myfun.repository.erpdb.po.ErpFunFinanceStatusExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunFinanceStatusMapper extends BaseMapper<ErpFunFinanceStatus, ErpFunFinanceStatus> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunFinanceStatusExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunFinanceStatusExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunFinanceStatus> selectByExample(ErpFunFinanceStatusExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunFinanceStatus record,
			@Param("example") ErpFunFinanceStatusExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunFinanceStatus record,
			@Param("example") ErpFunFinanceStatusExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void createCompTempleteFinancStatusList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
}