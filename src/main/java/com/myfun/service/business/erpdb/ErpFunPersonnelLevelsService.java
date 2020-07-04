package com.myfun.service.business.erpdb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunPersonnelLevels;
import com.myfun.repository.erpdb.po.ErpFunRecruitmentChannel;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface ErpFunPersonnelLevelsService extends BaseMapper<ErpFunPersonnelLevels, ErpFunPersonnelLevels> {
    void changeLevelsSeq(ErpFunPersonnelLevels funPersonnelLevels, BaseMapParam param);

    void addOrEditPersonnelLevel(Integer cityId, Integer compId, List<ErpFunPersonnelLevels> paramList);
}
