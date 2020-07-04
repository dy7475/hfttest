package com.myfun.repository.support.generator;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myfun.repository.support.generator.jdbc.Column;
import com.myfun.repository.support.generator.jdbc.Database;
import com.myfun.repository.support.generator.jdbc.DatabaseFactory;
import com.myfun.repository.support.generator.jdbc.Table;

/**
 * 生成mybaits生成代码配置文件
 * 
 * @ClassName: GeneratorMybatisGeneratorConfig
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月16日 下午12:00:07
 *
 */
public class GeneratorMybatisGeneratorConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorMybatisGeneratorConfig.class);
	private static String driverClass = "";
	private static String connectionURL = "";
	private static String userId = "";
	private static String password = "";
	private static String tbPrefix = "";

	public void initAdmin() {
		driverClass = "net.sourceforge.jtds.jdbc.Driver";
		connectionURL = "jdbc:jtds:sqlserver://192.168.0.243:33434;DatabaseName=hft_admindb";
		userId = "user_fafa";
		password = "user_fafa123456";
		tbPrefix = "Admin";
	}

	public void initErp() {
		driverClass = "net.sourceforge.jtds.jdbc.Driver";
		connectionURL = "jdbc:jtds:sqlserver://192.168.0.243:33434;DatabaseName=hft_erpdb_CD";
		userId = "user_fafa";
		password = "user_fafa123456";
		tbPrefix = "Erp";
	}

	public void initSoso() {
		driverClass = "net.sourceforge.jtds.jdbc.Driver";
		connectionURL = "jdbc:jtds:sqlserver://192.168.0.243:33434;DatabaseName=hft_searchdb";
		userId = "user_fafa";
		password = "user_fafa123456";
		tbPrefix = "Search";
	}

	public void initAgency() {
		driverClass = "net.sourceforge.jtds.jdbc.Driver";
		connectionURL = "jdbc:jtds:sqlserver://192.168.0.243:33434;DatabaseName=hft_agencydb";
		userId = "user_fafa";
		password = "user_fafa123456";
		tbPrefix = "Agency";
	}

	public void initTx() {
		driverClass = "com.mysql.jdbc.Driver";
		connectionURL = "jdbc:mysql://192.168.0.240:3306/txhouse_hft";
		userId = "root";
		password = "123456";
		tbPrefix = "Tx";
	}

	/**
	 * 生成配置文件
	 * 
	 * @throws Exception
	 */
	public void generator() throws Exception {
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(connectionURL, userId, password);
		Database database = DatabaseFactory.newDatabase(connection, null, null);
		String[] tablesName = database.getTableNames();
		LOGGER.info("扫描表数量->" + tablesName.length);
		StringBuilder configStr = new StringBuilder();
		for (int i = 0; i < tablesName.length; i++) {
			String tbName = tablesName[i];
			Table table = database.getTable(tbName);
			Column column = null;
			if (!table.getPrimaryKey().isEmpty()) {
				column = table.getPrimaryKey().get(0);
			}

			StringBuilder rowSb = new StringBuilder();
			try {
				rowSb.append("<table tableName=\"" + tbName + "\" domainObjectName=\"" + buildTbName(tbName) + "\""
						+ "enableCountByExample=\"false\" enableUpdateByExample=\"false\""
						+ "enableDeleteByExample=\"false\" enableSelectByExample=\"false\""
						+ "selectByExampleQueryId=\"false\">");

				// 判断是否自增
				String identityKey = isIdentity(connection, tbName);
				if (identityKey != null && identityKey.length() > 0) {
					rowSb.append("<generatedKey column=\"" + identityKey
							+ "\" sqlStatement=\"SqlServer\" identity=\"true\"/>");
				} else if (column != null) {
					// 判断是否蓄力
					String seqName = "SEQ_" + tbName + "_" + column.getName();
					if (hasSequences(connection, seqName)) {
						rowSb.append("<generatedKey column=\"" + column.getName()
								+ "\" sqlStatement=\"SELECT next value for " + seqName + "\"/>");
					}
				}
				rowSb.append("</table>");
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			LOGGER.info(i + "表信息->" + rowSb.toString());
			configStr.append(rowSb);
		}
		// LOGGER.info("配置文件信息->" + configStr.toString());
		writeStrToFile(configStr.toString());
	}

	/**
	 * 把内容写入文件
	 * 
	 * @param str
	 * @return
	 */
	public static boolean writeStrToFile(String str) {
		File file = new File("temp.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileUtils.writeStringToFile(file, str);
			return true;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return false;
	}

	/**
	 * 检查序列是否存在
	 * 
	 * @param connection
	 * @param sequences
	 * @return
	 * @throws Exception
	 */
	public static boolean hasSequences(Connection connection, String sequences) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT next value for ").append(sequences);
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sb.toString());
			if (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 判断表是否自增
	 * 
	 * @param connection
	 * @param tablseName
	 * @return
	 */
	public static String isIdentity(Connection connection, String tablseName) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.columns WHERE TABLE_NAME=? AND COLUMNPROPERTY(OBJECT_ID(?),COLUMN_NAME,'IsIdentity')=1 ");
		try {
			PreparedStatement ps = connection.prepareStatement(sb.toString());
			ps.setString(1, tablseName);
			ps.setString(2, tablseName);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("COLUMN_NAME");
			}
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 生成表名
	 * 
	 * @param tbName
	 * @return
	 */
	public static String buildTbName(String tbName) {
		String[] tbNams = tbName.toLowerCase().split("_");
		StringBuilder sb = new StringBuilder();
		sb.append(tbPrefix);
		for (int i = 0; i < tbNams.length; i++) {
			String tbSub = tbNams[i];
			String oneChar = String.valueOf(tbSub.charAt(0));
			sb.append(oneChar.toUpperCase() + tbSub.substring(1));
		}
		return sb.toString();
	}
}
