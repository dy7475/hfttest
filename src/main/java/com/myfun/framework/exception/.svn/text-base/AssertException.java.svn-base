package com.myfun.framework.exception;

/**
 * “断言”错误异常，不满足条件时抛出
 * 会以提示性的文字返回给前端
 * @author 张宏利
 * @since 2017年2月25日
 */
public class AssertException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errCode;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public AssertException() {
		super();
	}

	public AssertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssertException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssertException(String message) {
		super(message);
	}
	public AssertException(Throwable cause) {
		super(cause);
	}

	public AssertException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}
}

