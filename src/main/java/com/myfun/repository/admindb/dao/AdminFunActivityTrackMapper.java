package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunActivityTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunActivityTrackMapper extends BaseMapper<AdminFunActivityTrack, Integer> {

	List<AdminFunActivityTrack> selectByCompnoAndDempno(AdminFunActivityTrack activityTrack);
}