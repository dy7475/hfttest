package com.myfun.repository.support.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * 
 * @ClassName: CustCommentGenerator
 * @Description: 生成持久层注释类
 * @author jiangsonggui
 * @date 2015年10月26日 下午7:15:54
 *
 */
public class CustCommentGenerator implements CommentGenerator {
	private Properties properties;
	private boolean suppressDate;
	private boolean suppressAllComments;

	String classPathEntry = "";
	String driverClass = "";
	String connectionURL = "";
	String userId = "";
	String password = "";

	private Connection connection;

	// private static String MS_COLUMN_SQL = "SELECT A.name AS table_name,
	// B.name AS column_name, C.value AS column_description FROM sys.tables A
	// INNER JOIN sys.columns B ON B.object_id = A.object_id LEFT JOIN
	// sys.extended_properties C ON C.major_id = B.object_id AND C.minor_id =
	// B.column_id WHERE A.name = ? AND B.name = ?";
	private static String MS_COLUMN_SQL = "SELECT A.name AS table_name, B.name AS column_name, C.value AS column_description FROM sys.tables A INNER JOIN sys.columns B ON B.object_id = A.object_id LEFT JOIN sys.extended_properties C ON C.major_id = B.object_id AND C.minor_id = B.column_id  WHERE A.name = ?";

	// private static String MYSQL_SQL = "SELECT DISTINCT TABLE_NAME AS
	// `table_name`,COLUMN_NAME as `column_name`, COLUMN_COMMENT as
	// `column_description` FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?
	// AND COLUMN_NAME=? AND TABLE_SCHEMA = 'txhouse_cd'";
	private static String MYSQL_SQL = "SELECT DISTINCT TABLE_NAME AS `table_name`,COLUMN_NAME as `column_name`, COLUMN_COMMENT as `column_description` FROM INFORMATION_SCHEMA.COLUMNS  WHERE TABLE_NAME = ? AND TABLE_SCHEMA = 'txhouse_cd'";

	private Boolean IS_SQLSERVER = false;

	/** 缓存table注释 tableName->(column->description) **/
	private Map<String, Map<String, String>> tableCache = new HashMap<String, Map<String, String>>();

	public CustCommentGenerator() {
		super();
		properties = new Properties();
		suppressDate = false;
		suppressAllComments = false;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	private Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionURL, userId, password);
			return connection;
		} catch (Exception se) {
			throw new RuntimeException(se);
		}
	}

	/**
	 * 获取表注释
	 * 
	 * @param tableName
	 * @param column
	 * @return
	 * @throws SQLException
	 */
	public String getDescreption(String tableName, String column) throws SQLException {
		Map<String, String> columns = tableCache.get(tableName.toLowerCase());
		if (columns == null) {
			columns = new HashMap<String, String>();
			tableCache.put(tableName.toLowerCase(), columns);

			Connection connection = getConnection();
			PreparedStatement ps = IS_SQLSERVER ? connection.prepareStatement(MS_COLUMN_SQL) : connection.prepareStatement(MYSQL_SQL);
			ps.setString(1, tableName);
			// ps.setString(2, column);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String description =  rs.getString("column_description");
				if(!IS_SQLSERVER){
					description = latinToGBK(description);
				}
				columns.put(rs.getString("column_name").toLowerCase(), description);
			}
		}

		return columns.get(column.toLowerCase());
	}

	public void addJavaFileComment(CompilationUnit compilationUnit) {
		return;
	}

	public void addComment(XmlElement xmlElement) {
		if (suppressAllComments) {
			return;
		}
		xmlElement.addElement(new TextElement("<!--" + MergeConstants.NEW_ELEMENT_TAG + "-->"));
	}

	public void addRootComment(XmlElement rootElement) {
		return;
	}

	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
		suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
		suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

		driverClass = properties.getProperty("driverClass");
		connectionURL = properties.getProperty("connectionURL");
		userId = properties.getProperty("userId");
		password = properties.getProperty("password");

		if (driverClass.toLowerCase().contains("jtds")) {
			IS_SQLSERVER = true;
		}

		classPathEntry = properties.getProperty("classPathEntry");

		// 加载驱动
		try {
			java.lang.reflect.Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
			addURL.setAccessible(true);

			addURL.invoke(CustCommentGenerator.class.getClassLoader(), new Object[] { new File(classPathEntry).toURI().toURL() });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		javaElement.addJavaDocLine(" *");
		StringBuilder sb = new StringBuilder();
		sb.append(" * ");
		sb.append(MergeConstants.NEW_ELEMENT_TAG);
		if (markAsDoNotDelete) {
			sb.append(" do_not_delete_during_merge");
		}
		String s = getDateString();
		if (s != null) {
			sb.append(' ');
			sb.append(s);
		}
		javaElement.addJavaDocLine(sb.toString());
	}

	protected String getDateString() {
		if (suppressDate) {
			return null;
		} else {
			return new Date().toString();
		}
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		innerClass.addJavaDocLine("/**");
		addJavadocTag(innerClass, false);
		innerClass.addJavaDocLine(" */");
	}

	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		innerEnum.addJavaDocLine("/**");
		addJavadocTag(innerEnum, false);
		innerEnum.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		field.addJavaDocLine("/**");
		addJavadocTag(field, false);
		String description = null;
		field.addJavaDocLine(" */");
		try {
			description = getDescreption(introspectedTable.getTableConfiguration().getTableName(), introspectedColumn.getActualColumnName());
//			if (isBlank(description)) {
//				description = "-";
//			}
			field.addAnnotation("@ApiModelProperty(value= \"" + description + "\")");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		if (description != null) {
//			field.addJavaDocLine(description);
//		}
//
//		field.addJavaDocLine(" */");
	}

	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		field.addJavaDocLine("/**");
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}

	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}
		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" */");
	}

	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		String description = null;
		try {
			description = getDescreption(introspectedTable.getTableConfiguration().getTableName(), introspectedColumn.getActualColumnName());
			if (isBlank(description)) {
				description = "-";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" * " + description);
		method.addJavaDocLine(" */");
	}

	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}
		String description = null;
		try {
			description = getDescreption(introspectedTable.getTableConfiguration().getTableName(), introspectedColumn.getActualColumnName());
			if (isBlank(description)) {
				description = "-";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		method.addJavaDocLine("/**");
		addJavadocTag(method, false);
		method.addJavaDocLine(" * " + description);
		method.addJavaDocLine(" */");
	}

	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
			return;
		}
		innerClass.addJavaDocLine("/**");
		addJavadocTag(innerClass, markAsDoNotDelete);
		innerClass.addJavaDocLine(" */");
	}

	public static String latinToGBK(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return str;
		}
	}
	
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
