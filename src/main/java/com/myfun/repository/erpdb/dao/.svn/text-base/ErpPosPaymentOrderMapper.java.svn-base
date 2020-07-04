package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpPosPaymentOrderDto;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrder;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrderExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
@SwitchDB (type = SwitchDBType.CITY_ID)
public interface ErpPosPaymentOrderMapper extends BaseMapper<ErpPosPaymentOrder, ErpPosPaymentOrder> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpPosPaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpPosPaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpPosPaymentOrder> selectByExample(ErpPosPaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpPosPaymentOrder record,
			@Param("example") ErpPosPaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpPosPaymentOrder record,
			@Param("example") ErpPosPaymentOrderExample example);

	@SwitchDB (type = SwitchDBType.CITY_ID)
    List<ErpPosPaymentOrderDto> getPosOrderList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId,
												@Param("payStatus") Integer payStatus, @Param("queryTimeType")Integer queryTimeType, @Param("queryTimeStart")Date queryTimeStart,
												@Param("queryTimeEnd")Date queryTimeEnd, @Param("isGroupByContract")  Integer isGroupByContract,
												@Param("keyWords")  String keyWords, @Param("paymentId") Integer paymentId);

	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> countPosOrderList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("startTime") Date startTime,  @Param("endTime")Date endTime);
	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> countPosOrderList2(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("startTime") Date startTime,  @Param("endTime")Date endTime);

	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> getCyjOrderDetail(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);

	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> getDealFinanceDetail(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("paymentId") String paymentId);

	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> getCommonFinance(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);
	@SwitchDB (type = SwitchDBType.CITY_ID)
    List<Map<String,Object>> countPosOrderList3(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("startTime") Date startTime,  @Param("endTime")Date endTime);


	@SwitchDB (type = SwitchDBType.CITY_ID)
	List<Map<String,Object>> getNotPay(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);

	void updateByDealId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("pfIds") String[] pfIds,@Param("payStatus") Integer payStatus);
}