package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.transaction.param.DelProcessStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertRunTimeStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertWarrantProcessParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeWarrantParam;
import com.myfun.erpWeb.managecenter.transaction.vo.InsertRunTimeStepVO;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpProcessRuntimeStepService extends BaseMapper<ErpProcessRuntimeStep, ErpProcessRuntimeStep> {
	void dynamicDelProcessStep(DelProcessStepParam param);

	void updateDealUserRelativeOffStepUser(Integer cityId, Integer compId, Integer dealId);

	void dynamicInsertProcessStep(GeneralParam generalParam, ErpProcessRuntimeStep model);

	void updateMgrWarrantStepData(GeneralParam generalParam, ErpProcessRuntimeStep model, String runstepName);

	void updateStepExcutorOfNotDoing(Integer cityId, Integer compId, Integer dealId, Integer userId, String userType);

	void setProcessModelAndUpdateDealUser(Integer cityId, Integer compId, InsertWarrantProcessParam param, ErpProcessRuntimeStep model);

	void deleteAndNewStep(Integer cityId, Integer compId, changeWarrantParam param, ErpProcessRuntimeStep model);
	
	void updateStepExcutorOfNotDoing(Integer dealId,Integer userId,String userType, Integer cityId,Integer compId) throws Exception;

	void insertMgrWarrantProcess(InsertWarrantProcessParam param, ErpProcessRuntimeStep model, GeneralParam generalParam, String trackContent);

	/**
	 * @Title 插入流程步骤
	 * @Author lcb
	 * @Time 2019/6/24 15:50
	 * @Desc
	 **/
    void insertRunTimeStep(InsertRunTimeStepParam param, InsertRunTimeStepVO insertRunTimeStepVO) throws Exception;
}
