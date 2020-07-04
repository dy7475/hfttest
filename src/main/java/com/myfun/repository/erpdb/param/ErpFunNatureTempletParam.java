package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import java.math.BigDecimal;
import java.util.Date;

public class ErpFunNatureTempletParam extends AbstractEncryParam implements DaoBaseParam{


	private Integer id;

	
	private String taxName;

	
	private Byte funNature;

	
	private Byte buyNature;

	
	private Byte yearNature;

	
	private BigDecimal qsRate;

	
	private BigDecimal yhRate;

	
	private BigDecimal tradeFee;

	
	private Byte zzsType;

	
	private BigDecimal zzsRate;

	
	private Byte gsType;

	
	private BigDecimal gsRate;

	
	private Byte serverType;

	
	private BigDecimal serverFee;

	
	private BigDecimal regFee;

	
	private BigDecimal transferFee;

	
	private BigDecimal landCardFee;

	
	private Date createTime;

	
	private Integer compId;

	
	private Integer deptId;

	private String extParam;

	public void setYhRate(BigDecimal yhRate) {
		this.yhRate = yhRate;
	}

	public String getExtParam() {
		return extParam;
	}

	public void setExtParam(String extParam) {
		this.extParam = extParam;
	}

	private static final long serialVersionUID = 1L;

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getTaxName() {
		return taxName;
	}

	
	public void setTaxName(String taxName) {
		this.taxName = taxName == null ? null : taxName.trim();
	}

	
	public Byte getFunNature() {
		return funNature;
	}

	
	public void setFunNature(Byte funNature) {
		this.funNature = funNature;
	}

	
	public Byte getBuyNature() {
		return buyNature;
	}

	
	public void setBuyNature(Byte buyNature) {
		this.buyNature = buyNature;
	}

	
	public Byte getYearNature() {
		return yearNature;
	}

	
	public void setYearNature(Byte yearNature) {
		this.yearNature = yearNature;
	}

	
	public BigDecimal getQsRate() {
		return qsRate;
	}

	
	public void setQsRate(BigDecimal qsRate) {
		this.qsRate = qsRate;
	}

	
	public BigDecimal getYhRate() {
		return yhRate;
	}

	
	public void setYhRete(BigDecimal yhRate) {
		this.yhRate = yhRate;
	}

	
	public BigDecimal getTradeFee() {
		return tradeFee;
	}

	
	public void setTradeFee(BigDecimal tradeFee) {
		this.tradeFee = tradeFee;
	}

	
	public Byte getZzsType() {
		return zzsType;
	}

	
	public void setZzsType(Byte zzsType) {
		this.zzsType = zzsType;
	}

	
	public BigDecimal getZzsRate() {
		return zzsRate;
	}

	
	public void setZzsRate(BigDecimal zzsRate) {
		this.zzsRate = zzsRate;
	}

	
	public Byte getGsType() {
		return gsType;
	}

	
	public void setGsType(Byte gsType) {
		this.gsType = gsType;
	}

	
	public BigDecimal getGsRate() {
		return gsRate;
	}

	
	public void setGsRate(BigDecimal gsRate) {
		this.gsRate = gsRate;
	}

	
	public Byte getServerType() {
		return serverType;
	}

	
	public void setServerType(Byte serverType) {
		this.serverType = serverType;
	}

	
	public BigDecimal getServerFee() {
		return serverFee;
	}

	
	public void setServerFee(BigDecimal serverFee) {
		this.serverFee = serverFee;
	}

	
	public BigDecimal getRegFee() {
		return regFee;
	}

	
	public void setRegFee(BigDecimal regFee) {
		this.regFee = regFee;
	}

	
	public BigDecimal getTransferFee() {
		return transferFee;
	}

	
	public void setTransferFee(BigDecimal transferFee) {
		this.transferFee = transferFee;
	}

	
	public BigDecimal getLandCardFee() {
		return landCardFee;
	}

	
	public void setLandCardFee(BigDecimal landCardFee) {
		this.landCardFee = landCardFee;
	}


	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCompId() {
		return compId;
	}

	
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	
	public Integer getDeptId() {
		return deptId;
	}

	
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}



}
