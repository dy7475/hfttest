package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.vo.GetRoleByCompIdVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.OpersVO;
import com.myfun.repository.erpdb.po.ErpFunOpers;
import com.myfun.repository.erpdb.po.ErpFunUsers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunUsersDto extends ErpFunUsers{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "公司编号")
	private String compNo;
	@ApiModelProperty(value = "门店编号")
	private String deptNo;
	private String processByName;
	@ApiModelProperty(value = "erp库公司名称")
	private String erpCompName;
	private Integer manageUserId;
	private Integer manageArchiveId;
	// erp 扩展字段
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	@ApiModelProperty(value = "职级名称")
	private String roleLevelName;
	@ApiModelProperty(value = "角色Id")
	private String roleId;
	private Integer seqNo;
	private Integer baseMoney;
	@ApiModelProperty(value = "分组名字")
	private String grName;
	@ApiModelProperty(value = "身份证")
    private String userIccode;
	@ApiModelProperty(value = "用户出生年月")
    private Date userBirthday;
	@ApiModelProperty(value = "用户出生年月字符串")
    private String userBirthdayStr;
	@ApiModelProperty(value = "邮件地址")
    private String userEmail;
	@ApiModelProperty(value = "住宅电话(应急电话)")
    private String userFixedph;
	@ApiModelProperty(value = "办公电话(备用电话)")
    private String userOfficeph;
	@ApiModelProperty(value = "QQ")
    private String userQq;
	@ApiModelProperty(value = "省份ID")
    private Integer provinceId;
	@ApiModelProperty(value = "服务区域")
    private String serviceReg;
	@ApiModelProperty(value = "服务片区")
    private String serviceZone;
	@ApiModelProperty(value = "联系地址")
    private String userAddress;
	@ApiModelProperty(value = "邮编")
    private String userPostcode;
	@ApiModelProperty(value = "毕业院校")
    private String userSchool;
	@ApiModelProperty(value = "毕业专业")
    private String userField;
	@ApiModelProperty(value = "学历，DD: USER_SCHLRECORD 1=初中 2=高中 3=中值 4=大专 5=本科 6=硕士 7=博士")
    private String userSchlrecord;
	@ApiModelProperty(value = "外语水平，DD:USER_FOREIGN")
    private String userForeign;
	@ApiModelProperty(value = "政治面貌，DD:USER_POLITY")
    private String userPolity;
    @ApiModelProperty(value = "执业签名")
    private String professionSub;
    @ApiModelProperty(value = "用户简历")
    private String userDesc;
    @ApiModelProperty(value = "资格证号")
    private String userNumber;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "身份证照片1")
    private String icPhoto1;
    @ApiModelProperty(value = "身份证照片2")
    private String icPhoto2;
    @ApiModelProperty(value = "个人小头像（实名认证小头像）")
    private String userPhotoMin;
    @ApiModelProperty(value = "名片图片")
    private String cardPhoto;
    @ApiModelProperty(value = "论坛头像")
    private String bbsPhoto;
    @ApiModelProperty(value = "商铺内景图")
    private String shopInnerPhoto;
    @ApiModelProperty(value = "商铺外景图")
    private String shopOuterPhoto;
    @ApiModelProperty(value = "资金帐户ID")
    private Integer uaId;
    @ApiModelProperty(value = "实名认证 审核标记，0=未通过 1=已通过")
    private Integer userRight;
    @ApiModelProperty(value = "资质认证，0=未通过 1=已通过")
    private Integer userHonest;
    @ApiModelProperty(value = "高级用户，0=体验 1=安装 2=禁用     0=非vip  1=vip用户")
    private Integer superUser;
    @ApiModelProperty(value = "开始时间(一注册赠送的)")
    private Date superStart;
    @ApiModelProperty(value = "结束时间   VIP到期（一注册赠送的，但是终身会员这个是2055-01-01 00:00:00.000，ERP要使用这个字段）")
    private Date superEnd;
    @ApiModelProperty(value = "赠送增值服务天数")
    private Integer superDays;
    @ApiModelProperty(value = "网店状态，0=关闭 1=开启")
    private Integer webstoreStatus;
    @ApiModelProperty(value = "是否有小区专家竞价，0=无 1=有")
    private Integer userBidding;
    @ApiModelProperty(value = "是否有房源推广竞价，0=无 1=有")
    private Integer houseBidding;
    @ApiModelProperty(value = "指名改档案是从哪个ARCHIVE_ID拷贝的")
    private Integer copyFrom;
    @ApiModelProperty(value = "用户所在门店总人数")
    private Integer countUsers;
    @ApiModelProperty(value = "购买增值服务到期日期(区分购买和赠送)（vip到期时间）")
    private Date buySrvEnd;
    private Integer friendFlag;
    @ApiModelProperty(value = "销售公司，1=通过CRM直充精英版，如果为空并且是首次购买，则写入销售公司ID；2=用户通过个人中心购买服务，如果为首次购买，则写入0；3=购买精英版服务时，如果销售公司ID为分销商，则不管是何种方式、销售公司是谁都需要向分销商返点。")
    private Integer sellComp;
    @ApiModelProperty(value = "销售人员")
    private Integer sellId;
    @ApiModelProperty(value = "销版用户手机认证标记，0=否 1=是")
    private Byte mobileValided;
    @ApiModelProperty(value = "当天预算，默认：3")
    private BigDecimal highAmount;
    @ApiModelProperty(value = "当天消费金额")
    private BigDecimal balance;
    @ApiModelProperty(value = "资金帐户关联认证，0=未认证1=已认证 默认：1")
    private Byte validAccount;
    @ApiModelProperty(value = "erp最后登录时间")
    private Date lastLoginTime;
    @ApiModelProperty(value = "注册来源：网站=0。APP来源=1。微信来源=2。ERP 来源=3。第三方 来源=4。 例如：第三方竞价，5=充值分享，6=全民分销，7=推荐注册，8=诚信经纪人邀请注册,9 销售专属链接 ，10 短信批量推送,11.公众号专属 ；12=真房源分享注册 ；13=全民分销（新2018-05-09）")
    private Byte regFrom;
    @ApiModelProperty(value = "服务片区ID")
    private String serviceZoneIds;
    @ApiModelProperty(value = "IS_DISPATCHER")
    private Byte isDispatcher;
    @ApiModelProperty(value = "UA_ID_COMP")
    private Integer uaIdComp;
	@ApiModelProperty(value = "门店名称")
    private String deptName;
    private String  changes;
    @ApiModelProperty(value = "民族")
    private String  nation;
    @ApiModelProperty(value = "婚姻状况 0= 未婚   1= 已婚 2：丧偶 3：离异")
    private String  maritalStatus;
    @ApiModelProperty(value = "籍贯")
    private String  placeOfOrigin;
    @ApiModelProperty(value = "银行账号")
    private String  bankAccount;
    @ApiModelProperty(value = "社保账号")
    private String  socialSecurityAccount;
    @ApiModelProperty(value = "备注信息")
    private String  remarkInfo;
    @ApiModelProperty(value = "渠道说明")
    private String  channelDescription;
    @ApiModelProperty(value = "毕业时间")
    private Date  graduationTime;
    @ApiModelProperty(value = "毕业时间字符串")
    private String  graduationTimeStr;
    @ApiModelProperty(value = "档案主键Id")
    private Integer  employeeDocId;
    @ApiModelProperty(value = "工作年限")
    private Integer  workingYears;
    @ApiModelProperty(value = "最后的调动记录")
    private String userLastContent;
    @ApiModelProperty(value = "刷脸认证是否开启,1是0否")
	private Byte faceRecognitionFlag;
	private Integer userCount;
	@ApiModelProperty(value = "管理范围")
	private Integer rangeType;
	@ApiModelProperty(value = "范围Id(逗号分隔)")
	private String rangeIds;
	@ApiModelProperty(value = "高于默认的权限")
	private List<ErpFunOpers> advanceOperList;  //高于默认的权限
	@ApiModelProperty(value = "缺失的基本权限")
	private List<ErpFunOpers> baseOperList;  //缺失的基本权限
	@ApiModelProperty(value = "用户头像IM用") //fun_archive表里面的头像
	private String  userArchivePhoto;
	@ApiModelProperty(value = "管理层级 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组")
	private Byte manageLevel;
	@ApiModelProperty(value = "组织机构名称")
	private String organizationName;
	
	@ApiModelProperty(value = "入职日期字符串")
	private String userJobDateStr;
	
	@ApiModelProperty(value = "公司大区名称")
	private String areaName;
	
	@ApiModelProperty(value = "公司片区名称")
	private String regName;
	
	@ApiModelProperty(value = "用户性别字符串")
	private String userSexStr;
	
	// 员工附件资料的上传情况
	@ApiModelProperty(value = "身份证附件资料上传情况，已上传|未上传")
	private String idCardAttachment;
	
	@ApiModelProperty(value = "学历证书附件资料上传情况")
	private String educationAttachment;
	
	@ApiModelProperty(value = "荣誉证书附件资料上传情况")
	private String honorAttachment;
	
	@ApiModelProperty(value = "档案附件资料上传情况")
	private String archiveAttachment;
	
	@ApiModelProperty(value = "其他附件资料上传情况")
	private String otherAttachment;

	@ApiModelProperty(value = "高于默认的权限-- 新版组织")
	private List<OpersVO> advanceOperNewOrgList;  //高于默认的权限
	@ApiModelProperty(value = "缺失的基本权限-- 新版组织")
	private List<OpersVO> baseOperNewOrgList;  //缺失的基本权限
	
	@ApiModelProperty(value = "公司名称")
	private String compName;

	public List<OpersVO> getAdvanceOperNewOrgList() {
		return advanceOperNewOrgList;
	}

	public void setAdvanceOperNewOrgList(List<OpersVO> advanceOperNewOrgList) {
		this.advanceOperNewOrgList = advanceOperNewOrgList;
	}

	public List<OpersVO> getBaseOperNewOrgList() {
		return baseOperNewOrgList;
	}

	public void setBaseOperNewOrgList(List<OpersVO> baseOperNewOrgList) {
		this.baseOperNewOrgList = baseOperNewOrgList;
	}

	public Byte getManageLevel() {
		return manageLevel;
	}

	public void setManageLevel(Byte manageLevel) {
		this.manageLevel = manageLevel;
	}

	public String getUserJobDateStr() {
		return userJobDateStr;
	}

	public void setUserJobDateStr(String userJobDateStr) {
		this.userJobDateStr = userJobDateStr;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getUserSexStr() {
		return userSexStr;
	}

	public void setUserSexStr(String userSexStr) {
		this.userSexStr = userSexStr;
	}

	public String getUserArchivePhoto() {
		return userArchivePhoto;
	}

	public void setUserArchivePhoto(String userArchivePhoto) {
		this.userArchivePhoto = userArchivePhoto;
	}

	public List<ErpFunOpers> getAdvanceOperList() {
		return advanceOperList;
	}

	public void setAdvanceOperList(List<ErpFunOpers> advanceOperList) {
		this.advanceOperList = advanceOperList;
	}

	public List<ErpFunOpers> getBaseOperList() {
		return baseOperList;
	}

	public void setBaseOperList(List<ErpFunOpers> baseOperList) {
		this.baseOperList = baseOperList;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public String getRangeIds() {
		return rangeIds;
	}

	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}

	public Byte getFaceRecognitionFlag() {
		return faceRecognitionFlag;
	}

	public void setFaceRecognitionFlag(Byte faceRecognitionFlag) {
		this.faceRecognitionFlag = faceRecognitionFlag;
	}

	public String getUserLastContent() {
		return userLastContent;
	}

	public void setUserLastContent(String userLastContent) {
		this.userLastContent = userLastContent;
	}

	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public Integer getSeqNo() {
		return seqNo;
	}
	
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	
	public Date getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

/*
	public Byte getUsersSex() {
		return usersSex;
	}

	public void setUsersSex(Byte usersSex) {
		this.usersSex = usersSex;
	}
*/

	public String getGraduationTimeStr() {
		return graduationTimeStr;
	}

	public void setGraduationTimeStr(String graduationTimeStr) {
		this.graduationTimeStr = graduationTimeStr;
	}

	public Integer getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(Integer workingYears) {
		this.workingYears = workingYears;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
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

	public Integer getEmployeeDocId() {
		return employeeDocId;
	}

	public void setEmployeeDocId(Integer employeeDocId) {
		this.employeeDocId = employeeDocId;
	}

	public String getChanges() {
		return changes;
	}

	public void setChanges(String changes) {
		this.changes = changes;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getBaseMoney() {
		return baseMoney;
	}
	public void setBaseMoney(Integer baseMoney) {
		this.baseMoney = baseMoney;
	}
	public String getGrName() {
		return grName;
	}
	public void setGrName(String grName) {
		this.grName = grName;
	}

	public String getUserIccode() {
		return userIccode;
	}
	public void setUserIccode(String userIccode) {
		this.userIccode = userIccode;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserBirthdayStr() {
		return userBirthdayStr;
	}
	public void setUserBirthdayStr(String userBirthdayStr) {
		this.userBirthdayStr = userBirthdayStr;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFixedph() {
		return userFixedph;
	}
	public void setUserFixedph(String userFixedph) {
		this.userFixedph = userFixedph;
	}
	public String getUserOfficeph() {
		return userOfficeph;
	}
	public void setUserOfficeph(String userOfficeph) {
		this.userOfficeph = userOfficeph;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPostcode() {
		return userPostcode;
	}
	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}
	public String getUserSchool() {
		return userSchool;
	}
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}
	public String getUserField() {
		return userField;
	}
	public void setUserField(String userField) {
		this.userField = userField;
	}
	public String getUserSchlrecord() {
		return userSchlrecord;
	}
	public void setUserSchlrecord(String userSchlrecord) {
		this.userSchlrecord = userSchlrecord;
	}
	public String getUserForeign() {
		return userForeign;
	}
	public void setUserForeign(String userForeign) {
		this.userForeign = userForeign;
	}
	public String getUserPolity() {
		return userPolity;
	}
	public void setUserPolity(String userPolity) {
		this.userPolity = userPolity;
	}
	public String getProfessionSub() {
		return professionSub;
	}
	public void setProfessionSub(String professionSub) {
		this.professionSub = professionSub;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getIcPhoto1() {
		return icPhoto1;
	}
	public void setIcPhoto1(String icPhoto1) {
		this.icPhoto1 = icPhoto1;
	}
	public String getIcPhoto2() {
		return icPhoto2;
	}
	public void setIcPhoto2(String icPhoto2) {
		this.icPhoto2 = icPhoto2;
	}

	public String getUserPhotoMin() {
		return userPhotoMin;
	}
	public void setUserPhotoMin(String userPhotoMin) {
		this.userPhotoMin = userPhotoMin;
	}
	public String getCardPhoto() {
		return cardPhoto;
	}
	public void setCardPhoto(String cardPhoto) {
		this.cardPhoto = cardPhoto;
	}
	public String getBbsPhoto() {
		return bbsPhoto;
	}
	public void setBbsPhoto(String bbsPhoto) {
		this.bbsPhoto = bbsPhoto;
	}
	public String getShopInnerPhoto() {
		return shopInnerPhoto;
	}
	public void setShopInnerPhoto(String shopInnerPhoto) {
		this.shopInnerPhoto = shopInnerPhoto;
	}
	public String getShopOuterPhoto() {
		return shopOuterPhoto;
	}
	public void setShopOuterPhoto(String shopOuterPhoto) {
		this.shopOuterPhoto = shopOuterPhoto;
	}
	public Integer getUaId() {
		return uaId;
	}
	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}
	public Integer getUserRight() {
		return userRight;
	}
	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}
	public Integer getUserHonest() {
		return userHonest;
	}
	public void setUserHonest(Integer userHonest) {
		this.userHonest = userHonest;
	}
	public Integer getSuperUser() {
		return superUser;
	}
	public void setSuperUser(Integer superUser) {
		this.superUser = superUser;
	}
	public Date getSuperStart() {
		return superStart;
	}
	public void setSuperStart(Date superStart) {
		this.superStart = superStart;
	}
	public Date getSuperEnd() {
		return superEnd;
	}
	public void setSuperEnd(Date superEnd) {
		this.superEnd = superEnd;
	}
	public Integer getSuperDays() {
		return superDays;
	}
	public void setSuperDays(Integer superDays) {
		this.superDays = superDays;
	}
	public Integer getWebstoreStatus() {
		return webstoreStatus;
	}
	public void setWebstoreStatus(Integer webstoreStatus) {
		this.webstoreStatus = webstoreStatus;
	}
	public Integer getUserBidding() {
		return userBidding;
	}
	public void setUserBidding(Integer userBidding) {
		this.userBidding = userBidding;
	}
	public Integer getHouseBidding() {
		return houseBidding;
	}
	public void setHouseBidding(Integer houseBidding) {
		this.houseBidding = houseBidding;
	}
	public Integer getCopyFrom() {
		return copyFrom;
	}
	public void setCopyFrom(Integer copyFrom) {
		this.copyFrom = copyFrom;
	}
	public Date getBuySrvEnd() {
		return buySrvEnd;
	}
	public void setBuySrvEnd(Date buySrvEnd) {
		this.buySrvEnd = buySrvEnd;
	}
	public Integer getFriendFlag() {
		return friendFlag;
	}
	public void setFriendFlag(Integer friendFlag) {
		this.friendFlag = friendFlag;
	}
	public Integer getSellComp() {
		return sellComp;
	}
	public void setSellComp(Integer sellComp) {
		this.sellComp = sellComp;
	}
	public Integer getSellId() {
		return sellId;
	}
	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}

	public Byte getMobileValided() {
		return mobileValided;
	}
	public void setMobileValided(Byte mobileValided) {
		this.mobileValided = mobileValided;
	}
	public BigDecimal getHighAmount() {
		return highAmount;
	}
	public void setHighAmount(BigDecimal highAmount) {
		this.highAmount = highAmount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Byte getValidAccount() {
		return validAccount;
	}
	public void setValidAccount(Byte validAccount) {
		this.validAccount = validAccount;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Byte getRegFrom() {
		return regFrom;
	}
	public void setRegFrom(Byte regFrom) {
		this.regFrom = regFrom;
	}
	public String getServiceZoneIds() {
		return serviceZoneIds;
	}
	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds;
	}
	public Byte getIsDispatcher() {
		return isDispatcher;
	}
	public void setIsDispatcher(Byte isDispatcher) {
		this.isDispatcher = isDispatcher;
	}
	public Integer getUaIdComp() {
		return uaIdComp;
	}
	public void setUaIdComp(Integer uaIdComp) {
		this.uaIdComp = uaIdComp;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getManageUserId() {
		return manageUserId;
	}
	public void setManageUserId(Integer manageUserId) {
		this.manageUserId = manageUserId;
	}
	public Integer getManageArchiveId() {
		return manageArchiveId;
	}
	public void setManageArchiveId(Integer manageArchiveId) {
		this.manageArchiveId = manageArchiveId;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getProcessByName() {
		return processByName;
	}
	public void setProcessByName(String processByName) {
		this.processByName = processByName;
	}
	public String getErpCompName() {
		return erpCompName;
	}
	public void setErpCompName(String erpCompName) {
		this.erpCompName = erpCompName;
	}

	public Integer getCountUsers() {
		return countUsers;
	}

	public void setCountUsers(Integer countUsers) {
		this.countUsers = countUsers;
	}

	public String getIdCardAttachment() {
		return idCardAttachment;
	}

	public void setIdCardAttachment(String idCardAttachment) {
		this.idCardAttachment = idCardAttachment;
	}

	public String getEducationAttachment() {
		return educationAttachment;
	}

	public void setEducationAttachment(String educationAttachment) {
		this.educationAttachment = educationAttachment;
	}

	public String getHonorAttachment() {
		return honorAttachment;
	}

	public void setHonorAttachment(String honorAttachment) {
		this.honorAttachment = honorAttachment;
	}

	public String getArchiveAttachment() {
		return archiveAttachment;
	}

	public void setArchiveAttachment(String archiveAttachment) {
		this.archiveAttachment = archiveAttachment;
	}

	public String getOtherAttachment() {
		return otherAttachment;
	}

	public void setOtherAttachment(String otherAttachment) {
		this.otherAttachment = otherAttachment;
	}

	public String getRoleLevelName() {
		return roleLevelName;
	}

	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
