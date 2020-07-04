package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunScoreStandardMonth;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminFunScoreStandardMonthService extends BaseMapper<AdminFunScoreStandardMonth, Integer> {

	List<AdminFunScoreStandardMonth> selectCondition(Map<String, Object> pMap);

	void update(AdminFunScoreStandardMonth adminFunScoreStandardMonth);

	void insertAdminFunUseScoreRecore(Integer scoreType, GeneralParam generalParam);
}
