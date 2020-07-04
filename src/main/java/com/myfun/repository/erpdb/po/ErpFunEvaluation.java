package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;

public class ErpFunEvaluation extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer evalId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId1;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId2;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId3;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId4;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId5;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId6;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId7;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId8;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId9;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stId10;
	/**
	 * @mbggenerated
	 */
	private String evalTime;
	/**
	 * @mbggenerated
	 */
	private Byte evalStatus;
	/**
	 * @mbggenerated
	 */
	private Integer evalUserId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getEvalId() {
		return evalId;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvalId(Integer evalId) {
		this.evalId = evalId;
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
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId1() {
		return stId1;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId1(BigDecimal stId1) {
		this.stId1 = stId1;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId2() {
		return stId2;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId2(BigDecimal stId2) {
		this.stId2 = stId2;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId3() {
		return stId3;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId3(BigDecimal stId3) {
		this.stId3 = stId3;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId4() {
		return stId4;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId4(BigDecimal stId4) {
		this.stId4 = stId4;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId5() {
		return stId5;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId5(BigDecimal stId5) {
		this.stId5 = stId5;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId6() {
		return stId6;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId6(BigDecimal stId6) {
		this.stId6 = stId6;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId7() {
		return stId7;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId7(BigDecimal stId7) {
		this.stId7 = stId7;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId8() {
		return stId8;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId8(BigDecimal stId8) {
		this.stId8 = stId8;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId9() {
		return stId9;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId9(BigDecimal stId9) {
		this.stId9 = stId9;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStId10() {
		return stId10;
	}

	/**
	 * @mbggenerated
	 */
	public void setStId10(BigDecimal stId10) {
		this.stId10 = stId10;
	}

	/**
	 * @mbggenerated
	 */
	public String getEvalTime() {
		return evalTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvalTime(String evalTime) {
		this.evalTime = evalTime == null ? null : evalTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getEvalStatus() {
		return evalStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvalStatus(Byte evalStatus) {
		this.evalStatus = evalStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getEvalUserId() {
		return evalUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvalUserId(Integer evalUserId) {
		this.evalUserId = evalUserId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEvaluation() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEvaluation(Integer shardCityId, Integer evalId) {
		super(shardCityId);
		this.evalId = evalId;
	}
}