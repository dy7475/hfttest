package com.myfun.repository.support.generator;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 生成通用mapper类
 * 
 * @ClassName: BaseMapperGeneratorPlugin
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月21日 下午2:50:44
 *
 */
public class BaseMapperGeneratorPlugin extends PluginAdapter {

    public BaseMapperGeneratorPlugin() {
        super();
    }

    
	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	/**
	 * 获取主键主键类型
	 * 
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	protected FullyQualifiedJavaType getPKType(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		//如果是生成erpdb信息则需要做特殊处理 
		FullyQualifiedJavaType poType = null;
		List<IntrospectedColumn> pkList = introspectedTable.getPrimaryKeyColumns();
		if(introspectedTable.getPrimaryKeyType().contains("erpdb")){
			if (pkList.size() == 1) {
				poType = getPOType(interfaze, topLevelClass, introspectedTable);
			} else if (pkList.size() != 1) {
			    if("flat".equals(getContext().getDefaultModelType().toString().toLowerCase())){
			        poType = getPOType(interfaze, topLevelClass, introspectedTable);
			    }else{
			        poType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
			    }
			}
			
		}else{
			if (pkList.size() == 1) {
				poType = pkList.get(0).getFullyQualifiedJavaType();
			} else if (pkList.size() != 1) {
			    if("flat".equals(getContext().getDefaultModelType().toString().toLowerCase())){
                    poType = getPOType(interfaze, topLevelClass, introspectedTable);
                }else{
                    poType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
                }
			}
		}
		return poType;

	}

	/**
	 * 获取po类型
	 * 
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @return
	 */
	protected FullyQualifiedJavaType getPOType(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		FullyQualifiedJavaType pkType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
		String str = pkType.getPackageName() + "." + introspectedTable.getFullyQualifiedTable().getDomainObjectName();

		FullyQualifiedJavaType poType = new FullyQualifiedJavaType(str);
		return poType;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// 获取类型
		FullyQualifiedJavaType baseMapperType = new FullyQualifiedJavaType("com.myfun.repository.support.mybatis.api.BaseMapper");
		FullyQualifiedJavaType poType = getPOType(interfaze, topLevelClass, introspectedTable);
		FullyQualifiedJavaType keyType = getPKType(interfaze, topLevelClass, introspectedTable);
		
		// 添加引用类型
		interfaze.addImportedType(baseMapperType);
		interfaze.addImportedType(poType);
		interfaze.addImportedType(keyType);
		
		// 生成继承关系
		baseMapperType.addTypeArgument(poType);
		baseMapperType.addTypeArgument(keyType);
		interfaze.addSuperInterface(baseMapperType);
		return true;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}
}
