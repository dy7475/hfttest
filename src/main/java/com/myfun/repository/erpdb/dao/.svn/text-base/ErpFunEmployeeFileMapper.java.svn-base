package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunEmployeeFile;
import com.myfun.repository.erpdb.po.ErpFunEmployeeFileExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEmployeeFileMapper extends BaseMapper<ErpFunEmployeeFile, ErpFunEmployeeFile> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEmployeeFileExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEmployeeFileExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEmployeeFile> selectByExample(ErpFunEmployeeFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEmployeeFile record,
			@Param("example") ErpFunEmployeeFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEmployeeFile record,
			@Param("example") ErpFunEmployeeFileExample example);

	/**
	  * 获取员工档案中的附件信息
	  * @author 熊刚
	  * @since 2017年11月6日
	  * @param cityId
	  * @param compId
	  * @param employeeDocId
	  * @param archiveId
	  * @return
	  */
	List<ErpFunEmployeeFile> getEmployeeFile(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("employeeDocId") Integer employeeDocId);
}