package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Sync_OA_ML_UserChangeData 
* @Description: 同步HRS员工异动信息实体
* @author fsjohnhuang
* @date 2020年6月22日 下午3:22:51 
*
 */
@Entity
@Table(name="ML_EMP_CHANGE_DATA")
public class Admin_Sync_OA_ML_UserChangeData implements Serializable {

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name="ID")
	private String id;

	/**
	 * 异动类型
	 */
	@Column(name="C_TYPE")
	private String cType;

	/**
	 * 异动类型代码：changes，attribute，join，leave
	 */
	@Column(name="C_TYPE_CODE")
	private String cTypeCode;
	
	/**
	 * 事件名称
	 */
	@Column(name="CHANGE_TITLE")
	private String changeTitle;

	@Column(name="CHANGE_ID")
	private String changeId;

	/**
	 * 变动前工号
	 */
	@Column(name="OLD_BAGE")
	private String oldBage;
	
	/**
	 * 当前工号
	 */
	@Column(name="BADGE")
	private String badge;

	@Column(name="NAME")
	private String name;

	@Column(name="CERT_NO")
	private String certNo;

	@Column(name="OLD_MOBILE")
	private String oldMobile;

	@Column(name="NEW_MOBILE")
	private String newMobile;

	@Column(name="CHANGE_DATE")
	private Date changeDate;

	@Column(name="OLD_DEP_CODE")
	private String oldDepCode;

	@Column(name="NEW_DEP_CODE")
	private String newDepCode;
	
	@Column(name="OLD_DEP_ID")
	private String oldDepId;
	
	@Column(name="NEW_DEP_ID")
	private String newDepId;
	
	@Column(name="OLD_DEP_MAR_KET")
	private String oldDepMarKet;
	
	@Column(name="OLD_MARKET_NAME")
	private String oldMarketName;
	
	@Column(name="NEW_DEP_MARKET")
	private String newDepMarket;
	
	@Column(name="NEW_MARKET_NAME")
	private String newMarketName;
	
	@Column(name="OLD_DEP_ABBR")
	private String oldDepAbbr;

	@Column(name="NEW_DEP_ABBR")
	private String newDepAbbr;
	
	@Column(name="OLD_EMPGRADE")
	private String oldEmpgrade;
	
	@Column(name="NEW_EMPGRADE")
	private String newEmpgrade;
	
	/**
	 * yyyy-MM-dd，入职日期
	 */
	@Column(name="JOIN_DATE")
	private Date joinDate;
	
	/**
	 * yyyy-MM-dd，离职日期
	 */
	@Column(name="LEAVE_DATE")
	private Date leaveDate;
	
	/**
	 * 香港身份证号
	 */
	@Column(name="HONG_KONG_ID")
	private String hongKongId;
	
	/**
	 * yyyy-MM-dd HH:mm:ss，操作日期
	 */
	@Column(name="INITIALIZED_TIME")
	private Date initializedTime;
	
	@Column(name="OLD_JOB_NAME")
	private String oldJobName;
	
	@Column(name="OLD_JOB_ID")
	private String oldJobId;
	
	@Column(name="NEW_JOB_NAME")
	private String newJobName;
	
	@Column(name="NEW_JOB_ID")
	private String newJobId;
	
	/**
	 * 在岗位状态：在职 离职  退休  合作
	 */
	@Column(name="E_STATUE")
	private String eStatue;
	
	@Column(name="OLD_QXTYPE")
	private String oldQxtype;
	
	@Column(name="OLD_QXTYPE_NAME")
	private String oldQxtypeName;
	
	@Column(name="NEW_QXTYPE")
	private String newQxtype;
	
	@Column(name="NEW_QXTYPE_NAME")
	private String newQxtypeName;

	/**
	 * 新部门架构编码 示例：c486/L1/H1/I11/K69/118/d1464
	 * 示例解释：美联中国/华南区/(深圳/惠州)/福田及龙坂区/福田北A区/福田北A5区/福田 - 东海豪宅(SZ156)
	 */
	@Column(name="ORG_PATH")
	private String orgPath;
	
	private static final long serialVersionUID = 1L;


	public String getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getcType() {
		return cType;
	}

	/**
	 * @mbggenerated
	 */
	public void setcType(String cType) {
		this.cType = cType == null ? null : cType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getcTypeCode() {
		return cTypeCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setcTypeCode(String cTypeCode) {
		this.cTypeCode = cTypeCode == null ? null : cTypeCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getChangeTitle() {
		return changeTitle;
	}

	/**
	 * @mbggenerated
	 */
	public void setChangeTitle(String changeTitle) {
		this.changeTitle = changeTitle == null ? null : changeTitle.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getChangeId() {
		return changeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setChangeId(String changeId) {
		this.changeId = changeId == null ? null : changeId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldBage() {
		return oldBage;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldBage(String oldBage) {
		this.oldBage = oldBage == null ? null : oldBage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBadge() {
		return badge;
	}

	/**
	 * @mbggenerated
	 */
	public void setBadge(String badge) {
		this.badge = badge == null ? null : badge.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCertNo() {
		return certNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldMobile() {
		return oldMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldMobile(String oldMobile) {
		this.oldMobile = oldMobile == null ? null : oldMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewMobile() {
		return newMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile == null ? null : newMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	/**
	 * @mbggenerated
	 */
	public String getOldDepCode() {
		return oldDepCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldDepCode(String oldDepCode) {
		this.oldDepCode = oldDepCode == null ? null : oldDepCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewDepCode() {
		return newDepCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewDepCode(String newDepCode) {
		this.newDepCode = newDepCode == null ? null : newDepCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldDepId() {
		return oldDepId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldDepId(String oldDepId) {
		this.oldDepId = oldDepId == null ? null : oldDepId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewDepId() {
		return newDepId;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewDepId(String newDepId) {
		this.newDepId = newDepId == null ? null : newDepId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldDepMarKet() {
		return oldDepMarKet;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldDepMarKet(String oldDepMarKet) {
		this.oldDepMarKet = oldDepMarKet == null ? null : oldDepMarKet.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldMarketName() {
		return oldMarketName;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldMarketName(String oldMarketName) {
		this.oldMarketName = oldMarketName == null ? null : oldMarketName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewDepMarket() {
		return newDepMarket;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewDepMarket(String newDepMarket) {
		this.newDepMarket = newDepMarket == null ? null : newDepMarket.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewMarketName() {
		return newMarketName;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewMarketName(String newMarketName) {
		this.newMarketName = newMarketName == null ? null : newMarketName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldDepAbbr() {
		return oldDepAbbr;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldDepAbbr(String oldDepAbbr) {
		this.oldDepAbbr = oldDepAbbr == null ? null : oldDepAbbr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewDepAbbr() {
		return newDepAbbr;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewDepAbbr(String newDepAbbr) {
		this.newDepAbbr = newDepAbbr == null ? null : newDepAbbr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldEmpgrade() {
		return oldEmpgrade;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldEmpgrade(String oldEmpgrade) {
		this.oldEmpgrade = oldEmpgrade == null ? null : oldEmpgrade.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewEmpgrade() {
		return newEmpgrade;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewEmpgrade(String newEmpgrade) {
		this.newEmpgrade = newEmpgrade == null ? null : newEmpgrade.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	/**
	 * @mbggenerated
	 */
	public String getHongKongId() {
		return hongKongId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHongKongId(String hongKongId) {
		this.hongKongId = hongKongId == null ? null : hongKongId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getInitializedTime() {
		return initializedTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setInitializedTime(Date initializedTime) {
		this.initializedTime = initializedTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getOldJobName() {
		return oldJobName;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldJobName(String oldJobName) {
		this.oldJobName = oldJobName == null ? null : oldJobName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldJobId() {
		return oldJobId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldJobId(String oldJobId) {
		this.oldJobId = oldJobId == null ? null : oldJobId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewJobName() {
		return newJobName;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewJobName(String newJobName) {
		this.newJobName = newJobName == null ? null : newJobName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewJobId() {
		return newJobId;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewJobId(String newJobId) {
		this.newJobId = newJobId == null ? null : newJobId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String geteStatue() {
		return eStatue;
	}

	/**
	 * @mbggenerated
	 */
	public void seteStatue(String eStatue) {
		this.eStatue = eStatue == null ? null : eStatue.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldQxtype() {
		return oldQxtype;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldQxtype(String oldQxtype) {
		this.oldQxtype = oldQxtype == null ? null : oldQxtype.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOldQxtypeName() {
		return oldQxtypeName;
	}

	/**
	 * @mbggenerated
	 */
	public void setOldQxtypeName(String oldQxtypeName) {
		this.oldQxtypeName = oldQxtypeName == null ? null : oldQxtypeName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewQxtype() {
		return newQxtype;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewQxtype(String newQxtype) {
		this.newQxtype = newQxtype == null ? null : newQxtype.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getNewQxtypeName() {
		return newQxtypeName;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewQxtypeName(String newQxtypeName) {
		this.newQxtypeName = newQxtypeName == null ? null : newQxtypeName.trim();
	}

	public String getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	
}