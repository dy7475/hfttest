package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ErpFunComp extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID 单序列，自增序列SEQ_FUN_COMP_COMP_ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司编号")
	private String compNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "市(县)ID")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司名称")
	private String compName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司简称")
	private String compCname;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司地址")
	private String compAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "联系电话")
	private String compTele;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "联系人")
	private String compContact;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司描述")
	private String compDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执照编号")
	private String commercialNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "资质编号")
	private String aptitudeNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "安装密码")
	private String installPwd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "明文密码")
	private String plaintPwd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "自定义LOG地址")
	private String customLog;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "注册开关（默认为0），0=允许注册1=禁止注册")
	private Boolean registFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "企业类型，1=企业版2=专业版3=赢销版0=城市 4=新赢销版 5=物业版 6=单店版")
	private Byte compType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "策略参数开关，1=开启；0=关闭")
	private Boolean plotSwitch;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司自定义水印图片")
	private String waterimg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "水印配置，位置,透明度,位置={1:左上,2:右上,3:右下,4:左下,5:居中}透明度=[1-100]。例如：5,100")
	private String waterConfig;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String storeNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新者")
	private Integer updateUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最后更新时间")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "品牌ID")
	private Integer brandId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区是否开启，0=关闭{default}1=开启")
	private Byte areaFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总经理档案id")
	private Integer generalArchive;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String logoPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源总和")
	private Integer houseAddNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总部头名称")
	private String headName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务部门头名称")
	private String businessName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte statisticsFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司是否开启加盟模式 0=没有开启 1=开启")
	private Byte openPartner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务分开管控")
	private Byte businessApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主公司=1、子公司=2")
	private Byte mainComp;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 公司ID 单序列，自增序列SEQ_FUN_COMP_COMP_ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID 单序列，自增序列SEQ_FUN_COMP_COMP_ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 公司编号
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated 公司编号
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @mbggenerated 市(县)ID
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 市(县)ID
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 公司名称
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * @mbggenerated 公司名称
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * @mbggenerated 公司简称
	 */
	public String getCompCname() {
		return compCname;
	}

	/**
	 * @mbggenerated 公司简称
	 */
	public void setCompCname(String compCname) {
		this.compCname = compCname;
	}

	/**
	 * @mbggenerated 公司地址
	 */
	public String getCompAddr() {
		return compAddr;
	}

	/**
	 * @mbggenerated 公司地址
	 */
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public String getCompTele() {
		return compTele;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public void setCompTele(String compTele) {
		this.compTele = compTele;
	}

	/**
	 * @mbggenerated 联系人
	 */
	public String getCompContact() {
		return compContact;
	}

	/**
	 * @mbggenerated 联系人
	 */
	public void setCompContact(String compContact) {
		this.compContact = compContact;
	}

	/**
	 * @mbggenerated 公司描述
	 */
	public String getCompDesc() {
		return compDesc;
	}

	/**
	 * @mbggenerated 公司描述
	 */
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	/**
	 * @mbggenerated 执照编号
	 */
	public String getCommercialNo() {
		return commercialNo;
	}

	/**
	 * @mbggenerated 执照编号
	 */
	public void setCommercialNo(String commercialNo) {
		this.commercialNo = commercialNo;
	}

	/**
	 * @mbggenerated 资质编号
	 */
	public String getAptitudeNo() {
		return aptitudeNo;
	}

	/**
	 * @mbggenerated 资质编号
	 */
	public void setAptitudeNo(String aptitudeNo) {
		this.aptitudeNo = aptitudeNo;
	}

	/**
	 * @mbggenerated 安装密码
	 */
	public String getInstallPwd() {
		return installPwd;
	}

	/**
	 * @mbggenerated 安装密码
	 */
	public void setInstallPwd(String installPwd) {
		this.installPwd = installPwd;
	}

	/**
	 * @mbggenerated 明文密码
	 */
	public String getPlaintPwd() {
		return plaintPwd;
	}

	/**
	 * @mbggenerated 明文密码
	 */
	public void setPlaintPwd(String plaintPwd) {
		this.plaintPwd = plaintPwd;
	}

	/**
	 * @mbggenerated 自定义LOG地址
	 */
	public String getCustomLog() {
		return customLog;
	}

	/**
	 * @mbggenerated 自定义LOG地址
	 */
	public void setCustomLog(String customLog) {
		this.customLog = customLog;
	}

	/**
	 * @mbggenerated 注册开关（默认为0），0=允许注册1=禁止注册
	 */
	public Boolean getRegistFlag() {
		return registFlag;
	}

	/**
	 * @mbggenerated 注册开关（默认为0），0=允许注册1=禁止注册
	 */
	public void setRegistFlag(Boolean registFlag) {
		this.registFlag = registFlag;
	}

	/**
	 * @mbggenerated 企业类型，1=企业版2=专业版3=赢销版0=城市 4=新赢销版 5=物业版 6=单店版
	 */
	public Byte getCompType() {
		return compType;
	}

	/**
	 * @mbggenerated 企业类型，1=企业版2=专业版3=赢销版0=城市 4=新赢销版 5=物业版 6=单店版
	 */
	public void setCompType(Byte compType) {
		this.compType = compType;
	}

	/**
	 * @mbggenerated 策略参数开关，1=开启；0=关闭
	 */
	public Boolean getPlotSwitch() {
		return plotSwitch;
	}

	/**
	 * @mbggenerated 策略参数开关，1=开启；0=关闭
	 */
	public void setPlotSwitch(Boolean plotSwitch) {
		this.plotSwitch = plotSwitch;
	}

	/**
	 * @mbggenerated 公司自定义水印图片
	 */
	public String getWaterimg() {
		return waterimg;
	}

	/**
	 * @mbggenerated 公司自定义水印图片
	 */
	public void setWaterimg(String waterimg) {
		this.waterimg = waterimg;
	}

	/**
	 * @mbggenerated 水印配置，位置,透明度,位置={1:左上,2:右上,3:右下,4:左下,5:居中}透明度=[1-100]。例如：5,100
	 */
	public String getWaterConfig() {
		return waterConfig;
	}

	/**
	 * @mbggenerated 水印配置，位置,透明度,位置={1:左上,2:右上,3:右下,4:左下,5:居中}透明度=[1-100]。例如：5,100
	 */
	public void setWaterConfig(String waterConfig) {
		this.waterConfig = waterConfig;
	}

	/**
	 * @mbggenerated -
	 */
	public String getStoreNo() {
		return storeNo;
	}

	/**
	 * @mbggenerated -
	 */
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	/**
	 * @mbggenerated 最后更新者
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 * @mbggenerated 最后更新者
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 最后更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 品牌ID
	 */
	public Integer getBrandId() {
		return brandId;
	}

	/**
	 * @mbggenerated 品牌ID
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * @mbggenerated 大区是否开启，0=关闭{default}1=开启
	 */
	public Byte getAreaFlag() {
		return areaFlag;
	}

	/**
	 * @mbggenerated 大区是否开启，0=关闭{default}1=开启
	 */
	public void setAreaFlag(Byte areaFlag) {
		this.areaFlag = areaFlag;
	}

	/**
	 * @mbggenerated 总经理档案id
	 */
	public Integer getGeneralArchive() {
		return generalArchive;
	}

	/**
	 * @mbggenerated 总经理档案id
	 */
	public void setGeneralArchive(Integer generalArchive) {
		this.generalArchive = generalArchive;
	}

	/**
	 * @mbggenerated -
	 */
	public String getLogoPath() {
		return logoPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	/**
	 * @mbggenerated 房源总和
	 */
	public Integer getHouseAddNo() {
		return houseAddNo;
	}

	/**
	 * @mbggenerated 房源总和
	 */
	public void setHouseAddNo(Integer houseAddNo) {
		this.houseAddNo = houseAddNo;
	}

	/**
	 * @mbggenerated 总部头名称
	 */
	public String getHeadName() {
		return headName;
	}

	/**
	 * @mbggenerated 总部头名称
	 */
	public void setHeadName(String headName) {
		this.headName = headName;
	}

	/**
	 * @mbggenerated 业务部门头名称
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @mbggenerated 业务部门头名称
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getStatisticsFlag() {
		return statisticsFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setStatisticsFlag(Byte statisticsFlag) {
		this.statisticsFlag = statisticsFlag;
	}

	/**
	 * @mbggenerated 公司是否开启加盟模式 0=没有开启 1=开启
	 */
	public Byte getOpenPartner() {
		return openPartner;
	}

	/**
	 * @mbggenerated 公司是否开启加盟模式 0=没有开启 1=开启
	 */
	public void setOpenPartner(Byte openPartner) {
		this.openPartner = openPartner;
	}

	/**
	 * @mbggenerated 业务分开管控
	 */
	public Byte getBusinessApart() {
		return businessApart;
	}

	/**
	 * @mbggenerated 业务分开管控
	 */
	public void setBusinessApart(Byte businessApart) {
		this.businessApart = businessApart;
	}

	/**
	 * @mbggenerated 主公司=1、子公司=2
	 */
	public Byte getMainComp() {
		return mainComp;
	}

	/**
	 * @mbggenerated 主公司=1、子公司=2
	 */
	public void setMainComp(Byte mainComp) {
		this.mainComp = mainComp;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunComp() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunComp(Integer shardCityId, Integer compId) {
		super(shardCityId);
		this.compId = compId;
	}
}