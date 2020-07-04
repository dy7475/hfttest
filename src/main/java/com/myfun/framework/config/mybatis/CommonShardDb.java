package com.myfun.framework.config.mybatis;

import javax.persistence.Transient;

/**
 * 切换数据库基础类 添加分裤标记 注意添加事项<br/> 作用为替代原来的 ShardDb
 * 1,ShardDb变量<br/>
 * 2,SwitchDB 枚举<br/>
 * 3,DBHelper 切换数据库工具类
 * 
 * @ClassName: CommonShardDb
 * @Description: 切换数据库用的标识信息(因framework项目中关于数据库切换标识只认ShardDb)
 * @author jiangsonggui
 * @date 2015年11月13日 下午5:57:21
 *
 */
@Deprecated
public class CommonShardDb {
	
	@Transient
	private Integer shardCityId;
	
	@Transient
	private Integer shardCompId;
	
	@Transient
	private Integer shardArchiveId;
	
	@Transient
	private String shardCompNo;
	
	@Transient
	private String shardConnId;

	@Transient
	private String shardDbName;

	public CommonShardDb() {
	}

	public CommonShardDb(Integer shardCityId) {
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
