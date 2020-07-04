package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpAttendanceChangeRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "޸ļ¼ID,")
	private Integer recordId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ڼ¼ID")
	private Integer attendanceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ϰ໹° 0ϰ 1° 2")
	private Byte workType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ϰͣ1.42.5ֵ3.6ࣩ")
	private Byte workDetailType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "˵ID")
	private Integer sourceUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ŵID")
	private Integer sourceDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private String sourceUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "޸ID")
	private Integer changeUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "޸")
	private String changeUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "״̬")
	private String changeState;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "޸ԭ")
	private String changeReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ԭʼ")
	private Date sourceCreateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "֯ۺϲѯֶ :12001:12002:12003:")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated ޸ļ¼ID,
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @mbggenerated ޸ļ¼ID,
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	/**
	 * @mbggenerated ڼ¼ID
	 */
	public Integer getAttendanceId() {
		return attendanceId;
	}

	/**
	 * @mbggenerated ڼ¼ID
	 */
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	/**
	 * @mbggenerated ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated ϰ໹° 0ϰ 1° 2
	 */
	public Byte getWorkType() {
		return workType;
	}

	/**
	 * @mbggenerated ϰ໹° 0ϰ 1° 2
	 */
	public void setWorkType(Byte workType) {
		this.workType = workType;
	}

	/**
	 * @mbggenerated ϰͣ1.42.5ֵ3.6ࣩ
	 */
	public Byte getWorkDetailType() {
		return workDetailType;
	}

	/**
	 * @mbggenerated ϰͣ1.42.5ֵ3.6ࣩ
	 */
	public void setWorkDetailType(Byte workDetailType) {
		this.workDetailType = workDetailType;
	}

	/**
	 * @mbggenerated ˵ID
	 */
	public Integer getSourceUserId() {
		return sourceUserId;
	}

	/**
	 * @mbggenerated ˵ID
	 */
	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	/**
	 * @mbggenerated ŵID
	 */
	public Integer getSourceDeptId() {
		return sourceDeptId;
	}

	/**
	 * @mbggenerated ŵID
	 */
	public void setSourceDeptId(Integer sourceDeptId) {
		this.sourceDeptId = sourceDeptId;
	}

	/**
	 * @mbggenerated 
	 */
	public String getSourceUserName() {
		return sourceUserName;
	}

	/**
	 * @mbggenerated 
	 */
	public void setSourceUserName(String sourceUserName) {
		this.sourceUserName = sourceUserName;
	}

	/**
	 * @mbggenerated ޸ID
	 */
	public Integer getChangeUserId() {
		return changeUserId;
	}

	/**
	 * @mbggenerated ޸ID
	 */
	public void setChangeUserId(Integer changeUserId) {
		this.changeUserId = changeUserId;
	}

	/**
	 * @mbggenerated ޸
	 */
	public String getChangeUserName() {
		return changeUserName;
	}

	/**
	 * @mbggenerated ޸
	 */
	public void setChangeUserName(String changeUserName) {
		this.changeUserName = changeUserName;
	}

	/**
	 * @mbggenerated ״̬
	 */
	public String getChangeState() {
		return changeState;
	}

	/**
	 * @mbggenerated ״̬
	 */
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}

	/**
	 * @mbggenerated ޸ԭ
	 */
	public String getChangeReason() {
		return changeReason;
	}

	/**
	 * @mbggenerated ޸ԭ
	 */
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	/**
	 * @mbggenerated ԭʼ
	 */
	public Date getSourceCreateTime() {
		return sourceCreateTime;
	}

	/**
	 * @mbggenerated ԭʼ
	 */
	public void setSourceCreateTime(Date sourceCreateTime) {
		this.sourceCreateTime = sourceCreateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated ֯ۺϲѯֶ :12001:12002:12003:
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated ֯ۺϲѯֶ :12001:12002:12003:
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAttendanceChangeRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAttendanceChangeRecord(Integer shardCityId, Integer recordId) {
		super(shardCityId);
		this.recordId = recordId;
	}
}