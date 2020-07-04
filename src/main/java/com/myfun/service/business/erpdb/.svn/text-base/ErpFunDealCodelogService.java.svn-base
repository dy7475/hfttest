package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.po.ErpFunDealCodelog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDealCodelogService extends BaseMapper<ErpFunDealCodelog, ErpFunDealCodelog>{

	/**
	 * 修改合同分配编码停用启用
	 * @author 何传强
	 * @since 2017年7月6日
	 * @param cityId
	 * @param param
	 */
	void updateFunDealCodeLog(Integer cityId, Map<String, Object> param);
	/**
	 * 批量添加合同日志
	 * @author 何传强
	 * @since 2017年7月11日
	 * @param list
	 */
	void createBatchFunDealCodeLogList(List<ErpFunDealCodelog> list);

	void deleteByCodeId(Integer cityId, Integer codeId);
}
