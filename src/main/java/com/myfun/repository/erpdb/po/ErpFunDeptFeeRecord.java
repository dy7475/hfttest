package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ErpFunDeptFeeRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键ID") private Integer recordId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="生成时间") private Date creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店ID") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="1:修改 2:审核 3:反审核 4：新增 5删除") private Byte recordType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="用户ID") private Integer userId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="用户名") private String userName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店费用ID") private Integer deptFeeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer grId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer organizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="日志内容") private String recordContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	/**
	 * @mbggenerated 生成时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 生成时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 1:修改 2:审核 3:反审核 4：新增 5删除
	 */
	public Byte getRecordType() {
		return recordType;
	}

	/**
	 * @mbggenerated 1:修改 2:审核 3:反审核 4：新增 5删除
	 */
	public void setRecordType(Byte recordType) {
		this.recordType = recordType;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 门店费用ID
	 */
	public Integer getDeptFeeId() {
		return deptFeeId;
	}

	/**
	 * @mbggenerated 门店费用ID
	 */
	public void setDeptFeeId(Integer deptFeeId) {
		this.deptFeeId = deptFeeId;
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
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 日志内容
	 */
	public String getRecordContent() {
		return recordContent;
	}

	/**
	 * @mbggenerated 日志内容
	 */
	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeptFeeRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDeptFeeRecord(Integer shardCityId, Integer recordId) {
		super(shardCityId);
		this.recordId = recordId;
	}
}