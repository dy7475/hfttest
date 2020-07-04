package com.myfun.repository.support.config;

import com.myfun.utils.EnCodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashSet;
import java.util.Set;

/**
 * 属性文件加密解密
 * 
 * @ClassName: DecryptPropertyPlaceholderConfigurer
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月19日 下午1:34:55
 *
 */
public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(DecryptPropertyPlaceholderConfigurer.class);
	private static Set<String> enField = new HashSet<String>();

	static {
		enField.add("hft_admindb.datasource.username");
		enField.add("hft_admindb.datasource.password");
		enField.add("hft_agencydb.datasource.username");
		enField.add("hft_agencydb.datasource.password");
		enField.add("hft_searchdb.datasource.username");
		enField.add("hft_searchdb.datasource.password");
		enField.add("hft_erpdb.datasource.username");
		enField.add("hft_erpdb.datasource.password");
		enField.add("txhouse_hft.datasource.username");
		enField.add("txhouse_hft.datasource.password");
	}

	/**
	 * 调用字段加密
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptPropertyVal(propertyName)) {
			LOGGER.info("convertProperty->" + propertyName + "->" + propertyValue);
			String decodeValue = EnCodeHelper.decode(propertyValue);// 调用解密方法
			LOGGER.info("convertProperty->" + propertyName + "->" + propertyValue + "->" + decodeValue);
			return decodeValue;
		} else {
			return propertyValue;
		}
	}

	/**
	 * 判断是否是否需要解密
	 * 
	 * @param propertyName
	 *            字段名字
	 * @return
	 */
	private boolean isEncryptPropertyVal(String propertyName) {
		if (enField.contains(propertyName)) {
			return true;
		} else {
			return false;
		}
	}
}
