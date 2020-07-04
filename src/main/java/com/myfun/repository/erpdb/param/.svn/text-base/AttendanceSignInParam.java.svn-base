package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 何明礼
 * @date 2017年11月28日 上午9:53:59
 */
public class AttendanceSignInParam extends AbstractEncryParam implements DaoBaseParam {

	/**
	 * 考勤地点坐标X-纬度
	 **/
	@NotNull(message = "考勤地点坐标经度不能为空")
	private String attendanceX;
	/**
	 * 考勤地点坐标Y-经度
	 */
	@NotNull(message = "考勤地点坐标Y纬度不能为空")
	private String attendanceY;
	/**
	 * 考勤地点中文描述 例：世纪城南路888号
	 */
	@NotNull(message = "考勤地点名称不能不能为空")
	private String locationDesc;
	/**
	 * APP上传考勤时间 时间戳
	 */
	@NotNull(message = "考勤时间不能不能为空")
	private String localAttTime;
	/**
	 * 是否为离线上传 1是、默认：0否
	 */
	private String offLineUpload;
	/**
	 * 考勤上班或者下班	上班：1 、下班：2 (默认 0)
	 */
	@NotNull
	private String attAttribute;
	/**
	 * 一天中第几次打卡：值：1/2/3      默认（0）
	 */
	private String attNum;
	/**
	 * 考勤类型(1：排班打卡:2：固定班次打卡)
	 */
	private String attType;
	/**
	 * 考勤组ID
	 */
	private String attGrId;
	/**
	 * 考勤组名称
	 */
	private String groupName;
	/**
	 * 班次ID
	 */
	private String attClassId;
	/**
	 * 考勤范围ID
	 */
	private String attScopeId;
	/**
	 * 打卡更新id
	 */
	private String attId;
	/**
	 * 考勤设置 0有考勤组、1 休息  2、未配置考勤组
	 */
	@NotNull
	private String attRest;
	/**
	 * 当天需要几次打卡
	 */
	private String attSumCount;
	/**
	 * 当前打卡日期
	 */
	@NotNull
	private String currentAttDate;
	/**
	 * 设备编号作为后期根据设备号判断用户是否用同事的手机打卡等
	 */
	@NotNull
	private String deviceId;
	/**
	 * 1：安卓、2：苹果
	 */
	@NotNull
	private String deviceType;
	/**
	 * 设备名称，例如：iphone6、iphone8plus、huawei、xiaomi、vivo、oppo等
	 */
	@NotNull
	private String deviceName;
	/**
	 * 附件存储地址 例如：group/m01/kqwhdnasqhoiio12312.jpg
	 */
	private String extraPath;
	/**
	 * 附件类型：1、图片，2：文件
	 */
	private String extraType;
	/**
	 * 备注文案描述
	 */
	private String attRemark;
	/**
	 * 迟到或者早退分钟
	 */
	private Integer belateMinute = 0;

	/**
	 * 考勤配置地点
	 */
	private String attConfigLocation;
	/**
	 * 考勤配置距离
	 */
	private String attConfigDistance;
	/**
	 * 考勤配置开始打卡和结束打卡时间段
	 */

	private String attClassClockTime;
	/**
	 * 打卡配置时间（格式 09:00 字符串）
	 */
	private String attConfigTime;

	private Integer archiveId;
	/**
	 * 实际配置应该打卡时间 如 2017-1-2 09:00
	 */
	private Date attConfigTimeDate;

	public String getAttendanceX() {
		return attendanceX;
	}

	public void setAttendanceX(String attendanceX) {
		this.attendanceX = attendanceX;
	}

	public String getAttendanceY() {
		return attendanceY;
	}

	public void setAttendanceY(String attendanceY) {
		this.attendanceY = attendanceY;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocalAttTime() {
		return localAttTime;
	}

	public void setLocalAttTime(String localAttTime) {
		this.localAttTime = localAttTime;
	}

	public String getOffLineUpload() {
		return offLineUpload;
	}

	public void setOffLineUpload(String offLineUpload) {
		this.offLineUpload = offLineUpload;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getAttGrId() {
		return attGrId;
	}

	public void setAttGrId(String attGrId) {
		this.attGrId = attGrId;
	}

	public String getAttClassId() {
		return attClassId;
	}

	public void setAttClassId(String attClassId) {
		this.attClassId = attClassId;
	}

	public String getExtraPath() {
		return extraPath;
	}

	public void setExtraPath(String extraPath) {
		this.extraPath = extraPath;
	}

	public String getExtraType() {
		return extraType;
	}

	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}

	public String getAttRemark() {
		return attRemark;
	}

	public void setAttRemark(String attRemark) {
		this.attRemark = attRemark;
	}

	public String getAttAttribute() {
		return attAttribute;
	}

	public void setAttAttribute(String attAttribute) {
		this.attAttribute = attAttribute;
	}

	public String getAttNum() {
		return attNum;
	}

	public void setAttNum(String attNum) {
		this.attNum = attNum;
	}

	public boolean isAttendanceUp() {
		return "1".equals(attAttribute);
	}

	public String getAttScopeId() {
		return attScopeId;
	}

	public void setAttScopeId(String attScopeId) {
		this.attScopeId = attScopeId;
	}

	public String getAttType() {
		return attType;
	}

	public void setAttType(String attType) {
		this.attType = attType;
	}

	public String getAttId() {
		return attId;
	}

	public void setAttId(String attId) {
		this.attId = attId;
	}

	public String getAttRest() {
		return attRest;
	}

	public void setAttRest(String attRest) {
		this.attRest = attRest;
	}

	public String getAttSumCount() {
		return attSumCount;
	}

	public void setAttSumCount(String attSumCount) {
		this.attSumCount = attSumCount;
	}

	public String getCurrentAttDate() {
		return currentAttDate;
	}

	public void setCurrentAttDate(String currentAttDate) {
		this.currentAttDate = currentAttDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getBelateMinute() {
		return belateMinute;
	}

	public void setBelateMinute(Integer belateMinute) {
		this.belateMinute = belateMinute;
	}

	public String getAttConfigLocation() {
		return attConfigLocation;
	}

	public void setAttConfigLocation(String attConfigLocation) {
		this.attConfigLocation = attConfigLocation;
	}

	public String getAttConfigDistance() {
		return attConfigDistance;
	}

	public void setAttConfigDistance(String attConfigDistance) {
		this.attConfigDistance = attConfigDistance;
	}

	public String getAttClassClockTime() {
		return attClassClockTime;
	}

	public void setAttClassClockTime(String attClassClockTime) {
		this.attClassClockTime = attClassClockTime;
	}

	public String getAttConfigTime() {
		return attConfigTime;
	}

	public void setAttConfigTime(String attConfigTime) {
		this.attConfigTime = attConfigTime;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Date getAttConfigTimeDate() {
		return attConfigTimeDate;
	}

	public void setAttConfigTimeDate(Date attConfigTimeDate) {
		this.attConfigTimeDate = attConfigTimeDate;
	}
}
