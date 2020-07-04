package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class FunKeyDetailDto {
    private String deptName;
    private Integer keyStatus;
    private String userMobile;
    private Integer keyId;
    private String keyNum;
    private String userName;
    private Integer keDeptId;
    private String keyNote;
    private Integer keyLogId;
    private String borrowUserMobile;
    private String borrowUserName;
    private Integer borrowUserDept;
    private String trackUserName;
    private String trackUserMobile;
    private Integer currentDepositStatus;
    private BigDecimal currentDeposit;
    private Integer logType;
    private String reviewName;
    private String keyVoucher;
	private Integer borrowUserOrganizationId;
    @ApiModelProperty(value = "钥匙类型，1：数量，2：密码")
    private Byte keyType;

    @ApiModelProperty(value = "钥匙总数")
    private Integer keyCount;

    @ApiModelProperty(value = "收取时间")
    private Date gatherTime;

    @ApiModelProperty(value = "借出数量")
    private Integer lendCount;

    @ApiModelProperty(value = "钥匙密码")
    private String keyPassword;

    @ApiModelProperty(value = "当前操作人是否钥匙提交人，或者提交人本人直属领导，没有直属领导算上上级，1：是，2：否")
    private Byte directlyLeaderOrSelf = Byte.valueOf("2");

    @ApiModelProperty(value = "钥匙所属人ID")
    private Integer userId;

    public Byte getKeyType() {
        return keyType;
    }

    public void setKeyType(Byte keyType) {
        this.keyType = keyType;
    }

    public Integer getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(Integer keyCount) {
        this.keyCount = keyCount;
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Integer getLendCount() {
        return lendCount;
    }

    public void setLendCount(Integer lendCount) {
        this.lendCount = lendCount;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public Byte getDirectlyLeaderOrSelf() {
        return directlyLeaderOrSelf;
    }

    public void setDirectlyLeaderOrSelf(Byte directlyLeaderOrSelf) {
        this.directlyLeaderOrSelf = directlyLeaderOrSelf;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	public Integer getBorrowUserOrganizationId() {
        return borrowUserOrganizationId;
    }

    public void setBorrowUserOrganizationId(Integer borrowUserOrganizationId) {
        this.borrowUserOrganizationId = borrowUserOrganizationId;
    }
    public String getKeyVoucher() {
		return keyVoucher;
	}

	public void setKeyVoucher(String keyVoucher) {
		this.keyVoucher = keyVoucher;
	}

	public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getCurrentDepositStatus() {
        return currentDepositStatus;
    }

    public void setCurrentDepositStatus(Integer currentDepositStatus) {
        this.currentDepositStatus = currentDepositStatus;
    }

    public BigDecimal getCurrentDeposit() {
        return currentDeposit;
    }

    public void setCurrentDeposit(BigDecimal currentDeposit) {
        this.currentDeposit = currentDeposit;
    }

    public String getKeyNote() {
        return keyNote;
    }

    public void setKeyNote(String keyNote) {
        this.keyNote = keyNote;
    }

    public String getBorrowUserMobile() {
        return borrowUserMobile;
    }

    public void setBorrowUserMobile(String borrowUserMobile) {
        this.borrowUserMobile = borrowUserMobile;
    }

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public Integer getBorrowUserDept() {
        return borrowUserDept;
    }

    public void setBorrowUserDept(Integer borrowUserDept) {
        this.borrowUserDept = borrowUserDept;
    }

    public String getTrackUserName() {
        return trackUserName;
    }

    public void setTrackUserName(String trackUserName) {
        this.trackUserName = trackUserName;
    }

    public String getTrackUserMobile() {
        return trackUserMobile;
    }

    public void setTrackUserMobile(String trackUserMobile) {
        this.trackUserMobile = trackUserMobile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Integer keyStatus) {
        this.keyStatus = keyStatus;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(String keyNum) {
        this.keyNum = keyNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getKeDeptId() {
        return keDeptId;
    }

    public void setKeDeptId(Integer keDeptId) {
        this.keDeptId = keDeptId;
    }

    public Integer getKeyLogId() {
        return keyLogId;
    }

    public void setKeyLogId(Integer keyLogId) {
        this.keyLogId = keyLogId;
    }
}
