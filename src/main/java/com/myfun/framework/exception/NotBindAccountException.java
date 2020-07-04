package com.myfun.framework.exception;

/**
 * 为绑定资金账户异常
 * 
 * @ClassName: NotBindAccountException
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月12日 上午10:48:17
 *
 */
public class NotBindAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotBindAccountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotBindAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotBindAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotBindAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotBindAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
