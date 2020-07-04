package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.param.PaymentModuleDetailListParam;
import com.myfun.repository.erpdb.dto.ErpFunGenerationPaymentDto;
import com.myfun.repository.erpdb.dto.ErpFunRewardPunishmentDto;
import com.myfun.repository.erpdb.dto.FunWageTmpDataDto;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunGenerationPayment;
import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunGenerationPaymentMapper extends BaseMapper<ErpFunGenerationPayment, ErpFunGenerationPayment> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunGenerationPaymentExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunGenerationPaymentExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunGenerationPayment> selectByExample(ErpFunGenerationPaymentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunGenerationPayment record,
			@Param("example") ErpFunGenerationPaymentExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunGenerationPayment record,
			@Param("example") ErpFunGenerationPaymentExample example);

	List<ErpFunGenerationPaymentDto> getGenerationPaymentList(@Param("shardCityId") Integer cityId,
															  @Param("param")PaymentModuleDetailListParam param);

	List<Map<String,Object>> summaryGenerationPaymentList(@Param("shardCityId")Integer cityId, @Param("param") ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	void insertBatch(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("createUid") Integer createUid, @Param("param") ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	Long summaryGenerationPaymentCount(@Param("shardCityId") Integer cityId,@Param("param")ErpFunGenerationPaymentParam param);

	List<FunWageTmpDataDto> getAllUserGenerationData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userIds")Set<Integer> allUserIdSet,@Param("assmonthSet") Set<String> assmonthSet);

	Long summaryGenerationPaymentCountNewOrg(@Param("shardCityId") Integer cityId,@Param("param")ErpFunGenerationPaymentParam param);

	List<Map<String, Object>> summaryGenerationPaymentListNewOrg(@Param("shardCityId")Integer cityId, @Param("param") ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);

	List<ErpFunGenerationPaymentDto> getGenerationPaymentListNewOrg(@Param("shardCityId") Integer cityId, @Param("param")PaymentModuleDetailListParam param);

	void insertBatchNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("createUid") Integer createUid, @Param("param") ErpFunGenerationPaymentParam erpFunGenerationPaymentParam);
}