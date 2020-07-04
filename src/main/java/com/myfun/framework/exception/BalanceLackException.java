package com.myfun.framework.exception;

/**
 * 资金账户余额不足
 * 
 * @ClassName: BalanceLackException
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月12日 上午10:47:37
 *
 */
public class BalanceLackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BalanceLackException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceLackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BalanceLackException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BalanceLackException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BalanceLackException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
