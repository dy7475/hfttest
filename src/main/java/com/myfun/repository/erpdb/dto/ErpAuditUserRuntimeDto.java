package com.myfun.repository.erpdb.dto;

import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpAuditUserTransmitLogVO;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntime;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ErpAuditUserRuntimeDto extends ErpAuditUserRuntime{

	private static final long serialVersionUID = 1L;
	private String userPhoto;
	private Integer keyDeptId;
	private Integer userId;
	private Integer caseId;
	private Integer caseType;
	private Integer auditType;

	@ApiModelProperty(value = "转交记录")
	private List<ErpAuditUserTransmitLogVO> transmitLog;

	public List<ErpAuditUserTransmitLogVO> getTransmitLog() {
		return transmitLog;
	}

	public void setTransmitLog(List<ErpAuditUserTransmitLogVO> transmitLog) {
		this.transmitLog = transmitLog;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public Integer getKeyDeptId() {
		return keyDeptId;
	}

	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

}
