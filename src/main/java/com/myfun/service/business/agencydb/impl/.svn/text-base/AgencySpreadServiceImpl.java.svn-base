package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencySpreadMapper;
import com.myfun.repository.agencydb.dto.AgencySpreadDto;
import com.myfun.repository.agencydb.param.AgencySpreadParam;
import com.myfun.repository.agencydb.po.AgencySpread;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencySpreadService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午3:42:46 
 * 推广审核 
*/
@Service
public class AgencySpreadServiceImpl extends AbstractService<AgencySpread, Integer>implements AgencySpreadService {
	@Autowired
	private AgencySpreadMapper agencySpreadMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencySpreadMapper;
	}

	@Override
	public PageInfo<AgencySpread> getList(AgencySpreadParam agencySpreadParam) {
		PageHelper.startPage(agencySpreadParam.getPageNum(), Const.PAGE_NUMBER, true);
		List<AgencySpread> list = agencySpreadMapper.getList(agencySpreadParam);
		return new PageInfo(list);
	}

	@Override
	public AgencySpreadDto getCountSpread(String timeStart, String timeEnd) {
		return agencySpreadMapper.getCountSpread(timeStart, timeEnd);
	}

	@Override
	public int updateStatus(AdminCrmUser adminCrmUser, AgencySpread agencySpread) {
		AgencySpread up = new AgencySpread();
		up.setCheckStatus(agencySpread.getCheckStatus());
		up.setCheckUid(adminCrmUser.getUserId());
		up.setCheckUname(adminCrmUser.getUserName());
		up.setCheckTime(new Date());
		up.setSpreadId(agencySpread.getSpreadId());
		agencySpreadMapper.updateByPrimaryKeySelective(up);
		return 1;
	}

	/**
	 * @TODO 最新系统消息
	 * @author lcb
	 * @2016-9-19 下午5:33:31
	 */
	@Override
	public PageInfo<AgencySpreadDto> getDistSystemMessage(BaseMapParam param ) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("archiveId", param.getInteger("archiveId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencySpreadDto> resList = agencySpreadMapper.getDistSystemMessage(pMap);
		return new PageInfo<>(resList);
	}

	
}
