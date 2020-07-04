package com.myfun.service.business.erpdb.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateDeviceStatusParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpAppLoginDeviceMapper;
import com.myfun.repository.erpdb.po.ErpAppLoginDevice;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAppLoginDeviceService;

@Service
public class ErpAppLoginDeviceServiceImpl extends AbstractService<ErpAppLoginDevice, ErpAppLoginDevice> implements ErpAppLoginDeviceService{
	@Autowired private ErpAppLoginDeviceMapper erpAppLoginDeviceMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAppLoginDeviceMapper;
	}

	/**
	 * 审核app设备是否登录
	 * @author 熊刚
	 * @since 2017年6月9日
	 * @param param
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void updateDeviceStatus(UpdateDeviceStatusParam param) {
		ErpAppLoginDevice erpAppLoginDevice = new ErpAppLoginDevice();
		erpAppLoginDevice.setShardCityId(param.getCityId());
		erpAppLoginDevice.setCompId(param.getCompId());
		erpAppLoginDevice.setDeviceStatus(param.getDeviceStatus().byteValue());
		erpAppLoginDevice.setUserId(param.getUserId());
		erpAppLoginDevice.setLoginId(param.getLoginId());
		erpAppLoginDeviceMapper.updateDeviceStatus(erpAppLoginDevice);
		erpAppLoginDeviceMapper.updateDeviceStatusOverdue(erpAppLoginDevice);
	}
}
