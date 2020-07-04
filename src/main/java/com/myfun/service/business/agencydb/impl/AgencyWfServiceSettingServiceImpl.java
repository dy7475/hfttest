package com.myfun.service.business.agencydb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyWfServiceSettingMapper;
import com.myfun.repository.agencydb.po.AgencyWfServiceSetting;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfServiceSettingService;
@Service
public class AgencyWfServiceSettingServiceImpl extends AbstractService<AgencyWfServiceSetting, Integer> implements AgencyWfServiceSettingService {
	@Autowired AgencyWfServiceSettingMapper agencyWfServiceSettingMapper;
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 设置红包
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public void changeRedPacketNumber(BaseMapParam param) {
		Integer wfServiceSettingNumber = agencyWfServiceSettingMapper.getNumberByArchiveId(param.getMap());
		if (wfServiceSettingNumber > 0) {
			agencyWfServiceSettingMapper.changeRedPacketMumber(param.getMap());
		} else {
			AgencyWfServiceSetting agencyWfServiceSetting = new AgencyWfServiceSetting();
			agencyWfServiceSetting.setBuyMoney(Integer.valueOf(param.getString("buyMoney")));
			agencyWfServiceSetting.setBuyMoney(Integer.valueOf(param.getString("rentMoney")));
			agencyWfServiceSetting.setArchiveId(Integer.valueOf(param.getString("archiveid")));
			agencyWfServiceSettingMapper.insertSelective(agencyWfServiceSetting);
		}
	}

	/**
	 * 微店红包开启或者关闭
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public void changeSwitchState(BaseMapParam param) {
		AgencyWfServiceSetting agencyWfServiceSetting = agencyWfServiceSettingMapper.selectByPrimaryKey(param.getInteger("archiveId"));
		agencyWfServiceSetting.setWdHbSwitch(param.getInteger("switchFlag"));
		agencyWfServiceSettingMapper.updateByPrimaryKey(agencyWfServiceSetting);
	}
}
