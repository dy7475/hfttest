package com.myfun.erpWeb.openApi.attendance.vo;

import com.myfun.repository.erpdb.po.ErpOutLog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpOutLogVO extends ErpOutLog {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	
	@ApiModelProperty(value = "检测记录")
	private Integer checkInRecord;
	
	@ApiModelProperty(value = "外出类型")
	private Integer auditType;
	
	@ApiModelProperty(value = "门店名称")
	private String deptName;
	
	@ApiModelProperty(value = "分组名称")
	private String groupName;
	
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "经度")
	private String longi;
	
	@ApiModelProperty(value = "纬度")
	private String lati;
	
	@ApiModelProperty(value = "照片路径地址")
	private String photoPath;
	
	@ApiModelProperty(value = "检测描述")
	private String checkInDesc;
	
	@ApiModelProperty(value = "地理位置详细信息")
	private String locationDetail;
	
	@ApiModelProperty(value = "地理位置描述")
	private String locationDesc;
	
	@ApiModelProperty(value = "实际返回时长")
	private Integer realTime;
	

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getCheckInRecord() {
		return checkInRecord;
	}

	public void setCheckInRecord(Integer checkInRecord) {
		this.checkInRecord = checkInRecord;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getCheckInDesc() {
		return checkInDesc;
	}

	public void setCheckInDesc(String checkInDesc) {
		this.checkInDesc = checkInDesc;
	}

	public String getLocationDetail() {
		return locationDetail;
	}

	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public Integer getRealTime() {
		return realTime;
	}

	public void setRealTime(Integer realTime) {
		this.realTime = realTime;
	}
}