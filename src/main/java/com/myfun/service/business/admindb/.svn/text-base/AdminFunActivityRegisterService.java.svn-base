package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminFunActivityRegisterDto;
import com.myfun.repository.admindb.param.AdminFunActivityRegisterParam;
import com.myfun.repository.admindb.po.AdminFunActivityRegister;
import com.myfun.repository.admindb.po.AdminFunActivityTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunActivityRegisterService extends BaseMapper<AdminFunActivityRegister, Integer>{

	/**
	 * 查询活动报名列表
	 */
	public List<AdminFunActivityRegisterDto> getActivityRegisterList(AdminFunActivityRegisterParam param);
	/**
	 * 保存跟进
	 * @param track
	 * @author 熊财
	 */
	public void insertActivityTrack(AdminFunActivityTrack track);
	/**
	 * 获取活动报名跟进列表
	 * @param activityTrack
	 * @return
	 * @author 熊财
	 */
	public List<AdminFunActivityTrack> getRegisterTrackList(AdminFunActivityTrack activityTrack);
	
}
