package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpActionsqlLogWithBLOBs extends ErpActionsqlLog implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String sqlvalue;
	/**
	 * @mbggenerated
	 */
	private String sqlstring;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getSqlvalue() {
		return sqlvalue;
	}

	/**
	 * @mbggenerated
	 */
	public void setSqlvalue(String sqlvalue) {
		this.sqlvalue = sqlvalue == null ? null : sqlvalue.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSqlstring() {
		return sqlstring;
	}

	/**
	 * @mbggenerated
	 */
	public void setSqlstring(String sqlstring) {
		this.sqlstring = sqlstring == null ? null : sqlstring.trim();
	}
}