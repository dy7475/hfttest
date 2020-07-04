package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunAttendanceRecordDetail extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增")
	private Integer attId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户ERP库ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ERP库ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区ERP库ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ERP库ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ERP库ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ERP库ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤地点坐标X-纬度")
	private String attX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤地点坐标Y-经度")
	private String attY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配置的考勤地点中文描述		例：世纪城南路888号")
	private String locationDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置应该的考勤时间	例 2017-01-01 09:00")
	private Date configAttTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "APP上传考勤时间			例2017-10-10 23:00")
	private Date localAttTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "服务器记录的考勤时间	例		2017-10-10 23:00")
	private Date serverAttTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤上班或者下班	上班：1 、下班：2    (默认 0)")
	private Byte attAttribute;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤设置 0有考勤组、1：休息、2：未配置考勤组")
	private Byte attRest;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤类型(1：排班打卡、2：固定班次打卡)")
	private Byte attType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否为离线上传 1是、默认：0否")
	private Byte offLineUpload;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤组ID")
	private Integer attGrId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "班次ID")
	private Integer attClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "一天中第几次打卡：值：1/2/3、默认（0）")
	private Byte attNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "附件存储地址 例如：group/m01/kqwhdnasqhoiio12312.jpg")
	private String extraPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "附件类型：1、图片，2：文件")
	private Byte extraType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有附件：1有、默认：0没有")
	private Byte extraExist;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备注文案描述")
	private String attRemark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实际位置考勤结果 - 1正常、2外勤")
	private Byte locationAttResult;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实际时间考勤结果 - 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假 11休息 12 （审核来的请假）")
	private Byte timeAttResult;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte manageLocationAttResult;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息  12 （审核来的请假）（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数")
	private Byte manageTimeAttResult;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "本次打卡共需要几次打卡 ：1/2/3，每一轮上班下班算1次，")
	private Byte attSumCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编辑人所属门店ID")
	private Integer editDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编辑人USER_ID")
	private Integer editUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编辑后的备注信息")
	private String editRemark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实际应该打卡的日期，用于方便计算每天打卡的日期，格式：2017-01-01，只精确到天，例如：2017-01-29号上班，但是要在2017-01-30号次日下班，考勤记录时间应是2017-01-29")
	private Date attOughtDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "本次打卡系统设置的ID、关联FUN_ATTENDANCE_SCOPE的主键，需求背景：公司可能会设置多个有效的打卡地点")
	private Integer attScopeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备编号作为后期根据设备号判断用户是否用同事的手机打卡等")
	private String deviceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1：安卓、2：苹果")
	private Byte deviceType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备名称，例如：iphone6、iphone8plus、huawei、xiaomi、vivo、oppo等")
	private String deviceName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "如果迟到，那么迟到几分钟、如果早退，早退多少分钟")
	private Integer belateMinute;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打卡用户的档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配置打卡的地址")
	private String attConfigLocation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配置打卡范围距离")
	private Integer attConfigDistance;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "配置打卡时间第一次上班到最后一次下班 格式：9：00-18:00")
	private String attClassClocktime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤结果权重。6:迟到,5:早退,4:缺卡,3:外勤打卡,2:请假,1:正常打卡")
	private Byte attResultWeight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤分组名称")
	private String attGroupName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤班次名称")
	private String attClassName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte attWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打卡WIFI库ID")
	private Integer wifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WIFI打卡，WIFI的SSID名称")
	private String attWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WIFI打卡，WIFI的MAC地址")
	private String attWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实际考勤地点中文描述，和本表中的 LOCATION_DESC 字段分别存储配置的位置和实际位置	，例如：天府软件园 D 区")
	private String actualLocationDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤修改日期")
	private Date editDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer auditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String leaveAuditName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增
	 */
	public Integer getAttId() {
		return attId;
	}

	/**
	 * @mbggenerated 主键自增
	 */
	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	/**
	 * @mbggenerated 用户ERP库ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 用户ERP库ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 公司ERP库ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ERP库ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 大区ERP库ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区ERP库ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区ERP库ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区ERP库ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 门店ERP库ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ERP库ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated ERP库ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated ERP库ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 考勤地点坐标X-纬度
	 */
	public String getAttX() {
		return attX;
	}

	/**
	 * @mbggenerated 考勤地点坐标X-纬度
	 */
	public void setAttX(String attX) {
		this.attX = attX == null ? null : attX.trim();
	}

	/**
	 * @mbggenerated 考勤地点坐标Y-经度
	 */
	public String getAttY() {
		return attY;
	}

	/**
	 * @mbggenerated 考勤地点坐标Y-经度
	 */
	public void setAttY(String attY) {
		this.attY = attY == null ? null : attY.trim();
	}

	/**
	 * @mbggenerated 配置的考勤地点中文描述		例：世纪城南路888号
	 */
	public String getLocationDesc() {
		return locationDesc;
	}

	/**
	 * @mbggenerated 配置的考勤地点中文描述		例：世纪城南路888号
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc == null ? null : locationDesc.trim();
	}

	/**
	 * @mbggenerated 系统配置应该的考勤时间	例 2017-01-01 09:00
	 */
	public Date getConfigAttTime() {
		return configAttTime;
	}

	/**
	 * @mbggenerated 系统配置应该的考勤时间	例 2017-01-01 09:00
	 */
	public void setConfigAttTime(Date configAttTime) {
		this.configAttTime = configAttTime;
	}

	/**
	 * @mbggenerated APP上传考勤时间			例2017-10-10 23:00
	 */
	public Date getLocalAttTime() {
		return localAttTime;
	}

	/**
	 * @mbggenerated APP上传考勤时间			例2017-10-10 23:00
	 */
	public void setLocalAttTime(Date localAttTime) {
		this.localAttTime = localAttTime;
	}

	/**
	 * @mbggenerated 服务器记录的考勤时间	例		2017-10-10 23:00
	 */
	public Date getServerAttTime() {
		return serverAttTime;
	}

	/**
	 * @mbggenerated 服务器记录的考勤时间	例		2017-10-10 23:00
	 */
	public void setServerAttTime(Date serverAttTime) {
		this.serverAttTime = serverAttTime;
	}

	/**
	 * @mbggenerated 考勤上班或者下班	上班：1 、下班：2    (默认 0)
	 */
	public Byte getAttAttribute() {
		return attAttribute;
	}

	/**
	 * @mbggenerated 考勤上班或者下班	上班：1 、下班：2    (默认 0)
	 */
	public void setAttAttribute(Byte attAttribute) {
		this.attAttribute = attAttribute;
	}

	/**
	 * @mbggenerated 考勤设置 0有考勤组、1：休息、2：未配置考勤组
	 */
	public Byte getAttRest() {
		return attRest;
	}

	/**
	 * @mbggenerated 考勤设置 0有考勤组、1：休息、2：未配置考勤组
	 */
	public void setAttRest(Byte attRest) {
		this.attRest = attRest;
	}

	/**
	 * @mbggenerated 考勤类型(1：排班打卡、2：固定班次打卡)
	 */
	public Byte getAttType() {
		return attType;
	}

	/**
	 * @mbggenerated 考勤类型(1：排班打卡、2：固定班次打卡)
	 */
	public void setAttType(Byte attType) {
		this.attType = attType;
	}

	/**
	 * @mbggenerated 是否为离线上传 1是、默认：0否
	 */
	public Byte getOffLineUpload() {
		return offLineUpload;
	}

	/**
	 * @mbggenerated 是否为离线上传 1是、默认：0否
	 */
	public void setOffLineUpload(Byte offLineUpload) {
		this.offLineUpload = offLineUpload;
	}

	/**
	 * @mbggenerated 考勤组ID
	 */
	public Integer getAttGrId() {
		return attGrId;
	}

	/**
	 * @mbggenerated 考勤组ID
	 */
	public void setAttGrId(Integer attGrId) {
		this.attGrId = attGrId;
	}

	/**
	 * @mbggenerated 班次ID
	 */
	public Integer getAttClassId() {
		return attClassId;
	}

	/**
	 * @mbggenerated 班次ID
	 */
	public void setAttClassId(Integer attClassId) {
		this.attClassId = attClassId;
	}

	/**
	 * @mbggenerated 一天中第几次打卡：值：1/2/3、默认（0）
	 */
	public Byte getAttNum() {
		return attNum;
	}

	/**
	 * @mbggenerated 一天中第几次打卡：值：1/2/3、默认（0）
	 */
	public void setAttNum(Byte attNum) {
		this.attNum = attNum;
	}

	/**
	 * @mbggenerated 附件存储地址 例如：group/m01/kqwhdnasqhoiio12312.jpg
	 */
	public String getExtraPath() {
		return extraPath;
	}

	/**
	 * @mbggenerated 附件存储地址 例如：group/m01/kqwhdnasqhoiio12312.jpg
	 */
	public void setExtraPath(String extraPath) {
		this.extraPath = extraPath == null ? null : extraPath.trim();
	}

	/**
	 * @mbggenerated 附件类型：1、图片，2：文件
	 */
	public Byte getExtraType() {
		return extraType;
	}

	/**
	 * @mbggenerated 附件类型：1、图片，2：文件
	 */
	public void setExtraType(Byte extraType) {
		this.extraType = extraType;
	}

	/**
	 * @mbggenerated 是否有附件：1有、默认：0没有
	 */
	public Byte getExtraExist() {
		return extraExist;
	}

	/**
	 * @mbggenerated 是否有附件：1有、默认：0没有
	 */
	public void setExtraExist(Byte extraExist) {
		this.extraExist = extraExist;
	}

	/**
	 * @mbggenerated 备注文案描述
	 */
	public String getAttRemark() {
		return attRemark;
	}

	/**
	 * @mbggenerated 备注文案描述
	 */
	public void setAttRemark(String attRemark) {
		this.attRemark = attRemark == null ? null : attRemark.trim();
	}

	/**
	 * @mbggenerated 实际位置考勤结果 - 1正常、2外勤
	 */
	public Byte getLocationAttResult() {
		return locationAttResult;
	}

	/**
	 * @mbggenerated 实际位置考勤结果 - 1正常、2外勤
	 */
	public void setLocationAttResult(Byte locationAttResult) {
		this.locationAttResult = locationAttResult;
	}

	/**
	 * @mbggenerated 实际时间考勤结果 - 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假 11休息 12 （审核来的请假）
	 */
	public Byte getTimeAttResult() {
		return timeAttResult;
	}

	/**
	 * @mbggenerated 实际时间考勤结果 - 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假 11休息 12 （审核来的请假）
	 */
	public void setTimeAttResult(Byte timeAttResult) {
		this.timeAttResult = timeAttResult;
	}

	/**
	 * @mbggenerated 位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getManageLocationAttResult() {
		return manageLocationAttResult;
	}

	/**
	 * @mbggenerated 位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setManageLocationAttResult(Byte manageLocationAttResult) {
		this.manageLocationAttResult = manageLocationAttResult;
	}

	/**
	 * @mbggenerated 时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息  12 （审核来的请假）（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数
	 */
	public Byte getManageTimeAttResult() {
		return manageTimeAttResult;
	}

	/**
	 * @mbggenerated 时间考勤结果-管理员 0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息  12 （审核来的请假）（服务器端根据时间动态计算结果）(默认0) - 实际与前端交互的参数
	 */
	public void setManageTimeAttResult(Byte manageTimeAttResult) {
		this.manageTimeAttResult = manageTimeAttResult;
	}

	/**
	 * @mbggenerated 本次打卡共需要几次打卡 ：1/2/3，每一轮上班下班算1次，
	 */
	public Byte getAttSumCount() {
		return attSumCount;
	}

	/**
	 * @mbggenerated 本次打卡共需要几次打卡 ：1/2/3，每一轮上班下班算1次，
	 */
	public void setAttSumCount(Byte attSumCount) {
		this.attSumCount = attSumCount;
	}

	/**
	 * @mbggenerated 编辑人所属门店ID
	 */
	public Integer getEditDeptId() {
		return editDeptId;
	}

	/**
	 * @mbggenerated 编辑人所属门店ID
	 */
	public void setEditDeptId(Integer editDeptId) {
		this.editDeptId = editDeptId;
	}

	/**
	 * @mbggenerated 编辑人USER_ID
	 */
	public Integer getEditUserId() {
		return editUserId;
	}

	/**
	 * @mbggenerated 编辑人USER_ID
	 */
	public void setEditUserId(Integer editUserId) {
		this.editUserId = editUserId;
	}

	/**
	 * @mbggenerated 编辑后的备注信息
	 */
	public String getEditRemark() {
		return editRemark;
	}

	/**
	 * @mbggenerated 编辑后的备注信息
	 */
	public void setEditRemark(String editRemark) {
		this.editRemark = editRemark == null ? null : editRemark.trim();
	}

	/**
	 * @mbggenerated 实际应该打卡的日期，用于方便计算每天打卡的日期，格式：2017-01-01，只精确到天，例如：2017-01-29号上班，但是要在2017-01-30号次日下班，考勤记录时间应是2017-01-29
	 */
	public Date getAttOughtDate() {
		return attOughtDate;
	}

	/**
	 * @mbggenerated 实际应该打卡的日期，用于方便计算每天打卡的日期，格式：2017-01-01，只精确到天，例如：2017-01-29号上班，但是要在2017-01-30号次日下班，考勤记录时间应是2017-01-29
	 */
	public void setAttOughtDate(Date attOughtDate) {
		this.attOughtDate = attOughtDate;
	}

	/**
	 * @mbggenerated 本次打卡系统设置的ID、关联FUN_ATTENDANCE_SCOPE的主键，需求背景：公司可能会设置多个有效的打卡地点
	 */
	public Integer getAttScopeId() {
		return attScopeId;
	}

	/**
	 * @mbggenerated 本次打卡系统设置的ID、关联FUN_ATTENDANCE_SCOPE的主键，需求背景：公司可能会设置多个有效的打卡地点
	 */
	public void setAttScopeId(Integer attScopeId) {
		this.attScopeId = attScopeId;
	}

	/**
	 * @mbggenerated 设备编号作为后期根据设备号判断用户是否用同事的手机打卡等
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @mbggenerated 设备编号作为后期根据设备号判断用户是否用同事的手机打卡等
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId == null ? null : deviceId.trim();
	}

	/**
	 * @mbggenerated 1：安卓、2：苹果
	 */
	public Byte getDeviceType() {
		return deviceType;
	}

	/**
	 * @mbggenerated 1：安卓、2：苹果
	 */
	public void setDeviceType(Byte deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @mbggenerated 设备名称，例如：iphone6、iphone8plus、huawei、xiaomi、vivo、oppo等
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @mbggenerated 设备名称，例如：iphone6、iphone8plus、huawei、xiaomi、vivo、oppo等
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName == null ? null : deviceName.trim();
	}

	/**
	 * @mbggenerated 如果迟到，那么迟到几分钟、如果早退，早退多少分钟
	 */
	public Integer getBelateMinute() {
		return belateMinute;
	}

	/**
	 * @mbggenerated 如果迟到，那么迟到几分钟、如果早退，早退多少分钟
	 */
	public void setBelateMinute(Integer belateMinute) {
		this.belateMinute = belateMinute;
	}

	/**
	 * @mbggenerated 打卡用户的档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 打卡用户的档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 配置打卡的地址
	 */
	public String getAttConfigLocation() {
		return attConfigLocation;
	}

	/**
	 * @mbggenerated 配置打卡的地址
	 */
	public void setAttConfigLocation(String attConfigLocation) {
		this.attConfigLocation = attConfigLocation == null ? null : attConfigLocation.trim();
	}

	/**
	 * @mbggenerated 配置打卡范围距离
	 */
	public Integer getAttConfigDistance() {
		return attConfigDistance;
	}

	/**
	 * @mbggenerated 配置打卡范围距离
	 */
	public void setAttConfigDistance(Integer attConfigDistance) {
		this.attConfigDistance = attConfigDistance;
	}

	/**
	 * @mbggenerated 配置打卡时间第一次上班到最后一次下班 格式：9：00-18:00
	 */
	public String getAttClassClocktime() {
		return attClassClocktime;
	}

	/**
	 * @mbggenerated 配置打卡时间第一次上班到最后一次下班 格式：9：00-18:00
	 */
	public void setAttClassClocktime(String attClassClocktime) {
		this.attClassClocktime = attClassClocktime == null ? null : attClassClocktime.trim();
	}

	/**
	 * @mbggenerated 考勤结果权重。6:迟到,5:早退,4:缺卡,3:外勤打卡,2:请假,1:正常打卡
	 */
	public Byte getAttResultWeight() {
		return attResultWeight;
	}

	/**
	 * @mbggenerated 考勤结果权重。6:迟到,5:早退,4:缺卡,3:外勤打卡,2:请假,1:正常打卡
	 */
	public void setAttResultWeight(Byte attResultWeight) {
		this.attResultWeight = attResultWeight;
	}

	/**
	 * @mbggenerated 考勤分组名称
	 */
	public String getAttGroupName() {
		return attGroupName;
	}

	/**
	 * @mbggenerated 考勤分组名称
	 */
	public void setAttGroupName(String attGroupName) {
		this.attGroupName = attGroupName == null ? null : attGroupName.trim();
	}

	/**
	 * @mbggenerated 考勤班次名称
	 */
	public String getAttClassName() {
		return attClassName;
	}

	/**
	 * @mbggenerated 考勤班次名称
	 */
	public void setAttClassName(String attClassName) {
		this.attClassName = attClassName == null ? null : attClassName.trim();
	}

	/**
	 * @mbggenerated 打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getAttWay() {
		return attWay;
	}

	/**
	 * @mbggenerated 打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setAttWay(Byte attWay) {
		this.attWay = attWay;
	}

	/**
	 * @mbggenerated 打卡WIFI库ID
	 */
	public Integer getWifiId() {
		return wifiId;
	}

	/**
	 * @mbggenerated 打卡WIFI库ID
	 */
	public void setWifiId(Integer wifiId) {
		this.wifiId = wifiId;
	}

	/**
	 * @mbggenerated WIFI打卡，WIFI的SSID名称
	 */
	public String getAttWifiSsid() {
		return attWifiSsid;
	}

	/**
	 * @mbggenerated WIFI打卡，WIFI的SSID名称
	 */
	public void setAttWifiSsid(String attWifiSsid) {
		this.attWifiSsid = attWifiSsid == null ? null : attWifiSsid.trim();
	}

	/**
	 * @mbggenerated WIFI打卡，WIFI的MAC地址
	 */
	public String getAttWifiMac() {
		return attWifiMac;
	}

	/**
	 * @mbggenerated WIFI打卡，WIFI的MAC地址
	 */
	public void setAttWifiMac(String attWifiMac) {
		this.attWifiMac = attWifiMac == null ? null : attWifiMac.trim();
	}

	/**
	 * @mbggenerated 实际考勤地点中文描述，和本表中的 LOCATION_DESC 字段分别存储配置的位置和实际位置	，例如：天府软件园 D 区
	 */
	public String getActualLocationDesc() {
		return actualLocationDesc;
	}

	/**
	 * @mbggenerated 实际考勤地点中文描述，和本表中的 LOCATION_DESC 字段分别存储配置的位置和实际位置	，例如：天府软件园 D 区
	 */
	public void setActualLocationDesc(String actualLocationDesc) {
		this.actualLocationDesc = actualLocationDesc == null ? null : actualLocationDesc.trim();
	}

	/**
	 * @mbggenerated 考勤修改日期
	 */
	public Date getEditDate() {
		return editDate;
	}

	/**
	 * @mbggenerated 考勤修改日期
	 */
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getLeaveAuditName() {
		return leaveAuditName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaveAuditName(String leaveAuditName) {
		this.leaveAuditName = leaveAuditName == null ? null : leaveAuditName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceRecordDetail() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceRecordDetail(Integer shardCityId, Integer attId) {
		super(shardCityId);
		this.attId = attId;
	}
}