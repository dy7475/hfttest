package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunMacDto;
import com.myfun.repository.erpdb.po.ErpFunMac;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunMacService extends BaseMapper<ErpFunMac, ErpFunMac> {

	List<ErpFunMacDto> getMgrInstallList(BaseMapParam param);

	void updateMgrReg(BaseMapParam param);
	
	void updateMgrchgLoginType(BaseMapParam param);

	void updateMgrRoamUser(Integer cityId, Integer roam, Integer compId, Integer roamUserId, String macaddr) throws Exception;

	void deleteMgrReg(BaseMapParam param);

	void updateMgrchgRegist(BaseMapParam param);

	void setMgrRegistManager(BaseMapParam param) throws Exception;

	Map<String, Object> getRegistManagerUser(BaseMapParam param);

}
