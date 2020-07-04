package com.myfun.repository.erpdb.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * 用于完成日统计和月统计的请求参数
 * @author 陈文超
 * @date 2017年12月9日 下午1:38:39
 */
public class AttendanceRecordParam extends AbstractEncryParam implements DaoBaseParam{
	
	/**
	 * 日考勤时间格式：2017-01-01，具体到某天
	 * 月考勤时间格式：2017-01，具体到某个月
	 */
	private String attDate;
	private Integer areaId ;
	private Integer regId ;
	private Integer deptId ;
	private Integer grId;
	private Integer userId;
	
	/**
	 *	12,出勤天數
	 *	11, 迟到早退
		6, 迟到
		5, 早退
		4, 缺卡
		3, 外勤打卡
		2, 请假
		1, 正常打卡
	 */
	private Integer attType;

	public String getAttDate() {
		return attDate;
	}

	public void setAttDate(String attDate) {
		this.attDate = attDate;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAttType() {
		return attType;
	}

	public void setAttType(Integer attType) {
		this.attType = attType;
	}
}
