package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
import java.util.Map;

@ApiModel
public class FloorDataParam  implements EncryParamIfc {

	@ApiModelProperty("楼盘ID")
	private Integer buildId;//楼盘ID
	@ApiModelProperty("栋")
	private String roof;//栋
	@ApiModelProperty("单元")
	private String unit;//单元
	@ApiModelProperty("房号")
	private String house;//房号
	@ApiModelProperty("联系电话")
	private String cellPhone;//联系电话
	@ApiModelProperty("/楼")
	private String num;//楼
	@ApiModelProperty("查询类型")
	private String queryType;//查询类型
	@ApiModelProperty("页码")
	private  Integer pageOffset = 1; // 1 第几页
	@ApiModelProperty("每页显示数量")
	private  Integer pageRows = 50; // 50 一页多少条

    @ApiModelProperty(hidden = true)
	private String roofLike;
    @ApiModelProperty(hidden = true)
	private List<Map<String,Object>> personalList;
    @ApiModelProperty(hidden = true)
	private Integer compId;
    @ApiModelProperty(hidden = true)
	private Integer userId;
    @ApiModelProperty(hidden = true)
	private Date nowTime;

	public String getRoofLike() {
		return roofLike;
	}

	public void setRoofLike(String roofLike) {
		this.roofLike = roofLike;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public List<Map<String, Object>> getPersonalList() {
		return personalList;
	}

	public void setPersonalList(List<Map<String, Object>> personalList) {
		this.personalList = personalList;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public Integer getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		return pageRows;
	}

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}
}
