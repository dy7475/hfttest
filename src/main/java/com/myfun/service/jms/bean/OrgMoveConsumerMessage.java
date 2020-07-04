package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class OrgMoveConsumerMessage extends MqMessage{
    //数据处理类型 1=按全公司处理，2按影响节点处理
    private Byte dealType;

    //城市id
    private Integer cityId;

    //公司id
    private Integer compId;

    //移动的组织机构上级id
    private Integer moveOrgId;
    
    //如果是人员调动组织
    private Integer moveUserId;

	public Integer getMoveUserId() {
		return moveUserId;
	}

	public void setMoveUserId(Integer moveUserId) {
		this.moveUserId = moveUserId;
	}

	public Byte getDealType() {
		return dealType;
	}

	public void setDealType(Byte dealType) {
		this.dealType = dealType;
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

	public Integer getMoveOrgId() {
		return moveOrgId;
	}

	public void setMoveOrgId(Integer moveOrgId) {
		this.moveOrgId = moveOrgId;
	}

    
    
}
