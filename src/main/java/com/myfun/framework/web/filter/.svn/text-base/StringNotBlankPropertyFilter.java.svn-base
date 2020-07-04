package com.myfun.framework.web.filter;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class StringNotBlankPropertyFilter implements PropertyFilter{

	@Override
	public boolean apply(Object object, String fieldName, Object fieldVal) {
		if (fieldVal == null) {
			return false;
		}
		
		if (fieldVal instanceof String) {
			return StringUtils.isNotBlank((String)fieldVal);
		}
		return true;
	}
}
