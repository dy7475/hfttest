package com.myfun.repository.admindb.param;

import java.util.Date;

import com.myfun.repository.support.param.PageParam;

/**
 * 网络申请列表参数对象
 * 
 * @author XIONG CAI
 * 
 */

public class FunTrialappParam extends PageParam {

	private Long id;

	private Integer provinceId;

	private Integer cityId;

	private String cityName;

	private String userPhone;

	private String compName;

	private String userName;

	private String userMobile;

	private Integer userSex;

	private Integer softType;

	private String iccode;

	private String email;

	private String compcname;

	private Integer regId;

	private String adress;

	private String deptName;

	private Date regtime1;
	
	private Date regtime2;

	private Integer status;

	private String memo;

	private String macaddr;

	private String pcName;

	private String userNo;

	private String userPwd;

	private Integer userIdReg;

	private Date startTime;

	private Date endTime;

	private Integer compId;

	private Integer crmCompId;

	private Integer tralSource;

	private Date trackTime;

	private Integer chargeUserId;

	private String level;

	private String tralMethod;

	private Integer reguser;

	private Integer isCust;

	private String keyWords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone == null ? null : userPhone.trim();
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName == null ? null : compName.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public Integer getSoftType() {
		return softType;
	}

	public void setSoftType(Integer softType) {
		this.softType = softType;
	}

	public String getIccode() {
		return iccode;
	}

	public void setIccode(String iccode) {
		this.iccode = iccode == null ? null : iccode.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getCompcname() {
		return compcname;
	}

	public void setCompcname(String compcname) {
		this.compcname = compcname == null ? null : compcname.trim();
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress == null ? null : adress.trim();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public String getMacaddr() {
		return macaddr;
	}

	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr == null ? null : macaddr.trim();
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName == null ? null : pcName.trim();
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public Integer getUserIdReg() {
		return userIdReg;
	}

	public void setUserIdReg(Integer userIdReg) {
		this.userIdReg = userIdReg;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	public Integer getTralSource() {
		return tralSource;
	}

	public void setTralSource(Integer tralSource) {
		this.tralSource = tralSource;
	}

	public Date getTrackTime() {
		return trackTime;
	}

	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	public Integer getChargeUserId() {
		return chargeUserId;
	}

	public void setChargeUserId(Integer chargeUserId) {
		this.chargeUserId = chargeUserId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level == null ? null : level.trim();
	}

	public String getTralMethod() {
		return tralMethod;
	}

	public void setTralMethod(String tralMethod) {
		this.tralMethod = tralMethod == null ? null : tralMethod.trim();
	}

	public Integer getReguser() {
		return reguser;
	}

	public void setReguser(Integer reguser) {
		this.reguser = reguser;
	}

	public Integer getIsCust() {
		return isCust;
	}

	public void setIsCust(Integer isCust) {
		this.isCust = isCust;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Date getRegtime1() {
		return regtime1;
	}

	public void setRegtime1(Date regtime1) {
		this.regtime1 = regtime1;
	}

	public Date getRegtime2() {
		return regtime2;
	}

	public void setRegtime2(Date regtime2) {
		this.regtime2 = regtime2;
	}

}
