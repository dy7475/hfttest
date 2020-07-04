package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class Admin_Sync_OA_ML_UserChangeData2 implements Serializable {
	
	
    /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	* @author tangliang1
	*/
	private static final long serialVersionUID = -2816166511202290319L;


	private String id;

    private String cType;

    private String cTypeCode;

    private String changeTitle;

    private String changeId;

    private String oldBage;

    private String badge;

    private String name;

    private String certNo;

    private String oldMobile;

    private String newMobile;

    private Date changeDate;

    private String oldDepCode;

    private String newDepCode;

    private String oldDepId;

    private String newDepId;

    private String oldDepMarKet;

    private String oldMarketName;

    private String newDepMarket;

    private String newMarketName;

    private String oldDepAbbr;

    private String newDepAbbr;

    private String oldEmpgrade;

    private String newEmpgrade;

    private Date joinDate;

    private Date leaveDate;

    private String hongKongId;

    private Date initializedTime;

    private String oldJobName;

    private String oldJobId;

    private String newJobName;

    private String newJobId;

    private String eStatue;

    private String oldQxtype;

    private String oldQxtypeName;

    private String newQxtype;

    private String newQxtypeName;

    private String orgPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId == null ? null : changeId.trim();
    }

    public String getOldBage() {
        return oldBage;
    }

    public void setOldBage(String oldBage) {
        this.oldBage = oldBage == null ? null : oldBage.trim();
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge == null ? null : badge.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public String getOldMobile() {
        return oldMobile;
    }

    public void setOldMobile(String oldMobile) {
        this.oldMobile = oldMobile == null ? null : oldMobile.trim();
    }

    public String getNewMobile() {
        return newMobile;
    }

    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile == null ? null : newMobile.trim();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getOldDepCode() {
        return oldDepCode;
    }

    public void setOldDepCode(String oldDepCode) {
        this.oldDepCode = oldDepCode == null ? null : oldDepCode.trim();
    }

    public String getNewDepCode() {
        return newDepCode;
    }

    public void setNewDepCode(String newDepCode) {
        this.newDepCode = newDepCode == null ? null : newDepCode.trim();
    }

    public String getOldDepId() {
        return oldDepId;
    }

    public void setOldDepId(String oldDepId) {
        this.oldDepId = oldDepId == null ? null : oldDepId.trim();
    }

    public String getNewDepId() {
        return newDepId;
    }

    public void setNewDepId(String newDepId) {
        this.newDepId = newDepId == null ? null : newDepId.trim();
    }

    public String getOldDepMarKet() {
        return oldDepMarKet;
    }

    public void setOldDepMarKet(String oldDepMarKet) {
        this.oldDepMarKet = oldDepMarKet == null ? null : oldDepMarKet.trim();
    }

    public String getOldMarketName() {
        return oldMarketName;
    }

    public void setOldMarketName(String oldMarketName) {
        this.oldMarketName = oldMarketName == null ? null : oldMarketName.trim();
    }

    public String getNewDepMarket() {
        return newDepMarket;
    }

    public void setNewDepMarket(String newDepMarket) {
        this.newDepMarket = newDepMarket == null ? null : newDepMarket.trim();
    }

    public String getNewMarketName() {
        return newMarketName;
    }

    public void setNewMarketName(String newMarketName) {
        this.newMarketName = newMarketName == null ? null : newMarketName.trim();
    }

    public String getOldDepAbbr() {
        return oldDepAbbr;
    }

    public void setOldDepAbbr(String oldDepAbbr) {
        this.oldDepAbbr = oldDepAbbr == null ? null : oldDepAbbr.trim();
    }

    public String getNewDepAbbr() {
        return newDepAbbr;
    }

    public void setNewDepAbbr(String newDepAbbr) {
        this.newDepAbbr = newDepAbbr == null ? null : newDepAbbr.trim();
    }

    public String getOldEmpgrade() {
        return oldEmpgrade;
    }

    public void setOldEmpgrade(String oldEmpgrade) {
        this.oldEmpgrade = oldEmpgrade == null ? null : oldEmpgrade.trim();
    }

    public String getNewEmpgrade() {
        return newEmpgrade;
    }

    public void setNewEmpgrade(String newEmpgrade) {
        this.newEmpgrade = newEmpgrade == null ? null : newEmpgrade.trim();
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

    public String getHongKongId() {
        return hongKongId;
    }

    public void setHongKongId(String hongKongId) {
        this.hongKongId = hongKongId == null ? null : hongKongId.trim();
    }

    public Date getInitializedTime() {
        return initializedTime;
    }

    public void setInitializedTime(Date initializedTime) {
        this.initializedTime = initializedTime;
    }

    public String getOldJobName() {
        return oldJobName;
    }

    public void setOldJobName(String oldJobName) {
        this.oldJobName = oldJobName == null ? null : oldJobName.trim();
    }

    public String getOldJobId() {
        return oldJobId;
    }

    public void setOldJobId(String oldJobId) {
        this.oldJobId = oldJobId == null ? null : oldJobId.trim();
    }

    public String getNewJobName() {
        return newJobName;
    }

    public void setNewJobName(String newJobName) {
        this.newJobName = newJobName == null ? null : newJobName.trim();
    }

    public String getNewJobId() {
        return newJobId;
    }

    public void setNewJobId(String newJobId) {
        this.newJobId = newJobId == null ? null : newJobId.trim();
    }

    public String geteStatue() {
        return eStatue;
    }

    public void seteStatue(String eStatue) {
        this.eStatue = eStatue == null ? null : eStatue.trim();
    }

    public String getOldQxtype() {
        return oldQxtype;
    }

    public void setOldQxtype(String oldQxtype) {
        this.oldQxtype = oldQxtype == null ? null : oldQxtype.trim();
    }

    public String getOldQxtypeName() {
        return oldQxtypeName;
    }

    public void setOldQxtypeName(String oldQxtypeName) {
        this.oldQxtypeName = oldQxtypeName == null ? null : oldQxtypeName.trim();
    }

    public String getNewQxtype() {
        return newQxtype;
    }

    public void setNewQxtype(String newQxtype) {
        this.newQxtype = newQxtype == null ? null : newQxtype.trim();
    }

    public String getNewQxtypeName() {
        return newQxtypeName;
    }

    public void setNewQxtypeName(String newQxtypeName) {
        this.newQxtypeName = newQxtypeName == null ? null : newQxtypeName.trim();
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }
}