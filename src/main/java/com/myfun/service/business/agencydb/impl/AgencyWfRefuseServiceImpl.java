package com.myfun.service.business.agencydb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.agencydb.dao.AgencyWfRefuseMapper;
import com.myfun.repository.agencydb.po.AgencyWfRefuse;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfRefuseService;
import com.myfun.utils.StringUtil;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午12:45:29 
 * 类说明 
*/
@Service
public class AgencyWfRefuseServiceImpl extends AbstractService<AgencyWfRefuse, Integer>implements AgencyWfRefuseService {
	@Autowired
	private AgencyWfRefuseMapper agencyWfRefuseMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyWfRefuseMapper;
	}

	@Override
	public void reFuseBroker(AgencyWfRefuse param) {
		//查询经纪人档案
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(param.getArchiveId());
		param.setCityId(StringUtil.parseInteger(String.valueOf(adminFunArchive.getCityId())));
		param.setUserName(adminFunArchive.getUserName());
		param.setUserMobile(adminFunArchive.getUserMobile());
		param.setCreateTime(new Date());
		param.setDealStatus((byte)0);
		//拒绝经纪人
		agencyWfRefuseMapper.insertSelective(param);
	}

	

}
