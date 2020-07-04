package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpAuditRuntimeCase;
import com.myfun.repository.erpdb.po.ErpAuditRuntimeCaseExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpAuditRuntimeCaseMapper extends BaseMapper<ErpAuditRuntimeCase, ErpAuditRuntimeCase> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditRuntimeCaseExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditRuntimeCaseExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditRuntimeCase> selectByExample(ErpAuditRuntimeCaseExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditRuntimeCase record,
			@Param("example") ErpAuditRuntimeCaseExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditRuntimeCase record,
			@Param("example") ErpAuditRuntimeCaseExample example);

	/**
	 * 批量插入审核人
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param auditUserRuntimeList
	 */
	void insertList(@Param("shardCityId") Integer cityId, @Param("runtimeCaseList") List<ErpAuditRuntimeCase> runtimeCaseList);
	
	/**
	 * 通过审批ID获取相关的房客源列表
	 * @author 张宏利
	 * @since 2018年1月17日
	 * @param cityId
	 * @param compId
	 * @param auditId
	 * @return
	 */
	List<ErpAuditRuntimeCase> selectByAuditId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("auditId")Integer auditId);
}

