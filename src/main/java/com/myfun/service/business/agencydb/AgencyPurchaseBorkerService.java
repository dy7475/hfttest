package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.agencydb.po.AgencyPurchaseBorker;
import com.myfun.service.business.BaseService;

public interface AgencyPurchaseBorkerService extends BaseService<AgencyPurchaseBorker, Integer>{
	/**
	 * 统计是否支付
	 * @param agencyPurchaseBorker
	 * @return
	 */
	public int count(AgencyPurchaseBorker agencyPurchaseBorker);
	
	/**
	 * 获取经纪人列表
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	public List<AgencyPurchaseBorker> getPurchaseList(String cityId, Integer caseId, String caseType);
}
