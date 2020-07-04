package com.myfun.framework.exception;

import java.util.HashMap;

/**
 * 业务异常
 * 
 * @ClassName: BusinessException
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月12日 上午10:46:52
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errCode;
	
	private HashMap<String, Object> extMap;//错误扩展字段

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public HashMap<String, Object> getExtMap() {
		return extMap;
	}

	public void setExtMap(HashMap<String, Object> extMap) {
		this.extMap = extMap;
	}

	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, String errCode) {
		super(message);
	   	this.errCode = errCode;
	}
	
	public BusinessException(String message, String errCode, HashMap<String, Object> extMap) {
		super(message);
	   	this.errCode = errCode;
	   	this.extMap = extMap;
	}

	public BusinessException(String message, HashMap<String, Object> extMap) {
		super(message);
	   	this.extMap = extMap;
	}

}
    	