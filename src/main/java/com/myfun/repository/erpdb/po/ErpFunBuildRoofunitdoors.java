package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunBuildRoofunitdoors extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 对应楼盘id
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 户数
	 */
	private Integer roofs;
	/**
	 * @mbggenerated 单元数
	 */
	private Integer units;
	/**
	 * @mbggenerated 栋数
	 */
	private Integer doors;
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
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
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
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRoofs() {
		return roofs;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoofs(Integer roofs) {
		this.roofs = roofs;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUnits() {
		return units;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnits(Integer units) {
		this.units = units;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDoors() {
		return doors;
	}

	/**
	 * @mbggenerated
	 */
	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildRoofunitdoors() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildRoofunitdoors(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}