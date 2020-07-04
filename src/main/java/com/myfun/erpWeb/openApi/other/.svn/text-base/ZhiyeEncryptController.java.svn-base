package com.myfun.erpWeb.openApi.other;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.utils.StringUtil;
import com.myfun.utils.ThreeZhiyeDesUtil;

/**
 * 知业接口，现在主要给移动端用，临时的
 * @author 张宏利
 * @since 2017年6月1日
 */
@Controller
@RequestMapping(value = "/openApi/test")
public class ZhiyeEncryptController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ZhiyeEncryptController.class);
	
	/**
	 * 获取知业加密字符串
	 * @author 张宏利
	 * @since 2017年6月1日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getZhiyeEncrypt")
	public ResponseJson getZhiyeEncrypt(String archiveId) {
		if(StringUtils.isBlank(archiveId)) {
			return ErpResponseJson.warn("档案ID必传");
		}
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("uid", archiveId);
		paramMap.put("pid", "288");
		String encrypt = null;
		try {
			encrypt = ThreeZhiyeDesUtil.aesEncrypt(JSON.toJSONString(paramMap), ThreeZhiyeDesUtil.priKey);
			encrypt = ThreeZhiyeDesUtil.bytesToHexString(StringUtil.getUtf8Byte(encrypt));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ErpResponseJson.ok(encrypt);
	}
}

