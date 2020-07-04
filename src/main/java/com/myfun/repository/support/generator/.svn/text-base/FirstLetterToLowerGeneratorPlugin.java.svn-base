package com.myfun.repository.support.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * po 首字母小写扩展
 * 
 * @ClassName: FirstLetterToLowerGeneratorPlugin
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月8日 下午1:39:36
 *
 */
public class FirstLetterToLowerGeneratorPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

		// 是否采用数据真实字段做为属性名称
		String useActualColumnNames = introspectedTable.getTableConfigurationProperty("useActualColumnNames");
		if ("true".equals(useActualColumnNames)) {
			String lowerFieldName = buildHumpFieldName(field.getName());
			field.setName(lowerFieldName);
		}

		return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		// 是否采用数据真实字段做为属性名称
		String useActualColumnNames = introspectedTable.getTableConfigurationProperty("useActualColumnNames");
		if ("true".equals(useActualColumnNames)) {
			String lowerFieldName = buildHumpFieldName(introspectedColumn.getActualColumnName());

			method.getBodyLines().clear();
			method.addBodyLine("return " + lowerFieldName + ";");

			method.setName(buildMethodNameByField(lowerFieldName, "get"));
		}
		return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
	}

	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		// 是否采用数据真实字段做为属性名称
		String useActualColumnNames = introspectedTable.getTableConfigurationProperty("useActualColumnNames");
		if ("true".equals(useActualColumnNames)) {
			String lowerFieldName = buildHumpFieldName(introspectedColumn.getActualColumnName());

			String bodyLine = "this." + lowerFieldName + " = " + lowerFieldName + ";";
			method.getBodyLines().clear();
			method.addBodyLine(bodyLine);

			Parameter parameter = new Parameter(introspectedColumn.getFullyQualifiedJavaType(), lowerFieldName);
			method.getParameters().clear();
			method.addParameter(parameter);

			method.setName(buildMethodNameByField(lowerFieldName, "set"));

			introspectedColumn.setJavaProperty(lowerFieldName);
		}

		return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
	}

	/**
	 * 构建驼峰格式的属性
	 * 
	 * @param field
	 * @return
	 */
	public static String buildHumpFieldName(String field) {
		if (field == null || field.length() == 0) {
			return field;
		}

		if (field.contains("_")) {
			field = field.toLowerCase();
		} else {
			field = buildFirstLetterLower(field);
		}

		String[] humpArray = field.split("_");
		StringBuilder finalSb = new StringBuilder();
		for (int i = 0; i < humpArray.length; i++) {
			if (i > 0) {
				finalSb.append(buildFirstLetterUpper(humpArray[i]));
			} else {
				finalSb.append(humpArray[i]);
			}
		}

		return finalSb.toString();
	}

	public static String buildFirstLetterLower(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String buildFirstLetterUpper(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 生成驼峰方法名称，把下划线后面的首字母大写
	 * 
	 * @param methodName
	 * @return
	 */
	public static String buildMethodNameByField(String field, String pre) {
		if (field == null || field.length() == 0) {
			return field;
		}

		// 如果第二个字母是大写 则不转换首字母
		char[] ch = field.toCharArray();
		if ((ch.length > 2) && (ch[1] >= 'A') && (ch[1] <= 'Z')) {
			return pre + field;
		} else {
			return pre + buildFirstLetterUpper(field);
		}
	}
}
