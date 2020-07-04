package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.param.ErpCooperateComplaintParam;
import com.myfun.repository.erpdb.po.ErpCooperateComplaint;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpCooperateComplaintMapper extends BaseMapper<ErpCooperateComplaint, ErpCooperateComplaint> {
	/**
	 * 获取数据列表
	 * @param param
	 * @return
	 */
	List<ErpCooperateComplaint> getRecords(ErpCooperateComplaintParam param);
}