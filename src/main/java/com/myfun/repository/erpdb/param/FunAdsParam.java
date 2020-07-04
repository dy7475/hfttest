package com.myfun.repository.erpdb.param;

import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FunAdsParam extends AbstractEncryParam implements DaoBaseParam {
	@ApiModelProperty("房源ID")
	private Integer caseId;//房源ID
	@ApiModelProperty("房源类型")
	private Integer caseType;//房源类型
	@ApiModelProperty("操作人")
	private Integer userId;//操作人
	@ApiModelProperty("操作人的公司ID")
	private Integer compId;//操作人的公司ID
	@ApiModelProperty("操作人门店")
	private Integer deptId;//操作人门店
	@ApiModelProperty("广告语")
	private String adsContent;//广告语
	@ApiModelProperty("创建时间")
	private Date creationTime;//创建时间
	@ApiModelProperty("状态  0=撤销 1=点亮")
	private Integer adsStatus;//状态  0：撤销 1：点亮
	@ApiModelProperty("创建时间")
	private Date cancleTime;//创建时间
	@ApiModelProperty("房源编号")
	private String caseNo;//房源编号
	@ApiModelProperty("推荐价")
	private String recommendPrice;//推荐价
	@ApiModelProperty("价格单位")
	private String priceUnit;//价格单位
	@ApiModelProperty("操作门店名")
	private String deptName;//操作门店名
	@ApiModelProperty("操作人姓名")
	private String userName;//操作人姓名
	@ApiModelProperty("广告房源id组合")
	private String adsContentIds;//广告房源id组合
	@ApiModelProperty("开始时间")
	private String date1;//开始时间
	@ApiModelProperty("结束时间")
	private String date2;//结束时间
	@ApiModelProperty("房源所属BELONG_USER 操作人OPERATE_USER")
	private String operateType;//房源所属BELONG_USER 操作人OPERATE_USER
	@ApiModelProperty("见报手机号")
    private String newspapperTel;//见报手机号

    public String getNewspapperTel() {
        return newspapperTel;
    }

    public void setNewspapperTel(String newspapperTel) {
        this.newspapperTel = newspapperTel;
    }

	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getAdsContentIds() {
		return adsContentIds;
	}
	public void setAdsContentIds(String adsContentIds) {
		this.adsContentIds = adsContentIds;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getAdsContent() {
		return adsContent;
	}
	public void setAdsContent(String adsContent) {
		this.adsContent = adsContent;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getAdsStatus() {
		return adsStatus;
	}
	public void setAdsStatus(Integer adsStatus) {
		this.adsStatus = adsStatus;
	}
	public Date getCancleTime() {
		return cancleTime;
	}
	public void setCancleTime(Date cancleTime) {
		this.cancleTime = cancleTime;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getRecommendPrice() {
		return recommendPrice;
	}
	public void setRecommendPrice(String recommendPrice) {
		this.recommendPrice = recommendPrice;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	
	
}
