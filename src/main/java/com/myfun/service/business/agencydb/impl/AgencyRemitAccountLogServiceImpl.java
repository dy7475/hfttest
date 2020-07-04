package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyRemitAccountLogMapper;
import com.myfun.repository.agencydb.po.AgencyRemitAccountLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyRemitAccountLogService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 下午3:20:40 
 * 类说明 
*/
@Service
public class AgencyRemitAccountLogServiceImpl extends AbstractService<AgencyRemitAccountLog, Integer>implements AgencyRemitAccountLogService {
	@Autowired
	private AgencyRemitAccountLogMapper agencyRemitAccountLogMapper;
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyRemitAccountLogMapper;
	}
	@Override
	public List<AgencyRemitAccountLog> getPaidedHistory(String archiveId, String compFlag) {
		List<AgencyRemitAccountLog> list = agencyRemitAccountLogMapper.getPaidedHistory(archiveId, compFlag);
		return list;
	}
	

}
