package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittemp;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittempExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunBuildrulequerylimittempMapper extends BaseMapper<ErpFunBuildrulequerylimittemp, ErpFunBuildrulequerylimittemp> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBuildrulequerylimittempExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBuildrulequerylimittempExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunBuildrulequerylimittemp> selectByExample(ErpFunBuildrulequerylimittempExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBuildrulequerylimittemp record,
			@Param("example") ErpFunBuildrulequerylimittempExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBuildrulequerylimittemp record,
			@Param("example") ErpFunBuildrulequerylimittempExample example);
	@SwitchDB(type = SwitchDBType.DB_NAME)
    Integer selectLastLimitId(@Param("shardDbName") String shardDbName);
	@SwitchDB(type = SwitchDBType.DB_NAME)
	void insertList(@Param("shardDbName") String shardDbName, @Param("limitTempList")List<ErpFunBuildrulequerylimittemp> listTempList);
}