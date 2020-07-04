package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2018-12-11 17:06
 */
public class TemplateVO {
	@ApiModelProperty(value = " 主键")
	private Integer id;
	@ApiModelProperty(value = " 房源标题")
	private String subjectTemplet;
	@ApiModelProperty(value = " 标题或者描述，0=描述 1=标题")
	private Boolean type;
	@ApiModelProperty(value = " 租售类型，1=出售 2=出租")
	private Byte saleLease;
	@ApiModelProperty(value = " 包含哪些内容在模板中，111111表示适用于所有要求,100000:表示包含BNAME（楼盘名称）,011000:表示包含FITMENT（装修）和ROOM(几室),以此类推,BNAME:1,FITMENT:2,ROOM:3,PRICE:4,AREA:5,DIRECT:6")
	private String typesFlag;
	@ApiModelProperty(value = " 用途类型，1=住宅 2=商铺 3=写字楼 0=通用")
	private Byte houseUseage;
	@ApiModelProperty(value = "")
	private Byte lock;
	@ApiModelProperty(value = "")
	private Byte encodeFlag;
	@ApiModelProperty(value = "")
	private Byte newTemplate;
	@ApiModelProperty(value = " 房源描述")
	private String charactTemplet;
	@ApiModelProperty(value = "")
	private String charactTempletEncode;
	@ApiModelProperty(value = "")
	private String charactTempletEncodeOld;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectTemplet() {
		return subjectTemplet;
	}

	public void setSubjectTemplet(String subjectTemplet) {
		this.subjectTemplet = subjectTemplet;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Byte getSaleLease() {
		return saleLease;
	}

	public void setSaleLease(Byte saleLease) {
		this.saleLease = saleLease;
	}

	public String getTypesFlag() {
		return typesFlag;
	}

	public void setTypesFlag(String typesFlag) {
		this.typesFlag = typesFlag;
	}

	public Byte getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Byte getLock() {
		return lock;
	}

	public void setLock(Byte lock) {
		this.lock = lock;
	}

	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	public Byte getNewTemplate() {
		return newTemplate;
	}

	public void setNewTemplate(Byte newTemplate) {
		this.newTemplate = newTemplate;
	}

	public String getCharactTemplet() {
		return charactTemplet;
	}

	public void setCharactTemplet(String charactTemplet) {
		this.charactTemplet = charactTemplet;
	}

	public String getCharactTempletEncode() {
		return charactTempletEncode;
	}

	public void setCharactTempletEncode(String charactTempletEncode) {
		this.charactTempletEncode = charactTempletEncode;
	}

	public String getCharactTempletEncodeOld() {
		return charactTempletEncodeOld;
	}

	public void setCharactTempletEncodeOld(String charactTempletEncodeOld) {
		this.charactTempletEncodeOld = charactTempletEncodeOld;
	}
}
