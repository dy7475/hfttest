package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "获取电话查看列表VO")
public class ErpFunViewLogVo  implements Serializable {
	/**
	 * @mbggenerated 公司ID
	 */
	@ApiModelProperty("公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 自增
	 */
	@ApiModelProperty("自增")
	private Integer viewId;
	/**
	 * @mbggenerated 分店ID
	 */
	@ApiModelProperty("分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated 信息类型，1：出售2：出租3：求购4：求租
	 */
	@ApiModelProperty("信息类型，1：出售2：出租3：求购4：求租")
	private Byte targetType;
	/**
	 * @mbggenerated 用途，DD:HOUSE_USEAGE
	 */
	@ApiModelProperty("用途")
	private Byte useage;
	/**
	 * @mbggenerated 信息ID
	 */
	@ApiModelProperty("信息ID")
	private Integer targetId;
	/**
	 * @mbggenerated 信息所属门店
	 */
	@ApiModelProperty("信息所属门店")
	private Integer targetDept;
	/**
	 * @mbggenerated 盘别，DD:PLATE_TYPE
	 */
	@ApiModelProperty("盘别")
	private Byte plateType;
	/**
	 * @mbggenerated 信息所属人，From:FUN_USER.USER_ID
	 */
	@ApiModelProperty("信息所属人")
	private Integer ownerId;
	/**
	 * @mbggenerated 查看人，From:FUN_USER.USER_ID
	 */
	@ApiModelProperty("查看人")
	private Integer viewUser;
	/**
	 * @mbggenerated 查看时间
	 */
	@ApiModelProperty("查看时间")
	private String viewTime;
	/**
	 * @mbggenerated 信息类型编号，如房源编号
	 */
	@ApiModelProperty("信息类型编号，如房源编号")
	private String targetNo;
	/**
	 * @mbggenerated 查看来源，0=erp门店版 1=app 2=erp门店版
	 */
	@ApiModelProperty("查看来源，0=erp门店版 1=app 2=erp门店版")
	private Byte viewSource;
	/**
	 * @mbggenerated 是否参与每天查看条数的统计，0:注销写的查看记录,不参与查看条数的统计1:要参与每天查看条数的统计
	 */
	@ApiModelProperty("是否参与每天查看条数的统计")
	private Byte viewStatus;
	/**
	 * @mbggenerated 查看时的电脑名
	 */
	@ApiModelProperty("查看时的电脑名")
	private String pcname;
	/**
	 * @mbggenerated 查看时的状态 1/2/3/4
	 */
	@ApiModelProperty("查看时的状态")
	private Byte viewCaseStatus;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getViewId() {
		return viewId;
	}

	public void setViewId(Integer viewId) {
		this.viewId = viewId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Byte getTargetType() {
		return targetType;
	}

	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	public Byte getUseage() {
		return useage;
	}

	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Integer getTargetDept() {
		return targetDept;
	}

	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}

	public Byte getPlateType() {
		return plateType;
	}

	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getViewUser() {
		return viewUser;
	}

	public void setViewUser(Integer viewUser) {
		this.viewUser = viewUser;
	}

	public String getViewTime() {
		return viewTime;
	}

	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}

	public String getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	public Byte getViewSource() {
		return viewSource;
	}

	public void setViewSource(Byte viewSource) {
		this.viewSource = viewSource;
	}

	public Byte getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(Byte viewStatus) {
		this.viewStatus = viewStatus;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public Byte getViewCaseStatus() {
		return viewCaseStatus;
	}

	public void setViewCaseStatus(Byte viewCaseStatus) {
		this.viewCaseStatus = viewCaseStatus;
	}
}
