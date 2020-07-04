package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunVideo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer videoId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型 1=出售，2=出租")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频文件名(MD5)")
	private String videoAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片文件名(MD5)")
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "种子文件地址")
	private String torrentAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频MD5")
	private String videoMd5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频类型 房源：0 小区：1")
	private Byte videoType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态 0是正常，-1是已删除 4房勘上传需要审核的  5.美联没有权限的人上传后状态为5【表示审核中】")
	private Integer videoStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户ID")
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
	@ApiModelProperty(value = "描述")
	private String videoDesc;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "老的视频ID")
	private Integer videoIdOld;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "腾讯视频VID")
	private String txVid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频审核标记 0 未审核 1 审核通过 2 审核失败")
	private Byte videoReviewFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核人")
	private Integer videoReviewUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核时间")
	private Date videoReviewTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超")
	private Byte fileSystemType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用")
	private String fileAddr;
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
	@ApiModelProperty(value = "经度")
	private String lon;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "纬度")
	private String lat;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "定位地址")
	private String location;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频拍摄时间")
	private String videoShootingTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分辨率宽")
	private Integer wideResolution;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分辨率高")
	private Integer highResolution;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频解说人用户ID")
	private Integer narratorUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是解说视频，0=否 1=是")
	private Byte narrateVideo;
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
	@ApiModelProperty(value = "1=视频是房堪上传的，因为VIDEO_STATUS=4的状态会改变，所以增加此字段")
	private Byte fkVideo;
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
	 * @mbggenerated 主键ID
	 */
	public Integer getVideoId() {
		return videoId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
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
	 * @mbggenerated 房源类型 1=出售，2=出租
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型 1=出售，2=出租
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 视频文件名(MD5)
	 */
	public String getVideoAddr() {
		return videoAddr;
	}

	/**
	 * @mbggenerated 视频文件名(MD5)
	 */
	public void setVideoAddr(String videoAddr) {
		this.videoAddr = videoAddr;
	}

	/**
	 * @mbggenerated 图片文件名(MD5)
	 */
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated 图片文件名(MD5)
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	/**
	 * @mbggenerated 种子文件地址
	 */
	public String getTorrentAddr() {
		return torrentAddr;
	}

	/**
	 * @mbggenerated 种子文件地址
	 */
	public void setTorrentAddr(String torrentAddr) {
		this.torrentAddr = torrentAddr;
	}

	/**
	 * @mbggenerated 视频MD5
	 */
	public String getVideoMd5() {
		return videoMd5;
	}

	/**
	 * @mbggenerated 视频MD5
	 */
	public void setVideoMd5(String videoMd5) {
		this.videoMd5 = videoMd5;
	}

	/**
	 * @mbggenerated 视频类型 房源：0 小区：1
	 */
	public Byte getVideoType() {
		return videoType;
	}

	/**
	 * @mbggenerated 视频类型 房源：0 小区：1
	 */
	public void setVideoType(Byte videoType) {
		this.videoType = videoType;
	}

	/**
	 * @mbggenerated 状态 0是正常，-1是已删除 4房勘上传需要审核的  5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public Integer getVideoStatus() {
		return videoStatus;
	}

	/**
	 * @mbggenerated 状态 0是正常，-1是已删除 4房勘上传需要审核的  5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public void setVideoStatus(Integer videoStatus) {
		this.videoStatus = videoStatus;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public Integer getUploadUser() {
		return uploadUser;
	}

	/**
	 * @mbggenerated 用户ID
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
	 * @mbggenerated 描述
	 */
	public String getVideoDesc() {
		return videoDesc;
	}

	/**
	 * @mbggenerated 描述
	 */
	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	/**
	 * @mbggenerated 老的视频ID
	 */
	public Integer getVideoIdOld() {
		return videoIdOld;
	}

	/**
	 * @mbggenerated 老的视频ID
	 */
	public void setVideoIdOld(Integer videoIdOld) {
		this.videoIdOld = videoIdOld;
	}

	/**
	 * @mbggenerated 腾讯视频VID
	 */
	public String getTxVid() {
		return txVid;
	}

	/**
	 * @mbggenerated 腾讯视频VID
	 */
	public void setTxVid(String txVid) {
		this.txVid = txVid;
	}

	/**
	 * @mbggenerated 视频审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public Byte getVideoReviewFlag() {
		return videoReviewFlag;
	}

	/**
	 * @mbggenerated 视频审核标记 0 未审核 1 审核通过 2 审核失败
	 */
	public void setVideoReviewFlag(Byte videoReviewFlag) {
		this.videoReviewFlag = videoReviewFlag;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public Integer getVideoReviewUid() {
		return videoReviewUid;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public void setVideoReviewUid(Integer videoReviewUid) {
		this.videoReviewUid = videoReviewUid;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public Date getVideoReviewTime() {
		return videoReviewTime;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setVideoReviewTime(Date videoReviewTime) {
		this.videoReviewTime = videoReviewTime;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public Byte getFileSystemType() {
		return fileSystemType;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public void setFileSystemType(Byte fileSystemType) {
		this.fileSystemType = fileSystemType;
	}

	/**
	 * @mbggenerated 文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用
	 */
	public String getFileAddr() {
		return fileAddr;
	}

	/**
	 * @mbggenerated 文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用
	 */
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
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
	 * @mbggenerated 经度
	 */
	public String getLon() {
		return lon;
	}

	/**
	 * @mbggenerated 经度
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 * @mbggenerated 纬度
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @mbggenerated 纬度
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @mbggenerated 定位地址
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @mbggenerated 定位地址
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @mbggenerated 视频拍摄时间
	 */
	public String getVideoShootingTime() {
		return videoShootingTime;
	}

	/**
	 * @mbggenerated 视频拍摄时间
	 */
	public void setVideoShootingTime(String videoShootingTime) {
		this.videoShootingTime = videoShootingTime;
	}

	/**
	 * @mbggenerated 分辨率宽
	 */
	public Integer getWideResolution() {
		return wideResolution;
	}

	/**
	 * @mbggenerated 分辨率宽
	 */
	public void setWideResolution(Integer wideResolution) {
		this.wideResolution = wideResolution;
	}

	/**
	 * @mbggenerated 分辨率高
	 */
	public Integer getHighResolution() {
		return highResolution;
	}

	/**
	 * @mbggenerated 分辨率高
	 */
	public void setHighResolution(Integer highResolution) {
		this.highResolution = highResolution;
	}

	/**
	 * @mbggenerated 视频解说人用户ID
	 */
	public Integer getNarratorUid() {
		return narratorUid;
	}

	/**
	 * @mbggenerated 视频解说人用户ID
	 */
	public void setNarratorUid(Integer narratorUid) {
		this.narratorUid = narratorUid;
	}

	/**
	 * @mbggenerated 是否是解说视频，0=否 1=是
	 */
	public Byte getNarrateVideo() {
		return narrateVideo;
	}

	/**
	 * @mbggenerated 是否是解说视频，0=否 1=是
	 */
	public void setNarrateVideo(Byte narrateVideo) {
		this.narrateVideo = narrateVideo;
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
	 * @mbggenerated 1=视频是房堪上传的，因为VIDEO_STATUS=4的状态会改变，所以增加此字段
	 */
	public Byte getFkVideo() {
		return fkVideo;
	}

	/**
	 * @mbggenerated 1=视频是房堪上传的，因为VIDEO_STATUS=4的状态会改变，所以增加此字段
	 */
	public void setFkVideo(Byte fkVideo) {
		this.fkVideo = fkVideo;
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
	public ErpFunVideo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunVideo(Integer shardCityId, Integer videoId) {
		super(shardCityId);
		this.videoId = videoId;
	}
}