package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.transaction.param.InsertMgrStepModelParam;
import com.myfun.repository.erpdb.dao.ErpFunProcessLogMapper;
import com.myfun.repository.erpdb.dao.ErpModelStepRelateMapper;
import com.myfun.repository.erpdb.dao.ErpProcessModelStepMapper;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpProcessModelMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpProcessModelService;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ErpProcessModelServiceImpl extends AbstractService<ErpProcessModel, ErpProcessModel> implements ErpProcessModelService{
	@Autowired private ErpProcessModelMapper erpProcessModelMapper;
	@Autowired private ErpModelStepRelateMapper erpModelStepRelateMapper;
	@Autowired private ErpFunProcessLogMapper  erpFunProcessLogMapper;
	@Autowired ErpProcessModelStepMapper erpProcessModelStepMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = this.erpProcessModelMapper;
	}
	
	/**
	 *  创建公司的权证流程模版并返回
	 *  flj
	 *  2017-09-30
	 */
	@Transactional
	@Override
	public void initCompProcessModelList(Integer cityId, Integer compId) {
		// 1.初始化模版数据
		this.initCompProcessModeByCompId(cityId,compId);
		// 2.初始化模版步骤
		this.initCompProcessModelStepByCompId(cityId,compId);
		// 3.初始化模板与步骤的关联
		this.initCompModelStepRelateByCompId(cityId,compId);
	}

	/**
	 * 3.初始化模板与步骤的关联
	 * @param cityId
	 * @param compId
	 */
	private void initCompModelStepRelateByCompId(Integer cityId, Integer compId) {
		erpProcessModelMapper.insertInitCompModelStepRelateByCompId(cityId, compId);
	}
	
	/**
	 * 2.初始化模版步骤
	 * flj
	 * 2017-09-30
	 * @param cityId
	 * @param compId
	 */
	private void initCompProcessModelStepByCompId(Integer cityId, Integer compId) {
		erpProcessModelMapper.insertInitCompProcessModelStepByCompId(cityId, compId);
	}
	

	/**
	 * 1.初始化模版数据
	 * flj
	 * 2017-09-30
	 * @param cityId
	 * @param compId
	 */
	private void initCompProcessModeByCompId(Integer cityId, Integer compId) {
		erpProcessModelMapper.insertInitCompProcessModel(cityId, compId);
	}

	/**
	 * @tag 权证流程 - 向某个流程插入步骤
	 * @author 邓永洪
	 * @since 2018/5/15
	 */
	@Transactional
	@Override
	public void insertMgrStepModelToPro(Integer cityId, Integer userId, String currUname,ErpModelStepRelate modelStepRelate, InsertMgrStepModelParam param) {
		Integer modelId = param.getModelId();
		Integer compId = modelStepRelate.getCompId();
		Set<Integer> stepIdSet = new HashSet<>();
		if (modelId == null) {
			// 创建流程需要名字判重
			ErpProcessModelExample erpProcessModelExample = new ErpProcessModelExample();
			erpProcessModelExample.setShardCityId(cityId);
			erpProcessModelExample.createCriteria().andCompIdEqualTo(compId).andProNameEqualTo(param.getProName());
			int count = erpProcessModelMapper.countByExample(erpProcessModelExample);
			Assert.isTrueThrow(count > 0, "流程名称不可重复");
			// 流程不存在时创建流程
			ErpProcessModel processModel = new ErpProcessModel();
			processModel.setShardCityId(cityId);
			processModel.setCompId(compId);
			processModel.setProName(param.getProName());
			Integer modelNo = this.getModelNo("min", cityId, compId) - 1;
			processModel.setModelNo(modelNo.shortValue());
			erpProcessModelMapper.insertSelective(processModel);
			modelId = processModel.getModelId();
			modelStepRelate.setModelId(modelId);
		}else {
			ErpModelStepRelateExample erpModelStepRelateExample = new ErpModelStepRelateExample();
			erpModelStepRelateExample.setShardCityId(cityId);
			erpModelStepRelateExample.createCriteria().andCompIdEqualTo(compId).andModelIdEqualTo(modelId);
			List<ErpModelStepRelate> erpModelStepRelates = erpModelStepRelateMapper.selectByExample(erpModelStepRelateExample);
			stepIdSet = erpModelStepRelates.stream().collect(Collectors.mapping(val->val.getStepId(), Collectors.toSet()));
		}
		byte currentStepSeq = modelStepRelate.getStepSeq();

		// 先把数据全部收集好
		if (StringUtil.isNotBlank(param.getStepIds())) {
			for (String stepValue : param.getStepIds().split(",")) {
				stepIdSet.add(StringUtil.paseInteger(stepValue));
			}
		}

		if (StringUtil.isNotBlank(param.getStepIds())) {
			Integer i = 1;
			for (String stepValue : param.getStepIds().split(",")) {
				if (stepValue == null){
					continue;
				}
				if(null == param.getModelId() && i == 1) {
					modelStepRelate.setTimelimitType((byte) 1);
					modelStepRelate.setTimelimit(24);
				}else {
					ErpProcessModelStep erpProcessModelStep = new ErpProcessModelStep();
					erpProcessModelStep.setShardCityId(cityId);
					erpProcessModelStep.setStepId(StringUtil.paseInteger(stepValue));
					erpProcessModelStep = erpProcessModelStepMapper.selectByPrimaryKey(erpProcessModelStep);
					if(null != erpProcessModelStep) {

						if (null != erpProcessModelStep.getTimelimitType()) {

							modelStepRelate.setTimelimit(erpProcessModelStep.getTimelimit());
							modelStepRelate.setTimelimitType(erpProcessModelStep.getTimelimitType());

							// 上一步骤完成后
							if(2 == erpProcessModelStep.getTimelimitType().intValue()) {
								modelStepRelate.setRpevstepId(erpProcessModelStep.getRpevstepId());
								modelStepRelate.setRpevstepName(erpProcessModelStep.getRpevstepName());
								if(null != erpProcessModelStep.getRpevstepId()) {
									// 如果步骤不在本模板中就默认为步骤完成后一天
									if(!stepIdSet.contains(erpProcessModelStep.getRpevstepId())) {
										// 默认为上一步骤完成后一天
										modelStepRelate.setTimelimitType((byte) 2);
										modelStepRelate.setTimelimit(24);
										modelStepRelate.setRpevstepId(null);
										modelStepRelate.setRpevstepName(null);
									}
								}else {
									modelStepRelate.setRpevstepId(null);
									modelStepRelate.setRpevstepName(null);
								}
							}
						} else {
							modelStepRelate.setTimelimit(24);
							modelStepRelate.setTimelimitType((byte) 2);
						}

					}
				}
				modelStepRelate.setStepId(StringUtil.paseInteger(stepValue));
				modelStepRelate.setStepSeq(++currentStepSeq);
				modelStepRelate.setShardCityId(cityId);
				erpModelStepRelateMapper.insertSelective(modelStepRelate);
				i++;
			}

		}
		
		if (StringUtil.isNotBlank(param.getCancelStepIds())) {
			List<Integer> cancelStepIdList = new ArrayList<Integer>();
			Arrays.asList(param.getCancelStepIds().split(",")).stream().forEach(a -> {
				cancelStepIdList.add(StringUtil.paseInteger(a, 0));
			});
			if (!cancelStepIdList.isEmpty()) {
				erpModelStepRelateMapper.deleteByStepIds(cityId, compId, modelId, cancelStepIdList);
			}
		}
		
		// 写日志
		ErpFunProcessLog erpFunProcessLog = new ErpFunProcessLog();
		erpFunProcessLog.setCompId(compId);
		erpFunProcessLog.setCreateTime(new Date());
		erpFunProcessLog.setInfluenceId(modelStepRelate.getModelId());
		erpFunProcessLog.setUserId(userId);
		erpFunProcessLog.setInfluenceType((byte) 2);
		String chooseStr = modelId == null ? "添加" : "编辑";
		erpFunProcessLog.setContent(currUname + chooseStr + "了流程模板");
		erpFunProcessLog.setShardCityId(cityId);
		erpFunProcessLogMapper.insertSelective(erpFunProcessLog);
	}

	/**
	 * @tag 删除权证流程模版
	 * @author 邓永洪
	 * @since 2018/5/15
	 */
	@Transactional
	@Override
	public void deleteProcessModel(Integer cityId, Integer compId, Integer modelId) {
		erpModelStepRelateMapper.deleteModelStepRelateByModelId(cityId, compId, modelId);
		ErpProcessModelExample processModelExample=new ErpProcessModelExample();
		processModelExample.setShardCityId(cityId);
		processModelExample.createCriteria().andModelIdEqualTo(modelId);
		erpProcessModelMapper.deleteByExample(processModelExample);
	}

	/**
	 * @tag 获取公司模版的排序序号, 分最小和最大两种, 不存在时返回0
	 * @author 邓永洪
	 * @since 2018/5/14
	 */
	private Integer getModelNo(String type, Integer cityId, Integer compId) {
		Map<String, Object> map = erpProcessModelMapper.getSerialNumber(cityId, compId);
		if ("min".equalsIgnoreCase(type)) {
			return StringUtil.parseInteger(map.get("minValue")) ;
		} else {
			return StringUtil.parseInteger(map.get("maxValue"));
		}
	}
}
