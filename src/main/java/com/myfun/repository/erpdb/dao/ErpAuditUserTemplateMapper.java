package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditUserTemplate;
import com.myfun.repository.erpdb.po.ErpAuditUserTemplateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ErpAuditUserTemplateMapper extends BaseMapper<ErpAuditUserTemplate, ErpAuditUserTemplate> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditUserTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditUserTemplateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditUserTemplate> selectByExample(ErpAuditUserTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditUserTemplate record,
			@Param("example") ErpAuditUserTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditUserTemplate record,
			@Param("example") ErpAuditUserTemplateExample example);

	/**
	 * 通过公司模板配置获取审核人员列表
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param compId
	 * @param id
	 * @return
	 */
	List<ErpAuditUserTemplate> selectByAuditId(@Param("shardCityId")Integer cityId, @Param("auditId") Integer auditId);
	
	/**
	 * 获取公司的审核流程员工配置
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param auditIdSet
	 * @return
	 */
	List<ErpAuditUserTemplate> getBusinessAuditTemplate(@Param("shardCityId")Integer cityId, @Param("auditIds")Set<Integer> auditIds);
	
	/**
	 * 通过公司ID删除用户配置列表
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param compId
	 * @param auditType 
	 * @param caseType 
	 * @param auditResource 
	 */
	void deleteByAuditId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseType") Integer caseType, @Param("auditType") Integer auditType, @Param("auditResource") Byte auditResource);
	
	/**
	 * 批量插入审核人模板列表
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param auditUserTemplates
	 */
	void insertList(@Param("shardCityId")Integer cityId, @Param("auditUserTemplates")List<ErpAuditUserTemplate> auditUserTemplates);

    List<ErpAuditUserTemplate> selectByClassId(@Param("shardCityId")Integer cityId, @Param("classId")Integer classId);
    
    /**
     * 删除审核流程
     * @param cityId
     * @param compId
     * @param userId
     */
    void delAuditHouseComplaint(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);
    
    /**
     * 添加审核流程
     * @param cityId
     * @param compId
     * @param userId
     * @param generalManagerUserId
     */
    void addAuditHouseComplaint(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("generalManagerUserId")Integer generalManagerUserId);
    Integer countAuditHouseComplaint(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);

	List<ErpAuditUserTemplate> selectByAuditProcessId(@Param("shardCityId")Integer cityId, @Param("auditProcessId")Integer auditProcessId);
}

