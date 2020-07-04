package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class AgencyBuildLayout implements Serializable {

	/**
	 * @mbggenerated 
	 */
	private Integer layoutId;
	/**
	 * @mbggenerated ()ID
	 */
	private Short cityId;
	/**
	 * @mbggenerated ¥ID
	 */
	private Integer buildId;
	/**
	 * @mbggenerated ͱ
	 */
	private String layoutNo;
	/**
	 * @mbggenerated ͱ
	 */
	private String layoutName;
	/**
	 * @mbggenerated ʾ˳
	 */
	private Short seqNo;
	/**
	 * @mbggenerated 
	 */
	private Byte rooms;
	/**
	 * @mbggenerated 
	 */
	private Byte halls;
	/**
	 * @mbggenerated 
	 */
	private Byte weis;
	/**
	 * @mbggenerated 
	 */
	private Byte yangs;
	/**
	 * @mbggenerated 
	 */
	private BigDecimal buildArea;
	/**
	 * @mbggenerated 
	 */
	private BigDecimal insideArea;
	/**
	 * @mbggenerated ۸
	 */
	private Integer price;
	/**
	 * @mbggenerated 
	 */
	private String layoutType;
	/**
	 * @mbggenerated û
	 */
	private Integer houses;
	/**
	 * @mbggenerated Ƿ
	 */
	private Short ismain;
	/**
	 * @mbggenerated ɫ
	 */
	private String charact;
	/**
	 * @mbggenerated ͼ
	 */
	private String layoutPic1;
	/**
	 * @mbggenerated ͼ
	 */
	private String layoutPic2;
	/**
	 * @mbggenerated ±
	 */
	private Byte editFlag;
	/**
	 * @mbggenerated Ӧ  LAYOUT_TYPE ֵ
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated û״̬1=2=3=
	 */
	private Byte layoutStatus;
	/**
	 * @mbggenerated ǩ
	 */
	private String layoutTag;
	/**
	 * @mbggenerated Ƿvr
	 */
	private Byte hasPanorama;
	/**
	 * @mbggenerated ɫı
	 */
	private String charactRichText;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getLayoutId() {
		return layoutId;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
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
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutNo() {
		return layoutNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutNo(String layoutNo) {
		this.layoutNo = layoutNo == null ? null : layoutNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutName() {
		return layoutName;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName == null ? null : layoutName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Short getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Short seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRooms() {
		return rooms;
	}

	/**
	 * @mbggenerated
	 */
	public void setRooms(Byte rooms) {
		this.rooms = rooms;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHalls() {
		return halls;
	}

	/**
	 * @mbggenerated
	 */
	public void setHalls(Byte halls) {
		this.halls = halls;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWeis() {
		return weis;
	}

	/**
	 * @mbggenerated
	 */
	public void setWeis(Byte weis) {
		this.weis = weis;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getYangs() {
		return yangs;
	}

	/**
	 * @mbggenerated
	 */
	public void setYangs(Byte yangs) {
		this.yangs = yangs;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getBuildArea() {
		return buildArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildArea(BigDecimal buildArea) {
		this.buildArea = buildArea;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getInsideArea() {
		return insideArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setInsideArea(BigDecimal insideArea) {
		this.insideArea = insideArea;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutType() {
		return layoutType;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutType(String layoutType) {
		this.layoutType = layoutType == null ? null : layoutType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouses() {
		return houses;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouses(Integer houses) {
		this.houses = houses;
	}

	/**
	 * @mbggenerated
	 */
	public Short getIsmain() {
		return ismain;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsmain(Short ismain) {
		this.ismain = ismain;
	}

	/**
	 * @mbggenerated
	 */
	public String getCharact() {
		return charact;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharact(String charact) {
		this.charact = charact == null ? null : charact.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutPic1() {
		return layoutPic1;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutPic1(String layoutPic1) {
		this.layoutPic1 = layoutPic1 == null ? null : layoutPic1.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutPic2() {
		return layoutPic2;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutPic2(String layoutPic2) {
		this.layoutPic2 = layoutPic2 == null ? null : layoutPic2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getEditFlag() {
		return editFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setEditFlag(Byte editFlag) {
		this.editFlag = editFlag;
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
	public Byte getLayoutStatus() {
		return layoutStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutStatus(Byte layoutStatus) {
		this.layoutStatus = layoutStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getLayoutTag() {
		return layoutTag;
	}

	/**
	 * @mbggenerated
	 */
	public void setLayoutTag(String layoutTag) {
		this.layoutTag = layoutTag == null ? null : layoutTag.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHasPanorama() {
		return hasPanorama;
	}

	/**
	 * @mbggenerated
	 */
	public void setHasPanorama(Byte hasPanorama) {
		this.hasPanorama = hasPanorama;
	}

	/**
	 * @mbggenerated
	 */
	public String getCharactRichText() {
		return charactRichText;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharactRichText(String charactRichText) {
		this.charactRichText = charactRichText == null ? null : charactRichText.trim();
	}
}