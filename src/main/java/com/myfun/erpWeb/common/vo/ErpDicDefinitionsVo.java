package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("字典VO")
public class ErpDicDefinitionsVo  {

	@ApiModelProperty("ID号，SEQ_DIC_DEFINITIONS_DIC_ID")
	private Short dicId;
	@ApiModelProperty("大类英文")
	private String dicGroupType;
	@ApiModelProperty("小类英文")
	private String dicType;
	@ApiModelProperty("省份ID，0=公用的")
	private Short provinceId;
	@ApiModelProperty("城市ID，0=公用的")
	private Short cityId;
	@ApiModelProperty("序号")
	private Byte seqNo;
	@ApiModelProperty("标准值，DIC_VALUE 转成tinyint")
	private String dicValue;
	@ApiModelProperty("附加值1")
	private String dicValue1;
	@ApiModelProperty("值的英文描述，DIC_VALUE存入DIC_EN_MSG")
	private String dicEnMsg;
	@ApiModelProperty("值的中文描述")
	private String dicCnMsg;
	@ApiModelProperty("最后更新时间")
	private String updateTime;
	@ApiModelProperty("dicCnMsg2")
	private String dicCnMsg2;
	@ApiModelProperty("是否删除")
	private Integer isDel;

	public Short getDicId() {
		return dicId;
	}

	public void setDicId(Short dicId) {
		this.dicId = dicId;
	}

	public String getDicGroupType() {
		return dicGroupType;
	}

	public void setDicGroupType(String dicGroupType) {
		this.dicGroupType = dicGroupType;
	}

	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public Short getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Short provinceId) {
		this.provinceId = provinceId;
	}

	public Short getCityId() {
		return cityId;
	}

	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	public Byte getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicValue1() {
		return dicValue1;
	}

	public void setDicValue1(String dicValue1) {
		this.dicValue1 = dicValue1;
	}

	public String getDicEnMsg() {
		return dicEnMsg;
	}

	public void setDicEnMsg(String dicEnMsg) {
		this.dicEnMsg = dicEnMsg;
	}

	public String getDicCnMsg() {
		return dicCnMsg;
	}

	public void setDicCnMsg(String dicCnMsg) {
		this.dicCnMsg = dicCnMsg;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDicCnMsg2() {
		return dicCnMsg2;
	}

	public void setDicCnMsg2(String dicCnMsg2) {
		this.dicCnMsg2 = dicCnMsg2;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
}
