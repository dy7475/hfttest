package com.myfun.framework.session;

import java.io.Serializable;

/**
 *
 */
public class ActionUrl implements Serializable {
	private static final long serialVersionUID = 5743896726874915305L;
	/** 请求次数 */
	private int visitsNumber = 0;
	/** 接口名 */
	private String actionName = "";
	/** 接口中文名 */
	private String actionNameCN;
	/** 接口描述 */
	private String actionConfig;
	/** 是否更新参数 */
	private boolean isUpdateParam = true;
	/** 执行参数 */
	private String params = "";
	/** 返回值 */
	private String reparams = "";
	/** 是否更新释义 */
	private boolean isUpdateParamCN = true;
	/** 参数的含义 */
	private String paramCN = "";
	/** 错误信息 */
	private String errorInfo = "";
	/** 新增1 删除2 查询3 修改4 */
	private String crud = "";
	/** 类型 */
	private String type = "";
	private String className = "";
	private String methodName = "";
	private String sqlString = "";

	public ActionUrl() {
	}

	public ActionUrl(String visitTime, String visitTimeLength) {
		this.visitsNumber = 1;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public boolean isUpdateParam() {
		return isUpdateParam;
	}

	public void setUpdateParam(boolean isUpdateParam) {
		this.isUpdateParam = isUpdateParam;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getReparams() {
		return reparams;
	}

	public void setReparams(String reparams) {
		this.reparams = reparams;
	}

	public boolean isUpdateParamCN() {
		return isUpdateParamCN;
	}

	public void setUpdateParamCN(boolean isUpdateParamCN) {
		this.isUpdateParamCN = isUpdateParamCN;
	}

	public String getParamCN() {
		return paramCN;
	}

	public void setParamCN(String paramCN) {
		this.paramCN = paramCN;
	}

	public int getVisitsNumber() {
		return visitsNumber;
	}

	public void setVisitsNumber(int visitsNumber) {
		this.visitsNumber = visitsNumber;
	}

	public void increaseVisitsNumber() {
		this.visitsNumber++;
	}
	/*
	 * public String getVisitTime(){ return visitTime; } public void
	 * setVisitTime(String visitTime) { this.visitTime+=visitTime+","; } public
	 * void clearVisitTime(){ this.visitTime=""; } public String
	 * getVisitTimeLength() { return visitTimeLength; } public void
	 * setVisitTimeLength(String visitTimeLength) {
	 * this.visitTimeLength+=visitTimeLength+","; } public void
	 * clearVisitTimeLength(){ this.visitTimeLength=""; }
	 */

	public String getActionNameCN() {
		return actionNameCN;
	}

	public void setActionNameCN(String actionNameCN) {
		this.actionNameCN = actionNameCN;
	}

	public String getActionConfig() {
		return this.actionConfig;
	}

	public void setActionConfig(String actionConfig) {
		this.actionConfig = actionConfig;
	}

	public String getCrud() {
		return crud;
	}

	public void setCrud(String crud) {
		this.crud = crud;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/*
	 * CREATE Table ACTIONURL( actionName VARCHAR(100) PRIMARY key, visitsNumber
	 * int, visitTime TEXT, visitTimeLength TEXT, actionNameCN TEXT,
	 * actionConfig TEXT, isUpdateParam VARCHAR(10), params TEXT, reparams TEXT,
	 * isUpdateParamCN VARCHAR(10), paramCN TEXT, crud VARCHAR(10), type
	 * VARCHAR(100), className VARCHAR(100), methodName VARCHAR(100), sqlString
	 * TEXT )
	 */

}
