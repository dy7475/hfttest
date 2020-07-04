package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FunDealTaxesFatherVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("分类ID")
	private Integer id;
	
	@ApiModelProperty("分类名称")
	private String name;
	
	@ApiModelProperty("公司ID")
	private Integer compId;
	
	@ApiModelProperty("排序")
	private Integer seqNo;
	
	@ApiModelProperty("是否已删除")
	private Byte isDel;
	
	@ApiModelProperty("0=买方，1=卖方")
	private Byte payType;
	
	@ApiModelProperty("能否删除")
	private Byte canDel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public Byte getCanDel() {
		return canDel;
	}

	public void setCanDel(Byte canDel) {
		this.canDel = canDel;
	}
	
}
