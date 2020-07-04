package com.myfun.erpWeb.managecenter.deal.param;

import com.myfun.erpWeb.managecenter.constract.param.UpdateDealAuditStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.CounterMgrSettleDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.SettlementDealParam;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.GeneralParam;

/**
 * @Title 合同权证业务通用参数类
 * @Author lcb
 * @Time 2019/7/3 19:25
 * @Desc
 **/

public class DealBussinessCommonParam extends AbstractEncryParam {
	// 1=初审 2=复审 3=结算 4=合同作废 5=撤销初审 6=撤销复审 7= 撤销结算 8=应收审核 9=实收审核 10=撤销应收审核 11=撤销实收审核
	private Integer auditType;
	// 共用参数
	private GeneralParam generalParam;

	// ** 财务款项审核参数 **//
	private ProcessFinancStatusParam processFinancStatusParam;

	private UpdateDealAuditStatusParam updateDealAuditStatusParam;

	private SettlementDealParam settlementDealParam;

	private CounterMgrSettleDealParam counterMgrSettleDealParam;

	public CounterMgrSettleDealParam getCounterMgrSettleDealParam() {
		return counterMgrSettleDealParam;
	}

	public void setCounterMgrSettleDealParam(CounterMgrSettleDealParam counterMgrSettleDealParam) {
		this.counterMgrSettleDealParam = counterMgrSettleDealParam;
	}

	public SettlementDealParam getSettlementDealParam() {
		return settlementDealParam;
	}

	public void setSettlementDealParam(SettlementDealParam settlementDealParam) {
		this.settlementDealParam = settlementDealParam;
	}

	public UpdateDealAuditStatusParam getUpdateDealAuditStatusParam() {
		return updateDealAuditStatusParam;
	}

	public void setUpdateDealAuditStatusParam(UpdateDealAuditStatusParam updateDealAuditStatusParam) {
		this.updateDealAuditStatusParam = updateDealAuditStatusParam;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	public GeneralParam getGeneralParam() {
		return generalParam;
	}

	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}

	public ProcessFinancStatusParam getProcessFinancStatusParam() {
		return processFinancStatusParam;
	}

	public void setProcessFinancStatusParam(ProcessFinancStatusParam processFinancStatusParam) {
		this.processFinancStatusParam = processFinancStatusParam;
	}
}
