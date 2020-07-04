package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunCustSource;
import com.myfun.repository.erpdb.po.ErpFunCustSourceExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunCustSourceMapper extends BaseMapper<ErpFunCustSource, ErpFunCustSource> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunCustSourceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunCustSourceExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunCustSource> selectByExample(ErpFunCustSourceExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunCustSource record,@Param("example") ErpFunCustSourceExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunCustSource record,@Param("example") ErpFunCustSourceExample example);
}