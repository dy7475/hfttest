package com.myfun.service.business.erpdb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.param.ErpCooperateComplaintParam;
import com.myfun.repository.erpdb.po.ErpCooperateComplaint;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpCooperateComplainService extends BaseMapper<ErpCooperateComplaint, ErpCooperateComplaint>{
	/**
	 * 获取数据列表
	 * @param param
	 * @return
	 */
	PageInfo<ErpCooperateComplaint> getRecords(ErpCooperateComplaintParam param);
	
	/**
	 * 处理投诉
	 * @param complaint
	 */
	public void dealProcess(ErpCooperateComplaint complaint, String result, String NOREMNUM, String useage);
}
