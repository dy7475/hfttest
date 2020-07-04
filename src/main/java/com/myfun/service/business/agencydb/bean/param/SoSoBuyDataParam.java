package com.myfun.service.business.agencydb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class SoSoBuyDataParam extends AbstractEncryParam implements DaoBaseParam{
	private Integer caseId;
	private String caseType;
	// 以下是查询时使用参数
	private String provinceId;// 所在省市
	private Integer cityId;// 城市id
	private String time1;// 开始时间
	private String time2;// 结束时间
	private Integer archiveId;// 档案id
	private String tbName;// table名
	private String tbNameDetail;// 详细信息表名
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getTbName() {
		return tbName;
	}
	public void setTbName(String tbName) {
		this.tbName = tbName;
	}
	public String getTbNameDetail() {
		return tbNameDetail;
	}
	public void setTbNameDetail(String tbNameDetail) {
		this.tbNameDetail = tbNameDetail;
	}
	
	
	
}

