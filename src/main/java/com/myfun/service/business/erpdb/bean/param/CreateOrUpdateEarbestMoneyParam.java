package com.myfun.service.business.erpdb.bean.param;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class CreateOrUpdateEarbestMoneyParam extends AbstractEncryParam
		implements DaoBaseParam {

	private boolean isFJD = false;

	@ApiModelProperty("票据图片")
	private String billPhoto;
	/**
	 * 
	 *  诚意金ID
	 */
	@ApiModelProperty("诚意金Id")
	private Integer earbestId;

	/**
	 * 
	 *  诚意金收据编号
	 */
	@ApiModelProperty("收据编号")
	private String receiptNo;

	@ApiModelProperty(value = "收据编号", hidden = true)
	private String billCodeNo;

	/**
	 * 
	 *  公司ID
	 */
	private Integer compId;

	/**
	 * 
	 *  门店ID
	 */
	private Integer deptId;

	/**
	 * 
	 *  业绩类型名称
	 */
	@ApiModelProperty("类型：出售1，出租2")
	private String performanceName;

	/**
	 * 
	 *  收款金额
	 */
	@ApiModelProperty("收款金额")
	private Integer receiptMoney;

	/**
	 * 
	 *  收款门店ID
	 */
	@ApiModelProperty(value = "收款门店Id",hidden = true)
	private Integer receiptDeptId;

	/**
	 * 
	 *  收款门店名称
	 */
	private String receiptDeptName;

	/**
	 * 
	 *  收款人ID
	 */
	@ApiModelProperty("收款人Id")
	private Integer receiptUserId;

	/**
	 * 
	 *  收款人姓名
	 */
	private String receiptUserName;

	/**
	 * 
	 *  收款时间
	 */
	private Date receiptTime;

	/**
	 * 
	 *  退款门店ID
	 */
	private Integer refundDeptId;

	/**
	 * 
	 *  退款门店名称
	 */
	private String refundDeptName;

	/**
	 * 
	 *  退款人ID
	 */
	private Integer refundUserId;

	/**
	 * 
	 *  退款人姓名
	 */
	private String refundUserName;

	/**
	 * 
	 *  退款时间
	 */
	private Date refundTime;

	/**
	 * 
	 *  转定金门店ID
	 */
	private Integer depositDeptId;

	/**
	 * 
	 *  转定金门店名称
	 */
	private String depositDeptName;

	/**
	 * 
	 *  转定金人ID
	 */
	private Integer depositUserId;

	/**
	 * 
	 *  转定金人姓名
	 */
	private String depositUserName;

	/**
	 * 
	 *  转定金时间
	 */
	private Date depositTime;

	/**
	 * 
	 *  确认收款门店ID
	 */
	private Integer confirmDeptId;

	/**
	 * 
	 *  确认收款门店名称
	 */
	private String confirmDeptName;

	/**
	 * 
	 *  确认收款用户ID
	 */
	private Integer confirmUserId;

	/**
	 * 
	 *  确认收款人姓名
	 */
	private String confirmUserName;

	/**
	 * 
	 *  确认收款时间
	 */
	private Date confirmTime;

	/**
	 * 
	 *  房源编号
	 */
	@ApiModelProperty("房源编号")
	private String caseNo;

	/**
	 * 
	 *  房源ID
	 */
	@ApiModelProperty("房源Id")
	private Integer caseId;

	@ApiModelProperty(value = "房源类型：1出售，2出租",hidden = true)
	private Integer caseType;

	/**
	 * 
	 *  楼盘ID
	 */
	private Integer buildId;

	/**
	 * 
	 *  楼盘名称
	 */
	@ApiModelProperty(value = "楼盘名",hidden = true)
	private String buildName;

	/**
	 * 
	 *  几房
	 */
	private Byte houseRoom;

	/**
	 * 
	 *  几厅
	 */
	private Byte houseHall;

	/**
	 * 
	 *  几卫
	 */
	private Byte houseWei;

	/**
	 * 
	 *  房屋面积
	 */
	private BigDecimal houseArea;

	/**
	 * 
	 *  客源编号
	 */
	private String custNo;

	/**
	 * 
	 *  客源ID
	 */
	private Integer custId;

	/**
	 * 
	 *  付款客户姓名
	 */
	private String custName;

	/**
	 * 
	 *  客户身份证号码
	 */
	@ApiModelProperty("客户身份证")
	private String custIdcard;

	/**
	 * 
	 *  客户电话号码
	 */
	@ApiModelProperty("客户电话")
	private String custMobile;

	/**
	 * 
	 *  合同ID
	 */
	private Integer dealId;

	/**
	 * 
	 *  合同编号
	 */
	private String dealNo;

	/**
	 * 
	 *  是否删除
	 */
	private Byte isDel;

	/**
	 * 
	 *  诚意金状态 0待确认,1已收,2已退,3转定金
	 */
	private Byte earbestStatus;

	/**
	 * 
	 *  诚意金备注
	 */
	@ApiModelProperty("诚意金备注")
	private String earbestRemark;

	/**
	 * 
	 *  退款说明
	 */
	private String refundExplain;

	/**
	 * 
	 *  创建时间
	 */
	private Date createTime;

	/**
	 * 
	 *  创建人ID
	 */
	private Integer createUser;

	/**
	 * 
	 *  创建人名称
	 */
	private String createUserName;

	/**
	 * 
	 *  更新时间
	 */
	private Date updateTime;
	
	/**
	 * 
	 * 城市id
	 */
	private Integer cityId;
	/**
	 * 
	 * userId
	 */
	private Integer userId;

	@ApiModelProperty("产权地址")
	private String propertyAddress;

	/**
	 * 
	 * userName
	 */
	private Integer billCodeId;
	
	private String userName;
	
	private Integer currentAreaId;
	
	private Integer currentRegId;
	
	private Integer currentDeptId;
	
	private Integer currentGrId;
	
	private Byte billWay;

	private Integer areaId;
	private Integer regId;
	private Integer grId;

	private String paymentType;

	private Byte status;

	private String deptName;

	public boolean isFJD() {
		return isFJD;
	}

	public void setFJD(boolean FJD) {
		isFJD = FJD;
	}

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public String getBillCodeNo() {
		return billCodeNo;
	}

	public void setBillCodeNo(String billCodeNo) {
		this.billCodeNo = billCodeNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Byte getBillWay() {
		return billWay;
	}

	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}

	public Integer getBillCodeId() {
		return billCodeId;
	}

	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}

	public Integer getCurrentAreaId() {
		return currentAreaId;
	}

	public void setCurrentAreaId(Integer currentAreaId) {
		this.currentAreaId = currentAreaId;
	}

	public Integer getCurrentRegId() {
		return currentRegId;
	}

	public void setCurrentRegId(Integer currentRegId) {
		this.currentRegId = currentRegId;
	}

	public Integer getCurrentDeptId() {
		return currentDeptId;
	}

	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}

	public Integer getCurrentGrId() {
		return currentGrId;
	}

	public void setCurrentGrId(Integer currentGrId) {
		this.currentGrId = currentGrId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEarbestId() {
		return earbestId;
	}

	public void setEarbestId(Integer earbestId) {
		this.earbestId = earbestId;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
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

	public String getPerformanceName() {
		return performanceName;
	}

	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}

	public Integer getReceiptMoney() {
		return receiptMoney;
	}

	public void setReceiptMoney(Integer receiptMoney) {
		this.receiptMoney = receiptMoney;
	}

	public Integer getReceiptDeptId() {
		return receiptDeptId;
	}

	public void setReceiptDeptId(Integer receiptDeptId) {
		this.receiptDeptId = receiptDeptId;
	}

	public String getReceiptDeptName() {
		return receiptDeptName;
	}

	public void setReceiptDeptName(String receiptDeptName) {
		this.receiptDeptName = receiptDeptName;
	}

	public Integer getReceiptUserId() {
		return receiptUserId;
	}

	public void setReceiptUserId(Integer receiptUserId) {
		this.receiptUserId = receiptUserId;
	}

	public String getReceiptUserName() {
		return receiptUserName;
	}

	public void setReceiptUserName(String receiptUserName) {
		this.receiptUserName = receiptUserName;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Integer getRefundDeptId() {
		return refundDeptId;
	}

	public void setRefundDeptId(Integer refundDeptId) {
		this.refundDeptId = refundDeptId;
	}

	public String getRefundDeptName() {
		return refundDeptName;
	}

	public void setRefundDeptName(String refundDeptName) {
		this.refundDeptName = refundDeptName;
	}

	public Integer getRefundUserId() {
		return refundUserId;
	}

	public void setRefundUserId(Integer refundUserId) {
		this.refundUserId = refundUserId;
	}

	public String getRefundUserName() {
		return refundUserName;
	}

	public void setRefundUserName(String refundUserName) {
		this.refundUserName = refundUserName;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getDepositDeptId() {
		return depositDeptId;
	}

	public void setDepositDeptId(Integer depositDeptId) {
		this.depositDeptId = depositDeptId;
	}

	public String getDepositDeptName() {
		return depositDeptName;
	}

	public void setDepositDeptName(String depositDeptName) {
		this.depositDeptName = depositDeptName;
	}

	public Integer getDepositUserId() {
		return depositUserId;
	}

	public void setDepositUserId(Integer depositUserId) {
		this.depositUserId = depositUserId;
	}

	public String getDepositUserName() {
		return depositUserName;
	}

	public void setDepositUserName(String depositUserName) {
		this.depositUserName = depositUserName;
	}

	public Date getDepositTime() {
		return depositTime;
	}

	public void setDepositTime(Date depositTime) {
		this.depositTime = depositTime;
	}

	public Integer getConfirmDeptId() {
		return confirmDeptId;
	}

	public void setConfirmDeptId(Integer confirmDeptId) {
		this.confirmDeptId = confirmDeptId;
	}

	public String getConfirmDeptName() {
		return confirmDeptName;
	}

	public void setConfirmDeptName(String confirmDeptName) {
		this.confirmDeptName = confirmDeptName;
	}

	public Integer getConfirmUserId() {
		return confirmUserId;
	}

	public void setConfirmUserId(Integer confirmUserId) {
		this.confirmUserId = confirmUserId;
	}

	public String getConfirmUserName() {
		return confirmUserName;
	}

	public void setConfirmUserName(String confirmUserName) {
		this.confirmUserName = confirmUserName;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Byte getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	public Byte getHouseHall() {
		return houseHall;
	}

	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}

	public Byte getHouseWei() {
		return houseWei;
	}

	public void setHouseWei(Byte houseWei) {
		this.houseWei = houseWei;
	}

	public BigDecimal getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustIdcard() {
		return custIdcard;
	}

	public void setCustIdcard(String custIdcard) {
		this.custIdcard = custIdcard;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Byte getEarbestStatus() {
		return earbestStatus;
	}

	public void setEarbestStatus(Byte earbestStatus) {
		this.earbestStatus = earbestStatus;
	}

	public String getEarbestRemark() {
		return earbestRemark;
	}

	public void setEarbestRemark(String earbestRemark) {
		this.earbestRemark = earbestRemark;
	}

	public String getRefundExplain() {
		return refundExplain;
	}

	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getBillPhoto() {
		return billPhoto;
	}

	public void setBillPhoto(String billPhoto) {
		this.billPhoto = billPhoto;
	}
}
