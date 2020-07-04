package com.myfun.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public final class ThridHftApiReturnDataUtil {
	
	public static Map<String,Object> transHftMobileReturnData(String bodyStr) throws Exception{
		Map<String, Object> dataMap = JSON.parseObject(bodyStr, new TypeReference<Map<String, Object>>(){});
		String status = dataMap.get("status").toString();
		Map<String,Object> returnData  = new HashMap<String,Object>();
		if ("1".equals(status)) {
			returnData.put("data", dataMap.get("data"));
			returnData.put("errCode", 200);
		} else if("0".equals(status)) {
			returnData.put("data",null);
			returnData.put("errCode", 500);
		}
		return returnData;
	}
}
