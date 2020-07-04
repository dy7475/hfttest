package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpKpiStatisticBrokerPerformance extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "身份证号")
	private String idNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "fun_users user_id")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电话")
	private String userMobile;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "新增盘源")
	private Integer houseAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "新增客源")
	private Integer custAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案数量")
	private Integer houseRegistration;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙提交")
	private Integer submitKey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源图片上传")
	private Integer uploadPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "一手踩盘")
	private Integer reviewBuild;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "二手房堪")
	private Integer fangKan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "一手带看")
	private Integer takeLookBuild;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "二手带看")
	private Integer takeLookHouse;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "小号通话")
	private Integer hiddenNumberDial;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进")
	private Integer houseTrack;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "事假")
	private Integer compassionateLeave;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "迟到")
	private Integer late;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "早退")
	private Integer leaveEarly;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "旷工")
	private Integer absenteeism;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤 达标：是1，否0")
	private Integer attendanceUpStd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "形象 达标：是1，否0 ")
	private Integer imageUpStd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人星级牌照 达标：是1，否0")
	private Integer starAgent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人星级牌照编号")
	private String starAgentNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "独家委托")
	private Integer exclusiveCommission;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租单（独立单）")
	private Integer rentBillIndependent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租单（行内合作）")
	private Integer rentBillInnerCooperation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租单（跨行合作）")
	private Integer rentBillOuterCooperation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "买卖单（独立单）")
	private Integer saleBillIndependent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作买卖单（行内）")
	private Integer saleBillInnerCooperation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作买卖单（跨行）")
	private Integer saleBillOuterCooperation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "美联好房有效注册")
	private Integer mlAppRegistration;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "推荐入职(业务员)")
	private Integer recommendBusinessPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "推荐入职（管理岗）")
	private Integer recommendManagePosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "培训考勤（0无迟到早退、1有）")
	private Integer trainingAttendance;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "培训没通过（0完成且通过、1没通过）")
	private Integer trainingFailed;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "触犯红线（0没触犯、1触犯）")
	private Integer violateRedLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "触犯黄线（0没触犯、1触犯）")
	private Integer violateYellowLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "触犯蓝线（0没触犯、1触犯）")
	private Integer violateBlueLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer orgId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal websiteAdd;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated -
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 身份证号
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @mbggenerated 身份证号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated fun_users user_id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated fun_users user_id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 电话
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated 电话
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @mbggenerated 用户姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 新增盘源
	 */
	public Integer getHouseAdd() {
		return houseAdd;
	}

	/**
	 * @mbggenerated 新增盘源
	 */
	public void setHouseAdd(Integer houseAdd) {
		this.houseAdd = houseAdd;
	}

	/**
	 * @mbggenerated 新增客源
	 */
	public Integer getCustAdd() {
		return custAdd;
	}

	/**
	 * @mbggenerated 新增客源
	 */
	public void setCustAdd(Integer custAdd) {
		this.custAdd = custAdd;
	}

	/**
	 * @mbggenerated 备案数量
	 */
	public Integer getHouseRegistration() {
		return houseRegistration;
	}

	/**
	 * @mbggenerated 备案数量
	 */
	public void setHouseRegistration(Integer houseRegistration) {
		this.houseRegistration = houseRegistration;
	}

	/**
	 * @mbggenerated 钥匙提交
	 */
	public Integer getSubmitKey() {
		return submitKey;
	}

	/**
	 * @mbggenerated 钥匙提交
	 */
	public void setSubmitKey(Integer submitKey) {
		this.submitKey = submitKey;
	}

	/**
	 * @mbggenerated 房源图片上传
	 */
	public Integer getUploadPhoto() {
		return uploadPhoto;
	}

	/**
	 * @mbggenerated 房源图片上传
	 */
	public void setUploadPhoto(Integer uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	/**
	 * @mbggenerated 一手踩盘
	 */
	public Integer getReviewBuild() {
		return reviewBuild;
	}

	/**
	 * @mbggenerated 一手踩盘
	 */
	public void setReviewBuild(Integer reviewBuild) {
		this.reviewBuild = reviewBuild;
	}

	/**
	 * @mbggenerated 二手房堪
	 */
	public Integer getFangKan() {
		return fangKan;
	}

	/**
	 * @mbggenerated 二手房堪
	 */
	public void setFangKan(Integer fangKan) {
		this.fangKan = fangKan;
	}

	/**
	 * @mbggenerated 一手带看
	 */
	public Integer getTakeLookBuild() {
		return takeLookBuild;
	}

	/**
	 * @mbggenerated 一手带看
	 */
	public void setTakeLookBuild(Integer takeLookBuild) {
		this.takeLookBuild = takeLookBuild;
	}

	/**
	 * @mbggenerated 二手带看
	 */
	public Integer getTakeLookHouse() {
		return takeLookHouse;
	}

	/**
	 * @mbggenerated 二手带看
	 */
	public void setTakeLookHouse(Integer takeLookHouse) {
		this.takeLookHouse = takeLookHouse;
	}

	/**
	 * @mbggenerated 小号通话
	 */
	public Integer getHiddenNumberDial() {
		return hiddenNumberDial;
	}

	/**
	 * @mbggenerated 小号通话
	 */
	public void setHiddenNumberDial(Integer hiddenNumberDial) {
		this.hiddenNumberDial = hiddenNumberDial;
	}

	/**
	 * @mbggenerated 跟进
	 */
	public Integer getHouseTrack() {
		return houseTrack;
	}

	/**
	 * @mbggenerated 跟进
	 */
	public void setHouseTrack(Integer houseTrack) {
		this.houseTrack = houseTrack;
	}

	/**
	 * @mbggenerated 事假
	 */
	public Integer getCompassionateLeave() {
		return compassionateLeave;
	}

	/**
	 * @mbggenerated 事假
	 */
	public void setCompassionateLeave(Integer compassionateLeave) {
		this.compassionateLeave = compassionateLeave;
	}

	/**
	 * @mbggenerated 迟到
	 */
	public Integer getLate() {
		return late;
	}

	/**
	 * @mbggenerated 迟到
	 */
	public void setLate(Integer late) {
		this.late = late;
	}

	/**
	 * @mbggenerated 早退
	 */
	public Integer getLeaveEarly() {
		return leaveEarly;
	}

	/**
	 * @mbggenerated 早退
	 */
	public void setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly = leaveEarly;
	}

	/**
	 * @mbggenerated 旷工
	 */
	public Integer getAbsenteeism() {
		return absenteeism;
	}

	/**
	 * @mbggenerated 旷工
	 */
	public void setAbsenteeism(Integer absenteeism) {
		this.absenteeism = absenteeism;
	}

	/**
	 * @mbggenerated 考勤 达标：是1，否0
	 */
	public Integer getAttendanceUpStd() {
		return attendanceUpStd;
	}

	/**
	 * @mbggenerated 考勤 达标：是1，否0
	 */
	public void setAttendanceUpStd(Integer attendanceUpStd) {
		this.attendanceUpStd = attendanceUpStd;
	}

	/**
	 * @mbggenerated 形象 达标：是1，否0 
	 */
	public Integer getImageUpStd() {
		return imageUpStd;
	}

	/**
	 * @mbggenerated 形象 达标：是1，否0 
	 */
	public void setImageUpStd(Integer imageUpStd) {
		this.imageUpStd = imageUpStd;
	}

	/**
	 * @mbggenerated 经纪人星级牌照 达标：是1，否0
	 */
	public Integer getStarAgent() {
		return starAgent;
	}

	/**
	 * @mbggenerated 经纪人星级牌照 达标：是1，否0
	 */
	public void setStarAgent(Integer starAgent) {
		this.starAgent = starAgent;
	}

	/**
	 * @mbggenerated 经纪人星级牌照编号
	 */
	public String getStarAgentNo() {
		return starAgentNo;
	}

	/**
	 * @mbggenerated 经纪人星级牌照编号
	 */
	public void setStarAgentNo(String starAgentNo) {
		this.starAgentNo = starAgentNo;
	}

	/**
	 * @mbggenerated 独家委托
	 */
	public Integer getExclusiveCommission() {
		return exclusiveCommission;
	}

	/**
	 * @mbggenerated 独家委托
	 */
	public void setExclusiveCommission(Integer exclusiveCommission) {
		this.exclusiveCommission = exclusiveCommission;
	}

	/**
	 * @mbggenerated 租单（独立单）
	 */
	public Integer getRentBillIndependent() {
		return rentBillIndependent;
	}

	/**
	 * @mbggenerated 租单（独立单）
	 */
	public void setRentBillIndependent(Integer rentBillIndependent) {
		this.rentBillIndependent = rentBillIndependent;
	}

	/**
	 * @mbggenerated 租单（行内合作）
	 */
	public Integer getRentBillInnerCooperation() {
		return rentBillInnerCooperation;
	}

	/**
	 * @mbggenerated 租单（行内合作）
	 */
	public void setRentBillInnerCooperation(Integer rentBillInnerCooperation) {
		this.rentBillInnerCooperation = rentBillInnerCooperation;
	}

	/**
	 * @mbggenerated 租单（跨行合作）
	 */
	public Integer getRentBillOuterCooperation() {
		return rentBillOuterCooperation;
	}

	/**
	 * @mbggenerated 租单（跨行合作）
	 */
	public void setRentBillOuterCooperation(Integer rentBillOuterCooperation) {
		this.rentBillOuterCooperation = rentBillOuterCooperation;
	}

	/**
	 * @mbggenerated 买卖单（独立单）
	 */
	public Integer getSaleBillIndependent() {
		return saleBillIndependent;
	}

	/**
	 * @mbggenerated 买卖单（独立单）
	 */
	public void setSaleBillIndependent(Integer saleBillIndependent) {
		this.saleBillIndependent = saleBillIndependent;
	}

	/**
	 * @mbggenerated 合作买卖单（行内）
	 */
	public Integer getSaleBillInnerCooperation() {
		return saleBillInnerCooperation;
	}

	/**
	 * @mbggenerated 合作买卖单（行内）
	 */
	public void setSaleBillInnerCooperation(Integer saleBillInnerCooperation) {
		this.saleBillInnerCooperation = saleBillInnerCooperation;
	}

	/**
	 * @mbggenerated 合作买卖单（跨行）
	 */
	public Integer getSaleBillOuterCooperation() {
		return saleBillOuterCooperation;
	}

	/**
	 * @mbggenerated 合作买卖单（跨行）
	 */
	public void setSaleBillOuterCooperation(Integer saleBillOuterCooperation) {
		this.saleBillOuterCooperation = saleBillOuterCooperation;
	}

	/**
	 * @mbggenerated 美联好房有效注册
	 */
	public Integer getMlAppRegistration() {
		return mlAppRegistration;
	}

	/**
	 * @mbggenerated 美联好房有效注册
	 */
	public void setMlAppRegistration(Integer mlAppRegistration) {
		this.mlAppRegistration = mlAppRegistration;
	}

	/**
	 * @mbggenerated 推荐入职(业务员)
	 */
	public Integer getRecommendBusinessPosition() {
		return recommendBusinessPosition;
	}

	/**
	 * @mbggenerated 推荐入职(业务员)
	 */
	public void setRecommendBusinessPosition(Integer recommendBusinessPosition) {
		this.recommendBusinessPosition = recommendBusinessPosition;
	}

	/**
	 * @mbggenerated 推荐入职（管理岗）
	 */
	public Integer getRecommendManagePosition() {
		return recommendManagePosition;
	}

	/**
	 * @mbggenerated 推荐入职（管理岗）
	 */
	public void setRecommendManagePosition(Integer recommendManagePosition) {
		this.recommendManagePosition = recommendManagePosition;
	}

	/**
	 * @mbggenerated 培训考勤（0无迟到早退、1有）
	 */
	public Integer getTrainingAttendance() {
		return trainingAttendance;
	}

	/**
	 * @mbggenerated 培训考勤（0无迟到早退、1有）
	 */
	public void setTrainingAttendance(Integer trainingAttendance) {
		this.trainingAttendance = trainingAttendance;
	}

	/**
	 * @mbggenerated 培训没通过（0完成且通过、1没通过）
	 */
	public Integer getTrainingFailed() {
		return trainingFailed;
	}

	/**
	 * @mbggenerated 培训没通过（0完成且通过、1没通过）
	 */
	public void setTrainingFailed(Integer trainingFailed) {
		this.trainingFailed = trainingFailed;
	}

	/**
	 * @mbggenerated 触犯红线（0没触犯、1触犯）
	 */
	public Integer getViolateRedLine() {
		return violateRedLine;
	}

	/**
	 * @mbggenerated 触犯红线（0没触犯、1触犯）
	 */
	public void setViolateRedLine(Integer violateRedLine) {
		this.violateRedLine = violateRedLine;
	}

	/**
	 * @mbggenerated 触犯黄线（0没触犯、1触犯）
	 */
	public Integer getViolateYellowLine() {
		return violateYellowLine;
	}

	/**
	 * @mbggenerated 触犯黄线（0没触犯、1触犯）
	 */
	public void setViolateYellowLine(Integer violateYellowLine) {
		this.violateYellowLine = violateYellowLine;
	}

	/**
	 * @mbggenerated 触犯蓝线（0没触犯、1触犯）
	 */
	public Integer getViolateBlueLine() {
		return violateBlueLine;
	}

	/**
	 * @mbggenerated 触犯蓝线（0没触犯、1触犯）
	 */
	public void setViolateBlueLine(Integer violateBlueLine) {
		this.violateBlueLine = violateBlueLine;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getWebsiteAdd() {
		return websiteAdd;
	}

	/**
	 * @mbggenerated -
	 */
	public void setWebsiteAdd(BigDecimal websiteAdd) {
		this.websiteAdd = websiteAdd;
	}

	/**
	 * @mbggenerated
	 */
	public ErpKpiStatisticBrokerPerformance() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpKpiStatisticBrokerPerformance(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}