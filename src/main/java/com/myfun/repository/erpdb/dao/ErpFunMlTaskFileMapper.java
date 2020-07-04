package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunMlTaskFile;
import com.myfun.repository.erpdb.po.ErpFunMlTaskFileExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunMlTaskFileMapper extends BaseMapper<ErpFunMlTaskFile, ErpFunMlTaskFile> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunMlTaskFileExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunMlTaskFileExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunMlTaskFile> selectByExample(ErpFunMlTaskFileExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunMlTaskFile record,@Param("example") ErpFunMlTaskFileExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunMlTaskFile record,@Param("example") ErpFunMlTaskFileExample example);
}