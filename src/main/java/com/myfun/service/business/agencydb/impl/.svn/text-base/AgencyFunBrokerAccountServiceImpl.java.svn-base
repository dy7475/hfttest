package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyFunBrokerAccountMapper;
import com.myfun.repository.agencydb.po.AgencyFunBrokerAccount;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunBrokerAccountService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 上午11:45:37 
 * 类说明 
*/
@Service
public class AgencyFunBrokerAccountServiceImpl extends AbstractService<AgencyFunBrokerAccount, Integer>implements AgencyFunBrokerAccountService {
	@Autowired
	private AgencyFunBrokerAccountMapper agencyFunBrokerAccountMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunBrokerAccountMapper;
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-10-14 下午2:34:24
	 */
	@Override
	public AgencyFunBrokerAccount getDistUserBindBankList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		String userPosition = param.getString("userPosition");
		pMap.put("cityId", param.getInteger("cityId"));
		pMap.put("archiveId", param.getInteger("archiveId"));
		if("GENERAL_MANAGER".equals(userPosition)) {
			pMap.put("archiveId", param.getInteger("compId"));
		}
		return agencyFunBrokerAccountMapper.getDistUserBindBankList(pMap);
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-10-14 下午2:58:56
	 */
	@Transactional
	@Override
	public AgencyFunBrokerAccount addDistUserBank(BaseMapParam param) {
		// 先注销当前账号
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		Integer archiveId  = param.getInteger("archiveId");
		if("GENERAL_MANAGER".equals(param.getString("userPosition"))) {
			archiveId = param.getInteger("compId");
		}
		pMap.put("archiveId", archiveId);
		agencyFunBrokerAccountMapper.updateCurrentAccount(pMap);
		// 新建一条数据HashMap param = new HashMap();
		
		AgencyFunBrokerAccount funBrokerAccount = new AgencyFunBrokerAccount();
		funBrokerAccount.setArchiveId(archiveId);
		funBrokerAccount.setCityId(param.getInteger("cityId"));
		funBrokerAccount.setUaType(Integer.valueOf(pMap.get("uaType")+""));
		funBrokerAccount.setAccountStatus(1);
		funBrokerAccount.setUserIccode(pMap.get("userIccode")+"");
		funBrokerAccount.setAccountType(new Byte(pMap.get("accountType")+""));
		funBrokerAccount.setAccountBank(pMap.get("accountBank")+"");
		funBrokerAccount.setBankUsername(pMap.get("bankUserName")+"");
		funBrokerAccount.setAccountNo(pMap.get("accountNo")+"");
		funBrokerAccount.setCustMobile(pMap.get("custMobile")+"");
		funBrokerAccount.setBindTime(new Date());
		int accountId = agencyFunBrokerAccountMapper.insertSelective(funBrokerAccount);
		accountId = funBrokerAccount.getAccountId();
		funBrokerAccount = new AgencyFunBrokerAccount();
		funBrokerAccount.setAccountNo(pMap.get("accountNo")+"");
		funBrokerAccount.setAccountId(accountId);
		return funBrokerAccount;
		
	}
	

	
}
