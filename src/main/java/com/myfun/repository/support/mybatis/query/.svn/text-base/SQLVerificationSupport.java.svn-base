package com.myfun.repository.support.mybatis.query;

import org.apache.commons.lang.StringUtils;

import com.myfun.utils.BaseUtil;

/**
 * SQL必须组成部分验证支持类
 * @author flj
 *
 */
public final class SQLVerificationSupport {
	
	public static void checkWithSubSqlAlias(SQL sql) throws Exception{
		if(StringUtils.isBlank(sql.getAlias())){
			throw new IllegalArgumentException("when you use With t as ,that subSQL's (Field)Alias(String) cannot be Blank.");
		}
	}
	
	public static void checkSelectSqlType(SQL sql) throws Exception{
		if(!SqlType.SELECT.getType().equals(sql.getType())){
			throw new IllegalArgumentException("this select sql's SqlType must be "+SqlType.SELECT.getType());
		}
	}
	
	public static void checkWithTasSqlType(SQL sql) throws Exception{
		if(!SqlType.WITHTAS.getType().equals(sql.getType())){
			throw new IllegalArgumentException("this WITH T AS sql's SqlType must be "+SqlType.WITHTAS.getType());
		}
		//1.判断是否有子语句
		if(BaseUtil.isEmpty(sql.getSubList())){
			throw new IllegalArgumentException("when you use With t as ,that SQL's (Field)subList cannot be empty.");
		}
		if(sql.getQuerySql()==null){
			throw new IllegalArgumentException("when you use With t as ,that SQL's (querySql)querySql cannot be null.");
		}
	}

	public static void checkUnionSqlType(SQL sql) throws Exception{
		if(!SqlType.UNION.getType().equals(sql.getType())&&!SqlType.UNIONALL.getType().equals(sql.getType())){
			throw new IllegalArgumentException("this UNION or UNION ALL sql's SqlType must be "+SqlType.UNION.getType()+" or "+SqlType.UNIONALL.getType());
		}else if(BaseUtil.isEmpty(sql.getSubList())){
			throw new IllegalArgumentException("when you use UNION or UNION ALL sql's  subSQL cannot be not empty");
		}
	}
	
	public static void checkAutoPageHasOrderBy(SQL sql) {
		if(!sql.getIsAutoPage()){
			throw new IllegalArgumentException("when you use auto page ,that SQL's (Field)IsAutoPage(boolean) must be true(default false).");
		}
		if(StringUtils.isBlank(sql.getOrderBy())){
			throw new IllegalArgumentException(" when you use auto page ,that SQL's(Field)orderBy(String) cannot be blank");
		}
	}
}
