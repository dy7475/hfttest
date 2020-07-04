package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeData 
* @Description: 部门组织信息异动实体 
* @author fsjohnhuang
* @date 2020年6月22日 下午5:03:28 
*
 */
@Entity
@Table(name="ML_DEPT_CHANGE_DATA")
public class Admin_Sync_OA_ML_DepartmentChangeData implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "JDBC")
	@Column(insertable=true)
	private Integer id;
	
	/**
	 * 变更记录表ID，全局唯一
	 */
	private Integer changeId;
	
	/**
	 * 部门管理类型名称:新增、变更、关闭、重开
	 */
	private String cType;
	
	/**
	 * 部门管理类型代码1,2,3,4
	 */
	private String cTypeCode;
	
	/**
	 * 部门变更类型名称:未知变更,属性变更,部门调迁,主管变更,电话变更,名称变更,部门新增,部门关闭,部门重开
	 */
	private String changeTitle;
	
	/**
	 * 部门变更类型代码: 0-未知变更,1-属性变更,2-部门调迁,3-主管变更,6-电话变更,7-名称变更,100-部门新增,300-部门关闭,400-部门重开
	 */
	private String changeCode;
	
	private String depId;
	
	private String depCode;
	
	/**
	 * 变更后部门对内名称
	 */
	private String newDepAbbr;
	
	/**
	 * 原部门对外名称
	 */
	private String oldDepAbbr;
	
	/**
	 * 变更后部门对外名称
	 */
	private String newTitle;
	
	private String oldDepTitle;
	
	/**
	 * 变更后市场类型ID
	 */
	private String newMarket;
	
	private String oldMarket;
	
	/**
	 * 变更后市场类型名称
	 */
	private String newMarketName;
	private String oldMarketName;
	
	/**
	 * 新前线类型id 1-二级市场|2-三级市场|3-交易按揭
	 */
	private String qxType;
	private String qxTypeName;
	
	/**
	 * 变更后部门所属分公司ID（分行）
	 */
	private String newCompId;
	
	private String oldCompId;
	
	/**
	 * 变更后部门主管工号
	 */
	private String newDirecorBadge;
	private String oldDirecorBadge;
	
	/**
	 * 变更后部门主管姓名
	 */
	private String newDirecorName;
	private String oldDirecorName;
	
	/**
	 * 变更后部门主管电话号码
	 */
	private String newTelD1;
	private String telD1;
	
	/**
	 * 部门级别ID
	 */
	private String depGradeId;
	private String depGradeTitle;
	
	/**
	 * 片区ID
	 */
	private String workAreaId;
	private String workAreaTitle;
	
	/**
	 *片区负责人工号
	 */
	private String workAreaManageBadge;
	
	/**
	 * 片区负责人姓名
	 */
	private String workAreaManageName;

	/**
	 * 大片区ID
	 */
	private String workAreaIdK;
	
	/**
	 * 大片区名称
	 */
	private String workAreaTitleK;
	
	/**
	 * 大片区负责人工号
	 */
	private String workAreaManageBadgeK;
	
	/**
	 * 大片区负责人姓名
	 */
	private String workAreaManageNameK;
	
	/**
	 * 行政区ID
	 */
	private String workAreaIdI;
	/**
	 * 行政区名称
	 */
	private String workAreaTitleI;
	/**
	 * 行政区负责人工号
	 */
	private String workAreaManageBadgeI;
	
	/**
	 * 行政区负责人姓名
	 */
	private String workAreaManageNameI;
	
	/**
	 * 该条记录中部门ID真实架构树代码
	 */
	private String orgPathHistory;
	private String OrgPath;
	private String newTel;
	private String tel;
	
	/**
	 * 变更生效时间
	 */
	private Date changeDate;
	
	/**
	 * 变更操作时间
	 */
	private Date initializedTime;
	
	/*
	 * 记录创建时间
	 */
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChangeId() {
		return changeId;
	}

	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcTypeCode() {
		return cTypeCode;
	}

	public void setcTypeCode(String cTypeCode) {
		this.cTypeCode = cTypeCode;
	}

	public String getChangeTitle() {
		return changeTitle;
	}

	public void setChangeTitle(String changeTitle) {
		this.changeTitle = changeTitle;
	}

	public String getChangeCode() {
		return changeCode;
	}

	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getNewDepAbbr() {
		return newDepAbbr;
	}

	public void setNewDepAbbr(String newDepAbbr) {
		this.newDepAbbr = newDepAbbr;
	}

	public String getOldDepAbbr() {
		return oldDepAbbr;
	}

	public void setOldDepAbbr(String oldDepAbbr) {
		this.oldDepAbbr = oldDepAbbr;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getOldDepTitle() {
		return oldDepTitle;
	}

	public void setOldDepTitle(String oldDepTitle) {
		this.oldDepTitle = oldDepTitle;
	}

	public String getNewMarket() {
		return newMarket;
	}

	public void setNewMarket(String newMarket) {
		this.newMarket = newMarket;
	}

	public String getOldMarket() {
		return oldMarket;
	}

	public void setOldMarket(String oldMarket) {
		this.oldMarket = oldMarket;
	}

	public String getNewMarketName() {
		return newMarketName;
	}

	public void setNewMarketName(String newMarketName) {
		this.newMarketName = newMarketName;
	}

	public String getOldMarketName() {
		return oldMarketName;
	}

	public void setOldMarketName(String oldMarketName) {
		this.oldMarketName = oldMarketName;
	}

	public String getQxType() {
		return qxType;
	}

	public void setQxType(String qxType) {
		this.qxType = qxType;
	}

	public String getQxTypeName() {
		return qxTypeName;
	}

	public void setQxTypeName(String qxTypeName) {
		this.qxTypeName = qxTypeName;
	}

	public String getNewCompId() {
		return newCompId;
	}

	public void setNewCompId(String newCompId) {
		this.newCompId = newCompId;
	}

	public String getOldCompId() {
		return oldCompId;
	}

	public void setOldCompId(String oldCompId) {
		this.oldCompId = oldCompId;
	}

	public String getNewDirecorBadge() {
		return newDirecorBadge;
	}

	public void setNewDirecorBadge(String newDirecorBadge) {
		this.newDirecorBadge = newDirecorBadge;
	}

	public String getOldDirecorBadge() {
		return oldDirecorBadge;
	}

	public void setOldDirecorBadge(String oldDirecorBadge) {
		this.oldDirecorBadge = oldDirecorBadge;
	}

	public String getNewDirecorName() {
		return newDirecorName;
	}

	public void setNewDirecorName(String newDirecorName) {
		this.newDirecorName = newDirecorName;
	}

	public String getOldDirecorName() {
		return oldDirecorName;
	}

	public void setOldDirecorName(String oldDirecorName) {
		this.oldDirecorName = oldDirecorName;
	}

	public String getNewTelD1() {
		return newTelD1;
	}

	public void setNewTelD1(String newTelD1) {
		this.newTelD1 = newTelD1;
	}

	public String getTelD1() {
		return telD1;
	}

	public void setTelD1(String telD1) {
		this.telD1 = telD1;
	}

	public String getDepGradeId() {
		return depGradeId;
	}

	public void setDepGradeId(String depGradeId) {
		this.depGradeId = depGradeId;
	}

	public String getDepGradeTitle() {
		return depGradeTitle;
	}

	public void setDepGradeTitle(String depGradeTitle) {
		this.depGradeTitle = depGradeTitle;
	}

	public String getWorkAreaId() {
		return workAreaId;
	}

	public void setWorkAreaId(String workAreaId) {
		this.workAreaId = workAreaId;
	}

	public String getWorkAreaTitle() {
		return workAreaTitle;
	}

	public void setWorkAreaTitle(String workAreaTitle) {
		this.workAreaTitle = workAreaTitle;
	}

	public String getWorkAreaManageBadge() {
		return workAreaManageBadge;
	}

	public void setWorkAreaManageBadge(String workAreaManageBadge) {
		this.workAreaManageBadge = workAreaManageBadge;
	}

	public String getWorkAreaManageName() {
		return workAreaManageName;
	}

	public void setWorkAreaManageName(String workAreaManageName) {
		this.workAreaManageName = workAreaManageName;
	}

	public String getWorkAreaIdK() {
		return workAreaIdK;
	}

	public void setWorkAreaIdK(String workAreaIdK) {
		this.workAreaIdK = workAreaIdK;
	}

	public String getWorkAreaTitleK() {
		return workAreaTitleK;
	}

	public void setWorkAreaTitleK(String workAreaTitleK) {
		this.workAreaTitleK = workAreaTitleK;
	}

	public String getWorkAreaManageBadgeK() {
		return workAreaManageBadgeK;
	}

	public void setWorkAreaManageBadgeK(String workAreaManageBadgeK) {
		this.workAreaManageBadgeK = workAreaManageBadgeK;
	}

	public String getWorkAreaManageNameK() {
		return workAreaManageNameK;
	}

	public void setWorkAreaManageNameK(String workAreaManageNameK) {
		this.workAreaManageNameK = workAreaManageNameK;
	}

	public String getWorkAreaIdI() {
		return workAreaIdI;
	}

	public void setWorkAreaIdI(String workAreaIdI) {
		this.workAreaIdI = workAreaIdI;
	}

	public String getWorkAreaTitleI() {
		return workAreaTitleI;
	}

	public void setWorkAreaTitleI(String workAreaTitleI) {
		this.workAreaTitleI = workAreaTitleI;
	}

	public String getWorkAreaManageBadgeI() {
		return workAreaManageBadgeI;
	}

	public void setWorkAreaManageBadgeI(String workAreaManageBadgeI) {
		this.workAreaManageBadgeI = workAreaManageBadgeI;
	}

	public String getWorkAreaManageNameI() {
		return workAreaManageNameI;
	}

	public void setWorkAreaManageNameI(String workAreaManageNameI) {
		this.workAreaManageNameI = workAreaManageNameI;
	}

	public String getOrgPathHistory() {
		return orgPathHistory;
	}

	public void setOrgPathHistory(String orgPathHistory) {
		this.orgPathHistory = orgPathHistory;
	}

	public String getOrgPath() {
		return OrgPath;
	}

	public void setOrgPath(String orgPath) {
		OrgPath = orgPath;
	}

	public String getNewTel() {
		return newTel;
	}

	public void setNewTel(String newTel) {
		this.newTel = newTel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Date getInitializedTime() {
		return initializedTime;
	}

	public void setInitializedTime(Date initializedTime) {
		this.initializedTime = initializedTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}