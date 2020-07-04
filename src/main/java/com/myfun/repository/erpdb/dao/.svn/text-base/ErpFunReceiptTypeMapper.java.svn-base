package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunReceiptType;
import com.myfun.repository.erpdb.po.ErpFunReceiptTypeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunReceiptTypeMapper extends BaseMapper<ErpFunReceiptType, ErpFunReceiptType> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunReceiptTypeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunReceiptTypeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunReceiptType> selectByExample(ErpFunReceiptTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunReceiptType record,
			@Param("example") ErpFunReceiptTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunReceiptType record, @Param("example") ErpFunReceiptTypeExample example);

	@SwitchDB(type=SwitchDBType.CITY_ID)
    List<ErpFunReceiptType> getListByCompId(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId);
    
    @SwitchDB(type=SwitchDBType.CITY_ID)
    int updateListByCompId(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId);
    
    int updateTypeById(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId, @Param("id")Integer id);
}