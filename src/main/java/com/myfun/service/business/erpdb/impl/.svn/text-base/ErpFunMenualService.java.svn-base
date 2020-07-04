package com.myfun.service.business.erpdb.impl;

import java.util.List;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpDicDefinitionsDto;
import com.myfun.repository.erpdb.po.ErpFunMenual;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;

public interface ErpFunMenualService extends BaseMapper<ErpFunMenual, ErpFunMenual>{


	ErpFunMenual getBizMnaualData(BaseMapParam param);

	List<ErpDicDefinitionsDto> getBizAllMnaualList(BaseMapParam param);
	void updateBizAllMnaual(BuildingInfoTmpParam buildingInfoTmpParam);
}
