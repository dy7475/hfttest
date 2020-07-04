package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunContract extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer contractId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人")
	private Integer creationUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "印章位置")
	private String sealPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行高")
	private BigDecimal lineHeight;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否已经编辑   用于区分版本")
	private Byte isEdit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "logo位置")
	private String logoPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板ID")
	private Integer temletId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板名字")
	private String templateName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是新的合同")
	private Byte newFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同模板")
	private String contractContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同正文内容，不含签名的区域")
	private String contractSubContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated ID
	 */
	public Integer getContractId() {
		return contractId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	/**
	 * @mbggenerated 时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public Integer getCreationUid() {
		return creationUid;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setCreationUid(Integer creationUid) {
		this.creationUid = creationUid;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 门店
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 印章位置
	 */
	public String getSealPosition() {
		return sealPosition;
	}

	/**
	 * @mbggenerated 印章位置
	 */
	public void setSealPosition(String sealPosition) {
		this.sealPosition = sealPosition;
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
	 * @mbggenerated 是否已经编辑   用于区分版本
	 */
	public Byte getIsEdit() {
		return isEdit;
	}

	/**
	 * @mbggenerated 是否已经编辑   用于区分版本
	 */
	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	}

	/**
	 * @mbggenerated logo位置
	 */
	public String getLogoPosition() {
		return logoPosition;
	}

	/**
	 * @mbggenerated logo位置
	 */
	public void setLogoPosition(String logoPosition) {
		this.logoPosition = logoPosition;
	}

	/**
	 * @mbggenerated 模板ID
	 */
	public Integer getTemletId() {
		return temletId;
	}

	/**
	 * @mbggenerated 模板ID
	 */
	public void setTemletId(Integer temletId) {
		this.temletId = temletId;
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
	 * @mbggenerated 是否是新的合同
	 */
	public Byte getNewFlag() {
		return newFlag;
	}

	/**
	 * @mbggenerated 是否是新的合同
	 */
	public void setNewFlag(Byte newFlag) {
		this.newFlag = newFlag;
	}

	/**
	 * @mbggenerated 合同模板
	 */
	public String getContractContent() {
		return contractContent;
	}

	/**
	 * @mbggenerated 合同模板
	 */
	public void setContractContent(String contractContent) {
		this.contractContent = contractContent;
	}

	/**
	 * @mbggenerated 合同正文内容，不含签名的区域
	 */
	public String getContractSubContent() {
		return contractSubContent;
	}

	/**
	 * @mbggenerated 合同正文内容，不含签名的区域
	 */
	public void setContractSubContent(String contractSubContent) {
		this.contractSubContent = contractSubContent;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContract() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContract(Integer shardCityId, Integer contractId) {
		super(shardCityId);
		this.contractId = contractId;
	}
}