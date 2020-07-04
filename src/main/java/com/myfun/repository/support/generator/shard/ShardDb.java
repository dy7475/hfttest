package com.myfun.repository.support.generator.shard;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 切换数据库基础类 添加分裤标记 注意添加事项<br/>
 * 1,ShardDb变量<br/>
 * 2,SwitchDB 枚举<br/>
 * 3,DBHelper 切换数据库工具类
 * 
 * @ClassName: ShardDb
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月13日 下午5:57:21
 *
 */
@ApiModel
public class ShardDb {
	@ApiModelProperty(hidden = true)
	private Integer shardCityId;
	@ApiModelProperty(hidden = true)
	private Integer shardCompId;
	@ApiModelProperty(hidden = true)
	private Integer shardArchiveId;
	@ApiModelProperty(hidden = true)
	private String shardCompNo;
	@ApiModelProperty(hidden = true)
	private String shardConnId;
	@ApiModelProperty(hidden = true)
	private String shardDbName;

	public ShardDb() {
	}

	public ShardDb(Integer shardCityId) {
		this.shardCityId = shardCityId;
	}

	public Integer getShardCityId() {
		return shardCityId;
	}

	public void setShardCityId(Integer shardCityId) {
		this.shardCityId = shardCityId;
	}

	public Integer getShardCompId() {
		return shardCompId;
	}

	public void setShardCompId(Integer shardCompId) {
		this.shardCompId = shardCompId;
	}

	public Integer getShardArchiveId() {
		return shardArchiveId;
	}

	public void setShardArchiveId(Integer shardArchiveId) {
		this.shardArchiveId = shardArchiveId;
	}

	public String getShardCompNo() {
		return shardCompNo;
	}

	public void setShardCompNo(String shardCompNo) {
		this.shardCompNo = shardCompNo;
	}

	public String getShardConnId() {
		return shardConnId;
	}

	public void setShardConnId(String shardConnId) {
		this.shardConnId = shardConnId;
	}

	public String getShardDbName() {
		return shardDbName;
	}

	public void setShardDbName(String shardDbName) {
		this.shardDbName = shardDbName;
	}

}
