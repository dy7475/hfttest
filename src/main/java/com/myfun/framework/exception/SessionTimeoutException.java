package com.myfun.framework.exception;

/**
 * 会话超时
 * 
 * @ClassName: SessionTimeoutException
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午4:28:39
 *
 */
public class SessionTimeoutException extends RuntimeException {

	private static final long serialVersionUID = -7084066605197111614L;

	private Integer errorCode;
	private String errorMsg;
	
	public SessionTimeoutException(String msg, Integer errorCode, String errorMsg) {
		super(msg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public SessionTimeoutException(String errorMsg, Integer errorCode) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public SessionTimeoutException() {
		super();
	}

	public SessionTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SessionTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

	public SessionTimeoutException(String message) {
		super(message);
	}

	public SessionTimeoutException(Throwable cause) {
		super(cause);
	}

}
