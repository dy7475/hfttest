package com.myfun.service.business.erpdb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunCompDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface ErpFunCompService extends BaseMapper<ErpFunComp, ErpFunComp> {

	public ErpFunComp getUserByCompNo(String compNo);

	public ErpFunCompDto getCompInfoByCompNo(Integer cityId, String compNo);

	public ErpFunComp getCompByCompId(ErpFunComp comp);

	public ErpFunComp getCompanyData(BaseMapParam param);

    void setExcellent(Integer cityId, String compNo, String deptNo);
    void chgRegist(Integer cityId,Integer compId,String compNo,Integer registFlag);

	List<Integer> getErpCompIdListByCrmCompId(Integer cityId, Integer crmCompId);

	Boolean judgeHjCustomer(Integer cityId, Integer compId);
}
