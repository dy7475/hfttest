package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.math.BigDecimal;

import com.myfun.repository.support.generator.shard.ShardDb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunPrologs extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID，自增")
	private Long id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "MAC地址")
	private String macaddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后登录IP")
	private String logip;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "硬盘序列号")
	private String pcdiskno;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户名称")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "软件登录方式，WAN=漫游登录 LAN=局域网登录")
	private String softver;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录方式，正常登录")
	private String logtype;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录时间")
	private String logtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退出方式，正常退出")
	private String outtype;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "退出时间")
	private String outtime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录标识ID")
	private String logsid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "软件版本号")
	private String verno;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "路由器MAC")
	private String routemac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "工作台机器名")
	private String pcname;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "工作台机器ID")
	private String pcid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备类型：0=电脑ERP、1=安卓、2=IOS、3=fdd安卓登录 4=房多多ios登录")
	private Byte deviceType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "精英版还是门店版 0=门店版 1=精英版 2=开单豹")
	private Byte vernoVersion;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录地址")
	private String loginAddress;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登录异常标记1=是")
	private Byte loginAbnormal;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是新设备 1=是")
	private Byte newDevice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "手机品牌")
	private String mobileBrand;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "维度")
	private BigDecimal lat;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经度")
	private BigDecimal lng;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织综合查询字段 :12001:12002:12003:")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated ID，自增
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @mbggenerated ID，自增
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @mbggenerated MAC地址
	 */
	public String getMacaddr() {
		return macaddr;
	}

	/**
	 * @mbggenerated MAC地址
	 */
	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}

	/**
	 * @mbggenerated 最后登录IP
	 */
	public String getLogip() {
		return logip;
	}

	/**
	 * @mbggenerated 最后登录IP
	 */
	public void setLogip(String logip) {
		this.logip = logip;
	}

	/**
	 * @mbggenerated 硬盘序列号
	 */
	public String getPcdiskno() {
		return pcdiskno;
	}

	/**
	 * @mbggenerated 硬盘序列号
	 */
	public void setPcdiskno(String pcdiskno) {
		this.pcdiskno = pcdiskno;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 用户名称
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 用户名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 软件登录方式，WAN=漫游登录 LAN=局域网登录
	 */
	public String getSoftver() {
		return softver;
	}

	/**
	 * @mbggenerated 软件登录方式，WAN=漫游登录 LAN=局域网登录
	 */
	public void setSoftver(String softver) {
		this.softver = softver;
	}

	/**
	 * @mbggenerated 登录方式，正常登录
	 */
	public String getLogtype() {
		return logtype;
	}

	/**
	 * @mbggenerated 登录方式，正常登录
	 */
	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	/**
	 * @mbggenerated 登录时间
	 */
	public String getLogtime() {
		return logtime;
	}

	/**
	 * @mbggenerated 登录时间
	 */
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	/**
	 * @mbggenerated 退出方式，正常退出
	 */
	public String getOuttype() {
		return outtype;
	}

	/**
	 * @mbggenerated 退出方式，正常退出
	 */
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	/**
	 * @mbggenerated 退出时间
	 */
	public String getOuttime() {
		return outtime;
	}

	/**
	 * @mbggenerated 退出时间
	 */
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	/**
	 * @mbggenerated 登录标识ID
	 */
	public String getLogsid() {
		return logsid;
	}

	/**
	 * @mbggenerated 登录标识ID
	 */
	public void setLogsid(String logsid) {
		this.logsid = logsid;
	}

	/**
	 * @mbggenerated 软件版本号
	 */
	public String getVerno() {
		return verno;
	}

	/**
	 * @mbggenerated 软件版本号
	 */
	public void setVerno(String verno) {
		this.verno = verno;
	}

	/**
	 * @mbggenerated 路由器MAC
	 */
	public String getRoutemac() {
		return routemac;
	}

	/**
	 * @mbggenerated 路由器MAC
	 */
	public void setRoutemac(String routemac) {
		this.routemac = routemac;
	}

	/**
	 * @mbggenerated 工作台机器名
	 */
	public String getPcname() {
		return pcname;
	}

	/**
	 * @mbggenerated 工作台机器名
	 */
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	/**
	 * @mbggenerated 工作台机器ID
	 */
	public String getPcid() {
		return pcid;
	}

	/**
	 * @mbggenerated 工作台机器ID
	 */
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	/**
	 * @mbggenerated 设备类型：0=电脑ERP、1=安卓、2=IOS、3=fdd安卓登录 4=房多多ios登录
	 */
	public Byte getDeviceType() {
		return deviceType;
	}

	/**
	 * @mbggenerated 设备类型：0=电脑ERP、1=安卓、2=IOS、3=fdd安卓登录 4=房多多ios登录
	 */
	public void setDeviceType(Byte deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @mbggenerated 精英版还是门店版 0=门店版 1=精英版 2=开单豹
	 */
	public Byte getVernoVersion() {
		return vernoVersion;
	}

	/**
	 * @mbggenerated 精英版还是门店版 0=门店版 1=精英版 2=开单豹
	 */
	public void setVernoVersion(Byte vernoVersion) {
		this.vernoVersion = vernoVersion;
	}

	/**
	 * @mbggenerated 登录地址
	 */
	public String getLoginAddress() {
		return loginAddress;
	}

	/**
	 * @mbggenerated 登录地址
	 */
	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	/**
	 * @mbggenerated 登录异常标记1=是
	 */
	public Byte getLoginAbnormal() {
		return loginAbnormal;
	}

	/**
	 * @mbggenerated 登录异常标记1=是
	 */
	public void setLoginAbnormal(Byte loginAbnormal) {
		this.loginAbnormal = loginAbnormal;
	}

	/**
	 * @mbggenerated 是否是新设备 1=是
	 */
	public Byte getNewDevice() {
		return newDevice;
	}

	/**
	 * @mbggenerated 是否是新设备 1=是
	 */
	public void setNewDevice(Byte newDevice) {
		this.newDevice = newDevice;
	}

	/**
	 * @mbggenerated 手机品牌
	 */
	public String getMobileBrand() {
		return mobileBrand;
	}

	/**
	 * @mbggenerated 手机品牌
	 */
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	/**
	 * @mbggenerated 维度
	 */
	public BigDecimal getLat() {
		return lat;
	}

	/**
	 * @mbggenerated 维度
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	/**
	 * @mbggenerated 经度
	 */
	public BigDecimal getLng() {
		return lng;
	}

	/**
	 * @mbggenerated 经度
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPrologs() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPrologs(Integer shardCityId, Long id) {
		super(shardCityId);
		this.id = id;
	}

}