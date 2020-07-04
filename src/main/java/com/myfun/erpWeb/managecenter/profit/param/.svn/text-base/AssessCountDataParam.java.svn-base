package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 分销模式的参数
 * @Package com.myfun.erpWeb.managecenter.profit.param 
 * @author 陈文超   
 * @date 2019年8月28日 下午8:46:42
 */
@ApiModel
public class AssessCountDataParam extends AbstractEncryParam {
	
	@ApiModelProperty("查询类型：1按员工、2按团队，默认：1")
    private Byte queryType = 1;
	
	@ApiModelProperty("查询月份，格式：2019-01，默认：当前月份")
    private String monthStr;
	
	@ApiModelProperty("查询范围：2、下级团队、3团队、 当queryType = 2时该值才有用")
	private Byte queryRange = 1;
	
	@ApiModelProperty("员工ID，当queryType = 2时，userId用于查询该员工下的所有队员的数据")
    private Integer userId;

	@ApiModelProperty("用于区分移动端（1）或者PC端的查询（0），移动端专用的角色查询，值：1移动端的查询。默认：0")
	private Integer queryDevice = 0;
	
	@ApiModelProperty("移动端专用的角色查询，如果为空或者不传则查询全公司所有角色的数据")
	private String roleId;
	
	@ApiModelProperty(hidden=true)
	private Integer userLevel;
	
	@ApiModelProperty(hidden=true)
	private Integer compId;
	
	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Byte getQueryType() {
		return queryType;
	}

	public void setQueryType(Byte queryType) {
		this.queryType = queryType;
	}

	public String getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getQueryRange() {
		return queryRange;
	}

	public void setQueryRange(Byte queryRange) {
		this.queryRange = queryRange;
	}

	public Integer getQueryDevice() {
		return queryDevice;
	}

	public void setQueryDevice(Integer queryDevice) {
		this.queryDevice = queryDevice;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
