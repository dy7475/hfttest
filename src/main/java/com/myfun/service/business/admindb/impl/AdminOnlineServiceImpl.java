package com.myfun.service.business.admindb.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.deal.param.AccountInfoParam;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminSsqAccountInfoMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminSsqAccountInfo;
import com.myfun.service.business.admindb.AdminOnlineService;

@Service
public class AdminOnlineServiceImpl implements AdminOnlineService {
    @Resource
    AdminFunCompMapper adminFunCompMapper;
    @Resource
    AdminSsqAccountInfoMapper adminSsqAccountInfoMapper;
    
    @Override
    @Transactional
    public void openOnlineContract(AccountInfoParam accountInfoParam) {
        AdminSsqAccountInfo adminSsqAccountInfo = adminSsqAccountInfoMapper.selectByPrimaryKey(accountInfoParam.getAccount());
        if(adminSsqAccountInfo == null){
        	adminSsqAccountInfoMapper.insertSelective(accountInfoParam);
        } else {
        	adminSsqAccountInfoMapper.updateByPrimaryKeySelective(accountInfoParam);
        }
    }

	@Override
	public void updateOnlineContract(String account) {
		AdminFunComp adminFunComp = new AdminFunComp();
        adminFunComp.setCompId(Integer.valueOf(account));
        adminFunComp.setOpenOnlineContract((byte)1);
        adminFunCompMapper.updateByPrimaryKeySelective(adminFunComp);
	}

	@Override
	public void updateCertId(String account, String certId) {
		AdminSsqAccountInfo adminSsqAccountInfo = new AdminSsqAccountInfo();
		adminSsqAccountInfo.setAccount(account);
		adminSsqAccountInfo.setCertId(certId);
		adminSsqAccountInfoMapper.updateByPrimaryKeySelective(adminSsqAccountInfo);
	}
}
