package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunTemplet implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 房源标题
	 */
	private String subjectTemplet;
	/**
	 * @mbggenerated 标题或者描述，0=描述 1=标题
	 */
	private Boolean type;
	/**
	 * @mbggenerated 租售类型，1=出售 2=出租
	 */
	private Byte saleLease;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 包含哪些内容在模板中，111111表示适用于所有要求,100000:表示包含BNAME（楼盘名称）,011000:表示包含FITMENT（装修）和ROOM(几室),以此类推,BNAME:1,FITMENT:2,ROOM:3,PRICE:4,AREA:5,DIRECT:6
	 */
	private String typesFlag;
	/**
	 * @mbggenerated 用途类型，1=住宅 2=商铺 3=写字楼 0=通用
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated
	 */
	private Integer useCount;
	/**
	 * @mbggenerated
	 */
	private Date updatetime;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated ARCHIVE_ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Byte lock;
	/**
	 * @mbggenerated
	 */
	private Byte encodeFlag;
	/**
	 * @mbggenerated
	 */
	private Byte newTemplate;
	/**
	 * @mbggenerated 房源描述
	 */
	private String charactTemplet;
	/**
	 * @mbggenerated
	 */
	private String charactTempletEncode;
	/**
	 * @mbggenerated
	 */
	private String charactTempletEncodeOld;
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
	public String getSubjectTemplet() {
		return subjectTemplet;
	}

	/**
	 * @mbggenerated
	 */
	public void setSubjectTemplet(String subjectTemplet) {
		this.subjectTemplet = subjectTemplet;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getType() {
		return type;
	}

	/**
	 * @mbggenerated
	 */
	public void setType(Boolean type) {
		this.type = type;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(Byte saleLease) {
		this.saleLease = saleLease;
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
	public String getTypesFlag() {
		return typesFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setTypesFlag(String typesFlag) {
		this.typesFlag = typesFlag;
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
	public Integer getUseCount() {
		return useCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
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
	public Byte getNewTemplate() {
		return newTemplate;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewTemplate(Byte newTemplate) {
		this.newTemplate = newTemplate;
	}

	/**
	 * @mbggenerated
	 */
	public String getCharactTemplet() {
		return charactTemplet;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharactTemplet(String charactTemplet) {
		this.charactTemplet = charactTemplet;
	}

	/**
	 * @mbggenerated
	 */
	public String getCharactTempletEncode() {
		return charactTempletEncode;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharactTempletEncode(String charactTempletEncode) {
		this.charactTempletEncode = charactTempletEncode;
	}

	/**
	 * @mbggenerated
	 */
	public String getCharactTempletEncodeOld() {
		return charactTempletEncodeOld;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharactTempletEncodeOld(String charactTempletEncodeOld) {
		this.charactTempletEncodeOld = charactTempletEncodeOld;
	}
}