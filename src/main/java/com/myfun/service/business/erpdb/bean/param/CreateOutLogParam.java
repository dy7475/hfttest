package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
/**
* @ClassName: CreateOutLogParam 
* @Description: TODO(创建外出登录日志所需要的参数) 
* @author 方李骥
* @date 2016-10-14 下午3:02:03
 */
@ApiModel
public class CreateOutLogParam  implements EncryParamIfc {
	@ApiModelProperty(hidden = true)
	private Integer compId;//业务层需要使用当前用户所在公司
	@ApiModelProperty(hidden = true)
	private Integer cityId;//切库所需要使用的城市ID
	@ApiModelProperty(hidden = true)
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	@ApiModelProperty(hidden = true)
	private Integer currentUserId;//业务层需要使用当前用户Id
	@ApiModelProperty(hidden = true)
	private String userName;//业务层需要使用当前用户名称
	@ApiModelProperty(hidden = true)
	private String currentDeptName;//业务层需要使用当前用户名称
	@ApiModelProperty(hidden = true)
	private Integer currentDeptId;//当前用户所在门店ID
	@NotNull
	@ApiModelProperty("预计返回时间")
	private Integer expectBackTime;//预计返回时间
	@NotBlank
	@ApiModelProperty("外出原由")
	private String outDesc;//外出原由
	public Integer getExpectBackTime() {
		return expectBackTime;
	}
	public void setExpectBackTime(Integer expectBackTime) {
		this.expectBackTime = expectBackTime;
	}
	public String getOutDesc() {
		return outDesc;
	}
	public void setOutDesc(String outDesc) {
		this.outDesc = outDesc;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentDeptName() {
		return currentDeptName;
	}
	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	
	
}
