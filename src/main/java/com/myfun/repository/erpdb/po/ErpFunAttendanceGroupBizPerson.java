package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceGroupBizPerson extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 用户ID
	 */
	private Integer userId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 用户名
	 */
	private String userName;
	/**
	 * @mbggenerated FUN_ATTENDANCE_GROUP_BIZ  关联ID
	 */
	private Integer groupBizId;
	/**
	 * @mbggenerated 考勤组ID
	 */
	private Integer attGroupId;
	/**
	 * @mbggenerated 是否删除    0: 未删除 1：已删除
	 */
	private Byte isDel;
	/**
	 * @mbggenerated 删除时间
	 */
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGroupBizId() {
		return groupBizId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGroupBizId(Integer groupBizId) {
		this.groupBizId = groupBizId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAttGroupId() {
		return attGroupId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttGroupId(Integer attGroupId) {
		this.attGroupId = attGroupId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceGroupBizPerson() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceGroupBizPerson(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}