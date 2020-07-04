package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myfun.repository.agencydb.dao.AgencyProjectTrackMapper;
import com.myfun.repository.agencydb.po.AgencyProjectTrack;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyProjectTrackService;

@Service
public class AgencyProjectTrackServiceImpl extends AbstractService<AgencyProjectTrack, Integer>
		implements AgencyProjectTrackService {
	
	@Autowired
	private AgencyProjectTrackMapper agencyProjectTrackMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyProjectTrackMapper;
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Page<AgencyProjectTrack> getProjectTrackList(Integer projectId, Integer pageNumber) {
		PageHelper.startPage(pageNumber, Const.PAGE_NUMBER, true);
		Page<AgencyProjectTrack> projectTracks = agencyProjectTrackMapper.selectByProjectIdList(projectId);
		return projectTracks;
	}

	@Override
	public Integer addProjectTrackList(AgencyProjectTrack agencyProjectTrack) {
		return agencyProjectTrackMapper.insertSelective(agencyProjectTrack);
	}

	@Override
	public List<AgencyProjectTrack> getProjectTrackList(Integer projectId) {
		// TODO Auto-generated method stub
		return agencyProjectTrackMapper.selectByProjectIdToList(projectId);
	}

}
