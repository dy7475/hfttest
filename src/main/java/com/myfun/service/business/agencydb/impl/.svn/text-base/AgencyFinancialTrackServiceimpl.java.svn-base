package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyFinancialTrackMapper;
import com.myfun.repository.agencydb.po.AgencyFinancialTrack;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFinancialTrackService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 下午2:17:04 
 * 类说明 
*/
@Service
public class AgencyFinancialTrackServiceimpl extends AbstractService<AgencyFinancialTrack, Integer>implements AgencyFinancialTrackService {
	@Autowired
	private AgencyFinancialTrackMapper agencyFinancialTrackMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFinancialTrackMapper;
	}

	@Override
	public List<AgencyFinancialTrack> getFinancialTrack(String detailId) {
		List<AgencyFinancialTrack> list = agencyFinancialTrackMapper.getFinancialTrack(detailId);
		return list;
	}


}
