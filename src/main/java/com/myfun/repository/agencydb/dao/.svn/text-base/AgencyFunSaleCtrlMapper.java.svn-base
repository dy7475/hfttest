package com.myfun.repository.agencydb.dao;

import java.util.List;

import com.myfun.repository.agencydb.dto.AgencyFunSaleCtrlDto;
import com.myfun.repository.agencydb.param.AgencyFunSaleCtrlParam;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrl;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrlKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunSaleCtrlMapper extends BaseMapper<AgencyFunSaleCtrl, AgencyFunSaleCtrlKey> {

	List<AgencyFunSaleCtrlDto> getFunSaleCtrlList(AgencyFunSaleCtrlParam agencyFunSaleCtrlParam);

	Integer updateByCondition(AgencyFunSaleCtrl agencyFunSaleCtrl);
	
	Integer insertFunSaleCtrl(AgencyFunSaleCtrlParam agencyFunSaleCtrlParam);

}