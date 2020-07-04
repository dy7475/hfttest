package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyFunCustTrackMapper;
import com.myfun.repository.agencydb.po.AgencyFunCustTrack;
import com.myfun.repository.agencydb.po.AgencyFunCustTrackKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunCustTrackService;

@Service
public class AgencyFunCustTrackServiceImpl extends AbstractService<AgencyFunCustTrack, AgencyFunCustTrackKey>implements AgencyFunCustTrackService {
	@Autowired
	private AgencyFunCustTrackMapper agencyFunCustTrackMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunCustTrackMapper;
	}

	/**
	 * @TODO 跟进
	 * @author lcb
	 * @2016-10-14 下午1:53:08
	 */
	@Override
	public Integer writeFunCustTrack(Integer custId, Integer custSource, String trackType, String trackContent, Integer isWarn, BaseMapParam param) {
		AgencyFunCustTrack agencyFunCustTrack = new AgencyFunCustTrack();
		agencyFunCustTrack.setArchiveId(param.getInteger("archiveId"));
		agencyFunCustTrack.setCityId(param.getInteger("cityId").shortValue());
		agencyFunCustTrack.setCustId(custId);
		agencyFunCustTrack.setIswarm(isWarn.shortValue());
		agencyFunCustTrack.setTrackContent(trackContent);
		agencyFunCustTrack.setCustSource(custSource.shortValue());
		agencyFunCustTrack.setTrackTime(new Date());
		agencyFunCustTrack.setTrackType(trackType);
		agencyFunCustTrack.setTrackUid(param.getInteger("userId"));
		agencyFunCustTrack.setTrackUname(param.getString("userName"));
		return agencyFunCustTrackMapper.insertSelective(agencyFunCustTrack);
	}

	@Override
	public Integer createDistCustTrack(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		Integer custId = Integer.valueOf(pMap.get("custId")+"");
		return writeFunCustTrack(custId, 2, "经纪人", pMap.get("trackContent") +"", 0,param);
	}


}
