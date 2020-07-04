package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpCheckInRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人 userId")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人城市Id")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人公司")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人部门")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人分组")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人归档id")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备类型 ，1：android，2：ios")
	private Byte deviceType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经度")
	private String longi;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "纬度")
	private String lati;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片路径")
	private String photoPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签到备注")
	private String checkInDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "位置描述")
	private String locationDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签到时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备Id")
	private String deviceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备名称，iPhone 7，xiaomi 6")
	private String deviceName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人大区id")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人regid")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签到详细地址")
	private String locationDetail;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "外出id，关联外出日志")
	private Integer outId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 经纪人 userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人 userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 经纪人城市Id
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 经纪人城市Id
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 经纪人公司
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 经纪人公司
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 经纪人部门
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 经纪人部门
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 经纪人分组
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 经纪人分组
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 经纪人归档id
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 经纪人归档id
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 设备类型 ，1：android，2：ios
	 */
	public Byte getDeviceType() {
		return deviceType;
	}

	/**
	 * @mbggenerated 设备类型 ，1：android，2：ios
	 */
	public void setDeviceType(Byte deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @mbggenerated 经度
	 */
	public String getLongi() {
		return longi;
	}

	/**
	 * @mbggenerated 经度
	 */
	public void setLongi(String longi) {
		this.longi = longi;
	}

	/**
	 * @mbggenerated 纬度
	 */
	public String getLati() {
		return lati;
	}

	/**
	 * @mbggenerated 纬度
	 */
	public void setLati(String lati) {
		this.lati = lati;
	}

	/**
	 * @mbggenerated 图片路径
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @mbggenerated 图片路径
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @mbggenerated 签到备注
	 */
	public String getCheckInDesc() {
		return checkInDesc;
	}

	/**
	 * @mbggenerated 签到备注
	 */
	public void setCheckInDesc(String checkInDesc) {
		this.checkInDesc = checkInDesc;
	}

	/**
	 * @mbggenerated 位置描述
	 */
	public String getLocationDesc() {
		return locationDesc;
	}

	/**
	 * @mbggenerated 位置描述
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	/**
	 * @mbggenerated 签到时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 签到时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 设备Id
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @mbggenerated 设备Id
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @mbggenerated 设备名称，iPhone 7，xiaomi 6
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @mbggenerated 设备名称，iPhone 7，xiaomi 6
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @mbggenerated 经纪人大区id
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 经纪人大区id
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 经纪人regid
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 经纪人regid
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 签到详细地址
	 */
	public String getLocationDetail() {
		return locationDetail;
	}

	/**
	 * @mbggenerated 签到详细地址
	 */
	public void setLocationDetail(String locationDetail) {
		this.locationDetail = locationDetail;
	}

	/**
	 * @mbggenerated 外出id，关联外出日志
	 */
	public Integer getOutId() {
		return outId;
	}

	/**
	 * @mbggenerated 外出id，关联外出日志
	 */
	public void setOutId(Integer outId) {
		this.outId = outId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpCheckInRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpCheckInRecord(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}