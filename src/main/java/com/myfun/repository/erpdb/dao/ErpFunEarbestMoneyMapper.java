package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunEarbestMoneyMapper extends BaseMapper<ErpFunEarbestMoney, ErpFunEarbestMoney> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEarbestMoney> selectByExample(ErpFunEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEarbestMoney record,
			@Param("example") ErpFunEarbestMoneyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEarbestMoney record,
			@Param("example") ErpFunEarbestMoneyExample example);

	List<ErpFunEarbestMoneyDto> selectEarbestMoneyList(@Param("shardCityId")Integer cityId,
													   @Param("param")DaoBaseParam param);

	Integer count(@Param("shardCityId")Integer cityId,@Param("erpEarbestMoney") ErpEarbestMoney erpEarbestMoney);

	ErpFunEarbestMoneyDto selectEarbestMoneyDetail(@Param("shardCityId")Integer cityId,
												@Param("earbestId") Integer earbestId);

	void delBillPhoto(@Param("shardCityId")Integer cityId,@Param("earbestId") Integer earbestId);

    Integer countEarbestListByDealId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId);

	Integer countEarbestListByHouseCustId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("custNo")String custNo, @Param("custId")Integer custId, @Param("caseNo") String caseNo,@Param("caseId")Integer caseId);

	List<ErpFunEarbestMoney> selectEarbestListByDealId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId);

	List<ErpFunEarbestMoney> selectEarbestListByHouseCustId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("custNo")String custNo, @Param("custId")Integer custId, @Param("caseNo") String caseNo,@Param("caseId")Integer caseId,@Param("audited") boolean audited);

	Integer updateDealInfoByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("contactNo") String contactNo,@Param("dealId")Integer dealId,@Param("ids")List<Integer> ids);
}