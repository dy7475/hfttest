package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.dao.ErpFunProcessRecordMapper;
import com.myfun.repository.erpdb.dao.ErpProcessRuntimeStepMapper;
import com.myfun.repository.erpdb.po.ErpFunProcessRecord;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStepExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunProcessRecordService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErpFunProcessRecordServiceImpl extends AbstractService<ErpFunProcessRecord, ErpFunProcessRecord> implements ErpFunProcessRecordService {

	@Autowired
	ErpFunProcessRecordMapper erpFunProcessRecordMapper;
	@Autowired
	ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunProcessRecordMapper;
	}

	@Override
	public void insert4UpdateStep(GeneralParam generalParam, Integer dealId, String afterStepName, ErpProcessRuntimeStep runtimeStep,
								  String updateClassic, String trackContent, ErpProcessRuntimeStep oldRuntimeStep) {
		Integer cityId = generalParam.getCityId();
		ErpFunProcessRecord record = new ErpFunProcessRecord();
		if (runtimeStep != null && runtimeStep.getRunstepId() != null) {
			ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
			processRuntimeStepExample.setShardCityId(cityId);
			processRuntimeStepExample.createCriteria().andRunstepIdEqualTo(runtimeStep.getRunstepId()).andDealIdEqualTo(dealId);
			ErpProcessRuntimeStep newModel = erpProcessRuntimeStepMapper.selectByExample(processRuntimeStepExample).get(0);
			String updateContent = null;
			if (oldRuntimeStep != null) {
				updateContent = runtimeStep.getUpdateContent(oldRuntimeStep);
			}
			if (StringUtils.isNotBlank(updateContent)) {
				String arr[] = updateContent.split("、");
				if (arr.length == 1) {
					updateContent = arr[0];
				} else {
					updateContent += "等";
				}
			}
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("PROCESS_RUNTIME_STEP", BeanUtil.objToMap(newModel));
			record.setUpdateContent(JSON.toJSONString(paramMap));
			updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE;
			Integer frontRecordId = erpFunProcessRecordMapper.getFronRecordId(cityId, dealId, runtimeStep.getRunstepId());
			if (StringUtils.isBlank(trackContent)) {
				trackContent = "";
			}
			if (frontRecordId != null) {
				trackContent = generalParam.getCurrDeptUserName() + " 修改了步骤 " + oldRuntimeStep.getStepName() + updateContent + "信息";
			} else {
				trackContent = generalParam.getCurrDeptUserName() + " 为步骤 " + oldRuntimeStep.getStepName() + "添加了" + updateContent + "信息";
			}
			record.setFrontRecordId(frontRecordId);
			record.setRunstrpId(runtimeStep.getRunstepId());
		}
		record.setDealId(dealId);
		record.setDeptId(generalParam.getDeptId());
		record.setCompId(generalParam.getCompId());
		record.setTrackContent(trackContent);
		record.setUpdateClassic(updateClassic);
		record.setUpdateUid(generalParam.getUserId());
		record.setUpdateUserName(generalParam.getUserName());
		record.setUpdateDate(DateTimeHelper.getTimeNow());
		record.setShardCityId(cityId);
		erpFunProcessRecordMapper.insertSelective(record);
	}
}
