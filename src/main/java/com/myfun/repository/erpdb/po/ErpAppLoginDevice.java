package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpAppLoginDevice extends ShardDb implements Serializable {

	/**
	 * @mbggenerated id
	 */
	private Integer loginId;
	/**
	 * @mbggenerated 公司id
	 */
	private Integer compId;
	/**
	 * @mbggenerated 门店id
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 用户id
	 */
	private Integer userId;
	/**
	 * @mbggenerated 档案id
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 设备类型 1=android 2=ios
	 */
	private Byte deviceType;
	/**
	 * @mbggenerated 设备编号android=imei iso=idfv
	 */
	private String deviceNum1;
	/**
	 * @mbggenerated 设备编号2 android=defindid
	 */
	private String deviceNum2;
	/**
	 * @mbggenerated 状态 0=自动通过审核 1=手动通过审核 2=申请 3=拒绝 4=取消审核 5=过期
	 */
	private Byte deviceStatus;
	/**
	 * @mbggenerated 定位地址
	 */
	private String loginAddress;
	/**
	 * @mbggenerated 个推的token
	 */
	private String getuiToken;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 审核人id
	 */
	private Integer checkUserId;
	/**
	 * @mbggenerated 审核时间
	 */
	private Date checkTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getLoginId() {
		return loginId;
	}

	/**
	 * @mbggenerated
	 */
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
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
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDeviceType() {
		return deviceType;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeviceType(Byte deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @mbggenerated
	 */
	public String getDeviceNum1() {
		return deviceNum1;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeviceNum1(String deviceNum1) {
		this.deviceNum1 = deviceNum1 == null ? null : deviceNum1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDeviceNum2() {
		return deviceNum2;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeviceNum2(String deviceNum2) {
		this.deviceNum2 = deviceNum2 == null ? null : deviceNum2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDeviceStatus() {
		return deviceStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeviceStatus(Byte deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getLoginAddress() {
		return loginAddress;
	}

	/**
	 * @mbggenerated
	 */
	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress == null ? null : loginAddress.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getGetuiToken() {
		return getuiToken;
	}

	/**
	 * @mbggenerated
	 */
	public void setGetuiToken(String getuiToken) {
		this.getuiToken = getuiToken == null ? null : getuiToken.trim();
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
	public Integer getCheckUserId() {
		return checkUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckUserId(Integer checkUserId) {
		this.checkUserId = checkUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAppLoginDevice() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAppLoginDevice(Integer shardCityId, Integer loginId) {
		super(shardCityId);
		this.loginId = loginId;
	}
}