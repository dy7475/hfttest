package com.myfun.erpWeb.managecenter.employeeFiles.param;

import java.util.Date;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EditEmployeeDocParam implements EncryParamIfc {

	@ApiModelProperty(value = "档案ID")
	private Integer archiveId;
	@ApiModelProperty(value = "创建时间, 修改员工档案的时候不传这个字段")
	private Date creationTime;
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	@ApiModelProperty(value = "民族")
	private String nation;
	@ApiModelProperty(value = "婚姻状况 0= 未婚   1= 已婚 2：丧偶 3：离异")
	private Byte maritalStatus;
	@ApiModelProperty(value = "籍贯")
	private String placeOfOrigin;
	@ApiModelProperty(value = "毕业院校")
	private String userSchool;
	@ApiModelProperty(value = "银行账号")
	private String bankAccount;
	@ApiModelProperty(value = "社保账号")
	private String socialSecurityAccount;
	@ApiModelProperty(value = "备注信息")
	private String remarkInfo;
	@ApiModelProperty(value = "渠道说明")
	private String channelDescription;
	@ApiModelProperty(value = "学历,DD: USER_SCHLRECORD 1=初中 2=高中 3=中值 4=大专 5=本科 6=硕士 7=博士")
	private String userSchlrecord;
	@ApiModelProperty(value = "银行类型")
	private Integer accountType;
	@ApiModelProperty(value = "毕业时间")
	private Date graduationTime;
	@ApiModelProperty(value = "入职")
	private Date userJobDate;
	@ApiModelProperty(value = "离职")
	private Date writeoffTime;
	@ApiModelProperty(value = "当前员工的USER_ID")
	private Integer userId;
	@ApiModelProperty(value = "出生日期")
	private Date userBirthday;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "用户状态")
	private Integer userStatus;
	@ApiModelProperty(value = "门店Id")
	private Integer deptId;
	@ApiModelProperty(value = "分组Id")
	private Integer grId;
	@ApiModelProperty(value = "实名认证状态")
	private Integer userRight;
	@ApiModelProperty(value = "门店名字")
	private String deptName;
	@ApiModelProperty(value = "用户角色Id")
	private String userPosition;
	@ApiModelProperty(value = "工作年限")
	private String workingYears;
	@ApiModelProperty(value = "服务区域")
	private String serviceReg;
	@ApiModelProperty(value = "服务商圈")
	private String serviceZone;
	@ApiModelProperty(value = "QQ")
	private String userQq;
	@ApiModelProperty(value = "邮件")
	private String userEmail;
	@ApiModelProperty(value = "地址")
	private String userAddress;
	@ApiModelProperty(value = "身份证")
	private String userIccode;
	@ApiModelProperty(value = "政治面貌，DD:USER_POLITY")
	private String userPolity;
	@ApiModelProperty(value = "毕业专业")
	private String userField;
	@ApiModelProperty(value = "商圈Id")
	private String serviceZoneIds;
//	@ApiModelProperty(value = "用户头像")
//	private String userPhoto;
	@ApiModelProperty(value = "办公电话（备用电话)")
	private String userOfficeph;
	@ApiModelProperty(value = "住宅电话(应急电话)")
	private String userFixedph;
	@ApiModelProperty(value = "性别")
	private Byte userSex;
	@ApiModelProperty(value = "入职渠道")
	private String recruitmentChannel;
	@ApiModelProperty(value = "用户电话")
	private String userMobile;
	@ApiModelProperty(value = "公司区域ID，From:FUN_REGION")
	private Integer regId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	@ApiModelProperty(value = "注销状态;0=在职，1=注销")
	private Integer userWriteoff;
	@ApiModelProperty(value = "FUN_EMPLOYEE_DOC 主键Id")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserWriteoff() {
		return userWriteoff;
	}

	public void setUserWriteoff(Integer userWriteoff) {
		this.userWriteoff = userWriteoff;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Byte getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Byte maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getSocialSecurityAccount() {
		return socialSecurityAccount;
	}

	public void setSocialSecurityAccount(String socialSecurityAccount) {
		this.socialSecurityAccount = socialSecurityAccount;
	}

	public String getRemarkInfo() {
		return remarkInfo;
	}

	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}

	public String getChannelDescription() {
		return channelDescription;
	}

	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public String getUserSchlrecord() {
		return userSchlrecord;
	}

	public void setUserSchlrecord(String userSchlrecord) {
		this.userSchlrecord = userSchlrecord;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Date getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

	public Date getUserJobDate() {
		return userJobDate;
	}

	public void setUserJobDate(Date userJobDate) {
		this.userJobDate = userJobDate;
	}

	public Date getWriteoffTime() {
		return writeoffTime;
	}

	public void setWriteoffTime(Date writeoffTime) {
		this.writeoffTime = writeoffTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserRight() {
		return userRight;
	}

	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(String workingYears) {
		this.workingYears = workingYears;
	}

	public String getServiceReg() {
		return serviceReg;
	}

	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg;
	}

	public String getServiceZone() {
		return serviceZone;
	}

	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserIccode() {
		return userIccode;
	}

	public void setUserIccode(String userIccode) {
		this.userIccode = userIccode;
	}

	public String getUserPolity() {
		return userPolity;
	}

	public void setUserPolity(String userPolity) {
		this.userPolity = userPolity;
	}

	public String getUserField() {
		return userField;
	}

	public void setUserField(String userField) {
		this.userField = userField;
	}

	public String getServiceZoneIds() {
		return serviceZoneIds;
	}

	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds;
	}

//	public String getUserPhoto() {
//		return userPhoto;
//	}
//
//	public void setUserPhoto(String userPhoto) {
//		this.userPhoto = userPhoto;
//	}

	public String getUserOfficeph() {
		return userOfficeph;
	}

	public void setUserOfficeph(String userOfficeph) {
		this.userOfficeph = userOfficeph;
	}

	public String getUserFixedph() {
		return userFixedph;
	}

	public void setUserFixedph(String userFixedph) {
		this.userFixedph = userFixedph;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public String getRecruitmentChannel() {
		return recruitmentChannel;
	}

	public void setRecruitmentChannel(String recruitmentChannel) {
		this.recruitmentChannel = recruitmentChannel;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
}
