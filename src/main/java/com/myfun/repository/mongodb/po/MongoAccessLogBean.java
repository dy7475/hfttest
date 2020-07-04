package com.myfun.repository.mongodb.po;

import com.myfun.utils.StringUtil;
import com.myfun.utils.log.SqlInfo;

import java.util.Date;
import java.util.List;

/**
 * 日志记录
 *
 * @ClassName: AccessLogMongoBean
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年8月25日 下午9:16:51
 *
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "projectAccessLog")
public class MongoAccessLogBean {
	@org.springframework.data.annotation.Id
	private String id;

	/** 0 ERP 1 CRM **/
	private Integer project;

	/** 接口名称或者请求url **/
	private String ifaceName;

	/** 请求url参数 **/
	private String urlParam;

	/** post参数 **/
	private String postParam;

	/** 返回内容 **/
	private String result;

	/** 执行时长 **/
	private Long executeLength;

	/** 创建时间 **/
	private Date createTime;

	/** 执行sql **/
	private String executeSql;

	/** 标示 **/
	private String sessionId;

	/** 错误信息 **/
	private String exceptionStr;

	/** 是否错误 **/
	private Boolean isError;

	/**
	 * 访问来源的IP地址
	 */
	private String accessIp;

	/**
	 * 访问的来源，网站、APP、ERP、MOBILE等
	 */
	private String accessBizSrc;

	/**
	 * 默认0 1：安卓 2：iOS
	 */
	private String deviceType = "0";

	/**
	 * 运行环境
	 */
	private String runRange;

	/** 当前请求执行sql信息 **/
	private List<SqlInfo> sqlInfos;

	/** 自定义日志 **/
	private List<String> bussnessLogRecord;
	
	 /** 访问数据库数量，每个接口访问数据库的次数统计
     * **/
    private Integer accessDataBaseCount;

	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}

	public String getAccessBizSrc() {
		return accessBizSrc;
	}

	public void setAccessBizSrc(String accessBizSrc) {
		this.accessBizSrc = accessBizSrc;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getRunRange() {
		return runRange;
	}

	public void setRunRange(String runRange) {
		this.runRange = runRange;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getProject() {
		return project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public String getIfaceName() {
		return ifaceName;
	}

	public void setIfaceName(String ifaceName) {
		this.ifaceName = ifaceName;
	}

	public String getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}

	public String getPostParam() {
		return postParam;
	}

	public void setPostParam(String postParam) {
		this.postParam = postParam;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getExecuteLength() {
		return executeLength;
	}

	public void setExecuteLength(Long executeLength) {
		this.executeLength = executeLength;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getExecuteSql() {
		return executeSql;
	}

	public void setExecuteSql(String executeSql) {
		this.executeSql = executeSql;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getExceptionStr() {
		return exceptionStr;
	}

	public void setExceptionStr(String exceptionStr) {
	    if(StringUtil.isNotBlank(exceptionStr)){
            this.isError = true;
        }
	    this.exceptionStr = exceptionStr;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public List<SqlInfo> getSqlInfos() {
		return sqlInfos;
	}

	public void setSqlInfos(List<SqlInfo> sqlInfos) {
		this.sqlInfos = sqlInfos;
	}

	public List<String> getBussnessLogRecord() {
		return bussnessLogRecord;
	}

	public void setBussnessLogRecord(List<String> bussnessLogRecord) {
		this.bussnessLogRecord = bussnessLogRecord;
	}
	
	

	public Integer getAccessDataBaseCount() {
		return accessDataBaseCount;
	}

	public void setAccessDataBaseCount(Integer accessDataBaseCount) {
		this.accessDataBaseCount = accessDataBaseCount;
	}

	@Override
	public String toString() {
		return "AccessLogMongoBean [id=" + id + ", project=" + project + ", ifaceName=" + ifaceName + ", urlParam="
				+ urlParam + ", postParam=" + postParam + ", result=" + result + ", executeLength=" + executeLength
				+ ", createTime=" + createTime + ", executeSql=" + executeSql + ", sessionId=" + sessionId
				+ ", exceptionStr=" + exceptionStr + "]";
	}

}
