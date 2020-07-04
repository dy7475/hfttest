package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpTrackVideo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer videoId;
	/**
	 * @mbggenerated 带看客源信息ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 3求购、4求租
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private Integer houseId;
	/**
	 * @mbggenerated 关联的跟进ID
	 */
	private Integer trackId;
	/**
	 * @mbggenerated 视频URL地址
	 */
	private String videoAddr;
	/**
	 * @mbggenerated
	 */
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	private Integer uploadUser;
	/**
	 * @mbggenerated
	 */
	private Date uploadDate;
	/**
	 * @mbggenerated 视频状态：0：有效
	 */
	private Integer videoStatus;
	/**
	 * @mbggenerated
	 */
	private String locations;
	/**
	 * @mbggenerated 视频拍摄时间
	 */
	private String videoShootingTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getVideoId() {
		return videoId;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated
	 */
	public String getVideoAddr() {
		return videoAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoAddr(String videoAddr) {
		this.videoAddr = videoAddr == null ? null : videoAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr == null ? null : photoAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUploadUser() {
		return uploadUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setUploadUser(Integer uploadUser) {
		this.uploadUser = uploadUser;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUploadDate() {
		return uploadDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getVideoStatus() {
		return videoStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoStatus(Integer videoStatus) {
		this.videoStatus = videoStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getLocations() {
		return locations;
	}

	/**
	 * @mbggenerated
	 */
	public void setLocations(String locations) {
		this.locations = locations == null ? null : locations.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVideoShootingTime() {
		return videoShootingTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoShootingTime(String videoShootingTime) {
		this.videoShootingTime = videoShootingTime == null ? null : videoShootingTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpTrackVideo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpTrackVideo(Integer shardCityId, Integer videoId) {
		super(shardCityId);
		this.videoId = videoId;
	}
}