package com.myfun.repository.erpdb.param;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpAuditTemplate;
import com.myfun.repository.erpdb.po.ErpAuditUserTemplate;

/**
 * 修改系统参数模板
 * @author 张宏利
 * @since 2017年10月16日
 * [
 * {caseType:1,auditType:1,overdueAuditTime:40,auditUser:[{auditUserType:1,auditUserId:6515},{auditUserType:1,auditUserId:6515}]},
 * {caseType:1,auditType:2,overdueAuditTime:40,auditUser:[{auditUserType:1,auditUserId:6515},{auditUserType:1,auditUserId:6515}]}
 * ]
 */
public class ErpAuditTemplateListParam extends ErpAuditTemplate{
	private static final long serialVersionUID = 1L;
	
	private String auditUser;
	
	private List<ErpAuditUserTemplate> auditUserList;

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public List<ErpAuditUserTemplate> getAuditUserList() {
		return auditUserList;
	}

	public void setAuditUserList(List<ErpAuditUserTemplate> auditUserList) {
		this.auditUserList = auditUserList;
	}
	
}
