package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.reportdb.po.ReportFunWageDetail1;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ReportFunWageDetail1Service extends BaseMapper<ReportFunWageDetail1, Long>{


	Integer updateWorkCount(Integer cityId, Integer compId, ErpPerformanceAssessmentCountParam param);
}
