package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpActionsqlLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer logid;
	/**
	 * @mbggenerated
	 */
	private String logtime;
	/**
	 * @mbggenerated
	 */
	private String actionname;
	/**
	 * @mbggenerated
	 */
	private String begintime;
	/**
	 * @mbggenerated
	 */
	private String endtime;
	/**
	 * @mbggenerated
	 */
	private Integer usetime;
	/**
	 * @mbggenerated
	 */
	private String visitstart;
	/**
	 * @mbggenerated
	 */
	private String visitend;
	/**
	 * @mbggenerated
	 */
	private Integer visitusetime;
	/**
	 * @mbggenerated
	 */
	private String sqlvaluemd5;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getLogid() {
		return logid;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	/**
	 * @mbggenerated
	 */
	public String getLogtime() {
		return logtime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogtime(String logtime) {
		this.logtime = logtime == null ? null : logtime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getActionname() {
		return actionname;
	}

	/**
	 * @mbggenerated
	 */
	public void setActionname(String actionname) {
		this.actionname = actionname == null ? null : actionname.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime == null ? null : begintime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * @mbggenerated
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUsetime() {
		return usetime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUsetime(Integer usetime) {
		this.usetime = usetime;
	}

	/**
	 * @mbggenerated
	 */
	public String getVisitstart() {
		return visitstart;
	}

	/**
	 * @mbggenerated
	 */
	public void setVisitstart(String visitstart) {
		this.visitstart = visitstart == null ? null : visitstart.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVisitend() {
		return visitend;
	}

	/**
	 * @mbggenerated
	 */
	public void setVisitend(String visitend) {
		this.visitend = visitend == null ? null : visitend.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getVisitusetime() {
		return visitusetime;
	}

	/**
	 * @mbggenerated
	 */
	public void setVisitusetime(Integer visitusetime) {
		this.visitusetime = visitusetime;
	}

	/**
	 * @mbggenerated
	 */
	public String getSqlvaluemd5() {
		return sqlvaluemd5;
	}

	/**
	 * @mbggenerated
	 */
	public void setSqlvaluemd5(String sqlvaluemd5) {
		this.sqlvaluemd5 = sqlvaluemd5 == null ? null : sqlvaluemd5.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpActionsqlLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpActionsqlLog(Integer shardCityId, Integer logid) {
		super(shardCityId);
		this.logid = logid;
	}
}