package com.myfun.framework.web.json;

import java.util.HashMap;

import org.apache.solr.common.util.Hash;

/**
 * 返回json统一格式
 * 
 * @ClassName: DefaultResponseJson
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:17:29
 *
 */
public class DefaultResponseJson implements ResponseJson {
	/** 状态码 **/
	private int errCode;

	/** 返回值说明 **/
	private String errMsg;

	/** 返回数据 **/
	private Object data;

	public DefaultResponseJson() {
		this.setData(new HashMap());
	}

	public DefaultResponseJson(int errCode, String errMsg) {
		super();
		this.setData(new Hash());
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public DefaultResponseJson(int errCode, String errMsg, Object data) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
	}

	public DefaultResponseJson(int errCode) {
		super();
		this.errCode = errCode;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DefaultResponseJson [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + "]";
	}

}
