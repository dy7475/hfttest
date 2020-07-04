package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpAliRenthouseReservation extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "֧ûId")
	private String aliUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Դ")
	private String roomCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Ԣ 1ɢʽ 2Lʽ   flatsTagΪ1, 2,ͱ")
	private Integer flatsTag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ʽyyyy-MM-dd HH:mm")
	private Date lookTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ֻ")
	private String bookPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Ա 0δ֪ 1: 2:Ů")
	private Integer bookSex;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private String remark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ԤԼ")
	private String bookName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer caseUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "תݵID")
	private Integer transCaseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "תݵ 3= 4=")
	private Integer transCaseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated -
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated ֧ûId
	 */
	public String getAliUserId() {
		return aliUserId;
	}

	/**
	 * @mbggenerated ֧ûId
	 */
	public void setAliUserId(String aliUserId) {
		this.aliUserId = aliUserId;
	}

	/**
	 * @mbggenerated Դ
	 */
	public String getRoomCode() {
		return roomCode;
	}

	/**
	 * @mbggenerated Դ
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	/**
	 * @mbggenerated Ԣ 1ɢʽ 2Lʽ   flatsTagΪ1, 2,ͱ
	 */
	public Integer getFlatsTag() {
		return flatsTag;
	}

	/**
	 * @mbggenerated Ԣ 1ɢʽ 2Lʽ   flatsTagΪ1, 2,ͱ
	 */
	public void setFlatsTag(Integer flatsTag) {
		this.flatsTag = flatsTag;
	}

	/**
	 * @mbggenerated ʽyyyy-MM-dd HH:mm
	 */
	public Date getLookTime() {
		return lookTime;
	}

	/**
	 * @mbggenerated ʽyyyy-MM-dd HH:mm
	 */
	public void setLookTime(Date lookTime) {
		this.lookTime = lookTime;
	}

	/**
	 * @mbggenerated ֻ
	 */
	public String getBookPhone() {
		return bookPhone;
	}

	/**
	 * @mbggenerated ֻ
	 */
	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}

	/**
	 * @mbggenerated Ա 0δ֪ 1: 2:Ů
	 */
	public Integer getBookSex() {
		return bookSex;
	}

	/**
	 * @mbggenerated Ա 0δ֪ 1: 2:Ů
	 */
	public void setBookSex(Integer bookSex) {
		this.bookSex = bookSex;
	}

	/**
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated ԤԼ
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @mbggenerated ԤԼ
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCaseUserId() {
		return caseUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated תݵID
	 */
	public Integer getTransCaseId() {
		return transCaseId;
	}

	/**
	 * @mbggenerated תݵID
	 */
	public void setTransCaseId(Integer transCaseId) {
		this.transCaseId = transCaseId;
	}

	/**
	 * @mbggenerated תݵ 3= 4=
	 */
	public Integer getTransCaseType() {
		return transCaseType;
	}

	/**
	 * @mbggenerated תݵ 3= 4=
	 */
	public void setTransCaseType(Integer transCaseType) {
		this.transCaseType = transCaseType;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAliRenthouseReservation() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAliRenthouseReservation(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}