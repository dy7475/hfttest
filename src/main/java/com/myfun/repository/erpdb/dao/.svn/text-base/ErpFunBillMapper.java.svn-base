package com.myfun.repository.erpdb.dao;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunBill;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunBillMapper extends BaseMapper<ErpFunBill, ErpFunBill> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBillExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBillExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBill> selectByExample(ErpFunBillExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBill record, @Param("example") ErpFunBillExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBill record, @Param("example") ErpFunBillExample example);

	void deleteEarbestBillPrintRelative(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("earbestId") Integer earbestId);

	List<Map<String, Object>> selectPrintContentInfo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("financIdArr") String[] financIdArr, @Param("earBestIdArr")String[] earBestIdArr,@Param("depositIdArr") String[] depositIdArr,@Param("printType") Byte printType,@Param("printWay") String printWay);

	void insertList(@Param("shardCityId")Integer cityId,@Param("billList") List<ErpFunBill> billList);

	void delBillPhoto(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("earbestId")Integer earbestId, @Param("financId")Integer financId, @Param("depositId")Integer depositId);

	List<Map<String, Object>> selectNotEffctiveBillNoList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

	int DelByEarbestId(@Param("shardCityId")Integer cityId, @Param("earbestId") Integer earbestId);

    List<ErpFunBill> getBillList(@Param("shardCityId")Integer cityId, @Param("paramMap")Map<String, Object> param);

	void updateBillStatusByFianacId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("auditStatus") Integer auditStatus,@Param("pfIdArr") String[] pfIdArr);

	void updateBillStatusByIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("fianacIds") List<String> fianacIds);

	int countFunBill(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("codeNo") String codeNo);

	Integer countFunBillByCondition(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("billNo") String billNo,@Param("earbestDealBillRepeat") String earbestDealBillRepeat,@Param("invalidBillNoCanUseAgain") String invalidBillNoCanUseAgain,@Param("billType") Integer billType);

    ErpFunBill getRecordByEarnestId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId, @Param("earbestId") Integer earbestId);

	Integer updateBillDealInfoByEarbestIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("contractNo") String contractNo, @Param("dealId") Integer dealId,@Param("earbestIds") List<Integer> earbestIds);

	void updateBillDealInfoByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId, @Param("dealNo")String dealNo,
			@Param("depositIds")List<Integer> depositIds);

    void updateDepositBillNo(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("billCodeNo")String billCodeNo, @Param("depositId")Integer id);
}