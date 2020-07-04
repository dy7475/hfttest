package com.myfun.repository.agencydb.param;

import java.io.Serializable;

public class AgencyBuildingInfo4AddParam implements Serializable {

	private static final long serialVersionUID = 1L;


    private Integer oldSeqNo;

    private String loginUid;
    private String loginPwd;

    private String oldLoginUid;
    
    private String openDateString;
    
	public String getOpenDateString() {
		return openDateString;
	}


	public void setOpenDateString(String openDateString) {
		this.openDateString = openDateString;
	}


	public String getOldLoginUid() {
		return oldLoginUid;
	}


	public void setOldLoginUid(String oldLoginUid) {
		this.oldLoginUid = oldLoginUid;
	}


	public String getLoginUid() {
		return loginUid;
	}


	public void setLoginUid(String loginUid) {
		this.loginUid = loginUid;
	}


	public String getLoginPwd() {
		return loginPwd;
	}


	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}


	public Integer getOldSeqNo() {
		return oldSeqNo;
	}


	public void setOldSeqNo(Integer oldSeqNo) {
		this.oldSeqNo = oldSeqNo;
	}


	
    
	
   
}