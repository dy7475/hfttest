package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApiModel
public class ErpPerformanceAssessmentCountParam implements EncryParamIfc {

	@ApiModelProperty("统计项的Id")
	private Integer id;
	// 考核月份 自然月
	@ApiModelProperty("考核月份")
	private String assessmentMonth;
	@ApiModelProperty("")
	protected Integer pageOffset; // 1 第几页
	@ApiModelProperty("")
	protected Integer pageRows; // 50 一页多少条
	@ApiModelProperty("公司ID")
	private Integer compId;
	@ApiModelProperty("大区ID")
	private Integer areaId;
	@ApiModelProperty("城市ID")
	private Integer cityId;
	@ApiModelProperty("片区ID")
	private Integer regId;
	@ApiModelProperty("门店ID")
	private Integer deptId;
	@ApiModelProperty("分组ID")
	private Integer grId;
	@ApiModelProperty("用户ID")
	private Integer userId;
	@ApiModelProperty("")
	private Integer checkType;
	@ApiModelProperty("")
	private Integer isExport = 0;
	@ApiModelProperty("角色ID")
	private String roleId;
	@ApiModelProperty("")
	private Integer timeType;
	@ApiModelProperty("")
	private Integer dealStatus;

	// 是否是异常 0正常 1:异常
	@ApiModelProperty("是否异常 0=正常 1=异常")
	private Integer validFlag;
	@ApiModelProperty("")
	private Integer countType;
	@ApiModelProperty("")
	private Integer caseType;

	@ApiModelProperty("")
	private Byte checkBusiness;
	@ApiModelProperty("")
	private Set<Integer> sourceFrom;
	@ApiModelProperty("")
	private Integer archiveId;

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Set<Integer> getSourceFrom() {
		return sourceFrom;
	}

	public void setSourceFrom(Set<Integer> sourceFrom) {
		this.sourceFrom = sourceFrom;
	}

	public Byte getCheckBusiness() {
		return checkBusiness;
	}

	public void setCheckBusiness(Byte checkBusiness) {
		this.checkBusiness = checkBusiness;
	}

	private List<Integer> areaIds = new ArrayList<>();
	private List<Integer> regIds = new ArrayList<>();
	private List<Integer> deptIds = new ArrayList<>();
	private List<Integer> grIds = new ArrayList<>();

	private String detailIds;

	private Integer saleCaseType;
	private Integer leaseCaseType;

	public Integer getSaleCaseType() {
		return saleCaseType;
	}

	public void setSaleCaseType(Integer saleCaseType) {
		this.saleCaseType = saleCaseType;
	}

	public Integer getLeaseCaseType() {
		return leaseCaseType;
	}

	public void setLeaseCaseType(Integer leaseCaseType) {
		this.leaseCaseType = leaseCaseType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetailIds() {
		return detailIds;
	}

	public void setDetailIds(String detailIds) {
		this.detailIds = detailIds;
	}

	public List<Integer> getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(List<Integer> areaIds) {
		this.areaIds = areaIds;
	}

	public List<Integer> getRegIds() {
		return regIds;
	}

	public void setRegIds(List<Integer> regIds) {
		this.regIds = regIds;
	}

	public List<Integer> getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(List<Integer> deptIds) {
		this.deptIds = deptIds;
	}

	public List<Integer> getGrIds() {
		return grIds;
	}

	public void setGrIds(List<Integer> grIds) {
		this.grIds = grIds;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	public Integer getCountType() {
		return countType;
	}

	public void setCountType(Integer countType) {
		this.countType = countType;
	}

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	// 空是全部  1个人 2管理
	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getIsExport() {
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	public boolean isNeedCount() {
		return getPageOffset() == 1;
	}

	public Integer getOffsetNow() {
		return (getPageOffset()-1)*getPageRows();
	}

	public Integer getPageOffset() {
		if(pageOffset == null || pageOffset <= 0){
			return Const.CURRENT_PAGE;
		}
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		if(pageRows == null || pageRows <= 0){
			return Const.PAGE_NUMBER;
		}
		return pageRows;
	}

	public Integer getPageRows(Integer p) {
		if(pageRows == null || pageRows <= 0){
			return p;
		}
		return pageRows;
	}

	public void setPageRows(Integer p) {
		pageRows = p;
	}
}
