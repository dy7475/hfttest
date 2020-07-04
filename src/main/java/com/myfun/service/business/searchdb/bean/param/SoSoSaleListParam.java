package com.myfun.service.business.searchdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SoSoSaleListParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "区域Id")
	private String regionIds;// 区域Id
	@ApiModelProperty(value = "商圈Id")
	private String sectionIds;// 商圈Id
	@ApiModelProperty(value = "区域")
	private String region;// 区域
	@ApiModelProperty(value = "商圈")
	private String section;// 商圈
	@ApiModelProperty(value = "户型1")
	private String room1;// 户型1
	@ApiModelProperty(value = "户型2")
	private String room2;// 户型2
	@ApiModelProperty(value = "用途")
	private String useage;// 用途
	@ApiModelProperty(value = "面积1")
	private String area1;// 面积1
	@ApiModelProperty(value = "面积2")
	private String area2;// 面积2
	@ApiModelProperty(value = "价格1")
	private String price1;// 价格1
	@ApiModelProperty(value = "价格2")
	private String price2;// 价格2
	@ApiModelProperty(value = "日期查询条件范围")
	private String time;// 日期查询条件范围 * 0-全部* 1-一天 * 2-一周 * 3-一月* 4-一季 * 5-半年 * 6-半年前 * 7-一年 * 8-一年前 * 9-两年前
	@ApiModelProperty(value = "关键词")
	private String keywords;// 关键词
	// 以下是查询时使用参数
	@ApiModelProperty(value = "所在省市")
	private Integer provinceId;// 所在省市
	@ApiModelProperty(value = "城市id")
	private Integer cityId;// 城市id
	@ApiModelProperty(value = "开始时间")
	private String time1;// 开始时间
	@ApiModelProperty(value = "结束时间")
	private String time2;// 结束时间
	@ApiModelProperty(value = "档案id")
	private Integer archiveId;// 档案id
	@ApiModelProperty(value = "table名")
	private String tbName;// table名
	@ApiModelProperty(value = "详细信息表名")
	private String tbNameDetail;// 详细信息表名
	@ApiModelProperty(value = "区域列表")
	private String[] regions;// 区域列表
	@ApiModelProperty(value = "商圈列表")
	private String[] sectionArr;// 商圈列表
	@ApiModelProperty(value = "区域Id列表")
	private String[] regionIdArr;// 区域Id列表
	@ApiModelProperty(value = "商铺类型")
	private String shoptype;// 商铺类型
	@ApiModelProperty(value = "过滤房源1是过滤")
	private String filterFlag;//过滤房源1是过滤
	@ApiModelProperty(value = "虚假")
	private String fakeHouseFlag;//虚假
	@ApiModelProperty(value = "中介")
	private String intermediaryHouseFlag;//中介
	public String getSectionIds() {
		return sectionIds;
	}
	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}
	public String getFakeHouseFlag() {
		return fakeHouseFlag;
	}
	public void setFakeHouseFlag(String fakeHouseFlag) {
		this.fakeHouseFlag = fakeHouseFlag;
	}
	public String getIntermediaryHouseFlag() {
		return intermediaryHouseFlag;
	}
	public void setIntermediaryHouseFlag(String intermediaryHouseFlag) {
		this.intermediaryHouseFlag = intermediaryHouseFlag;
	}
	public String getFilterFlag() {
		return filterFlag;
	}
	public void setFilterFlag(String filterFlag) {
		this.filterFlag = filterFlag;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRoom1() {
		return room1;
	}
	public void setRoom1(String room1) {
		this.room1 = room1;
	}
	public String getRoom2() {
		return room2;
	}
	public void setRoom2(String room2) {
		this.room2 = room2;
	}
	public String getUseage() {
		return useage;
	}
	public void setUseage(String useage) {
		this.useage = useage;
	}
	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public String getPrice2() {
		return price2;
	}
	public void setPrice2(String price2) {
		this.price2 = price2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getTbName() {
		return tbName;
	}
	public void setTbName(String tbName) {
		this.tbName = tbName;
	}
	public String getTbNameDetail() {
		return tbNameDetail;
	}
	public void setTbNameDetail(String tbNameDetail) {
		this.tbNameDetail = tbNameDetail;
	}
	public String[] getRegions() {
		return regions;
	}
	public void setRegions(String[] regions) {
		this.regions = regions;
	}
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
	public String[] getRegionIdArr() {
		return regionIdArr;
	}
	public void setRegionIdArr(String[] regionIdArr) {
		this.regionIdArr = regionIdArr;
	}
	public String getRegionIds() {
		return regionIds;
	}
	public void setRegionIds(String regionIds) {
		this.regionIds = regionIds;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String[] getSectionArr() {
		return sectionArr;
	}
	public void setSectionArr(String[] sectionArr) {
		this.sectionArr = sectionArr;
	}
}

