package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DeletePanoramaPhotoParam implements EncryParamIfc {

    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型")
    private Integer caseType;
    @ApiModelProperty(value = "图片IDS")
    private String photoId;
    @ApiModelProperty(hidden = true)
    private String userName;
    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private Integer currentUserId;
    @ApiModelProperty(hidden = true)
    private Integer currentCompId;
    @ApiModelProperty(hidden = true)
    private Integer currentDeptId;
    @ApiModelProperty(hidden = true)
    private String deptName;
    @ApiModelProperty(hidden = true)
    private String[] photoIds;
    @ApiModelProperty(value="可租可售id",hidden = true)
    private Integer saleLeaseId;
    @ApiModelProperty(value="可租可售类型",hidden = true)
    private Integer saleLeaseType;
    
    public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String[] getPhotoIds() {
        return photoIds;
    }

    public void setPhotoIds(String[] photoIds) {
        this.photoIds = photoIds;
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

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
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
