package com.myfun.service.business.admindb.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminContactInfoMapper;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.dto.AdminFunPaidDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.AdminContactInfo;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunPaidKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminContactInfoService;
import com.myfun.service.business.admindb.AdminFunPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class AdminContactInfoServiceImpl extends AbstractService<AdminContactInfo, Integer> implements AdminContactInfoService {
	@Autowired
	private AdminContactInfoMapper adminContactInfoMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminContactInfoMapper;
	}
	
	/**
	 * 修改联系方式
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/18
	 * @return
	 *
	 */
	@Override
	public void updateByArchiveId(Integer archiveId, String contactFlag, Date updateDate) {
		adminContactInfoMapper.updateByArchiveId(archiveId,contactFlag,updateDate);
		
	}
}
