package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpBuildingPhotoKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	private Integer photoId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPhotoId() {
		return photoId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingPhotoKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildingPhotoKey(Integer shardCityId, Short cityId, Integer photoId) {
		super(shardCityId);
		this.cityId = cityId;
		this.photoId = photoId;
	}
}