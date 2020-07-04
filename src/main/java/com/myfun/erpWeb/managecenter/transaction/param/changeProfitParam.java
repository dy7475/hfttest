package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class changeProfitParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "业绩json 例：{\"dealId\":\"51722\",\"profitJson\":\"[{\\\"agreementNo\\\":\\\"S51721190311\\\",\\\"archiveId\\\":\\\"1278831\\\",\\\"areaId\\\":\"17308\",\\\"compId\\\":\\\"12001\\\",\\\"createDate\\\":\\\"2019-03-11 20:42:12\\\",\\\"dealId\\\":\\\"51722\\\",\\\"dealType\\\":\\\"101\\\",\\\"deptId\\\":\\\"903457(在美联环境中如果是公司业绩的话，该字段代表组织机构ID)\\\",\\\"deptName\\\":\\\"ERP部\\\",\\\"discount\\\":\\\"100\\\",\\\"grId\\\":\\\"0\\\",\\\"grName\\\":\\\"\\\",\\\"performanceId\\\":\\\"19392\\\",\\\"performanceName\\\":\\\"房源登记人\\\",\\\"performanceType\\\":\\\"6\\\",\\\"profitId\\\":\\\"81760\\\",\\\"profitMoney\\\":\\\"0\\\",\\\"profitProportion\\\":\\\"5\\\",\\\"profitType\\\":\\\"0\\\",\\\"receivableMoney\\\":\\\"0\\\",\\\"regId\\\":\\\"44306\\\",\\\"remark\\\":\\\"\\\",\\\"roleId\\\":\\\"BIZ_GENERAL\\\",\\\"roleName\\\":\\\"大区经理\\\",\\\"settleFlag\\\":\\\"0\\\",\\\"userId\\\":\\\"20159956\\\",\\\"userName\\\":\\\"杨山\\\",\\\"validFlag\\\":\\\"0\\\"}]\"}")
	private String profitJson;
	@ApiModelProperty(value = "被移除的业绩ID，例：898979,649821,782332")
	private String removeProfitIds;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getProfitJson() {
		return profitJson;
	}

	public void setProfitJson(String profitJson) {
		this.profitJson = profitJson;
	}

	public String getRemoveProfitIds() {
		return removeProfitIds;
	}

	public void setRemoveProfitIds(String removeProfitIds) {
		this.removeProfitIds = removeProfitIds;
	}
}
