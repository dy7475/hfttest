package com.myfun.repository.agencydb.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.po.AgencyProjectTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyProjectTrackMapper extends BaseMapper<AgencyProjectTrack, Integer> {
	
	Page<AgencyProjectTrack> selectByProjectIdList(Integer projectId);
	List<AgencyProjectTrack> selectByProjectIdToList(Integer projectId);
}