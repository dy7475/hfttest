package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.constract.param.CreateDealTrackParam;
import com.myfun.erpWeb.managecenter.transaction.param.DelProcessStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertRunTimeStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertWarrantProcessParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeWarrantParam;
import com.myfun.erpWeb.managecenter.transaction.vo.InsertRunTimeStepVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStepExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpProcessRuntimeStepServiceImpl extends AbstractService<ErpProcessRuntimeStep, ErpProcessRuntimeStep> implements ErpProcessRuntimeStepService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErpProcessRuntimeStepServiceImpl.class);


    @Autowired
    ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
    @Autowired
    ErpDealUserRelativeMapper erpDealUserRelativeMapper;
    @Autowired
    ErpDealUserRelativeService erpDealUserRelativeService;
    @Autowired
    ErpFunProcessRecordService erpFunProcessRecordService;
    @Autowired
    ErpFunDealMapper erpFunDealMapper;
    @Autowired
    ErpFunTaskService erpFunTaskService;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunDealService erpFunDealService;
    @Autowired
    private ErpFunScheduleMapper erpFunScheduleMapper;
    @Autowired
    ErpProcessModelStepMapper erpProcessModelStepMapper;
    @Autowired
    ErpFunProcessRecordMapper erpFunProcessRecordMapper;

    @Override
    public void setBaseMapper() {
        super.baseMapper = erpProcessRuntimeStepMapper;
    }

    /**
     * @tag 动态删除流程
     * @author 邓永洪
     * @since 2018/6/20
     */
    @Transactional
    @Override
    public void dynamicDelProcessStep(DelProcessStepParam param) {
        Integer cityId = param.getCityId();
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.setShardCityId(cityId);
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(param.getDealId()).andRunstepIdEqualTo(param.getRunstepId());
        ErpProcessRuntimeStep erpProcessRuntimeStep = new ErpProcessRuntimeStep();
        erpProcessRuntimeStep.setDelFlag((byte) 1);
        erpProcessRuntimeStepMapper.updateByExampleSelective(erpProcessRuntimeStep, processRuntimeStepExample);

        // 删除步骤之后所有流程重新排序
        int processRuntimeStepCount = erpProcessRuntimeStepMapper.resetSeqForRuntimeStep(cityId, param.getDealId());
        // 如果没有排序 就清除步骤名
        if (processRuntimeStepCount == 0) {
            ErpFunDeal erpFunDeal = new ErpFunDeal();
            erpFunDeal.setDealId(param.getDealId());
            erpFunDeal.setRunstepId(null);
            erpFunDeal.setRunstepName("");
            erpFunDeal.setShardCityId(cityId);
            erpFunDealMapper.updateStepInDeal(cityId, erpFunDeal);
        }
        processRuntimeStepExample.clear();
        processRuntimeStepExample.setShardCityId(cityId);
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(param.getDealId()).andDelFlagEqualTo((byte) 0);
        List<ErpProcessRuntimeStep> list = erpProcessRuntimeStepMapper.selectByExample(processRuntimeStepExample);

        // 如果存在流程步骤 1.有完成状态的,取最大完成状态的步骤更新到FUN_DEAL 2:没有完成状态的,将FUN_DEAL里面字段更为空
        // 不存在流程步骤,已经在上面代码中将FUN_DEAL里面字段更为空
        if (list.size() > 0) {
            Optional<ErpProcessRuntimeStep> userOp = list.stream().filter(it -> it.getUpdateTime() != null).max(Comparator.comparingInt(ErpProcessRuntimeStep::getStepSeq));
            if (userOp.isPresent()) {
                ErpProcessRuntimeStep maxStep = userOp.get();
                ErpFunDeal erpFunDeal = new ErpFunDeal();
                erpFunDeal.setDealId(param.getDealId());
                erpFunDeal.setRunstepId(maxStep.getRunstepId());
                erpFunDeal.setRunstepName(maxStep.getStepName());
                erpFunDeal.setShardCityId(cityId);
                erpFunDealMapper.updateStepInDeal(cityId, erpFunDeal);
            } else {
                ErpFunDeal erpFunDeal = new ErpFunDeal();
                erpFunDeal.setDealId(param.getDealId());
                erpFunDeal.setRunstepId(null);
                erpFunDeal.setRunstepName("");
                erpFunDeal.setShardCityId(cityId);
                erpFunDealMapper.updateStepInDeal(cityId, erpFunDeal);
            }
        }

        this.updateDealUserRelativeOffStepUser(cityId, param.getCompId(), param.getDealId());
        GeneralParam generalParam = new GeneralParam();
        generalParam.setUserName(param.getUserName());
        generalParam.setUserId(param.getUserId());
        generalParam.setDeptId(param.getDeptId());
        generalParam.setCompId(param.getCompId());
        generalParam.setCityId(cityId);
        String trackContent = param.getCurrUserName() + " 为该合同删除了" + param.getStepName() + "步骤";
        erpFunProcessRecordService.insert4UpdateStep(generalParam, param.getDealId(), "", erpProcessRuntimeStep,
                Const.DIC_DEAL_UPDATE_CLASSIC_STEPADD, trackContent, erpProcessRuntimeStep);
        String currentDeptUserName = param.getCurrUserName();
        String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;
        ErpFunDeal deal = erpFunDealMapper.getBaseDealInfo(cityId, param.getDealId());
        String taskSubJect = taskType + " " + currentDeptUserName + " 为编号" + deal.getContractNo() + "的合同的流程删除了步骤";
        erpFunTaskService.createDealWarmTask(deal.getDealType(), param.getDealId(), deal.getContractNo(), null, taskSubJect,
                Const.DIC_TASK_TYPE_CONTRACT_REMIND, taskSubJect, param.getUserId(), cityId, param.getDeptId(), param.getCompId());
    }

    @Transactional
    @Override
    public void updateDealUserRelativeOffStepUser(Integer cityId, Integer compId, Integer dealId) {
        List<Integer> userIds = erpProcessRuntimeStepMapper.getUpdateUserList(cityId, dealId);
        if (null != userIds && userIds.size() > 0) {
            ErpDealUserRelativeExample dealUserRelativeExample = new ErpDealUserRelativeExample();
            dealUserRelativeExample.setShardCityId(cityId);
            dealUserRelativeExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andRelateTypeEqualTo(Const.DIC_RELATE_TYPE_STEPUSER);
            erpDealUserRelativeMapper.deleteByExample(dealUserRelativeExample);
            erpDealUserRelativeService.createDealUserRelativeOffStep(cityId, compId, dealId, new HashSet<>(userIds), Const.DIC_RELATE_TYPE_STEPUSER);
        }
    }

    /**
     * @tag 为合同根据模板生成流程实例
     * @author 邓永洪
     * @since 2018/6/21
     */
    @Transactional
    @Override
    public void dynamicInsertProcessStep(GeneralParam generalParam, ErpProcessRuntimeStep model) {
        Integer cityId = generalParam.getCityId();
        Integer dealId = model.getDealId();

        ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
        example.setShardCityId(cityId);
        example.createCriteria()
                .andCompIdEqualTo(generalParam.getCompId())
                .andDealIdEqualTo(dealId).andStepNameEqualTo(model.getStepName())
                .andDelFlagEqualTo(Byte.valueOf("0"));
        int count = erpProcessRuntimeStepMapper.countByExample(example);

        if (count > 0) {
            throw new BusinessException("流程步骤不能重复！");
        }

        model.setDelFlag((byte) 0);
        model.setCompId(generalParam.getCompId());
        model.setShardCityId(cityId);
        if (StringUtils.isNotBlank(model.getUpdateTime())) {
            model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SUCCESS);
        } else if (StringUtils.isNotBlank(model.getFlowcontent()) || null != model.getReminderId()) {
            model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_WAITDOING);
        } else {
            model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_NOTDOING);
        }

        erpProcessRuntimeStepMapper.updateStepSeq(cityId, dealId, model.getDelFlag(), model.getStepSeq());
        erpProcessRuntimeStepMapper.insertSelective(model);

        // 新增加的步骤如果填写了实际完成时间,则修改合同表中的当前步骤名
        if (StringUtils.isNotBlank(model.getUpdateTime())) {
            ErpFunDealExample funDealExample = new ErpFunDealExample();
            funDealExample.setShardCityId(cityId);
            funDealExample.createCriteria().andCompIdEqualTo(generalParam.getCompId()).andDealIdEqualTo(dealId);

            ErpFunDeal funDeal = new ErpFunDeal();
            funDeal.setRunstepId(model.getRunstepId());
            funDeal.setRunstepName(model.getStepName());
            erpFunDealMapper.updateByExampleSelective(funDeal, funDealExample);
        }

        this.updateDealUserRelativeOffStepUser(cityId, generalParam.getCompId(), dealId);
        String trackContent = generalParam.getCurrDeptUserName() + " 为该合同添加" + model.getStepName() + "步骤";
        erpFunProcessRecordService.insert4UpdateStep(generalParam, dealId, null, null,
                Const.DIC_DEAL_UPDATE_CLASSIC_STEPADD, trackContent, null);
//		String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;
//		ErpFunDeal deal = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
//		String taskSubJect = taskType + " " + generalParam.getCurrDeptUserName() + " 为编号" + deal.getContractNo() + "的合同的流程添加了步骤";
//		erpFunTaskService.createDealWarmTask(deal.getDealType(), dealId, deal.getContractNo(), null, taskSubJect, Const.DIC_TASK_TYPE_CONTRACT_REMIND,
//				taskSubJect, generalParam.getUserId(), generalParam.getCityId(), generalParam.getDeptId(), generalParam.getCompId());
        // 发送提醒信息
        if (Byte.valueOf("1").equals(model.getWarmFlag()) && model.getReminderId() != null) {
            List<Integer> taskUserIdList = new ArrayList<>();
            taskUserIdList.add(model.getReminderId());
            erpFunTaskService.writeTaskForRuntimeStep(generalParam, model, null, taskUserIdList, null, model.getStepName(), null);
        }
    }

    /**
     * @param userId
     * @param cityId
     * @param compId
     * @param isComplete
     * @param caseId
     * @param caseType
     * @param runstepId
     * @author 周希来
     * @since 2019年5月27日
     */
    private void ifExistUpdateOrInsertWorkPlan(Integer userId, Integer cityId, Integer compId,
                                               Integer isComplete, Integer caseId, Integer caseType, Date completeTime, Integer areaId, Integer regId,
                                               Integer deptId, Integer grId, Integer runstepId,String orgPath) {

        int workPlanType = 102;//计划表权证代办的类型
        ErpFunSchedule erpFunSchedule = erpFunScheduleMapper.findByContion(cityId, userId, compId, workPlanType, caseId, caseType, runstepId);
        if (null != erpFunSchedule) {
            ErpFunSchedule erpFunScheduleUpdate = new ErpFunSchedule(cityId, erpFunSchedule.getScheduleId());
            erpFunScheduleUpdate.setShardCityId(cityId);
            erpFunScheduleUpdate.setIscomplete((byte) 1);
            erpFunScheduleUpdate.setUpdateTime(completeTime);
            erpFunScheduleMapper.updateByPrimaryKeySelective(erpFunScheduleUpdate);
        } else {
            ErpFunSchedule erpFunScheduleInsert = new ErpFunSchedule();
            erpFunScheduleInsert.setShardCityId(cityId);
            erpFunScheduleInsert.setUserId(userId);
            erpFunScheduleInsert.setCompId(compId);
            erpFunScheduleInsert.setScheduleType((byte) workPlanType);
            erpFunScheduleInsert.setIscomplete(isComplete.byteValue());
            erpFunScheduleInsert.setUpdateTime(completeTime);
            erpFunScheduleInsert.setCreationTime(new Date());
            erpFunScheduleInsert.setAreaId(areaId);
            erpFunScheduleInsert.setRegId(regId);
            erpFunScheduleInsert.setDeptId(deptId);
            erpFunScheduleInsert.setGrId(grId);
            erpFunScheduleInsert.setCaseId(caseId);
            erpFunScheduleInsert.setCaseType(caseType.byteValue());
            erpFunScheduleInsert.setJson(runstepId + "");
            erpFunScheduleMapper.insertSelective(erpFunScheduleInsert);
        }

    }


    /**
     * @tag 更新合同中的子步骤数据
     * @author 邓永洪
     * @since 2018/6/21
     */
    @Transactional
    @Override
    public void updateMgrWarrantStepData(GeneralParam generalParam, ErpProcessRuntimeStep model, String runstepName) {
        Integer cityId = generalParam.getCityId();
        model.setShardCityId(cityId);
        ErpFunDeal funDeal = new ErpFunDeal();
        funDeal.setShardCityId(cityId);
        funDeal.setDealId(model.getDealId());
        funDeal.setUpdateTime(new Date());
        erpFunDealMapper.updateByPrimaryKeySelective(funDeal);

        Integer runstepId = model.getRunstepId();
        ErpProcessRuntimeStep oldModel = null;
        String nodeName = null;
        String nextLimitTime = null;
        Integer nextUserId = null;
        Integer reminderId = model.getReminderId();// 提醒人id
        String reminderName = model.getReminderName();// 提醒人名称
        String warmContent = model.getWarmContent();// 提醒内容
        if (runstepId != null) {
            ErpProcessRuntimeStep erpProcessRuntimeStep = new ErpProcessRuntimeStep();
            erpProcessRuntimeStep.setShardCityId(cityId);
            erpProcessRuntimeStep.setRunstepId(runstepId);
            oldModel = erpProcessRuntimeStepMapper.selectByPrimaryKey(erpProcessRuntimeStep);
        }
        //已处理或者跳过
        if (Const.DIC_RUNSTEP_STATUS_SUCCESS.equals(model.getRunstepStatus()) || Const.DIC_RUNSTEP_STATUS_SKIP.equals(model.getRunstepStatus())) {
            // 不传实际完成的时间，不完成流程
            if (StringUtils.isNotBlank(model.getUpdateTime())) {
                model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SUCCESS);
            }
            model.setReminderId(null);
            model.setReminderName(null);
            model.setWarmContent(null);
            erpProcessRuntimeStepMapper.updateByPrimaryKeySelective(model);
            model.setReminderId(reminderId);
            model.setReminderName(reminderName);
            model.setWarmContent(warmContent);
		/*	//工作日程 完成更新权证待办
			if(model.getRunstepStatus().equals(Const.DIC_RUNSTEP_STATUS_SUCCESS)) {
				String[] strs = {"case_id","case_type"};
				ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, model.getDealId(), strs);
				int caseType = erpFunDeal.getDealType().byteValue()==Const.DIC_CASE_TYPE_SALE_DEAL?Const.HouseCustType.SALE :Const.HouseCustType.LEASE;
				ifExistUpdateOrInsertWorkPlan(generalParam.getUserId(), cityId, generalParam.getCompId(), 1,erpFunDeal.getDealHouseId(), caseType, 
						DateTimeHelper.parseToDate(model.getUpdateTime()),
						generalParam.getAreaId(), generalParam.getRegId(), generalParam.getDeptId(), generalParam.getGrId());
			}*/
            erpFunProcessRecordService.insert4UpdateStep(generalParam, model.getDealId(), null, model, "",
                    Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE, oldModel);
            updateDealUserRelativeOffStepUser(cityId, generalParam.getCompId(), model.getDealId());
            // 发送提醒信息
            if (model.getReminderId() != null && StringUtil.isNotBlank(model.getWarmContent())) {
				/*ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
				erpProcessRuntimeStepExample.setShardCityId(cityId);
				erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andStepSeqGreaterThan(oldModel.getStepSeq()).andDelFlagEqualTo((byte) 0);
				erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ");
				List<ErpProcessRuntimeStep> nodeList = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);
				if (null != nodeList && nodeList.size() > 0) {
					nodeName = nodeList.get(0).getStepName();
				}
				List<Integer> taskUserIdList = new ArrayList<>();
				taskUserIdList.add(model.getReminderId());
				erpFunTaskService.writeTaskForRuntimeStep(generalParam,model,model.getStepName(),taskUserIdList,runstepName, null);*/

                // 有手动发送提醒消息的还需要写跟进
                pushMsgAndCreateDealTrack(generalParam, model);
            }
            return;
        } else {//未处理或者待处理的
            if (StringUtils.isBlank(model.getUpdateTime())) {//无更新时间，证明未处理或待处理
                //前端传的空字符穿会导致 updateTime 为1900-01-01
                model.setUpdateTime(null);
                if (StringUtils.isNotBlank(model.getFlowcontent()) || model.getReminderId() != null) {
                    model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_WAITDOING);//如果步骤的备注或者提醒人不为空，那么证明为待处理
                }
                model.setReminderId(null);
                model.setReminderName(null);
                model.setWarmContent(null);
                erpProcessRuntimeStepMapper.updateByPrimaryKeySelective(model);
                model.setReminderId(reminderId);
                model.setReminderName(reminderName);
                model.setWarmContent(warmContent);
                erpFunProcessRecordService.insert4UpdateStep(generalParam, model.getDealId(), null, model, "",
                        Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE, oldModel);
                updateDealUserRelativeOffStepUser(cityId, generalParam.getCompId(), model.getDealId());
                // 发送提醒信息
                if (model.getReminderId() != null && StringUtil.isNotBlank(model.getWarmContent())) {
					/*ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
					erpProcessRuntimeStepExample.setShardCityId(cityId);
					erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andStepSeqGreaterThan(oldModel.getStepSeq()).andDelFlagEqualTo((byte) 0);
					erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ");
					List<ErpProcessRuntimeStep> nodeList = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);
					if (null != nodeList && nodeList.size() > 0) {
						nodeName = nodeList.get(0).getStepName();
					}
					List<Integer> taskUserIdList = new ArrayList<>();
					taskUserIdList.add(model.getReminderId());
					erpFunTaskService.writeTaskForRuntimeStep(generalParam,model,nodeName,taskUserIdList,runstepName, null);*/

                    // 有手动发送提醒消息的还需要写跟进
                    pushMsgAndCreateDealTrack(generalParam, model);
                }
                return;
            }
            //以下状态既不是已处理或者跳过且有跟新时间，那么处理该步骤
            String timelimitdate = model.getTimelimitdate();
            if (StringUtils.isBlank(timelimitdate)) {
                model.setTimelimit(null);
            }
            // 1.标记当前处理节点为已处理
            model.setCompId(generalParam.getCompId());
            model.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SUCCESS);

            model.setReminderId(null);
            model.setReminderName(null);
            model.setWarmContent(null);
            erpProcessRuntimeStepMapper.updateByPrimaryKeySelective(model);
            model.setReminderId(reminderId);
            model.setReminderName(reminderName);
            model.setWarmContent(warmContent);
            // 2.更新当前节点之前的节点,存在未处理的情况则标记为跳过
            ErpProcessRuntimeStep updateModel = new ErpProcessRuntimeStep();
            updateModel.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SKIP);
            ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
            processRuntimeStepExample.setShardCityId(cityId);
            processRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andStepSeqLessThan(oldModel.getStepSeq())
                    .andRunstepStatusLessThan(Const.DIC_RUNSTEP_STATUS_SUCCESS).andDelFlagEqualTo((byte) 0);
            erpProcessRuntimeStepMapper.updateByExampleSelective(updateModel, processRuntimeStepExample);

            remindPersonOfRelativeStep(generalParam, cityId, model, oldModel, runstepName);
            // 3.获取之后的节点列表,更新processRuntimeStep和funDeal中的相关信息
            ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
            erpProcessRuntimeStepExample.setShardCityId(cityId);
            erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andStepSeqGreaterThan(oldModel.getStepSeq()).andDelFlagEqualTo((byte) 0);
            erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ");
            List<ErpProcessRuntimeStep> nodeList = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);

            ErpFunDeal dealModel = new ErpFunDeal();
            if (null != nodeList && nodeList.size() > 0) {
                nodeName = nodeList.get(0).getStepName();
                String nextTimelimitdate = nodeList.get(0).getTimelimitdate();
                //如果下一个具体执行人不为空，那么首选发消息给下一位
                nextUserId = nodeList.get(0).getUpdateUser() != null ? nodeList.get(0).getUpdateUser() : nodeList.get(0).getExecutor();
                if (StringUtil.isNotBlank(nextTimelimitdate)) {
                    String monthAndDay = DateTimeHelper.getMonthOfYear(DateTimeHelper.parseToDate(nextTimelimitdate)) + "月" + DateTimeHelper.getDayOfMonth(DateTimeHelper.parseToDate(nextTimelimitdate)) + "日";
                    String weekOfDay = DateTimeHelper.transferWeekDayOffCn(DateTimeHelper.parseToDate(nextTimelimitdate));
                    nextLimitTime = monthAndDay + weekOfDay;
                }
                updateProcessStep(cityId, generalParam.getCompId(), model.getDealId(), nodeList, model);
            } else {//之后没有步骤了，就只需要跟新完成时间
                dealModel.setUpdateTime(new Date());
            }
            ErpFunDeal deal = erpFunDealMapper.getFunDealById(cityId, generalParam.getCompId(), model.getDealId());
            // 完成步骤备注时插入流程日志记录
            String trackContent = generalParam.getCurrDeptUserName() + " 完成了" + runstepName + "步骤";
            erpFunProcessRecordService.insert4UpdateStep(generalParam, deal.getDealId(), null, model,
                    Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEDEAL, trackContent, oldModel);

            // 10个步骤,1个步骤都没有完成,FUN_DEAL中没有 runstepName; 第1个步骤完成，再完成第4个步骤,FUN_DEAL的runstepName为第4个步骤名;
            // 第4个步骤完成,再完成第2个步骤,FUN_DEAL的runstepName还是为第4个步骤名; 插入一条新步骤，且为完成，则FUN_DEAL的runstepName为第11个步骤名
            if (null != nodeList && nodeList.size() > 0) {
                erpProcessRuntimeStepExample.clear();
                erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andDelFlagEqualTo((byte) 0);
                erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ");
                List<ErpProcessRuntimeStep> lists = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);
                List<ErpProcessRuntimeStep> match = lists.stream().filter(it -> it.getStepName().equals(runstepName)).collect(Collectors.toList());
                if (match.size() > 0) {
                    ErpProcessRuntimeStep max = match.subList(match.size() - 1, match.size()).get(0);//获取与当前步骤名相同的最后一个步骤
                    //获取在当前步骤名相同的最后一个步骤之后且有完成时间的步骤集合
                    List<ErpProcessRuntimeStep> big = lists.stream().filter(it -> it.getUpdateTime() != null && it.getStepSeq() > max.getStepSeq()).collect(Collectors.toList());

                    // 当前步骤之后的步骤没有完成状态的,则更新FUN_DEAL中runstepName
                    if (big.size() == 0) {
                        // 修改流程当前步骤名称
                        dealModel.setRunstepName(runstepName);
                        dealModel.setRunstepId(model.getRunstepId());
                        dealModel.setDealId(model.getDealId());
                        dealModel.setShardCityId(cityId);
                        erpFunDealMapper.updateByPrimaryKeySelective(dealModel);
                    }
                }
            } else {
                // 当前已经是最大排序的流程,修改流程当前步骤名称
                dealModel.setRunstepName(runstepName);
                dealModel.setRunstepId(model.getRunstepId());
                dealModel.setDealId(model.getDealId());
                dealModel.setShardCityId(cityId);
                erpFunDealMapper.updateByPrimaryKeySelective(dealModel);
            }
        }
        //工作日程 完成更新权证待办

        String[] strs = {"DEAL_HOUSE_ID", "DEAL_TYPE"};
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, model.getDealId(), strs);
        int caseType = erpFunDeal.getDealType().byteValue() == Const.DIC_CASE_TYPE_SALE_DEAL ? Const.HouseCustType.SALE : Const.HouseCustType.LEASE;
        ifExistUpdateOrInsertWorkPlan(generalParam.getUserId(), cityId, generalParam.getCompId(), 1, erpFunDeal.getDealHouseId(), caseType,
                new Date(),
                generalParam.getAreaId(), generalParam.getRegId(), generalParam.getDeptId(), generalParam.getGrId(), model.getRunstepId(),generalParam.getOrganizationPath());

        // 4.添加提醒
        updateDealUserRelativeOffStepUser(cityId, generalParam.getCompId(), model.getDealId());
		/*Byte warnFlag = model.getWarmFlag();
		if(warnFlag==null ||  warnFlag==0){
			return;// 不需要提醒
		}*/
        // 根据提醒类型指定提醒人
        List<Integer> taskUserIdList = new ArrayList<>();
        Byte warnType = model.getWarnType();
        //预防前端没有屏蔽数据 导致没有提醒人而进行提醒啦

        ErpFunDeal dealInfo = erpFunDealMapper.getBaseDealInfo(cityId, model.getDealId());
        if (warnType == null) {
            taskUserIdList.add(nextUserId);
        } else if (warnType == 1) {// 指定提醒人
            taskUserIdList.add(model.getReminderId());
        } else if (warnType == 3) {// 流程负责人
            taskUserIdList.add(dealInfo.getDealUserId());
        } else if (warnType == 4) {// 合同签约人
            taskUserIdList.add(dealInfo.getSignUserId());
        }

        // 发送提醒信息
        if (generalParam.getUserId().equals(nextUserId) || null == nextUserId) {// 是自己就返回了，不发了
            return;
        }

        erpFunTaskService.writeTaskForRuntimeStep(generalParam, model, nodeName, taskUserIdList, runstepName, null, nextLimitTime);
        // 有手动发送提醒消息的还需要写跟进
        if (model.getReminderId() != null && StringUtil.isNotBlank(model.getWarmContent())) {
            pushMsgAndCreateDealTrack(generalParam, model);
        }

    }

    //给关联步骤执行人发送提醒
    private void remindPersonOfRelativeStep(GeneralParam generalParam, Integer cityId, ErpProcessRuntimeStep model, ErpProcessRuntimeStep oldModel, String runstepName) {
        String nodeName = null;
        String nextLimitTime = null;

        //获取所有的步骤，拿出所有有关联步骤
        ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
        erpProcessRuntimeStepExample.setShardCityId(cityId);
        erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andRpevstepIdEqualTo(oldModel.getStepId()).andDelFlagEqualTo((byte) 0);
        erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ");
        List<ErpProcessRuntimeStep> nodeList = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);

        if (nodeList != null && nodeList.size() > 0) {
            for (int i = 0; i < nodeList.size(); i++) {
                Integer relativeUserId = nodeList.get(i).getUpdateUser() != null ? nodeList.get(i).getUpdateUser() : nodeList.get(i).getExecutor();
                if (generalParam.getUserId().equals(relativeUserId) || null == relativeUserId) {// 是自己就返回了，不发了
                    continue;
                }
                nodeName = nodeList.get(i).getStepName();
                String nextTimelimitdate = nodeList.get(i).getTimelimitdate();
                if (StringUtil.isNotBlank(nextTimelimitdate)) {
                    String monthAndDay = DateTimeHelper.getMonthOfYear(DateTimeHelper.parseToDate(nextTimelimitdate)) + "月" + DateTimeHelper.getDayOfMonth(DateTimeHelper.parseToDate(nextTimelimitdate)) + "日";
                    String weekOfDay = DateTimeHelper.transferWeekDayOffCn(DateTimeHelper.parseToDate(nextTimelimitdate));
                    nextLimitTime = monthAndDay + weekOfDay;
                }
                // 指定关联提醒人
                List<Integer> taskUserIdList = new ArrayList<>();
                taskUserIdList.add(relativeUserId);
                erpFunTaskService.writeTaskForRuntimeStep(generalParam, model, nodeName, taskUserIdList, runstepName, null, nextLimitTime);
            }
        }
    }

    /**
     * 有手动发送提醒消息的还需要写跟进
     *
     * @param generalParam
     * @param model
     */
    private void pushMsgAndCreateDealTrack(GeneralParam generalParam, ErpProcessRuntimeStep model) {
        String[] columns = new String[]{"DEAL_ID", "CONTRACT_NO", "DEAL_TYPE"};
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(generalParam.getCityId(), model.getDealId(), columns);
        if (null != model.getReminderId() && StringUtil.isNotBlank(model.getWarmContent())) {
            Set<Integer> userIdSet = new HashSet<>();
            userIdSet.add(model.getReminderId());
            erpFunTaskService.pushMsgForDealRemind(generalParam, erpFunDeal, model.getWarmContent(), userIdSet);
            CreateDealTrackParam createDealTrackParam = new CreateDealTrackParam();
            createDealTrackParam.setDealId(model.getDealId());
            createDealTrackParam.setWarmContent(model.getWarmContent());
            createDealTrackParam.setWarmUser(null != model.getReminderId() ? String.valueOf(model.getReminderId()) : null);
            erpFunDealService.createDealTrack(generalParam, createDealTrackParam);
        }
    }


    /**
     * @tag 遍历合同流程步骤, 并更新计划执行人, 以及计划完成时间
     * @author 邓永洪
     * @since 2018/6/21
     */
    private void updateProcessStep(Integer cityId, Integer compId, Integer dealId, List<ErpProcessRuntimeStep> nodeList, ErpProcessRuntimeStep model) {
        if (nodeList == null || dealId == null) {
            LOGGER.error("合同: " + dealId + " 或流程步骤不存在");
        }
        ErpDealUserRelativeExample dealUserRelativeExample = new ErpDealUserRelativeExample();
        dealUserRelativeExample.setShardCityId(cityId);
        dealUserRelativeExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andRelateTypeEqualTo(Const.DIC_RELATE_TYPE_STEPUSER);
        erpDealUserRelativeMapper.deleteByExample(dealUserRelativeExample);
        ErpFunDeal deal = new ErpFunDeal();
        deal.setShardCityId(cityId);
        deal.setDealId(dealId);
        ErpFunDeal funDeal = erpFunDealMapper.selectByPrimaryKey(deal);
        Set<Integer> userIds = new HashSet<>();
        for (ErpProcessRuntimeStep node : nodeList) {
            ErpProcessRuntimeStep updateModel = new ErpProcessRuntimeStep();
            if (node == null) {
                continue;
            }
            Byte executorType = node.getExecutorType();
            //以下是对执行人的封装，根据执行类别，封装对应的人员数据
            //首选是具体指定的执人，若没有那么找计划执行人，如果都没有，是第一次创建或者更换，
            // 按照执行类别封装（更换流程会将nodlist中的数据置空传递过来）
            if (executorType != null) {
                if (executorType == 3) {
                    updateModel.setExecutor(funDeal.getDealUserId());
                    updateModel.setExecutorName(funDeal.getDealUserName());
                    if (node.getUpdateUser() != null) {
                        updateModel.setUpdateUser(node.getUpdateUser());
                        updateModel.setUpdateUsername(node.getUpdateUsername());
                    } else if (node.getExecutor() != null) {
                        updateModel.setUpdateUser(node.getExecutor());
                        updateModel.setUpdateUsername(node.getExecutorName());
                    } else {
                        updateModel.setUpdateUser(funDeal.getDealUserId());
                        updateModel.setUpdateUsername(funDeal.getDealUserName());
                    }
                    userIds.add(funDeal.getDealUserId());
                } else if (executorType == 4) {
                    updateModel.setExecutor(funDeal.getSignUserId());
                    updateModel.setExecutorName(funDeal.getSignUserName());
                    if (node.getUpdateUser() != null) {
                        updateModel.setUpdateUser(node.getUpdateUser());
                        updateModel.setUpdateUsername(node.getUpdateUsername());
                    } else if (node.getExecutor() != null) {
                        updateModel.setUpdateUser(node.getExecutor());
                        updateModel.setUpdateUsername(node.getExecutorName());
                    } else {
                        updateModel.setUpdateUser(funDeal.getSignUserId());
                        updateModel.setUpdateUsername(funDeal.getSignUserName());
                    }
                    userIds.add(funDeal.getSignUserId());
                } else if (executorType == 1 && node.getExecutor() != null) {
                    if (node.getUpdateUser() != null) {
                        userIds.add(node.getUpdateUser());
                        updateModel.setUpdateUser(node.getUpdateUser());
                        updateModel.setUpdateUsername(node.getUpdateUsername());
                    } else {
                        userIds.add(node.getExecutor());
                        updateModel.setUpdateUser(node.getExecutor());
                        updateModel.setUpdateUsername(node.getExecutorName());
                    }
                }
            }
            String startDate = null;
            // 计划时间为 相对合同签订时间
            // 此步骤为签约收定金
            // 计划时间为 相对合同签订时间
            if (node.getTimelimitType() != null && node.getTimelimitType() == 1 && node.getTimelimitdate() == null) {
                startDate = funDeal.getCreatorDate();
            }
            // 计划时间为 相对前置流程时间 直接根据步骤顺序设置时间
            if (node.getTimelimitType() != null && node.getTimelimitType() == 2 && null == node.getTimelimitdate()) {
                Integer preStepId = node.getRpevstepId();
                ErpProcessRuntimeStep preStep = null;
                if (preStepId != null && !Integer.valueOf("-1").equals(preStepId)) {
                    ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
                    example.setShardCityId(cityId);
                    example.createCriteria().andDealIdEqualTo(dealId).andStepIdEqualTo(preStepId).andDelFlagEqualTo((byte) 0);
                    List<ErpProcessRuntimeStep> processRuntimeStepList = erpProcessRuntimeStepMapper.selectByExample(example);
                    if (processRuntimeStepList != null && processRuntimeStepList.size() > 0) {
                        preStep = processRuntimeStepList.get(0);
                    }
                } else {
                    // id值是-1或空的情况获取本流程的前置流程
                    preStep = erpProcessRuntimeStepMapper.getBeforeRuntimeStep(cityId, dealId, node.getStepSeq());
                    if (null == preStep) {
                        preStep = new ErpProcessRuntimeStep();
                        preStep.setTimelimitdate(funDeal.getCreatorDate());
                    }
                }
                // 如果存在前置流程
                if (preStep != null) {
                    // 前置流程的执行时间
                    startDate = preStep.getTimelimitdate();
                }
            }
            if (null != startDate) {
                int days = node.getTimelimit() / 24;
                Date endDate = DateTimeHelper.addDays(DateTimeHelper.parseToDate(startDate), days);
                updateModel.setTimelimitdate(DateTimeHelper.formatDateTimetoString(endDate, DateTimeHelper.FMT_yyyyMMdd));
            }
            // 重新设置一下dealId 防止报错
            updateModel.setDealId(node.getDealId());
            updateModel.setRunstepId(node.getRunstepId());
            updateModel.setShardCityId(cityId);
            erpProcessRuntimeStepMapper.updateByPrimaryKeySelective(updateModel);
        }
        erpDealUserRelativeService.createDealUserRelativeOffStep(cityId, compId, dealId, userIds, Const.DIC_RELATE_TYPE_STEPUSER);
    }

    @Override
    public void updateStepExcutorOfNotDoing(Integer cityId, Integer compId, Integer dealId, Integer userId, String userType) {
        if (dealId == null && userId == null) {
            return;
        }
        ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
        if (funUsers == null) {
            return;
        }
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.setShardCityId(cityId);
        ErpProcessRuntimeStepExample.Criteria criteria = processRuntimeStepExample.createCriteria();
        criteria.andDelFlagEqualTo((byte) 0).andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andRunstepStatusEqualTo(Const.DIC_RUNSTEP_STATUS_NOTDOING);
        if ("SIGN_USER".equals(userType)) {
            criteria.andExecutorTypeEqualTo((byte) 4);
        } else if ("DEAL_USER".equals(userType)) {
            criteria.andExecutorTypeEqualTo((byte) 3);
        } else {
            return;
        }
        ErpProcessRuntimeStep erpProcessRuntimeStep = new ErpProcessRuntimeStep();
        erpProcessRuntimeStep.setExecutor(funUsers.getUserId());
        erpProcessRuntimeStep.setExecutorName(funUsers.getUserName());
        erpProcessRuntimeStep.setUpdateUser(funUsers.getUserId());
        erpProcessRuntimeStep.setUpdateUsername(funUsers.getUserName());
        erpProcessRuntimeStepMapper.updateByExampleSelective(erpProcessRuntimeStep, processRuntimeStepExample);
    }

    /**
     * @tag 为合同根据模板生成流程实例, 同时更新流程总负责人
     * @author 邓永洪
     * @since 2018/6/23
     */
    @Transactional
    @Override
    public void setProcessModelAndUpdateDealUser(Integer cityId, Integer compId, InsertWarrantProcessParam param, ErpProcessRuntimeStep model) {
        Integer modelId = param.getModelId();
        Integer dealId = model.getDealId();
        createProcessRuntimeStep(cityId, modelId, model);// 重新创建该模版
        // 遍历合同的流程步骤,并计算执行人执行时间等
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.setShardCityId(cityId);
        processRuntimeStepExample.setOrderByClause("STEP_SEQ ASC");
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(dealId).andDelFlagEqualTo((byte) 0);
        processRuntimeStepExample.setOrderByClause("STEP_SEQ");
        List<ErpProcessRuntimeStep> nodeList = erpProcessRuntimeStepMapper.selectByExample(processRuntimeStepExample);
        // 创建流程、更换流程时插入修改记录，必须在合同信息修改之前
        String afterFirstStepName = null;
        if (nodeList != null && nodeList.size() > 0) {// 设置第一步的名称
            afterFirstStepName = nodeList.get(0).getStepName();
        }
        nodeList = nodeList.stream().peek(obj -> {
            if (Byte.valueOf("3").equals(obj.getExecutorType()) || Byte.valueOf("4").equals(obj.getExecutorType())) {
                obj.setUpdateUser(null);
                obj.setExecutor(null);
            }
        }).collect(Collectors.toList());
        //将合同标记为履行中
        ErpFunDeal funDeal = new ErpFunDeal();
        funDeal.setDealId(dealId);
        funDeal.setShardCityId(cityId);
        funDeal.setProcessStatus(Const.DIC_DEAL_STATUS_DOING);
        funDeal.setModelId(modelId);
        funDeal.setModelName(param.getModelName());
        // 2019-3-26 大白说,第一次添加权证流程的时候,所有步骤都没有完成,则 FUN_DEAL runStepName 没有值
//		if (StringUtil.isNotBlank(afterFirstStepName)){ // 设置第一步的名称
//			funDeal.setRunstepName(afterFirstStepName);
//		}
        funDeal.setUpdateTime(new Date());
        erpFunDealMapper.updateByPrimaryKeySelective(funDeal);
        // 更新流程总负责人
        erpFunDealService.updateDealUser(cityId, compId, param.getDealUserId(), param.getDealUserName(), dealId);
        // 合同相关人员中也插入流程总负责
        Set<Integer> userIds = new HashSet<>();
        userIds.add(param.getDealUserId());
        erpDealUserRelativeService.createDealUserRelativeOffStep(cityId, compId, dealId, userIds, Const.DIC_RELATE_TYPE_DEALUSER);
        // 遍历合同的流程步骤,并计算执行人执行时间等
        updateProcessStep(cityId, compId, model.getDealId(), nodeList, null);
    }

    /**
     * @tag 先清理再创建(流程步骤)
     * @author 邓永洪
     * @since 2018/6/29
     */
    @Transactional
    @Override
    public void deleteAndNewStep(Integer cityId, Integer compId, changeWarrantParam param, ErpProcessRuntimeStep model) {
        Integer dealId = param.getDealId();
        this.clearProcessModel(cityId, dealId);
        //清空合同流程负责人 放款时间 等等
        erpFunDealMapper.cleanFunDealData(cityId, param.getDealId());
        this.setProcessModelAndUpdateDealUser(cityId, compId, param, model);
    }

    /**
     * @tag 创建权证步骤  检测是否有完成的流程 并提示？ 否则删除原有流程  新建流程
     * @author 邓永洪
     * @since 2018/6/23
     */
    private void createProcessRuntimeStep(Integer cityId, Integer modelId, ErpProcessRuntimeStep model) {
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.setShardCityId(cityId);
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(model.getDealId()).andRunstepStatusEqualTo(Const.DIC_RUNSTEP_STATUS_SUCCESS).andDelFlagEqualTo((byte) 0);
        int countNum = erpProcessRuntimeStepMapper.countByExample(processRuntimeStepExample);
        if (countNum <= 0) {
            clearProcessModel(cityId, model.getDealId());// 清除本合同原本的流程
        } else {
            throw new BusinessException("流程已经生成，并且有步骤已经成功完成,请尝试刷新列表");
        }
        // 创建流程
        erpProcessRuntimeStepMapper.createProcessRuntimeStep(cityId, modelId, model.getDealId());
    }

    /**
     * @tag 清除合同流程
     * @author 邓永洪
     * @since 2018/6/23
     */
    private void clearProcessModel(Integer cityId, Integer dealId) {
        ErpProcessRuntimeStep processRuntimeStep = new ErpProcessRuntimeStep();
        processRuntimeStep.setShardCityId(cityId);
        processRuntimeStep.setDelFlag((byte) 1);
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(dealId);
        processRuntimeStepExample.setShardCityId(cityId);
        erpProcessRuntimeStepMapper.updateByExampleSelective(processRuntimeStep, processRuntimeStepExample);
    }

    @Override
    public void updateStepExcutorOfNotDoing(Integer dealId, Integer userId, String userType, Integer cityId, Integer compId) throws Exception {
        if (dealId == null && userId == null) {
            return;
        }
        ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
        if (funUsers == null) {
            return;
        }

        ErpProcessRuntimeStep erpProcessRuntimeStep = new ErpProcessRuntimeStep();
        erpProcessRuntimeStep.setExecutor(userId);
        erpProcessRuntimeStep.setExecutorName(funUsers.getUserName());
        erpProcessRuntimeStep.setUpdateUser(userId);
        erpProcessRuntimeStep.setUpdateUsername(funUsers.getUserName());

        ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
        example.setShardCityId(cityId);
        Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo((byte) 0).andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andRunstepStatusEqualTo(Const.DIC_RUNSTEP_STATUS_NOTDOING);
        if ("SIGN_USER".equals(userType)) {
            criteria.andExecutorTypeEqualTo((byte) 4);
        } else if ("DEAL_USER".equals(userType)) {
            criteria.andExecutorTypeEqualTo((byte) 3);
        } else {
            return;
        }
        erpProcessRuntimeStepMapper.updateByExampleSelective(erpProcessRuntimeStep, example);
    }

    @Override
    public void insertMgrWarrantProcess(InsertWarrantProcessParam param, ErpProcessRuntimeStep model, GeneralParam generalParam, String trackContent) {
        this.setProcessModelAndUpdateDealUser(generalParam.getCityId(), generalParam.getCompId(), param, model);
        erpFunProcessRecordService.insert4UpdateStep(generalParam, model.getDealId(), null, null,
                Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATE, trackContent, null);
    }

    /**
     * @Title 插入流程
     * @Author lcb
     * @Time 2019/6/24 15:52
     * @Desc
     **/
    @Override
    public void insertRunTimeStep(InsertRunTimeStepParam param, InsertRunTimeStepVO insertRunTimeStepVO) throws Exception {
        ErpProcessModelStep erpProcessModelStep = new ErpProcessModelStep();
        erpProcessModelStep.setShardCityId(param.getCityId());
        erpProcessModelStep.setStepId(param.getStepId());
        erpProcessModelStep = erpProcessModelStepMapper.selectByPrimaryKey(erpProcessModelStep);
        Assert.isTrueThrow(null == erpProcessModelStep, "所选流程步骤有误，请重新选择");
        // 处理前端传入的数据

        if (null != param.getTimelimit()) {
            erpProcessModelStep.setTimelimit(param.getTimelimit());
        }

        if (null != param.getTimelimitType()) {
            erpProcessModelStep.setTimelimitType(param.getTimelimitType());
        }

        if (null != param.getExecutorType()) {
            erpProcessModelStep.setExecutorType(param.getExecutorType());
        }

        if (null != param.getExecutor()) {
            erpProcessModelStep.setExecutor(param.getExecutor());
        }

        if (null != param.getExecutorName()) {
            erpProcessModelStep.setExecutorName(param.getExecutorName());
        }

        if (null != param.getRpevstepId()) {
            erpProcessModelStep.setRpevstepId(param.getRpevstepId());
        }

        if (StringUtil.isNotBlank(param.getRpevstepName())) {
            erpProcessModelStep.setRpevstepName(param.getRpevstepName());
        }

        Integer runtimeStepId = dealInsertStepBussiness(param, erpProcessModelStep);


        insertRunTimeStepVO.setDealId(param.getDealId());
        insertRunTimeStepVO.setRunStepId(runtimeStepId);
        insertRunTimeStepVO.setStepSeq(param.getStepSeq());
    }

    /**
     * @Title 处理新插入步骤的业务逻辑
     * @Author lcb
     * @Time 2019/6/24 16:00
     * @Desc
     **/
    private Integer dealInsertStepBussiness(InsertRunTimeStepParam param, ErpProcessModelStep erpProcessModelStep) throws Exception {
        ErpFunDeal deal = new ErpFunDeal();
        deal.setShardCityId(param.getCityId());
        deal.setDealId(param.getDealId());
        ErpFunDeal funDeal = erpFunDealMapper.selectByPrimaryKey(deal);

        Set<Integer> userIds = new HashSet<>();
        ErpProcessRuntimeStep updateModel = new ErpProcessRuntimeStep();
        updateModel.setStepSeq(param.getStepSeq());

        // 先copy一份相同属性
        BeanUtilsHelper.copyProperties(updateModel, erpProcessModelStep);

        Byte executorType = erpProcessModelStep.getExecutorType();
        if (executorType != null) {
            if (executorType == 3) {
                updateModel.setExecutor(funDeal.getDealUserId());
                updateModel.setExecutorName(funDeal.getDealUserName());
                updateModel.setUpdateUser(funDeal.getDealUserId());
                updateModel.setUpdateUsername(funDeal.getDealUserName());
                userIds.add(funDeal.getDealUserId());
            } else if (executorType == 4) {
                updateModel.setExecutor(funDeal.getSignUserId());
                updateModel.setExecutorName(funDeal.getSignUserName());
                updateModel.setUpdateUser(funDeal.getSignUserId());
                updateModel.setUpdateUsername(funDeal.getSignUserName());
                userIds.add(funDeal.getSignUserId());
            } else if (executorType == 1 && erpProcessModelStep.getExecutor() != null) {
                userIds.add(erpProcessModelStep.getExecutor());
                updateModel.setUpdateUser(erpProcessModelStep.getExecutor());
                updateModel.setUpdateUsername(erpProcessModelStep.getExecutorName());
            }
        }
        String startDate = null;
        // 计划时间为 相对合同签订时间
        // 此步骤为签约收定金
        // 计划时间为 相对合同签订时间
        if (erpProcessModelStep.getTimelimitType() != null && erpProcessModelStep.getTimelimitType() == 1) {
            startDate = funDeal.getCreatorDate();
        }
        // 计划时间为 相对前置流程时间
        if (erpProcessModelStep.getTimelimitType() != null && erpProcessModelStep.getTimelimitType() == 2) {
            Integer preStepId = erpProcessModelStep.getRpevstepId();
            ErpProcessRuntimeStep preStep = null;
            if (preStepId != null && !Integer.valueOf("-1").equals(preStepId)) {
                //有明确的前置步骤时，获取该流程
                ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
                example.setShardCityId(param.getCityId());
                example.createCriteria().andDealIdEqualTo(param.getDealId()).andStepIdEqualTo(preStepId).andDelFlagEqualTo((byte) 0);
                List<ErpProcessRuntimeStep> processRuntimeStepList = erpProcessRuntimeStepMapper.selectByExample(example);
                if (processRuntimeStepList != null && processRuntimeStepList.size() > 0) {
                    preStep = processRuntimeStepList.get(0);
                }
            } else {
                // id值是-1或空的情况获取本流程的前置流程
                preStep = erpProcessRuntimeStepMapper.getBeforeRuntimeStep(param.getCityId(), param.getDealId(), param.getStepSeq());
                if (null == preStep) {
                    preStep = new ErpProcessRuntimeStep();
                    preStep.setTimelimitdate(funDeal.getCreatorDate());
                }
            }
            // 如果存在前置流程
            if (preStep != null) {
                // 前置流程的执行时间
                startDate = preStep.getTimelimitdate();
            }
        }
        if (null != startDate) {
            int days = erpProcessModelStep.getTimelimit() / 24;
            Date endDate = DateTimeHelper.addDays(DateTimeHelper.parseToDate(startDate), days);
            updateModel.setTimelimitdate(DateTimeHelper.formatDateTimetoString(endDate, DateTimeHelper.FMT_yyyyMMdd));
        }
        // 重新设置一下dealId 防止报错
        updateModel.setDealId(param.getDealId());
        updateModel.setShardCityId(param.getCityId());

        // 先将大于这个序号的步骤都+1
        erpProcessRuntimeStepMapper.updateStepSeq(param.getCityId(), param.getDealId(), (byte) 0, param.getStepSeq());


        // 查询相邻的一个步骤 处理状态
        ErpProcessRuntimeStep nextRuntimeStep = erpProcessRuntimeStepMapper.getNextRuntimeStep(param.getCityId(), param.getDealId(), param.getStepSeq());
        updateModel.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_NOTDOING);
        if (null != nextRuntimeStep) {
            if (Const.DIC_RUNSTEP_STATUS_SUCCESS.equals(nextRuntimeStep.getRunstepStatus()) || Const.DIC_RUNSTEP_STATUS_SKIP.equals(nextRuntimeStep.getRunstepStatus())) {
                updateModel.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SKIP);
            }
        }
        erpProcessRuntimeStepMapper.insertSelective(updateModel);
        erpDealUserRelativeService.createDealUserRelativeOffStep(param.getCityId(), param.getCompId(), param.getDealId(), userIds, Const.DIC_RELATE_TYPE_STEPUSER);

        String content = param.getCurrentUserName() + "添加了步骤,步骤名为[%s]";
        ErpFunProcessRecord record = new ErpFunProcessRecord();
        record.setDealId(param.getDealId());
        record.setDeptId(param.getDeptId());
        record.setCompId(param.getCompId());
        record.setTrackContent(String.format(content, updateModel.getStepName()));
        record.setUpdateClassic(Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE);
        record.setUpdateUid(param.getUserId());
        record.setUpdateUserName(param.getUserName());
        record.setUpdateDate(DateTimeHelper.getTimeNow());
        record.setShardCityId(param.getCityId());
        record.setRunstrpId(updateModel.getRunstepId());
        erpFunProcessRecordMapper.insertSelective(record);
        return updateModel.getRunstepId();
    }

}
