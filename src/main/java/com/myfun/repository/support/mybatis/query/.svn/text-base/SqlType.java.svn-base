package com.myfun.repository.support.mybatis.query;

import net.sf.jsqlparser.statement.update.Update;

/**
 * SQL类型枚举
 * 用于表示SQL语句的类型
 * 1 代表SELECT
 * 2 代表UPDATE
 * 3 代表INSERT
 * 4 代表DELETE
 * 5 代表 WITH T　AS开头的SQL语句
 * 6 代表UNION SQL语句
 * 7 代表UNIONALL SQL语句
 * 8 代表SELECTAUTO SQL语句
 * @author Administrator
 *
 */
public enum SqlType {
	SELECT(1),
	UPDATE(2),
	INSERT(3),
	DELETE(4),
	WITHTAS(5),
	UNION(6),
	UNIONALL(7),
	UNIONPAGE(8),
	SELECTAUTO(9);
	
	SqlType(Integer type){
		this.setType(type);
	}
	
	/**
	 * sql类型
	 */
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}


}
