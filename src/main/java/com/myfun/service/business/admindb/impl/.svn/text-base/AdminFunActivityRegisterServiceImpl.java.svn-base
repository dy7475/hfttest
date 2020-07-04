package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunActivityRegisterMapper;
import com.myfun.repository.admindb.dao.AdminFunActivityTrackMapper;
import com.myfun.repository.admindb.dto.AdminFunActivityRegisterDto;
import com.myfun.repository.admindb.param.AdminFunActivityRegisterParam;
import com.myfun.repository.admindb.po.AdminFunActivityRegister;
import com.myfun.repository.admindb.po.AdminFunActivityTrack;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunActivityRegisterService;
import com.myfun.utils.DateUtil;

@Service
public class AdminFunActivityRegisterServiceImpl extends AbstractService<AdminFunActivityRegister, Integer> implements AdminFunActivityRegisterService {

	@Autowired
	private AdminFunActivityRegisterMapper activityRegister;
	@Autowired
	private AdminFunActivityTrackMapper funActivityTrack;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper  = activityRegister;
	}

	/**
	 * 获取公众号报名列表
	 * @author 熊财
	 */
	@Override
	public List<AdminFunActivityRegisterDto> getActivityRegisterList(AdminFunActivityRegisterParam param) {
		if(param.getStarTime()!="" && param.getStarTime() != null){
			param.setsTime(DateUtil.StringToDate(param.getStarTime()));
		}
		if(param.getEndTime()!="" && param.getEndTime() != null){
			param.seteTime(DateUtil.StringToDate(param.getEndTime()));
		}
		return activityRegister.getPublicNumberRegisterList(param);
	}

	/**
	 * 公众号报名写跟进
	 */
	@Override
	public void insertActivityTrack(AdminFunActivityTrack track){
		funActivityTrack.insert(track);
	}

	@Override
	public List<AdminFunActivityTrack> getRegisterTrackList(AdminFunActivityTrack activityTrack) {
		return funActivityTrack.selectByCompnoAndDempno(activityTrack);
		
	}
}
