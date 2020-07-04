package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SaveOneSalaryPlanRelativeUserParam extends AbstractEncryParam {
    @ApiModelProperty(value = "薪资方案ID")
    private Integer wageTypeId;
    @ApiModelProperty(value = "分配人员列表以JSON字符串形式")
    private String salaryPlanuserJson;
    @ApiModelProperty(value = "提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司")
    private String royaltyRange;
    @ApiModelProperty(value = "要删除的USER_ID(多个用逗号隔开)")
    private String delUsers;

    public Integer getWageTypeId() {
        return wageTypeId;
    }

    public void setWageTypeId(Integer wageTypeId) {
        this.wageTypeId = wageTypeId;
    }

    public String getSalaryPlanuserJson() {
        return salaryPlanuserJson;
    }

    public void setSalaryPlanuserJson(String salaryPlanuserJson) {
        this.salaryPlanuserJson = salaryPlanuserJson;
    }

    public String getRoyaltyRange() {
        return royaltyRange;
    }

    public void setRoyaltyRange(String royaltyRange) {
        this.royaltyRange = royaltyRange;
    }

    public String getDelUsers() {
        return delUsers;
    }

    public void setDelUsers(String delUsers) {
        this.delUsers = delUsers;
    }
}
