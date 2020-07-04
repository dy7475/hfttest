package com.myfun.erpWeb.managecenter.mlEntrustManage.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author HuangJiang
 * @since 2019年11月26日 16:32:24
 * Modified XXX HuangJiang 2019年11月26日
 */
public class SelectEntrusListParam extends AbstractEncryParam {

    @ApiModelProperty(value = "备案号")
    private String recordNo;
    @ApiModelProperty(value = "是否有效（1=有效；0=无效）")
    private Byte isEffective;
    @ApiModelProperty(value = "人员类型 1=申请人，2=审核人，3=备案人")
    private Integer userType;
    @ApiModelProperty(value = "人员类型对应字段 1=APPROVE_USER_ID 2=AUDIT_USER_ID 3=RECORD_USER", hidden = true)
    private String userTypeCn;
    @ApiModelProperty(value = "公司ID")
    private Integer compId;
    @ApiModelProperty(value = "大区ID")
    private Integer areaId;
    @ApiModelProperty(value = "片区ID")
    private Integer regId;
    @ApiModelProperty(value = "门店ID")
    private Integer deptId;
    @ApiModelProperty(value = "分组ID")
    private Integer grId;
    @ApiModelProperty(value = "员工ID")
    private Integer userId;
    @ApiModelProperty(value = "关联查询的表：1=分组 2=门店 3=片区 4=大区", hidden = true)
    private Integer selectTalbe;
    @ApiModelProperty(value = "是否电子委托：0=否（纸质委托）；1=是（电子委托）")
    private Byte electronicEntrust;
    @ApiModelProperty(value = "状态（有效委托时传这个参数）：0=待审核（未审核） 1=审核拒绝 2=审核完成")
    private Byte auditStatus;
    @ApiModelProperty(value = "状态（无效委托时传这个参数）：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格 ")
    private Byte status;
    @ApiModelProperty(value = "备案状态（1=未备案 2=已备案 0=清空备案）")
    private Byte recordStatus;
    @ApiModelProperty(value = "日期开始")
    private String createTimeStart;
    @ApiModelProperty(value = "开始时间", hidden = true)
    private Date createTime1;
    @ApiModelProperty(value = "日期结束")
    private String createTimeEnd;
    @ApiModelProperty(value = "结束时间", hidden = true)
    private Date createTime2;
    @ApiModelProperty(value = "审核类型", hidden = true)
    private Byte auditType;
    @ApiModelProperty(value = "当前登录人", hidden = true)
    private Integer currentUserId;
    @ApiModelProperty(value = "组织ID，传对应人员类型的组织ID")
    private Integer organizationId;
    @ApiModelProperty(value = "委托类型（1=普通；2=独家）")
    private Byte entrustType;

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public Byte getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Byte entrustType) {
        this.entrustType = entrustType;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    
    public Integer getCurrentUserId() {
        return currentUserId;
    }
    
    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }
    
    public Byte getAuditType() {
        return auditType;
    }
    
    public void setAuditType(Byte auditType) {
        this.auditType = auditType;
    }
    
    public Integer getSelectTalbe() {
        return selectTalbe;
    }
    
    public void setSelectTalbe(Integer selectTalbe) {
        this.selectTalbe = selectTalbe;
    }
    
    public String getUserTypeCn() {
        return userTypeCn;
    }
    
    public void setUserTypeCn(String userTypeCn) {
        this.userTypeCn = userTypeCn;
    }
    
    public Date getCreateTime1() {
        return createTime1;
    }
    
    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }
    
    public Date getCreateTime2() {
        return createTime2;
    }
    
    public void setCreateTime2(Date createTime2) {
        this.createTime2 = createTime2;
    }
    
    public Byte getIsEffective() {
        return isEffective;
    }
    
    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
    }
    
    public Integer getUserType() {
        return userType;
    }
    
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    
    public Integer getCompId() {
        return compId;
    }
    
    public void setCompId(Integer compId) {
        this.compId = compId;
    }
    
    public Integer getAreaId() {
        return areaId;
    }
    
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    
    public Integer getRegId() {
        return regId;
    }
    
    public void setRegId(Integer regId) {
        this.regId = regId;
    }
    
    public Integer getDeptId() {
        return deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    
    public Integer getGrId() {
        return grId;
    }
    
    public void setGrId(Integer grId) {
        this.grId = grId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Byte getElectronicEntrust() {
        return electronicEntrust;
    }
    
    public void setElectronicEntrust(Byte electronicEntrust) {
        this.electronicEntrust = electronicEntrust;
    }
    
    public Byte getAuditStatus() {
        return auditStatus;
    }
    
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }
    
    public Byte getStatus() {
        return status;
    }
    
    public void setStatus(Byte status) {
        this.status = status;
    }
    
    public Byte getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
    
    public String getCreateTimeStart() {
        return createTimeStart;
    }
    
    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    
    public String getCreateTimeEnd() {
        return createTimeEnd;
    }
    
    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
