package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunBillPrint;
import com.myfun.repository.erpdb.po.ErpFunBillPrintExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunBillPrintMapper extends BaseMapper<ErpFunBillPrint, ErpFunBillPrint> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBillPrintExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBillPrintExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBillPrint> selectByExample(ErpFunBillPrintExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBillPrint record,
			@Param("example") ErpFunBillPrintExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBillPrint record, @Param("example") ErpFunBillPrintExample example);

	/**
	 * 更新打印表上的打印次数
	 * @param cityId
	 * @param printId
	 * @param userId
	 */
	void updateBillPrintCountAndUserInfo(@Param("shardCityId")Integer cityId,@Param("printId") Integer printId,@Param("userId") Integer userId);

	void deleteByIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("fianacIds") List<String> fianacIds);
}