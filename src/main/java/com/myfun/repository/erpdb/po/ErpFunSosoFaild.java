package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunSosoFaild extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Integer type;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private String regName;
	/**
	 * @mbggenerated
	 */
	private String useage;
	/**
	 * @mbggenerated
	 */
	private String room1;
	/**
	 * @mbggenerated
	 */
	private String room2;
	/**
	 * @mbggenerated
	 */
	private String area1;
	/**
	 * @mbggenerated
	 */
	private String area2;
	/**
	 * @mbggenerated
	 */
	private String price1;
	/**
	 * @mbggenerated
	 */
	private String price2;
	/**
	 * @mbggenerated
	 */
	private String faildTime;
	/**
	 * @mbggenerated
	 */
	private String contont;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @mbggenerated
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegName(String regName) {
		this.regName = regName == null ? null : regName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseage(String useage) {
		this.useage = useage == null ? null : useage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRoom1() {
		return room1;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoom1(String room1) {
		this.room1 = room1 == null ? null : room1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRoom2() {
		return room2;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoom2(String room2) {
		this.room2 = room2 == null ? null : room2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getArea1() {
		return area1;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea1(String area1) {
		this.area1 = area1 == null ? null : area1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getArea2() {
		return area2;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea2(String area2) {
		this.area2 = area2 == null ? null : area2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPrice1() {
		return price1;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrice1(String price1) {
		this.price1 = price1 == null ? null : price1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPrice2() {
		return price2;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrice2(String price2) {
		this.price2 = price2 == null ? null : price2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFaildTime() {
		return faildTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setFaildTime(String faildTime) {
		this.faildTime = faildTime == null ? null : faildTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getContont() {
		return contont;
	}

	/**
	 * @mbggenerated
	 */
	public void setContont(String contont) {
		this.contont = contont == null ? null : contont.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSosoFaild() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSosoFaild(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}