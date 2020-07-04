package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpAuditTemplateDto;
import com.myfun.repository.erpdb.po.ErpAuditTemplate;
import com.myfun.repository.erpdb.po.ErpAuditTemplateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpAuditTemplateMapper extends BaseMapper<ErpAuditTemplate, ErpAuditTemplate> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditTemplateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditTemplate> selectByExample(ErpAuditTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditTemplate record,
			@Param("example") ErpAuditTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditTemplate record, @Param("example") ErpAuditTemplateExample example);

	/**
	 * 依据类型获取配置
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param auditResource 
	 * @param auditType 类型
	 * @return
	 */
	ErpAuditTemplate selectByAuditType(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("auditResource") Byte auditResource, @Param("auditType") Integer auditType,@Param("caseType") Integer caseType);
	
	/**
	 * 通过公司ID获取审核模板
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param compId
	 * @param caseType 
	 * @param auditResource 
	 * @return
	 */
	List<ErpAuditTemplateDto> getBusinessAuditTemplate(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("caseType") Integer caseType, @Param("auditResource") Integer auditResource);
	
	/**
	 * 通过公司ID删除模板
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param compId
	 */
	void deleteByCompId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("caseType") Integer caseType, @Param("auditType") Integer auditType);
	
	/**
	 * 拷贝审核配置模板
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param auditResource 
	 * @param fromCaseType 来源房客源类型
	 * @param toCaseType 目标房客源类型
	 * @param auditTypeSet 目标房客源类型拥有的审核类型
	 */
	void copyAuditTemplate(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("fromCaseType") Integer fromCaseType, @Param("toCaseType") Integer toCaseType,
			@Param("auditTypeSet") Set<Byte> auditTypeSet);

	/**
	 * 拷贝OA类审批到其他行
	 * 
	 * @author 张宏利
	 * @since 2018年1月17日
	 * @param cityId
	 * @param compId
	 * @param auditResource
	 *            审核类型 2=请假审核 3=外出审核
	 * @param templateId
	 *            模板行的ID
	 */
	void copyAuditTemplateForOa(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("auditResource") Integer auditResource, @Param("templateId") Integer templateId,
			@Param("auditTypeSet") Set<Byte> auditTypeSet);

	ErpAuditTemplate getAuditTemplate(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("caseType") Integer caseType,@Param("trackType") Byte trackType);

	Byte selectAuditProcess(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("auditResource")Byte auditResource, @Param("auditType")Integer auditType, @Param("caseType")Integer caseType);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpAuditTemplate selectByAuditTypeByClassId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("auditResource") Byte auditResource, @Param("auditType") Integer auditType,@Param("caseType") Integer caseType, @Param("classId") Integer classId);


}
