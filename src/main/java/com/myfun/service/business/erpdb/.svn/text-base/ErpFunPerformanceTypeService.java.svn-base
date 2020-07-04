package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.transaction.vo.FjdFunPerformanceTypeVO;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface ErpFunPerformanceTypeService extends BaseMapper<ErpFunPerformanceType, ErpFunPerformanceType> {
    void updatePerformanceList(List<FjdFunPerformanceTypeVO> list, Integer compId, Integer cityId) throws Exception;

    void initializationData(Integer compId, Integer cityId, Boolean isFjd);
}
