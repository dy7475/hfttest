package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * @author czq
 * @since 2018/12/11
 */
public class ErpBuildingSetRoof extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer buildingSetRoofId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "省份ID")
	private Integer provinceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司编号")
	private String compNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋座名称")
	private String buildRoof;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑结构")
	private Integer houseStruct;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑年代")
	private Integer houseYear;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "建筑类型")
	private Integer houseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用途")
	private Integer houseUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "土地年限")
	private Integer buildLandAge;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "土地性质（1出让 2划拨）")
	private Integer buildLandNature;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权力性质")
	private Integer buildRightNature;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋管理员ID")
	private Integer buildingManagerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "栋别名")
	private String buildRoofName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元前缀")
	private String unitPreFix;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元起")
	private String unitSuffixStart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元止")
	private String unitSuffixEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "数字或字母模式(单元)，1=数字，2=字母")
	private Byte inunitSuffixType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层起")
	private Integer floorStart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼层止")
	private Integer floorEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "梯")
	private String buildLadder;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "户")
	private String buildDoors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组成规则 1(无)=户号，2(楼层)=楼层+户号")
	private Byte compriseRule;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "多单元通排")
	private Byte addedByAllUnits;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房号规则 1=按楼层排号，2=按单元排号")
	private Byte numberRule;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组成规则 数字,字母")
	private Byte numberType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元别名")
	private String buildUnitName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "单元数")
	private Integer units;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "户数")
	private Integer doors;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除，1=已删除")
	private Byte delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "数字或字母模式(栋)")
	private Byte roofSuffixType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getBuildingSetRoofId() {
		return buildingSetRoofId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setBuildingSetRoofId(Integer buildingSetRoofId) {
		this.buildingSetRoofId = buildingSetRoofId;
	}

	/**
	 * @mbggenerated 省份ID
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated 省份ID
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	 * @mbggenerated 公司编号
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated 公司编号
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo == null ? null : compNo.trim();
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
	 * @mbggenerated 栋座名称
	 */
	public String getBuildRoof() {
		return buildRoof;
	}

	/**
	 * @mbggenerated 栋座名称
	 */
	public void setBuildRoof(String buildRoof) {
		this.buildRoof = buildRoof == null ? null : buildRoof.trim();
	}

	/**
	 * @mbggenerated 建筑结构
	 */
	public Integer getHouseStruct() {
		return houseStruct;
	}

	/**
	 * @mbggenerated 建筑结构
	 */
	public void setHouseStruct(Integer houseStruct) {
		this.houseStruct = houseStruct;
	}

	/**
	 * @mbggenerated 建筑年代
	 */
	public Integer getHouseYear() {
		return houseYear;
	}

	/**
	 * @mbggenerated 建筑年代
	 */
	public void setHouseYear(Integer houseYear) {
		this.houseYear = houseYear;
	}

	/**
	 * @mbggenerated 建筑类型
	 */
	public Integer getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated 建筑类型
	 */
	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	/**
	 * @mbggenerated 用途
	 */
	public Integer getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated 用途
	 */
	public void setHouseUseage(Integer houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated 土地年限
	 */
	public Integer getBuildLandAge() {
		return buildLandAge;
	}

	/**
	 * @mbggenerated 土地年限
	 */
	public void setBuildLandAge(Integer buildLandAge) {
		this.buildLandAge = buildLandAge;
	}

	/**
	 * @mbggenerated 土地性质（1出让 2划拨）
	 */
	public Integer getBuildLandNature() {
		return buildLandNature;
	}

	/**
	 * @mbggenerated 土地性质（1出让 2划拨）
	 */
	public void setBuildLandNature(Integer buildLandNature) {
		this.buildLandNature = buildLandNature;
	}

	/**
	 * @mbggenerated 权力性质
	 */
	public Integer getBuildRightNature() {
		return buildRightNature;
	}

	/**
	 * @mbggenerated 权力性质
	 */
	public void setBuildRightNature(Integer buildRightNature) {
		this.buildRightNature = buildRightNature;
	}

	/**
	 * @mbggenerated 栋管理员ID
	 */
	public Integer getBuildingManagerId() {
		return buildingManagerId;
	}

	/**
	 * @mbggenerated 栋管理员ID
	 */
	public void setBuildingManagerId(Integer buildingManagerId) {
		this.buildingManagerId = buildingManagerId;
	}

	/**
	 * @mbggenerated 栋别名
	 */
	public String getBuildRoofName() {
		return buildRoofName;
	}

	/**
	 * @mbggenerated 栋别名
	 */
	public void setBuildRoofName(String buildRoofName) {
		this.buildRoofName = buildRoofName == null ? null : buildRoofName.trim();
	}

	/**
	 * @mbggenerated 单元前缀
	 */
	public String getUnitPreFix() {
		return unitPreFix;
	}

	/**
	 * @mbggenerated 单元前缀
	 */
	public void setUnitPreFix(String unitPreFix) {
		this.unitPreFix = unitPreFix == null ? null : unitPreFix.trim();
	}

	/**
	 * @mbggenerated 单元起
	 */
	public String getUnitSuffixStart() {
		return unitSuffixStart;
	}

	/**
	 * @mbggenerated 单元起
	 */
	public void setUnitSuffixStart(String unitSuffixStart) {
		this.unitSuffixStart = unitSuffixStart == null ? null : unitSuffixStart.trim();
	}

	/**
	 * @mbggenerated 单元止
	 */
	public String getUnitSuffixEnd() {
		return unitSuffixEnd;
	}

	/**
	 * @mbggenerated 单元止
	 */
	public void setUnitSuffixEnd(String unitSuffixEnd) {
		this.unitSuffixEnd = unitSuffixEnd == null ? null : unitSuffixEnd.trim();
	}

	/**
	 * @mbggenerated 数字或字母模式(单元)，1=数字，2=字母
	 */
	public Byte getInunitSuffixType() {
		return inunitSuffixType;
	}

	/**
	 * @mbggenerated 数字或字母模式(单元)，1=数字，2=字母
	 */
	public void setInunitSuffixType(Byte inunitSuffixType) {
		this.inunitSuffixType = inunitSuffixType;
	}

	/**
	 * @mbggenerated 楼层起
	 */
	public Integer getFloorStart() {
		return floorStart;
	}

	/**
	 * @mbggenerated 楼层起
	 */
	public void setFloorStart(Integer floorStart) {
		this.floorStart = floorStart;
	}

	/**
	 * @mbggenerated 楼层止
	 */
	public Integer getFloorEnd() {
		return floorEnd;
	}

	/**
	 * @mbggenerated 楼层止
	 */
	public void setFloorEnd(Integer floorEnd) {
		this.floorEnd = floorEnd;
	}

	/**
	 * @mbggenerated 梯
	 */
	public String getBuildLadder() {
		return buildLadder;
	}

	/**
	 * @mbggenerated 梯
	 */
	public void setBuildLadder(String buildLadder) {
		this.buildLadder = buildLadder == null ? null : buildLadder.trim();
	}

	/**
	 * @mbggenerated 户
	 */
	public String getBuildDoors() {
		return buildDoors;
	}

	/**
	 * @mbggenerated 户
	 */
	public void setBuildDoors(String buildDoors) {
		this.buildDoors = buildDoors == null ? null : buildDoors.trim();
	}

	/**
	 * @mbggenerated 组成规则 1(无)=户号，2(楼层)=楼层+户号
	 */
	public Byte getCompriseRule() {
		return compriseRule;
	}

	/**
	 * @mbggenerated 组成规则 1(无)=户号，2(楼层)=楼层+户号
	 */
	public void setCompriseRule(Byte compriseRule) {
		this.compriseRule = compriseRule;
	}

	/**
	 * @mbggenerated 多单元通排
	 */
	public Byte getAddedByAllUnits() {
		return addedByAllUnits;
	}

	/**
	 * @mbggenerated 多单元通排
	 */
	public void setAddedByAllUnits(Byte addedByAllUnits) {
		this.addedByAllUnits = addedByAllUnits;
	}

	/**
	 * @mbggenerated 房号规则 1=按楼层排号，2=按单元排号
	 */
	public Byte getNumberRule() {
		return numberRule;
	}

	/**
	 * @mbggenerated 房号规则 1=按楼层排号，2=按单元排号
	 */
	public void setNumberRule(Byte numberRule) {
		this.numberRule = numberRule;
	}

	/**
	 * @mbggenerated 组成规则 数字,字母
	 */
	public Byte getNumberType() {
		return numberType;
	}

	/**
	 * @mbggenerated 组成规则 数字,字母
	 */
	public void setNumberType(Byte numberType) {
		this.numberType = numberType;
	}

	/**
	 * @mbggenerated 单元别名
	 */
	public String getBuildUnitName() {
		return buildUnitName;
	}

	/**
	 * @mbggenerated 单元别名
	 */
	public void setBuildUnitName(String buildUnitName) {
		this.buildUnitName = buildUnitName == null ? null : buildUnitName.trim();
	}

	/**
	 * @mbggenerated 单元数
	 */
	public Integer getUnits() {
		return units;
	}

	/**
	 * @mbggenerated 单元数
	 */
	public void setUnits(Integer units) {
		this.units = units;
	}

	/**
	 * @mbggenerated 户数
	 */
	public Integer getDoors() {
		return doors;
	}

	/**
	 * @mbggenerated 户数
	 */
	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	/**
	 * @mbggenerated 是否删除，1=已删除
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 是否删除，1=已删除
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated 数字或字母模式(栋)
	 */
	public Byte getRoofSuffixType() {
		return roofSuffixType;
	}

	/**
	 * @mbggenerated 数字或字母模式(栋)
	 */
	public void setRoofSuffixType(Byte roofSuffixType) {
		this.roofSuffixType = roofSuffixType;
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
	 * @mbggenerated 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetRoof() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingSetRoof(Integer shardCityId, Integer buildingSetRoofId) {
		super(shardCityId);
		this.buildingSetRoofId = buildingSetRoofId;
	}


}