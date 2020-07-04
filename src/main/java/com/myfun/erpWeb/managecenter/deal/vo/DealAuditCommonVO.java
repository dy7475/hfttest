package com.myfun.erpWeb.managecenter.deal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title 合同操作业务返回对象
 * @Author lcb
 * @Time 2019/7/3 20:16
 * @Desc  
 **/
@ApiModel
public class DealAuditCommonVO {

	// ** 是否需要审核 ** //
	@ApiModelProperty("创建结果")
	private Integer needAudit;
	// ** 审核ID ** //
	@ApiModelProperty("审批ID")
	private Integer id;
	@ApiModelProperty("是否需要刷新")
	private Integer needRefresh = 0;
	@ApiModelProperty("配置不完整")
	private Integer needConfig = 0;

	public Integer getNeedConfig() {
		return needConfig;
	}

	public void setNeedConfig(Integer needConfig) {
		this.needConfig = needConfig;
	}

	public Integer getNeedRefresh() {
		return needRefresh;
	}

	public void setNeedRefresh(Integer needRefresh) {
		this.needRefresh = needRefresh;
	}

	public Integer getNeedAudit() {
		return needAudit;
	}

	public void setNeedAudit(Integer needAudit) {
		this.needAudit = needAudit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
