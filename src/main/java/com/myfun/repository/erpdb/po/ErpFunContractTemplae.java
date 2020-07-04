package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunContractTemplae extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板ID")
	private Integer templateId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板名字")
	private String templateName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板类型 101=买卖合同 102=租赁合同 105=合同补充协议")
	private Byte templateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "新建人公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板删除状态 1:正常 0 删除")
	private Byte templateStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行高")
	private BigDecimal lineHeight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是优家模板，优家合同需要审核的则查询这个标记为1的模板，不管公司模板")
	private Byte isYoujiaTemplate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统模板")
	private Integer isSysModel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer sysTemplateId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1:合同 2:协议 3居间 4:配套")
	private Byte contentType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板内容")
	private String templateContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String contractSubContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 模板ID
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @mbggenerated 模板ID
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @mbggenerated 模板名字
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @mbggenerated 模板名字
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 模板类型 101=买卖合同 102=租赁合同 105=合同补充协议
	 */
	public Byte getTemplateType() {
		return templateType;
	}

	/**
	 * @mbggenerated 模板类型 101=买卖合同 102=租赁合同 105=合同补充协议
	 */
	public void setTemplateType(Byte templateType) {
		this.templateType = templateType;
	}

	/**
	 * @mbggenerated 新建人公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 新建人公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 模板删除状态 1:正常 0 删除
	 */
	public Byte getTemplateStatus() {
		return templateStatus;
	}

	/**
	 * @mbggenerated 模板删除状态 1:正常 0 删除
	 */
	public void setTemplateStatus(Byte templateStatus) {
		this.templateStatus = templateStatus;
	}

	/**
	 * @mbggenerated 行高
	 */
	public BigDecimal getLineHeight() {
		return lineHeight;
	}

	/**
	 * @mbggenerated 行高
	 */
	public void setLineHeight(BigDecimal lineHeight) {
		this.lineHeight = lineHeight;
	}

	/**
	 * @mbggenerated 是否是优家模板，优家合同需要审核的则查询这个标记为1的模板，不管公司模板
	 */
	public Byte getIsYoujiaTemplate() {
		return isYoujiaTemplate;
	}

	/**
	 * @mbggenerated 是否是优家模板，优家合同需要审核的则查询这个标记为1的模板，不管公司模板
	 */
	public void setIsYoujiaTemplate(Byte isYoujiaTemplate) {
		this.isYoujiaTemplate = isYoujiaTemplate;
	}

	/**
	 * @mbggenerated 系统模板
	 */
	public Integer getIsSysModel() {
		return isSysModel;
	}

	/**
	 * @mbggenerated 系统模板
	 */
	public void setIsSysModel(Integer isSysModel) {
		this.isSysModel = isSysModel;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getSysTemplateId() {
		return sysTemplateId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSysTemplateId(Integer sysTemplateId) {
		this.sysTemplateId = sysTemplateId;
	}

	/**
	 * @mbggenerated 1:合同 2:协议 3居间 4:配套
	 */
	public Byte getContentType() {
		return contentType;
	}

	/**
	 * @mbggenerated 1:合同 2:协议 3居间 4:配套
	 */
	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 模板内容
	 */
	public String getTemplateContent() {
		return templateContent;
	}

	/**
	 * @mbggenerated 模板内容
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	/**
	 * @mbggenerated -
	 */
	public String getContractSubContent() {
		return contractSubContent;
	}

	/**
	 * @mbggenerated -
	 */
	public void setContractSubContent(String contractSubContent) {
		this.contractSubContent = contractSubContent;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractTemplae() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractTemplae(Integer shardCityId, Integer templateId) {
		super(shardCityId);
		this.templateId = templateId;
	}
}