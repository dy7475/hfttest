package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminDiscountConfig implements Serializable {

	/**
	 * @mbggenerated 编号
	 */
	private Integer dcId;
	/**
	 * @mbggenerated 城市级别 1=重点城市，2=非重点城市
	 */
	private String version;
	/**
	 * @mbggenerated 类型，SOUFA=增值服务 NETBANK=网银充值
	 */
	private String type;
	/**
	 * @mbggenerated 类型描述
	 */
	private String typeDesc;
	/**
	 * @mbggenerated 增值服务就是原价，网银就是底价
	 */
	private Integer limit;
	/**
	 * @mbggenerated 增值服务折扣价
	 */
	private Double discount1;
	/**
	 * @mbggenerated 增值服务赠送天数
	 */
	private String discount2;
	/**
	 * @mbggenerated 开始时间
	 */
	private Date startTime;
	/**
	 * @mbggenerated 结束时间
	 */
	private Date endTime;
	/**
	 * @mbggenerated 省份ID
	 */
	private Integer provinceId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Short cityId;
	/**
	 * @mbggenerated 项目配置
	 */
	private String items;
	/**
	 * @mbggenerated 原价
	 */
	private String option1;
	/**
	 * @mbggenerated 折扣价
	 */
	private String option2;
	/**
	 * @mbggenerated 赠送1
	 */
	private String option3;
	/**
	 * @mbggenerated 赠送2
	 */
	private String option4;
	/**
	 * @mbggenerated 扩展json字符串
	 */
	private String extJson;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getDcId() {
		return dcId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	/**
	 * @mbggenerated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @mbggenerated
	 */
	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getType() {
		return type;
	}

	/**
	 * @mbggenerated
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc == null ? null : typeDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @mbggenerated
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @mbggenerated
	 */
	public Double getDiscount1() {
		return discount1;
	}

	/**
	 * @mbggenerated
	 */
	public void setDiscount1(Double discount1) {
		this.discount1 = discount1;
	}

	/**
	 * @mbggenerated
	 */
	public String getDiscount2() {
		return discount2;
	}

	/**
	 * @mbggenerated
	 */
	public void setDiscount2(String discount2) {
		this.discount2 = discount2 == null ? null : discount2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public String getItems() {
		return items;
	}

	/**
	 * @mbggenerated
	 */
	public void setItems(String items) {
		this.items = items == null ? null : items.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @mbggenerated
	 */
	public void setOption1(String option1) {
		this.option1 = option1 == null ? null : option1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @mbggenerated
	 */
	public void setOption2(String option2) {
		this.option2 = option2 == null ? null : option2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @mbggenerated
	 */
	public void setOption3(String option3) {
		this.option3 = option3 == null ? null : option3.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOption4() {
		return option4;
	}

	/**
	 * @mbggenerated
	 */
	public void setOption4(String option4) {
		this.option4 = option4 == null ? null : option4.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getExtJson() {
		return extJson;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtJson(String extJson) {
		this.extJson = extJson == null ? null : extJson.trim();
	}
}