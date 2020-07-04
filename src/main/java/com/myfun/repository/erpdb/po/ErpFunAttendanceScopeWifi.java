package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceScopeWifi extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated wifi 名字
	 */
	private String wifiSsid;
	/**
	 * @mbggenerated wifi mac
	 */
	private String wifiMac;
	/**
	 * @mbggenerated 上传人
	 */
	private Integer userId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 门店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 提交时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 0 未启用 1：启用 2：删除
	 */
	private Byte wifiStatus;
	/**
	 * @mbggenerated 考勤地址的ID
	 */
	private Integer attScopeId;
	/**
	 * @mbggenerated 状态更新时间
	 */
	private Date updateTime;
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
	public String getWifiSsid() {
		return wifiSsid;
	}

	/**
	 * @mbggenerated
	 */
	public void setWifiSsid(String wifiSsid) {
		this.wifiSsid = wifiSsid == null ? null : wifiSsid.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWifiMac() {
		return wifiMac;
	}

	/**
	 * @mbggenerated
	 */
	public void setWifiMac(String wifiMac) {
		this.wifiMac = wifiMac == null ? null : wifiMac.trim();
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
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	public Byte getWifiStatus() {
		return wifiStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setWifiStatus(Byte wifiStatus) {
		this.wifiStatus = wifiStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAttScopeId() {
		return attScopeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttScopeId(Integer attScopeId) {
		this.attScopeId = attScopeId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceScopeWifi() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceScopeWifi(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}