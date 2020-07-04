package com.myfun.framework.web.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.myfun.framework.annotation.CharsetUrlEncode;
import com.myfun.framework.annotation.CommonField;
import com.myfun.framework.annotation.DefaultValue;
import com.myfun.framework.annotation.HouseFloorRule;
import com.myfun.framework.annotation.HtmlStringFilter;
import com.myfun.framework.annotation.NumberFormat;
import com.myfun.repository.support.generator.shard.ShardDb;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.RegExUtils;
import com.myfun.utils.StringUtil;

/**
 * 用于前端将PO转换成vo
 * 
 * @author 陈文超
 * @date 2016年6月1日 上午11:04:53
 */
public class PoConverterToView {

	/**
	 * 敏感词过滤
	 */
	private static String filterCharsetRegEx = "";

	public static String getFilterCharsetRegEx() {
		return filterCharsetRegEx;
	}

	public static void setFilterCharsetRegEx(String filterCharsetRegEx) {
		PoConverterToView.filterCharsetRegEx = filterCharsetRegEx;
	}

	/**
	 * 获取来源子类父类的class集合
	 * 
	 * @author 陈文超
	 * @date 2018年3月30日 下午2:00:14
	 */
	private static List<Class> getAllClass(Class srcClassParam) {
		List<Class> clazzList = new LinkedList<>();
		while (!Object.class.getSimpleName().equals(srcClassParam.getSimpleName())
				&& !ShardDb.class.getSimpleName().equals(srcClassParam.getSimpleName())) {
			clazzList.add(srcClassParam);
			srcClassParam = srcClassParam.getSuperclass();
		}
		return clazzList;
	}

	/**
	 * 获取目标子类父类的field集合
	 * 
	 * @author 陈文超
	 * @date 2018年3月30日 下午1:52:12
	 */
	private static List<Field> getAllField(Class aimClassParam) {
		// 目标对象字段
		List<Field> aimFields = new LinkedList<>();
		while (!Object.class.getSimpleName().equals(aimClassParam.getSimpleName())
				&& !ShardDb.class.getSimpleName().equals(aimClassParam.getSimpleName())) {
			aimFields.addAll(Arrays.asList(aimClassParam.getDeclaredFields()));
			aimClassParam = aimClassParam.getSuperclass();
		}
		return aimFields;
	}

	/**
	 * 来源bean对象 与 目标bean对象的字段赋值
	 * 
	 * @author 陈文超
	 * @throws Exception
	 * @throws @date
	 *             2017年2月17日 下午3:06:48
	 */
	public static void setFieldValue(Object srcObj, Object aimObj, Byte caseType) throws Exception {
		List<Class> srcClasss = getAllClass(srcObj.getClass());
		List<Field> aimFields = getAllField(aimObj.getClass());
		// 设置字段
		for (Field aimField : aimFields) {
			aimField.setAccessible(true);
			// 如果注解都为空，则跳过
			CommonField commonFieldAnn = aimField.getAnnotation(CommonField.class);
			if (commonFieldAnn == null) {
				continue;
			}

			// 如果声明的别名为空，则跳过
			String[] poFieldNameS = commonFieldAnn.poFieldValues();
			if (poFieldNameS.length == 0) {
				continue;
			}

			// 根据注解设置的PO对象属性名获取来源对象的属性对象
			for (Class tmpClazz : srcClasss) {
				// 如果为空则再获取一次通用属性名尝试获取值
				for (String poFieldName : poFieldNameS) {
					try {
						Field srcField = tmpClazz.getDeclaredField(poFieldName);
						srcField.setAccessible(true);

						Object poValue = srcField.get(srcObj);
						if (poValue != null) {

							if (poValue instanceof Date) { // 时间默认转换成字符串-陈文超
								poValue = DateTimeHelper.formatDateTimetoString((Date) poValue, "yyyy-MM-dd HH:mm:ss");
							} else if (poValue instanceof Boolean) { // boolean转换成字符串"1"或"0"-李海森
								poValue = (Boolean) poValue ? "1" : "0";
							}

							Class<?> fromClass = poValue.getClass();
							Class<?> toClass = aimField.getType();
							if (toClass != fromClass) { // 字段类型不统一时，通过parse[ClassName]兼容
								Class<?> clazz = Class.forName(toClass.getName());
								Method method = null;
								if (toClass.equals(Integer.class)) {
									method = clazz.getDeclaredMethod("parseInt", String.class);
								} else if (toClass.equals(String.class)) {
									aimField.set(aimObj, poValue.toString());
								} else {
									method = clazz.getDeclaredMethod("parse" + toClass.getSimpleName(), String.class);
								}

								if (method != null) {
									aimField.set(aimObj, method.invoke(null, poValue.toString()));
								}
							} else {
								aimField.set(aimObj, poValue);
							}
						}
					} catch (Exception ignored) {
					}
				}
			}
		}
	}

	/**
	 * 将PO转换成VO
	 * 
	 * @author 陈文超
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @date 2016年6月1日 上午11:16:41
	 */
	public static <T> T convertPoToVo4String(Object srcPo, Class<T> aimVo) {

		if (srcPo == null) {
			return null;
		}

		// 目标对象
		T tObj = null;
		try {
			tObj = aimVo.newInstance();
			setFieldValue(srcPo, tObj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return tObj;
	}

	/**
	 * 设置VO的默认值 通过注解对VO的属性值进行一次过滤执行
	 * 
	 * @author 陈文超
	 * @date 2016年7月1日 下午3:07:56
	 */
	public static void exeAnnotationFilter(Object srcPo) throws Exception {
		Field[] srcFields = srcPo.getClass().getDeclaredFields();
		for (Field srcField : srcFields) {
			DefaultValue defaultObj = srcField.getAnnotation(DefaultValue.class);
			srcField.setAccessible(true);
			Object poValue = srcField.get(srcPo);
			if (defaultObj != null) {
				if (poValue == null) {
					srcField.set(srcPo, defaultObj.value());
				}
			}

			NumberFormat needNumberFormat = srcField.getAnnotation(NumberFormat.class);
			if (needNumberFormat != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					if (poValue instanceof BigDecimal) {
						poValue = BigDecimal.valueOf(StringUtil.parseDouble(NumberHelper
								.formatNumber(((BigDecimal) poValue).toString(), needNumberFormat.value())));
					} else {
						poValue = NumberHelper.formatNumber(String.valueOf(poValue), needNumberFormat.value());
					}
					srcField.set(srcPo, poValue);
				}
			}

			HtmlStringFilter htmlStringFilter = srcField.getAnnotation(HtmlStringFilter.class);
			if (htmlStringFilter != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					srcField.set(srcPo, StringUtil.replaceHtmlToBlank(poValue.toString()));
				}
			}

			CharsetUrlEncode charsetUrlEncode = srcField.getAnnotation(CharsetUrlEncode.class);
			if (charsetUrlEncode != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					poValue = URLEncoder.encode(String.valueOf(poValue), charsetUrlEncode.charset());
					srcField.set(srcPo, poValue);
				}
			}

			HouseFloorRule houseFloorRule = srcField.getAnnotation(HouseFloorRule.class);
			if (houseFloorRule != null) {
				// 总楼层数
				String floorsField = houseFloorRule.floorsFieldName();
				Field fromField = srcPo.getClass().getDeclaredField(floorsField);
				poValue = srcField.get(srcPo);
				if (poValue == null) {
					poValue = "0";
				}
				if (fromField != null) {
					fromField.setAccessible(true);
					Object floorsValue = fromField.get(srcPo);
					if (floorsValue != null) {
						double intFloor = StringUtil.parseDouble(poValue.toString());// 所在楼层
						double intFloors = StringUtil.parseDouble(floorsValue.toString());// 总楼层
						/*
						 * if (floors <= 3 || floorValue < floors / 3) {
						 * srcField.set(srcPo, "低楼层"); } else if (floors <= 6 ||
						 * floorValue < floors * 2 / 3) { srcField.set(srcPo,
						 * "中楼层"); } else { srcField.set(srcPo, "高楼层"); }
						 */
						// 1.总楼层不超过10层时：所在楼层在3层及以下时为低楼层，4-6层为中层，7-10为高层
						// 2.总楼层在11-40层之间时，按照总楼层/3计算，前1/3属于低楼层，中间1/3属于中楼层，后1/3属于高楼层
						// 3.所在楼层在41及以上时显示为超高层，前40层按照规则2计算。
						// 总楼层低于10
						String floorType = "";
						if (intFloors <= 10) {
							if (intFloor <= 3) {
								floorType = "低层";
							} else if (3 < intFloor && intFloor <= 6) {
								floorType = "中层";
							} else {
								floorType = "高层";
							}
						} else if (intFloors >= 11 && intFloors <= 40) {// 总楼层11--40
							double result = intFloors / 3;
							if (intFloor <= result) {
								floorType = "低层";
							} else if (result < intFloor && intFloor <= intFloors * (2 / 3)) {
								floorType = "中层";
							} else {
								floorType = "高层";
							}
						} else if (intFloors > 40) {// 总楼层>40
							if (intFloor <= 40 / 3) {
								floorType = "低层";
							} else if (40 / 3 < intFloor && intFloor <= (40 / 3) * 2) {
								floorType = "中层";
							} else if ((40 / 3) * 2 < intFloor && intFloor <= 40) {
								floorType = "高层";
							} else {
								floorType = "超高层";
							}
						}
						srcField.set(srcPo, floorType);
					}
					fromField.setAccessible(false);
				}
			}
			srcField.setAccessible(false);
		}
	}

	/**
	 * 设置VO的默认值 通过注解对VO的属性值进行一次过滤执行 不含对楼层的信息的处理 参考：exeAnnotationFilter的使用
	 * 
	 * @author 陈文超
	 * @date 2016年7月1日 下午3:07:56
	 */
	public static void exeAnnotationFilterNoneBuildRule(Object srcPo) throws Exception {
		Field[] srcFields = srcPo.getClass().getDeclaredFields();
		for (Field srcField : srcFields) {
			DefaultValue defaultObj = srcField.getAnnotation(DefaultValue.class);
			srcField.setAccessible(true);
			Object poValue = srcField.get(srcPo);
			if (defaultObj != null) {
				if (poValue == null) {
					srcField.set(srcPo, defaultObj.value());
				}
			}

			NumberFormat needNumberFormat = srcField.getAnnotation(NumberFormat.class);
			if (needNumberFormat != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					if (poValue instanceof BigDecimal) {
						poValue = BigDecimal.valueOf(StringUtil.parseDouble(NumberHelper
								.formatNumber(((BigDecimal) poValue).toString(), needNumberFormat.value())));
					} else {
						poValue = NumberHelper.formatNumber(String.valueOf(poValue), needNumberFormat.value());
					}
					srcField.set(srcPo, poValue);
				}
			}

			HtmlStringFilter htmlStringFilter = srcField.getAnnotation(HtmlStringFilter.class);
			if (htmlStringFilter != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					srcField.set(srcPo, StringUtil.replaceHtmlToBlank(poValue.toString()));
				}
			}

			CharsetUrlEncode charsetUrlEncode = srcField.getAnnotation(CharsetUrlEncode.class);
			if (charsetUrlEncode != null) {
				poValue = srcField.get(srcPo);
				if (poValue != null) {
					poValue = URLEncoder.encode(String.valueOf(poValue), charsetUrlEncode.charset());
					srcField.set(srcPo, poValue);
				}
			}

			srcField.setAccessible(false);
		}
	}

	/**
	 * 字符串处理类
	 */
	private static String charsetFilterMix(Object poValue) {
		if (!StringUtil.isEmpty(poValue.toString()) && !StringUtil.isEmpty(filterCharsetRegEx)) {
			List<String> tmps = RegExUtils.getMatchAllTexts("(" + filterCharsetRegEx + ")", poValue.toString());
			for (String tmpStr : tmps) {
				poValue = poValue.toString().replaceAll(tmpStr + "\\|", "");
				poValue = poValue.toString().replaceAll(tmpStr, "");
			}
		}
		return poValue.toString();
	}

	/**
	 * 将PO转换成VO
	 * 
	 * @author 陈文超
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @date 2016年6月1日 上午11:16:41
	 */
	public static <T> T convertPoToVo(Object srcPo, Class<T> aimVo) throws Exception {
		if (srcPo == null) {
			return null;
		}

		// 目标对象
		T tObj = aimVo.newInstance();
		setFieldValue(srcPo, tObj);
		return tObj;
	}

	/**
	 * 来源bean对象 与 目标bean对象的字段赋值
	 * 
	 * @author 陈文超
	 * @date 2017年2月17日 下午3:06:48
	 */
	private static void setFieldValue(Object srcObj, Object aimObj) throws Exception {
		// 来源对象类
		List<Class> clazzList = getAllClass(srcObj.getClass());
		// 目标对象字段
		List<Field> aimFields = getAllField(aimObj.getClass());

		// 设置字段
		for (Field aimField : aimFields) {
			aimField.setAccessible(true);

			// 如果注解都为空，则跳过
			String[] poFieldNameS = null;
			CommonField commonFieldAnn = aimField.getAnnotation(CommonField.class);
			if (commonFieldAnn == null) {
				// 如果没有注解则使用属性原有的名字
				poFieldNameS = new String[] { aimField.getName() };
			} else {
				// 如果声明的别名为空，则跳过
				poFieldNameS = commonFieldAnn.poFieldValues();
				if (poFieldNameS.length == 0) {
					continue;
				}
			}

			// 根据注解设置的PO对象属性名获取来源对象的属性对象
			for (Class tmpClazz : clazzList) {
				// 如果为空则再获取一次通用属性名尝试获取值
				for (String poFieldName : poFieldNameS) {
					try {
						Field srcField = tmpClazz.getDeclaredField(poFieldName);
						srcField.setAccessible(true);

						Object poValue = srcField.get(srcObj);
						if (poValue != null) {

							if (poValue instanceof Date) { // 时间默认转换成字符串-陈文超
								poValue = DateTimeHelper.formatDateTimetoString((Date) poValue, "yyyy-MM-dd HH:mm:ss");
							} else if (poValue instanceof Boolean && !aimField.getType().equals(Boolean.class)) { // boolean转换成字符串"1"或"0"-李海森
								poValue = (Boolean) poValue ? "1" : "0";
							}

							Class<?> fromClass = poValue.getClass();
							Class<?> toClass = aimField.getType();
							if (toClass != fromClass) { // 字段类型不统一时，通过parse[ClassName]兼容
								Class<?> clazz = Class.forName(toClass.getName());
								Method method = null;
								if (toClass.equals(Integer.class)) {
									method = clazz.getDeclaredMethod("parseInt", String.class);
								} else if (toClass.equals(String.class)) {
									aimField.set(aimObj, poValue.toString());
								} else if (toClass.equals(Boolean.class)) {
									aimField.set(aimObj, poValue.toString());
								} else {
									method = clazz.getDeclaredMethod("parse" + toClass.getSimpleName(), String.class);
								}

								if (method != null) {
									aimField.set(aimObj, method.invoke(null, poValue.toString()));
								}
							} else {
								aimField.set(aimObj, poValue);
							}
						}
					} catch (Exception ignored) {
					}
				}
			}
		}
	}

	/**
	 * 去掉value前后的空格 @param srcObj @throws Exception @throws
	 */
	public static void setFieldIsTrim(Object srcObj) {
		Field[] files = srcObj.getClass().getDeclaredFields();
		for (Field field : files) {
			String filename = field.getName();
			if ("serialVersionUID".equals(filename)) {
				continue;
			}
			try {
				field.setAccessible(true);
				Object object = field.get(srcObj);
				if (object != null && String.class.isInstance(object)) {
					field.getType();
					field.set(srcObj, object.toString().trim());
				}
			} catch (Exception e) {
				continue;
			}

		}
	}

	/**
	 * vo转po,变量名相同，类型相同可以不加注解
	 * 
	 * @param srcVo
	 * @param tarPoClass
	 * @param <T>
	 * @return
	 * @throws Exception
	 * @author 郭皓
	 */
	public static <T> T convertVoToPo(Object srcVo, Class<T> tarPoClass) throws Exception {
		if (srcVo == null)
			return null;
		T po = tarPoClass.newInstance();
		List<String> poClassFieldStrings = Arrays.stream(tarPoClass.getDeclaredFields()).parallel()
				.map(f -> f.getName()).collect(Collectors.toList());
		// vo类
		List<Class> voClazzList = new LinkedList<>();
		Class voClazz = srcVo.getClass();
		while (!Object.class.getCanonicalName().equals(voClazz.getCanonicalName())) {
			voClazzList.add(voClazz);
			voClazz = voClazz.getSuperclass();
		}

		for (Class voClass : voClazzList) {
			List<Field> fieldList = Arrays.asList(voClass.getDeclaredFields());
			fieldList.parallelStream().forEach((Field field) -> {
				try {
					field.setAccessible(true);
					Object voValue = field.get(srcVo);
					if (voValue == null)
						return; // 值为空,跳过

					CommonField commonField = field.getDeclaredAnnotation(CommonField.class); // 注解
					if (commonField == null) {
						if (poClassFieldStrings.contains(field.getName())) {
							Field noAnnoField = tarPoClass.getDeclaredField(field.getName());
							noAnnoField.setAccessible(true);
							noAnnoField.set(po, voValue);
						}
						return;
					}
					; // 注解为null,跳过
					String[] poFields = commonField.poFieldValues();
					if (poFields.length == 0)
						return; // 注解值为null,跳过
					for (String poField : poFields) {
						try {
							Field tarField = po.getClass().getDeclaredField(poField);
							tarField.setAccessible(true);

							if (tarField.getType().isAssignableFrom(Date.class)) { // po类型为时间
								voValue = DateTimeHelper.formatDateTimetoString((Date) voValue, "yyyy-MM-dd HH:mm:ss");
							}
							// TODO 其他类型转换待使用时添加
							tarField.set(po, voValue);
							break;
						} catch (Exception e) {
							continue;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		return po;
	}
}
