package com.myfun.repository.support.mybatis.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.HttpMessageNotReadableException;

import com.myfun.utils.StringUtil;

public class BaseMap extends HashMap<String, Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 返回字符串值
	 * @param key
	 * @return
	 */
	public String getString(String key){
		Object object = this.get(key);
		if(null != object) {
			return String.valueOf(object);
		}
		return null;
	}
	
	/**
	 * 返回字符串值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public String getStringCheck(String key){
		String result = getString(key);
		if(result == null){
			throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
		}
		return result;
	}
	
	/**
	 * 返回整形值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public Integer getIntegerCheck(String key) {
		Integer result = getInteger(key, null);
		if(result == null){
			throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
		}
		return result;
	}
	
	/**
	 * 返回整形值，没有返回空
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key) {
		return getInteger(key, null);
	}
	
	/**
	 * 返回整形值，没有defVal
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key, Integer defVal) {
		return StringUtil.parseInteger(super.get(key) + "", defVal);
	}


	
	/**
	 * 手动设置值
	 * @param name
	 * @param value
	 */
	public void setString(String name,String value){
		super.put(name, value);
	}
	
	/**
	 * 手动设置值
	 * @param name
	 * @param value
	 */
	public void setInteger(String name, Integer value){
		super.put(name, value);
	}
	public void setObject(String name,Object object){
		super.put(name, object);
	}
	public Object getObject(String name){
		return super.get(name);
	}
	public Boolean getBoolean(String name){
		return Boolean.valueOf(String.valueOf(super.get(name)));
	}
}
