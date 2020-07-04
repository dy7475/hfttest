package com.myfun.erpWeb.openApi.other;


import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.utils.rijindael.AESHelper;
import com.myfun.utils.rijindael.AESUtf8Helper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/openApi/aes")
public class AesEncryptController {
	/**
	 * @tag 加密接口
	 * @author 邓永洪
	 * @since 2018/8/2
	 */
	@ResponseBody
	@RequestMapping(value = "/getAesEncrypt")
	public ErpResponseJson getAesEncrypt(String json,Integer aesType) throws Exception {
		String ciphertext = "";
		if (StringUtils.isBlank(json)) {
			return ErpResponseJson.ok();
		}
		if (aesType == null) {
			ciphertext = AESHelper.encode(json);
			return ErpResponseJson.ok(ciphertext);
		}
		if (aesType == 1) {
			ciphertext = AESUtf8Helper.encode(json);
			return ErpResponseJson.ok(ciphertext);
		}
		if (aesType == 2) {
			ciphertext = AESHelper.encode(json);
			return ErpResponseJson.ok(ciphertext);
		}
		return ErpResponseJson.ok();
	}

}
