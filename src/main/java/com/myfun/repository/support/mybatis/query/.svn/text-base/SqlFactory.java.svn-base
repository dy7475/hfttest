package com.myfun.repository.support.mybatis.query;

/**
 * SQL构造工厂
 * @author Administrator
 *
 */
public final class SqlFactory {
	/**
	 * 	构建默认的sql查询
	 * @param tableName
	 * @param condition
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public static SQL createDelFaultSelectSql(String tableName,boolean distinct,Condition condition,Columns columns,String orderBy,
				String groupBy) {
		SQL.SqlBuilder sqlBuilder = new SQL.SqlBuilder(SqlType.SELECT.getType(), tableName, columns, condition);
		sqlBuilder.distinct(distinct).groupBy(groupBy).orderBy(orderBy);
		return sqlBuilder.createSQL();
	}
}
