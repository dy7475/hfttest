package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class ErpFunAttendanceStatistics extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键id")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "员工id")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤时间")
	private Date attDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤组id")
	private Integer attGrId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤班次id")
	private Integer attClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤班次名称")
	private String attClassName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤班次时间  ")
	private String attClassClocktime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = " 是否休息（1是、0否、2代表没有排班、3缺卡。默认：0）")
	private Byte offWork;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte firstWorkOn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte firstWorkonType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡修改人，erp库USER_ID")
	private Integer firstWorkonChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡修改人门店，erp库DEPT_ID")
	private Integer firstWorkonChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡时间，后面不用说你都知道是什么意思啦")
	private Date firstWorkOntime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte secondWorkOn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte secondWorkonType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡修改人，erp库USER_ID")
	private Integer secondWorkonChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡修改人门店，erp库DEPT_ID")
	private Integer secondWorkonChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡时间")
	private Date secondWorkOntime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte threeWorkOn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = " 第三次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte threeWorkonType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡修改人，erp库USER_ID")
	private Integer threeWorkonChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡修改人门店，erp库DEPT_ID")
	private Integer threeWorkonChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡时间")
	private Date threeWorkOntime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte firstWorkOff;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte firstWorkoffType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡修改人，erp库USER_ID")
	private Integer firstWorkoffChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡修改人门店，erp库DEPT_ID")
	private Integer firstWorkoffChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡时间")
	private Date firstWorkOfftime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte secondWorkOff;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte secondWorkoffType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡修改人，erp库USER_ID")
	private Integer secondWorkoffChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡修改人门店，erp库DEPT_ID")
	private Integer secondWorkoffChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡时间")
	private Date secondWorkOfftime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)")
	private Byte threeWorkOff;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)")
	private Byte threeWorkoffType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡修改人，erp库USER_ID")
	private Integer threeWorkoffChangeuser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡修改人门店，erp库DEPT_ID")
	private Integer threeWorkoffChangedept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡时间")
	private Date threeWorkOfftime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "一共打几轮卡")
	private Byte attSumCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡修改备注")
	private String firstWorkonChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡修改备注")
	private String secondWorkonChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡修改备注")
	private String threeWorkonChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡修改备注")
	private String firstWorkoffChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡修改备注")
	private String secondWorkoffChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡修改备注")
	private String threeWorkoffChangeremark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "打卡用户的档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第一次上班打卡时间")
	private String firstWorkOnconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第一次下班打卡时间")
	private String firstWorkOffconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第二次上班打卡时间")
	private String secondWorkOnconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第二次下班打卡时间")
	private String secondWorkOffconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第三次上班打卡时间")
	private String threeWorkOnconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统配置第三次下班打卡时间")
	private String threeWorkOffconfigtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤班次类型 1：行政班  2：排班")
	private Byte attClassType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤组名")
	private String attGrName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte firstWorkonAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡WIFI库ID")
	private Integer firstWorkonWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班WIFI打卡，WIFI的SSID名称")
	private String firstWorkonAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班WIFI打卡，WIFI的MAC地址")
	private String firstWorkonAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte firstWorkoffAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡WIFI库ID")
	private Integer firstWorkoffWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班WIFI打卡，WIFI的SSID名称")
	private String firstWorkoffAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班WIFI打卡，WIFI的MAC地址")
	private String firstWorkoffAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte secondWorkonAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡WIFI库ID")
	private Integer secondWorkonWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班WIFI打卡，WIFI的SSID名称")
	private String secondWorkonAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班WIFI打卡，WIFI的MAC地址")
	private String secondWorkonAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte secondWorkoffAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡WIFI库ID")
	private Integer secondWorkoffWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班WIFI打卡，WIFI的SSID名称")
	private String secondWorkoffAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班WIFI打卡，WIFI的MAC地址")
	private String secondWorkoffAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte threeWorkonAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡WIFI库ID")
	private Integer threeWorkonWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班WIFI打卡，WIFI的SSID名称")
	private String threeWorkonAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班WIFI打卡，WIFI的MAC地址")
	private String threeWorkonAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡途径，0：定位打卡；1：WIFI打卡")
	private Byte threeWorkoffAttWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡WIFI库ID")
	private Integer threeWorkoffWifiId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班WIFI打卡，WIFI的SSID名称")
	private String threeWorkoffAttWifiSsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班WIFI打卡，WIFI的MAC地址")
	private String threeWorkoffAttWifiMac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班打卡修改时间")
	private Date firstWorkonChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班打卡修改时间")
	private Date secondWorkonChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班打卡修改时间")
	private Date threeWorkonChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班打卡修改时间")
	private Date firstWorkoffChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班打卡修改时间")
	private Date secondWorkoffChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班打卡修改时间")
	private Date threeWorkoffChangedate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班请假审批关联的请假id")
	private Integer firstWorkonAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班请假审批关联的请假id")
	private Integer secondWorkonAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班请假审批关联的请假id")
	private Integer threeWorkonAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班请假审批关联的请假id")
	private Integer firstWorkoffAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班请假审批关联的请假id")
	private Integer secondWorkoffAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班请假审批关联的请假id")
	private Integer threeWorkoffAuditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班请假审批关联的请假名称")
	private String firstWorkonLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班请假审批关联的请假名称")
	private String secondWorkonLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班请假审批关联的请假名称")
	private String threeWorkonLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班请假审批关联的请假名称")
	private String firstWorkoffLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班请假审批关联的请假名称")
	private String secondWorkoffLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班请假审批关联的请假名称")
	private String threeWorkoffLeaveName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次上班请假审批关联的请假id")
	private Integer firstWorkonClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次上班请假审批关联的请假id")
	private Integer secondWorkonClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次上班请假审批关联的请假id")
	private Integer threeWorkonClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第一次下班请假审批关联的请假id")
	private Integer firstWorkoffClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第二次下班请假审批关联的请假id")
	private Integer secondWorkoffClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "第三次下班请假审批关联的请假id")
	private Integer threeWorkoffClassId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "弃用")
	private String attendanceClassTimeSegment;
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
	 * @mbggenerated 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 大区id
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区id
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区id
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区id
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 分组id
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组id
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 员工id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 员工id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 考勤时间
	 */
	public Date getAttDate() {
		return attDate;
	}

	/**
	 * @mbggenerated 考勤时间
	 */
	public void setAttDate(Date attDate) {
		this.attDate = attDate;
	}

	/**
	 * @mbggenerated 考勤组id
	 */
	public Integer getAttGrId() {
		return attGrId;
	}

	/**
	 * @mbggenerated 考勤组id
	 */
	public void setAttGrId(Integer attGrId) {
		this.attGrId = attGrId;
	}

	/**
	 * @mbggenerated 考勤班次id
	 */
	public Integer getAttClassId() {
		return attClassId;
	}

	/**
	 * @mbggenerated 考勤班次id
	 */
	public void setAttClassId(Integer attClassId) {
		this.attClassId = attClassId;
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
		this.attClassName = attClassName;
	}

	/**
	 * @mbggenerated 考勤班次时间  
	 */
	public String getAttClassClocktime() {
		return attClassClocktime;
	}

	/**
	 * @mbggenerated 考勤班次时间  
	 */
	public void setAttClassClocktime(String attClassClocktime) {
		this.attClassClocktime = attClassClocktime;
	}

	/**
	 * @mbggenerated 是否休息（1是、0否、2代表没有排班、3缺卡。默认：0）
	 */
	public Byte getOffWork() {
		return offWork;
	}

	/**
	 * @mbggenerated 是否休息（1是、0否、2代表没有排班、3缺卡。默认：0）
	 */
	public void setOffWork(Byte offWork) {
		this.offWork = offWork;
	}

	/**
	 * @mbggenerated 第一次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getFirstWorkOn() {
		return firstWorkOn;
	}

	/**
	 * @mbggenerated 第一次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setFirstWorkOn(Byte firstWorkOn) {
		this.firstWorkOn = firstWorkOn;
	}

	/**
	 * @mbggenerated 第一次上班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getFirstWorkonType() {
		return firstWorkonType;
	}

	/**
	 * @mbggenerated 第一次上班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setFirstWorkonType(Byte firstWorkonType) {
		this.firstWorkonType = firstWorkonType;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改人，erp库USER_ID
	 */
	public Integer getFirstWorkonChangeuser() {
		return firstWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改人，erp库USER_ID
	 */
	public void setFirstWorkonChangeuser(Integer firstWorkonChangeuser) {
		this.firstWorkonChangeuser = firstWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getFirstWorkonChangedept() {
		return firstWorkonChangedept;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改人门店，erp库DEPT_ID
	 */
	public void setFirstWorkonChangedept(Integer firstWorkonChangedept) {
		this.firstWorkonChangedept = firstWorkonChangedept;
	}

	/**
	 * @mbggenerated 第一次上班打卡时间，后面不用说你都知道是什么意思啦
	 */
	public Date getFirstWorkOntime() {
		return firstWorkOntime;
	}

	/**
	 * @mbggenerated 第一次上班打卡时间，后面不用说你都知道是什么意思啦
	 */
	public void setFirstWorkOntime(Date firstWorkOntime) {
		this.firstWorkOntime = firstWorkOntime;
	}

	/**
	 * @mbggenerated 第二次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getSecondWorkOn() {
		return secondWorkOn;
	}

	/**
	 * @mbggenerated 第二次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setSecondWorkOn(Byte secondWorkOn) {
		this.secondWorkOn = secondWorkOn;
	}

	/**
	 * @mbggenerated 第二次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getSecondWorkonType() {
		return secondWorkonType;
	}

	/**
	 * @mbggenerated 第二次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setSecondWorkonType(Byte secondWorkonType) {
		this.secondWorkonType = secondWorkonType;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改人，erp库USER_ID
	 */
	public Integer getSecondWorkonChangeuser() {
		return secondWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改人，erp库USER_ID
	 */
	public void setSecondWorkonChangeuser(Integer secondWorkonChangeuser) {
		this.secondWorkonChangeuser = secondWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getSecondWorkonChangedept() {
		return secondWorkonChangedept;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改人门店，erp库DEPT_ID
	 */
	public void setSecondWorkonChangedept(Integer secondWorkonChangedept) {
		this.secondWorkonChangedept = secondWorkonChangedept;
	}

	/**
	 * @mbggenerated 第二次上班打卡时间
	 */
	public Date getSecondWorkOntime() {
		return secondWorkOntime;
	}

	/**
	 * @mbggenerated 第二次上班打卡时间
	 */
	public void setSecondWorkOntime(Date secondWorkOntime) {
		this.secondWorkOntime = secondWorkOntime;
	}

	/**
	 * @mbggenerated 第三次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getThreeWorkOn() {
		return threeWorkOn;
	}

	/**
	 * @mbggenerated 第三次上班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setThreeWorkOn(Byte threeWorkOn) {
		this.threeWorkOn = threeWorkOn;
	}

	/**
	 * @mbggenerated 第三次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getThreeWorkonType() {
		return threeWorkonType;
	}

	/**
	 * @mbggenerated 第三次上班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setThreeWorkonType(Byte threeWorkonType) {
		this.threeWorkonType = threeWorkonType;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改人，erp库USER_ID
	 */
	public Integer getThreeWorkonChangeuser() {
		return threeWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改人，erp库USER_ID
	 */
	public void setThreeWorkonChangeuser(Integer threeWorkonChangeuser) {
		this.threeWorkonChangeuser = threeWorkonChangeuser;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getThreeWorkonChangedept() {
		return threeWorkonChangedept;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改人门店，erp库DEPT_ID
	 */
	public void setThreeWorkonChangedept(Integer threeWorkonChangedept) {
		this.threeWorkonChangedept = threeWorkonChangedept;
	}

	/**
	 * @mbggenerated 第三次上班打卡时间
	 */
	public Date getThreeWorkOntime() {
		return threeWorkOntime;
	}

	/**
	 * @mbggenerated 第三次上班打卡时间
	 */
	public void setThreeWorkOntime(Date threeWorkOntime) {
		this.threeWorkOntime = threeWorkOntime;
	}

	/**
	 * @mbggenerated 第一次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getFirstWorkOff() {
		return firstWorkOff;
	}

	/**
	 * @mbggenerated 第一次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setFirstWorkOff(Byte firstWorkOff) {
		this.firstWorkOff = firstWorkOff;
	}

	/**
	 * @mbggenerated 第一次下班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getFirstWorkoffType() {
		return firstWorkoffType;
	}

	/**
	 * @mbggenerated 第一次下班打卡(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setFirstWorkoffType(Byte firstWorkoffType) {
		this.firstWorkoffType = firstWorkoffType;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改人，erp库USER_ID
	 */
	public Integer getFirstWorkoffChangeuser() {
		return firstWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改人，erp库USER_ID
	 */
	public void setFirstWorkoffChangeuser(Integer firstWorkoffChangeuser) {
		this.firstWorkoffChangeuser = firstWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getFirstWorkoffChangedept() {
		return firstWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改人门店，erp库DEPT_ID
	 */
	public void setFirstWorkoffChangedept(Integer firstWorkoffChangedept) {
		this.firstWorkoffChangedept = firstWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第一次下班打卡时间
	 */
	public Date getFirstWorkOfftime() {
		return firstWorkOfftime;
	}

	/**
	 * @mbggenerated 第一次下班打卡时间
	 */
	public void setFirstWorkOfftime(Date firstWorkOfftime) {
		this.firstWorkOfftime = firstWorkOfftime;
	}

	/**
	 * @mbggenerated 第二次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getSecondWorkOff() {
		return secondWorkOff;
	}

	/**
	 * @mbggenerated 第二次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setSecondWorkOff(Byte secondWorkOff) {
		this.secondWorkOff = secondWorkOff;
	}

	/**
	 * @mbggenerated 第二次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getSecondWorkoffType() {
		return secondWorkoffType;
	}

	/**
	 * @mbggenerated 第二次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setSecondWorkoffType(Byte secondWorkoffType) {
		this.secondWorkoffType = secondWorkoffType;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改人，erp库USER_ID
	 */
	public Integer getSecondWorkoffChangeuser() {
		return secondWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改人，erp库USER_ID
	 */
	public void setSecondWorkoffChangeuser(Integer secondWorkoffChangeuser) {
		this.secondWorkoffChangeuser = secondWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getSecondWorkoffChangedept() {
		return secondWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改人门店，erp库DEPT_ID
	 */
	public void setSecondWorkoffChangedept(Integer secondWorkoffChangedept) {
		this.secondWorkoffChangedept = secondWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第二次下班打卡时间
	 */
	public Date getSecondWorkOfftime() {
		return secondWorkOfftime;
	}

	/**
	 * @mbggenerated 第二次下班打卡时间
	 */
	public void setSecondWorkOfftime(Date secondWorkOfftime) {
		this.secondWorkOfftime = secondWorkOfftime;
	}

	/**
	 * @mbggenerated 第三次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public Byte getThreeWorkOff() {
		return threeWorkOff;
	}

	/**
	 * @mbggenerated 第三次下班打卡结果  0缺卡、1早退、2迟到、3旷工、4正常、5等待打卡、6严重迟到、7早退旷工、8迟到旷工、9事假、10病假、11休息 12(代表审批来的请假)
	 */
	public void setThreeWorkOff(Byte threeWorkOff) {
		this.threeWorkOff = threeWorkOff;
	}

	/**
	 * @mbggenerated 第三次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public Byte getThreeWorkoffType() {
		return threeWorkoffType;
	}

	/**
	 * @mbggenerated 第三次下班打卡类型(位置考勤结果-管理员 - (1正常、2外勤 - 实际与前端交互的参数)
	 */
	public void setThreeWorkoffType(Byte threeWorkoffType) {
		this.threeWorkoffType = threeWorkoffType;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改人，erp库USER_ID
	 */
	public Integer getThreeWorkoffChangeuser() {
		return threeWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改人，erp库USER_ID
	 */
	public void setThreeWorkoffChangeuser(Integer threeWorkoffChangeuser) {
		this.threeWorkoffChangeuser = threeWorkoffChangeuser;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改人门店，erp库DEPT_ID
	 */
	public Integer getThreeWorkoffChangedept() {
		return threeWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改人门店，erp库DEPT_ID
	 */
	public void setThreeWorkoffChangedept(Integer threeWorkoffChangedept) {
		this.threeWorkoffChangedept = threeWorkoffChangedept;
	}

	/**
	 * @mbggenerated 第三次下班打卡时间
	 */
	public Date getThreeWorkOfftime() {
		return threeWorkOfftime;
	}

	/**
	 * @mbggenerated 第三次下班打卡时间
	 */
	public void setThreeWorkOfftime(Date threeWorkOfftime) {
		this.threeWorkOfftime = threeWorkOfftime;
	}

	/**
	 * @mbggenerated 一共打几轮卡
	 */
	public Byte getAttSumCount() {
		return attSumCount;
	}

	/**
	 * @mbggenerated 一共打几轮卡
	 */
	public void setAttSumCount(Byte attSumCount) {
		this.attSumCount = attSumCount;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改备注
	 */
	public String getFirstWorkonChangeremark() {
		return firstWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改备注
	 */
	public void setFirstWorkonChangeremark(String firstWorkonChangeremark) {
		this.firstWorkonChangeremark = firstWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改备注
	 */
	public String getSecondWorkonChangeremark() {
		return secondWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改备注
	 */
	public void setSecondWorkonChangeremark(String secondWorkonChangeremark) {
		this.secondWorkonChangeremark = secondWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改备注
	 */
	public String getThreeWorkonChangeremark() {
		return threeWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改备注
	 */
	public void setThreeWorkonChangeremark(String threeWorkonChangeremark) {
		this.threeWorkonChangeremark = threeWorkonChangeremark;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改备注
	 */
	public String getFirstWorkoffChangeremark() {
		return firstWorkoffChangeremark;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改备注
	 */
	public void setFirstWorkoffChangeremark(String firstWorkoffChangeremark) {
		this.firstWorkoffChangeremark = firstWorkoffChangeremark;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改备注
	 */
	public String getSecondWorkoffChangeremark() {
		return secondWorkoffChangeremark;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改备注
	 */
	public void setSecondWorkoffChangeremark(String secondWorkoffChangeremark) {
		this.secondWorkoffChangeremark = secondWorkoffChangeremark;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改备注
	 */
	public String getThreeWorkoffChangeremark() {
		return threeWorkoffChangeremark;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改备注
	 */
	public void setThreeWorkoffChangeremark(String threeWorkoffChangeremark) {
		this.threeWorkoffChangeremark = threeWorkoffChangeremark;
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
	 * @mbggenerated 系统配置第一次上班打卡时间
	 */
	public String getFirstWorkOnconfigtime() {
		return firstWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第一次上班打卡时间
	 */
	public void setFirstWorkOnconfigtime(String firstWorkOnconfigtime) {
		this.firstWorkOnconfigtime = firstWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第一次下班打卡时间
	 */
	public String getFirstWorkOffconfigtime() {
		return firstWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第一次下班打卡时间
	 */
	public void setFirstWorkOffconfigtime(String firstWorkOffconfigtime) {
		this.firstWorkOffconfigtime = firstWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第二次上班打卡时间
	 */
	public String getSecondWorkOnconfigtime() {
		return secondWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第二次上班打卡时间
	 */
	public void setSecondWorkOnconfigtime(String secondWorkOnconfigtime) {
		this.secondWorkOnconfigtime = secondWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第二次下班打卡时间
	 */
	public String getSecondWorkOffconfigtime() {
		return secondWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第二次下班打卡时间
	 */
	public void setSecondWorkOffconfigtime(String secondWorkOffconfigtime) {
		this.secondWorkOffconfigtime = secondWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第三次上班打卡时间
	 */
	public String getThreeWorkOnconfigtime() {
		return threeWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第三次上班打卡时间
	 */
	public void setThreeWorkOnconfigtime(String threeWorkOnconfigtime) {
		this.threeWorkOnconfigtime = threeWorkOnconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第三次下班打卡时间
	 */
	public String getThreeWorkOffconfigtime() {
		return threeWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 系统配置第三次下班打卡时间
	 */
	public void setThreeWorkOffconfigtime(String threeWorkOffconfigtime) {
		this.threeWorkOffconfigtime = threeWorkOffconfigtime;
	}

	/**
	 * @mbggenerated 考勤班次类型 1：行政班  2：排班
	 */
	public Byte getAttClassType() {
		return attClassType;
	}

	/**
	 * @mbggenerated 考勤班次类型 1：行政班  2：排班
	 */
	public void setAttClassType(Byte attClassType) {
		this.attClassType = attClassType;
	}

	/**
	 * @mbggenerated 考勤组名
	 */
	public String getAttGrName() {
		return attGrName;
	}

	/**
	 * @mbggenerated 考勤组名
	 */
	public void setAttGrName(String attGrName) {
		this.attGrName = attGrName;
	}

	/**
	 * @mbggenerated 第一次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getFirstWorkonAttWay() {
		return firstWorkonAttWay;
	}

	/**
	 * @mbggenerated 第一次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setFirstWorkonAttWay(Byte firstWorkonAttWay) {
		this.firstWorkonAttWay = firstWorkonAttWay;
	}

	/**
	 * @mbggenerated 第一次上班打卡WIFI库ID
	 */
	public Integer getFirstWorkonWifiId() {
		return firstWorkonWifiId;
	}

	/**
	 * @mbggenerated 第一次上班打卡WIFI库ID
	 */
	public void setFirstWorkonWifiId(Integer firstWorkonWifiId) {
		this.firstWorkonWifiId = firstWorkonWifiId;
	}

	/**
	 * @mbggenerated 第一次上班WIFI打卡，WIFI的SSID名称
	 */
	public String getFirstWorkonAttWifiSsid() {
		return firstWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第一次上班WIFI打卡，WIFI的SSID名称
	 */
	public void setFirstWorkonAttWifiSsid(String firstWorkonAttWifiSsid) {
		this.firstWorkonAttWifiSsid = firstWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第一次上班WIFI打卡，WIFI的MAC地址
	 */
	public String getFirstWorkonAttWifiMac() {
		return firstWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第一次上班WIFI打卡，WIFI的MAC地址
	 */
	public void setFirstWorkonAttWifiMac(String firstWorkonAttWifiMac) {
		this.firstWorkonAttWifiMac = firstWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第一次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getFirstWorkoffAttWay() {
		return firstWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第一次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setFirstWorkoffAttWay(Byte firstWorkoffAttWay) {
		this.firstWorkoffAttWay = firstWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第一次下班打卡WIFI库ID
	 */
	public Integer getFirstWorkoffWifiId() {
		return firstWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第一次下班打卡WIFI库ID
	 */
	public void setFirstWorkoffWifiId(Integer firstWorkoffWifiId) {
		this.firstWorkoffWifiId = firstWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第一次下班WIFI打卡，WIFI的SSID名称
	 */
	public String getFirstWorkoffAttWifiSsid() {
		return firstWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第一次下班WIFI打卡，WIFI的SSID名称
	 */
	public void setFirstWorkoffAttWifiSsid(String firstWorkoffAttWifiSsid) {
		this.firstWorkoffAttWifiSsid = firstWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第一次下班WIFI打卡，WIFI的MAC地址
	 */
	public String getFirstWorkoffAttWifiMac() {
		return firstWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第一次下班WIFI打卡，WIFI的MAC地址
	 */
	public void setFirstWorkoffAttWifiMac(String firstWorkoffAttWifiMac) {
		this.firstWorkoffAttWifiMac = firstWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第二次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getSecondWorkonAttWay() {
		return secondWorkonAttWay;
	}

	/**
	 * @mbggenerated 第二次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setSecondWorkonAttWay(Byte secondWorkonAttWay) {
		this.secondWorkonAttWay = secondWorkonAttWay;
	}

	/**
	 * @mbggenerated 第二次上班打卡WIFI库ID
	 */
	public Integer getSecondWorkonWifiId() {
		return secondWorkonWifiId;
	}

	/**
	 * @mbggenerated 第二次上班打卡WIFI库ID
	 */
	public void setSecondWorkonWifiId(Integer secondWorkonWifiId) {
		this.secondWorkonWifiId = secondWorkonWifiId;
	}

	/**
	 * @mbggenerated 第二次上班WIFI打卡，WIFI的SSID名称
	 */
	public String getSecondWorkonAttWifiSsid() {
		return secondWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第二次上班WIFI打卡，WIFI的SSID名称
	 */
	public void setSecondWorkonAttWifiSsid(String secondWorkonAttWifiSsid) {
		this.secondWorkonAttWifiSsid = secondWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第二次上班WIFI打卡，WIFI的MAC地址
	 */
	public String getSecondWorkonAttWifiMac() {
		return secondWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第二次上班WIFI打卡，WIFI的MAC地址
	 */
	public void setSecondWorkonAttWifiMac(String secondWorkonAttWifiMac) {
		this.secondWorkonAttWifiMac = secondWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第二次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getSecondWorkoffAttWay() {
		return secondWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第二次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setSecondWorkoffAttWay(Byte secondWorkoffAttWay) {
		this.secondWorkoffAttWay = secondWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第二次下班打卡WIFI库ID
	 */
	public Integer getSecondWorkoffWifiId() {
		return secondWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第二次下班打卡WIFI库ID
	 */
	public void setSecondWorkoffWifiId(Integer secondWorkoffWifiId) {
		this.secondWorkoffWifiId = secondWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第二次下班WIFI打卡，WIFI的SSID名称
	 */
	public String getSecondWorkoffAttWifiSsid() {
		return secondWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第二次下班WIFI打卡，WIFI的SSID名称
	 */
	public void setSecondWorkoffAttWifiSsid(String secondWorkoffAttWifiSsid) {
		this.secondWorkoffAttWifiSsid = secondWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第二次下班WIFI打卡，WIFI的MAC地址
	 */
	public String getSecondWorkoffAttWifiMac() {
		return secondWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第二次下班WIFI打卡，WIFI的MAC地址
	 */
	public void setSecondWorkoffAttWifiMac(String secondWorkoffAttWifiMac) {
		this.secondWorkoffAttWifiMac = secondWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第三次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getThreeWorkonAttWay() {
		return threeWorkonAttWay;
	}

	/**
	 * @mbggenerated 第三次上班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setThreeWorkonAttWay(Byte threeWorkonAttWay) {
		this.threeWorkonAttWay = threeWorkonAttWay;
	}

	/**
	 * @mbggenerated 第三次上班打卡WIFI库ID
	 */
	public Integer getThreeWorkonWifiId() {
		return threeWorkonWifiId;
	}

	/**
	 * @mbggenerated 第三次上班打卡WIFI库ID
	 */
	public void setThreeWorkonWifiId(Integer threeWorkonWifiId) {
		this.threeWorkonWifiId = threeWorkonWifiId;
	}

	/**
	 * @mbggenerated 第三次上班WIFI打卡，WIFI的SSID名称
	 */
	public String getThreeWorkonAttWifiSsid() {
		return threeWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第三次上班WIFI打卡，WIFI的SSID名称
	 */
	public void setThreeWorkonAttWifiSsid(String threeWorkonAttWifiSsid) {
		this.threeWorkonAttWifiSsid = threeWorkonAttWifiSsid;
	}

	/**
	 * @mbggenerated 第三次上班WIFI打卡，WIFI的MAC地址
	 */
	public String getThreeWorkonAttWifiMac() {
		return threeWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第三次上班WIFI打卡，WIFI的MAC地址
	 */
	public void setThreeWorkonAttWifiMac(String threeWorkonAttWifiMac) {
		this.threeWorkonAttWifiMac = threeWorkonAttWifiMac;
	}

	/**
	 * @mbggenerated 第三次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public Byte getThreeWorkoffAttWay() {
		return threeWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第三次下班打卡途径，0：定位打卡；1：WIFI打卡
	 */
	public void setThreeWorkoffAttWay(Byte threeWorkoffAttWay) {
		this.threeWorkoffAttWay = threeWorkoffAttWay;
	}

	/**
	 * @mbggenerated 第三次下班打卡WIFI库ID
	 */
	public Integer getThreeWorkoffWifiId() {
		return threeWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第三次下班打卡WIFI库ID
	 */
	public void setThreeWorkoffWifiId(Integer threeWorkoffWifiId) {
		this.threeWorkoffWifiId = threeWorkoffWifiId;
	}

	/**
	 * @mbggenerated 第三次下班WIFI打卡，WIFI的SSID名称
	 */
	public String getThreeWorkoffAttWifiSsid() {
		return threeWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第三次下班WIFI打卡，WIFI的SSID名称
	 */
	public void setThreeWorkoffAttWifiSsid(String threeWorkoffAttWifiSsid) {
		this.threeWorkoffAttWifiSsid = threeWorkoffAttWifiSsid;
	}

	/**
	 * @mbggenerated 第三次下班WIFI打卡，WIFI的MAC地址
	 */
	public String getThreeWorkoffAttWifiMac() {
		return threeWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第三次下班WIFI打卡，WIFI的MAC地址
	 */
	public void setThreeWorkoffAttWifiMac(String threeWorkoffAttWifiMac) {
		this.threeWorkoffAttWifiMac = threeWorkoffAttWifiMac;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改时间
	 */
	public Date getFirstWorkonChangedate() {
		return firstWorkonChangedate;
	}

	/**
	 * @mbggenerated 第一次上班打卡修改时间
	 */
	public void setFirstWorkonChangedate(Date firstWorkonChangedate) {
		this.firstWorkonChangedate = firstWorkonChangedate;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改时间
	 */
	public Date getSecondWorkonChangedate() {
		return secondWorkonChangedate;
	}

	/**
	 * @mbggenerated 第二次上班打卡修改时间
	 */
	public void setSecondWorkonChangedate(Date secondWorkonChangedate) {
		this.secondWorkonChangedate = secondWorkonChangedate;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改时间
	 */
	public Date getThreeWorkonChangedate() {
		return threeWorkonChangedate;
	}

	/**
	 * @mbggenerated 第三次上班打卡修改时间
	 */
	public void setThreeWorkonChangedate(Date threeWorkonChangedate) {
		this.threeWorkonChangedate = threeWorkonChangedate;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改时间
	 */
	public Date getFirstWorkoffChangedate() {
		return firstWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第一次下班打卡修改时间
	 */
	public void setFirstWorkoffChangedate(Date firstWorkoffChangedate) {
		this.firstWorkoffChangedate = firstWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改时间
	 */
	public Date getSecondWorkoffChangedate() {
		return secondWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第二次下班打卡修改时间
	 */
	public void setSecondWorkoffChangedate(Date secondWorkoffChangedate) {
		this.secondWorkoffChangedate = secondWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改时间
	 */
	public Date getThreeWorkoffChangedate() {
		return threeWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第三次下班打卡修改时间
	 */
	public void setThreeWorkoffChangedate(Date threeWorkoffChangedate) {
		this.threeWorkoffChangedate = threeWorkoffChangedate;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假id
	 */
	public Integer getFirstWorkonAuditId() {
		return firstWorkonAuditId;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假id
	 */
	public void setFirstWorkonAuditId(Integer firstWorkonAuditId) {
		this.firstWorkonAuditId = firstWorkonAuditId;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假id
	 */
	public Integer getSecondWorkonAuditId() {
		return secondWorkonAuditId;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假id
	 */
	public void setSecondWorkonAuditId(Integer secondWorkonAuditId) {
		this.secondWorkonAuditId = secondWorkonAuditId;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假id
	 */
	public Integer getThreeWorkonAuditId() {
		return threeWorkonAuditId;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假id
	 */
	public void setThreeWorkonAuditId(Integer threeWorkonAuditId) {
		this.threeWorkonAuditId = threeWorkonAuditId;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假id
	 */
	public Integer getFirstWorkoffAuditId() {
		return firstWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假id
	 */
	public void setFirstWorkoffAuditId(Integer firstWorkoffAuditId) {
		this.firstWorkoffAuditId = firstWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假id
	 */
	public Integer getSecondWorkoffAuditId() {
		return secondWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假id
	 */
	public void setSecondWorkoffAuditId(Integer secondWorkoffAuditId) {
		this.secondWorkoffAuditId = secondWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假id
	 */
	public Integer getThreeWorkoffAuditId() {
		return threeWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假id
	 */
	public void setThreeWorkoffAuditId(Integer threeWorkoffAuditId) {
		this.threeWorkoffAuditId = threeWorkoffAuditId;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假名称
	 */
	public String getFirstWorkonLeaveName() {
		return firstWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假名称
	 */
	public void setFirstWorkonLeaveName(String firstWorkonLeaveName) {
		this.firstWorkonLeaveName = firstWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假名称
	 */
	public String getSecondWorkonLeaveName() {
		return secondWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假名称
	 */
	public void setSecondWorkonLeaveName(String secondWorkonLeaveName) {
		this.secondWorkonLeaveName = secondWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假名称
	 */
	public String getThreeWorkonLeaveName() {
		return threeWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假名称
	 */
	public void setThreeWorkonLeaveName(String threeWorkonLeaveName) {
		this.threeWorkonLeaveName = threeWorkonLeaveName;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假名称
	 */
	public String getFirstWorkoffLeaveName() {
		return firstWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假名称
	 */
	public void setFirstWorkoffLeaveName(String firstWorkoffLeaveName) {
		this.firstWorkoffLeaveName = firstWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假名称
	 */
	public String getSecondWorkoffLeaveName() {
		return secondWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假名称
	 */
	public void setSecondWorkoffLeaveName(String secondWorkoffLeaveName) {
		this.secondWorkoffLeaveName = secondWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假名称
	 */
	public String getThreeWorkoffLeaveName() {
		return threeWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假名称
	 */
	public void setThreeWorkoffLeaveName(String threeWorkoffLeaveName) {
		this.threeWorkoffLeaveName = threeWorkoffLeaveName;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假id
	 */
	public Integer getFirstWorkonClassId() {
		return firstWorkonClassId;
	}

	/**
	 * @mbggenerated 第一次上班请假审批关联的请假id
	 */
	public void setFirstWorkonClassId(Integer firstWorkonClassId) {
		this.firstWorkonClassId = firstWorkonClassId;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假id
	 */
	public Integer getSecondWorkonClassId() {
		return secondWorkonClassId;
	}

	/**
	 * @mbggenerated 第二次上班请假审批关联的请假id
	 */
	public void setSecondWorkonClassId(Integer secondWorkonClassId) {
		this.secondWorkonClassId = secondWorkonClassId;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假id
	 */
	public Integer getThreeWorkonClassId() {
		return threeWorkonClassId;
	}

	/**
	 * @mbggenerated 第三次上班请假审批关联的请假id
	 */
	public void setThreeWorkonClassId(Integer threeWorkonClassId) {
		this.threeWorkonClassId = threeWorkonClassId;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假id
	 */
	public Integer getFirstWorkoffClassId() {
		return firstWorkoffClassId;
	}

	/**
	 * @mbggenerated 第一次下班请假审批关联的请假id
	 */
	public void setFirstWorkoffClassId(Integer firstWorkoffClassId) {
		this.firstWorkoffClassId = firstWorkoffClassId;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假id
	 */
	public Integer getSecondWorkoffClassId() {
		return secondWorkoffClassId;
	}

	/**
	 * @mbggenerated 第二次下班请假审批关联的请假id
	 */
	public void setSecondWorkoffClassId(Integer secondWorkoffClassId) {
		this.secondWorkoffClassId = secondWorkoffClassId;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假id
	 */
	public Integer getThreeWorkoffClassId() {
		return threeWorkoffClassId;
	}

	/**
	 * @mbggenerated 第三次下班请假审批关联的请假id
	 */
	public void setThreeWorkoffClassId(Integer threeWorkoffClassId) {
		this.threeWorkoffClassId = threeWorkoffClassId;
	}

	/**
	 * @mbggenerated 弃用
	 */
	public String getAttendanceClassTimeSegment() {
		return attendanceClassTimeSegment;
	}

	/**
	 * @mbggenerated 弃用
	 */
	public void setAttendanceClassTimeSegment(String attendanceClassTimeSegment) {
		this.attendanceClassTimeSegment = attendanceClassTimeSegment;
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
	public ErpFunAttendanceStatistics() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceStatistics(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}