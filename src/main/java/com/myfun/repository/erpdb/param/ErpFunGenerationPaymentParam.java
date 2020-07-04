package com.myfun.repository.erpdb.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.erpdb.po.ErpFunGenerationPayment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Set;

/**
 * @Title
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/
@ApiModel(description = "代扣款列表请求参数")
public class ErpFunGenerationPaymentParam extends ErpFunGenerationPayment implements EncryParamIfc {
    @ApiModelProperty("开始时间")
	private String startTime;
	@ApiModelProperty("结束时间")
	private String endTime;
	@ApiModelProperty("开始日期")
	private Date startTimeDate;
	@ApiModelProperty("结束日期")
	private Date endTimeDate;
	@ApiModelProperty("日期类型")
	private Integer timeType;
	@ApiModelProperty("页码")
	private Integer pageOffset;
	@ApiModelProperty("每页数量")
	private Integer pageRows;
	@ApiModelProperty("")
	private String ids;
	@ApiModelProperty("用户ids")
	private String userIds;
	@ApiModelProperty("")
	private Set<Integer> userIdList;
	@ApiModelProperty("用户的角色ID")
	private String userPosition;
	@ApiModelProperty("维度")
	private String dimension;
	@ApiModelProperty("")
	private String generationPaymentListJson;

	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean newOrganization;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;

	@ApiModelProperty(value = "组织定义id")
	private Integer defId;
	@ApiModelProperty(hidden = true, value = "某个ORG_?")
	private String mappingDbField;
	@ApiModelProperty(hidden = true, value = "group字段")
	private String groupColumn;
	@ApiModelProperty(hidden = true, value = "")
	private Integer serchRangeId;
	@ApiModelProperty(hidden = true, value = "")
	private String rangeColumn;
	@ApiModelProperty(hidden = true, value = "")
	private String selectColumnStr;
	
	
	public Integer getSerchRangeId() {
	
		return serchRangeId;
	}

	public void setSerchRangeId(Integer serchRangeId) {
	
		this.serchRangeId = serchRangeId;
	}

	public String getRangeColumn() {
	
		return rangeColumn;
	}

	public void setRangeColumn(String rangeColumn) {
	
		this.rangeColumn = rangeColumn;
	}

	public String getSelectColumnStr() {
	
		return selectColumnStr;
	}

	public void setSelectColumnStr(String selectColumnStr) {
	
		this.selectColumnStr = selectColumnStr;
	}

	public Boolean getNewOrganization() {
	
		return newOrganization;
	}

	public void setNewOrganization(Boolean newOrganization) {
	
		this.newOrganization = newOrganization;
	}

	public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}

	public Integer getDefId() {
	
		return defId;
	}

	public void setDefId(Integer defId) {
	
		this.defId = defId;
	}

	public String getMappingDbField() {
	
		return mappingDbField;
	}

	public void setMappingDbField(String mappingDbField) {
	
		this.mappingDbField = mappingDbField;
	}

	public String getGroupColumn() {
	
		return groupColumn;
	}

	public void setGroupColumn(String groupColumn) {
	
		this.groupColumn = groupColumn;
	}

	public String getGenerationPaymentListJson() {
		return generationPaymentListJson;
	}

	public void setGenerationPaymentListJson(String generationPaymentListJson) {
		this.generationPaymentListJson = generationPaymentListJson;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Set<Integer> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(Set<Integer> userIdList) {
		this.userIdList = userIdList;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private String occMonth;
	private Integer isExport = 0;

	public Date getStartTimeDate() {
		return startTimeDate;
	}

	public void setStartTimeDate(Date startTimeDate) {
		this.startTimeDate = startTimeDate;
	}

	public Date getEndTimeDate() {
		return endTimeDate;
	}

	public void setEndTimeDate(Date endTimeDate) {
		this.endTimeDate = endTimeDate;
	}

	public Integer getIsExport() {
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public String getOccMonth() {
		return occMonth;
	}

	public void setOccMonth(String occMonth) {
		this.occMonth = occMonth;
	}

	public boolean isNeedCount() {
		return getPageOffset() == 1;
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

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}
