
package com.myfun.repository.support.mybatis.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.myfun.repository.support.datasource.SwitchDBType;

/**
 * 此方法不支持预编译 尽量少使用
 * 
 * @ClassName: Condition
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月19日 上午12:00:26
 *
 */
public class Condition {

	/* 所有条件单项 */
	private List<Object> conditions = new ArrayList<Object>();

	/** 逻辑操作符，与(AND) */
	public final static String AND = "AND";
	/** 逻辑操作符, 或(OR) */
	public final static String OR = "OR";
	/** 逻辑操作符, 与非(AND NOT) */
	public final static String AND_NOT = "AND NOT";
	/** 逻辑操作符,或非(AND NOT) */
	public final static String OR_NOT = "OR NOT";

	private Condition condition = this;

	private Integer shardCompId;
	private Integer shardCityId;
	private Integer shardArchiveId;
	private String shardCompNo;
	private String shardConnId;
	private String shardDbName;
	/*
	 * 在构建SQL条件时可用到的所有“逻辑运算符号”
	 */
	private static String[] LOGIC_OPERATOR_SIGNS = { AND, OR, AND_NOT, OR_NOT };

	/*
	 * 检查是否有效的逻辑运算符
	 * 
	 * @param oprtor
	 * 
	 * @return true,是
	 */
	private boolean isValidLogicOperator(String oprtor) {
		for (int i = 0; i < LOGIC_OPERATOR_SIGNS.length; i++) {
			if (LOGIC_OPERATOR_SIGNS[i].equalsIgnoreCase(oprtor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 清除所有条件项
	 */
	public void clear() {
		conditions.clear();
	}

	/**
	 * 返回条件项的数量
	 * 
	 * @return 条件项数量
	 */
	public int size() {
		return conditions.size();
	}

	/**
	 * 加入一条件单项
	 * 
	 * @param logicOperator
	 *            两条件项之间的逻辑运算符, AND, OR, AND NOT, OR NOT
	 * @param item
	 *            条件单项
	 */
	public void add(String logicOperator, ConditionItem item) {
		logicOperator = logicOperator.trim().toUpperCase();
		if (!isValidLogicOperator(logicOperator)) {
			throw new IllegalArgumentException("不合法的逻辑运算符, 正确的逻辑运算符是:AND, OR, AND NOT, OR NOT");
		}
		conditions.add(new Object[] { logicOperator, item });
	}

	/**
	 * 加入一条件单项,默认逻辑运算符为 AND
	 * 
	 * @param item
	 *            条件单项
	 */
	public void add(ConditionItem item) {
		add(AND, item);
	}

	/**
	 * 加入一子条件
	 * 
	 * @param logicOperator
	 *            两条件项之间的逻辑运算符, AND, OR, AND NOT, OR NOT
	 * @param condition
	 *            子条件
	 */
	public void add(String logicOperator, Condition condition) {
		conditions.add(new Object[] { logicOperator, condition });
	}

	/**
	 * 加入一子条件,默认逻辑运算符为 AND
	 * 
	 * @param condition
	 *            子条件
	 */
	public void add(Condition condition) {
		conditions.add(new Object[] { AND, condition });
	}

	public StringBuilder getConditionStatement() {
		return getConditionStatement(0);
	}
	

	/**
	 * 返回查询条件
	 * 
	 * @return 条件串
	 */
	public StringBuilder getConditionStatement(int isQuote) {
		Iterator<Object> conditionsIT = conditions.iterator();
		StringBuilder whereStr = new StringBuilder();
		while (conditionsIT.hasNext()) {
			Object[] CondiItem = (Object[]) conditionsIT.next();
			String logicOperator = (String) CondiItem[0];
			if (whereStr.length() == 0) {
				if (logicOperator.equals(AND) || logicOperator.equals(OR)) {
					logicOperator = "";
				} else if (logicOperator.equals(AND_NOT) || logicOperator.equals(OR_NOT)) {
					logicOperator = "NOT";
				}
			}
			logicOperator = (whereStr.length() == 0 && (logicOperator.equals(AND) || logicOperator.equals(OR))) ? "" : logicOperator;
			if (CondiItem[1] instanceof ConditionItem) {
				ConditionItem item = (ConditionItem) CondiItem[1];
				whereStr.append(logicOperator).append(" ").append(item.getConditionItemStatement(isQuote));
			} else {
				Condition condition = (Condition) CondiItem[1];
				StringBuilder subCondnStr = condition.getConditionStatement(isQuote);
				if (subCondnStr.length() > 0) {
					whereStr.append(logicOperator).append(" (").append(subCondnStr).append(") ");
				}
			}
		}
		return whereStr;
	}

	/**
	 * 返回所有条件表达式的值数组
	 * 
	 * @return 条件值
	 */
	public Object[] getValues() {
		List<Object> values = new ArrayList<Object>();
		int itemLen = conditions.size();
		for (int ii = 0; ii < itemLen; ii++) {
			Object[] CondiItem = (Object[]) conditions.get(ii);
			if (CondiItem[1] instanceof ConditionItem) {
				ConditionItem item = (ConditionItem) CondiItem[1];
				Object[] objs = item.getValues();
				if (objs != null) {
					int len = objs.length;
					for (int i = 0; i < len; i++) {
						values.add(objs[i]);
					}
				}
			} else {
				Condition condition = (Condition) CondiItem[1];
				Object[] objs = condition.getValues();
				if (objs != null) {
					int len = objs.length;
					for (int i = 0; i < len; i++) {
						values.add(objs[i]);
					}
				}
			}
		}
		return values.toArray();
	}

	/**
	 * 返回所有条件表达式的值缓冲
	 * 
	 * @return ObjectBuffered类型的条件值缓冲对象
	 */
	public StringBuilder getValueBuffered() {
		StringBuilder values = new StringBuilder();
		int len = conditions.size();
		for (int i = 0; i < len; i++) {
			Object[] CondiItem = (Object[]) conditions.get(i);
			if (CondiItem[1] instanceof ConditionItem) {
				ConditionItem item = (ConditionItem) CondiItem[1];
				StringBuilder sqlValues = item.getSQLValues();
				if (sqlValues != null) {
					values.append(sqlValues);
				} else {
					Object[] condValues = item.getValues();
					if (condValues != null) {
						values.append(condValues);
					}
				}
			} else {
				Condition condition = (Condition) CondiItem[1];
				StringBuilder condValues = condition.getValueBuffered();
				if (condValues != null) {
					values.append(condValues);
				}
			}
		}
		return values;
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

	@Override
	public String toString() {
		return getConditionStatement().toString();
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

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
		
	}
	public static void main(String[] args) {
		Condition condition = new Condition();
		condition.add(new ConditionItem("COMP_ID","=","12001"));
		condition.add(new ConditionItem("DEPT_ID","=","12001"));
		System.out.println(condition.getConditionStatement(1));
		
	}

}
