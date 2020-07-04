package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunPolicyControl;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPolicyControlService extends BaseMapper<ErpFunPolicyControl, ErpFunPolicyControl> {

	public void resetPrivateDay(Integer cityId, Integer caseId, Integer caseType,boolean isTrack, boolean isFangKan,Integer compId, Integer createUserId);

	void insertFunPolicyContro(Integer rentCustId, Integer compId,Integer cityId, Integer phoneCaseType, Integer createUserId);
}
