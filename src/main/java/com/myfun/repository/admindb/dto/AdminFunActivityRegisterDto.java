package com.myfun.repository.admindb.dto;

import java.util.Date;

import com.myfun.repository.admindb.po.AdminFunActivityRegister;
import com.myfun.repository.erpdb.po.ErpFunUsers;

public class AdminFunActivityRegisterDto extends AdminFunActivityRegister{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer user_hight;
	private String user_email;
	private String user_name;
	private Integer user_sex;
	private String user_mobile;
	private Integer mobile_valided;
	private Double amount;
	private Integer super_user;
	private Date super_start;
	private Date super_end;
	private Date creation_time;
	private String dept_name;
	private String city_name;
	private Integer registerNum;
	private Date lastRegisterTime;
	private ErpFunUsers funUsers;
	
	public ErpFunUsers getFunUsers() {
		return funUsers;
	}
	public void setFunUsers(ErpFunUsers funUsers) {
		this.funUsers = funUsers;
	}
	public Integer getUser_hight() {
		return user_hight;
	}
	public void setUser_hight(Integer user_hight) {
		this.user_hight = user_hight;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public Integer getMobile_valided() {
		return mobile_valided;
	}
	public void setMobile_valided(Integer mobile_valided) {
		this.mobile_valided = mobile_valided;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getSuper_user() {
		return super_user;
	}
	public void setSuper_user(Integer super_user) {
		this.super_user = super_user;
	}
	public Date getSuper_start() {
		return super_start;
	}
	public void setSuper_start(Date super_start) {
		this.super_start = super_start;
	}
	public Date getSuper_end() {
		return super_end;
	}
	public void setSuper_end(Date super_end) {
		this.super_end = super_end;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Integer getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(Integer registerNum) {
		this.registerNum = registerNum;
	}
	public Date getLastRegisterTime() {
		return lastRegisterTime;
	}
	public void setLastRegisterTime(Date lastRegisterTime) {
		this.lastRegisterTime = lastRegisterTime;
	}

	
}
