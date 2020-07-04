package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunBuildRoofunitdoors;

public class ErpFunBuildRoofunitdoorsDto extends ErpFunBuildRoofunitdoors{
	/**
	 * @author 张宏利
	 * @since 2017年8月30日
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @mbggenerated 是否锁定，1=是
	 */
	private Byte buildLock;

	private String buildRoofName;//栋座别名
	private String buildUnitName;//单元别名

	public String getBuildRoofName() {
		return buildRoofName;
	}

	public void setBuildRoofName(String buildRoofName) {
		this.buildRoofName = buildRoofName;
	}

	public String getBuildUnitName() {
		return buildUnitName;
	}

	public void setBuildUnitName(String buildUnitName) {
		this.buildUnitName = buildUnitName;
	}

	public Byte getBuildLock() {
		return buildLock;
	}
	public void setBuildLock(Byte buildLock) {
		this.buildLock = buildLock;
	}
		
}
