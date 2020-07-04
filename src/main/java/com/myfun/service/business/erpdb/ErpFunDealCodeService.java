package com.myfun.service.business.erpdb;

import java.util.Map;

import com.myfun.repository.erpdb.po.ErpFunDealCode;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDealCodeService extends BaseMapper<ErpFunDealCode, ErpFunDealCode> {
	/**
	 * 合同号段启用和停用
	 * 
	 * @author 何传强
	 * @since 2017年7月6日
	 * @param cityId
	 * @param map
	 */
	void updateDealFunDealCode(Integer cityId, Map<String, Object> param);

	/**
	 * 添加合同号段
	 * 
	 * @author 何传强
	 * @since 2017年7月11日
	 * @param erpFunDealCode
	 * @return 
	 */
	Integer createDealFunDealCode(ErpFunDealCode erpFunDealCode);

	void updateCode(Integer cityId, Integer compId,String isCan,String isSplit,String isAllow);

	void updateCodeLog(Integer cityId, Integer compId,String isCan);

	void deleteByCodeId(Integer cityId, Integer codeId);
}
