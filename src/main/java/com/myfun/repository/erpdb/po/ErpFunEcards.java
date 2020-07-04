package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunEcards extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer ecardId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收录人公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收录人分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收录人ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "姓名")
	private String ecardsName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "姓别，1-先生")
	private Boolean ecardsSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "职务")
	private String ecardsPost;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电子邮箱")
	private String ecardsMail;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "QQ号码")
	private String ecardsQq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电话")
	private String ecardsTel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司名称")
	private String ecardsComp;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "方位")
	private String ecardsPos;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地址")
	private String compAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司网址")
	private String compUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备注")
	private String ecardsRemarks;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收录入时间")
	private String createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否公开，0=公开，1=保密")
	private Boolean isPublic;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "与公司关联的人的档案ID")
	private Integer ecardsArchiveId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getEcardId() {
		return ecardId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setEcardId(Integer ecardId) {
		this.ecardId = ecardId;
	}

	/**
	 * @mbggenerated 收录人公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 收录人公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 收录人分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 收录人分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 收录人ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 收录人ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 姓名
	 */
	public String getEcardsName() {
		return ecardsName;
	}

	/**
	 * @mbggenerated 姓名
	 */
	public void setEcardsName(String ecardsName) {
		this.ecardsName = ecardsName == null ? null : ecardsName.trim();
	}

	/**
	 * @mbggenerated 姓别，1-先生
	 */
	public Boolean getEcardsSex() {
		return ecardsSex;
	}

	/**
	 * @mbggenerated 姓别，1-先生
	 */
	public void setEcardsSex(Boolean ecardsSex) {
		this.ecardsSex = ecardsSex;
	}

	/**
	 * @mbggenerated 职务
	 */
	public String getEcardsPost() {
		return ecardsPost;
	}

	/**
	 * @mbggenerated 职务
	 */
	public void setEcardsPost(String ecardsPost) {
		this.ecardsPost = ecardsPost == null ? null : ecardsPost.trim();
	}

	/**
	 * @mbggenerated 电子邮箱
	 */
	public String getEcardsMail() {
		return ecardsMail;
	}

	/**
	 * @mbggenerated 电子邮箱
	 */
	public void setEcardsMail(String ecardsMail) {
		this.ecardsMail = ecardsMail == null ? null : ecardsMail.trim();
	}

	/**
	 * @mbggenerated QQ号码
	 */
	public String getEcardsQq() {
		return ecardsQq;
	}

	/**
	 * @mbggenerated QQ号码
	 */
	public void setEcardsQq(String ecardsQq) {
		this.ecardsQq = ecardsQq == null ? null : ecardsQq.trim();
	}

	/**
	 * @mbggenerated 电话
	 */
	public String getEcardsTel() {
		return ecardsTel;
	}

	/**
	 * @mbggenerated 电话
	 */
	public void setEcardsTel(String ecardsTel) {
		this.ecardsTel = ecardsTel == null ? null : ecardsTel.trim();
	}

	/**
	 * @mbggenerated 公司名称
	 */
	public String getEcardsComp() {
		return ecardsComp;
	}

	/**
	 * @mbggenerated 公司名称
	 */
	public void setEcardsComp(String ecardsComp) {
		this.ecardsComp = ecardsComp == null ? null : ecardsComp.trim();
	}

	/**
	 * @mbggenerated 方位
	 */
	public String getEcardsPos() {
		return ecardsPos;
	}

	/**
	 * @mbggenerated 方位
	 */
	public void setEcardsPos(String ecardsPos) {
		this.ecardsPos = ecardsPos == null ? null : ecardsPos.trim();
	}

	/**
	 * @mbggenerated 地址
	 */
	public String getCompAdd() {
		return compAdd;
	}

	/**
	 * @mbggenerated 地址
	 */
	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd == null ? null : compAdd.trim();
	}

	/**
	 * @mbggenerated 公司网址
	 */
	public String getCompUrl() {
		return compUrl;
	}

	/**
	 * @mbggenerated 公司网址
	 */
	public void setCompUrl(String compUrl) {
		this.compUrl = compUrl == null ? null : compUrl.trim();
	}

	/**
	 * @mbggenerated 备注
	 */
	public String getEcardsRemarks() {
		return ecardsRemarks;
	}

	/**
	 * @mbggenerated 备注
	 */
	public void setEcardsRemarks(String ecardsRemarks) {
		this.ecardsRemarks = ecardsRemarks == null ? null : ecardsRemarks.trim();
	}

	/**
	 * @mbggenerated 收录入时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 收录入时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	/**
	 * @mbggenerated 是否公开，0=公开，1=保密
	 */
	public Boolean getIsPublic() {
		return isPublic;
	}

	/**
	 * @mbggenerated 是否公开，0=公开，1=保密
	 */
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @mbggenerated 与公司关联的人的档案ID
	 */
	public Integer getEcardsArchiveId() {
		return ecardsArchiveId;
	}

	/**
	 * @mbggenerated 与公司关联的人的档案ID
	 */
	public void setEcardsArchiveId(Integer ecardsArchiveId) {
		this.ecardsArchiveId = ecardsArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEcards() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEcards(Integer shardCityId, Integer ecardId) {
		super(shardCityId);
		this.ecardId = ecardId;
	}
}