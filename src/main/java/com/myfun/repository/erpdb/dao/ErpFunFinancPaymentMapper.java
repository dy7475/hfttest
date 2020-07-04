package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunFinancPaymentMapper extends BaseMapper<ErpFunFinancPayment, ErpFunFinancPayment> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunFinancPaymentExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunFinancPaymentExample example);
	/**
	 * @mbggenerated
	 */List<ErpFunFinancPayment> selectByExample(ErpFunFinancPaymentExample example);
	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunFinancPayment record,@Param("example") ErpFunFinancPaymentExample example);
	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunFinancPayment record,@Param("example") ErpFunFinancPaymentExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void createCompTempleteFinancPaymentList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
	/**
	 * 构建业绩来源 行转利 列条件
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/10
	 * @return
	 *
	 */
	List<ErpFunFinancPayment> buildSystemDefinitionFinancPayment(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);
	
	/**
	 * 获取财务款项配置列表主键
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/11
	 * @return
	 *
	 */
	List<Integer> getPaymentIdsList(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId);
}