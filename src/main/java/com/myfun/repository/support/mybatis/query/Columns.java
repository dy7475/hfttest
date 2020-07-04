
package com.myfun.repository.support.mybatis.query;

import com.myfun.utils.BaseUtil;

/**
 * 
 * @ClassName: Columns
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月18日 上午11:30:31
 *
 */
public class Columns implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String[] columnStr = null;

	public Columns(String... columns) {
		columnStr = columns.clone();
	}

	public String getColumns() {
		if (columnStr == null || columnStr.length < 1) {
			throw new RuntimeException("列不能为空");
		}

		StringBuilder sb = new StringBuilder();
		for (String string : columnStr) {
			sb.append(string).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	@Override
	public String toString() {
		return getColumns();
	}
	
	public boolean isEmpty(){
		return BaseUtil.isEmpty(this.columnStr);
	}
}
