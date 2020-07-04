package com.myfun.repository.admindb.param;

import com.myfun.repository.support.param.PageParam;

public class AdminFunBrandParam extends PageParam {

	private String sInTime;
	private String eInTime;
	private String brandName;
	private Byte writeOff;

	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Byte getWriteOff() {
		return writeOff;
	}
	public void setWriteOff(Byte writeOff) {
		this.writeOff = writeOff;
	}
	public String getsInTime() {
		return sInTime;
	}
	public void setsInTime(String sInTime) {
		this.sInTime = sInTime;
	}
	public String geteInTime() {
		return eInTime;
	}
	public void seteInTime(String eInTime) {
		this.eInTime = eInTime;
	}    
}