package com.myfun.erpWeb.usercenter.session.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("软件登陆接口参数对象")
public class LoginParam extends AbstractEncryParam{

	@ApiModelProperty("设备类型 1:pc 2:移动端")
	private Integer clientType = 1;
	@ApiModelProperty(value = "用户ID", example = "1025444")
	private Integer userId;
	@ApiModelProperty(value = "电脑名称", example = "FWEHWEKRJ21312HJEGG")
	private String pcname;
	@ApiModelProperty(value = "工作台机器ID", example = "1243125423")
	private String pcId;
	@ApiModelProperty(value = "版本", example = "17, 0, 1, 19342")
	private String verson;
	@ApiModelProperty(value = "admin的compId", example = "10001")
	private Integer adminCompId;// admin库公司ID，门店版登录必传
	@ApiModelProperty(value = "路由mac", example = "XS,EW,23,GE,FW")
	private String routemac;
	@ApiModelProperty(value = "密码", example = "asdwr432423grgh4y54654t")
	private String loginPassword;// 密码，必传
	@ApiModelProperty(value = "手机号：精英版必传", example = "18782920347")
	private String userMobile;// 手机号，精英版登录或第三方登录必传
	@ApiModelProperty(value = " 0 明文 1，密文")
	private Integer passwordType = 0;
	@ApiModelProperty(value = "磁盘序列号", example = "312541251412")
	private String pcdiskno;
	@ApiModelProperty(value = "用户类型", example = "1：pro WAN LAN   什么类型的 ")
	private String userType;
	@ApiModelProperty(hidden = true, value = "ip地址")
	private String ipAddr;
	@ApiModelProperty(value = "登录标识ID", example = "3123124")
	private String logsId;
	@ApiModelProperty(value = "本地mac", example = "XS,EW,23,GE,FW")
	private String macAddr;
	//---------------------------------------------------------------------
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer openLogin;
	@ApiModelProperty(hidden = true)
	private Integer archiveId;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "性别")
	private Byte userSex;
	@ApiModelProperty(value = "公司名")
	private String compName;
	@ApiModelProperty(value = "服务区域")
	private String serviceReg;
	@ApiModelProperty(value = "服务商圈，中文名用空格隔开")
	private String serviceZone;
	@ApiModelProperty(value = "服务商圈id，id用空格隔开")
	private String serviceZoneIds;

	// 奇葩参数
	@ApiModelProperty(hidden = true)
	private String siteRootUrl;

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getSiteRootUrl() {
		return siteRootUrl;
	}

	public void setSiteRootUrl(String siteRootUrl) {
		this.siteRootUrl = siteRootUrl;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getServiceReg() {
		return serviceReg;
	}

	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg;
	}

	public String getServiceZone() {
		return serviceZone;
	}

	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}

	public String getServiceZoneIds() {
		return serviceZoneIds;
	}

	public void setServiceZoneIds(String serviceZoneIds) {
		this.serviceZoneIds = serviceZoneIds;
	}

	public Integer getOpenLogin() {
		return openLogin;
	}

	public void setOpenLogin(Integer openLogin) {
		this.openLogin = openLogin;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(Integer passwordType) {
		this.passwordType = passwordType;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public String getVerson() {
		return verson;
	}
	public void setVerson(String verson) {
		this.verson = verson;
	}
	public Integer getAdminCompId() {
		return adminCompId;
	}
	public void setAdminCompId(Integer adminCompId) {
		this.adminCompId = adminCompId;
	}
	public String getMacAddr() {
		return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public String getRoutemac() {
		return routemac;
	}
	public void setRoutemac(String routemac) {
		this.routemac = routemac;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	public String getLogsId() {
		return logsId;
	}
	
	public void setLogsId(String logsId) {
		this.logsId = logsId;
	}
	
	public String getPcdiskno() {
		return pcdiskno;
	}
	
	public void setPcdiskno(String pcdiskno) {
		this.pcdiskno = pcdiskno;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getPcId() {
		return pcId;
	}
	
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
}
