package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunSelfbuild extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司id") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘ID") private Integer buildId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘名称") private String buildName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘拼音简写") private String buildCode;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="总栋数") private Integer roofs;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="总户数") private Integer rooms;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="已转入量") private Integer yetIn;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="转售") private Integer changeSale;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="转租") private Integer changeRent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	 * @mbggenerated 楼盘ID
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 楼盘名称
	 */
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated 楼盘名称
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated 楼盘拼音简写
	 */
	public String getBuildCode() {
		return buildCode;
	}

	/**
	 * @mbggenerated 楼盘拼音简写
	 */
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode == null ? null : buildCode.trim();
	}

	/**
	 * @mbggenerated 总栋数
	 */
	public Integer getRoofs() {
		return roofs;
	}

	/**
	 * @mbggenerated 总栋数
	 */
	public void setRoofs(Integer roofs) {
		this.roofs = roofs;
	}

	/**
	 * @mbggenerated 总户数
	 */
	public Integer getRooms() {
		return rooms;
	}

	/**
	 * @mbggenerated 总户数
	 */
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	/**
	 * @mbggenerated 已转入量
	 */
	public Integer getYetIn() {
		return yetIn;
	}

	/**
	 * @mbggenerated 已转入量
	 */
	public void setYetIn(Integer yetIn) {
		this.yetIn = yetIn;
	}

	/**
	 * @mbggenerated 转售
	 */
	public Integer getChangeSale() {
		return changeSale;
	}

	/**
	 * @mbggenerated 转售
	 */
	public void setChangeSale(Integer changeSale) {
		this.changeSale = changeSale;
	}

	/**
	 * @mbggenerated 转租
	 */
	public Integer getChangeRent() {
		return changeRent;
	}

	/**
	 * @mbggenerated 转租
	 */
	public void setChangeRent(Integer changeRent) {
		this.changeRent = changeRent;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSelfbuild() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSelfbuild(Integer shardCityId, Integer compId, Integer buildId) {
		super(shardCityId);
		this.compId = compId;
		this.buildId = buildId;
	}
}