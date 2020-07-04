package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPartner extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商id，自增")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商名称")
	private String partnerName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信用代码")
	private String enterpriseCreditCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加入时间")
	private Date joinTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "负责人id")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "管理员id")
	private Integer managerUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否已删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除人id")
	private Integer delUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商地址")
	private String partnerAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商电话")
	private String partnerTele;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte plotSwitch;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 加盟商id，自增
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 加盟商id，自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 加盟商名称
	 */
	public String getPartnerName() {
		return partnerName;
	}

	/**
	 * @mbggenerated 加盟商名称
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	/**
	 * @mbggenerated 信用代码
	 */
	public String getEnterpriseCreditCode() {
		return enterpriseCreditCode;
	}

	/**
	 * @mbggenerated 信用代码
	 */
	public void setEnterpriseCreditCode(String enterpriseCreditCode) {
		this.enterpriseCreditCode = enterpriseCreditCode;
	}

	/**
	 * @mbggenerated 加入时间
	 */
	public Date getJoinTime() {
		return joinTime;
	}

	/**
	 * @mbggenerated 加入时间
	 */
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * @mbggenerated 负责人id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 负责人id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 管理员id
	 */
	public Integer getManagerUserId() {
		return managerUserId;
	}

	/**
	 * @mbggenerated 管理员id
	 */
	public void setManagerUserId(Integer managerUserId) {
		this.managerUserId = managerUserId;
	}

	/**
	 * @mbggenerated 是否已删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否已删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 删除人id
	 */
	public Integer getDelUserId() {
		return delUserId;
	}

	/**
	 * @mbggenerated 删除人id
	 */
	public void setDelUserId(Integer delUserId) {
		this.delUserId = delUserId;
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
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 加盟商地址
	 */
	public String getPartnerAddr() {
		return partnerAddr;
	}

	/**
	 * @mbggenerated 加盟商地址
	 */
	public void setPartnerAddr(String partnerAddr) {
		this.partnerAddr = partnerAddr;
	}

	/**
	 * @mbggenerated 加盟商电话
	 */
	public String getPartnerTele() {
		return partnerTele;
	}

	/**
	 * @mbggenerated 加盟商电话
	 */
	public void setPartnerTele(String partnerTele) {
		this.partnerTele = partnerTele;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getPlotSwitch() {
		return plotSwitch;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPlotSwitch(Byte plotSwitch) {
		this.plotSwitch = plotSwitch;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartner() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartner(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}