package com.myfun.utils;

import java.net.URL;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ReflectCfgHelper {
	private static Element configEL;
	private static ReflectCfgHelper cfg = null;

	/* 从资源根位置装载reflect_config.xml配置文件 */
	static{
		if(cfg==null){
			URL cfgurl = ReflectCfgHelper.class.getResource("/reflect_config.xml");
			if(cfgurl==null){
				System.err.println("WARN:Cannot find \"reflect_config.xml\", at root location.");
			}else{
				cfg = new ReflectCfgHelper(load(cfgurl));
			}
		}
	}
	
	/**
	 * 返回reflect_config.xml配置
	 * @throws Exception 
	 */
	public synchronized static ReflectCfgHelper getConfiguration(){
		if(cfg==null){
			return null;
		}
		return cfg;
	}

	/**
	 * 创建Configuration类型的对象, 输入参数为配置文件reflect_config.xml的org.jdom.Element对象形式。
	 * 
	 * @param configEL 配置文件reflect_config.xml的org.jdom.Element对象形式
	 */
	public ReflectCfgHelper(Element configEL) {
		ReflectCfgHelper.configEL = configEL;
		cfg = this;
	}
	
	public static Element getReflect(String id){
		Element subEl = getChild(configEL.getChild("reflect-mapping"), "id", id);
		return subEl;
	}
	
	public static String getReflectClass(String id) throws Exception{
		Element subEl = getReflect(id);
		if(subEl == null){
			throw new Exception("没有找到关联的类");
		}
		return getAttributeString(subEl, "class");
	}
	public static String getReflectMethod(String id) throws Exception{
		Element subEl = getReflect(id);
		if(subEl == null){
			throw new Exception("没有找到关联的方法:" + id);
		}
		return getAttributeString(subEl, "method");
	}
	
	/**
	 * 返回属性值。如果属性不存在，返回空串：“”。
	 * @param element	org.jdom.Element元素
	 * @param name		 属性名称
	 * @return				 属性值
	 */
	private static String getAttributeString(Element element, String name) {
		String attributeValue = element.getAttributeValue(name);
		if (attributeValue == null) {
			attributeValue = "";
		}
		return attributeValue;
	}
	
	/**
	 * 解析XML文档为orj.jdom.Element元素从URL统一资源定义器
	 *
	 * @param	 url	URL
	 * @return	org.jdom.Element元素
	 */
	public static synchronized Element load(URL url) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document xmlJDoc = builder.build(url);
			return xmlJDoc.getRootElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 返回满足属性条件的子节点
	 * 
	 * @param el		 org.jdom.Element元素
	 * @param name	 子节点的属性名
	 * @param value	子节点的属性值
	 * @return 子节点,如果没找到,返回null
	 */
	public static Element getChild(Element el, String name, String value){
		if (value != null) {
			List<?> elementLT = el.getChildren();
			int listLength = elementLT.size();
			for (int i = 0; i < listLength; i++) {
				Element subEL = (Element)elementLT.get(i);
				String attrValue = subEL.getAttributeValue(name);
				if (attrValue != null) {
					if (attrValue.equals(value)) {
						return subEL;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 返回WebServices的配置信息。
	 * 
	 * @return 配置文件的org.jdom.Element对象形式 
	 */
	public static Element getConfig() {
		return configEL;
	}
}
