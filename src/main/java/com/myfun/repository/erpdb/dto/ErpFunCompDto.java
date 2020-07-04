package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunComp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunCompDto extends ErpFunComp{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code; 
	private String msg;

	@ApiModelProperty("安装密码 铭文")
	private String plaintPwd;

	@Override
	public String getPlaintPwd() {
		return plaintPwd;
	}

	@Override
	public void setPlaintPwd(String plaintPwd) {
		this.plaintPwd = plaintPwd;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
