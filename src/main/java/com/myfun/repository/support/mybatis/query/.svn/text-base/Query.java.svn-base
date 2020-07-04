package com.myfun.repository.support.mybatis.query;

import com.myfun.repository.support.datasource.SwitchDBType;

/**
 * 查询类封装
 * 
 * @ClassName: Query
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月19日 上午11:54:12
 *
 */
public class Query {
	private String orderBy;
	private Columns columns;
	private Condition condition;

	private Integer shardCompId;
	private Integer shardCityId;
	private Integer shardArchiveId;
	private String shardCompNo;
	private String shardConnId;
	private String shardDbName;

	public Query() {
	}

	public Query(Columns columns, Condition condition, String orderBy) {
		this.columns = columns;
		this.condition = condition;
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Columns getColumns() {
		return columns;
	}

	public void setColumns(Columns columns) {
		this.columns = columns;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Integer getShardCompId() {
		return shardCompId;
	}

	public void setShardCompId(Integer shardCompId) {
		this.shardCompId = shardCompId;
	}

	public Integer getShardCityId() {
		return shardCityId;
	}

	public void setShardCityId(Integer shardCityId) {
		this.shardCityId = shardCityId;
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

	public void getSwithDbType(SwitchDBType switchDBType, Object value) {
		if (shardArchiveId != null) {
			switchDBType = SwitchDBType.ARCHIVE_ID;
			value = getShardArchiveId();
		} else if (shardCityId != null) {
			switchDBType = SwitchDBType.CITY_ID;
			value = getShardCityId();
		} else if (shardCompId != null) {
			switchDBType = SwitchDBType.COMP_ID;
			value = getShardCompId();
		} else if (shardConnId != null) {
			switchDBType = SwitchDBType.CONN_ID;
			value = getShardConnId();
		} else if (shardDbName != null) {
			switchDBType = SwitchDBType.DB_NAME;
			value = getShardDbName();
		}
	}
}
