package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunSaleBakData;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunSaleBakDataMapper extends BaseMapper<ErpFunSaleBakData, ErpFunSaleBakData> {
	@SwitchDB(type=SwitchDBType.DB_NAME)
	List<ErpFunSaleBakData> getFunSaleBackDataForNotEncordPage(String dbName);
}