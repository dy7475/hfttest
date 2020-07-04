package com.myfun.erpWeb.businesstools.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "获取电子名片详情VO")
public class EcardsByDataVo implements Serializable {
	/**
	 * @mbggenerated 主键ID
	 */
	@ApiModelProperty("主键ID")
	private Integer ecardId;
	/**
	 * @mbggenerated 收录人公司ID
	 */
	@ApiModelProperty("收录人公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 收录人分店ID
	 */
	@ApiModelProperty("收录人分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated 收录人ID
	 */
	@ApiModelProperty("收录人ID")
	private Integer archiveId;
	/**
	 * @mbggenerated 姓名
	 */
	@ApiModelProperty("姓名")
	private String ecardsName;
	/**
	 * @mbggenerated 姓别，1-先生
	 */
	@ApiModelProperty("姓别，1-先生")
	private Boolean ecardsSex;
	/**
	 * @mbggenerated 职务
	 */
	@ApiModelProperty("职务")
	private String ecardsPost;
	/**
	 * @mbggenerated 电子邮箱
	 */
	@ApiModelProperty("电子邮箱")
	private String ecardsMail;
	/**
	 * @mbggenerated QQ号码
	 */
	@ApiModelProperty("QQ号码")
	private String ecardsQq;
	/**
	 * @mbggenerated 电话
	 */
	@ApiModelProperty("电话")
	private String ecardsTel;
	/**
	 * @mbggenerated 公司名称
	 */
	@ApiModelProperty("公司名称")
	private String ecardsComp;
	/**
	 * @mbggenerated 方位
	 */
	@ApiModelProperty("方位")
	private String ecardsPos;
	/**
	 * @mbggenerated 地址
	 */
	@ApiModelProperty("地址")
	private String compAdd;
	/**
	 * @mbggenerated 公司网址
	 */
	@ApiModelProperty("公司网址")
	private String compUrl;
	/**
	 * @mbggenerated 备注
	 */
	@ApiModelProperty("备注")
	private String ecardsRemarks;
	/**
	 * @mbggenerated 收录入时间
	 */
	@ApiModelProperty("收录入时间")
	private String createTime;
	/**
	 * @mbggenerated 是否公开，0=公开，1=保密
	 */
	@ApiModelProperty("是否公开，0=公开，1=保密")
	private Boolean isPublic;
	/**
	 * @mbggenerated 与公司关联的人的档案ID
	 */
	@ApiModelProperty("与公司关联的人的档案ID")
	private Integer ecardsArchiveId;

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

	public Boolean getPublic() {
		return isPublic;
	}

	public void setPublic(Boolean aPublic) {
		isPublic = aPublic;
	}

	public Integer getEcardsArchiveId() {
		return ecardsArchiveId;
	}

	public void setEcardsArchiveId(Integer ecardsArchiveId) {
		this.ecardsArchiveId = ecardsArchiveId;
	}
}
