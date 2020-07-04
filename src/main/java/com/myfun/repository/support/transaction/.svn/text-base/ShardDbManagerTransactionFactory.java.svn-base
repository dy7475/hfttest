package com.myfun.repository.support.transaction;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;

/**
 * 重写AbstractRoutingDataSource分库事物管理
 * 
 * @ClassName: ShardDbManagerTransactionFactory
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月18日 上午11:53:44
 *
 */
public class ShardDbManagerTransactionFactory extends SpringManagedTransactionFactory {

	public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
		return new ShardDbManagerTransaction(dataSource);
	}

	public Transaction newTransaction(Connection conn) {
		throw new UnsupportedOperationException("不支持链接获取方式");
	}

	public void setProperties(Properties props) {
	}
}
