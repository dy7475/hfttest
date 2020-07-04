package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceClass extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 本表主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 班次名称
	 */
	private String className;
	/**
	 * @mbggenerated 班次类型 1：行政班  2：排班
	 */
	private Byte classType;
	/**
	 * @mbggenerated 班次打卡次数
	 */
	private Integer calssNumber;
	/**
	 * @mbggenerated 第一次上班打卡时间
	 */
	private String firstUp;
	/**
	 * @mbggenerated 第一次下班打卡时间
	 */
	private String firstDown;
	/**
	 * @mbggenerated 第二次上班打卡时间
	 */
	private String secondUp;
	/**
	 * @mbggenerated 第二次下班打卡时间
	 */
	private String secondDown;
	/**
	 * @mbggenerated 第三次上班打卡时间
	 */
	private String threeUp;
	/**
	 * @mbggenerated 第三次下班打卡时间
	 */
	private String threeDown;
	/**
	 * @mbggenerated 删除标记 0：未删除 1：已删除
	 */
	private Byte delFlag;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 删除时间
	 */
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @mbggenerated
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getClassType() {
		return classType;
	}

	/**
	 * @mbggenerated
	 */
	public void setClassType(Byte classType) {
		this.classType = classType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCalssNumber() {
		return calssNumber;
	}

	/**
	 * @mbggenerated
	 */
	public void setCalssNumber(Integer calssNumber) {
		this.calssNumber = calssNumber;
	}

	/**
	 * @mbggenerated
	 */
	public String getFirstUp() {
		return firstUp;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstUp(String firstUp) {
		this.firstUp = firstUp == null ? null : firstUp.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFirstDown() {
		return firstDown;
	}

	/**
	 * @mbggenerated
	 */
	public void setFirstDown(String firstDown) {
		this.firstDown = firstDown == null ? null : firstDown.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondUp() {
		return secondUp;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondUp(String secondUp) {
		this.secondUp = secondUp == null ? null : secondUp.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecondDown() {
		return secondDown;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecondDown(String secondDown) {
		this.secondDown = secondDown == null ? null : secondDown.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getThreeUp() {
		return threeUp;
	}

	/**
	 * @mbggenerated
	 */
	public void setThreeUp(String threeUp) {
		this.threeUp = threeUp == null ? null : threeUp.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getThreeDown() {
		return threeDown;
	}

	/**
	 * @mbggenerated
	 */
	public void setThreeDown(String threeDown) {
		this.threeDown = threeDown == null ? null : threeDown.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
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
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
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
	public ErpFunAttendanceClass() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceClass(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}