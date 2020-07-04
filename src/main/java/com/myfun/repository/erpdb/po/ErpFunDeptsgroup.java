package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunDeptsgroup extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID，自增序列")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组名称")
	private String grName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "负责人ID")
	private Integer adminUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "负责人姓名")
	private String grContact;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "负责人电话")
	private String grTele;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组描述")
	private String grDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新者")
	private Integer updateUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新时间")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否已被删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 分组ID，自增序列
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID，自增序列
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 分组名称
	 */
	public String getGrName() {
		return grName;
	}

	/**
	 * @mbggenerated 分组名称
	 */
	public void setGrName(String grName) {
		this.grName = grName == null ? null : grName.trim();
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 序号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 负责人ID
	 */
	public Integer getAdminUser() {
		return adminUser;
	}

	/**
	 * @mbggenerated 负责人ID
	 */
	public void setAdminUser(Integer adminUser) {
		this.adminUser = adminUser;
	}

	/**
	 * @mbggenerated 负责人姓名
	 */
	public String getGrContact() {
		return grContact;
	}

	/**
	 * @mbggenerated 负责人姓名
	 */
	public void setGrContact(String grContact) {
		this.grContact = grContact == null ? null : grContact.trim();
	}

	/**
	 * @mbggenerated 负责人电话
	 */
	public String getGrTele() {
		return grTele;
	}

	/**
	 * @mbggenerated 负责人电话
	 */
	public void setGrTele(String grTele) {
		this.grTele = grTele == null ? null : grTele.trim();
	}

	/**
	 * @mbggenerated 分组描述
	 */
	public String getGrDesc() {
		return grDesc;
	}

	/**
	 * @mbggenerated 分组描述
	 */
	public void setGrDesc(String grDesc) {
		this.grDesc = grDesc == null ? null : grDesc.trim();
	}

	/**
	 * @mbggenerated 最后更新者
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 * @mbggenerated 最后更新者
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	/**
	 * @mbggenerated 是否已被删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否已被删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeptsgroup() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeptsgroup(Integer shardCityId, Integer grId) {
		super(shardCityId);
		this.grId = grId;
	}
}