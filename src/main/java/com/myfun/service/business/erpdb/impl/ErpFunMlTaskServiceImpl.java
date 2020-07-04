package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.task.param.SendTaskParam;
import com.myfun.erpWeb.task.param.TaskFileParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunMlTaskService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunMlTaskServiceImpl extends AbstractService<ErpFunMlTask, ErpFunMlTask> implements ErpFunMlTaskService {
    @Resource
    ErpFunMlTaskMapper erpFunMlTaskMapper;
    @Resource
    ErpFunUsersMapper erpFunUsersMapper;
    @Resource
    ErpFunMlTaskTimeMapper erpFunMlTaskTimeMapper;
    @Resource
    ErpFunMlTaskFileMapper erpFunMlTaskFileMapper;
    @Resource
    ErpFunMsgMapper erpFunMsgMapper;
    @Resource
    ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Override
    public void setBaseMapper() {
        super.baseMapper = erpFunMlTaskMapper;
    }
    @Transactional
    @Override
    public Integer insertSendNowTask(Operator operator, SendTaskParam sendTaskParam) {
        Date date = new Date();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        String sendUserName = operator.getUserName();
        Integer sendarchiveId = operator.getArchiveId();
        Integer sendorganizationId = operator.getOrganizationId();
        String sendorganizationPath = operator.getOrganizationPath();
        String taskDescipt = sendTaskParam.getTaskDescription();
        String taskName = sendTaskParam.getTaskName();
        Byte sendNow = sendTaskParam.getSendNow();
        String taskSearch = StringUtil.isBlank(taskDescipt)?"":taskDescipt;
        taskSearch = taskSearch + ","+(StringUtil.isBlank(taskName)?"":taskName);
        // 发布任务
        ErpFunMlTask erpSendFunMlTask = new ErpFunMlTask();
        BeanUtils.copyProperties(sendTaskParam,erpSendFunMlTask);
        List<Integer> userIdList = new ArrayList<>();

        String fromErp = sendTaskParam.getFromErp();
        if("1".equals(fromErp)){
            String userIdStr = sendTaskParam.getUserIdStr();
            if(StringUtil.isNotEmpty(userIdStr)){
                String[] split = userIdStr.split(",");
                List<String> strings = Arrays.asList(split);
                CollectionUtils.collect(strings,
                        new Transformer(){
                            public java.lang.Object transform(java.lang.Object input){
                                return new Integer((String)input);
                            }
                        } ,userIdList );
            }
        }else{
            userIdList = sendTaskParam.getUserIdList();
        }

        if(userIdList.size()>1){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userIdList.get(0));
            erpSendFunMlTask.setRecieveUsersName(erpFunUsers.getUserName()+"等"+userIdList.size()+"人");
        }else if(userIdList.size()==1){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userIdList.get(0));
            erpSendFunMlTask.setRecieveUsersName(erpFunUsers.getUserName());
        }
        erpSendFunMlTask.setTaskType((byte)1);// 发布任务
        erpSendFunMlTask.setShardCityId(cityId);
        erpSendFunMlTask.setSendUserId(userId);
        erpSendFunMlTask.setSendUserName(sendUserName);
        erpSendFunMlTask.setSendUserOrgId(sendorganizationId);
        erpSendFunMlTask.setSendUserOrgPath(sendorganizationPath);
        erpSendFunMlTask.setCompId(compId);
        erpSendFunMlTask.setCompleteStatus((byte)2);// 未完成
        erpSendFunMlTask.setCreateTime(date);
        erpSendFunMlTask.setDelStatus((byte)0);//未删除
        erpSendFunMlTask.setSendTime(date);
        erpSendFunMlTask.setSeeStatus((byte)1);
        erpSendFunMlTask.setSendArchiveId(sendarchiveId);
        erpSendFunMlTask.setTaskSearch(taskSearch);
        erpSendFunMlTask.setRecieveCount(userIdList.size());
        erpFunMlTaskMapper.insertSelective(erpSendFunMlTask);
        // 接收任务
        Integer sendtaskId = erpSendFunMlTask.getTaskId();
        List<ErpFunMlTask> recieveTaskList = new ArrayList<>();
        Map<Integer, ErpFunUsers> userMap = getUserMap(cityId, userIdList);

        for (Integer recieverUserId : userIdList) {
            ErpFunMlTask recieveTask = new ErpFunMlTask();
            BeanUtils.copyProperties(sendTaskParam,recieveTask);
            erpSendFunMlTask.setShardCityId(cityId);
            recieveTask.setSendTaskId(sendtaskId);// 发送任务的ID
            recieveTask.setSendArchiveId(sendarchiveId);
            recieveTask.setSendUserOrgId(sendorganizationId);
            recieveTask.setSendUserOrgPath(sendorganizationPath);
            recieveTask.setTaskType((byte)2);// 接收任务
            recieveTask.setDelStatus((byte)0);//未删除
            recieveTask.setCompleteStatus((byte)2);// 未完成
            recieveTask.setCompId(compId);
            recieveTask.setSendTime(date);
            recieveTask.setRecieveUsersId(recieverUserId);     // 接收这ID
            ErpFunUsers erpFunUsers = userMap.get(recieverUserId);
            recieveTask.setRecieveUserOrgId(erpFunUsers.getOrganizationId()+"");
            recieveTask.setRecieveUserOrgPath(erpFunUsers.getTissueLine());
            recieveTask.setRecieveUsersName(erpFunUsers.getUserName());
            recieveTask.setRecieveArchiveId(erpFunUsers.getArchiveId());
            recieveTask.setSendUserId(userId);
            recieveTask.setCreateTime(date);
            recieveTask.setSendUserName(sendUserName);
            recieveTask.setSeeStatus((byte)1);// 可看，出现在列表
            recieveTaskList.add(recieveTask);

        }
        int size = recieveTaskList.size();
        int i= 0;

        while (size > 50) {
            erpFunMlTaskMapper.insertRecieveTaskBatch(cityId,recieveTaskList.subList(i, i + 50));
            i = i + 50;
            size = size - 50;
        }
        if (size > 0) {
            erpFunMlTaskMapper.insertRecieveTaskBatch(cityId,recieveTaskList.subList(i, i + size));
        }
// 写入funmsg表用于erp小秘书
        ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
        erpFunMlTaskExample.setShardCityId(cityId);
        erpFunMlTaskExample.createCriteria().andCompIdEqualTo(compId).andDelStatusEqualTo((byte)0).andTaskTypeEqualTo((byte)2)
                .andSendTaskIdEqualTo(sendtaskId);
        List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);

        List<ErpFunMsg> erpFunMsgList = new ArrayList<>();
        List<Integer> orgIds = erpFunMlTaskList.stream().map(ErpFunMlTask::getSendUserOrgId).collect(Collectors.toList());
        Map<Integer, ErpFunOrganization> orgMap = getOrgMap(cityId, compId, orgIds);
        for (ErpFunMlTask erpFunMlTask : erpFunMlTaskList) {
            // 写入消息表，发送小秘书
            ErpFunMsg erpFunMsg = new ErpFunMsg();
            //青羊区门店李明提醒您于2019-12-12 10:10前完成任务：XXXXXX（任务名称）
            ErpFunOrganization organization = orgMap.get(erpFunMlTask.getSendUserOrgId());
            String msgContent = organization.getOrganizationName()+erpFunMlTask.getSendUserName()+"提醒您与"+DateUtil.DateToString(erpFunMlTask.getTaskEndTime(),
                    DateUtil.DateStyle.YYYY_MM_DD_HH_MM_SS)+"前完成任务："+erpFunMlTask.getTaskName();
            erpFunMsg.setMsgContent(msgContent);
            erpFunMsg.setSendUser(erpFunMlTask.getSendUserId());
            erpFunMsg.setReceiveUser(erpFunMlTask.getRecieveUsersId());
            erpFunMsg.setCompId(compId);
            erpFunMsg.setCaseId(erpFunMlTask.getTaskId());
            erpFunMsg.setMsgType(10);// 任务提醒
            erpFunMsg.setReadFlag(false);//未读
            erpFunMsgList.add(erpFunMsg);
        }
        int msgSize = erpFunMsgList.size();
        int k= 0;

        while (msgSize > 50) {
            erpFunMsgMapper.insertTaskMsgBatch(cityId,erpFunMsgList.subList(k, k + 50));
            k = k + 50;
            msgSize = msgSize - 50;
        }
        if (msgSize > 0) {
            erpFunMsgMapper.insertTaskMsgBatch(cityId,erpFunMsgList.subList(k, k + msgSize));
        }

        // 写入附件表
        List<TaskFileParam> taskFileList = sendTaskParam.getTaskFileList();
        if(taskFileList!=null&&taskFileList.size()!=0){
            for (TaskFileParam taskFileParam : taskFileList) {
                ErpFunMlTaskFile funMlTaskFile = new ErpFunMlTaskFile();
                BeanUtils.copyProperties(taskFileParam,funMlTaskFile);
                funMlTaskFile.setTaskId(erpSendFunMlTask.getTaskId());
                funMlTaskFile.setShardCityId(cityId);
                erpFunMlTaskFileMapper.insertSelective(funMlTaskFile);
            }
        }
        return sendtaskId;
    }
    @Transactional
    @Override
    public void insertTimedTask(Operator operator, SendTaskParam sendTaskParam) {
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        String sendUserName = operator.getUserName();
        Integer sendarchiveId = operator.getArchiveId();
        Integer sendorganizationId = operator.getOrganizationId();
        String sendorganizationPath = operator.getOrganizationPath();
        String taskDescipt = sendTaskParam.getTaskDescription();
        String taskName = sendTaskParam.getTaskName();
        Byte sendNow = sendTaskParam.getSendNow();
        String taskSearch = StringUtil.isBlank(taskDescipt)?"":taskDescipt;
        taskSearch = taskSearch + ","+(StringUtil.isBlank(taskName)?"":taskName);

        // 写入接收任务表
        Date date = new Date();
        // 发布任务
        ErpFunMlTask erpSendFunMlTask = new ErpFunMlTask();
        BeanUtils.copyProperties(sendTaskParam,erpSendFunMlTask);
        List<Integer> userIdList = new ArrayList<>();

        String fromErp = sendTaskParam.getFromErp();
        if("1".equals(fromErp)){
            String userIdStr = sendTaskParam.getUserIdStr();
            if(StringUtil.isNotEmpty(userIdStr)){
                String[] split = userIdStr.split(",");
                List<String> strings = Arrays.asList(split);
                CollectionUtils.collect(strings,
                        new Transformer(){
                            public java.lang.Object transform(java.lang.Object input){
                                return new Integer((String)input);
                            }
                        } ,userIdList );
            }
        }else{
            userIdList = sendTaskParam.getUserIdList();
        }

        if(userIdList.size()>1){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userIdList.get(0));
            erpSendFunMlTask.setRecieveUsersName(erpFunUsers.getUserName()+"等"+userIdList.size()+"人");
        }else if(userIdList.size()==1){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userIdList.get(0));
            erpSendFunMlTask.setRecieveUsersName(erpFunUsers.getUserName());
        }
        erpSendFunMlTask.setTaskType((byte)1);// 发布任务
        erpSendFunMlTask.setShardCityId(cityId);
        erpSendFunMlTask.setSendUserId(userId);
        erpSendFunMlTask.setSendUserName(sendUserName);
        erpSendFunMlTask.setSendUserOrgId(sendorganizationId);
        erpSendFunMlTask.setSendUserOrgPath(sendorganizationPath);
        erpSendFunMlTask.setCompId(compId);
        erpSendFunMlTask.setCompleteStatus((byte)2);// 未完成
        erpSendFunMlTask.setCreateTime(date);
        erpSendFunMlTask.setDelStatus((byte)0);//未删除
        erpSendFunMlTask.setSendTime(sendTaskParam.getSendTime());
        erpSendFunMlTask.setSendArchiveId(sendarchiveId);
        erpSendFunMlTask.setSeeStatus((byte)1);
        erpSendFunMlTask.setTaskSearch(taskSearch);
        erpSendFunMlTask.setRecieveCount(userIdList.size());
        erpFunMlTaskMapper.insertSelective(erpSendFunMlTask);
        // 接收任务
        Integer sendtaskId = erpSendFunMlTask.getTaskId();
        List<ErpFunMlTask> recieveTaskList = new ArrayList<>();
        List<ErpFunMlTaskTime> mlTaskTimeList = new ArrayList<>();
        Map<Integer, ErpFunUsers> userMap = getUserMap(cityId, userIdList);

        for (Integer recieverUserId : userIdList) {
            ErpFunMlTask recieveTask = new ErpFunMlTask();
            BeanUtils.copyProperties(sendTaskParam,recieveTask);
            erpSendFunMlTask.setShardCityId(cityId);
            recieveTask.setSendTaskId(sendtaskId);// 发送任务的ID
            recieveTask.setSendArchiveId(sendarchiveId);
            recieveTask.setSendUserOrgId(sendorganizationId);
            recieveTask.setSendUserOrgPath(sendorganizationPath);
            recieveTask.setTaskType((byte)2);// 接收任务
            recieveTask.setDelStatus((byte)0);//未删除
            recieveTask.setCompleteStatus((byte)2);// 未完成
            recieveTask.setCompId(compId);
            recieveTask.setSendTime(sendTaskParam.getSendTime());
            recieveTask.setRecieveUsersId(recieverUserId);     // 接收这ID
            ErpFunUsers erpFunUsers = userMap.get(recieverUserId);
            recieveTask.setRecieveUserOrgId(erpFunUsers.getOrganizationId()+"");
            recieveTask.setRecieveUserOrgPath(erpFunUsers.getTissueLine());
            recieveTask.setRecieveUsersName(erpFunUsers.getUserName());
            recieveTask.setRecieveArchiveId(erpFunUsers.getArchiveId());
            recieveTask.setSendUserId(userId);
            recieveTask.setSendUserName(sendUserName);
            recieveTask.setSeeStatus((byte)0);// 不可见，出现在列表
            recieveTask.setCreateTime(date);
            recieveTaskList.add(recieveTask);

        }
        int size = recieveTaskList.size();
        int i= 0;

        while (size > 50) {
            erpFunMlTaskMapper.insertRecieveTaskBatch(cityId,recieveTaskList.subList(i, i + 50));
            i = i + 50;
            size = size - 50;
        }
        if (size > 0) {
            erpFunMlTaskMapper.insertRecieveTaskBatch(cityId,recieveTaskList.subList(i, i + size));
        }

//            // 因为批量插入不能返回id，所有只能在查询一次
        Integer taskId = erpSendFunMlTask.getTaskId();
        ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
        erpFunMlTaskExample.setShardCityId(cityId);
        erpFunMlTaskExample.createCriteria().andSendTaskIdEqualTo(taskId).andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0);
        List<ErpFunMlTask> erpFunMlTaskList1 = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
        List<ErpFunMlTaskTime> erpFunMlTaskTimeList = new ArrayList<>();
        for (ErpFunMlTask erpFunMlTask : erpFunMlTaskList1) {
            ErpFunMlTaskTime erpFunMlTaskTime = new ErpFunMlTaskTime();
            erpFunMlTaskTime.setCompId(erpFunMlTask.getCompId());
            erpFunMlTaskTime.setCreatedTime(date);
            erpFunMlTaskTime.setRecieveTaskId(erpFunMlTask.getTaskId());
            erpFunMlTaskTime.setRecieveArchiveId(erpFunMlTask.getRecieveArchiveId());
            erpFunMlTaskTime.setRecieveUserId(erpFunMlTask.getRecieveUsersId());
            erpFunMlTaskTime.setRecieveTime(erpFunMlTask.getSendTime());
            erpFunMlTaskTimeList.add(erpFunMlTaskTime);
        }
        int timeSize = erpFunMlTaskTimeList.size();
        int j= 0;

        while (timeSize > 50) {
            erpFunMlTaskTimeMapper.insertBatch(cityId,erpFunMlTaskTimeList.subList(j, j + 50));
            j = j + 50;
            timeSize = timeSize - 50;
        }
        if (timeSize > 0) {
            erpFunMlTaskTimeMapper.insertBatch(cityId,erpFunMlTaskTimeList.subList(j, j + size));
        }
        // 写入附件表
        List<TaskFileParam> taskFileList = sendTaskParam.getTaskFileList();
        if(taskFileList!=null&&taskFileList.size()!=0){
            for (TaskFileParam taskFileParam : taskFileList) {
                ErpFunMlTaskFile funMlTaskFile = new ErpFunMlTaskFile();
                funMlTaskFile.setShardCityId(cityId);
                BeanUtils.copyProperties(taskFileParam,funMlTaskFile);
                funMlTaskFile.setTaskId(erpSendFunMlTask.getTaskId());
                erpFunMlTaskFileMapper.insertSelective(funMlTaskFile);
            }
        }
    }

    @Override
    @Async
    public void appSendMsg(ErpFunOrganization organization,List<ErpFunMlTask> erpFunMlTaskList) {
        for (ErpFunMlTask erpFunMlTask : erpFunMlTaskList) {
            JSONObject paramData = new JSONObject();
            paramData.put("templateId", 134);
            paramData.put("receiver", erpFunMlTask.getRecieveArchiveId());
            paramData.put("title", "任务提醒");
            String content = organization.getOrganizationName()+erpFunMlTask.getSendUserName()+"提醒您于"+ DateUtil.DateToString(erpFunMlTask.getTaskEndTime(),"yyyy-MM-dd HH:mm")+"前完成任务:"+erpFunMlTask.getTaskName();
            paramData.put("content", content);
            paramData.put("taskId", erpFunMlTask.getTaskId());
            paramData.put("taskType", 2);
            paramData.put("secretHeader",AppConfig.getNewAppNetDomain() + "images/im/aduit.png");
            Map<String,Object> paramExt = new HashMap<String,Object>();
            paramExt.put("paramExt", paramData.toJSONString());
            String s = HttpUtil.post2NewJson(AppConfig.getPushWebDomain() + "openApi/push/pushMsg", paramExt);
//                String s1 = HttpUtil.post2NewJson("http://192.168.200.108:8033/pushWeb/" + "openApi/push/pushMsg", paramExt);
//                System.out.println(s1);
        }
    }

    /**
     *
     * @param cityId
     * @param userIds
     * @return
     * 获取多个用户信息
     */
    public Map<Integer,ErpFunUsers> getUserMap(Integer cityId, List<Integer> userIds){
        ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
        erpFunUsersExample.setShardCityId(cityId);
        erpFunUsersExample.createCriteria().andUserIdIn(userIds);
        List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
        return erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
    }
    /**
     *获取多个组织信息
     */
    public Map<Integer,ErpFunOrganization> getOrgMap(Integer cityId, Integer compId,List<Integer> OrgIds){
        List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, OrgIds);
        return erpFunOrganizations.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, org -> org));
    }
    
    @Transactional
	@Override
	public void completeTask(Integer cityId, Integer compId, Integer userId, Date taskCompleteTime,
			ErpFunMlTask erpFunMlTask) {
	  	ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
        erpFunMlTaskExample.setShardCityId(cityId);
        erpFunMlTaskExample.createCriteria().andCompIdEqualTo(compId).andRecieveUsersIdEqualTo(userId).andTaskIdEqualTo(erpFunMlTask.getTaskId());
        erpFunMlTask.setTaskId(null);
        if(erpFunMlTask.getCompleteStatus()==1 || erpFunMlTask.getCompleteStatus() == 4){
        	if (erpFunMlTask.getCompleteStatus()==1) {
        		erpFunMlTask.setCompleteStatus((byte)5); 
        	}
            //计算完成
            erpFunMlTaskMapper.updateCompleteStatus(cityId,compId,userId,taskCompleteTime,erpFunMlTask.getSendTaskId());
        }
        erpFunMlTask.setTaskCompleteTime(taskCompleteTime);
        erpFunMlTaskMapper.updateByExampleSelective(erpFunMlTask,erpFunMlTaskExample);
	}
}
