package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminTrueHouseComplaintMapper;
import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminTrueHouseComplaintService;

@Service
public class AdminTrueHouseComplaintServiceImpl extends AbstractService<AdminTrueHouseComplaint, Integer> implements AdminTrueHouseComplaintService {
	@Autowired
	private AdminTrueHouseComplaintMapper adminTrueHouseComplaintMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminTrueHouseComplaintMapper;
	}

	@Override
	public List<AdminTrueHouseComplaint> getListByCondition(AdminTrueHouseComplaint adminTrueHouseComplaint) {
		return adminTrueHouseComplaintMapper.getListByCondition(adminTrueHouseComplaint);
	}

	@Override
	public void updateDownAll(AdminTrueHouseComplaint complaint) {
		adminTrueHouseComplaintMapper.updateDownAll(complaint);
		
	}

}
