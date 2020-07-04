package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.po.ErpFunBillCode;
import com.myfun.repository.erpdb.po.ErpFunBillCodeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunBillCodeMapper extends BaseMapper<ErpFunBillCode, ErpFunBillCode> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBillCodeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBillCodeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBillCode> selectByExample(ErpFunBillCodeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBillCode record,
			@Param("example") ErpFunBillCodeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBillCode record, @Param("example") ErpFunBillCodeExample example);

	List<ErpFunBillCode> getFunBillCodes(@Param("shardCityId")Integer cityId,@Param("param") FunBillModuleParam param);

	ErpFunBillCode getFunBillCodeByCodeId(@Param("shardCityId")Integer cityId,@Param("codeId") Integer codeId);

	void updateByPrimaryId(@Param("shardCityId")Integer cityId,@Param("usedCount") Integer usedCount,@Param("codeId") Integer codeId);

	/**
	 * 增减使用量
	 * @param cityId
	 * @param compId
	 * @param codeId
	 */
    void addCountByCodeId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("codeId")Integer codeId);
    void subCountByCodeId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("codeId")Integer codeId);
}