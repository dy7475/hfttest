package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpCompRoleLevelsVO;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpFunRoleWageProfit;
import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcount;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelative;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("薪资配置")
public class ErpFunRoleWageConfigDto  implements Serializable {
	
    @ApiModelProperty("工作量考核薪资")
    private List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList;
    
    @ApiModelProperty("业绩考核薪资")
    private List<ErpFunRoleWageProfit> erpFunRoleWageProfitList;
    
    @ApiModelProperty("提成")
    private List<ErpRoleWagetypeRelative> erpRoleWagetypeRelativeList;
    
    @ApiModelProperty("方案")
    private List<ErpFunWageTypeNewDto> erpFunWageTypeNewDtoList;
    
    @ApiModelProperty("角色的管理范围")
    private ErpCompRoles erpCompRoles;
    
    @ApiModelProperty("已设置薪资配置的角色-职级ID集合")
    private List<ErpCompRoleLevelsVO> erpFunRoleLevelIds;
    
    @ApiModelProperty("角色薪资配置ID")
    private Integer id;
    
    @ApiModelProperty("基础工资")
    private BigDecimal baseWage;
   
    @ApiModelProperty("公司ID")
    private Integer compId;
    
    @ApiModelProperty("创建时间")
    private Date createTime;
    
    @ApiModelProperty("角色ID")
    private String roleId;
    
    @ApiModelProperty("更新时间")
    private Date updateTime;
    
    @ApiModelProperty("管理范围")
    private Byte manageLevel;
    
    @ApiModelProperty("创建人ID")
    private Integer createUid;

    @ApiModelProperty("是否考核 0不考核 1考核 和是否作废一个意思")
    private Byte isCheck;
    
    @ApiModelProperty("考核月份")
    private String assessmentMonth;
    
    @ApiModelProperty("职级ID")
    private Integer roleLevelId;

    public List<ErpFunRoleWageWorkcount> getErpFunRoleWageWorkcountList() {
        return erpFunRoleWageWorkcountList;
    }

    public void setErpFunRoleWageWorkcountList(List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList) {
        this.erpFunRoleWageWorkcountList = erpFunRoleWageWorkcountList;
    }

    public List<ErpFunRoleWageProfit> getErpFunRoleWageProfitList() {
        return erpFunRoleWageProfitList;
    }

    public void setErpFunRoleWageProfitList(List<ErpFunRoleWageProfit> erpFunRoleWageProfitList) {
        this.erpFunRoleWageProfitList = erpFunRoleWageProfitList;
    }

    public List<ErpRoleWagetypeRelative> getErpRoleWagetypeRelativeList() {
        return erpRoleWagetypeRelativeList;
    }

    public void setErpRoleWagetypeRelativeList(List<ErpRoleWagetypeRelative> erpRoleWagetypeRelativeList) {
        this.erpRoleWagetypeRelativeList = erpRoleWagetypeRelativeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(BigDecimal baseWage) {
        this.baseWage = baseWage;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getManageLevel() {
        return manageLevel;
    }

    public void setManageLevel(Byte manageLevel) {
        this.manageLevel = manageLevel;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
    }

    public List<ErpFunWageTypeNewDto> getErpFunWageTypeNewDtoList() {
        return erpFunWageTypeNewDtoList;
    }

    public void setErpFunWageTypeNewDtoList(List<ErpFunWageTypeNewDto> erpFunWageTypeNewDtoList) {
        this.erpFunWageTypeNewDtoList = erpFunWageTypeNewDtoList;
    }

    public ErpCompRoles getErpCompRoles() {
        return erpCompRoles;
    }

    public void setErpCompRoles(ErpCompRoles erpCompRoles) {
        this.erpCompRoles = erpCompRoles;
    }

	public List<ErpCompRoleLevelsVO> getErpFunRoleLevelIds() {
		return erpFunRoleLevelIds;
	}

	public void setErpFunRoleLevelIds(List<ErpCompRoleLevelsVO> erpFunRoleLevelIds) {
		this.erpFunRoleLevelIds = erpFunRoleLevelIds;
	}

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
}
