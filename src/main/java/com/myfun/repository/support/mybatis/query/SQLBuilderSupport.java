package com.myfun.repository.support.mybatis.query;

import java.sql.SQLType;

import org.apache.commons.lang.StringUtils;

import com.myfun.utils.BaseUtil;
import com.myfun.utils.StringUtil;
/**
 * SQL构造支持类
 * @author flj
 *
 */
public final class SQLBuilderSupport {
	public static StringBuilder constructSQL(SQL sql) throws Exception{
		if(sql==null){
			return null;
		}
		if(SqlType.SELECT.getType().equals(sql.getType())){
			return constructSQLForSelect(sql);
		}else if(SqlType.WITHTAS.getType().equals(sql.getType())){
			return constructWithTasSQL(sql);
		}else if(SqlType.UNION.getType().equals(sql.getType())){
			return constructUnionSQL(sql);
		}else if(SqlType.UNIONALL.getType().equals(sql.getType())){
			return constructUnionSQL(sql);
		}else if(SqlType.UNIONPAGE.getType().equals(sql.getType())){
			return constructUnionPageSQL(sql);
		}
		return null;
	}
	public static StringBuilder constructUnionPageSQL(SQL sql) throws Exception{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ");
		sqlBuilder.append(sql.getColumns().getColumns());
		sqlBuilder.append(" FROM (");
		sqlBuilder.append(constructSQLForSelect(sql.getSubList().get(0)));
		sqlBuilder.append(SqlType.UNION.getType().equals(sql.getType())?"UNION":"UNION ALL");
		sqlBuilder.append(constructSQLForSelect(sql.getSubList().get(1)));
		sqlBuilder.append(") as ");
		if(StringUtils.isNotBlank(sql.getAlias())){
			sqlBuilder.append(sql.getAlias());
		}
		/* 生成ORDER BY串 */
		if (StringUtils.isNotBlank(sql.getOrderBy())) {
			sqlBuilder.append(" ORDER BY ").append(sql.getOrderBy());
		}
		/* 生成分页串 */
		if (sql.getIsAutoPage()) {
			sqlBuilder.append(" OFFSET "+((sql.getPageOffSet()-1)*sql.getPageRows())+" ROW FETCH NEXT "+sql.getPageRows()+" ROWS ONLY");// 条件
		}
		return sqlBuilder;
		
	}
	public static StringBuilder constructUnionSQL(SQL sql) throws Exception{
		SQLVerificationSupport.checkUnionSqlType(sql);
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(constructSQLForSelect(sql));
		sqlBuilder.append(SqlType.UNION.getType().equals(sql.getType())?"UNION":"UNION ALL");
		sqlBuilder.append(constructSQLForSelect(sql.getSubList().get(0)));
		return sqlBuilder;
		
	}
	public static StringBuilder constructWithTasSQL(SQL sql) throws Exception{
		StringBuilder sqlBuilder = new StringBuilder();
		SQLVerificationSupport.checkWithTasSqlType(sql);
		boolean firstFlag = true;
		for(SQL subSql:sql.getSubList()){
			if(firstFlag){
				 sqlBuilder.append(" With ");
				 SQLVerificationSupport.checkWithSubSqlAlias(subSql);
				 sqlBuilder.append(subSql.getAlias());
				 sqlBuilder.append(" as (");
				 sqlBuilder.append(constructSQLForSelect(subSql));
				 sqlBuilder.append("),");
			}else{
				 SQLVerificationSupport.checkWithSubSqlAlias(subSql);
				 sqlBuilder.append(subSql.getAlias());
				 sqlBuilder.append(" as (");
				 sqlBuilder.append(constructSQLForSelect(subSql));
				 sqlBuilder.append("),");
			}
			firstFlag = false;
		}
		if(!firstFlag){
			sqlBuilder = new StringBuilder(sqlBuilder.substring(0, sqlBuilder.length()-1));
		}
		sqlBuilder.append(constructSQLForSelect(sql));
		return sqlBuilder;
	 }
	 public static StringBuilder constructSQLForSelect(SQL sql ) {
		if(StringUtil.isBlank(sql.getTableName())){
			throw new IllegalArgumentException("The name of an table cannot be null.");
		}
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT ");
		if (sql.getDistinct()) {
			sqlBuilder.append(" DISTINCT ");
		}
		if (sql.getColumns() != null && !sql.getColumns().isEmpty()){
			sqlBuilder.append(sql.getColumns().getColumns());
		}else{
			sqlBuilder.append("*");
		}
		/* 生成DISTINCT串 */
		/* 生成返回列的串 */
		/* 生成FROM子串, 如果tableName为空,将不构建FROM子句 */
		if (StringUtils.isNotBlank(sql.getTableName())) {
			sqlBuilder.append(" FROM ").append(sql.getTableName());
		}
		/* 生成查询条件串 */
		if (sql.getCondition() != null && sql.getCondition().size() != 0) {
			sqlBuilder.append(" WHERE ")
			.append(sql.getCondition().getConditionStatement(1));
		}
		/* 生成GROUP BY串 */
		if (StringUtils.isNotBlank(sql.getGroupBy())) {
			sqlBuilder.append(" GROUP BY ").append(sql.getGroupBy());
		}
		/* 生成HAVING串 */
		if (StringUtils.isNotBlank(sql.getHaving())) {
			sqlBuilder.append(" HAVING ").append(sql.getHaving());
		}
		/* 生成ORDER BY串 */
		if (StringUtils.isNotBlank(sql.getOrderBy())) {
			sqlBuilder.append(" ORDER BY ").append(sql.getOrderBy());
		}
		/* 生成ORDER BY串 */
		if (sql.getIsAutoPage()) {
			SQLVerificationSupport.checkAutoPageHasOrderBy(sql);
			sqlBuilder.append(" OFFSET "+((sql.getPageOffSet()-1)*sql.getPageRows())+" ROW FETCH NEXT "+sql.getPageRows()+" ROWS ONLY");// 条件
		}
		
		return sqlBuilder;
	}
	 
	public static StringBuilder selectByCondition(SQL sql
			) throws Exception{
		SQLVerificationSupport.checkSelectSqlType(sql);
		return constructSQL(sql);
	}
	
	public static StringBuilder WithTasByCondition(SQL sql
			) throws Exception{
		return constructSQL(sql);
	}
	
	public static StringBuilder UnionByCondition(SQL sql
			) throws Exception{
		return constructSQL(sql);
	}
	
	public static StringBuilder UnionAllByCondition(SQL sql
			) throws Exception{
		return constructSQL(sql);
	}
	public static StringBuilder selectByCondition(String tableName, boolean distinct,
			Columns columns, Condition condition, String orderBy, String groupBy) throws Exception {
		SQL sql = SqlFactory.createDelFaultSelectSql(tableName, distinct, condition, columns, orderBy, groupBy);
		return selectByCondition(sql); 
	}
	
	public static void main(String[] args) {
		/*Condition condition = new Condition();
		condition.add(new ConditionItem("COMP_ID","=","12001"));
		Condition queryCondition = new Condition();
		queryCondition.add(new ConditionItem("CASE_TYPE", "is", "NOT NULL"));
		condition.add(queryCondition);
		condition.add(new ConditionItem("SALE_ID","IN",new String[]{"6631840","6631839","6631838"}));
		System.out.println(constructSQLForSelect(" FUN_SALE ", false ,new Columns( new String[]{"SALE_ID as id","SALE_NO"}), condition, null, "SALE_NO desc"));
*/	}
	
}
