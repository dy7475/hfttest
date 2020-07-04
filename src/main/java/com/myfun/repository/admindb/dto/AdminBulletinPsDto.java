package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminBulletinPs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminBulletinPsDto extends AdminBulletinPs{

	private static final long serialVersionUID = 1L;
	@ApiModelProperty("文件大小")
	private String fileSizeStr;
	@ApiModelProperty("文件类型")
	private String fileType;
	
	public String getFileSizeStr() {
		return fileSizeStr;
	}
	public void setFileSizeStr(String fileSizeStr) {
		this.fileSizeStr = fileSizeStr;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
