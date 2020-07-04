package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminCrmUser;

public class AdminCrmUserDto extends AdminCrmUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleName;
	private String deptName;
	private String vipNum;
	private String vipSaleSum;
	private String vipCommission;
	private String otoNum;
	private String otoSaleSum;
	private String otoCommission;
	private String softNUm;
	private String softSaleSum;
	private String softCommission;
	private String personTotalSales;
	private String bonus;
	private String personTotalCommission;
	private String personTotal;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getVipNum() {
		return vipNum;
	}
	public void setVipNum(String vipNum) {
		this.vipNum = vipNum;
	}
	public String getVipSaleSum() {
		return vipSaleSum;
	}
	public void setVipSaleSum(String vipSaleSum) {
		this.vipSaleSum = vipSaleSum;
	}
	public String getVipCommission() {
		return vipCommission;
	}
	public void setVipCommission(String vipCommission) {
		this.vipCommission = vipCommission;
	}
	public String getOtoNum() {
		return otoNum;
	}
	public void setOtoNum(String otoNum) {
		this.otoNum = otoNum;
	}
	public String getOtoSaleSum() {
		return otoSaleSum;
	}
	public void setOtoSaleSum(String otoSaleSum) {
		this.otoSaleSum = otoSaleSum;
	}
	public String getOtoCommission() {
		return otoCommission;
	}
	public void setOtoCommission(String otoCommission) {
		this.otoCommission = otoCommission;
	}
	public String getSoftNUm() {
		return softNUm;
	}
	public void setSoftNUm(String softNUm) {
		this.softNUm = softNUm;
	}
	public String getSoftSaleSum() {
		return softSaleSum;
	}
	public void setSoftSaleSum(String softSaleSum) {
		this.softSaleSum = softSaleSum;
	}
	public String getSoftCommission() {
		return softCommission;
	}
	public void setSoftCommission(String softCommission) {
		this.softCommission = softCommission;
	}
	public String getPersonTotalSales() {
		return personTotalSales;
	}
	public void setPersonTotalSales(String personTotalSales) {
		this.personTotalSales = personTotalSales;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getPersonTotalCommission() {
		return personTotalCommission;
	}
	public void setPersonTotalCommission(String personTotalCommission) {
		this.personTotalCommission = personTotalCommission;
	}
	public String getPersonTotal() {
		return personTotal;
	}
	public void setPersonTotal(String personTotal) {
		this.personTotal = personTotal;
	}
	
	
	
}
