package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class AdminFunCity implements Serializable {
    /**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "省份ID")
	private Short provinceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市拼音，首字母大写，其它小写（记录用户NO时使用）")
	private String pyCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Short seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "虚拟公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "虚拟公司公司编号")
	private String compNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "虚拟分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开通情况，0=未开发城市 1=开放城市")
	private Boolean cityOn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市区号")
	private String telCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "X坐标")
	private String positionX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "Y坐标")
	private String positionY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "天气编码")
	private String weatherCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "SIMPLE_SUPER，0=不赠送")
	private Short simpleSuper;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "精英版注册赠送服务天数，0=不赠送")
	private Short personalSuper;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "企业版注册赠送服务天数")
	private Short enterpriseSuper;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "赠送截止时间")
	private Date superTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司开库试用天数")
	private Integer tryDays;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "默认认证限制的城市，0=关闭 1=放开")
	private Boolean userRight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "对非付费用户是否进行模块限制，0=限制 1=不限制")
	private Boolean superUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "企业版最大用户数")
	private Byte enterUserNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "专业版最大用户数")
	private Byte proUserNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "未入库的楼盘，ERP用户是否可以直接使用控制。0=不控制 1=控制")
	private Boolean buildingFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "增值服务团购开关，0=关闭 1=放开")
	private Boolean grouponFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "不通过实名认证发帖，0=关闭 1=开放")
	private Boolean bulletFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "非VIP纯精英版用户按城市管理，0=不限制 1=限制 公告：同城交流列表出来，不可浏览及发布信息，不接收同城交流小秘书提醒，其他板块可以查看，但不能发布及回复；好房搜搜：不可进入")
	private Boolean manageFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "SUPER_END、SUPER_TIME字段修改标记，0=未修改(默认) 1=已修改,当修改SUPER_END字段后，存储过程作业于当晚执行将SUPER_END上的剩余时间与SUPER_DAYS字段互换")
	private Boolean updateSuperFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "专供房源数据是否开放，0=未开放 1=开放免费 2=开放收费")
	private Byte vipFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "金融服务开启标记[具体分店控制以城市表上的此字段和公司上的系统参数联合控制]，0=关闭 1=开放")
	private Byte finacFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市级别，1=一线城市 2=三线城市 默认为2    （1=重点 2=非重点）")
	private Byte cityLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源图盘中可以选择楼盘图盘，0=不可选 1=可选 默认为0")
	private Byte selBuildpicFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "FId")
	private Integer fid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "SUBNAME")
	private String subname;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "CITY_SINGLE")
	private Byte citySingle;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "腾讯网站对接开通，0=未开通 1=已开通")
	private Byte qqPublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "好房直供是否绑定金融，0=否 1=是")
	private Byte vipBound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "搜搜查看电话受不受手机APP登录限制，1=要收限制")
	private Integer phoneBound;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源竞价底价")
	private BigDecimal houseBiddingMinPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘竞价底价（包括新盘）")
	private BigDecimal buildBiddingMinPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "C_CITY_NAME")
	private String cCityName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "C_PY_CODE")
	private String cPyCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WEB_FLAG")
	private Integer webFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布到腾讯二手房条数")
	private Integer qqHouseCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "app获取构建wap房源路径")
	private String webDomain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布到腾许二手房条数（未付费用户）")
	private Integer qqHouseCountFree;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘竞价上限（包括新盘）")
	private BigDecimal buildBiddingMaxPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源竞价上限")
	private BigDecimal houseBiddingMaxPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "SOLR控制开关，0=关闭 1=开启")
	private Byte sosoSolrFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店版用户是否全免费，0=否 1=是")
	private Byte enterVip;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市描述")
	private String cityDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "BAIDU_FLAG")
	private Byte baiduFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WF_PRICE_STANDARD_BUY")
	private String wfPriceStandardBuy;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WF_PRICE_STANDARD_RENT")
	private String wfPriceStandardRent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "WF_PRICE_PAY")
	private String wfPricePay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU+开启开关，0=关闭 1=开启")
	private Byte youjiaCityFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte youjiaBuildinfoFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU_SHARE_HOUSEGAINSCORE")
	private Integer youShareHousegainscore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU_BUY_HOUSECOSTSCORE")
	private Integer youBuyHousecostscore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU_COOPERATE_HOUSECOSTSCORE")
	private Integer youCooperateHousecostscore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU_CALL_BUILDFIRSTSCORE")
	private Integer youCallBuildfirstscore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "YOU_SHOW_BUILDPHONESCORE")
	private Integer youShowBuildphonescore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市公盘的楼盘资料开关 0：关闭")
	private Integer youBuildinfoFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String youLogoPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte didiOpenFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date updateSectionTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date updateRegTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String cityShareName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String cityShareShortName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String youjiaHotlineName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String youjiaHotline;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String youjiaAuditPhone;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte appShowYouyou;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物业版分享房源得积分")
	private Integer youPropertyVerHousegainscore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优家房源拨打IP电话是否免费，1=免费")
	private Byte youjiaIpcallFree;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市等级 默认2  1234分别表示1234线城市")
	private Byte cityLevelGrade;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "本城市的优家合同是否需要审核 1:要审核 0:缺省值 不审核")
	private Byte youDealNeedExamine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "IP拨打")
	private String ipCallUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优优好房是否开通维修功能 1:开通、0:未开通-陈文超")
	private Byte repairFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优优好房是否开通装修功能 1:开通、0:未开通-陈文超")
	private Byte fitmentFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市上增加参数控制查看城市公盘数据是否需要走购买逻辑 0=关闭费用  1=开启费用")
	private Byte youjiaDataNeedPay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上")
	private String statisticsPriceSaleOption;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上")
	private String statisticsAreaSaleOption;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上")
	private String statisticsPriceLeaseOption;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上")
	private String statisticsAreaLeaseOption;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当前城市是否开通优优新房功能，1：开通、0：未开通-陈文超")
	private Byte youyouNewHouseFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "平安普惠金融开放城市标记 1:开启、默认:0 - 陈文超")
	private Byte paFinanceFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "网站开启房源编号是否显示标记  0:关闭、1:开启-陈文超添加，由网站部使用")
	private Byte showCaseNoFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否开放新房抵扣券 1:开启、0:关闭")
	private Byte openNewhouseCoupon;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否开启业主房源标记1：开启、0：关闭")
	private Byte openOwnerhouseFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优优WAP推广标记 0=关 1=开")
	private Byte adWapOpenflag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市是否开通公寓系统1开通0不开  B端是否开启，C端不能用这个字段判断")
	private Byte cityApartmentFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市是否开通核验编号1开通0不开")
	private Byte cityCheckCodeflag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市公盘是否开启（需求中心） 1=开启收费版需求中心")
	private Byte cityShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否开启楼盘评估 0=未开启 1=已开启，ERP上的控制")
	private Byte buildAssessFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房掌柜是否开通 1 开通 0 未开通 (房掌柜在ERP上录了数据就可以开通)")
	private Byte fzgFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于优优好房逻辑，即使城市开通了估价，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超")
	private Byte buildAssessIsOpen;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于优优好房逻辑，即使城市开通了公寓，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超")
	private Byte apartmentIsOpen;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于优优好房逻辑，控制是否开放房价评估功能。1:是、0:否，默认:0---------------------陈文超")
	private Byte buildAssessFlag4c;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用于优优好房逻辑，控制是否开放公寓功能。1:是、0:否，默认:0---------------------陈文超")
	private Byte apartmentFlag4c;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否开通开发票开关0=不开 1=开")
	private Byte invoiceFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是省会城市 1 是 0 不是")
	private Byte isCapital;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭")
	private Byte checkSalecheckcodeOnpublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭")
	private Byte checkLeasecheckcodeOnpublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭")
	private Byte checkSaleeffectivedateOnpublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭")
	private Byte checkLeaseeffectivedateOnpublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否展示房管局状态 0代表不展示，1代表展示")
	private Byte showFunmanagerSalestatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "头条新房广告展示概率 80,90这种数字")
	private Byte chance;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "控制保底分层 1开启0关闭")
	private BigDecimal platformFee;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "优家平台管理费")
	private Byte profitBaseproFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1:开启花呗功能、0:关闭花呗功能。代表租赁分期功能是否开放")
	private Byte openHuabei;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发发三和一是否开启，1=已开启")
	private Byte fafaThreeInOne;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte openDyFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer cityLevelVip;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer entrustSale;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer entrustLease;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String youDianLogoPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte openMetro;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte openAliRentHouse;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "正式门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打")
	private Byte rightCallType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "物业门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打")
	private Byte wuyeCallType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer countryId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte entrustHouseInstruction;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal portentialPerformanceCommissionRate;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @mbggenerated 城市ID
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 省份ID
	 */
	public Short getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated 省份ID
	 */
	public void setProvinceId(Short provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @mbggenerated 城市名称
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @mbggenerated 城市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @mbggenerated 城市拼音，首字母大写，其它小写（记录用户NO时使用）
	 */
	public String getPyCode() {
		return pyCode;
	}

	/**
	 * @mbggenerated 城市拼音，首字母大写，其它小写（记录用户NO时使用）
	 */
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	/**
	 * @mbggenerated 序号
	 */
	public Short getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setSeqNo(Short seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 虚拟公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 虚拟公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 虚拟公司公司编号
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated 虚拟公司公司编号
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @mbggenerated 虚拟分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 虚拟分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 开通情况，0=未开发城市 1=开放城市
	 */
	public Boolean getCityOn() {
		return cityOn;
	}

	/**
	 * @mbggenerated 开通情况，0=未开发城市 1=开放城市
	 */
	public void setCityOn(Boolean cityOn) {
		this.cityOn = cityOn;
	}

	/**
	 * @mbggenerated 城市区号
	 */
	public String getTelCode() {
		return telCode;
	}

	/**
	 * @mbggenerated 城市区号
	 */
	public void setTelCode(String telCode) {
		this.telCode = telCode;
	}

	/**
	 * @mbggenerated X坐标
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * @mbggenerated X坐标
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	/**
	 * @mbggenerated Y坐标
	 */
	public String getPositionY() {
		return positionY;
	}

	/**
	 * @mbggenerated Y坐标
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	/**
	 * @mbggenerated 天气编码
	 */
	public String getWeatherCode() {
		return weatherCode;
	}

	/**
	 * @mbggenerated 天气编码
	 */
	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}

	/**
	 * @mbggenerated SIMPLE_SUPER，0=不赠送
	 */
	public Short getSimpleSuper() {
		return simpleSuper;
	}

	/**
	 * @mbggenerated SIMPLE_SUPER，0=不赠送
	 */
	public void setSimpleSuper(Short simpleSuper) {
		this.simpleSuper = simpleSuper;
	}

	/**
	 * @mbggenerated 精英版注册赠送服务天数，0=不赠送
	 */
	public Short getPersonalSuper() {
		return personalSuper;
	}

	/**
	 * @mbggenerated 精英版注册赠送服务天数，0=不赠送
	 */
	public void setPersonalSuper(Short personalSuper) {
		this.personalSuper = personalSuper;
	}

	/**
	 * @mbggenerated 企业版注册赠送服务天数
	 */
	public Short getEnterpriseSuper() {
		return enterpriseSuper;
	}

	/**
	 * @mbggenerated 企业版注册赠送服务天数
	 */
	public void setEnterpriseSuper(Short enterpriseSuper) {
		this.enterpriseSuper = enterpriseSuper;
	}

	/**
	 * @mbggenerated 赠送截止时间
	 */
	public Date getSuperTime() {
		return superTime;
	}

	/**
	 * @mbggenerated 赠送截止时间
	 */
	public void setSuperTime(Date superTime) {
		this.superTime = superTime;
	}

	/**
	 * @mbggenerated 公司开库试用天数
	 */
	public Integer getTryDays() {
		return tryDays;
	}

	/**
	 * @mbggenerated 公司开库试用天数
	 */
	public void setTryDays(Integer tryDays) {
		this.tryDays = tryDays;
	}

	/**
	 * @mbggenerated 默认认证限制的城市，0=关闭 1=放开
	 */
	public Boolean getUserRight() {
		return userRight;
	}

	/**
	 * @mbggenerated 默认认证限制的城市，0=关闭 1=放开
	 */
	public void setUserRight(Boolean userRight) {
		this.userRight = userRight;
	}

	/**
	 * @mbggenerated 对非付费用户是否进行模块限制，0=限制 1=不限制
	 */
	public Boolean getSuperUser() {
		return superUser;
	}

	/**
	 * @mbggenerated 对非付费用户是否进行模块限制，0=限制 1=不限制
	 */
	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}

	/**
	 * @mbggenerated 企业版最大用户数
	 */
	public Byte getEnterUserNum() {
		return enterUserNum;
	}

	/**
	 * @mbggenerated 企业版最大用户数
	 */
	public void setEnterUserNum(Byte enterUserNum) {
		this.enterUserNum = enterUserNum;
	}

	/**
	 * @mbggenerated 专业版最大用户数
	 */
	public Byte getProUserNum() {
		return proUserNum;
	}

	/**
	 * @mbggenerated 专业版最大用户数
	 */
	public void setProUserNum(Byte proUserNum) {
		this.proUserNum = proUserNum;
	}

	/**
	 * @mbggenerated 未入库的楼盘，ERP用户是否可以直接使用控制。0=不控制 1=控制
	 */
	public Boolean getBuildingFlag() {
		return buildingFlag;
	}

	/**
	 * @mbggenerated 未入库的楼盘，ERP用户是否可以直接使用控制。0=不控制 1=控制
	 */
	public void setBuildingFlag(Boolean buildingFlag) {
		this.buildingFlag = buildingFlag;
	}

	/**
	 * @mbggenerated 增值服务团购开关，0=关闭 1=放开
	 */
	public Boolean getGrouponFlag() {
		return grouponFlag;
	}

	/**
	 * @mbggenerated 增值服务团购开关，0=关闭 1=放开
	 */
	public void setGrouponFlag(Boolean grouponFlag) {
		this.grouponFlag = grouponFlag;
	}

	/**
	 * @mbggenerated 不通过实名认证发帖，0=关闭 1=开放
	 */
	public Boolean getBulletFlag() {
		return bulletFlag;
	}

	/**
	 * @mbggenerated 不通过实名认证发帖，0=关闭 1=开放
	 */
	public void setBulletFlag(Boolean bulletFlag) {
		this.bulletFlag = bulletFlag;
	}

	/**
	 * @mbggenerated 非VIP纯精英版用户按城市管理，0=不限制 1=限制 公告：同城交流列表出来，不可浏览及发布信息，不接收同城交流小秘书提醒，其他板块可以查看，但不能发布及回复；好房搜搜：不可进入
	 */
	public Boolean getManageFlag() {
		return manageFlag;
	}

	/**
	 * @mbggenerated 非VIP纯精英版用户按城市管理，0=不限制 1=限制 公告：同城交流列表出来，不可浏览及发布信息，不接收同城交流小秘书提醒，其他板块可以查看，但不能发布及回复；好房搜搜：不可进入
	 */
	public void setManageFlag(Boolean manageFlag) {
		this.manageFlag = manageFlag;
	}

	/**
	 * @mbggenerated SUPER_END、SUPER_TIME字段修改标记，0=未修改(默认) 1=已修改,当修改SUPER_END字段后，存储过程作业于当晚执行将SUPER_END上的剩余时间与SUPER_DAYS字段互换
	 */
	public Boolean getUpdateSuperFlag() {
		return updateSuperFlag;
	}

	/**
	 * @mbggenerated SUPER_END、SUPER_TIME字段修改标记，0=未修改(默认) 1=已修改,当修改SUPER_END字段后，存储过程作业于当晚执行将SUPER_END上的剩余时间与SUPER_DAYS字段互换
	 */
	public void setUpdateSuperFlag(Boolean updateSuperFlag) {
		this.updateSuperFlag = updateSuperFlag;
	}

	/**
	 * @mbggenerated 专供房源数据是否开放，0=未开放 1=开放免费 2=开放收费
	 */
	public Byte getVipFlag() {
		return vipFlag;
	}

	/**
	 * @mbggenerated 专供房源数据是否开放，0=未开放 1=开放免费 2=开放收费
	 */
	public void setVipFlag(Byte vipFlag) {
		this.vipFlag = vipFlag;
	}

	/**
	 * @mbggenerated 金融服务开启标记[具体分店控制以城市表上的此字段和公司上的系统参数联合控制]，0=关闭 1=开放
	 */
	public Byte getFinacFlag() {
		return finacFlag;
	}

	/**
	 * @mbggenerated 金融服务开启标记[具体分店控制以城市表上的此字段和公司上的系统参数联合控制]，0=关闭 1=开放
	 */
	public void setFinacFlag(Byte finacFlag) {
		this.finacFlag = finacFlag;
	}

	/**
	 * @mbggenerated 城市级别，1=一线城市 2=三线城市 默认为2    （1=重点 2=非重点）
	 */
	public Byte getCityLevel() {
		return cityLevel;
	}

	/**
	 * @mbggenerated 城市级别，1=一线城市 2=三线城市 默认为2    （1=重点 2=非重点）
	 */
	public void setCityLevel(Byte cityLevel) {
		this.cityLevel = cityLevel;
	}

	/**
	 * @mbggenerated 房源图盘中可以选择楼盘图盘，0=不可选 1=可选 默认为0
	 */
	public Byte getSelBuildpicFlag() {
		return selBuildpicFlag;
	}

	/**
	 * @mbggenerated 房源图盘中可以选择楼盘图盘，0=不可选 1=可选 默认为0
	 */
	public void setSelBuildpicFlag(Byte selBuildpicFlag) {
		this.selBuildpicFlag = selBuildpicFlag;
	}

	/**
	 * @mbggenerated FId
	 */
	public Integer getFid() {
		return fid;
	}

	/**
	 * @mbggenerated FId
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}

	/**
	 * @mbggenerated SUBNAME
	 */
	public String getSubname() {
		return subname;
	}

	/**
	 * @mbggenerated SUBNAME
	 */
	public void setSubname(String subname) {
		this.subname = subname;
	}

	/**
	 * @mbggenerated CITY_SINGLE
	 */
	public Byte getCitySingle() {
		return citySingle;
	}

	/**
	 * @mbggenerated CITY_SINGLE
	 */
	public void setCitySingle(Byte citySingle) {
		this.citySingle = citySingle;
	}

	/**
	 * @mbggenerated 腾讯网站对接开通，0=未开通 1=已开通
	 */
	public Byte getQqPublish() {
		return qqPublish;
	}

	/**
	 * @mbggenerated 腾讯网站对接开通，0=未开通 1=已开通
	 */
	public void setQqPublish(Byte qqPublish) {
		this.qqPublish = qqPublish;
	}

	/**
	 * @mbggenerated 好房直供是否绑定金融，0=否 1=是
	 */
	public Byte getVipBound() {
		return vipBound;
	}

	/**
	 * @mbggenerated 好房直供是否绑定金融，0=否 1=是
	 */
	public void setVipBound(Byte vipBound) {
		this.vipBound = vipBound;
	}

	/**
	 * @mbggenerated 搜搜查看电话受不受手机APP登录限制，1=要收限制
	 */
	public Integer getPhoneBound() {
		return phoneBound;
	}

	/**
	 * @mbggenerated 搜搜查看电话受不受手机APP登录限制，1=要收限制
	 */
	public void setPhoneBound(Integer phoneBound) {
		this.phoneBound = phoneBound;
	}

	/**
	 * @mbggenerated 房源竞价底价
	 */
	public BigDecimal getHouseBiddingMinPrice() {
		return houseBiddingMinPrice;
	}

	/**
	 * @mbggenerated 房源竞价底价
	 */
	public void setHouseBiddingMinPrice(BigDecimal houseBiddingMinPrice) {
		this.houseBiddingMinPrice = houseBiddingMinPrice;
	}

	/**
	 * @mbggenerated 楼盘竞价底价（包括新盘）
	 */
	public BigDecimal getBuildBiddingMinPrice() {
		return buildBiddingMinPrice;
	}

	/**
	 * @mbggenerated 楼盘竞价底价（包括新盘）
	 */
	public void setBuildBiddingMinPrice(BigDecimal buildBiddingMinPrice) {
		this.buildBiddingMinPrice = buildBiddingMinPrice;
	}

	/**
	 * @mbggenerated C_CITY_NAME
	 */
	public String getcCityName() {
		return cCityName;
	}

	/**
	 * @mbggenerated C_CITY_NAME
	 */
	public void setcCityName(String cCityName) {
		this.cCityName = cCityName;
	}

	/**
	 * @mbggenerated C_PY_CODE
	 */
	public String getcPyCode() {
		return cPyCode;
	}

	/**
	 * @mbggenerated C_PY_CODE
	 */
	public void setcPyCode(String cPyCode) {
		this.cPyCode = cPyCode;
	}

	/**
	 * @mbggenerated WEB_FLAG
	 */
	public Integer getWebFlag() {
		return webFlag;
	}

	/**
	 * @mbggenerated WEB_FLAG
	 */
	public void setWebFlag(Integer webFlag) {
		this.webFlag = webFlag;
	}

	/**
	 * @mbggenerated 发布到腾讯二手房条数
	 */
	public Integer getQqHouseCount() {
		return qqHouseCount;
	}

	/**
	 * @mbggenerated 发布到腾讯二手房条数
	 */
	public void setQqHouseCount(Integer qqHouseCount) {
		this.qqHouseCount = qqHouseCount;
	}

	/**
	 * @mbggenerated app获取构建wap房源路径
	 */
	public String getWebDomain() {
		return webDomain;
	}

	/**
	 * @mbggenerated app获取构建wap房源路径
	 */
	public void setWebDomain(String webDomain) {
		this.webDomain = webDomain;
	}

	/**
	 * @mbggenerated 发布到腾许二手房条数（未付费用户）
	 */
	public Integer getQqHouseCountFree() {
		return qqHouseCountFree;
	}

	/**
	 * @mbggenerated 发布到腾许二手房条数（未付费用户）
	 */
	public void setQqHouseCountFree(Integer qqHouseCountFree) {
		this.qqHouseCountFree = qqHouseCountFree;
	}

	/**
	 * @mbggenerated 楼盘竞价上限（包括新盘）
	 */
	public BigDecimal getBuildBiddingMaxPrice() {
		return buildBiddingMaxPrice;
	}

	/**
	 * @mbggenerated 楼盘竞价上限（包括新盘）
	 */
	public void setBuildBiddingMaxPrice(BigDecimal buildBiddingMaxPrice) {
		this.buildBiddingMaxPrice = buildBiddingMaxPrice;
	}

	/**
	 * @mbggenerated 房源竞价上限
	 */
	public BigDecimal getHouseBiddingMaxPrice() {
		return houseBiddingMaxPrice;
	}

	/**
	 * @mbggenerated 房源竞价上限
	 */
	public void setHouseBiddingMaxPrice(BigDecimal houseBiddingMaxPrice) {
		this.houseBiddingMaxPrice = houseBiddingMaxPrice;
	}

	/**
	 * @mbggenerated SOLR控制开关，0=关闭 1=开启
	 */
	public Byte getSosoSolrFlag() {
		return sosoSolrFlag;
	}

	/**
	 * @mbggenerated SOLR控制开关，0=关闭 1=开启
	 */
	public void setSosoSolrFlag(Byte sosoSolrFlag) {
		this.sosoSolrFlag = sosoSolrFlag;
	}

	/**
	 * @mbggenerated 门店版用户是否全免费，0=否 1=是
	 */
	public Byte getEnterVip() {
		return enterVip;
	}

	/**
	 * @mbggenerated 门店版用户是否全免费，0=否 1=是
	 */
	public void setEnterVip(Byte enterVip) {
		this.enterVip = enterVip;
	}

	/**
	 * @mbggenerated 城市描述
	 */
	public String getCityDesc() {
		return cityDesc;
	}

	/**
	 * @mbggenerated 城市描述
	 */
	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	/**
	 * @mbggenerated BAIDU_FLAG
	 */
	public Byte getBaiduFlag() {
		return baiduFlag;
	}

	/**
	 * @mbggenerated BAIDU_FLAG
	 */
	public void setBaiduFlag(Byte baiduFlag) {
		this.baiduFlag = baiduFlag;
	}

	/**
	 * @mbggenerated WF_PRICE_STANDARD_BUY
	 */
	public String getWfPriceStandardBuy() {
		return wfPriceStandardBuy;
	}

	/**
	 * @mbggenerated WF_PRICE_STANDARD_BUY
	 */
	public void setWfPriceStandardBuy(String wfPriceStandardBuy) {
		this.wfPriceStandardBuy = wfPriceStandardBuy;
	}

	/**
	 * @mbggenerated WF_PRICE_STANDARD_RENT
	 */
	public String getWfPriceStandardRent() {
		return wfPriceStandardRent;
	}

	/**
	 * @mbggenerated WF_PRICE_STANDARD_RENT
	 */
	public void setWfPriceStandardRent(String wfPriceStandardRent) {
		this.wfPriceStandardRent = wfPriceStandardRent;
	}

	/**
	 * @mbggenerated WF_PRICE_PAY
	 */
	public String getWfPricePay() {
		return wfPricePay;
	}

	/**
	 * @mbggenerated WF_PRICE_PAY
	 */
	public void setWfPricePay(String wfPricePay) {
		this.wfPricePay = wfPricePay;
	}

	/**
	 * @mbggenerated YOU+开启开关，0=关闭 1=开启
	 */
	public Byte getYoujiaCityFlag() {
		return youjiaCityFlag;
	}

	/**
	 * @mbggenerated YOU+开启开关，0=关闭 1=开启
	 */
	public void setYoujiaCityFlag(Byte youjiaCityFlag) {
		this.youjiaCityFlag = youjiaCityFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getYoujiaBuildinfoFlag() {
		return youjiaBuildinfoFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYoujiaBuildinfoFlag(Byte youjiaBuildinfoFlag) {
		this.youjiaBuildinfoFlag = youjiaBuildinfoFlag;
	}

	/**
	 * @mbggenerated YOU_SHARE_HOUSEGAINSCORE
	 */
	public Integer getYouShareHousegainscore() {
		return youShareHousegainscore;
	}

	/**
	 * @mbggenerated YOU_SHARE_HOUSEGAINSCORE
	 */
	public void setYouShareHousegainscore(Integer youShareHousegainscore) {
		this.youShareHousegainscore = youShareHousegainscore;
	}

	/**
	 * @mbggenerated YOU_BUY_HOUSECOSTSCORE
	 */
	public Integer getYouBuyHousecostscore() {
		return youBuyHousecostscore;
	}

	/**
	 * @mbggenerated YOU_BUY_HOUSECOSTSCORE
	 */
	public void setYouBuyHousecostscore(Integer youBuyHousecostscore) {
		this.youBuyHousecostscore = youBuyHousecostscore;
	}

	/**
	 * @mbggenerated YOU_COOPERATE_HOUSECOSTSCORE
	 */
	public Integer getYouCooperateHousecostscore() {
		return youCooperateHousecostscore;
	}

	/**
	 * @mbggenerated YOU_COOPERATE_HOUSECOSTSCORE
	 */
	public void setYouCooperateHousecostscore(Integer youCooperateHousecostscore) {
		this.youCooperateHousecostscore = youCooperateHousecostscore;
	}

	/**
	 * @mbggenerated YOU_CALL_BUILDFIRSTSCORE
	 */
	public Integer getYouCallBuildfirstscore() {
		return youCallBuildfirstscore;
	}

	/**
	 * @mbggenerated YOU_CALL_BUILDFIRSTSCORE
	 */
	public void setYouCallBuildfirstscore(Integer youCallBuildfirstscore) {
		this.youCallBuildfirstscore = youCallBuildfirstscore;
	}

	/**
	 * @mbggenerated YOU_SHOW_BUILDPHONESCORE
	 */
	public Integer getYouShowBuildphonescore() {
		return youShowBuildphonescore;
	}

	/**
	 * @mbggenerated YOU_SHOW_BUILDPHONESCORE
	 */
	public void setYouShowBuildphonescore(Integer youShowBuildphonescore) {
		this.youShowBuildphonescore = youShowBuildphonescore;
	}

	/**
	 * @mbggenerated 城市公盘的楼盘资料开关 0：关闭
	 */
	public Integer getYouBuildinfoFlag() {
		return youBuildinfoFlag;
	}

	/**
	 * @mbggenerated 城市公盘的楼盘资料开关 0：关闭
	 */
	public void setYouBuildinfoFlag(Integer youBuildinfoFlag) {
		this.youBuildinfoFlag = youBuildinfoFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public String getYouLogoPath() {
		return youLogoPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYouLogoPath(String youLogoPath) {
		this.youLogoPath = youLogoPath;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getDidiOpenFlag() {
		return didiOpenFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDidiOpenFlag(Byte didiOpenFlag) {
		this.didiOpenFlag = didiOpenFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getUpdateSectionTime() {
		return updateSectionTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateSectionTime(Date updateSectionTime) {
		this.updateSectionTime = updateSectionTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getUpdateRegTime() {
		return updateRegTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateRegTime(Date updateRegTime) {
		this.updateRegTime = updateRegTime;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCityShareName() {
		return cityShareName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityShareName(String cityShareName) {
		this.cityShareName = cityShareName;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCityShareShortName() {
		return cityShareShortName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityShareShortName(String cityShareShortName) {
		this.cityShareShortName = cityShareShortName;
	}

	/**
	 * @mbggenerated -
	 */
	public String getYoujiaHotlineName() {
		return youjiaHotlineName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYoujiaHotlineName(String youjiaHotlineName) {
		this.youjiaHotlineName = youjiaHotlineName;
	}

	/**
	 * @mbggenerated -
	 */
	public String getYoujiaHotline() {
		return youjiaHotline;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYoujiaHotline(String youjiaHotline) {
		this.youjiaHotline = youjiaHotline;
	}

	/**
	 * @mbggenerated -
	 */
	public String getYoujiaAuditPhone() {
		return youjiaAuditPhone;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYoujiaAuditPhone(String youjiaAuditPhone) {
		this.youjiaAuditPhone = youjiaAuditPhone;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getAppShowYouyou() {
		return appShowYouyou;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAppShowYouyou(Byte appShowYouyou) {
		this.appShowYouyou = appShowYouyou;
	}

	/**
	 * @mbggenerated 物业版分享房源得积分
	 */
	public Integer getYouPropertyVerHousegainscore() {
		return youPropertyVerHousegainscore;
	}

	/**
	 * @mbggenerated 物业版分享房源得积分
	 */
	public void setYouPropertyVerHousegainscore(Integer youPropertyVerHousegainscore) {
		this.youPropertyVerHousegainscore = youPropertyVerHousegainscore;
	}

	/**
	 * @mbggenerated 优家房源拨打IP电话是否免费，1=免费
	 */
	public Byte getYoujiaIpcallFree() {
		return youjiaIpcallFree;
	}

	/**
	 * @mbggenerated 优家房源拨打IP电话是否免费，1=免费
	 */
	public void setYoujiaIpcallFree(Byte youjiaIpcallFree) {
		this.youjiaIpcallFree = youjiaIpcallFree;
	}

	/**
	 * @mbggenerated 城市等级 默认2  1234分别表示1234线城市
	 */
	public Byte getCityLevelGrade() {
		return cityLevelGrade;
	}

	/**
	 * @mbggenerated 城市等级 默认2  1234分别表示1234线城市
	 */
	public void setCityLevelGrade(Byte cityLevelGrade) {
		this.cityLevelGrade = cityLevelGrade;
	}

	/**
	 * @mbggenerated 本城市的优家合同是否需要审核 1:要审核 0:缺省值 不审核
	 */
	public Byte getYouDealNeedExamine() {
		return youDealNeedExamine;
	}

	/**
	 * @mbggenerated 本城市的优家合同是否需要审核 1:要审核 0:缺省值 不审核
	 */
	public void setYouDealNeedExamine(Byte youDealNeedExamine) {
		this.youDealNeedExamine = youDealNeedExamine;
	}

	/**
	 * @mbggenerated IP拨打
	 */
	public String getIpCallUrl() {
		return ipCallUrl;
	}

	/**
	 * @mbggenerated IP拨打
	 */
	public void setIpCallUrl(String ipCallUrl) {
		this.ipCallUrl = ipCallUrl;
	}

	/**
	 * @mbggenerated 优优好房是否开通维修功能 1:开通、0:未开通-陈文超
	 */
	public Byte getRepairFlag() {
		return repairFlag;
	}

	/**
	 * @mbggenerated 优优好房是否开通维修功能 1:开通、0:未开通-陈文超
	 */
	public void setRepairFlag(Byte repairFlag) {
		this.repairFlag = repairFlag;
	}

	/**
	 * @mbggenerated 优优好房是否开通装修功能 1:开通、0:未开通-陈文超
	 */
	public Byte getFitmentFlag() {
		return fitmentFlag;
	}

	/**
	 * @mbggenerated 优优好房是否开通装修功能 1:开通、0:未开通-陈文超
	 */
	public void setFitmentFlag(Byte fitmentFlag) {
		this.fitmentFlag = fitmentFlag;
	}

	/**
	 * @mbggenerated 城市上增加参数控制查看城市公盘数据是否需要走购买逻辑 0=关闭费用  1=开启费用
	 */
	public Byte getYoujiaDataNeedPay() {
		return youjiaDataNeedPay;
	}

	/**
	 * @mbggenerated 城市上增加参数控制查看城市公盘数据是否需要走购买逻辑 0=关闭费用  1=开启费用
	 */
	public void setYoujiaDataNeedPay(Byte youjiaDataNeedPay) {
		this.youjiaDataNeedPay = youjiaDataNeedPay;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上
	 */
	public String getStatisticsPriceSaleOption() {
		return statisticsPriceSaleOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上
	 */
	public void setStatisticsPriceSaleOption(String statisticsPriceSaleOption) {
		this.statisticsPriceSaleOption = statisticsPriceSaleOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上
	 */
	public String getStatisticsAreaSaleOption() {
		return statisticsAreaSaleOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上
	 */
	public void setStatisticsAreaSaleOption(String statisticsAreaSaleOption) {
		this.statisticsAreaSaleOption = statisticsAreaSaleOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上
	 */
	public String getStatisticsPriceLeaseOption() {
		return statisticsPriceLeaseOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表价格的分组（50,70,80,90）代表总价：50元以下，50~70元......90元以上
	 */
	public void setStatisticsPriceLeaseOption(String statisticsPriceLeaseOption) {
		this.statisticsPriceLeaseOption = statisticsPriceLeaseOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上
	 */
	public String getStatisticsAreaLeaseOption() {
		return statisticsAreaLeaseOption;
	}

	/**
	 * @mbggenerated 统计分析中成交分析表面积的分组（50,70,80,90）代表面积：50平米以下，50~70平米......90平米以上
	 */
	public void setStatisticsAreaLeaseOption(String statisticsAreaLeaseOption) {
		this.statisticsAreaLeaseOption = statisticsAreaLeaseOption;
	}

	/**
	 * @mbggenerated 当前城市是否开通优优新房功能，1：开通、0：未开通-陈文超
	 */
	public Byte getYouyouNewHouseFlag() {
		return youyouNewHouseFlag;
	}

	/**
	 * @mbggenerated 当前城市是否开通优优新房功能，1：开通、0：未开通-陈文超
	 */
	public void setYouyouNewHouseFlag(Byte youyouNewHouseFlag) {
		this.youyouNewHouseFlag = youyouNewHouseFlag;
	}

	/**
	 * @mbggenerated 平安普惠金融开放城市标记 1:开启、默认:0 - 陈文超
	 */
	public Byte getPaFinanceFlag() {
		return paFinanceFlag;
	}

	/**
	 * @mbggenerated 平安普惠金融开放城市标记 1:开启、默认:0 - 陈文超
	 */
	public void setPaFinanceFlag(Byte paFinanceFlag) {
		this.paFinanceFlag = paFinanceFlag;
	}

	/**
	 * @mbggenerated 网站开启房源编号是否显示标记  0:关闭、1:开启-陈文超添加，由网站部使用
	 */
	public Byte getShowCaseNoFlag() {
		return showCaseNoFlag;
	}

	/**
	 * @mbggenerated 网站开启房源编号是否显示标记  0:关闭、1:开启-陈文超添加，由网站部使用
	 */
	public void setShowCaseNoFlag(Byte showCaseNoFlag) {
		this.showCaseNoFlag = showCaseNoFlag;
	}

	/**
	 * @mbggenerated 是否开放新房抵扣券 1:开启、0:关闭
	 */
	public Byte getOpenNewhouseCoupon() {
		return openNewhouseCoupon;
	}

	/**
	 * @mbggenerated 是否开放新房抵扣券 1:开启、0:关闭
	 */
	public void setOpenNewhouseCoupon(Byte openNewhouseCoupon) {
		this.openNewhouseCoupon = openNewhouseCoupon;
	}

	/**
	 * @mbggenerated 是否开启业主房源标记1：开启、0：关闭
	 */
	public Byte getOpenOwnerhouseFlag() {
		return openOwnerhouseFlag;
	}

	/**
	 * @mbggenerated 是否开启业主房源标记1：开启、0：关闭
	 */
	public void setOpenOwnerhouseFlag(Byte openOwnerhouseFlag) {
		this.openOwnerhouseFlag = openOwnerhouseFlag;
	}

	/**
	 * @mbggenerated 优优WAP推广标记 0=关 1=开
	 */
	public Byte getAdWapOpenflag() {
		return adWapOpenflag;
	}

	/**
	 * @mbggenerated 优优WAP推广标记 0=关 1=开
	 */
	public void setAdWapOpenflag(Byte adWapOpenflag) {
		this.adWapOpenflag = adWapOpenflag;
	}

	/**
	 * @mbggenerated 城市是否开通公寓系统1开通0不开  B端是否开启，C端不能用这个字段判断
	 */
	public Byte getCityApartmentFlag() {
		return cityApartmentFlag;
	}

	/**
	 * @mbggenerated 城市是否开通公寓系统1开通0不开  B端是否开启，C端不能用这个字段判断
	 */
	public void setCityApartmentFlag(Byte cityApartmentFlag) {
		this.cityApartmentFlag = cityApartmentFlag;
	}

	/**
	 * @mbggenerated 城市是否开通核验编号1开通0不开
	 */
	public Byte getCityCheckCodeflag() {
		return cityCheckCodeflag;
	}

	/**
	 * @mbggenerated 城市是否开通核验编号1开通0不开
	 */
	public void setCityCheckCodeflag(Byte cityCheckCodeflag) {
		this.cityCheckCodeflag = cityCheckCodeflag;
	}

	/**
	 * @mbggenerated 城市公盘是否开启（需求中心） 1=开启收费版需求中心
	 */
	public Byte getCityShareFlag() {
		return cityShareFlag;
	}

	/**
	 * @mbggenerated 城市公盘是否开启（需求中心） 1=开启收费版需求中心
	 */
	public void setCityShareFlag(Byte cityShareFlag) {
		this.cityShareFlag = cityShareFlag;
	}

	/**
	 * @mbggenerated 是否开启楼盘评估 0=未开启 1=已开启，ERP上的控制
	 */
	public Byte getBuildAssessFlag() {
		return buildAssessFlag;
	}

	/**
	 * @mbggenerated 是否开启楼盘评估 0=未开启 1=已开启，ERP上的控制
	 */
	public void setBuildAssessFlag(Byte buildAssessFlag) {
		this.buildAssessFlag = buildAssessFlag;
	}

	/**
	 * @mbggenerated 房掌柜是否开通 1 开通 0 未开通 (房掌柜在ERP上录了数据就可以开通)
	 */
	public Byte getFzgFlag() {
		return fzgFlag;
	}

	/**
	 * @mbggenerated 房掌柜是否开通 1 开通 0 未开通 (房掌柜在ERP上录了数据就可以开通)
	 */
	public void setFzgFlag(Byte fzgFlag) {
		this.fzgFlag = fzgFlag;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，即使城市开通了估价，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超
	 */
	public Byte getBuildAssessIsOpen() {
		return buildAssessIsOpen;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，即使城市开通了估价，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超
	 */
	public void setBuildAssessIsOpen(Byte buildAssessIsOpen) {
		this.buildAssessIsOpen = buildAssessIsOpen;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，即使城市开通了公寓，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超
	 */
	public Byte getApartmentIsOpen() {
		return apartmentIsOpen;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，即使城市开通了公寓，但是有可能只是展示并提示功能暂未开通，默认：0:未开通、1:开通---------------------陈文超
	 */
	public void setApartmentIsOpen(Byte apartmentIsOpen) {
		this.apartmentIsOpen = apartmentIsOpen;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，控制是否开放房价评估功能。1:是、0:否，默认:0---------------------陈文超
	 */
	public Byte getBuildAssessFlag4c() {
		return buildAssessFlag4c;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，控制是否开放房价评估功能。1:是、0:否，默认:0---------------------陈文超
	 */
	public void setBuildAssessFlag4c(Byte buildAssessFlag4c) {
		this.buildAssessFlag4c = buildAssessFlag4c;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，控制是否开放公寓功能。1:是、0:否，默认:0---------------------陈文超
	 */
	public Byte getApartmentFlag4c() {
		return apartmentFlag4c;
	}

	/**
	 * @mbggenerated 用于优优好房逻辑，控制是否开放公寓功能。1:是、0:否，默认:0---------------------陈文超
	 */
	public void setApartmentFlag4c(Byte apartmentFlag4c) {
		this.apartmentFlag4c = apartmentFlag4c;
	}

	/**
	 * @mbggenerated 是否开通开发票开关0=不开 1=开
	 */
	public Byte getInvoiceFlag() {
		return invoiceFlag;
	}

	/**
	 * @mbggenerated 是否开通开发票开关0=不开 1=开
	 */
	public void setInvoiceFlag(Byte invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	/**
	 * @mbggenerated 是否是省会城市 1 是 0 不是
	 */
	public Byte getIsCapital() {
		return isCapital;
	}

	/**
	 * @mbggenerated 是否是省会城市 1 是 0 不是
	 */
	public void setIsCapital(Byte isCapital) {
		this.isCapital = isCapital;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public Byte getCheckSalecheckcodeOnpublish() {
		return checkSalecheckcodeOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public void setCheckSalecheckcodeOnpublish(Byte checkSalecheckcodeOnpublish) {
		this.checkSalecheckcodeOnpublish = checkSalecheckcodeOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public Byte getCheckLeasecheckcodeOnpublish() {
		return checkLeasecheckcodeOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在校验编号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public void setCheckLeasecheckcodeOnpublish(Byte checkLeasecheckcodeOnpublish) {
		this.checkLeasecheckcodeOnpublish = checkLeasecheckcodeOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public Byte getCheckSaleeffectivedateOnpublish() {
		return checkSaleeffectivedateOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public void setCheckSaleeffectivedateOnpublish(Byte checkSaleeffectivedateOnpublish) {
		this.checkSaleeffectivedateOnpublish = checkSaleeffectivedateOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public Byte getCheckLeaseeffectivedateOnpublish() {
		return checkLeaseeffectivedateOnpublish;
	}

	/**
	 * @mbggenerated 发布房源时检测是否存在房源有效期号，不存在不可点亮网络推广按钮。1=开通 0=关闭
	 */
	public void setCheckLeaseeffectivedateOnpublish(Byte checkLeaseeffectivedateOnpublish) {
		this.checkLeaseeffectivedateOnpublish = checkLeaseeffectivedateOnpublish;
	}

	/**
	 * @mbggenerated 是否展示房管局状态 0代表不展示，1代表展示
	 */
	public Byte getShowFunmanagerSalestatus() {
		return showFunmanagerSalestatus;
	}

	/**
	 * @mbggenerated 是否展示房管局状态 0代表不展示，1代表展示
	 */
	public void setShowFunmanagerSalestatus(Byte showFunmanagerSalestatus) {
		this.showFunmanagerSalestatus = showFunmanagerSalestatus;
	}

	/**
	 * @mbggenerated 头条新房广告展示概率 80,90这种数字
	 */
	public Byte getChance() {
		return chance;
	}

	/**
	 * @mbggenerated 头条新房广告展示概率 80,90这种数字
	 */
	public void setChance(Byte chance) {
		this.chance = chance;
	}

	/**
	 * @mbggenerated 控制保底分层 1开启0关闭
	 */
	public BigDecimal getPlatformFee() {
		return platformFee;
	}

	/**
	 * @mbggenerated 控制保底分层 1开启0关闭
	 */
	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}

	/**
	 * @mbggenerated 优家平台管理费
	 */
	public Byte getProfitBaseproFlag() {
		return profitBaseproFlag;
	}

	/**
	 * @mbggenerated 优家平台管理费
	 */
	public void setProfitBaseproFlag(Byte profitBaseproFlag) {
		this.profitBaseproFlag = profitBaseproFlag;
	}

	/**
	 * @mbggenerated 1:开启花呗功能、0:关闭花呗功能。代表租赁分期功能是否开放
	 */
	public Byte getOpenHuabei() {
		return openHuabei;
	}

	/**
	 * @mbggenerated 1:开启花呗功能、0:关闭花呗功能。代表租赁分期功能是否开放
	 */
	public void setOpenHuabei(Byte openHuabei) {
		this.openHuabei = openHuabei;
	}

	/**
	 * @mbggenerated 发发三和一是否开启，1=已开启
	 */
	public Byte getFafaThreeInOne() {
		return fafaThreeInOne;
	}

	/**
	 * @mbggenerated 发发三和一是否开启，1=已开启
	 */
	public void setFafaThreeInOne(Byte fafaThreeInOne) {
		this.fafaThreeInOne = fafaThreeInOne;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getOpenDyFlag() {
		return openDyFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOpenDyFlag(Byte openDyFlag) {
		this.openDyFlag = openDyFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCityLevelVip() {
		return cityLevelVip;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityLevelVip(Integer cityLevelVip) {
		this.cityLevelVip = cityLevelVip;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getEntrustSale() {
		return entrustSale;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustSale(Integer entrustSale) {
		this.entrustSale = entrustSale;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getEntrustLease() {
		return entrustLease;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustLease(Integer entrustLease) {
		this.entrustLease = entrustLease;
	}

	/**
	 * @mbggenerated -
	 */
	public String getYouDianLogoPath() {
		return youDianLogoPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setYouDianLogoPath(String youDianLogoPath) {
		this.youDianLogoPath = youDianLogoPath;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getOpenMetro() {
		return openMetro;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOpenMetro(Byte openMetro) {
		this.openMetro = openMetro;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getOpenAliRentHouse() {
		return openAliRentHouse;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOpenAliRentHouse(Byte openAliRentHouse) {
		this.openAliRentHouse = openAliRentHouse;
	}

	/**
	 * @mbggenerated 正式门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打
	 */
	public Byte getRightCallType() {
		return rightCallType;
	}

	/**
	 * @mbggenerated 正式门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打
	 */
	public void setRightCallType(Byte rightCallType) {
		this.rightCallType = rightCallType;
	}

	/**
	 * @mbggenerated 物业门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打
	 */
	public Byte getWuyeCallType() {
		return wuyeCallType;
	}

	/**
	 * @mbggenerated 物业门店拨打方式：1=直接拨打，2=隐号拨打，0=不可拨打
	 */
	public void setWuyeCallType(Byte wuyeCallType) {
		this.wuyeCallType = wuyeCallType;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getEntrustHouseInstruction() {
		return entrustHouseInstruction;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustHouseInstruction(Byte entrustHouseInstruction) {
		this.entrustHouseInstruction = entrustHouseInstruction;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getPortentialPerformanceCommissionRate() {
		return portentialPerformanceCommissionRate;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPortentialPerformanceCommissionRate(BigDecimal portentialPerformanceCommissionRate) {
		this.portentialPerformanceCommissionRate = portentialPerformanceCommissionRate;
	}

	private String youLogoPage;
    
    
    public String getYouLogoPage() {
		return youLogoPage;
	}

	public void setYouLogoPage(String youLogoPage) {
		this.youLogoPage = youLogoPage;
	}

}