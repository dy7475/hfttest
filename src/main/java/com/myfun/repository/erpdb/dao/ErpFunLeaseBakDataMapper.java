package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunLeaseBakData;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunLeaseBakDataMapper extends BaseMapper<ErpFunLeaseBakData, ErpFunLeaseBakData> {
	@SwitchDB(type=SwitchDBType.DB_NAME)
	List<ErpFunLeaseBakData> getFunLeaseBackDataForNotEncordPage(String dbName);
}