package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateDeviceStatusParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpAppLoginDevice;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpAppLoginDeviceService extends BaseMapper<ErpAppLoginDevice, ErpAppLoginDevice>{
	

	public void updateDeviceStatus(UpdateDeviceStatusParam param);
	

}
