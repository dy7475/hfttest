package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class Admin_Sync_OA_ML_DepartmentChangeData2 implements Serializable {
	
    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/
	private static final long serialVersionUID = -171601647984430206L;


	private Integer id;

    private Integer changeId;

    private String cType;

    private String cTypeCode;

    private String changeTitle;

    private String changeCode;

    private String depId;

    private String depCode;

    private String newDepAbbr;

    private String oldDepAbbr;

    private String newTitle;

    private String oldDepTitle;

    private String newMarket;

    private String oldMarket;

    private String newMarketName;

    private String oldMarketName;

    private String qxType;

    private String qxTypeName;

    private String newCompId;

    private String oldCompId;

    private String newDirecorBadge;

    private String oldDirecorBadge;

    private String newDirecorName;

    private String oldDirecorName;

    private String newTelD1;

    private String telD1;

    private String depGradeId;

    private String depGradeTitle;

    private String workAreaId;

    private String workAreaTitle;

    private String workAreaManageBadge;

    private String workAreaManageName;

    private String workAreaIdK;

    private String workAreaTitleK;

    private String workAreaManageBadgeK;

    private String workAreaManageNameK;

    private String workAreaIdI;

    private String workAreaTitleI;

    private String workAreaManageBadgeI;

    private String workAreaManageNameI;

    private String orgPathHistory;

    private String orgPath;

    private String newTel;

    private String tel;

    private Date changeDate;

    private Date initializedTime;

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
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcTypeCode() {
        return cTypeCode;
    }

    public void setcTypeCode(String cTypeCode) {
        this.cTypeCode = cTypeCode == null ? null : cTypeCode.trim();
    }

    public String getChangeTitle() {
        return changeTitle;
    }

    public void setChangeTitle(String changeTitle) {
        this.changeTitle = changeTitle == null ? null : changeTitle.trim();
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(String changeCode) {
        this.changeCode = changeCode == null ? null : changeCode.trim();
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId == null ? null : depId.trim();
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode == null ? null : depCode.trim();
    }

    public String getNewDepAbbr() {
        return newDepAbbr;
    }

    public void setNewDepAbbr(String newDepAbbr) {
        this.newDepAbbr = newDepAbbr == null ? null : newDepAbbr.trim();
    }

    public String getOldDepAbbr() {
        return oldDepAbbr;
    }

    public void setOldDepAbbr(String oldDepAbbr) {
        this.oldDepAbbr = oldDepAbbr == null ? null : oldDepAbbr.trim();
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle == null ? null : newTitle.trim();
    }

    public String getOldDepTitle() {
        return oldDepTitle;
    }

    public void setOldDepTitle(String oldDepTitle) {
        this.oldDepTitle = oldDepTitle == null ? null : oldDepTitle.trim();
    }

    public String getNewMarket() {
        return newMarket;
    }

    public void setNewMarket(String newMarket) {
        this.newMarket = newMarket == null ? null : newMarket.trim();
    }

    public String getOldMarket() {
        return oldMarket;
    }

    public void setOldMarket(String oldMarket) {
        this.oldMarket = oldMarket == null ? null : oldMarket.trim();
    }

    public String getNewMarketName() {
        return newMarketName;
    }

    public void setNewMarketName(String newMarketName) {
        this.newMarketName = newMarketName == null ? null : newMarketName.trim();
    }

    public String getOldMarketName() {
        return oldMarketName;
    }

    public void setOldMarketName(String oldMarketName) {
        this.oldMarketName = oldMarketName == null ? null : oldMarketName.trim();
    }

    public String getQxType() {
        return qxType;
    }

    public void setQxType(String qxType) {
        this.qxType = qxType == null ? null : qxType.trim();
    }

    public String getQxTypeName() {
        return qxTypeName;
    }

    public void setQxTypeName(String qxTypeName) {
        this.qxTypeName = qxTypeName == null ? null : qxTypeName.trim();
    }

    public String getNewCompId() {
        return newCompId;
    }

    public void setNewCompId(String newCompId) {
        this.newCompId = newCompId == null ? null : newCompId.trim();
    }

    public String getOldCompId() {
        return oldCompId;
    }

    public void setOldCompId(String oldCompId) {
        this.oldCompId = oldCompId == null ? null : oldCompId.trim();
    }

    public String getNewDirecorBadge() {
        return newDirecorBadge;
    }

    public void setNewDirecorBadge(String newDirecorBadge) {
        this.newDirecorBadge = newDirecorBadge == null ? null : newDirecorBadge.trim();
    }

    public String getOldDirecorBadge() {
        return oldDirecorBadge;
    }

    public void setOldDirecorBadge(String oldDirecorBadge) {
        this.oldDirecorBadge = oldDirecorBadge == null ? null : oldDirecorBadge.trim();
    }

    public String getNewDirecorName() {
        return newDirecorName;
    }

    public void setNewDirecorName(String newDirecorName) {
        this.newDirecorName = newDirecorName == null ? null : newDirecorName.trim();
    }

    public String getOldDirecorName() {
        return oldDirecorName;
    }

    public void setOldDirecorName(String oldDirecorName) {
        this.oldDirecorName = oldDirecorName == null ? null : oldDirecorName.trim();
    }

    public String getNewTelD1() {
        return newTelD1;
    }

    public void setNewTelD1(String newTelD1) {
        this.newTelD1 = newTelD1 == null ? null : newTelD1.trim();
    }

    public String getTelD1() {
        return telD1;
    }

    public void setTelD1(String telD1) {
        this.telD1 = telD1 == null ? null : telD1.trim();
    }

    public String getDepGradeId() {
        return depGradeId;
    }

    public void setDepGradeId(String depGradeId) {
        this.depGradeId = depGradeId == null ? null : depGradeId.trim();
    }

    public String getDepGradeTitle() {
        return depGradeTitle;
    }

    public void setDepGradeTitle(String depGradeTitle) {
        this.depGradeTitle = depGradeTitle == null ? null : depGradeTitle.trim();
    }

    public String getWorkAreaId() {
        return workAreaId;
    }

    public void setWorkAreaId(String workAreaId) {
        this.workAreaId = workAreaId == null ? null : workAreaId.trim();
    }

    public String getWorkAreaTitle() {
        return workAreaTitle;
    }

    public void setWorkAreaTitle(String workAreaTitle) {
        this.workAreaTitle = workAreaTitle == null ? null : workAreaTitle.trim();
    }

    public String getWorkAreaManageBadge() {
        return workAreaManageBadge;
    }

    public void setWorkAreaManageBadge(String workAreaManageBadge) {
        this.workAreaManageBadge = workAreaManageBadge == null ? null : workAreaManageBadge.trim();
    }

    public String getWorkAreaManageName() {
        return workAreaManageName;
    }

    public void setWorkAreaManageName(String workAreaManageName) {
        this.workAreaManageName = workAreaManageName == null ? null : workAreaManageName.trim();
    }

    public String getWorkAreaIdK() {
        return workAreaIdK;
    }

    public void setWorkAreaIdK(String workAreaIdK) {
        this.workAreaIdK = workAreaIdK == null ? null : workAreaIdK.trim();
    }

    public String getWorkAreaTitleK() {
        return workAreaTitleK;
    }

    public void setWorkAreaTitleK(String workAreaTitleK) {
        this.workAreaTitleK = workAreaTitleK == null ? null : workAreaTitleK.trim();
    }

    public String getWorkAreaManageBadgeK() {
        return workAreaManageBadgeK;
    }

    public void setWorkAreaManageBadgeK(String workAreaManageBadgeK) {
        this.workAreaManageBadgeK = workAreaManageBadgeK == null ? null : workAreaManageBadgeK.trim();
    }

    public String getWorkAreaManageNameK() {
        return workAreaManageNameK;
    }

    public void setWorkAreaManageNameK(String workAreaManageNameK) {
        this.workAreaManageNameK = workAreaManageNameK == null ? null : workAreaManageNameK.trim();
    }

    public String getWorkAreaIdI() {
        return workAreaIdI;
    }

    public void setWorkAreaIdI(String workAreaIdI) {
        this.workAreaIdI = workAreaIdI == null ? null : workAreaIdI.trim();
    }

    public String getWorkAreaTitleI() {
        return workAreaTitleI;
    }

    public void setWorkAreaTitleI(String workAreaTitleI) {
        this.workAreaTitleI = workAreaTitleI == null ? null : workAreaTitleI.trim();
    }

    public String getWorkAreaManageBadgeI() {
        return workAreaManageBadgeI;
    }

    public void setWorkAreaManageBadgeI(String workAreaManageBadgeI) {
        this.workAreaManageBadgeI = workAreaManageBadgeI == null ? null : workAreaManageBadgeI.trim();
    }

    public String getWorkAreaManageNameI() {
        return workAreaManageNameI;
    }

    public void setWorkAreaManageNameI(String workAreaManageNameI) {
        this.workAreaManageNameI = workAreaManageNameI == null ? null : workAreaManageNameI.trim();
    }

    public String getOrgPathHistory() {
        return orgPathHistory;
    }

    public void setOrgPathHistory(String orgPathHistory) {
        this.orgPathHistory = orgPathHistory == null ? null : orgPathHistory.trim();
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    public String getNewTel() {
        return newTel;
    }

    public void setNewTel(String newTel) {
        this.newTel = newTel == null ? null : newTel.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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