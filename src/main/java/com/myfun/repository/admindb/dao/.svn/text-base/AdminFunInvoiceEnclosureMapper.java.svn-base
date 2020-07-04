package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.usercenter.param.GetInvoiceEnclosureListParam;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosureExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunInvoiceEnclosureMapper extends BaseMapper<AdminFunInvoiceEnclosure, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunInvoiceEnclosure> selectByExampleWithBLOBs(AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunInvoiceEnclosure> selectByExample(AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunInvoiceEnclosure record,
			@Param("example") AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") AdminFunInvoiceEnclosure record,
			@Param("example") AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunInvoiceEnclosure record,
			@Param("example") AdminFunInvoiceEnclosureExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminFunInvoiceEnclosure record);

    List<AdminFunInvoiceEnclosure> selectList(@Param("param") AdminFunInvoiceEnclosure adminFunInvoiceEnclosure);

	void insertForFastDfs(@Param("dfsParamList")List<Map<String, Object>> fastdfsFileList);
	
	AdminFunInvoiceEnclosure selectAdminFunInvoiceEnclosureById(@Param("esId")Integer esId,@Param("compNo")String compNo);
	@AccessReadonlyDb
	List<AdminFunInvoiceEnclosure> getAdminFunInvoiceEnclosurelist(@Param("param") GetInvoiceEnclosureListParam param);
}