package com.myfun.repository.support.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 生成solr注解
 * 
 * @ClassName: SolrAnnotationGeneratorPlugin
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月21日 下午2:50:44
 *
 */
public class SolrAnnotationGeneratorPlugin extends PluginAdapter {

	public static Set<String> SOLR_ANNOTATION_SET = new HashSet<String>();

	static {
		SOLR_ANNOTATION_SET.add("FUN_SALE");
		SOLR_ANNOTATION_SET.add("FUN_LEASE");

		SOLR_ANNOTATION_SET.add("SALE_IN");
		SOLR_ANNOTATION_SET.add("SALE_2");
		SOLR_ANNOTATION_SET.add("SALE_3");
		SOLR_ANNOTATION_SET.add("SALE_4");

		SOLR_ANNOTATION_SET.add("LEASE_IN");
		SOLR_ANNOTATION_SET.add("LEASE_2");
		SOLR_ANNOTATION_SET.add("LEASE_3");
		SOLR_ANNOTATION_SET.add("LEASE_4");

		SOLR_ANNOTATION_SET.add("HEZU");
		SOLR_ANNOTATION_SET.add("HEZU_2");
		SOLR_ANNOTATION_SET.add("HEZU_3");
		SOLR_ANNOTATION_SET.add("HEZU_4");

		SOLR_ANNOTATION_SET.add("SHOP_MAIN");
		SOLR_ANNOTATION_SET.add("SHOP_2");
		SOLR_ANNOTATION_SET.add("SHOP_3");
		SOLR_ANNOTATION_SET.add("SHOP_4");
	}

	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return true;
	}

	/**
	 * 添加solr注释
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String tbName = introspectedTable.getTableConfiguration().getTableName();
		if (tbName != null && tbName.length() > 0) {
			if (SOLR_ANNOTATION_SET.contains(tbName.toUpperCase())) {
				topLevelClass.addImportedType("org.apache.solr.client.solrj.beans.Field");
			}
		}

		return true;
	}

	@Override
	public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType) {
		String tbName = introspectedTable.getTableConfiguration().getTableName();
		if (tbName != null && tbName.length() > 0) {
			if (SOLR_ANNOTATION_SET.contains(tbName.toUpperCase())) {
				field.addAnnotation("@Field(value = \"" + introspectedColumn.getActualColumnName().toUpperCase() + "\")");
			}
		}
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String tbName = introspectedTable.getTableConfiguration().getTableName();
		if (tbName != null && tbName.length() > 0) {
			if (SOLR_ANNOTATION_SET.contains(tbName.toUpperCase())) {
				topLevelClass.addImportedType("org.apache.solr.client.solrj.beans.Field");
			}
		}
		return true;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}
}
