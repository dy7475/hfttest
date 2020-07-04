package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

public class ErpSysPara extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID,0=企业版模板 5=物业版模板,-1=房基地模板；如果是标准版和房基地都需要的系统参数，则COMP_ID=0和COMP_ID=-1的模板都要插一条")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "参数Id")
	private String paramId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID-加盟商自行管理时，需要查询所属加盟商的配置")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "参数值。新版组织模式下：部分系统参数保存的是组织定义表的层级ID，如果是全部该值为：0")
	private String paramValue;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "参数类型")
	private String paramType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "普通管控默认值")
	private String defaultValue;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "参数说明")
	private String paramDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否需要重新登录，0=不踢人 1：踢人 2：从1->0不踢人，从0->1要踢人 3：是从1->0踢人，从0->1不踢人")
	private Byte needRelogin;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "中级管控默认值")
	private String mediumValue;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "强管控默认值")
	private String seniorValue;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构版本 不为空并且=1 为新版的组合参数，单个参数的通用")
	private Byte organizationType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "参数值对应的管理层级")
	private Integer paramValueDefId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "普通管控默认对应的管理层级")
	private Integer defaultValueDefId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "中度管控默认对应的管理层级")
	private Integer mediumValueDefId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "强度管控默认对应的管理层级")
	private Integer seniorValueDefId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "策略参数是控制到组织的")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 公司ID,0=企业版模板 5=物业版模板,-1=房基地模板；如果是标准版和房基地都需要的系统参数，则COMP_ID=0和COMP_ID=-1的模板都要插一条
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID,0=企业版模板 5=物业版模板,-1=房基地模板；如果是标准版和房基地都需要的系统参数，则COMP_ID=0和COMP_ID=-1的模板都要插一条
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 参数Id
	 */
	public String getParamId() {
		return paramId;
	}

	/**
	 * @mbggenerated 参数Id
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	/**
	 * @mbggenerated 加盟商ID-加盟商自行管理时，需要查询所属加盟商的配置
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated 加盟商ID-加盟商自行管理时，需要查询所属加盟商的配置
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated 参数值。新版组织模式下：部分系统参数保存的是组织定义表的层级ID，如果是全部该值为：0
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * @mbggenerated 参数值。新版组织模式下：部分系统参数保存的是组织定义表的层级ID，如果是全部该值为：0
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 * @mbggenerated 参数类型
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * @mbggenerated 参数类型
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * @mbggenerated 普通管控默认值
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * @mbggenerated 普通管控默认值
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	/**
	 * @mbggenerated 参数说明
	 */
	public String getParamDesc() {
		return paramDesc;
	}

	/**
	 * @mbggenerated 参数说明
	 */
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	/**
	 * @mbggenerated 是否需要重新登录，0=不踢人 1：踢人 2：从1->0不踢人，从0->1要踢人 3：是从1->0踢人，从0->1不踢人
	 */
	public Byte getNeedRelogin() {
		return needRelogin;
	}

	/**
	 * @mbggenerated 是否需要重新登录，0=不踢人 1：踢人 2：从1->0不踢人，从0->1要踢人 3：是从1->0踢人，从0->1不踢人
	 */
	public void setNeedRelogin(Byte needRelogin) {
		this.needRelogin = needRelogin;
	}

	/**
	 * @mbggenerated 中级管控默认值
	 */
	public String getMediumValue() {
		return mediumValue;
	}

	/**
	 * @mbggenerated 中级管控默认值
	 */
	public void setMediumValue(String mediumValue) {
		this.mediumValue = mediumValue;
	}

	/**
	 * @mbggenerated 强管控默认值
	 */
	public String getSeniorValue() {
		return seniorValue;
	}

	/**
	 * @mbggenerated 强管控默认值
	 */
	public void setSeniorValue(String seniorValue) {
		this.seniorValue = seniorValue;
	}

	/**
	 * @mbggenerated 组织机构版本 不为空并且=1 为新版的组合参数，单个参数的通用
	 */
	public Byte getOrganizationType() {
		return organizationType;
	}

	/**
	 * @mbggenerated 组织机构版本 不为空并且=1 为新版的组合参数，单个参数的通用
	 */
	public void setOrganizationType(Byte organizationType) {
		this.organizationType = organizationType;
	}

	/**
	 * @mbggenerated 参数值对应的管理层级
	 */
	public Integer getParamValueDefId() {
		return paramValueDefId;
	}

	/**
	 * @mbggenerated 参数值对应的管理层级
	 */
	public void setParamValueDefId(Integer paramValueDefId) {
		this.paramValueDefId = paramValueDefId;
	}

	/**
	 * @mbggenerated 普通管控默认对应的管理层级
	 */
	public Integer getDefaultValueDefId() {
		return defaultValueDefId;
	}

	/**
	 * @mbggenerated 普通管控默认对应的管理层级
	 */
	public void setDefaultValueDefId(Integer defaultValueDefId) {
		this.defaultValueDefId = defaultValueDefId;
	}

	/**
	 * @mbggenerated 中度管控默认对应的管理层级
	 */
	public Integer getMediumValueDefId() {
		return mediumValueDefId;
	}

	/**
	 * @mbggenerated 中度管控默认对应的管理层级
	 */
	public void setMediumValueDefId(Integer mediumValueDefId) {
		this.mediumValueDefId = mediumValueDefId;
	}

	/**
	 * @mbggenerated 强度管控默认对应的管理层级
	 */
	public Integer getSeniorValueDefId() {
		return seniorValueDefId;
	}

	/**
	 * @mbggenerated 强度管控默认对应的管理层级
	 */
	public void setSeniorValueDefId(Integer seniorValueDefId) {
		this.seniorValueDefId = seniorValueDefId;
	}

	/**
	 * @mbggenerated 策略参数是控制到组织的
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 策略参数是控制到组织的
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpSysPara() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpSysPara(Integer shardCityId, Integer compId, String paramId, Integer partnerId) {
		super(shardCityId);
		this.compId = compId;
		this.paramId = paramId;
		this.partnerId = partnerId;
	}
}