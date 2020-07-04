package com.myfun.erpWeb.managecenter.deal.param;

import com.myfun.erpWeb.managecenter.constract.param.UpdateDealAuditStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.CounterMgrSettleDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.SettlementDealParam;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.GeneralParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title 合同权证审批通用参数类(其实和合同审批类差不多)
 * @Author lcb
 * @Time 2019/7/3 19:25
 * @Desc
 **/

public class DealAuditCommonParam extends AbstractEncryParam {
	private GeneralParam generalParam;
	@ApiModelProperty("是否来自手机端 1=手机端")
	private Integer isMobileApi;// 是否来自手机端 1=手机端
	// 审核ID
	private Integer id;
	private Integer dealId;
	private Integer auditType;
	private String contractNo;

	// ** 财务款项审核参数 **//
	private ProcessFinancStatusParam processFinancStatusParam;

	private UpdateDealAuditStatusParam updateDealAuditStatusParam;

	private SettlementDealParam settlementDealParam;

	private CounterMgrSettleDealParam counterMgrSettleDealParam;

	@ApiModelProperty("如果有共享中心审核配置, 选择的具体共享中心审核流程的ID")
	private Integer classId;

	@ApiModelProperty("是不是房基地")
	private boolean isFangJidi;

	public CounterMgrSettleDealParam getCounterMgrSettleDealParam() {
		return counterMgrSettleDealParam;
	}

	public void setCounterMgrSettleDealParam(CounterMgrSettleDealParam counterMgrSettleDealParam) {
		this.auditType = 7;
		this.dealId = counterMgrSettleDealParam.getDealId();
		this.counterMgrSettleDealParam = counterMgrSettleDealParam;
	}

	public SettlementDealParam getSettlementDealParam() {
		return settlementDealParam;
	}

	public void setSettlementDealParam(SettlementDealParam settlementDealParam) {
		this.auditType = 3;
		this.dealId = settlementDealParam.getDealId();
		this.settlementDealParam = settlementDealParam;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public GeneralParam getGeneralParam() {
		return generalParam;
	}

	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}

	public Integer getIsMobileApi() {
		return isMobileApi;
	}

	public void setIsMobileApi(Integer isMobileApi) {
		this.isMobileApi = isMobileApi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	public ProcessFinancStatusParam getProcessFinancStatusParam() {
		return processFinancStatusParam;
	}

	public void setProcessFinancStatusParam(ProcessFinancStatusParam processFinancStatusParam) {
		this.dealId = processFinancStatusParam.getDealId();
		// 区分审核类型
		if(0 == processFinancStatusParam.getPfActual()) {
			if(1 == processFinancStatusParam.getAuditStatus()) {
				this.auditType=8;
			}else {
				this.auditType=10;
			}
		}else {
			if(1 == processFinancStatusParam.getAuditStatus()) {
				this.auditType=9;
			}else {
				this.auditType=11;
			}
		}
		this.processFinancStatusParam = processFinancStatusParam;
	}

    public UpdateDealAuditStatusParam getUpdateDealAuditStatusParam() {
        return updateDealAuditStatusParam;
    }

    public void setUpdateDealAuditStatusParam(UpdateDealAuditStatusParam updateDealAuditStatusParam) {
        this.dealId = updateDealAuditStatusParam.getDealId();
        // 区分审核类型
		if(null != updateDealAuditStatusParam.getDealAuditStatus()) {
			if(1 == updateDealAuditStatusParam.getDealAuditStatus()) {
				this.auditType=1;
			}else if(2 == updateDealAuditStatusParam.getDealAuditStatus()) {
				this.auditType=2;
			}else if(3 == updateDealAuditStatusParam.getDealAuditStatus()) {
				this.auditType=4;
			}else if(5 == updateDealAuditStatusParam.getDealAuditStatus()) {
				this.auditType=5;
			}else if(6 == updateDealAuditStatusParam.getDealAuditStatus()) {
				this.auditType=6;
			}
		}else {
			this.auditType=5;
		}

        this.updateDealAuditStatusParam = updateDealAuditStatusParam;
    }

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public boolean isFangJidi() {
		return isFangJidi;
	}

	public void setFangJidi(boolean fangJidi) {
		isFangJidi = fangJidi;
	}
}
