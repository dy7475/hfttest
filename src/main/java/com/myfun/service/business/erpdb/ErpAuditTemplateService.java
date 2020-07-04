package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpAuditTemplate;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpAuditTemplateService extends BaseMapper<ErpAuditTemplate, ErpAuditTemplate>{

	/**
	 * 保存模板
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param templateListStr
	 * @param cityId
	 * @param compId
	 */
	void saveAuditTemplate(String templateListStr, Integer cityId, Integer compId);
	
	/**
	 * 保存审核流程模板
	 * @author 张宏利
	 * @since 2017年10月12日
	 */
	//public void saveAuditTemplate();
	
}
