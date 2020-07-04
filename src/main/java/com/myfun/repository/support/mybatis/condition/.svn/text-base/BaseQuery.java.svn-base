package com.myfun.repository.support.mybatis.condition;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.myfun.repository.support.generator.shard.ShardDb;

/**
 * 基础查询类
 * @author ZHL
 */
public class BaseQuery extends ShardDb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private transient String groupByField;// 分组字段
	private transient String orderByField;// 排序字段
	private transient String columns[];// 关键则查询
	private transient String tableName;//表NAME
	/** 自定义条件 */
	private List<ConditionItem> conditions;
	/** 自定义更新项 */
	private List<ConditionItem> updateColumns;
	
	public BaseQuery() {
		
	}
	
	public BaseQuery(Integer shardCityId) {
		super(shardCityId);
	}
	

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@JSONField(serialize=false)
	public String getOrderByField() {
		return orderByField;
	}
	
	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}
	
	@JSONField(serialize=false)
	public String getGroupByField() {
		return groupByField;
	}
	
	public void setGroupByField(String groupByField) {
		this.groupByField = groupByField;
	}
	
	@JSONField(serialize=false)
	public String[] getColumns() {
		return columns;
	}
	
	public void setColumns(String columns[]) {
		this.columns = columns;
	}
	
	public void addCondition(Condition conditions) {
		if(conditions == null || conditions.size() <= 0){
			return;
		}
		addConditionItem(conditions.getCondition());
	}
	
	public void addCondition(String logic, Condition conditions) {
		if(conditions == null || conditions.size() <= 0){
			return;
		}
		addConditionItem(logic, conditions.getCondition());
	}
	
	public void addConditionItem(List<ConditionItem> conditions) {
		addConditionItem(ConditionItem.AND, conditions);
	}
	
	public void addConditionItem(String logic, List<ConditionItem> conditions) {
		if(conditions == null || conditions.size() <= 0)return;
		if(this.conditions == null){
			this.conditions = new LinkedList<ConditionItem>();
		}
		this.conditions.add(new ConditionItem(logic,"(","",""));
		int i=0;
		for (ConditionItem conditionItem : conditions) {
			if(i++ == 0){
				conditionItem.setLogic("");
			}
			this.conditions.add(conditionItem);
		}
		this.conditions.add(new ConditionItem("",")","",""));
	}
	
	public void addConditionItem(ConditionItem conditions) {
		if(this.conditions == null){
			this.conditions = new LinkedList<ConditionItem>();
		}
		this.conditions.add(conditions);
	}
	
	@JSONField(serialize=false)
	public List<ConditionItem> getConditions() {
		return conditions;
	}
	
	@JSONField(serialize=false)
	public List<ConditionItem> getUpdateColumns() {
		return updateColumns;
	}
	
	public void addUpdate(List<ConditionItem> conditions) {
		if(conditions == null || conditions.size() <= 0){return;}
		if(this.updateColumns == null){
			this.updateColumns = new LinkedList<ConditionItem>();
		}
		this.updateColumns.addAll(conditions);
	}
	
	public void addUpdate(ConditionItem conditions) {
		if(this.updateColumns == null){
			this.updateColumns = new LinkedList<ConditionItem>();
		}
		this.updateColumns.add(conditions);
	}
}
