package com.myfun.repository.support.datasource;

/**
 * 切换读写分离
 * 
 * @ClassName: AccessReadonlyDbHolder
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年6月5日 上午10:09:46
 *
 */
public class AccessReadonlyDbHolder {
	/** 访问数据库只读标记 当前线程计数大于0 则访问只读 **/
	public static ThreadLocal<Integer> accessDatabaseReadonlyFlag = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static Boolean getAccessDatabaseReadonlyFlag() {
		return accessDatabaseReadonlyFlag.get() > 0;
	}

	public static Integer incrAccessDatabaseReadonlyFlag() {
		Integer value = accessDatabaseReadonlyFlag.get() + 1;
		accessDatabaseReadonlyFlag.set(value);
		return value;
	}

	public static Integer decrAccessDatabaseReadonlyFlag() {
		Integer value = accessDatabaseReadonlyFlag.get() - 1;
		accessDatabaseReadonlyFlag.set(value);
		return value;
	}
}
