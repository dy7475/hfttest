package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.utils.DateTimeHelper;
/**
* @ClassName: QueryAttendanceListParam 
* @Description: TODO(查询考勤列表) 
* @author 方李骥
* @date 2016-10-13 上午10:27:53
 */
public class QueryAttendanceListParam extends AbstractEncryParam implements
		DaoBaseParam {
	private String startTime;//考勤日期开始时间
	private String endTime;//考勤日期结束时间
	private Integer userId;//员工ID
	private Integer deptId;//门店ID
	private Integer areaId;//大区ID
	private Integer regId;//片区ID
	private Byte workStatus;//工作状态
	private String orderBy;//排序字段
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private Integer currentUserId;//业务层需要使用当前用户Id
	private String userName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private Integer compId;//当前公司ID
	private Integer[] deptIds; //辅助查询封装deptId的数组，因为考勤表上没有大区，片区ID，所以你懂的
	
	
	public Integer[] getDeptIds() {
		return deptIds;
	}
	public void setDeptIds(Integer[] deptIds) {
		this.deptIds = deptIds;
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
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) throws Exception {
		this.startTime = DateTimeHelper.formatDateTimetoString(startTime,"yyyy-MM-dd 00:00:00");
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) throws Exception {
		this.endTime = DateTimeHelper.formatDateTimetoString(endTime,"yyyy-MM-dd 23:59:59");
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Byte getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(Byte workStatus) {
		this.workStatus = workStatus;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
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
}
