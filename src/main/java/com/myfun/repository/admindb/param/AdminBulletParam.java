package com.myfun.repository.admindb.param;

import com.myfun.repository.admindb.po.AdminBullet;

public class AdminBulletParam extends AdminBullet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer provinceId;
	
	private Integer crmCompId;

	private Integer deptId;
	
	private Integer compId;
	
	private Integer youjiaflag = 0;
	
	private String voteOptions;
	
	private Integer isvoteNote;
	
	private Integer voteType;
	
	private String keyWord;
	
	private Integer searchModel;
	
	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	public Integer getSearchModel() {
		return searchModel;
	}


	public void setSearchModel(Integer searchModel) {
		this.searchModel = searchModel;
	}


	public Integer getVoteType() {
		return voteType;
	}


	public void setVoteType(Integer voteType) {
		this.voteType = voteType;
	}


	public Integer getIsvoteNote() {
		return isvoteNote;
	}


	public void setIsvoteNote(Integer isvoteNote) {
		this.isvoteNote = isvoteNote;
	}


	public String getVoteOptions() {
		return voteOptions;
	}


	public void setVoteOptions(String voteOptions) {
		this.voteOptions = voteOptions;
	}

	
	public Integer getYoujiaflag() {
		return youjiaflag;
	}

	public void setYoujiaflag(Integer youjiaflag) {
		this.youjiaflag = youjiaflag;
	}


	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public Integer getCompId() {
		return compId;
	}


	public void setCompId(Integer compId) {
		this.compId = compId;
	}


	public Integer getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}


	public Integer getCrmCompId() {
		return crmCompId;
	}


	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}
	
	
}
