package com.myfun.repository.support.generator;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 生成代码是追加分库信息
 * 
 * @ClassName: ShardDbGeneratorPlugin
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月13日 下午6:03:37
 *
 */
public class ShardDbGeneratorPlugin extends PluginAdapter {

	private FullyQualifiedJavaType shardDbClass;
	
	public ShardDbGeneratorPlugin() {
		super();
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		shardDbClass = new FullyQualifiedJavaType(properties.getProperty("shardDbClass"));
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
		topLevelClass.addImportedType(shardDbClass);
		topLevelClass.setSuperClass(shardDbClass);

		// 添加空构造函数
		Method emptyMethod = new Method();
		emptyMethod.setConstructor(true);
		if (introspectedTable.getPrimaryKeyColumns().size() > 1) {
		    if("flat".equals(getContext().getDefaultModelType().toString().toLowerCase())){
		        emptyMethod.setName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
		    }else{
		        FullyQualifiedJavaType poType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
		        emptyMethod.setName(poType.getShortName());
		    }
		} else {
			emptyMethod.setName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
		}
		emptyMethod.setVisibility(JavaVisibility.PUBLIC);
		emptyMethod.addBodyLine("");
		context.getCommentGenerator().addGeneralMethodComment(emptyMethod, introspectedTable);
		topLevelClass.addMethod(emptyMethod);

		// 添加分裤构造函数
		Method method = new Method();
		method.setConstructor(true);
		method.setVisibility(JavaVisibility.PUBLIC);
		if (introspectedTable.getPrimaryKeyColumns().size() > 1) {
		    if("flat".equals(getContext().getDefaultModelType().toString().toLowerCase())){
		        method.setName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
            }else{
                FullyQualifiedJavaType poType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
                method.setName(poType.getShortName());
            }
		} else {
			method.setName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
		}
		// 默认按照shardCityId分裤
		method.addParameter(new Parameter(new FullyQualifiedJavaType("Integer"), "shardCityId")); //$NON-NLS-1$
		method.addBodyLine("super(shardCityId);");
		Iterator<IntrospectedColumn> keyIt = introspectedTable.getPrimaryKeyColumns().iterator();
		while (keyIt.hasNext()) {
			IntrospectedColumn column = keyIt.next();
			String property = column.getJavaProperty();
			method.addParameter(new Parameter(column.getFullyQualifiedJavaType(), property));
			method.addBodyLine("this." + property + " = " + property + ";");
		}
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
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
		topLevelClass.addImportedType(shardDbClass);
		topLevelClass.setSuperClass(shardDbClass);
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}
}
