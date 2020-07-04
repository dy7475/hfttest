package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunBillCode extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "ID")
	private Integer codeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "票据类型0 诚意金 1 出售合同 2 出租合同 3：通用")
	private Byte billType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编码前缀")
	private String codePrefix;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编码开始")
	private String codeStart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编码结束")
	private String codeEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态 0 停用 1启用")
	private Byte status;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人姓名")
	private String userName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总共数量")
	private Integer totalCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "已用数量")
	private Integer usedCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出票方式  0电子票据 1纸质票薄")
	private Byte billWay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated ID
	 */
	public Integer getCodeId() {
		return codeId;
	}

	/**
	 * @mbggenerated ID
	 */
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
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
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 票据类型0 诚意金 1 出售合同 2 出租合同 3：通用
	 */
	public Byte getBillType() {
		return billType;
	}

	/**
	 * @mbggenerated 票据类型0 诚意金 1 出售合同 2 出租合同 3：通用
	 */
	public void setBillType(Byte billType) {
		this.billType = billType;
	}

	/**
	 * @mbggenerated 编码前缀
	 */
	public String getCodePrefix() {
		return codePrefix;
	}

	/**
	 * @mbggenerated 编码前缀
	 */
	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}

	/**
	 * @mbggenerated 编码开始
	 */
	public String getCodeStart() {
		return codeStart;
	}

	/**
	 * @mbggenerated 编码开始
	 */
	public void setCodeStart(String codeStart) {
		this.codeStart = codeStart;
	}

	/**
	 * @mbggenerated 编码结束
	 */
	public String getCodeEnd() {
		return codeEnd;
	}

	/**
	 * @mbggenerated 编码结束
	 */
	public void setCodeEnd(String codeEnd) {
		this.codeEnd = codeEnd;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 状态 0 停用 1启用
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated 状态 0 停用 1启用
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 创建人姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated 创建人姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated 总共数量
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @mbggenerated 总共数量
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @mbggenerated 已用数量
	 */
	public Integer getUsedCount() {
		return usedCount;
	}

	/**
	 * @mbggenerated 已用数量
	 */
	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	/**
	 * @mbggenerated 出票方式  0电子票据 1纸质票薄
	 */
	public Byte getBillWay() {
		return billWay;
	}

	/**
	 * @mbggenerated 出票方式  0电子票据 1纸质票薄
	 */
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBillCode() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBillCode(Integer shardCityId, Integer codeId) {
		super(shardCityId);
		this.codeId = codeId;
	}
}