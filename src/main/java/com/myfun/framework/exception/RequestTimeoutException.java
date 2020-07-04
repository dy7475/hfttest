package com.myfun.framework.exception;

/**
 * @param ${tags} 设定文件
 * @author lcb
 * @Title: 请求超时异常
 * @Description: 超时抛出异常 被全局异常处理器捕获
 * @return ${return_type}    返回类型
 * @Date 2018/12/22 15:11
 * @throws
 */
public class RequestTimeoutException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errCode;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public RequestTimeoutException() {
        super();
    }

    public RequestTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RequestTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestTimeoutException(String message) {
        super(message);
    }

    public RequestTimeoutException(Throwable cause) {
        super(cause);
    }

    public RequestTimeoutException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }

}
    	