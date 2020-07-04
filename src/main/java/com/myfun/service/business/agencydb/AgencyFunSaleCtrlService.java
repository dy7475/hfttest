package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.AgencyFunSaleCtrlDto;
import com.myfun.repository.agencydb.param.AgencyFunSaleCtrlParam;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrl;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrlKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunSaleCtrlService extends BaseMapper<AgencyFunSaleCtrl, AgencyFunSaleCtrlKey>{

	PageInfo<AgencyFunSaleCtrlDto> getFunSaleCtrlList(AgencyFunSaleCtrlParam agencyFunSaleCtrlParam);

	Integer addOrupdateFunSaleCtrol(AgencyFunSaleCtrl agencyFunSaleCtrl, Integer type, AdminCrmUser adminCrmUser);

	AgencyFunSaleCtrl getFunSaleCtrl(Integer cityId, Integer buildId, String houseNo);

}
