package com.myfun.framework.httpMessageConvert.base;

import java.util.Map;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.utils.StringUtil;


public class BaseMapParam extends AbstractEncryParam{
	private BaseMap param = new BaseMap();// 所有接收的参数集
	
	public Map<String, Object> getMap() {
		return param;
	}
	/**
	 * 返回字符串值
	 * @param key
	 * @return
	 */
	public String getString(String key){
		return param.getString(key);
	}
	
	/**
	 * 返回字符串值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public String getStringCheck(String key){
		return param.getString(key);
	}
	
	/**
	 * 返回整形值
	 * 检查参数如果为空将抛出HttpMessageNotReadableException异常
	 * @param key
	 * @return
	 */
	public Integer getIntegerCheck(String key) {
		return param.getIntegerCheck(key);
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
		return StringUtil.parseInteger(param.get(key), defVal);
	}
	
	/**
	 * 返回整形值，没有返回空
	 * @param key
	 * @return
	 */
	public Byte getByte(String key) {
		return getByte(key, null);
	}
	
	/**
	 * 返回整形值，没有defVal
	 * @param key
	 * @return
	 */
	public Byte getByte(String key, Byte defVal) {
		return StringUtil.parseByte(String.valueOf(param.get(key)), defVal);
	}

	public void setParam(Map<String, Object> param){
		this.param.putAll(param);
	}
	
	/**
	 * 手动设置值
	 * @param name
	 * @param value
	 */
	public void setString(String name,String value){
		param.put(name, value);
	}

	/**
	 * 手动设置值
	 * @param name
	 * @param value
	 */
	public void setByte(String name,Byte value){
		param.put(name, value);
	}
	
	/**
	 * 手动设置值
	 * @param name
	 * @param value
	 */
	public void setInteger(String name, Integer value){
		param.put(name, value);
	}
	public void setObject(String name,Object object){
		param.put(name, object);
	}
	public Object getObject(String name){
		return param.get(name);
	}
}

