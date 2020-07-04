package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.agencydb.po.AgencyWebClient;
import com.myfun.service.business.BaseService;

public interface AgencyWebClientService extends BaseService<AgencyWebClient, Integer>{
	/**
	 * 查询ClientId
	 * @param phone1
	 * @param phone2
	 * @return
	 */
	public List<AgencyWebClient> getWebClient(String phone1, String phone2); 
	
	/**
	 * 获取本次ID
	 * @param record
	 * @return
	 */
	public Integer getId();
	
	/**
	 * 获取电话号码
	 * @param cityId
	 * @param caseId
	 * @return
	 */
	public AgencyWebClient getClientMobile(String cityId, String caseId);

	public AgencyWebClient getWebClientById(Integer clientId);

	public AgencyWebClient getClientSex(Integer getfIdHFT, Integer getfProId);
}
