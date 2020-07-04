package com.myfun.framework.web.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.utils.DateTimeHelper;

import java.util.Date;
import java.util.List;

/**
  * 支付宝租房平台返回
  * @author 李成兵
  * @since 2018/5/21
  * @param
  * @return
  */
public class RentHouseResponseJson implements ResponseJson {
	private static SerializeConfig mapping = new SerializeConfig();
	private static Integer RES_CODE_SUCCESS= 1;
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}

	/** 状态码 **/
	private int code;
	/** 返回值说明 **/
	private String message;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RentHouseResponseJson() {
		this.code = RES_CODE_SUCCESS;
		this.message = "成功";
	}

	public RentHouseResponseJson(Integer code) {
		this.code = code;
		switch (code) {
			case 2:
				this.message = "失败";
				break;
			case 1:
				this.message = "成功";
				break;
			case 3:
				this.message = "无权访问此接口";
				break;
		}
	}
}
