package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunEcardsDto {
	@ApiModelProperty(value = "主键ID")
	private Integer ecardId;
	@ApiModelProperty(value = "收录人公司ID")
	private Integer compId;
	@ApiModelProperty(value = "收录人分店ID")
	private Integer deptId;
	@ApiModelProperty(value = "收录人ID")
	private Integer archiveId;
	@ApiModelProperty(value = "姓名")
	private String ecardsName;
	@ApiModelProperty(value = "姓别，1-先生")
	private Boolean ecardsSex;
	@ApiModelProperty(value = "职务")
	private String ecardsPost;
	@ApiModelProperty(value = "电子邮箱")
	private String ecardsMail;
	@ApiModelProperty(value = "QQ号码")
	private String ecardsQq;
	@ApiModelProperty(value = "电话")
	private String ecardsTel;
	@ApiModelProperty(value = "公司名称")
	private String ecardsComp;
	@ApiModelProperty(value = "方位")
	private String ecardsPos;
	@ApiModelProperty(value = "地址")
	private String compAdd;
	@ApiModelProperty(value = "公司网址")
	private String compUrl;
	@ApiModelProperty(value = "备注")
	private String ecardsRemarks;
	@ApiModelProperty(value = "收录入时间")
	private String createTime;
	@ApiModelProperty(value = "是否公开，0=公开，1=保密")
	private Boolean isPublic;
	@ApiModelProperty(value = "与公司关联的人的档案ID")
	private Integer ecardsArchiveId;
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getEcardId() {
		return ecardId;
	}
	public void setEcardId(Integer ecardId) {
		this.ecardId = ecardId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getEcardsName() {
		return ecardsName;
	}
	public void setEcardsName(String ecardsName) {
		this.ecardsName = ecardsName;
	}
	public Boolean getEcardsSex() {
		return ecardsSex;
	}
	public void setEcardsSex(Boolean ecardsSex) {
		this.ecardsSex = ecardsSex;
	}
	public String getEcardsPost() {
		return ecardsPost;
	}
	public void setEcardsPost(String ecardsPost) {
		this.ecardsPost = ecardsPost;
	}
	public String getEcardsMail() {
		return ecardsMail;
	}
	public void setEcardsMail(String ecardsMail) {
		this.ecardsMail = ecardsMail;
	}
	public String getEcardsQq() {
		return ecardsQq;
	}
	public void setEcardsQq(String ecardsQq) {
		this.ecardsQq = ecardsQq;
	}
	public String getEcardsTel() {
		return ecardsTel;
	}
	public void setEcardsTel(String ecardsTel) {
		this.ecardsTel = ecardsTel;
	}
	public String getEcardsComp() {
		return ecardsComp;
	}
	public void setEcardsComp(String ecardsComp) {
		this.ecardsComp = ecardsComp;
	}
	public String getEcardsPos() {
		return ecardsPos;
	}
	public void setEcardsPos(String ecardsPos) {
		this.ecardsPos = ecardsPos;
	}
	public String getCompAdd() {
		return compAdd;
	}
	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd;
	}
	public String getCompUrl() {
		return compUrl;
	}
	public void setCompUrl(String compUrl) {
		this.compUrl = compUrl;
	}
	public String getEcardsRemarks() {
		return ecardsRemarks;
	}
	public void setEcardsRemarks(String ecardsRemarks) {
		this.ecardsRemarks = ecardsRemarks;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Integer getEcardsArchiveId() {
		return ecardsArchiveId;
	}
	public void setEcardsArchiveId(Integer ecardsArchiveId) {
		this.ecardsArchiveId = ecardsArchiveId;
	}
}
