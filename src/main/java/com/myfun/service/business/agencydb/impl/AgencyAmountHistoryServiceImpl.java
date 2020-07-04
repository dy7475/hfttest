package com.myfun.service.business.agencydb.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyAmountHistoryMapper;
import com.myfun.repository.agencydb.dto.AgencyAmountHistoryDto;
import com.myfun.repository.agencydb.param.AgencyAmountHistoryparam;
import com.myfun.repository.agencydb.po.AgencyAmountHistory;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyAmountHistoryService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 上午10:36:37 
 * 类说明 
*/
@Service
public class AgencyAmountHistoryServiceImpl extends AbstractService<AgencyAmountHistory, Integer>implements AgencyAmountHistoryService {
	@Autowired
	private AgencyAmountHistoryMapper agencyAmountHistoryMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyAmountHistoryMapper;
	}

	@Override
	public PageInfo<AgencyAmountHistory> getCashList(
			AgencyAmountHistoryparam agencyAgencyAmountHistoryparam) {
		PageHelper.startPage(agencyAgencyAmountHistoryparam.getPageNum(), Const.PAGE_NUMBER, true);
		List<AgencyAmountHistory> list = agencyAmountHistoryMapper.getCashList(agencyAgencyAmountHistoryparam);
		return new PageInfo(list);
	}

	@Override
	public List<AgencyAmountHistory> getCashHistory(String archiveId, String compFlag) {
		List<AgencyAmountHistory> list = agencyAmountHistoryMapper.getCashHistory(archiveId, compFlag);
		return list;
	}

	/**
	 * @TODO 提现记录
	 * @author lcb
	 * @2016-9-19 下午5:09:51
	 */
	@Override
	public PageInfo<AgencyAmountHistoryDto> getDistAmountHistory( BaseMapParam param) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		Map<String, Object> pMap = param.getMap();
		List<AgencyAmountHistoryDto> resList = agencyAmountHistoryMapper.getDistAmountHistory(pMap);
		return new PageInfo<>(resList);
	}
	

}
