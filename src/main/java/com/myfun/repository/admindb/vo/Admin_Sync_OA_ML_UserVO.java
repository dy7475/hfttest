package com.myfun.repository.admindb.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * 
* @ClassName: Admin_Sync_OA_ML_User 
* @Description: 同步HRS人员信息记录
* @author tangliang1
* @date 2020年6月24日 下午4:17:47 
*
 */
public class Admin_Sync_OA_ML_UserVO {
	
    private Integer eid;

    // 工号
    private String badge;

    private String name;

    private Integer compId;

    private Integer deptId;

    private Integer jobId;

    /**
     * 1：在职， 2：离职，3：退休，4：合作
     */
    private Integer empStatus;
    
    private String empStatusDesc;

    /**
     * 1：在岗，2：试用， 3：实习，4：内退，5：停薪留职，6：待岗，7：信息缺失
     */
    private Integer jobStatus;
    private String jobStatusDesc;

    private Date joinDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leaveDate;

    private String mobile;

	private String certNo;
	private String positionName;
	private String hftRuleDesc;
	private String orgName;
	
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(Integer empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpStatusDesc() {
		return empStatusDesc;
	}
	public void setEmpStatusDesc(String empStatusDesc) {
		this.empStatusDesc = empStatusDesc;
	}
	public Integer getJobStatus() {
		return jobStatus;
	}
	
	public void setJobStatus(Integer jobStatus) {
		this.jobStatus = jobStatus;
		//1：在岗，2：试用， 3：实习，4：内退，5：停薪留职，6：待岗，7：信息缺失
		switch (jobStatus) {
		case 1:
			this.setJobStatusDesc("在岗");
			break;
		case 2:
			this.setJobStatusDesc("试用");
			break;
		case 3:
			this.setJobStatusDesc("实习");
			break;
		case 4:
			this.setJobStatusDesc("内退");
			break;
		case 5:
			this.setJobStatusDesc("停薪留职");
			break;
		case 6:
			this.setJobStatusDesc("待岗");
			break;
		case 7:
			this.setJobStatusDesc("信息缺失");
			break;

		default:
			this.setJobStatusDesc("信息缺失");
			break;
		}
	}
	
	public String getJobStatusDesc() {
		return jobStatusDesc;
	}
	public void setJobStatusDesc(String jobStatusDesc) {
		this.jobStatusDesc = jobStatusDesc;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getHftRuleDesc() {
		return hftRuleDesc;
	}
	public void setHftRuleDesc(String hftRuleDesc) {
		this.hftRuleDesc = hftRuleDesc;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
    
	
}