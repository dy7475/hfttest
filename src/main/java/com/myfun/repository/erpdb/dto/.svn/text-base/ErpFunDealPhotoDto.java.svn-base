package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunDealPhoto;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunDealPhotoDto extends ErpFunDealPhoto{
	@ApiModelProperty("是否可以查看 1：可以，0：不可以")
	private Integer canSee;
    @ApiModelProperty("是否可以删除 1：可以，0：不可以")
    private Integer canDel;
	@ApiModelProperty("门店id")
	private Integer deptId;
	@ApiModelProperty("文件大类描述")
	private String fileTypeText;
	@ApiModelProperty("文件小类描述")
	private String fileSubTypeText;

    public Integer getCanDel() {
        return canDel;
    }

    public void setCanDel(Integer canDel) {
        this.canDel = canDel;
    }

    public Integer getCanSee() {
		return canSee;
	}

	public void setCanSee(Integer canSee) {
		this.canSee = canSee;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getFileTypeText() {
	
		return fileTypeText;
	}

	public void setFileTypeText(String fileTypeText) {
	
		this.fileTypeText = fileTypeText;
	}

	public String getFileSubTypeText() {
	
		return fileSubTypeText;
	}

	public void setFileSubTypeText(String fileSubTypeText) {
	
		this.fileSubTypeText = fileSubTypeText;
	}

	
}
