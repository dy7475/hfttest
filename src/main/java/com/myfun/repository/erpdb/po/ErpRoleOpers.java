package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

public class ErpRoleOpers extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色ID") private String roleId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="权限ID") private String operId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否高级权限，1=是0=否") private Boolean operType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="专业版权限，1=是0=否") private Boolean proRole;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="物业版权限 1=是 0=否") private Boolean wyRole;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="营销版权限，1=是0=否 ") private Boolean smpRole;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte partnerOper;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 角色ID
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @mbggenerated 权限ID
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * @mbggenerated 权限ID
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * @mbggenerated 是否高级权限，1=是0=否
	 */
	public Boolean getOperType() {
		return operType;
	}

	/**
	 * @mbggenerated 是否高级权限，1=是0=否
	 */
	public void setOperType(Boolean operType) {
		this.operType = operType;
	}

	/**
	 * @mbggenerated 专业版权限，1=是0=否
	 */
	public Boolean getProRole() {
		return proRole;
	}

	/**
	 * @mbggenerated 专业版权限，1=是0=否
	 */
	public void setProRole(Boolean proRole) {
		this.proRole = proRole;
	}

	/**
	 * @mbggenerated 物业版权限 1=是 0=否
	 */
	public Boolean getWyRole() {
		return wyRole;
	}

	/**
	 * @mbggenerated 物业版权限 1=是 0=否
	 */
	public void setWyRole(Boolean wyRole) {
		this.wyRole = wyRole;
	}

	/**
	 * @mbggenerated 营销版权限，1=是0=否 
	 */
	public Boolean getSmpRole() {
		return smpRole;
	}

	/**
	 * @mbggenerated 营销版权限，1=是0=否 
	 */
	public void setSmpRole(Boolean smpRole) {
		this.smpRole = smpRole;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getPartnerOper() {
		return partnerOper;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPartnerOper(Byte partnerOper) {
		this.partnerOper = partnerOper;
	}

	/**
	 * @mbggenerated
	 */
	public ErpRoleOpers() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpRoleOpers(Integer shardCityId, String roleId, String operId) {
		super(shardCityId);
		this.roleId = roleId;
		this.operId = operId;
	}
}