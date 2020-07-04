package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.repository.erpdb.po.ErpFunBillCodelogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunBillCodelogMapper extends BaseMapper<ErpFunBillCodelog, ErpFunBillCodelog> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBillCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBillCodelogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBillCodelog> selectByExample(ErpFunBillCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBillCodelog record,
			@Param("example") ErpFunBillCodelogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBillCodelog record, @Param("example") ErpFunBillCodelogExample example);

	Integer countCodeLog(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("param")FunBillModuleParam param, @Param("codeLength")Integer codeLength);

    void insertBatch(@Param("shardCityId")Integer cityId, @Param("codelogList")List<ErpFunBillCodelog> codelogList);

    ErpFunBillCodelog getOneBillCodeLog(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
                                        @Param("deptId")Integer deptId, @Param("billType")Byte billType, @Param("billWay")Byte billWay);
    
    List<ErpFunBillCodelog> getNotUseBillCodeNoList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
    		@Param("deptId")Integer deptId, @Param("billType")Byte billType, @Param("billWay")Byte billWay ,@Param("billNo") String billNo);

	List<ErpFunBillCodelog> getFunBillCodelogByCodeNo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("codeNo") String codeNo);

	void updateByPrimaryId(@Param("shardCityId")Integer cityId,@Param("codelogId")Integer codelogId,@Param("useStatus")Integer useStatus);
}