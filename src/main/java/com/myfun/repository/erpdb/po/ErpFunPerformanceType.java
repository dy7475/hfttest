package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunPerformanceType extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键id,自增") private Integer performanceId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类型名称") private String performanceName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司id") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="排序no") private Integer seqNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否删除 0否、1是 2停用") private Byte isDel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="能否删除：0否、1能 2可以停用") private Integer canDel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩分配比例") private BigDecimal performanceProportion;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否使用该比例分配业绩1=是 0=否") private Byte isAuto;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="英文简称") private String enMsg;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别 1=过户 2=二手房佣金 3=新房佣金 4=租赁租金 5=金融 ") private Byte collectionType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分成项：1房源、2客源、3交易服务、4金融服务") private Byte commissionType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="别名") private String alias;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="能够编辑扩展项 0=可以，1=不可以") private Byte editExtAble;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte canDelete;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte canAdd;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte configAble;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键id,自增
	 */
	public Integer getPerformanceId() {
		return performanceId;
	}

	/**
	 * @mbggenerated 主键id,自增
	 */
	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
	}

	/**
	 * @mbggenerated 业绩类型名称
	 */
	public String getPerformanceName() {
		return performanceName;
	}

	/**
	 * @mbggenerated 业绩类型名称
	 */
	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
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
	 * @mbggenerated 排序no
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 排序no
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	 * @mbggenerated 是否删除 0否、1是 2停用
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除 0否、1是 2停用
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 能否删除：0否、1能 2可以停用
	 */
	public Integer getCanDel() {
		return canDel;
	}

	/**
	 * @mbggenerated 能否删除：0否、1能 2可以停用
	 */
	public void setCanDel(Integer canDel) {
		this.canDel = canDel;
	}

	/**
	 * @mbggenerated 业绩分配比例
	 */
	public BigDecimal getPerformanceProportion() {
		return performanceProportion;
	}

	/**
	 * @mbggenerated 业绩分配比例
	 */
	public void setPerformanceProportion(BigDecimal performanceProportion) {
		this.performanceProportion = performanceProportion;
	}

	/**
	 * @mbggenerated 是否使用该比例分配业绩1=是 0=否
	 */
	public Byte getIsAuto() {
		return isAuto;
	}

	/**
	 * @mbggenerated 是否使用该比例分配业绩1=是 0=否
	 */
	public void setIsAuto(Byte isAuto) {
		this.isAuto = isAuto;
	}

	/**
	 * @mbggenerated 英文简称
	 */
	public String getEnMsg() {
		return enMsg;
	}

	/**
	 * @mbggenerated 英文简称
	 */
	public void setEnMsg(String enMsg) {
		this.enMsg = enMsg;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手房佣金 3=新房佣金 4=租赁租金 5=金融 
	 */
	public Byte getCollectionType() {
		return collectionType;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手房佣金 3=新房佣金 4=租赁租金 5=金融 
	 */
	public void setCollectionType(Byte collectionType) {
		this.collectionType = collectionType;
	}

	/**
	 * @mbggenerated 分成项：1房源、2客源、3交易服务、4金融服务
	 */
	public Byte getCommissionType() {
		return commissionType;
	}

	/**
	 * @mbggenerated 分成项：1房源、2客源、3交易服务、4金融服务
	 */
	public void setCommissionType(Byte commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 * @mbggenerated 别名
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @mbggenerated 别名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @mbggenerated 能够编辑扩展项 0=可以，1=不可以
	 */
	public Byte getEditExtAble() {
		return editExtAble;
	}

	/**
	 * @mbggenerated 能够编辑扩展项 0=可以，1=不可以
	 */
	public void setEditExtAble(Byte editExtAble) {
		this.editExtAble = editExtAble;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getCanDelete() {
		return canDelete;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCanDelete(Byte canDelete) {
		this.canDelete = canDelete;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getCanAdd() {
		return canAdd;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCanAdd(Byte canAdd) {
		this.canAdd = canAdd;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getConfigAble() {
		return configAble;
	}

	/**
	 * @mbggenerated -
	 */
	public void setConfigAble(Byte configAble) {
		this.configAble = configAble;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPerformanceType() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPerformanceType(Integer shardCityId, Integer performanceId) {
		super(shardCityId);
		this.performanceId = performanceId;
	}
}