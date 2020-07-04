package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpRenovationCustomerFileDto;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerFile;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerFileExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpRenovationCustomerFileMapper extends BaseMapper<ErpRenovationCustomerFile, ErpRenovationCustomerFile> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpRenovationCustomerFileExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpRenovationCustomerFileExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpRenovationCustomerFile> selectByExample(ErpRenovationCustomerFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpRenovationCustomerFile record,
			@Param("example") ErpRenovationCustomerFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpRenovationCustomerFile record,
			@Param("example") ErpRenovationCustomerFileExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    int updateIsDelById(@Param("shardCityId") Integer shardCityId, @Param("idList") List<Integer> idList);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpRenovationCustomerFileDto> getFileList(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("id") Integer id);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
    int updateIsDelByRenovationCustomerId(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("id") Integer id);
}