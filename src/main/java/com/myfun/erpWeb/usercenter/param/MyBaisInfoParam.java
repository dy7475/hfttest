package com.myfun.erpWeb.usercenter.param;


import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MyBaisInfoParam implements EncryParamIfc {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "档案id", hidden = true)
	private Integer archiveId;
	@ApiModelProperty(value = "城市ID", hidden = true)
	private Integer cityId;
	@ApiModelProperty(value = "社交头像地址")
	private String bbsPhoto;
	@ApiModelProperty(value = "工作头像")
	private String userPhoto;
	@ApiModelProperty(value = "昵称")
	private String nickName;
	@ApiModelProperty(value = "签名")
	private String professionSub;
	@ApiModelProperty(value = "服务区域(id 集合) 逗号隔开")
	private String serviceRegIds;
	@ApiModelProperty(value = "服务片区  (id  集合)  逗号隔开")
	private String serviceZoneids;
	@ApiModelProperty(value = "服务片区 中文名  逗号隔开")
	private String serviceZones;
	@ApiModelProperty(value = "公司名")
	private String compName;
	@ApiModelProperty(value = "服务区域，服务片区的json   格式 :[{regionId:'1',sectionId:'1'},{regionId:'2',sectionId:'7'},{regionId:'2',sectionId:'8'}]")
	private String regAndSecJson;
	@ApiModelProperty(value = "性别 男=1 女=0")
	private Byte userSex;
	@ApiModelProperty(value = "姓名")
	private String userName;
	
	public String getRegAndSecJson() {
		return regAndSecJson;
	}

	public void setRegAndSecJson(String regAndSecJson) {
		this.regAndSecJson = regAndSecJson;
	}

	public String getServiceRegIds() {
		return serviceRegIds;
	}

	public void setServiceRegIds(String serviceRegIds) {
		this.serviceRegIds = serviceRegIds;
	}

	public String getServiceZoneids() {
		return serviceZoneids;
	}

	public void setServiceZoneids(String serviceZoneids) {
		this.serviceZoneids = serviceZoneids;
	}

	public String getServiceZones() {
		return serviceZones;
	}

	public void setServiceZones(String serviceZones) {
		this.serviceZones = serviceZones;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public String getBbsPhoto() {
		return bbsPhoto;
	}

	public void setBbsPhoto(String bbsPhoto) {
		this.bbsPhoto = bbsPhoto;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfessionSub() {
		return professionSub;
	}

	public void setProfessionSub(String professionSub) {
		this.professionSub = professionSub;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
