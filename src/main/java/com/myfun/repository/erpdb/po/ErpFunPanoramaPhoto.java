package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunPanoramaPhoto extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片ID")
	private Integer photoId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型 1-出售;2-出租")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片地址")
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人")
	private Integer uploadUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传时间")
	private Date uploadDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "场景名称字典值")
	private String scene;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角度")
	private String cfov;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态 0有效 1已删除 4房勘上传审核的  5.美联没有权限的人上传后状态为5【表示审核中】")
	private Byte photoStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "设备编号")
	private String deviceNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "来源 1安卓 2ios")
	private Byte source;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR审核标记 0 未审核 1 审核通过 2 审核失败")
	private Byte vrReviewFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR审核人")
	private Integer vrReviewUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR审核时间")
	private Date vrReviewTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR审核描述")
	private String vrReviewDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传的唯一标识")
	private String uploadClientId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进id")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客服")
	private Integer serviceId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件地址")
	private String fileAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人门店名称")
	private String deptName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=老款好房通定制相机	2=理光相机")
	private Byte cameraType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "场景中文名称")
	private String sceneCn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "室内第几楼")
	private Byte houseInnerFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=全景是房堪上传的，因为PHOTO_STATUS=4的状态会改变，所以增加此字段")
	private Byte fkPanorama;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "保存vr串联坐标")
	private String vrCoordinateJson;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String organizationName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 图片ID
	 */
	public Integer getPhotoId() {
		return photoId;
	}

	/**
	 * @mbggenerated 图片ID
	 */
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
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
	 * @mbggenerated 房源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源类型 1-出售;2-出租
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型 1-出售;2-出租
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 图片地址
	 */
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated 图片地址
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	/**
	 * @mbggenerated 上传人
	 */
	public Integer getUploadUser() {
		return uploadUser;
	}

	/**
	 * @mbggenerated 上传人
	 */
	public void setUploadUser(Integer uploadUser) {
		this.uploadUser = uploadUser;
	}

	/**
	 * @mbggenerated 用户档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 用户档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 上传时间
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @mbggenerated 上传时间
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @mbggenerated 场景名称字典值
	 */
	public String getScene() {
		return scene;
	}

	/**
	 * @mbggenerated 场景名称字典值
	 */
	public void setScene(String scene) {
		this.scene = scene;
	}

	/**
	 * @mbggenerated 角度
	 */
	public String getCfov() {
		return cfov;
	}

	/**
	 * @mbggenerated 角度
	 */
	public void setCfov(String cfov) {
		this.cfov = cfov;
	}

	/**
	 * @mbggenerated 状态 0有效 1已删除 4房勘上传审核的  5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public Byte getPhotoStatus() {
		return photoStatus;
	}

	/**
	 * @mbggenerated 状态 0有效 1已删除 4房勘上传审核的  5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public void setPhotoStatus(Byte photoStatus) {
		this.photoStatus = photoStatus;
	}

	/**
	 * @mbggenerated 设备编号
	 */
	public String getDeviceNum() {
		return deviceNum;
	}

	/**
	 * @mbggenerated 设备编号
	 */
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @mbggenerated 来源 1安卓 2ios
	 */
	public Byte getSource() {
		return source;
	}

	/**
	 * @mbggenerated 来源 1安卓 2ios
	 */
	public void setSource(Byte source) {
		this.source = source;
	}

	/**
	 * @mbggenerated VR审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public Byte getVrReviewFlag() {
		return vrReviewFlag;
	}

	/**
	 * @mbggenerated VR审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public void setVrReviewFlag(Byte vrReviewFlag) {
		this.vrReviewFlag = vrReviewFlag;
	}

	/**
	 * @mbggenerated VR审核人
	 */
	public Integer getVrReviewUid() {
		return vrReviewUid;
	}

	/**
	 * @mbggenerated VR审核人
	 */
	public void setVrReviewUid(Integer vrReviewUid) {
		this.vrReviewUid = vrReviewUid;
	}

	/**
	 * @mbggenerated VR审核时间
	 */
	public Date getVrReviewTime() {
		return vrReviewTime;
	}

	/**
	 * @mbggenerated VR审核时间
	 */
	public void setVrReviewTime(Date vrReviewTime) {
		this.vrReviewTime = vrReviewTime;
	}

	/**
	 * @mbggenerated VR审核描述
	 */
	public String getVrReviewDesc() {
		return vrReviewDesc;
	}

	/**
	 * @mbggenerated VR审核描述
	 */
	public void setVrReviewDesc(String vrReviewDesc) {
		this.vrReviewDesc = vrReviewDesc;
	}

	/**
	 * @mbggenerated 上传的唯一标识
	 */
	public String getUploadClientId() {
		return uploadClientId;
	}

	/**
	 * @mbggenerated 上传的唯一标识
	 */
	public void setUploadClientId(String uploadClientId) {
		this.uploadClientId = uploadClientId;
	}

	/**
	 * @mbggenerated 跟进id
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进id
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated 客服
	 */
	public Integer getServiceId() {
		return serviceId;
	}

	/**
	 * @mbggenerated 客服
	 */
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @mbggenerated 文件地址
	 */
	public String getFileAddr() {
		return fileAddr;
	}

	/**
	 * @mbggenerated 文件地址
	 */
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
	}

	/**
	 * @mbggenerated 上传人门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 上传人门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 上传人门店名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 上传人门店名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @mbggenerated 1=老款好房通定制相机	2=理光相机
	 */
	public Byte getCameraType() {
		return cameraType;
	}

	/**
	 * @mbggenerated 1=老款好房通定制相机	2=理光相机
	 */
	public void setCameraType(Byte cameraType) {
		this.cameraType = cameraType;
	}

	/**
	 * @mbggenerated 场景中文名称
	 */
	public String getSceneCn() {
		return sceneCn;
	}

	/**
	 * @mbggenerated 场景中文名称
	 */
	public void setSceneCn(String sceneCn) {
		this.sceneCn = sceneCn;
	}

	/**
	 * @mbggenerated 室内第几楼
	 */
	public Byte getHouseInnerFloor() {
		return houseInnerFloor;
	}

	/**
	 * @mbggenerated 室内第几楼
	 */
	public void setHouseInnerFloor(Byte houseInnerFloor) {
		this.houseInnerFloor = houseInnerFloor;
	}

	/**
	 * @mbggenerated 1=全景是房堪上传的，因为PHOTO_STATUS=4的状态会改变，所以增加此字段
	 */
	public Byte getFkPanorama() {
		return fkPanorama;
	}

	/**
	 * @mbggenerated 1=全景是房堪上传的，因为PHOTO_STATUS=4的状态会改变，所以增加此字段
	 */
	public void setFkPanorama(Byte fkPanorama) {
		this.fkPanorama = fkPanorama;
	}

	/**
	 * @mbggenerated 保存vr串联坐标
	 */
	public String getVrCoordinateJson() {
		return vrCoordinateJson;
	}

	/**
	 * @mbggenerated 保存vr串联坐标
	 */
	public void setVrCoordinateJson(String vrCoordinateJson) {
		this.vrCoordinateJson = vrCoordinateJson;
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
	 * @mbggenerated -
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPanoramaPhoto() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPanoramaPhoto(Integer shardCityId, Integer photoId) {
		super(shardCityId);
		this.photoId = photoId;
	}
}