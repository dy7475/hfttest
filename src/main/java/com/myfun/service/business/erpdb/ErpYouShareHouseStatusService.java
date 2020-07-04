package com.myfun.service.business.erpdb;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpYouComplainDto;
import com.myfun.repository.erpdb.param.ErpYouComplainParam;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouShareHouseStatusService extends  BaseMapper<ErpYouShareHouseStatus, ErpYouShareHouseStatus>{

	PageInfo<ErpYouComplainDto> getComplainList(ErpYouComplainParam erpYouComplainParam);

	void downShareHouseByCondition(Integer cityId, ErpYouShareHouseStatus record);

	void downShareDataByCaseIds(Integer cityId, Map<String, Object> pMap);

}
