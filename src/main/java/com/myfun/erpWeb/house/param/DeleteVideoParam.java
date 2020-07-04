package com.myfun.erpWeb.house.param;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DeleteVideoParam implements EncryParamIfc {
    @ApiModelProperty(value = "视频ID")
    private Integer videoId;
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型")
    private Integer caseType;
    @ApiModelProperty(value = "房源编号")
    private String caseNo;
    @ApiModelProperty(hidden = true)
    private String uploadDeptName;
    @ApiModelProperty(hidden = true)
    private String uploadUserName;
    @ApiModelProperty(hidden = true)
    private String userName;
    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private Integer currentUserId;
    @ApiModelProperty(hidden = true)
    private Integer currentCompId;
    @ApiModelProperty(hidden = true)
    private Integer currentDeptId;
    @ApiModelProperty(hidden = true)
    private String deptName;
    @ApiModelProperty(hidden = true)
    private Object cityShareName;
    @ApiModelProperty(hidden = true)
    private Integer saleLeaseId;
    @ApiModelProperty(hidden = true)
    private Integer saleLeaseType;
    @ApiModelProperty(hidden = true)
    private Integer isMeiLian = 0;
    
    
    
    public Integer getIsMeiLian() {
		return isMeiLian;
	}

	public void setIsMeiLian(Integer isMeiLian) {
		this.isMeiLian = isMeiLian;
	}

	public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    public String getUploadDeptName() {
        return uploadDeptName;
    }

    public void setUploadDeptName(String uploadDeptName) {
        this.uploadDeptName = uploadDeptName;
    }

    public Object getCityShareName() {
        return cityShareName;
    }

    public void setCityShareName(Object cityShareName) {
        this.cityShareName = cityShareName;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
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

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }

    public Integer getCurrentCompId() {
        return currentCompId;
    }

    public void setCurrentCompId(Integer currentCompId) {
        this.currentCompId = currentCompId;
    }

    public Integer getCurrentDeptId() {
        return currentDeptId;
    }

    public void setCurrentDeptId(Integer currentDeptId) {
        this.currentDeptId = currentDeptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public Integer getSaleLeaseId() {
		return saleLeaseId;
	}

	public void setSaleLeaseId(Integer saleLeaseId) {
		this.saleLeaseId = saleLeaseId;
	}

	public Integer getSaleLeaseType() {
		return saleLeaseType;
	}

	public void setSaleLeaseType(Integer saleLeaseType) {
		this.saleLeaseType = saleLeaseType;
	}
    
    
}
