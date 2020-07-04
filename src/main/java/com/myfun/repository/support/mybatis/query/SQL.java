package com.myfun.repository.support.mybatis.query;

import java.util.List;

/**
 * SQL描述类
 * @author flj
 *
 */
public final class SQL implements java.io.Serializable{
	private static final long serialVersionUID = 6626942489436364862L;
	private int type;//sql 类型
	private String tableName;//表名称
	private String alias;//别名
	private Condition condition;//sql 条件
	private Columns columns; // 更新的列
	private boolean distinct; // 是否去重复
	private String orderBy; //排序字段
	private String groupBy; //分组字段
	private String having; //having 条件过滤
	private boolean isAutoPage = false; // 是否在SQL中拼写分页条件
	private Integer pageOffSet; // 分页页数
	private Integer pageRows; // 分页条数
	private List<SQL> subList; // 子sql列表 如
	private SQL querySql; //复杂SQL查询语句
	private String connector; //链接符号
	
	public SQL(int type,String tableName ,String alias,Condition condition, Columns columns,
			boolean distinct, String orderBy, String groupBy, String having,
			boolean isAutoPage, Integer pageOffSet, Integer pageRows,
			List<SQL> subList, SQL querySql, String connector) {
		this.type = type;
		this.alias = alias;
		this.tableName = tableName;
		this.condition = condition;
		this.columns = columns;
		this.distinct = distinct;
		this.orderBy = orderBy;
		this.groupBy = groupBy;
		this.having = having;
		this.isAutoPage = isAutoPage;
		this.pageOffSet = pageOffSet;
		this.pageRows = pageRows;
		this.subList = subList;
		this.querySql = querySql;
		this.connector = connector;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Columns getColumns() {
		return columns;
	}
	public void setColumns(Columns columns) {
		this.columns = columns;
	}
	public boolean getDistinct() {
		return distinct;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	public String getHaving() {
		return having;
	}
	public void setHaving(String having) {
		this.having = having;
	}
	public boolean getIsAutoPage() {
		return isAutoPage;
	}
	public void setAutoPage(boolean isAutoPage) {
		this.isAutoPage = isAutoPage;
	}
	public Integer getPageOffSet() {
		return pageOffSet;
	}
	public void setPageOffSet(Integer pageOffSet) {
		this.pageOffSet = pageOffSet;
	}
	public Integer getPageRows() {
		return pageRows;
	}
	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}
	
	public List<SQL> getSubList() {
		return subList;
	}
	public void setSubList(List<SQL> subList) {
		this.subList = subList;
	}
	public SQL getQuerySql() {
		return querySql;
	}
	public void setQuerySql(SQL querySql) {
		this.querySql = querySql;
	}
	public String getConnector() {
		return connector;
	}
	public void setConnector(String connector) {
		this.connector = connector;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}


	public static class SqlBuilder
	{
		private int type;
		private String tableName;
		private String alias;
		private Condition condition;
		private Columns columns;
		private boolean distinct;
		private String orderBy;
		private String groupBy;
		private String having;
		private boolean isAutoPage;
		private Integer pageOffSet;
		private Integer pageRows;
		private List<SQL> subList;
		private SQL querySql;
		private String connector;
		
		public SqlBuilder(final int type,final String tableName,final Columns columns,final Condition condition){
			this.type = type;
			this.tableName = tableName;
			this.columns = columns;
			this.condition = condition;
		}
		
		public SqlBuilder type(final int type){
			this.type = type;
			return this;
		};
		
		public SqlBuilder tableName(final String tableName){
			this.tableName = tableName;
			return this;
		};
		
		public SqlBuilder alias(final String alias){
			this.alias = alias;
			return this;
		};
		
		public SqlBuilder condition(final Condition condition){
			this.condition = condition;
			return this;
		};
		
		public SqlBuilder columns(final Columns columns){
			this.columns = columns;
			return this;
		};
		
		public SqlBuilder distinct(final boolean distinct){
			this.distinct = distinct;
			return this;
		};
		
		public SqlBuilder orderBy(final String orderBy){
			this.orderBy = orderBy;
			return this;
		};
		
		public SqlBuilder groupBy(final String groupBy){
			this.groupBy = groupBy;
			return this;
		};
		
		public SqlBuilder having(final String having){
			this.having = having;
			return this;
		};
		
		public SqlBuilder isAutoPage(final boolean isAutoPage){
			this.isAutoPage = isAutoPage;
			return this;
		};
		
		public SqlBuilder pageOffSet(final Integer pageOffSet){
			this.pageOffSet = pageOffSet;
			return this;
		};
		
		public SqlBuilder pageRows(final Integer pageRows){
			this.pageRows = pageRows;
			return this;
		};
		
		public SqlBuilder subList(final List<SQL> subList){
			this.subList = subList;
			return this;
		};
		
		public SqlBuilder querySql(final SQL querySql){
			this.querySql = querySql;
			return this;
		};
		
		public SqlBuilder connector(final String connector){
			this.connector = connector;
			return this;
		};
		
		public SQL createSQL()
	    {
	       return new SQL(this.type,this.tableName,this.alias,this.condition, this.columns,
	   			this.distinct, this.orderBy, this.groupBy, this.having,
				this.isAutoPage, this.pageOffSet, this.pageRows,
				this.subList, this.querySql, this.connector) ;
		
	    }
	}
	
}
