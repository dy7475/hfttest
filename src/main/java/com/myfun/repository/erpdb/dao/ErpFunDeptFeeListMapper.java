package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunDeptFeeListDto;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeListParam;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeList;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeListExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDeptFeeListMapper extends BaseMapper<ErpFunDeptFeeList, ErpFunDeptFeeList> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDeptFeeListExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDeptFeeListExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunDeptFeeList> selectByExample(ErpFunDeptFeeListExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunDeptFeeList record,@Param("example") ErpFunDeptFeeListExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunDeptFeeList record,@Param("example") ErpFunDeptFeeListExample example);

	List<ErpFunDeptFeeListDto> getFunDeptFeeList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("param")ErpFunDeptFeeListParam param);

    Integer audtiDeptFeeById(@Param("shardCityId")Integer cityId, @Param("param") ErpFunDeptFeeListParam erpFunDeptFeeList);

	List<ErpFunDeptFeeList> summaryFunFeeList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("param")ErpFunDeptFeeListParam param);

	void updateFunDeptFeeList(@Param("shardCityId") Integer cityId, @Param("feeAmount") BigDecimal feeAmount, @Param("currentTime")Date currentTime, @Param("feeId")Integer feeId, @Param("partnerId") Integer partnerId);

	Integer updateInfoByPrimaryKey(@Param("shardCityId") Integer cityId, @Param("countTime") Date countTime, @Param("feeAmount") BigDecimal feeAmount, @Param("feeNote") String feeNote, @Param("feeDetailListId") Integer feeDetailListId);

	Integer updateDeptFeeBillPic(@Param("shardCityId") Integer cityId, @Param("billPicUrl") String billPicUrl, @Param("feeDetailListId") Integer feeDetailListId);
}