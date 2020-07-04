package com.myfun.erpWeb.task.controller;

import com.alibaba.fastjson.JSONObject;
import com.ctc.wstx.util.DataUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.build.param.UploadBuildingPhotoParam;
import com.myfun.erpWeb.managecenter.userOpers.param.GetRoleOpersParam;
import com.myfun.erpWeb.task.api.TaskApi;
import com.myfun.erpWeb.task.param.*;
import com.myfun.erpWeb.task.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;

import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.*;

import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.service.business.erpdb.ErpFunMlTaskService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import io.swagger.models.auth.In;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scala.Int;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TaskApiController extends BaseController implements TaskApi {
    @Resource
    ErpFunMlTaskMapper erpFunMlTaskMapper;
    @Resource
    ErpFunUsersMapper erpFunUsersMapper;
    @Resource
    ErpFunMlTaskTimeMapper erpFunMlTaskTimeMapper;
    @Resource
    ErpFunSaleMapper erpFunSaleMapper;
    @Resource
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Resource
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Resource
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Resource
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Resource
    ErpFunMlTaskService erpFunMlTaskService;
    @Resource
    ErpFunMlTaskFileMapper erpFunMlTaskFileMapper;
    @Resource
    ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Resource
    ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Resource
    ErpFunMsgMapper erpFunMsgMapper;
    @Override
    public ResponseJson sendTask(@RequestBody SendTaskParam sendTaskParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer sendorganizationId = operator.getOrganizationId();
        Byte sendNow = sendTaskParam.getSendNow();
        if (sendTaskParam.getCaseType()==null) {
        	sendTaskParam.setCaseType(Byte.valueOf("0"));
        }
        if(sendNow.equals((byte)1)){// 立即发送
            Integer sendTaskId = erpFunMlTaskService.insertSendNowTask(operator, sendTaskParam);
            //  发送消息  只发app端
            ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
            erpFunMlTaskExample.setShardCityId(cityId);
            erpFunMlTaskExample.createCriteria().andSendTaskIdEqualTo(sendTaskId).andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0);
            List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
            ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, sendorganizationId);
//            long l = new Date().getTime();
            // 异步推送消息
            erpFunMlTaskService.appSendMsg(organization,erpFunMlTaskList);
        }else{ //定时任务
            erpFunMlTaskService.insertTimedTask(operator,sendTaskParam);
        }

        return ErpResponseJson.ok();
    }

   
    
    @Override
    public ResponseJson taskDetail(@RequestBody TaskDetailParam taskDetailParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer taskId = taskDetailParam.getTaskId();
        ErpFunMlTask erpFunMlTask = new ErpFunMlTask();
        erpFunMlTask.setShardCityId(cityId);
        erpFunMlTask.setTaskId(taskId);
        ErpFunMlTask erpFunMlTask1 = erpFunMlTaskMapper.selectByPrimaryKey(erpFunMlTask);
        Integer sendTaskId = erpFunMlTask1.getSendTaskId();
        TaskDetailVO vo = new TaskDetailVO();
        if(erpFunMlTask1.getTaskType().equals((byte)1)){// 发布任务
            BeanUtils.copyProperties(erpFunMlTask1,vo);
          /*  Map<Integer, Byte> sendTaskStatus = getSendTaskStatus(Arrays.asList(new Integer[]{taskId}), cityId, compId);
            vo.setCompleteStatus(sendTaskStatus.get(taskId));*/
            // 设置房客源类型
            Byte caseType = erpFunMlTask1.getCaseType();// 类型1出售2出租3求购4求租
            if(caseType!=null){
                setFunAndCustVO(cityId, erpFunMlTask1, vo, caseType);
            }

            // 查询发送任务对应的接收任务
            ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
            erpFunMlTaskExample.setShardCityId(cityId);
            ErpFunMlTaskExample.Criteria criteria = erpFunMlTaskExample.createCriteria();
            criteria.andSendTaskIdEqualTo(taskId).andDelStatusEqualTo((byte)0).andCompIdEqualTo(compId).andTaskTypeEqualTo((byte)2);
            List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
            if(erpFunMlTaskList.size()==1){
                vo.setTaskCompleteTime(erpFunMlTaskList.get(0).getTaskCompleteTime());
            }
//            List<Integer> collect = erpFunMlTaskList.stream().map(ErpFunMlTask::getRecieveArchiveId).collect(Collectors.toList());
//            Map<Integer, String> userPhoto = getUserPhoto(collect);
//            List<TaskDetailTaskVO> recieveTaskList = new ArrayList<>();
//            if(erpFunMlTaskList!=null&&erpFunMlTaskList.size()!=0){
//                erpFunMlTaskList.stream().forEach(erpFunMlTask2 -> {
//                    TaskDetailTaskVO taskDetailTaskVO = new TaskDetailTaskVO();
//                    BeanUtils.copyProperties(erpFunMlTask2,taskDetailTaskVO);
//                    taskDetailTaskVO.setHeadImgUrl(AppConfig.getHousePicDomainPath(userPhoto.get(erpFunMlTask2.getRecieveArchiveId())));
//                    recieveTaskList.add(taskDetailTaskVO);
//                });
//                // 按照 未完成/延期  无法翻车  完成 排序  1完成2未完成3延期4无法完成
//                recieveTaskList.stream().forEach(v->{
//                    if(v.getCompleteStatus().equals((byte)1)){
//                        v.setCompleteStatus((byte)5);
//                    }
//                });
//                List<TaskDetailTaskVO> collect1 = recieveTaskList.stream().sorted(Comparator.comparing(TaskDetailTaskVO::getCompleteStatus)).collect(Collectors.toList());
//                collect1.stream().forEach(v->{
//                            if(v.getCompleteStatus().equals((byte)5)){
//                                v.setCompleteStatus((byte)1);
//                            }
//                    Byte completeStatus = v.getCompleteStatus();
//                    Date taskEndTime = v.getTaskEndTime();
//                    if(completeStatus.equals((byte)2)&&taskEndTime.getTime()<new Date().getTime()){
//                        v.setCompleteStatus((byte)3);
//                    }else{
//                        v.setCompleteStatus(v.getCompleteStatus());
//                    }
//
//                });
//                vo.setRecieveTaskList(collect1);
//
//            }


            Date now = new Date();
//            for (ErpFunMlTask erpFunMlTask4 : erpFunMlTaskList) {
//                if(erpFunMlTask4.getCompleteStatus().equals((byte)1)){
//                    completeCount++;
//                }
//                if(erpFunMlTask4.getCompleteStatus().equals((byte)2)&&erpFunMlTask4.getTaskEndTime().getTime()>now.getTime()){
//                    notCompleteCount++;
//                }
//                if(erpFunMlTask4.getCompleteStatus().equals((byte)4)){
//                    unAbleCompleteCount++;
//                }
//                if(erpFunMlTask4.getCompleteStatus().equals((byte)2)&&erpFunMlTask4.getTaskEndTime().getTime()<now.getTime()){
//                    overDueCount++;
//                }
//
//            }
            ErpFunMlTaskExample erpFunMlTaskExample2 = new ErpFunMlTaskExample();
            erpFunMlTaskExample2.setShardCityId(cityId);
            ErpFunMlTaskExample.Criteria criteria2 = erpFunMlTaskExample2.createCriteria();
            criteria2.andSendTaskIdEqualTo(taskId).andDelStatusEqualTo((byte)0).andCompIdEqualTo(compId).andTaskTypeEqualTo((byte)2);
            int recieveTotalCount = erpFunMlTaskMapper.countByExample(erpFunMlTaskExample2);
            // 1完成2未完成3延期4无法完成
//            Integer completeCount=0;//已经完成
//            Integer notCompleteCount=0;// 未完成
//            Integer unAbleCompleteCount=0;// 无法完成
//            Integer overDueCount=0;//延期个数
            //查询已经完成个数
            ErpFunMlTaskExample completeCountExampe = new ErpFunMlTaskExample();
            completeCountExampe.setShardCityId(cityId);
            completeCountExampe.createCriteria().andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0).andSendTaskIdEqualTo(taskId)
                    .andCompIdEqualTo(compId).andCompleteStatusEqualTo((byte)5);
            int completeCount = erpFunMlTaskMapper.countByExample(completeCountExampe);
            //查询未完成个数
            ErpFunMlTaskExample notCompleteCountExampe = new ErpFunMlTaskExample();
            notCompleteCountExampe.setShardCityId(cityId);
            notCompleteCountExampe.createCriteria().andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0).andSendTaskIdEqualTo(taskId)
                    .andCompIdEqualTo(compId).andCompleteStatusEqualTo((byte)2).andTaskEndTimeGreaterThan(now);
            int notCompleteCount = erpFunMlTaskMapper.countByExample(notCompleteCountExampe);
            //查询无法完成个数
            ErpFunMlTaskExample unAbleCompleteCountExampe = new ErpFunMlTaskExample();
            unAbleCompleteCountExampe.setShardCityId(cityId);
            unAbleCompleteCountExampe.createCriteria().andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0).andSendTaskIdEqualTo(taskId)
                    .andCompIdEqualTo(compId).andCompleteStatusEqualTo((byte)4);
            int unAbleCompleteCount = erpFunMlTaskMapper.countByExample(unAbleCompleteCountExampe);
            //查询延期完成个数
            ErpFunMlTaskExample overDueCountExampe = new ErpFunMlTaskExample();
            overDueCountExampe.setShardCityId(cityId);
            overDueCountExampe.createCriteria().andTaskTypeEqualTo((byte)2).andDelStatusEqualTo((byte)0).andSendTaskIdEqualTo(taskId)
                    .andCompIdEqualTo(compId).andCompleteStatusEqualTo((byte)2).andTaskEndTimeLessThanOrEqualTo(now);
            int overDueCount = erpFunMlTaskMapper.countByExample(overDueCountExampe);
            vo.setSendPeopleCount(recieveTotalCount);
            vo.setCompleteCount(completeCount);
            vo.setNotCompleteCount(notCompleteCount);
            vo.setUnablecompleteCount(unAbleCompleteCount);
            vo.setOverDueCount(overDueCount);
            Integer sendArchiveId = erpFunMlTask1.getSendArchiveId();
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(sendArchiveId);
            // 头像
            vo.setHeadImgUrl(AppConfig.getHousePicDomainPath(adminFunArchive.getUserPhoto()));
            // 设置附件
            ErpFunMlTaskFileExample erpFunMlTaskFileExample = new ErpFunMlTaskFileExample();
            erpFunMlTaskFileExample.setShardCityId(cityId);
            erpFunMlTaskFileExample.createCriteria().andTaskIdEqualTo(taskId);
            List<ErpFunMlTaskFile> erpFunMlTaskFiles = erpFunMlTaskFileMapper.selectByExample(erpFunMlTaskFileExample);
            List<TaskFileVO> taskFileVOList = new ArrayList<>();
            if(erpFunMlTaskFiles!=null&&erpFunMlTaskFiles.size()!=0){
                for (ErpFunMlTaskFile erpFunMlTaskFile : erpFunMlTaskFiles) {
                    TaskFileVO taskFileVO = new TaskFileVO();
                    BeanUtils.copyProperties(erpFunMlTaskFile,taskFileVO);
                    taskFileVO.setFileAddr(AppConfig.getHousePicDomainPath(taskFileVO.getFileAddr()));
                    taskFileVOList.add(taskFileVO);
                }
            }
            if(vo.getCompleteStatus()==5){
                vo.setCompleteStatus((byte)1);

            }
            vo.setTaskFileVOList(taskFileVOList);
        }else{// 接收任务
            BeanUtils.copyProperties(erpFunMlTask1,vo);
            // 设置房客源类型
            Byte caseType = erpFunMlTask1.getCaseType();// 类型1出售2出租3求购4求租
        /*    Integer caseId = erpFunMlTask1.getCaseId();
            FunAndCustVO funAndCustVO = new FunAndCustVO();*/
            if(caseType!=null){
                setFunAndCustVO(cityId, erpFunMlTask1, vo, caseType);
            }

            Integer sendArchiveId = erpFunMlTask1.getSendArchiveId();
            Integer recieveArchiveId = erpFunMlTask1.getRecieveArchiveId();
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(sendArchiveId);
            AdminFunArchive recieveFunArchive = adminFunArchiveMapper.selectByPrimaryKey(recieveArchiveId);
            // 头像
            vo.setHeadImgUrl(AppConfig.getHousePicDomainPath(adminFunArchive.getUserPhoto()));
            // 设置是否延期
            Byte completeStatus = vo.getCompleteStatus();
            Date taskEndTime = vo.getTaskEndTime();
            if(completeStatus.equals((byte)2)&&taskEndTime.getTime()<new Date().getTime()){
                vo.setCompleteStatus((byte)3);
            }
            // 设置附件
            ErpFunMlTaskFileExample erpFunMlTaskFileExample = new ErpFunMlTaskFileExample();
            erpFunMlTaskFileExample.setShardCityId(cityId);
            erpFunMlTaskFileExample.createCriteria().andTaskIdEqualTo(sendTaskId);
            List<ErpFunMlTaskFile> erpFunMlTaskFiles = erpFunMlTaskFileMapper.selectByExample(erpFunMlTaskFileExample);
            List<TaskFileVO> taskFileVOList = new ArrayList<>();
            if(erpFunMlTaskFiles!=null&&erpFunMlTaskFiles.size()!=0){
                for (ErpFunMlTaskFile erpFunMlTaskFile : erpFunMlTaskFiles) {
                    TaskFileVO taskFileVO = new TaskFileVO();
                    BeanUtils.copyProperties(erpFunMlTaskFile,taskFileVO);
                    taskFileVO.setFileAddr(AppConfig.getHousePicDomainPath(erpFunMlTaskFile.getFileAddr()));
                    taskFileVOList.add(taskFileVO);
                }
            }
//            List<TaskDetailTaskVO> recieveTaskList = new ArrayList<>();
            TaskDetailTaskVO taskDetailTaskVO = new TaskDetailTaskVO();
            taskDetailTaskVO.setHeadImgUrl(AppConfig.getHousePicDomainPath(recieveFunArchive.getUserPhoto()));
            taskDetailTaskVO.setRecieveUsersName(erpFunMlTask1.getRecieveUsersName());
            if(completeStatus.equals((byte)2)&&taskEndTime.getTime()<new Date().getTime()){
                taskDetailTaskVO.setCompleteStatus((byte)3);
            }else{
                taskDetailTaskVO.setCompleteStatus(erpFunMlTask1.getCompleteStatus());
            }
            taskDetailTaskVO.setTaskCompleteTime(erpFunMlTask1.getTaskCompleteTime());
            taskDetailTaskVO.setTaskRemark(erpFunMlTask1.getTaskRemark());
//            recieveTaskList.add(taskDetailTaskVO);
//            vo.setRecieveTaskList(recieveTaskList);
            vo.setTaskFileVOList(taskFileVOList);
            if(vo.getCompleteStatus()==5){
                vo.setCompleteStatus((byte)1);
            }
        }
        return ErpResponseJson.ok(vo);
    }

    private void setFunAndCustVO(Integer cityId, ErpFunMlTask erpFunMlTask1, TaskDetailVO vo, Byte caseType) {
        Integer caseId = erpFunMlTask1.getCaseId();
        FunAndCustVO funAndCustVO = new FunAndCustVO();
        switch (caseType){
            case (byte)1://出售
                ErpFunSale erpFunSaleCondition = new ErpFunSale();
                erpFunSaleCondition.setShardCityId(cityId);
                erpFunSaleCondition.setSaleId(caseId);
                ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSaleCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(erpFunSale.getBuildName());
                funAndCustVO.setRoom(erpFunSale.getSaleRoom());
                funAndCustVO.setHall(erpFunSale.getSaleHall());
                funAndCustVO.setWei(erpFunSale.getSaleWei());
                funAndCustVO.setPicUrl(erpFunSale.getThumbUrl());
                funAndCustVO.setPrice(erpFunSale.getSaleTotalPrice());
                funAndCustVO.setArea(erpFunSale.getSaleArea());
                funAndCustVO.setPriceUnitCn("万元");
                Integer userId = erpFunSale.getUserId();
                if(userId!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)2://出租
                ErpFunLease erpFunLeaseCondition = new ErpFunLease();
                erpFunLeaseCondition.setShardCityId(cityId);
                erpFunLeaseCondition.setLeaseId(caseId);
                ErpFunLease funLeaseByLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(funLeaseByLease.getBuildName());
                funAndCustVO.setRoom(funLeaseByLease.getLeaseRoom());
                funAndCustVO.setHall(funLeaseByLease.getLeaseHall());
                funAndCustVO.setWei(funLeaseByLease.getLeaseWei());
                funAndCustVO.setPicUrl(funLeaseByLease.getThumbUrl());
                funAndCustVO.setPrice(funLeaseByLease.getLeaseTotalPrice());
                funAndCustVO.setArea(funLeaseByLease.getLeaseArea());
                Byte priceUnit = funLeaseByLease.getPriceUnit();
                String price_unit = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", priceUnit + "");
                funAndCustVO.setPriceUnitCn(price_unit);
                Integer userId1 = funLeaseByLease.getUserId();
                if(userId1!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId1);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)3://求购
                ErpFunBuyCustomer buyCondition = new ErpFunBuyCustomer();
                buyCondition.setShardCityId(cityId);
                buyCondition.setBuyCustId(caseId);
                ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(buyCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(erpFunBuyCustomer.getBuyCustName());
                funAndCustVO.setCustBuildName(erpFunBuyCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(erpFunBuyCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(erpFunBuyCustomer.getHousePriceHigh());
                Byte houseRoom = erpFunBuyCustomer.getHouseRoom();
                Byte houseRoom1 = erpFunBuyCustomer.getHouseRoom1();
                funAndCustVO.setCustHouseRoom(houseRoom+"-"+houseRoom1+"室");
                Integer userId2 = erpFunBuyCustomer.getUserId();
                if(userId2!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId2);
                    funAndCustVO.setCustBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setCustBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)4://求租
                ErpFunRentCustomerKey rentCondition = new ErpFunRentCustomerKey();
                rentCondition.setShardCityId(cityId);
                rentCondition.setRentCustId(caseId);
                ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(rentCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(rentCustomer.getRentCustName());
                funAndCustVO.setCustBuildName(rentCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(rentCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(rentCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(rentCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(rentCustomer.getHousePriceHigh());
                Byte houseRoom2 = rentCustomer.getHouseRoom();
                Byte houseRoom3 = rentCustomer.getHouseRoom1();
                funAndCustVO.setCustHouseRoom(houseRoom2+"-"+houseRoom3+"室");
                Integer userId3 = rentCustomer.getUserId();
                if(userId3!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId3);
                    funAndCustVO.setCustBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setCustBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
        }
    }
    private void listSetFunAndCustVO(Integer cityId, ErpFunMlTask erpFunMlTask1, TaskListVO vo, Byte caseType) {
        Integer caseId = erpFunMlTask1.getCaseId();
        FunAndCustVO funAndCustVO = new FunAndCustVO();
        switch (caseType){
            case (byte)1://出售
                ErpFunSale erpFunSaleCondition = new ErpFunSale();
                erpFunSaleCondition.setShardCityId(cityId);
                erpFunSaleCondition.setSaleId(caseId);
                ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSaleCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(erpFunSale.getBuildName());
                funAndCustVO.setRoom(erpFunSale.getSaleRoom());
                funAndCustVO.setHall(erpFunSale.getSaleHall());
                funAndCustVO.setWei(erpFunSale.getSaleWei());
                funAndCustVO.setPicUrl(erpFunSale.getThumbUrl());
                funAndCustVO.setPrice(erpFunSale.getSaleTotalPrice());
                funAndCustVO.setPriceUnitCn("万元");
                Integer userId = erpFunSale.getUserId();
                if(userId!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)2://出租
                ErpFunLease erpFunLeaseCondition = new ErpFunLease();
                erpFunLeaseCondition.setShardCityId(cityId);
                erpFunLeaseCondition.setLeaseId(caseId);
                ErpFunLease funLeaseByLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(funLeaseByLease.getBuildName());
                funAndCustVO.setRoom(funLeaseByLease.getLeaseRoom());
                funAndCustVO.setHall(funLeaseByLease.getLeaseHall());
                funAndCustVO.setWei(funLeaseByLease.getLeaseWei());
                funAndCustVO.setPicUrl(funLeaseByLease.getThumbUrl());
                funAndCustVO.setPrice(funLeaseByLease.getLeaseTotalPrice());
                Byte priceUnit = funLeaseByLease.getPriceUnit();
                String price_unit = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", priceUnit + "");
                funAndCustVO.setPriceUnitCn(price_unit);
                Integer userId1 = funLeaseByLease.getUserId();
                if(userId1!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId1);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)3://求购
                ErpFunBuyCustomer buyCondition = new ErpFunBuyCustomer();
                buyCondition.setShardCityId(cityId);
                buyCondition.setBuyCustId(caseId);
                ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(buyCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(erpFunBuyCustomer.getBuyCustName());
                funAndCustVO.setCustBuildName(erpFunBuyCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(erpFunBuyCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(erpFunBuyCustomer.getHousePriceHigh());
                Integer userId2 = erpFunBuyCustomer.getUserId();
                if(userId2!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId2);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                Byte houseRoom = erpFunBuyCustomer.getHouseRoom();
                Byte houseRoom1 = erpFunBuyCustomer.getHouseRoom1();
                funAndCustVO.setCustHouseRoom(houseRoom+"-"+houseRoom1+"室");
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)4://求租
                ErpFunRentCustomerKey rentCondition = new ErpFunRentCustomerKey();
                rentCondition.setShardCityId(cityId);
                rentCondition.setRentCustId(caseId);
                ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(rentCondition);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(rentCustomer.getRentCustName());
                funAndCustVO.setCustBuildName(rentCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(rentCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(rentCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(rentCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(rentCustomer.getHousePriceHigh());
                Integer userId3 = rentCustomer.getUserId();
                if(userId3!=null){
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId3);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                Byte houseRoom2= rentCustomer.getHouseRoom();
                Byte houseRoom3 = rentCustomer.getHouseRoom1();
                funAndCustVO.setCustHouseRoom(houseRoom2+"-"+houseRoom3+"室");
                vo.setFunAndCustVO(funAndCustVO);
                break;
        }
    }
    
    private void listSetFunAndCustVO(Integer cityId, ErpFunMlTask erpFunMlTask1, TaskListVO vo, Byte caseType,Map<Integer,ErpFunSale> saleMap,Map<Integer,ErpFunLease> leaseMap,Map<Integer,ErpFunBuyCustomer> buyCustMap,Map<Integer,ErpFunRentCustomer> rentCustMap,Map<Integer,ErpFunUsers> userMap,Map<String,String> dicMap) {
        Integer caseId = erpFunMlTask1.getCaseId();
        FunAndCustVO funAndCustVO = new FunAndCustVO();
        switch (caseType){
            case (byte)1://出售
                ErpFunSale erpFunSale = saleMap.get(caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(erpFunSale.getBuildName());
                funAndCustVO.setRoom(erpFunSale.getSaleRoom());
                funAndCustVO.setHall(erpFunSale.getSaleHall());
                funAndCustVO.setWei(erpFunSale.getSaleWei());
                funAndCustVO.setPicUrl(erpFunSale.getThumbUrl());
                funAndCustVO.setPrice(erpFunSale.getSaleTotalPrice());
                funAndCustVO.setPriceUnitCn("万元");
                Integer userId = erpFunSale.getUserId();
                if(userId!=null){
                    ErpFunUsers erpFunUsers = userMap.get(userId);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)2://出租
                ErpFunLease funLeaseByLease = leaseMap.get(caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setBuildName(funLeaseByLease.getBuildName());
                funAndCustVO.setRoom(funLeaseByLease.getLeaseRoom());
                funAndCustVO.setHall(funLeaseByLease.getLeaseHall());
                funAndCustVO.setWei(funLeaseByLease.getLeaseWei());
                funAndCustVO.setPicUrl(funLeaseByLease.getThumbUrl());
                funAndCustVO.setPrice(funLeaseByLease.getLeaseTotalPrice());
                Byte priceUnit = funLeaseByLease.getPriceUnit();
                String price_unit = dicMap.get(priceUnit + "");
                funAndCustVO.setPriceUnitCn(price_unit);
                Integer userId1 = funLeaseByLease.getUserId();
                if(userId1!=null){
                    ErpFunUsers erpFunUsers = userMap.get(userId1);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)3://求购
                ErpFunBuyCustomer erpFunBuyCustomer = buyCustMap.get(caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(erpFunBuyCustomer.getBuyCustName());
                funAndCustVO.setCustBuildName(erpFunBuyCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(erpFunBuyCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(erpFunBuyCustomer.getHousePriceHigh());
                Integer userId2 = erpFunBuyCustomer.getUserId();
                if(userId2!=null){
                    ErpFunUsers erpFunUsers = userMap.get(userId2);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                Byte houseRoom = erpFunBuyCustomer.getHouseRoom();
                Byte houseRoom1 = erpFunBuyCustomer.getHouseRoom1();
                if (houseRoom!=null && houseRoom1!=null) {
                	funAndCustVO.setCustHouseRoom(houseRoom+"-"+houseRoom1+"室");
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
            case (byte)4://求租
                ErpFunRentCustomer rentCustomer = rentCustMap.get(caseId);
                funAndCustVO.setCaseId(caseId);
                funAndCustVO.setCaseType(caseType);
                funAndCustVO.setCustName(rentCustomer.getRentCustName());
                funAndCustVO.setCustBuildName(rentCustomer.getBuildName());
                funAndCustVO.setHouseAreaLow(rentCustomer.getHouseAreaLow());
                funAndCustVO.setHouseAreaHigh(rentCustomer.getHouseAreaHigh());
                funAndCustVO.setHousePriceLow(rentCustomer.getHousePriceLow());
                funAndCustVO.setHousePriceHigh(rentCustomer.getHousePriceHigh());
                Integer userId3 = rentCustomer.getUserId();
                if(userId3!=null){
                	  ErpFunUsers erpFunUsers = userMap.get(userId3);
                    funAndCustVO.setBrokerUserName(erpFunUsers.getUserName());
                    funAndCustVO.setBrokerUserTel(erpFunUsers.getUserMobile());
                }
                Byte houseRoom2= rentCustomer.getHouseRoom();
                Byte houseRoom3 = rentCustomer.getHouseRoom1();
                if (houseRoom2!=null && houseRoom3!=null) {
                	funAndCustVO.setCustHouseRoom(houseRoom2+"-"+houseRoom3+"室");
                }
                vo.setFunAndCustVO(funAndCustVO);
                break;
        }
    }

    @Override
    public ResponseJson completeTask(@RequestBody CompleteTaskParam completeTaskParam) throws Exception {
        Operator operator = getOperator();
        Integer userId = operator.getUserId();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
//        ErpFunMlTask funMlTask = new ErpFunMlTask();
        Integer taskId = completeTaskParam.getTaskId();
        ErpFunMlTask condition = new ErpFunMlTask();
        condition.setShardCityId(cityId);
        condition.setTaskId(taskId);
        ErpFunMlTask erpFunMlTask = erpFunMlTaskMapper.selectByPrimaryKey(condition);
        BeanUtils.copyProperties(completeTaskParam,erpFunMlTask);
        erpFunMlTaskService.completeTask(cityId,compId,userId,completeTaskParam.getTaskCompleteTime(),erpFunMlTask);
        // 发送消息给app
        if(erpFunMlTask.getCompleteStatus()==5){//完成任务
            JSONObject paramData = new JSONObject();
            paramData.put("templateId", 134);
            paramData.put("receiver", erpFunMlTask.getSendArchiveId());
            paramData.put("title", "任务已完成");
            String content = erpFunMlTask.getRecieveUsersName()+"已完成任务："+erpFunMlTask.getTaskName()+"";
                    if(StringUtil.isNotEmpty(erpFunMlTask.getTaskRemark())){
                        content=content+",备注："+erpFunMlTask.getTaskRemark();
                    }
            paramData.put("content", content);
            paramData.put("taskId", erpFunMlTask.getSendTaskId());
            paramData.put("taskType", 1);
            paramData.put("secretHeader",AppConfig.getNewAppNetDomain() + "images/im/aduit.png");
            Map<String,Object> paramExt = new HashMap<String,Object>();
            paramExt.put("paramExt", paramData.toJSONString());
            String s = HttpUtil.post2NewJson(AppConfig.getPushWebDomain() + "openApi/push/pushMsg", paramExt);

            // 写入msg表，发小秘书
            ErpFunMsg erpFunMsg = new ErpFunMsg();
            // 李明已完成任务：XXX（任务名称），备注：XXXX（有备注就展示，无备注就不展示）
            String msgContent = erpFunMlTask.getRecieveUsersName()+"已完成任务"+erpFunMlTask.getTaskName();
                    if(StringUtil.isNotEmpty(erpFunMlTask.getTaskRemark())){
                        msgContent+=",备注："+erpFunMlTask.getTaskRemark();
                    }else{
                        msgContent+=".";
                    }
            erpFunMsg.setMsgContent(msgContent);
            erpFunMsg.setSendUser(erpFunMlTask.getRecieveUsersId());
            erpFunMsg.setReceiveUser(erpFunMlTask.getSendUserId());
            erpFunMsg.setCompId(compId);
            erpFunMsg.setCaseId(erpFunMlTask.getTaskId());
            erpFunMsg.setMsgType(12);// 已经完成
            erpFunMsg.setReadFlag(false);//未读.
            erpFunMsg.setShardCityId(cityId);
            erpFunMsgMapper.insertFunMsg(erpFunMsg);

        }else if(erpFunMlTask.getCompleteStatus()==4){//无法完成
            JSONObject paramData = new JSONObject();
            paramData.put("templateId", 134);
            paramData.put("receiver", erpFunMlTask.getSendArchiveId());
            paramData.put("title", "任务无法完成");
            String content = erpFunMlTask.getRecieveUsersName()+"无法完成任务："+erpFunMlTask.getTaskName()+"";
            if(StringUtil.isNotEmpty(erpFunMlTask.getTaskRemark())){
                content=content+",原因："+erpFunMlTask.getTaskRemark();
            }
            paramData.put("content", content);
            paramData.put("taskId", erpFunMlTask.getSendTaskId());
            paramData.put("taskType", 1);
            paramData.put("secretHeader",AppConfig.getNewAppNetDomain() + "images/im/aduit.png");
            Map<String,Object> paramExt = new HashMap<String,Object>();
            paramExt.put("paramExt", paramData.toJSONString());
            String s = HttpUtil.post2NewJson(AppConfig.getPushWebDomain() + "openApi/push/pushMsg", paramExt);

            // 写入msg表，发小秘书
            ErpFunMsg erpFunMsg = new ErpFunMsg();
            // 李明无法完成任务：XXX（任务名称），原因：XXXX（选择无法完成时的原因）
            String msgContent = erpFunMlTask.getRecieveUsersName()+"无法完成任务"+erpFunMlTask.getTaskName();
            if(StringUtil.isNotEmpty(erpFunMlTask.getTaskRemark())){
                msgContent+=",原因："+erpFunMlTask.getTaskRemark();
            }else{
                msgContent+=".";
            }
            erpFunMsg.setMsgContent(msgContent);
            erpFunMsg.setSendUser(erpFunMlTask.getRecieveUsersId());
            erpFunMsg.setReceiveUser(erpFunMlTask.getSendUserId());
            erpFunMsg.setCompId(compId);
            erpFunMsg.setCaseId(erpFunMlTask.getTaskId());
            erpFunMsg.setMsgType(11);// 无法完成
            erpFunMsg.setReadFlag(false);//未读
            erpFunMsg.setShardCityId(cityId);
            erpFunMlTask.setTaskCompleteTime(new Date());// 无法完成时，后台生成完成时间。
            erpFunMsgMapper.insertFunMsg(erpFunMsg);
        }
        return  ErpResponseJson.ok();
    }

    @Override
    public ResponseJson getTaskExceteCase(@RequestBody GetTaskExceteCaseParam completeTaskParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer taskId = completeTaskParam.getTaskId();
        Integer compId = operator.getCompId();
        ErpFunMlTask condition  = new ErpFunMlTask();
        condition.setTaskId(taskId);
        condition.setShardCityId(cityId);
        ErpFunMlTask erpFunMlTask = erpFunMlTaskMapper.selectByPrimaryKey(condition);
        Byte taskType = erpFunMlTask.getTaskType();
        if(taskType==1){//发布任务

            // 查询发送任务对应的接收任务
            ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
            erpFunMlTaskExample.setShardCityId(cityId);
            erpFunMlTaskExample.setOrderByClause("COMPLETE_STATUS ASC");
            ErpFunMlTaskExample.Criteria criteria = erpFunMlTaskExample.createCriteria();
            criteria.andSendTaskIdEqualTo(taskId).andDelStatusEqualTo((byte)0).andCompIdEqualTo(compId).andTaskTypeEqualTo((byte)2);
            PageHelper.startPage(completeTaskParam.getPageOffset(),completeTaskParam.getPageRows());
            List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
            if(erpFunMlTaskList!=null&&erpFunMlTaskList.size()==0){
                return ErpResponseJson.ok(new PageInfo<>(erpFunMlTaskList));
            }
            List<Integer> collect = erpFunMlTaskList.stream().map(ErpFunMlTask::getRecieveArchiveId).collect(Collectors.toList());
            Map<Integer, String> userPhoto = getUserPhoto(collect);
            List<TaskDetailTaskVO> vo = new ArrayList<>();
            erpFunMlTaskList.stream().forEach(erpFunMlTask2 -> {
                TaskDetailTaskVO taskDetailTaskVO = new TaskDetailTaskVO();
                BeanUtils.copyProperties(erpFunMlTask2,taskDetailTaskVO);
                taskDetailTaskVO.setHeadImgUrl(AppConfig.getHousePicDomainPath(userPhoto.get(erpFunMlTask2.getRecieveArchiveId())));
                vo.add(taskDetailTaskVO);

            });
            // 按照 未完成/延期  无法翻车  完成 排序  1完成2未完成3延期4无法完成
//            vo.stream().forEach(v->{
//                if(v.getCompleteStatus().equals((byte)1)){
//                    v.setCompleteStatus((byte)5);
//                }
//            });
            List<TaskDetailTaskVO> collect1 = vo.stream().sorted(Comparator.comparing(TaskDetailTaskVO::getCompleteStatus)).collect(Collectors.toList());
            collect1.stream().forEach(v->{
                if(v.getCompleteStatus().equals((byte)5)){
                    v.setCompleteStatus((byte)1);
                }
                Byte completeStatus = v.getCompleteStatus();
                Date taskEndTime = v.getTaskEndTime();
                if(completeStatus.equals((byte)2)&&taskEndTime.getTime()<new Date().getTime()){
                    v.setCompleteStatus((byte)3);
                }else{
                    v.setCompleteStatus(v.getCompleteStatus());
                }

            });
            PageInfo pageInfo = new PageInfo(erpFunMlTaskList);
            PageInfo pageInfo1 = new PageInfo(vo);
            pageInfo1.setTotal(pageInfo.getTotal());
            pageInfo1.setPageSize(pageInfo.getPageSize());
            pageInfo1.setPageNum(pageInfo.getPageNum());
            pageInfo1.setPages(pageInfo.getPages());
            return ErpResponseJson.ok(pageInfo1);
        }else{//接收任务
            TaskDetailTaskVO vo = new TaskDetailTaskVO();
            BeanUtils.copyProperties(erpFunMlTask,vo);
            List<TaskDetailTaskVO> recieveTaskList  = new ArrayList<>();
            Byte completeStatus = vo.getCompleteStatus();
            Date taskEndTime = vo.getTaskEndTime();
            if(completeStatus.equals((byte)2)&&taskEndTime.getTime()<new Date().getTime()){
                vo.setCompleteStatus((byte)3);
            }else{
                vo.setCompleteStatus(erpFunMlTask.getCompleteStatus());
            }
            if(vo.getCompleteStatus()==5){
                vo.setCompleteStatus((byte) 1);
            }
            recieveTaskList.add(vo);
            PageInfo pageInfo = new PageInfo(recieveTaskList);
            return  ErpResponseJson.ok(pageInfo);
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
     *
     * @param taskIds
     * @param cityId
     * @return
     * 获取发布任务的状态
     * 2、完成情况：
     * （1）如果完成人是多人
     * a、只要有一个人未完成就是未完成
     * b、只要有一个人已延期就是已延期
     * c、如果所有人都是（已完成/无法完成），整个任务的状态是已完成
     *  备注：未完成和已延期不会同时存在
     * （2）完成人只有一个，显示具体的执行情况
     */
    public Map<Integer,Byte> getSendTaskStatus(List<Integer> taskIds, Integer cityId,Integer compId){
        Date now = new Date();
        long nowTime = now.getTime();
        Map<Integer,Byte> map = new HashMap<>();
        ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
        erpFunMlTaskExample.setShardCityId(cityId);
        erpFunMlTaskExample.createCriteria().andSendTaskIdIn(taskIds).andCompIdEqualTo(compId)
                .andDelStatusEqualTo((byte)0).andTaskTypeEqualTo((byte)2);
        List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
        Map<Integer, List<ErpFunMlTask>> collect = erpFunMlTaskList.stream().collect(Collectors.groupingBy(ErpFunMlTask::getSendTaskId));
        collect.forEach((k,v)->{
            // 如果只有一条接收任务。
            if(v.size()==1){
                long taskEndTime2 = v.get(0).getTaskEndTime().getTime();
                if(v.get(0).getTaskCompleteTime()==null&& nowTime-taskEndTime2>0) {
                    map.put(k, (byte) 3);// 延期
                }else{
                    map.put(k,v.get(0).getCompleteStatus());
                }
                return;
            }
            for (ErpFunMlTask erpFunMlTask : v) {
                //先判断是否延期 已经延期 查询时间>任务截止时间 && 任务完成时间为null
                long taskEndTime = erpFunMlTask.getTaskEndTime().getTime();
                if(erpFunMlTask.getTaskCompleteTime()==null&& nowTime-taskEndTime>0){
                    map.put(k,(byte)3);// 延期
                    break;
                }
                // 未完成
                if(erpFunMlTask.getCompleteStatus().equals((byte)2)){//未完成
                    map.put(k,erpFunMlTask.getCompleteStatus());
                    break;
                }
                map.put(k,(byte)1);// 已完成
            }
        });
        return map;
    }

    /**
     *
     * @param operator
     *
     * @param taskListParam
     * @return
     * 发布任务根据状态查询时
     */
    public List<Integer> getSendTaskId(Operator operator ,TaskListParam taskListParam){
        Byte completeStatus = taskListParam.getCompleteStatus();
        Integer sendUserId = operator.getUserId();
        Integer cityId = operator.getCityId();
        ErpFunMlTaskExample erpFunMlTaskExample = new ErpFunMlTaskExample();
        erpFunMlTaskExample.setShardCityId(cityId);
        erpFunMlTaskExample.createCriteria();

        erpFunMlTaskMapper.selectByExample(erpFunMlTaskExample);
        return  null;
    }

    /**
     *
     * @param archieveIds
     * @return
     * 获取经纪人头像
     */
    public Map<Integer,String>getUserPhoto(List<Integer> archieveIds){
        Map<Integer,String> map = new HashMap<>();
        if (archieveIds!=null && !archieveIds.isEmpty()) {
        	List<AdminFunArchive> archiveInfosByIds = adminFunArchiveMapper.getArchiveInfosByIds(archieveIds);
//        Map<Integer, String> collect = archiveInfosByIds.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, v -> v.getUserPhoto()));
        	for (AdminFunArchive archiveInfosById : archiveInfosByIds) {
        		map.put(archiveInfosById.getArchiveId(),archiveInfosById.getUserPhoto());
        	}
        }
        return map;
    }


    
    @Override
    public ResponseJson taskList(@RequestBody TaskListParam sendTaskParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer date = sendTaskParam.getDate();
        sendTaskParam.setUserId(operator.getUserId());
        sendTaskParam.setCompId(compId);
        // 时间
        if (date!=null) {
        	Date startDate = null;
        	Date endDate = null;
            if(date==1){// 今日
            	startDate = DateUtil.todayFirstDate();
            	endDate = new Date();
            }else if(date==2){// 一周内
            	startDate = DateUtil.addDay(DateUtil.todayFirstDate(),-7);
            	endDate = new Date();
            }else if(date==3){// 一月内
                startDate = DateUtil.addMonth(DateUtil.todayFirstDate(),-1);
            	endDate = new Date();
            }else if(date==4){// 一季内
                startDate = DateUtil.addMonth(DateUtil.todayFirstDate(),-3);
            	endDate = new Date();
            } else if(date==5){// 半年内
                startDate = DateUtil.addMonth(DateUtil.todayFirstDate(),-6);
            	endDate = new Date();
            }
            sendTaskParam.setOperateStartTime(startDate);
            sendTaskParam.setOperateEndTime(endDate);
        } 
        if (sendTaskParam.getOrgId()!=null && sendTaskParam.getOrgId()>0) {
        	sendTaskParam.setOrgIdStr("%:"+sendTaskParam.getOrgId()+":%");
        }
        if (sendTaskParam.getKeyWord()!=null) {
        	sendTaskParam.setKeyWord("%"+sendTaskParam.getKeyWord()+"%");
        }
        Integer totalCount = erpFunMlTaskMapper.countTaskCount(cityId, sendTaskParam);
        List<TaskListVO> vo = new ArrayList<>();
        if (totalCount==0) {
        	return ErpResponseJson.ok(vo);
        }
        List<ErpFunMlTask> erpFunMlTaskList = erpFunMlTaskMapper.getTaskList(cityId,sendTaskParam);
        List<Integer> archiveids = erpFunMlTaskList.stream().map(ErpFunMlTask::getSendArchiveId).collect(Collectors.toList());
        Map<Integer, String> userPhoto = getUserPhoto(archiveids);
        //取出所有的关联的房客源
        List<Integer> saleIdList = erpFunMlTaskList.stream().filter(a->Byte.valueOf("1").equals(a.getCaseType())).collect(Collectors.mapping(ErpFunMlTask::getCaseId, Collectors.toList()));
        List<Integer> leaseIdList = erpFunMlTaskList.stream().filter(a->Byte.valueOf("2").equals(a.getCaseType())).collect(Collectors.mapping(ErpFunMlTask::getCaseId, Collectors.toList()));
        Set<Integer> buyIdList = erpFunMlTaskList.stream().filter(a->Byte.valueOf("3").equals(a.getCaseType())).collect(Collectors.mapping(ErpFunMlTask::getCaseId, Collectors.toSet()));
        Set<Integer> rentIdList = erpFunMlTaskList.stream().filter(a->Byte.valueOf("4").equals(a.getCaseType())).collect(Collectors.mapping(ErpFunMlTask::getCaseId, Collectors.toSet()));
        Map<Integer,ErpFunSale> saleMap = null;
        Map<Integer,ErpFunLease> leaseMap = null;
        Map<Integer,ErpFunBuyCustomer> buyMap = null;
        Map<Integer,ErpFunRentCustomer> rentMap = null;
        Map<Integer,ErpFunUsers> userMap = null;
        Map<String,String> byteDicMap = null;
       
        Set<Byte> dicValSet = new HashSet<>();
        Set<Integer> userIdSet = new HashSet<>();
        if (!saleIdList.isEmpty()) {
        	List<ErpFunSale> saleList = erpFunSaleMapper.getFunListByCaseIds(cityId,compId, saleIdList);
        	saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, v->v));
        	Set<Integer> tempUserIdSet = saleList.stream().filter(a->a.getUserId()!=null).collect(Collectors.mapping(ErpFunSale::getUserId, Collectors.toSet()));
        	if (tempUserIdSet!=null && !tempUserIdSet.isEmpty()) {
        		userIdSet.addAll(tempUserIdSet);
        	}
        }
        if (!leaseIdList.isEmpty()) {
        	List<ErpFunLease> leaseList = erpFunLeaseMapper.getFunListByCaseIds(cityId,compId, leaseIdList);
        	leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, v->v));
        	Set<Integer> tempUserIdSet = leaseList.stream().filter(a->a.getUserId()!=null).collect(Collectors.mapping(ErpFunLease::getUserId, Collectors.toSet()));
        	if (tempUserIdSet!=null && !tempUserIdSet.isEmpty()) {
        		userIdSet.addAll(tempUserIdSet);
        	}
        	Set<Byte> priceUnitSet = leaseList.stream().filter(a->a.getPriceUnit()!=null).collect(Collectors.mapping(ErpFunLease::getPriceUnit, Collectors.toSet()));
        	if (priceUnitSet!=null && !priceUnitSet.isEmpty()) {
        		dicValSet.addAll(priceUnitSet);
        	}
        }
        if (!buyIdList.isEmpty()) {
        	List<ErpFunBuyCustomer> buyList = erpFunBuyCustomerMapper.getFunBuyCustListByCompIdAndCaseIds(cityId, compId, buyIdList);
        	buyMap = buyList.stream().collect(Collectors.toMap(ErpFunBuyCustomer::getBuyCustId, v->v));
        	Set<Integer> tempUserIdSet = buyList.stream().filter(a->a.getUserId()!=null).collect(Collectors.mapping(ErpFunBuyCustomer::getUserId, Collectors.toSet()));
        	if (tempUserIdSet!=null && !tempUserIdSet.isEmpty()) {
        		userIdSet.addAll(tempUserIdSet);
        	}
        }
        if (!rentIdList.isEmpty()) {
        	List<ErpFunRentCustomer> rentList = erpFunRentCustomerMapper.getFunRentCustListByCompIdAndCaseIds(cityId, compId, rentIdList);
        	rentMap = rentList.stream().collect(Collectors.toMap(ErpFunRentCustomer::getRentCustId, v->v));
        	Set<Integer> tempUserIdSet = rentList.stream().filter(a->a.getUserId()!=null).collect(Collectors.mapping(ErpFunRentCustomer::getUserId, Collectors.toSet()));
        	if (tempUserIdSet!=null && !tempUserIdSet.isEmpty()) {
        		userIdSet.addAll(tempUserIdSet);
        	}
        }
        if (!userIdSet.isEmpty()) {
        	List<ErpFunUsers> userList = erpFunUsersMapper.selectUserListByIds(cityId, compId, new ArrayList<>(userIdSet));
        	userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user->user));
        }
        if (!dicValSet.isEmpty()) {
        	List<ErpDicDefinitions> difintitionList = erpDicDefinitionsMapper.getDicListByDicValues(cityId,"PRICE_UNIT",new ArrayList<>(dicValSet));
        	byteDicMap = difintitionList.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, ErpDicDefinitions::getDicCnMsg));
        }
   
        Date now = new Date();
        for (ErpFunMlTask erpFunMlTask : erpFunMlTaskList) {
            TaskListVO taskListVO = new TaskListVO();
            BeanUtils.copyProperties(erpFunMlTask,taskListVO);
            if(taskListVO.getCompleteStatus().equals((byte)2)&&taskListVO.getTaskEndTime().getTime()<now.getTime()){
                taskListVO.setCompleteStatus((byte)3);//延期
            }
            Byte caseType1 = erpFunMlTask.getCaseType();
            if(caseType1!=null){
                listSetFunAndCustVO(cityId, erpFunMlTask, taskListVO, caseType1, saleMap, leaseMap, buyMap, rentMap,userMap,byteDicMap);
            }
            taskListVO.setHeadImgUrl(AppConfig.getHousePicDomainPath(userPhoto.get(erpFunMlTask.getSendArchiveId())));
            if(taskListVO.getCompleteStatus()==5){
                taskListVO.setCompleteStatus((byte)1);
            }
            vo.add(taskListVO);

        }
       
        PageInfo pageInfo1 = new PageInfo(vo);
        pageInfo1.setTotal(totalCount);
        pageInfo1.setPageNum(sendTaskParam.getPageOffset());
        pageInfo1.setPageSize(sendTaskParam.getPageRows());
        return ErpResponseJson.ok(pageInfo1);
    }
}
