
package com.myfun.repository.support.generator.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 重写mybatis Table 支持多主键
 * 
 * @ClassName: Table
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月18日 下午5:50:33
 *
 */
public class Table {
	private final String name;
	private String catalog;
	private String schema;
	private final Map<String, Column> columns = new HashMap<String, Column>();
	private List<Column> primaryKey;

	public Table(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void addColumn(Column col) {
		columns.put(col.getName().toUpperCase(Locale.ENGLISH), col);
	}

	public Column getColumn(String name) {
		return columns.get(name.toUpperCase(Locale.ENGLISH));
	}

	public String[] getColumnNames() {
		return columns.keySet().toArray(new String[columns.size()]);
	}

	public List<Column> getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(List<Column> primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Map<String, Column> getColumns() {
		return columns;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final Table table = (Table) o;
		if (name != null ? !name.equals(table.name) : table.name != null)
			return false;
		return true;
	}

	public int hashCode() {
		return (name != null ? name.hashCode() : 0);
	}

}
