package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceFestival extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID   0:国家规定节假日
	 */
	private Integer compId;
	/**
	 * @mbggenerated 考勤组id
	 */
	private Integer attGrId;
	/**
	 * @mbggenerated 特殊考勤日
	 */
	private Date festivalData;
	/**
	 * @mbggenerated 考勤班次ID  -1：休息
	 */
	private Integer attClassId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 0 未删除 1：已删除
	 */
	private Byte isDel;
	/**
	 * @mbggenerated 删除时间
	 */
	private Date delTime;
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
	public Integer getAttGrId() {
		return attGrId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttGrId(Integer attGrId) {
		this.attGrId = attGrId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFestivalData() {
		return festivalData;
	}

	/**
	 * @mbggenerated
	 */
	public void setFestivalData(Date festivalData) {
		this.festivalData = festivalData;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAttClassId() {
		return attClassId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttClassId(Integer attClassId) {
		this.attClassId = attClassId;
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
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceFestival() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceFestival(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}