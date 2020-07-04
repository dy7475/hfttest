/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
public class QueryWorkLogListParam extends AbstractEncryParam implements DaoBaseParam{
	/**门店ID**/
	private Integer deptId;
	private Integer compId;
	/**审阅标记1=已阅0=未阅**/
	private Byte examinFlag;
	/**排序字段**/
	private String orderBy;
	/**员工ID**/
	private Integer userId;
	/**日志日期开始段**/
	private String wlTime1;
	/**日志日期结束段**/
	private String wlTime2;
	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	/**
	 * @return the examinFlag
	 */
	public Byte getExaminFlag() {
		return examinFlag;
	}
	/**
	 * @param examinFlag the examinFlag to set
	 */
	public void setExaminFlag(Byte examinFlag) {
		this.examinFlag = examinFlag;
	}
	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the wlTime1
	 */
	public String getWlTime1() {
		return wlTime1;
	}
	/**
	 * @param wlTime1 the wlTime1 to set
	 */
	public void setWlTime1(String wlTime1) {
		this.wlTime1 = wlTime1;
	}
	/**
	 * @return the wlTime2
	 */
	public String getWlTime2() {
		return wlTime2;
	}
	/**
	 * @param wlTime2 the wlTime2 to set
	 */
	public void setWlTime2(String wlTime2) {
		this.wlTime2 = wlTime2;
	}
	
}
