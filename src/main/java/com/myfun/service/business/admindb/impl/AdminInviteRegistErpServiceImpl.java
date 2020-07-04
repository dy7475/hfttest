package com.myfun.service.business.admindb.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminInviteRegistErpMapper;
import com.myfun.repository.admindb.po.AdminInviteRegistErp;
import com.myfun.repository.admindb.po.AdminInviteRegistErpExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminInviteRegistErpService;

/** 
 * 邀请注册
 * @author 张宏利
 * @since 2017年5月11日
 */
@Service
public class AdminInviteRegistErpServiceImpl extends AbstractService<AdminInviteRegistErp, Integer> implements AdminInviteRegistErpService {
	@Autowired
	private AdminInviteRegistErpMapper adminInviteRegistErpMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminInviteRegistErpMapper;
	}

	@Override
	public void updateRegistStatus(Integer id) {
		if(id == null) {
			return;
		}
		AdminInviteRegistErp record = new AdminInviteRegistErp();
		record.setId(id);
		record.setRegistStatus((byte)1);
		record.setRegistTime(new Date());
		adminInviteRegistErpMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer getInviteCount(String userMobile) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -24);
		AdminInviteRegistErpExample example = new AdminInviteRegistErpExample();
		example.createCriteria().andUserMobileEqualTo(userMobile)
		.andCreateTimeGreaterThan(calendar.getTime());
		return adminInviteRegistErpMapper.countByExample(example);
	}
	
}



