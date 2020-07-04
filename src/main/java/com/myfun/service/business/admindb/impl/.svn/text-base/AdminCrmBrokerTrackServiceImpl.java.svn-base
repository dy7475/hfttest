package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminCrmBrokerTrackMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCrmBrokerTrackService;

@Service
public class AdminCrmBrokerTrackServiceImpl extends AbstractService<AdminCrmBrokerTrack, Integer> implements AdminCrmBrokerTrackService {
	
	@Autowired
	private  AdminCrmBrokerTrackMapper adminCrmBrokerTrackMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminCrmBrokerTrackMapper;
	}

	@Override
	public List<AdminCrmBrokerTrack> selectByArchiveId(int archiveId) {
		return adminCrmBrokerTrackMapper.selectByArchiveId(archiveId);
	}

	@Override
	public void addTrack(AdminFunArchive archive, AdminCrmUser adminCrmUser, String content, String desc) {
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(archive.getArchiveId());
		brokerTrack.setProvinceId(archive.getProvinceId());
		brokerTrack.setCityId((int) archive.getCityId());
		brokerTrack.setTrackDesc(desc);
		brokerTrack.setTrackContent(content);
		brokerTrack.setTrackTime(new Date());
		brokerTrack.setCompId(adminCrmUser.getCompId());
		brokerTrack.setDeptId(adminCrmUser.getDeptId());
		brokerTrack.setTrackUser(adminCrmUser.getUserId());
		adminCrmBrokerTrackMapper.insertSelective(brokerTrack);
	}

	@Override
	public void createRegisterTrack(Integer archiveId, String trackContent, String desc) {
		AdminCrmBrokerTrack insertModel = new AdminCrmBrokerTrack();
		insertModel.setArchiveId(archiveId);
		insertModel.setTrackDesc(desc);
		insertModel.setTrackUser(999);
		insertModel.setTrackContent(trackContent);
		insertModel.setTrackTime(new Date());
		adminCrmBrokerTrackMapper.insertSelective(insertModel);
	}

	@Override
	public void createWriwriteOffUserTrack(Integer archiveId, String trackContent, DeleteUsersParam param) {
		ErpFunUsers selfUser = param.getSelfUser();
		
		AdminCrmBrokerTrack insertModel = new AdminCrmBrokerTrack();
		insertModel.setArchiveId(archiveId);
		insertModel.setTrackDesc("[门店注销]");
		insertModel.setTrackUser(Const.DIC_SYSTEM_USERID_999);
		insertModel.setTrackContent(trackContent);
		insertModel.setProvinceId(param.getSelfProvinceId());
		insertModel.setCityId(selfUser.getCityId().intValue());
		insertModel.setCompId(selfUser.getCompId());
		insertModel.setDeptId(selfUser.getDeptId());
		insertModel.setTrackTime(new Date());
		adminCrmBrokerTrackMapper.insertSelective(insertModel);
	}

	@Override
	public void createRegisterTrack(Integer archiveId, String trackContent) {
		AdminCrmBrokerTrack insertModel = new AdminCrmBrokerTrack();
		insertModel.setArchiveId(archiveId);
		insertModel.setTrackDesc("[用户注册]");
		insertModel.setTrackUser(999);
		insertModel.setTrackContent(trackContent);
		insertModel.setTrackTime(new Date());
		adminCrmBrokerTrackMapper.insertSelective(insertModel);
	}

}
