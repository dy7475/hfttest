package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpRichText extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 房源类型1=出售 2=出租
	 */
	private Integer saleLease;
	/**
	 * @mbggenerated 房源id
	 */
	private Integer houseId;
	/**
	 * @mbggenerated 用途
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated 房源编号
	 */
	private String houseNo;
	/**
	 * @mbggenerated
	 */
	private Byte lock;
	/**
	 * @mbggenerated 是否编码
	 */
	private Byte encodeFlag;
	/**
	 * @mbggenerated 核心卖点富文本
	 */
	private String richText;
	/**
	 * @mbggenerated 装修描述富文本
	 */
	private String richTextFitment;
	/**
	 * @mbggenerated 户型介绍富文本
	 */
	private String richTextLayout;
	/**
	 * @mbggenerated 权属抵押富文本
	 */
	private String richTextRights;
	/**
	 * @mbggenerated 核心卖点纯文本
	 */
	private String onlyTextCore;
	/**
	 * @mbggenerated 装修描述纯文本
	 */
	private String onlyTextFitment;
	/**
	 * @mbggenerated 户型介绍纯文本
	 */
	private String onlyTextLayout;
	/**
	 * @mbggenerated 权属抵押纯文本
	 */
	private String onlyTextRights;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(Integer saleLease) {
		this.saleLease = saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo == null ? null : houseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLock() {
		return lock;
	}

	/**
	 * @mbggenerated
	 */
	public void setLock(Byte lock) {
		this.lock = lock;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getRichText() {
		return richText;
	}

	/**
	 * @mbggenerated
	 */
	public void setRichText(String richText) {
		this.richText = richText == null ? null : richText.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRichTextFitment() {
		return richTextFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setRichTextFitment(String richTextFitment) {
		this.richTextFitment = richTextFitment == null ? null : richTextFitment.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRichTextLayout() {
		return richTextLayout;
	}

	/**
	 * @mbggenerated
	 */
	public void setRichTextLayout(String richTextLayout) {
		this.richTextLayout = richTextLayout == null ? null : richTextLayout.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRichTextRights() {
		return richTextRights;
	}

	/**
	 * @mbggenerated
	 */
	public void setRichTextRights(String richTextRights) {
		this.richTextRights = richTextRights == null ? null : richTextRights.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOnlyTextCore() {
		return onlyTextCore;
	}

	/**
	 * @mbggenerated
	 */
	public void setOnlyTextCore(String onlyTextCore) {
		this.onlyTextCore = onlyTextCore == null ? null : onlyTextCore.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOnlyTextFitment() {
		return onlyTextFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setOnlyTextFitment(String onlyTextFitment) {
		this.onlyTextFitment = onlyTextFitment == null ? null : onlyTextFitment.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOnlyTextLayout() {
		return onlyTextLayout;
	}

	/**
	 * @mbggenerated
	 */
	public void setOnlyTextLayout(String onlyTextLayout) {
		this.onlyTextLayout = onlyTextLayout == null ? null : onlyTextLayout.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOnlyTextRights() {
		return onlyTextRights;
	}

	/**
	 * @mbggenerated
	 */
	public void setOnlyTextRights(String onlyTextRights) {
		this.onlyTextRights = onlyTextRights == null ? null : onlyTextRights.trim();
	}

	/**
	 * @mbggenerated
	 */
	public void ErpRichTextKey() {
	}

	/**
	 * @mbggenerated
	 */
	public void ErpRichTextKey(Integer shardCityId, Integer saleLease, Integer houseId, Byte houseUseage) {
		this.saleLease = saleLease;
		this.houseId = houseId;
		this.houseUseage = houseUseage;
	}
}