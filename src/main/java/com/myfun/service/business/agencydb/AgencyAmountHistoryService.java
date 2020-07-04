package com.myfun.service.business.agencydb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dto.AgencyAmountHistoryDto;
import com.myfun.repository.agencydb.param.AgencyAmountHistoryparam;
import com.myfun.repository.agencydb.po.AgencyAmountHistory;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 上午10:34:27 
 * 提现充值
*/
public interface AgencyAmountHistoryService extends BaseMapper<AgencyAmountHistory, Integer>{
	/**
	 * 获取提现需求列表
	 * @param agencyAgencyAmountHistoryparam
	 * @return
	 */
	PageInfo<AgencyAmountHistory> getCashList(AgencyAmountHistoryparam agencyAgencyAmountHistoryparam);
	
	/**
	 * 查询提现记录
	 * @param userId
	 * @param compFlag
	 * @return
	 */
	List<AgencyAmountHistory> getCashHistory(String archiveId, String compFlag);

	/**
	 * @TODO 查询提现记录
	 * @author lcb
	 * @2016-9-19 下午5:02:15
	 */
	PageInfo<AgencyAmountHistoryDto> getDistAmountHistory(BaseMapParam param);

}
