package com.myfun.erpWeb.openApi.user.param;

import com.extension.framework.mq.context.MqMessage;
import com.myfun.repository.param.EncryParamIfc;

public class DealNewOrgUserCountMessage extends MqMessage implements EncryParamIfc{
	private Integer cityId;
	private Integer compId;
	private Integer newOrgId;
	private Integer oldOrgId;
	/**
	 * 处理类型 1处理员工调组织 2处理部门调组织
	 */
	private Integer dealType;
	private Integer oldPid;
	private Integer moveOrgId;
	private Integer newPid;
	private Integer moveUserId;
	private Integer moveArchiveId;
	private Integer selfUserId;
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public Integer getMoveUserId() {
		return moveUserId;
	}
	public void setMoveUserId(Integer moveUserId) {
		this.moveUserId = moveUserId;
	}
	public Integer getMoveArchiveId() {
		return moveArchiveId;
	}
	public void setMoveArchiveId(Integer moveArchiveId) {
		this.moveArchiveId = moveArchiveId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getNewOrgId() {
		return newOrgId;
	}
	public void setNewOrgId(Integer newOrgId) {
		this.newOrgId = newOrgId;
	}
	public Integer getOldOrgId() {
		return oldOrgId;
	}
	public void setOldOrgId(Integer oldOrgId) {
		this.oldOrgId = oldOrgId;
	}
	public Integer getDealType() {
		return dealType;
	}
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}
	public Integer getOldPid() {
		return oldPid;
	}
	public void setOldPid(Integer oldPid) {
		this.oldPid = oldPid;
	}
	public Integer getMoveOrgId() {
		return moveOrgId;
	}
	public void setMoveOrgId(Integer moveOrgId) {
		this.moveOrgId = moveOrgId;
	}
	public Integer getNewPid() {
		return newPid;
	}
	public void setNewPid(Integer newPid) {
		this.newPid = newPid;
	}
	
	
}
