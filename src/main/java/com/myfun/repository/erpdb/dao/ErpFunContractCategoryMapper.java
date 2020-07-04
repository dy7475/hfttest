package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunContractCategory;
import com.myfun.repository.erpdb.po.ErpFunContractCategoryExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunContractCategoryMapper extends BaseMapper<ErpFunContractCategory, ErpFunContractCategory> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunContractCategoryExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunContractCategoryExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunContractCategory> selectByExample(ErpFunContractCategoryExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunContractCategory record,
			@Param("example") ErpFunContractCategoryExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunContractCategory record,
			@Param("example") ErpFunContractCategoryExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertProfitComp(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void generateDefaultPerformanceCategories(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId, @Param("compId") Integer compId);

}