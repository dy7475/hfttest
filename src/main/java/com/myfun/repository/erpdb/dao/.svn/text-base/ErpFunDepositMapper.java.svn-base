package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.param.QueryDepositListParam;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositListVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositVO;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunDepositExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDepositMapper extends BaseMapper<ErpFunDeposit, ErpFunDeposit> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDepositExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDepositExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDeposit> selectByExample(ErpFunDepositExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDeposit record, @Param("example") ErpFunDepositExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDeposit record, @Param("example") ErpFunDepositExample example);

	List<DepositVO> selectDepositList(@Param("shardCityId")Integer cityId, @Param("param")QueryDepositListParam param);

	List<DepositVO> selectDepositListByDealId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId, @Param("id")Integer id);

	List<DepositVO> selectDepositListByHouseCustId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("custId")Integer custId, @Param("custType")Byte custType,
			@Param("caseId")Integer caseId, @Param("caseType")Byte caseType, @Param("id")Integer id);

	Integer countDepositListByDealId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId);

	Integer countDepositListByHouseCustId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("custId")Integer custId, @Param("custType")Byte custType,
			@Param("caseId")Integer caseId, @Param("caseType")Byte caseType);

	void updateDealInfoByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId, @Param("dealNo")String dealNo,
			@Param("depositIds")List<Integer> depositIds);

	void delBillPhoto(@Param("shardCityId")Integer cityId, @Param("depositId")Integer depositId);

	void updateDepositBillPhoto(@Param("shardCityId")Integer cityId, @Param("depositId")Integer depositId, @Param("photoUrl")String photoUrl);

	void clearAuditInfo(@Param("shardCityId")Integer cityId, @Param("id")Integer id);
}	