package com.myfun.utils.poCovert.utils;

import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.utils.StringUtil;
import com.myfun.utils.poCovert.annotation.DicConvert;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DicValueConverter {

	/**
	 * 自动转换字典的CN值
	 * @author 陈文超
	 * @date 2016年6月1日 下午5:33:06
	 */
	public static void dicConvertVoCN(Map<String, Map<String, Map<String,ErpDicDefinitions>>> dicMap , Object aimVo , String cityId) throws Exception {
		Field [] aimFields = aimVo.getClass().getDeclaredFields();
		for (Field aimField : aimFields) {
			aimField.setAccessible(true);
			DicConvert dicConvert = aimField.getAnnotation(DicConvert.class);
			if(dicConvert != null){
				String dicTypeStr = dicConvert.dicTypeStr();
				String fromFieldName = dicConvert.fromFieldName();
				if(!StringUtil.isEmpty(dicTypeStr) && !StringUtil.isEmpty(fromFieldName)){
					Map<String, Map<String,ErpDicDefinitions>> tmpDic = dicMap.get(dicTypeStr + "_" + cityId);
					if(tmpDic == null || tmpDic.isEmpty()){
						tmpDic = dicMap.get(dicTypeStr + "_0");
					}
					if(tmpDic == null || tmpDic.isEmpty()){
						continue;
					}
					Field fromField = aimVo.getClass().getDeclaredField(fromFieldName);
					fromField.setAccessible(true);
					String fromFieldValue = String.valueOf(fromField.get(aimVo));//字典转换默认规范使用string类型
					if(!StringUtil.isEmpty(fromFieldValue)){
						ErpDicDefinitions tmpDicObj = tmpDic.get(dicTypeStr).get(fromFieldValue);
						if(tmpDicObj != null){
							String dicCnValue = tmpDicObj.getDicCnMsg();
							if(!StringUtil.isEmpty(dicCnValue)){
								aimField.set(aimVo, dicCnValue);
							}else{
								aimField.set(aimVo, fromFieldValue);//如果为空则设置为原始值
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 自动转换字典的CN值
	 * 分割字符转换字典值，最后再由指定分割符显示
	 * splitStr:参数以splitStr符号分割
	 * connectSplitStr:参数以转换完后再由符号连接
	 * @author 陈文超
	 * @date 2016年6月5日 下午4:11:38
	 */
	public static void dicConvertVoCN(Map<String, Map<String, Map<String,ErpDicDefinitions>>> dicMap , Object aimVo , String cityId , String splitStr , String connectSplitStr) throws Exception {
		List<Class> voClazzList = new LinkedList<>();
		Class voClazz = aimVo.getClass();
		while (!Object.class.getCanonicalName().equals(voClazz.getCanonicalName())) {
			voClazzList.add(voClazz);
			voClazz = voClazz.getSuperclass();
		}
		for (Class clazz: voClazzList) {
			Field [] aimFields = clazz.getDeclaredFields();
			for (Field aimField : aimFields) {
				aimField.setAccessible(true);
				DicConvert dicConvert = aimField.getAnnotation(DicConvert.class);
				if(dicConvert != null){
					String dicTypeStr = dicConvert.dicTypeStr();
					String fromFieldName = dicConvert.fromFieldName();
					if(!StringUtil.isEmpty(dicTypeStr) && !StringUtil.isEmpty(fromFieldName)){
						Map<String, Map<String,ErpDicDefinitions>> tmpDic = dicMap.get(dicTypeStr + "_" + cityId);
						if(tmpDic == null || tmpDic.isEmpty()){
							tmpDic = dicMap.get(dicTypeStr + "_0");
						}
						if(tmpDic == null || tmpDic.isEmpty()){
							continue;
						}
						Field fromField = clazz.getDeclaredField(fromFieldName);
						fromField.setAccessible(true);
						String fromFieldValue = String.valueOf(fromField.get(aimVo));//字典转换默认规范使用string类型
						if(!StringUtil.isEmpty(fromFieldValue)){
							if(fromFieldValue.split(splitStr).length > 1){
								StringBuilder sb = new StringBuilder();
								String [] convertValues = fromFieldValue.split(Pattern.quote(splitStr));
								for(String tmp : convertValues){
									ErpDicDefinitions tmpDicObj = tmpDic.get(dicTypeStr).get(tmp);
									if(tmpDicObj != null){
										String dicCnValue = tmpDicObj.getDicCnMsg();
										sb.append(dicCnValue).append(connectSplitStr);
									}
								}
								if(StringUtil.isEmpty(connectSplitStr)){
									connectSplitStr = ",";//默认使用逗号分割
								}
								if(sb.toString().length() > 0){
									int length = connectSplitStr.length();
									for(int i = 0 ; i < length ; i++){
										sb.deleteCharAt(sb.toString().length() - 1);
									}
									aimField.set(aimVo, sb.toString());
								}else{
									aimField.set(aimVo, fromFieldValue);//如果为空则设置为原始值
								}
							}else{
								ErpDicDefinitions tmpDicObj = tmpDic.get(dicTypeStr).get(fromFieldValue);
								if(tmpDicObj != null){
									String dicCnValue = tmpDicObj.getDicCnMsg();
									if(!StringUtil.isEmpty(dicCnValue)){
										aimField.set(aimVo, dicCnValue);
									}else{
										aimField.set(aimVo, fromFieldValue);//如果为空则设置为原始值
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 自动转换字典的EN值
	 * @author 陈文超
	 * @date 2016年6月1日 下午5:33:06
	 */
	public static void dicConvertVoEN(Map<String, Map<String, Map<String,ErpDicDefinitions>>> dicMap , Object aimVo , String cityId) throws Exception {
		Field [] aimFields = aimVo.getClass().getDeclaredFields();
		for (Field aimField : aimFields) {
			aimField.setAccessible(true);
			DicConvert dicConvert = aimField.getAnnotation(DicConvert.class);
			if(dicConvert != null){
				String dicTypeStr = dicConvert.dicTypeStr();
				String fromFieldName = dicConvert.fromFieldName();
				if(!StringUtil.isEmpty(dicTypeStr) && !StringUtil.isEmpty(fromFieldName)){
					Map<String, Map<String,ErpDicDefinitions>> tmpDic = dicMap.get(dicTypeStr + "_" + cityId);
					if(tmpDic == null || tmpDic.isEmpty()){
						tmpDic = dicMap.get(dicTypeStr + "_0");
					}
					if(tmpDic == null || tmpDic.isEmpty()){
						continue;
					}
					Field fromField = aimVo.getClass().getDeclaredField(fromFieldName);
					fromField.setAccessible(true);
					String fromFieldValue = String.valueOf(fromField.get(aimVo));//字典转换默认规范使用string类型
					if(!StringUtil.isEmpty(fromFieldValue)){
						ErpDicDefinitions tmpDicObj = tmpDic.get(dicTypeStr).get(fromFieldValue);
						if(tmpDicObj != null){
							String dicEnValue = tmpDicObj.getDicEnMsg();
							if(!StringUtil.isEmpty(dicEnValue)){
								aimField.set(aimVo, dicEnValue);
							}else{
								aimField.set(aimVo, fromFieldValue);//如果为空则设置为原始值
							}
						}
					}
				}
			}
		}
	}
}
