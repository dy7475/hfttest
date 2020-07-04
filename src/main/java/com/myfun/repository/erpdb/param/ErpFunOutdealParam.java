package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 外成交参数集
 * @author ZangTie
 * @since 2018年7月26日 下午8:33:50
 * Modified XXX ZangTie 2018年7月26日
 */
@ApiModel
public class ErpFunOutdealParam extends AbstractEncryParam{
	@ApiModelProperty(value = "共享圈ID")
	private Integer shareId;// 共享圈ID
	@ApiModelProperty(value = "门店编号")
	private String compNo;// 门店编号
	@ApiModelProperty(value = "时间")
	private String date;// 时间  数字  0~9  10~....
	@ApiModelProperty(value = "开始时间")
	private String startTime;// 开始时间
	@ApiModelProperty(value = "结束时间")
	private String endTime;// 结束时间
	@ApiModelProperty(value = "时间范围")
	private String dateRange;// 时间  例如 2018-07-10~2018-07-26
	@ApiModelProperty(value = "公司ID")
	private Integer compId;// 公司ID
	@ApiModelProperty(value = "公司ID集合")
	private Integer[] compIds;// 公司ID集合
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;// 门店ID
	@ApiModelProperty(value = "片区ID")
	private Integer regId;// 片区ID
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;// 大区ID
	@ApiModelProperty(value = "合同的状态")
	private Integer dealStatus;// 合同的状态
	@ApiModelProperty(value = "合同的类型")
	private Integer dealType;// 合同的类型
	@ApiModelProperty(value = "合同创建人")
	private Integer userId;// 合同创建人
	private Integer shareCompId;
	private List<Integer> shareCompIds;

	public Integer getShareCompId() {
		return shareCompId;
	}

	public void setShareCompId(Integer shareCompId) {
		this.shareCompId = shareCompId;
	}

	public List<Integer> getShareCompIds() {
		return shareCompIds;
	}

	public void setShareCompIds(List<Integer> shareCompIds) {
		this.shareCompIds = shareCompIds;
	}

	public Integer getDealStatus() {
	
		return dealStatus;
	}
	public void setDealStatus(Integer dealStatus) {
	
		this.dealStatus = dealStatus;
	}
	public Integer getDealType() {
	
		return dealType;
	}
	public void setDealType(Integer dealType) {
	
		this.dealType = dealType;
	}
	public Integer getUserId() {
	
		return userId;
	}
	public void setUserId(Integer userId) {
	
		this.userId = userId;
	}
	public Integer getDeptId() {
	
		return deptId;
	}
	public void setDeptId(Integer deptId) {
	
		this.deptId = deptId;
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
	public Integer[] getCompIds() {
	
		return compIds;
	}
	public void setCompIds(Integer[] compIds) {
	
		this.compIds = compIds;
	}
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getShareId() {
	
		return shareId;
	}
	public void setShareId(Integer shareId) {
	
		this.shareId = shareId;
	}
	public String getCompNo() {
	
		return compNo;
	}
	public void setCompNo(String compNo) {
	
		this.compNo = compNo;
	}
	public String getDate() {
	
		return date;
	}
	public void setDate(String date) {
	
		this.date = date;
	}
	
}
