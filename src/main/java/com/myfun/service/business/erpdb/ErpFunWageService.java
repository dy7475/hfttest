package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.dto.AuditWageVO;
import com.myfun.repository.erpdb.dto.ErpFunCountwageDto;
import com.myfun.repository.erpdb.dto.ErpFunWageDto;
import com.myfun.repository.erpdb.param.ErpFunWageParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunWage;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;


public interface ErpFunWageService extends BaseMapper<ErpFunWage, ErpFunWage>{


	List<AuditWageVO> auditFunWage(Integer cityId, Integer compId, Integer userId, String userName, String wageIds );

	Integer updateFunWageRealWage(Integer cityId, Integer userId, String userName, ErpFunWageParam param);

	List<ErpFunWageDto> getStaticWageVOListForUser(Integer cityId, Integer compId,Integer grId, Integer userId, String startDate, String subDate,Integer pageOffSet, Integer pageRows, Map<Integer,ErpFunCountwageDto> wageCountMap);

    void updateWageData(Integer cityId, Integer compId, ErpFunUsers erpFunUsers);
}
