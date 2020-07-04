package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunProcessLogMapper;
import com.myfun.repository.erpdb.dao.ErpModelStepRelateMapper;
import com.myfun.repository.erpdb.dao.ErpProcessModelMapper;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpModelStepRelateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ErpModelStepRelateServiceImpl extends AbstractService<ErpModelStepRelate, ErpModelStepRelateKey> implements ErpModelStepRelateService {
	@Autowired
	private ErpModelStepRelateMapper erpModelStepRelateMapper;
	@Autowired
	private ErpFunProcessLogMapper erpFunProcessLogMapper;
	@Autowired
	ErpProcessModelMapper erpProcessModelMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=this.erpModelStepRelateMapper;
	}

	/**
	 * @tag 删除某个流程中的步骤
	 * @author 邓永洪
	 * @since 2018/5/15
	 */
	@Transactional
	@Override
	public void deleteMgrStepModelFromPro(Integer cityId, Integer compId, ErpModelStepRelate model, Integer userId, String currUname ) {
		erpModelStepRelateMapper.deleteModelStepRelate(cityId,model);
		ErpModelStepRelate updateModel=new ErpModelStepRelate();
		updateModel.setCompId(compId);
		updateModel.setModelId(model.getModelId());
		updateModel.setStepId(model.getStepId());
		updateModel.setStepSeq(model.getStepSeq());
		erpModelStepRelateMapper.updateStepSeq(cityId,updateModel);

		ErpFunProcessLog erpFunProcessLog = new ErpFunProcessLog();
		erpFunProcessLog.setCompId(compId);
		erpFunProcessLog.setCreateTime(new Date());
		erpFunProcessLog.setInfluenceId(model.getModelId());
		erpFunProcessLog.setUserId(userId);
		erpFunProcessLog.setInfluenceType((byte) 2);
		erpFunProcessLog.setContent(currUname + "删除了流程步骤");
		erpFunProcessLog.setShardCityId(cityId);
		erpFunProcessLogMapper.insertSelective(erpFunProcessLog);

		// 删除关联的modelId
		erpProcessModelMapper.updateConditionStepIdToNull(cityId, compId, model.getModelId(), model.getStepId());

	}
}
