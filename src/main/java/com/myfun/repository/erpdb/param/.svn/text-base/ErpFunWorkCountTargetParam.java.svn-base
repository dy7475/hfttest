package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunWorkcountTarget;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;

import java.util.List;

public class ErpFunWorkCountTargetParam extends ErpFunWorkcountTarget implements EncryParamIfc {

	protected Integer pageOffset; // 1 第几页
	protected Integer pageRows; // 50 一页多少条

	private Integer cityId;
	private Integer areaId;
	private Integer regId;
	private Integer deptId;
	private Integer grId;
	private Integer isExport = 0;
	private String userPosition;

	private List<Integer> areaIds;
	private List<Integer> regIds;
	private List<Integer> deptIds;
	private List<Integer> grIds;
	private List<Integer> userIds;
	private List<Integer> partnerIds;

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public List<Integer> getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(List<Integer> areaIds) {
		this.areaIds = areaIds;
	}

	public List<Integer> getRegIds() {
		return regIds;
	}

	public void setRegIds(List<Integer> regIds) {
		this.regIds = regIds;
	}

	public List<Integer> getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(List<Integer> deptIds) {
		this.deptIds = deptIds;
	}

	public List<Integer> getGrIds() {
		return grIds;
	}

	public void setGrIds(List<Integer> grIds) {
		this.grIds = grIds;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getIsExport() {
		return isExport;
	}

	public void setIsExport(Integer isExport) {
		this.isExport = isExport;
	}


	public boolean isNeedCount() {
		return getPageOffset() == 1;
	}

	public Integer getOffsetNow() {
		return (getPageOffset()-1)*getPageRows();
	}

	public Integer getPageOffset() {
		if(pageOffset == null || pageOffset <= 0){
			return Const.CURRENT_PAGE;
		}
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		if(pageRows == null || pageRows <= 0){
			return Const.PAGE_NUMBER;
		}
		return pageRows;
	}

	public Integer getPageRows(Integer p) {
		if(pageRows == null || pageRows <= 0){
			return p;
		}
		return pageRows;
	}

	public void setPageRows(Integer p) {
		pageRows = p;
	}

	public List<Integer> getPartnerIds() {
		return partnerIds;
	}

	public void setPartnerIds(List<Integer> partnerIds) {
		this.partnerIds = partnerIds;
	}
}
