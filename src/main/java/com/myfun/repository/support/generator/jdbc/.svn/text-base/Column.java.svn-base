package com.myfun.repository.support.generator.jdbc;

/**
 * 生成配置文件对应列
 * 
 * @ClassName: Column
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月18日 下午5:48:29
 *
 */
public class Column {

	private String name;
	private int type;

	public Column(String name, int type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Column column = (Column) o;

		if (type != column.type)
			return false;
		if (name != null ? !name.equals(column.name) : column.name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (name != null ? name.hashCode() : 0);
		result = 29 * result + type;
		return result;
	}

}
