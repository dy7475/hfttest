/*
 * ConditionItem.java	2005-7-16
 *
 * 版权所有: 自由思考组织(FTO)软件团队 2000-2005, 保留所有权利.
 * 这个软件是自由思考组织(FTO)软件团队开发的，如果要使用这个软件，请首先阅读并接受许可协议。
 *
 * Copyright 2000-2005 FTO Software Team, Inc. All Rights Reserved.
 * This software is the proprietary information of FTO Software Team, Inc.
 * Use is subject to license terms.
 *
 * FTO站点：http://www.free-think.org
 */
package com.myfun.repository.support.mybatis.query;

import java.util.Date;

import com.myfun.utils.BaseUtil;
import com.myfun.utils.DateUtil;

/**
 * 不支持预编译尽量少试用
 * 
 * @ClassName: ConditionItem
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月19日 上午12:01:06
 *
 */
public class ConditionItem implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * 在构建SQL条件单项时用到的运算符号: "=", ">=", "<=", ">", "<", "<>", "!=", "LIKE",
	 * "NOT LIKE" ,"IS"
	 */
	private final static String[] OPERATOR_SIGNS_SINGLE = { "=", ">=", "<=", ">", "<", "<>", "!=", "LIKE", "NOT LIKE", "IS" };

	/* 在构建SQL条件单项时用到的运算符号: "Between","NOT Between", "IN", "NOT IN" */
	private final static String[] OPERATOR_SIGNS_MORE = { "Between", "NOT Between", "IN", "NOT IN" };
	/* 在构建SQL条件单项时用到的运算符号: "Between","NOT Between" */
	private final static String[] OPERATOR_SIGNS_BETWEEN = { "Between", "NOT Between" };
	/* 在构建SQL条件单项时用到的运算符号: "IN", "NOT IN" */
	private final static String[] OPERATOR_SIGNS_IN = { "IN", "NOT IN" };
	private String name;
	private String operator;
	private Object[] values;
	private boolean isQuote = false;

	/**
	 * 构造方法, 创建条件单项
	 * 
	 * @param name
	 *            列名称
	 * @param operator
	 *            条件运算符,合法的运算符有: "=", ">=", "<=", ">", "<", "<>", "!=", "LIKE",
	 *            "NOT LIKE","IS"
	 * @param value
	 *            条件值,可以是串类型,或其它能正确转换为数据库数据类型的JAVA类类型
	 */
	public ConditionItem(String name, String operator, Object value) {
		this(name, operator, value, false);
	}

	/**
	 * 构造方法, 创建条件单项
	 * 
	 * @param name
	 *            列名称
	 * @param operator
	 *            条件运算符,合法的运算符有: "=", ">=", "<=", ">", "<", "<>", "!=", "LIKE",
	 *            "NOT LIKE","IS"
	 * @param value
	 *            条件值,可以是串类型,或其它能正确转换为数据库数据类型的JAVA类类型
	 * @param isQuote
	 *            是否是直接引用条件值, 如果是，将会把整个条件项构建为SQL串，而不会将值用？号替换
	 */
	public ConditionItem(String name, String operator, Object value, boolean isQuote) {
		if (!isValidOperator(OPERATOR_SIGNS_SINGLE, operator)) {
			throw new IllegalArgumentException("不合法的条件运算符, 正确的条件运算符是: =, >=, <=, >, <, <>, !=, LIKE, NOT LIKE, IS");
		}

		this.name = name;
		this.operator = operator;
		this.values = new Object[] { value };
		if (operator.equalsIgnoreCase("IS")) {
			this.isQuote = isQuote;
			String v = ((String) value).trim();
			if (!(v.equalsIgnoreCase("NULL") || v.equalsIgnoreCase("NOT NULL"))) {
				throw new IllegalArgumentException("如果运算符是IS, 条件值只能是: NULL或NOT NULL");
			}
		} else {
			this.isQuote = isQuote;
		}
	}

	/**
	 * 构造方法, 创建条件单项
	 * 
	 * @param name
	 *            列名称
	 * @param operator
	 *            条件运算符,合法的运算符有: Between,NOT Between, IN, NOT IN
	 * @param values
	 *            条件值数组,数组值可以是串类型,或其它能正确转换为数据库数据类型的JAVA类类型,
	 *            注意:数据组的长度与条件运算符operator有一定关系,如果运算符是Between,
	 *            values数组的值必须是2个,如果运算符是IN,values数组的值至少有1个
	 */
	public ConditionItem(String name, String operator, Object[] values) {
		if (values.length == 0) {
			throw new IllegalArgumentException("不能没有条件值！");
		}
		operator = operator.trim();
		if (!isValidOperator(OPERATOR_SIGNS_MORE, operator)) {
			throw new IllegalArgumentException("不合法的条件运算符, 正确的条件运算符是: Between,NOT Between, IN, NOT IN");
		}

		if (isValidOperator(OPERATOR_SIGNS_BETWEEN, operator)) {
			if (values.length != 2) {
				throw new IllegalArgumentException("不合法的条件值数量，Between,Not Between操作的条件值数量必须为2！");
			}
		}

		this.name = name;
		this.operator = operator;
		this.values = values;
	}

	/**
	 * 返回条件单项列名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 返回条件单项运算符号
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 返回所有条件值数组, 如果没有，返回null
	 */
	public Object[] getValues() {
		if (isQuote) {
			return null;
		}
		return values;
	}

	/**
	 * 返回SQL子查询中的值对象, 如果返回为null, 请使用getValues返回值数组,
	 * 此方法主要是用于当条件值为SQL时，直接返回ObjectBuffered类型的值Buff， 以减少转换为对象数组操作。
	 * 
	 * @return ObjectBuffered
	 */
	public StringBuilder getSQLValues() {
		return null;
	}

	/**
	 * 返回SQL串形式的条件单项
	 * 
	 * @deprecated
	 */
	/*
	 * public String getConditionItemString() { if (sql != null) { return new
	 * StringBuffered(name).append(" ").append(operator).append(" ("
	 * ).append(sql.getSQLString()).append(") ").toString(); } if
	 * (isValidOperator(OPERATOR_SIGNS_SINGLE, operator)) { if (isQuote) {
	 * return new StringBuffered(name).append(" ").append(operator).append(" "
	 * ).append(values[0]).append(" ").toString(); } else { return new
	 * StringBuffered(name).append(" ").append(operator).append(" ? "
	 * ).toString(); } } else { if (isValidOperator(OPERATOR_SIGNS_BETWEEN,
	 * operator)) { return new StringBuffered(name).append(" "
	 * ).append(operator).append(" ? AND ? ").toString(); } else {
	 * StringBuffered valuesStr = new StringBuffered(name).append(" "
	 * ).append(operator).append(" ("); int valuesCount = values.length; for
	 * (int i = 0; i < valuesCount; i++) { valuesStr.append(i == 0 ? "? " :
	 * ",? "); } return valuesStr.append(") ").toString(); } } }
	 */

	/**
	 * 返回SQL串形式的条件单项
	 * @param isQuote 0=true加'' 1=false加''
	 * @return
	 */
	public StringBuilder getConditionItemStatement(int isQuote) {
		if(isQuote == 1) {
			this.isQuote = !this.isQuote;
		}
		StringBuilder sb = getConditionItemStatement();
		// 改回来，不然原始对象被改了
		if(isQuote == 1) {
			this.isQuote = !this.isQuote;
		}
		return sb;
	}
	/**
	 * 返回SQL串形式的条件单项
	 */
	public StringBuilder getConditionItemStatement() {
		if (isValidOperator(OPERATOR_SIGNS_SINGLE, operator)) {
			return new StringBuilder(name).append(" ").append(operator).append(" ").append(getObjectValueStr(values[0],this.isQuote)).append(" ");
		} else if (isValidOperator(OPERATOR_SIGNS_BETWEEN, operator)) {
			return new StringBuilder(name).append(" ").append(operator).append(" " + getObjectValueStr(values[0],this.isQuote) + " AND " + getObjectValueStr(values[1],this.isQuote) + " ");
		} else if (isValidOperator(OPERATOR_SIGNS_IN, operator)) {
			StringBuilder valuesStr = new StringBuilder();
			valuesStr.append(name).append(" ").append(operator).append(" (");
			int valuesCount = values.length;
			for (int i = 0; i < valuesCount; i++) {
				if (i > 0) {
					valuesStr.append(",");
				}
				valuesStr.append(getObjectValueStr(values[i],this.isQuote));
			}
			return valuesStr.append(") ");
		} else {
			throw new RuntimeException("不支持的操作符类型");
		}
	}

	/**
	 * 检索是否有效的条件运算符
	 * 
	 * @param oprtor
	 *            条件运算符号
	 * 
	 * @return true,是, false,否
	 */
	private boolean isValidOperator(String[] definedSigns, String oprtor) {
		int len = definedSigns.length;
		for (int i = 0; i < len; i++) {
			if (definedSigns[i].equalsIgnoreCase(oprtor.trim())) {
				return true;
			}
		}
		return false;
	}

	public static String getObjectValueStr(Object obj,boolean isQute) {
		if (BaseUtil.isPrimitiveType(obj)) {
			return obj.toString();
		} else if (BaseUtil.isDate(obj)) {
			return "'" + DateUtil.DateToString((Date) obj) + "'";
		} else if(!isQute){
			return obj != null ? "'" + obj.toString() + "'" : "";
		} else {
			return obj != null ?  obj.toString() : "";
		}
	}

}
