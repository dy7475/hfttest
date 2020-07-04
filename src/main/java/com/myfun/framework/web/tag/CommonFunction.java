package com.myfun.framework.web.tag;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myfun.framework.util.SpringContextUtil;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;

/**
 * 共有函数类 方便jsp调用
 * 
 * @ClassName: CommonFunction
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:19:56
 *
 */
@Component
public class CommonFunction {
	private transient static final Logger LOGGER = LoggerFactory.getLogger(CommonFunction.class);
	/** 单例类 **/
	private volatile static CommonFunction commonFunction;
	private static ErpDicDefdinitionsService erpDicDefdinitionsService;
	
	public static String getDicMsg(String dicType, String dicValue, Integer cityId) throws Exception {
		String result = null;
		try {
			if(erpDicDefdinitionsService == null) {
				erpDicDefdinitionsService = SpringContextUtil.getBean(ErpDicDefdinitionsService.class);
			}
			result = erpDicDefdinitionsService.getDicValue(dicType, dicValue, cityId).getDicCnMsg();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("页面获取数据字典出错");
		}
		return result;
	}
	
	public CommonFunction() {
		commonFunction = this;
	}

	public static CommonFunction getInstance() {
		return commonFunction;
	}

	public static String dateFormat(Date date, String style) {
		try {
			return DateUtil.DateToString(date, style);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String dateFormatStr(String date, String style) {
		try {
			return DateTimeHelper.formatDateTimetoString(date);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String replace(String source, String regex, String replacement) {
		try {
			return source.replaceAll(regex, replacement);
		} catch (Exception e) {
			return source;
		}
	}
	
	public static String replaceAllEntity(String str){
		if(StringUtils.isEmpty(str)){
			return str;
		}
		return str.replaceAll("\n|\r","&EACE").replaceAll("\"|&quot;","'").replaceAll("'","\\\\'");
	}
}
