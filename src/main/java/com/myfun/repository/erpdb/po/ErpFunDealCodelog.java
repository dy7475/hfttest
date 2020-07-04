package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunDealCodelog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键id,自增
	 */
	private Integer codelogId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 编码前缀
	 */
	private String codePrefix;
	/**
	 * @mbggenerated 编码数值
	 */
	private Integer codeCount;
	/**
	 * @mbggenerated 门店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 编码ID
	 */
	private Integer codeId;
	/**
	 * @mbggenerated 编码号
	 */
	private String codeNo;
	/**
	 * @mbggenerated 编码使用状态0代表未使用1代表已使用2被停用
	 */
	private Byte useStatus;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getCodelogId() {
		return codelogId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCodelogId(Integer codelogId) {
		this.codelogId = codelogId;
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
	public String getCodePrefix() {
		return codePrefix;
	}

	/**
	 * @mbggenerated
	 */
	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix == null ? null : codePrefix.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCodeCount() {
		return codeCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCodeCount(Integer codeCount) {
		this.codeCount = codeCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCodeId() {
		return codeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCodeNo() {
		return codeNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo == null ? null : codeNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUseStatus() {
		return useStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseStatus(Byte useStatus) {
		this.useStatus = useStatus;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealCodelog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealCodelog(Integer shardCityId, Integer codelogId) {
		super(shardCityId);
		this.codelogId = codelogId;
	}
}