package com.myfun.service.business.agencydb;

import java.util.List;

import com.github.pagehelper.Page;
import com.myfun.repository.agencydb.po.AgencyProjectTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyProjectTrackService extends BaseMapper<AgencyProjectTrack, Integer> {

	Page<AgencyProjectTrack> getProjectTrackList(Integer projectId, Integer pageNumber);

	Integer addProjectTrackList(AgencyProjectTrack agencyProjectTrack);

	List<AgencyProjectTrack> getProjectTrackList(Integer projectId);

}
