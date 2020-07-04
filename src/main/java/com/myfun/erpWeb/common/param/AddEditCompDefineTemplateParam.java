package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class AddEditCompDefineTemplateParam extends AbstractEncryParam {

	@ApiModelProperty(value = "主键  有id时修改  id为空时新增", example = "1111")
	private Integer id;
	@ApiModelProperty(value = "房源标题")
	private String subjectTemplet;
	@ApiModelProperty(value = "标题或者描述，0=描述 1=标题")
	private Boolean type;
	@ApiModelProperty(value = "租售类型，1=出售 2=出租")
	private Byte saleLease;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(value = "包含哪些内容在模板中，111111表示适用于所有要求,100000:表示包含BNAME（楼盘名称）,011000:表示包含FITMENT（装修）和ROOM(几室),以此类推,BNAME:1,FITMENT:2,ROOM:3,PRICE:4,AREA:5,DIRECT:6")
	private String typesFlag;
	@ApiModelProperty(value = "用途类型，1=住宅 2=商铺 3=写字楼 0=通用")
	private Byte houseUseage;
	@ApiModelProperty(value = "")
	private Integer useCount;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer archiveId;
	@ApiModelProperty(hidden = true)
	private Byte lock;
	@ApiModelProperty(hidden = true)
	private Byte encodeFlag;
	@ApiModelProperty(hidden = true)
	private Byte newTemplate;
	@ApiModelProperty("房源描述")
	private String charactTemplet;
	@ApiModelProperty("内容")
	private String charactTempletEncode;
	@ApiModelProperty("内容")
	private String charactTempletEncodeOld;
	@ApiModelProperty(hidden = true)
	private Date updatetime;
	@ApiModelProperty("类型 // 0为公司 1为个人")
	private Integer queryType;

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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

	public Integer getUseCount() {
		return useCount;
	}

	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
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
