<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
<generatorConfiguration>
	<!-- 驱动路径 -->
	<!-- <classPathEntry location="D:\mavenRepository\net\sourceforge\jtds\jtds\1.2\jtds-1.2.jar" 
		/> -->
	<classPathEntry
		location="D:\mavenRepository\net\sourceforge\jtds\jtds\1.2.2\jtds-1.2.2.jar" />
	<context id="context1" targetRuntime="MyBatis3">
		<commentGenerator
			type="com.myfun.repository.support.generator.MyCommentGenerator">
			<!-- 是否去除自动生成的注释 true：是 ： false:否 -->
			<property name="suppressAllComments" value="false" />
			<property name="suppressDate" value="true" />
		</commentGenerator>
		<jdbcConnection driverClass="${driverClass}"
			connectionURL="${connectionURL}"
			userId="${userId}" password="${password}">
		</jdbcConnection>
		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>
		<javaModelGenerator targetPackage="com.myfun.repository.po.admindb"
			targetProject="repository">
			<property name="trimStrings" value="true" />
			<property name="defaultModelType" value="flat" />
		</javaModelGenerator>
		<sqlMapGenerator targetPackage="com.myfun.repository.mapper.admindb"
			targetProject="repository">
		</sqlMapGenerator>
		<javaClientGenerator type="XMLMAPPER"
			targetPackage="com.myfun.repository.dao.admindb" targetProject="repository">
		</javaClientGenerator>
		<table tableName="DIC_DEFINITIONS" domainObjectName="AdminDicDefinitons"
			enableCountByExample="false" enableUpdateByExample="false"
			enableDeleteByExample="false" enableSelectByExample="false"
			selectByExampleQueryId="false">
		</table>
	</context>
</generatorConfiguration>