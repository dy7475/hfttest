package com.myfun.service.business.erpdb;

import java.util.ArrayList;

import com.myfun.repository.erpdb.po.ErpFunHousePublishLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunHousePublishLogService extends BaseMapper<ErpFunHousePublishLog, Integer>{
	/**
	 * 获取根据信息
	 * @param cityId
	 * @param pubId
	 * @return
	 */
	public ArrayList<ErpFunHousePublishLog> getListInfo(String cityId, String pubId);
}
