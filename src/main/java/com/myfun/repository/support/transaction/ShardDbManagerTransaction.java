package com.myfun.repository.support.transaction;

import static org.springframework.jdbc.datasource.DataSourceUtils.isConnectionTransactional;
import static org.springframework.jdbc.datasource.DataSourceUtils.releaseConnection;
import static org.springframework.util.Assert.notNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.transaction.SpringManagedTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

/**
 * 重写mybatis事物 AbstractRoutingDataSource分库问题
 * 
 * @ClassName: ShardDbManagerTransaction
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月18日 上午11:55:20
 *
 */
public class ShardDbManagerTransaction extends SpringManagedTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShardDbManagerTransaction.class);

	private final Map<DataSource, ConnectionInfo> dataSourceMap;

	private final DataSource dataSource;

	public ShardDbManagerTransaction(DataSource dataSource) {
		super(dataSource);
		notNull(dataSource, "No DataSource specified");
		this.dataSource = dataSource;
		dataSourceMap = new HashMap<DataSource, ConnectionInfo>();
	}

	@Override
	public Connection getConnection() throws SQLException {
		LOGGER.info("获取数据库连接");
		// 如果试用分库源 则绑定真实数据源
		if (this.dataSource instanceof ExtRoutingDataSource) {
			ExtRoutingDataSource routingDataSource = (ExtRoutingDataSource) dataSource;
			DataSource targetDataSource = routingDataSource.getSessionTargetDataSource();
			ConnectionInfo targetConnectionInfo = dataSourceMap.get(targetDataSource);
			if (targetConnectionInfo != null) {
				Connection connection = targetConnectionInfo.getConnection();
				LOGGER.info("链接已经存在从已有池中取链接" + connection);
				return connection;
			}

			Connection targetConnection = DataSourceUtils.getConnection(targetDataSource);
			boolean autoCommit = targetConnection.getAutoCommit();
			boolean isConnectionTransactional = isConnectionTransactional(targetConnection, targetDataSource);

			ConnectionInfo connectionInfo = new ConnectionInfo(targetConnection, isConnectionTransactional, autoCommit);
			dataSourceMap.put(targetDataSource, connectionInfo);
			LOGGER.info("获取新链接" + connectionInfo);
			return targetConnection;
		} else {
			ConnectionInfo targetConnectionInfo = dataSourceMap.get(dataSource);
			if (targetConnectionInfo != null) {
				return targetConnectionInfo.getConnection();
			}

			Connection targetConnection = DataSourceUtils.getConnection(dataSource);
			boolean autoCommit = targetConnection.getAutoCommit();
			boolean isConnectionTransactional = isConnectionTransactional(targetConnection, dataSource);

			ConnectionInfo connectionInfo = new ConnectionInfo(targetConnection, isConnectionTransactional, autoCommit);
			dataSourceMap.put(dataSource, connectionInfo);
			LOGGER.info("获取原始连接" + targetConnection);
			return targetConnection;
		}
	}

	@Override
	public void commit() throws SQLException {
		boolean isError = false;
		Iterator<DataSource> iterator = dataSourceMap.keySet().iterator();
		while (iterator.hasNext()) {
			DataSource key = iterator.next();
			ConnectionInfo connectionInfo = dataSourceMap.get(key);
			try {
				if (connectionInfo != null && !connectionInfo.isConnectionTransactional && !connectionInfo.autoCommit) {
					LOGGER.info("提交事物->" + connectionInfo);
					connectionInfo.getConnection().commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
				isError = true;
			}
		}
		if (isError) {
			throw new SQLException("提交失败");
		}
	}

	@Override
	public void rollback() throws SQLException {
		boolean isError = false;
		Iterator<DataSource> iterator = dataSourceMap.keySet().iterator();
		while (iterator.hasNext()) {
			DataSource key = iterator.next();
			ConnectionInfo connectionInfo = dataSourceMap.get(key);
			try {
				if (connectionInfo != null && !connectionInfo.isConnectionTransactional() && !connectionInfo.isAutoCommit()) {
					connectionInfo.getConnection().rollback();
					LOGGER.info("回滚事务->" + connectionInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
				isError = true;
			}
		}
		if (isError) {
			throw new SQLException("提交失败");
		}
	}

	@Override
	public void close() throws SQLException {
		Iterator<DataSource> iterator = dataSourceMap.keySet().iterator();
		while (iterator.hasNext()) {
			DataSource key = iterator.next();
			ConnectionInfo connectionInfo = dataSourceMap.get(key);
			LOGGER.info("释放链接->" + connectionInfo + "->" + key);
			releaseConnection(connectionInfo.getConnection(), key);
		}
	}

	/**
	 * 描述当前连接状态
	 * 
	 * @ClassName: ConnectionInfo
	 * @Description: TODO
	 * @author jiangsonggui
	 * @date 2015年11月18日 下午5:43:47
	 *
	 */
	class ConnectionInfo {
		private Connection connection;

		private boolean isConnectionTransactional;

		private boolean autoCommit;

		public ConnectionInfo(Connection connection, boolean isConnectionTransactional, boolean autoCommit) {
			this.connection = connection;
			this.isConnectionTransactional = isConnectionTransactional;
			this.autoCommit = autoCommit;
		}

		public Connection getConnection() {
			return connection;
		}

		public void setConnection(Connection connection) {
			this.connection = connection;
		}

		public boolean isConnectionTransactional() {
			return isConnectionTransactional;
		}

		public void setConnectionTransactional(boolean isConnectionTransactional) {
			this.isConnectionTransactional = isConnectionTransactional;
		}

		public boolean isAutoCommit() {
			return autoCommit;
		}

		public void setAutoCommit(boolean autoCommit) {
			this.autoCommit = autoCommit;
		}

		@Override
		public String toString() {
			return "ConnectionInfo [connection=" + connection + ", isConnectionTransactional=" + isConnectionTransactional + ", autoCommit=" + autoCommit + "]";
		}
	}
}
