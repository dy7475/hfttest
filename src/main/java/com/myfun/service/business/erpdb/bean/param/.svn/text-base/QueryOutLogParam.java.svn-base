package com.myfun.service.business.erpdb.bean.param;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
* @ClassName: QueryOutLogParam 
* @Description: TODO(查询外出日志参数) 
* @author 方李骥
* @date 2016-10-14 下午2:21:14
 */
@ApiModel
public class QueryOutLogParam extends AbstractEncryParam implements DaoBaseParam{
	
	@ApiModelProperty(value = "业务层需要使用当前用户所在公司")
	private Integer compId;
	
	@ApiModelProperty(value = "切库所需要使用的城市ID")
	private Integer cityId;
	
	@ApiModelProperty(value = "业务层需要使用当前用户的名称(带门店名称)")
	private String currentUserName;
	
	@ApiModelProperty(value = "业务层需要使用当前用户Id")
	private Integer currentUserId;
	
	@ApiModelProperty(value = "业务层需要使用当前用户名称")
	private String userName;
	
	@ApiModelProperty(value = "业务层需要使用当前用户名称")
	private String currentDeptName;
	
	@ApiModelProperty(value = "当前用户所在门店ID")
	private Integer currentDeptId;
	
	@ApiModelProperty(value = "行政区id")
	private Integer areaId;
	
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	
	@ApiModelProperty(value = "门店ID")
	private Integer grId;
	
	@ApiModelProperty(value = "排序方式")
	private String orderBy;
	
	@ApiModelProperty(value = "开始时间")
	@NotBlank
	private String outTime1;
	
	@ApiModelProperty(value = "结束时间")
	@NotBlank
	private String outTime2;
	
	@ApiModelProperty(value = "员工ID")
	private Integer userId;
	
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentDeptName() {
		return currentDeptName;
	}
	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOutTime1() {
		return outTime1;
	}
	public void setOutTime1(String outTime1) {
		this.outTime1 = outTime1;
	}
	public String getOutTime2() {
		return outTime2;
	}
	public void setOutTime2(String outTime2) {
		this.outTime2 = outTime2;
	}
}