/*
 *    Copyright 2009-2012 The MyBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.myfun.repository.support.generator.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 重写mybatis DatabaseFactory 支持获取不同视图
 * 
 * @ClassName: DatabaseFactory
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月18日 下午5:49:59
 *
 */
public class DatabaseFactory {
	private DatabaseFactory() {
	}

	public static Database newDatabase(Connection conn, String catalogFilter, String schemaFilter) throws SQLException {
		Database database = new Database(catalogFilter, schemaFilter);
		ResultSet rs = null;
		try {
			DatabaseMetaData dbmd = conn.getMetaData();

			try {
				rs = dbmd.getTables(catalogFilter, schemaFilter, null, new String[] { "TABLE" });
				while (rs.next()) {
					String tableName = rs.getString("TABLE_NAME");
					Table table = database.getTable(tableName);
					if (table == null) {
						table = new Table(tableName);
						database.addTable(table);
					}
				}
			} finally {
				if (rs != null)
					rs.close();
			}

			try {
				rs = dbmd.getColumns(catalogFilter, schemaFilter, null, null);
				while (rs.next()) {
					String tableName = rs.getString("TABLE_NAME");
					String columnName = rs.getString("COLUMN_NAME");
					int dataType = Integer.parseInt(rs.getString("DATA_TYPE"));
					Table table = database.getTable(tableName);
					if (table != null) {
						table.addColumn(new Column(columnName, dataType));
					}
				}
			} finally {
				if (rs != null)
					rs.close();
			}

			try {
				String[] tableNames = database.getTableNames();
				for (int i = 0; i < tableNames.length; i++) {
					Table table = database.getTable(tableNames[i]);
					rs = dbmd.getPrimaryKeys(catalogFilter, schemaFilter, table.getName());
					List<Column> pkList = new ArrayList<Column>();
					while (rs.next()) {
						String columnName = rs.getString("COLUMN_NAME");
						Column pkColumn = new Column(columnName, 0);
						pkList.add(pkColumn);
					}
					table.setPrimaryKey(pkList);
				}
			} finally {
				if (rs != null)
					rs.close();
			}

		} finally {
			try {
				conn.rollback();
			} catch (Exception e) {
				/* ignore */ }
		}
		return database;
	}

}
