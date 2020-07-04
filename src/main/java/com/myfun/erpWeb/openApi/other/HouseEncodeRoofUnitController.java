package com.myfun.erpWeb.openApi.other;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;

/**
 * 加密单元栋号
 * @since 2017年6月9日
 */
@Controller
@RequestMapping(value = "/openApi/encode")
public class HouseEncodeRoofUnitController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ThirdPageTestController.class);
	
	/**
	 * 加密单元栋号
	 * @since 2017年6月9日
	 * @param encodeType
	 * @param codeStr
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/encodeRoofOrUnit")
	public String encodeRoofOrUnit(String encodeType, String codeStr, HttpServletResponse response) throws Exception {
		String resultStr = null;
		if(StringUtils.isNotBlank(codeStr)){
			codeStr = URLDecoder.decode(codeStr, "utf-8");
			if("0".equals(encodeType)){
				resultStr = EnCodeHelper.encode(codeStr.toUpperCase()).trim()+"#ROOF#"+EnCodeHelper.encode(StringUtil.convertStr(codeStr.toUpperCase(), Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT));
			}else if("1".equals(encodeType)){
				resultStr = EnCodeHelper.encode(codeStr.toUpperCase()).trim()+"#UNIT#"+EnCodeHelper.encode(StringUtil.convertStr(codeStr.toUpperCase(), Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT));
			}
		}
		return resultStr;
	}
}
