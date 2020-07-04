package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunProxyTemplate extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 1:带看确认书 2：委托书
	 */
	private Byte templateType;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 模版内容
	 */
	private String templateContent;
	/**
	 * @mbggenerated 101=买卖 102=租赁
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTemplateType() {
		return templateType;
	}

	/**
	 * @mbggenerated
	 */
	public void setTemplateType(Byte templateType) {
		this.templateType = templateType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getTemplateContent() {
		return templateContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent == null ? null : templateContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProxyTemplate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProxyTemplate(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}