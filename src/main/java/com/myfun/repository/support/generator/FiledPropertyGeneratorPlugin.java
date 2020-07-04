package com.myfun.repository.support.generator;

import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 生成字段注释信息
 * 
 * @ClassName: ShardDbGeneratorPlugin
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月13日 下午6:03:37
 *
 */
public class FiledPropertyGeneratorPlugin extends PluginAdapter {

	private FullyQualifiedJavaType filedPropertyClass;

	public FiledPropertyGeneratorPlugin() {
		super();
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		filedPropertyClass = new FullyQualifiedJavaType(properties.getProperty("filedPropertyClass"));
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 如果是多主键 则不生成分裤标记
		//if (introspectedTable.getPrimaryKeyColumns().size() < 2) {
			makeSerializable(topLevelClass, introspectedTable);
		//}
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// makeSerializable(topLevelClass, introspectedTable);
		return true;
	}

	/**
	 * 添加分库属性 继承shardDbClass 实现构造函数
	 * 
	 * @param topLevelClass
	 * @param introspectedTable
	 */
	protected void makeSerializable(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.addImportedType(filedPropertyClass);
	}

	/**
	 * 重写查询参数
	 */
	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.getParameters().clear();
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()), "record"));
		return true;
	}

	/**
	 * 重写删除操作
	 */
	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
		method.getParameters().clear();
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()), "record"));
		return true;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		method.getParameters().clear();
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()), "record"));
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
}
