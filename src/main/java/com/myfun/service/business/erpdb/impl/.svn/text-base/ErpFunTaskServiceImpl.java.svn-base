package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunUserTaskRemindMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminTrackCasestatusEndtaskMapper;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.admindb.po.AdminFunUserTaskRemind;
import com.myfun.repository.admindb.po.AdminTrackCasestatusEndtask;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpUpdateHouseBuildParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyVipErpRelationService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
@Service
public class ErpFunTaskServiceImpl extends AbstractService<ErpFunTask, ErpFunTask> implements ErpFunTaskService {
    @Autowired
    private ErpFunTaskMapper erpFunTaskMapper;
    @Autowired
    private ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    private ErpFunUsersService erpFunUsersService;
    @Autowired
    private ErpFunSaleService erpFunSaleService;
    @Autowired
    private ErpFunLeaseService erpFunLeaseService;
    @Autowired
    private ErpFunBuyCustomerService erpFunBuyCustomerService;
    @Autowired
    private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    private ErpFunTrackService erpFunTrackService;
    @Autowired
    private ErpFunPolicyControlService erpFunPolicyControlService;
    @Autowired
    private ErpAuditRuntimeMapper erpAuditRuntimeMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunCoreInfoMapper erpFunCoreInfoMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;
    @Autowired
    private ErpSalePeopleRelativeService erpSalePeopleRelativeService;
    @Autowired
    private ErpLeasePeopleRelativeService erpLeasePeopleRelativeService;
    @Autowired
    private ErpFunEntrustmentPhotoService erpFunEntrustmentPhotoService;
    @Autowired
    private ErpBuildingSetRoomService erpBuildingSetRoomService;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpFunKeyMapper erpFunKeyMapper;
    @Autowired
    private ErpFunKeyLogMapper erpFunKeyLogMapper;
    @Autowired
    private ErpFunKeyOperationLogMapper erpFunKeyOperationLogMapper;
    @Autowired
    private ErpFunKeyService erpFunKeyService;
    @Autowired
    private ErpFunPhoneMapper erpFunPhoneMapper;
    @Autowired
    private ErpFunAuditMapper erpFunAuditMapper;
    @Autowired
    private ErpFunAdAuditMapper erpFunAdAuditMapper;
    @Autowired
    private ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
    @Autowired
    private ErpFunHouseBiddingService erpFunHouseBiddingService;
    @Autowired
    private AgencyVipErpRelationService agencyVipErpRelationService;
    @Autowired
    private AdminTrackCasestatusEndtaskMapper adminTrackCasestatusEndtaskMapper;
    @Autowired
    private ErpFunTaskTimedMapper erpFunTaskTimedMapper;
    @Autowired
    private AdminFunUserTaskRemindMapper adminFunUserTaskRemindMapper;
    @Autowired
    private ErpCityshareHouseMapper erpCityshareHouseMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    private ErpFunDealMapper erpFunDealMapper;
    @Autowired
    private ErpFunViewLogMapper erpFunViewLogMapper;
    @Autowired
    private ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
    @Autowired
    private ErpLeasePeopleRelativeMapper erpLeasePeopleRelativeMapper;
    @Autowired
    private CacheUtil cacheUtil;
    @Autowired
    private ErpDicDefinitionsMapper erpDicDefinitionsMapper;

    /**
     * @author 方李骥
     * @since 2016年8月29日
     */
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpFunTaskMapper;
    }

    /**
     * @param cityId
     * @param compId
     * @param param
     * @throws BusinessException
     * @author 方李骥
     * @since 2016年8月29日
     */
    @Override
    public void checkApplyForCommitHouseKeyTaskStatus(Integer cityId, Integer compId, CreateHouseKeyParam param) throws BusinessException {
        ErpFunTask conditionModel = new ErpFunTask();
        conditionModel.setCaseId(param.getCaseId());
        conditionModel.setCaseType(param.getCaseType());
        conditionModel.setTrackType(Const.DIC_TRACK_TYPE_KEY);
        conditionModel.setTaskType(Const.DIC_TASK_TYPE_EXAMIN);
        conditionModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        conditionModel.setCompId(compId);
        List<ErpFunTask> taskPoList = erpFunTaskMapper.selectFunTaskByConditionModel(cityId, conditionModel);
        if (taskPoList != null && taskPoList.size() > 0) {
            ErpFunTask erpFunTask = taskPoList.get(0);
            String userName = erpFunUsersService.selectUserNameByUserId(cityId, erpFunTask.getCreatorUid()).getUserName();
            throw new BusinessException("该房源已提交了钥匙申请，申请人是：" + userName + "，请等待审核！");
        }
    }

    /**
     * @param cityId
     * @param compId
     * @param funTrackPO
     * @throws Exception
     * @author 方李骥
     * @since 2016年8月29日
     */
    @Override
    public void createHouseKeyTask(Integer cityId, Integer compId, ErpFunTrack funTrackPO) throws Exception {
        String taskName = null;
        if (funTrackPO.getTrackKey()) {
            String trackContent = funTrackPO.getTrackContent();
            if (trackContent.indexOf("\n钥匙说明：") != -1) {
                trackContent = trackContent.substring(0, trackContent.indexOf("\n钥匙说明："));
            }
            taskName = Const.DIC_TASK_SUBJECT_HEAD_13 + " " + trackContent;
        } else {
            taskName = Const.DIC_TASK_SUBJECT_HEAD_14 + " " + funTrackPO.getTrackContent();
        }
        if (true) {
            throw new ConfirmException("不应该再使用此方法");
        }
        Byte taskType = Const.DIC_TASK_TYPE_EXAMIN;
        //钥匙的审核任务的门店ID必须是房源信息所在门店
//		Map<String,Object> caseInfoMap = getCaseInfo(funTrackPO);
        Integer caseInfoDeptId = null;//(Integer)caseInfoMap.get("deptId");
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCompId(compId);
        insertModel.setCaseId(funTrackPO.getCaseId());
        insertModel.setCaseNo(funTrackPO.getCaseNo());
        insertModel.setCaseType(funTrackPO.getCaseType());
        insertModel.setTaskSubject(taskName);
        insertModel.setTrackId(funTrackPO.getTrackId());
        insertModel.setTrackType(funTrackPO.getTrackType());
        insertModel.setTrackWarm(funTrackPO.getTrackWarm());
        insertModel.setTaskDesc(funTrackPO.getTrackContent());
        insertModel.setDeptId(caseInfoDeptId);
        insertModel.setTaskType(taskType);
        insertModel.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_1);
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(funTrackPO.getCreatorUid());
        insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setShardCityId(funTrackPO.getShardCityId());
        this.insertTask(funTrackPO.getShardCityId(), insertModel, (byte) 0);
    }

    /**
     * @param updateModel
     * @param conditionModel
     * @param trackTypes
     * @author 方李骥
     * @since 2016年8月30日
     */
    @Override
    public void updateFunTask(Integer cityId, ErpFunTask updateModel, ErpFunTask conditionModel, Object[] trackTypes) {
        erpFunTaskMapper.updateFunTask(cityId, updateModel, conditionModel, trackTypes);
    }

    /**
     * @param cityId
     * @param conditionModel
     * @return
     * @author 方李骥
     * @since 2016年9月6日
     */
    @Override
    public Integer countFunTask(Integer cityId, ErpFunTask conditionModel) {
        return erpFunTaskMapper.countFunTask(cityId, conditionModel);
    }

    /**
     * @param cityId
     * @param updateModel
     * @param compId
     * @author 方李骥
     * @since 2016年8月30日
     */
    @Override
    public void updateKeyTask(Integer cityId, Integer compId, Object[] keyIds) {
        erpFunTaskMapper.updateKeyTaskByKeyId(cityId, compId, keyIds);
    }

    @Transactional
    @Override
    @Deprecated
    public void createUpdateHouseBuildTask(ErpUpdateHouseBuildParam param) {
        String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
        // 写一条跟进
        ErpFunTrack erpFunTrack = new ErpFunTrack();
        erpFunTrack.setShardCityId(param.getCityId());
        erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD);
        erpFunTrack.setTargetId(param.getBuildId());
        erpFunTrack.setCaseId(param.getCaseId());
        erpFunTrack.setCaseNo(param.getCaseNo());
        erpFunTrack.setCaseType(param.getCaseType().byteValue());
        erpFunTrack.setCompId(param.getCompId());
        erpFunTrack.setCreationTime(timeNow);
        erpFunTrack.setCreatorUid(param.getUserId());
        erpFunTrack.setDeptId(param.getDeptId());
        erpFunTrack.setCaseDeptId(param.getCaseDeptId());
        erpFunTrack.setCaseUserId(param.getCaseUserId());
        erpFunTrack.setCaseStatus(param.getCaseStatus().byteValue());
        erpFunTrack.setIsUserTrack(1);
        erpFunTrack.setTrackClassic(Const.DIC_TASK_SUBJECT_HEAD_30);
        erpFunTrack.setTrackContent(param.getDeptUserName()
                + " 申请变更房源楼盘："
                + param.getOldBuildName() + ">>" + param.getBuildName()
                + "，变更原因：" + param.getReasons());
        erpFunTrack.setTrackWarm(false);
        erpFunTrackMapper.insertSelective(erpFunTrack);
        // 写一条审核任务
        ErpFunTask record = new ErpFunTask();
        record.setShardCityId(param.getCityId());
        record.setCaseId(param.getCaseId());
        record.setCaseNo(param.getCaseNo());
        record.setCaseType(param.getCaseType().byteValue());
        record.setDeptId(param.getDeptId());
        record.setIsRead(false);
        record.setCreationTime(timeNow);
        record.setTaskStatus((byte) 1);
        record.setTrackWarm(false);
        record.setCaseNo(param.getCaseNo());
        record.setTrackId(erpFunTrack.getTrackId());
        record.setTaskSubject(Const.DIC_TASK_SUBJECT_HEAD_30 + param.getDeptUserName() + " 申请变更房源楼盘名称");
        record.setCaseType(param.getCaseType().byteValue());
        record.setCaseId(param.getCaseId());
        record.setCreatorUid(param.getUserId());
        record.setTaskDesc(Const.DIC_TASK_SUBJECT_HEAD_30 + param.getDeptUserName()
                + " 申请变更房源楼盘："
                + param.getOldBuildName() + ">>" + param.getBuildName()
                + "，变更原因：" + param.getReasons());
        record.setTaskType((byte) 1);
        record.setCompId(param.getCompId());
        record.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_1);
        record.setTrackType(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD);
        this.insertTask(param.getCityId(), record, (byte) 0);
    }

    /**
     * 写过议价跟进的数据 需要修改原数据的议价标记，方便前端右键一键查询
     *
     * @param erpFunTrack
     * @author 熊刚
     * @since 2017年10月12日
     */
    @Transactional
    @Override
    public void updateCaseBargainFlag(ErpFunTrack erpFunTrack, CaseInfoDto caseInfoDto, ErpFunUsers createAuditUser) {
        Integer caseId = erpFunTrack.getCaseId();
        Integer caseType = erpFunTrack.getCaseType().intValue();
        Integer cityId = erpFunTrack.getShardCityId();
        Integer compId = erpFunTrack.getCompId();
        Integer createAuditUserId = createAuditUser.getUserId();

        Map<String, Object> inputMap = new HashMap<>();
        inputMap.put("houseBargain", 1);
        inputMap.put("updateTime", new Date());
        boolean writeTrackTime4House = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, caseType, createAuditUserId);
        if (writeTrackTime4House) {
            inputMap.put("orangeFlag", 0);
            inputMap.put("trackTime", new Date());
            erpFunPolicyControlService.resetPrivateDay(cityId, caseId, caseType, true, false, compId,createAuditUserId);
        }
        if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)) {
            erpFunSaleMapper.updateModelData(cityId, inputMap, caseId, null);
            erpSalePeopleRelativeService.insertSalePeopleRelative(cityId, caseId, createAuditUserId, 6, null);
        } else if (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
            erpFunLeaseMapper.updateModelData(cityId, inputMap, caseId, null);
            erpLeasePeopleRelativeService.insertLeasePeopleRelative(cityId, caseId, createAuditUserId, 6, null);
        }
    }

    @Transactional
    @Override
    public void updateCaseHouseLevel4House(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack) {
        Integer caseId = param.getCaseId();
        Integer cityId = param.getCityId();
        Integer caseType = param.getCaseType();
        Byte trackType = param.getTrackType();
        Integer compId = param.getCompId();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();
        Integer createAuditUser = param.getCreateAuditUser().getUserId();
        Integer caseUserId = param.getCaseUserId();
        Integer caseDeptId = param.getCaseDeptId();

        Byte houseLevel = null;
        Date commendTime = null;
        Date secrecyTime = null;
        Byte sendToWeiDian = null;
        Integer[] houseLevelCount = erpFunTrackService.getSpecialCaseCount(cityId, caseId, caseType, caseUserId, compId, caseDeptId);
        if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(trackType)) {
        	String commendRecords = erpSysParaService.getMLErpSysParamValByOrgId(cityId, compId, param.getCreateAuditUser().getOrganizationId(), "COMMEND_RECORDS");
           /* String commendRecords = erpSysParaMapper.getParamValue(cityId, compId, "COMMEND_RECORDS");*/
            boolean countCompare = houseLevelCount[0] >= StringUtil.parseInteger(commendRecords, 0);
            Assert.isTrueThrow(countCompare, "推荐条数达到上限！");
            houseLevel = Const.DIC_HOUSE_LEVEL_COMMEND;
            commendTime = new Date();// 转推荐日期
        } else if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)) {
        	String passwordRecords = erpSysParaService.getMLErpSysParamValByOrgId(cityId, compId, param.getCreateAuditUser().getOrganizationId(), "PASSWORD_RECORDS");
            boolean countCompare = houseLevelCount[1] >= StringUtil.parseInteger(passwordRecords, 0);
            Assert.isTrueThrow(countCompare, "加密条数达到上限！");
            houseLevel = Const.DIC_HOUSE_LEVEL_PASSWORD;
            sendToWeiDian = (byte) 0;
            secrecyTime = new Date();// 转加密日期
            this.cancelAuditTaskForTransAndSecrecy(cityId, compId, caseType, caseId, Const.DIC_HOUSE_LEVEL_PASSWORD);
        }
        boolean writeTrackTime = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, caseType, createAuditUser);
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setSaleId(caseId);
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setCommendTime(commendTime);
            erpFunSale.setSecrecyTime(secrecyTime);
            erpFunSale.setSaleLevel(houseLevel);
            erpFunSale.setSendtoWeidian(sendToWeiDian);
            erpFunSale.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunSale.setRedFlag(false);
                erpFunSale.setOrangeFlag(false);
                erpFunSale.setTrackTime(new Date());
            }
            erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setLeaseId(caseId);
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setCommendTime(commendTime);
            erpFunLease.setSecrecyTime(secrecyTime);
            erpFunLease.setLeaseLevel(houseLevel);
            erpFunLease.setSendtoWeidian(sendToWeiDian);
            erpFunLease.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunLease.setRedFlag(false);
                erpFunLease.setOrangeFlag(false);
                erpFunLease.setTrackTime(new Date());
            }
            erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
        } else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
            ErpFunBuyCustomer erpFunBuyCustomer = new ErpFunBuyCustomer();
            erpFunBuyCustomer.setBuyCustId(caseId);
            erpFunBuyCustomer.setShardCityId(cityId);
            erpFunBuyCustomer.setCommendTime(DateTimeHelper.formatDateTimetoString(commendTime));
            erpFunBuyCustomer.setSecrecyTime(DateTimeHelper.formatDateTimetoString(secrecyTime));
            erpFunBuyCustomer.setBuyCustLevel(houseLevel);
            erpFunBuyCustomer.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunBuyCustomer.setRedFlag(false);
                erpFunBuyCustomer.setOrangeFlag(false);
                erpFunBuyCustomer.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date()));
            }
            erpFunBuyCustomerMapper.updateByPrimaryKeySelective(erpFunBuyCustomer);
        } else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
            ErpFunRentCustomer erpFunRentCustomer = new ErpFunRentCustomer();
            erpFunRentCustomer.setRentCustId(caseId);
            erpFunRentCustomer.setShardCityId(cityId);
            erpFunRentCustomer.setCommendTime(commendTime);
            erpFunRentCustomer.setSecrecyTime(secrecyTime);
            erpFunRentCustomer.setRentCustLevel(houseLevel);
            erpFunRentCustomer.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunRentCustomer.setRedFlag(false);
                erpFunRentCustomer.setOrangeFlag(false);
                erpFunRentCustomer.setTrackTime(new Date());
            }
            erpFunRentCustomerMapper.updateByPrimaryKeySelective(erpFunRentCustomer);
        }
        if (writeTrackTime) {
            erpFunPolicyControlService.resetPrivateDay(cityId, caseId, caseType, true, false, compId, createAuditUser);
        }
    }

    /**
     * 钥匙借用和注销钥匙-->失效任务：钥匙借用，钥匙注销，钥匙
     *
     * @author 张宏利
     * @since 2017年10月13日
     */
    public void cancelAuditTaskForKey(Integer cityId, Integer compId, Integer caseType, Integer caseId, Byte trackType) {
        Byte[] trackTypes = null;
        if (Const.DIC_TRACK_TYPE_BORROW_KEY.equals(trackType)) {
            trackTypes = new Byte[]{Const.DIC_TRACK_TYPE_BORROW_KEY};
        } else if (Const.DIC_TRACK_TYPE_RETURN_KEY.equals(trackType)) {
            trackTypes = new Byte[]{Const.DIC_TRACK_TYPE_RETURN_KEY};
        } else if (Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(trackType)) {
            trackTypes = new Byte[]{Const.DIC_TRACK_TYPE_SUBMIT_KEY};
        } else {
            trackTypes = new Byte[]{
                    Const.DIC_TRACK_TYPE_BORROW_KEY, Const.DIC_TRACK_TYPE_RETURN_KEY,
                    Const.DIC_TRACK_TYPE_DESTROY_KEY
            };
        }
        String content = "钥匙已被" + this.getCNMsgByStatus(trackType) + "，此任务自动关闭！";
        erpAuditRuntimeMapper.cancelAuditTask(cityId, compId, caseId, caseType, trackTypes, content);
    }


    /**
     * 售转租或租转售|加密-->失效任务：注销 内成交 外成交 电话 加密失效的也是这三个，如果以后变了则重新写个方法吧
     *
     * @author 张宏利
     * @since 2017年10月13日
     */
    public void cancelAuditTaskForTransAndSecrecy(Integer cityId, Integer compId, Integer caseType, Integer caseId, Byte trackType) {
        Byte[] trackTypes = new Byte[]{
                Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, Const.DIC_TRACK_TYPE_STATUS_OUTDEAL,
                Const.DIC_TRACK_TYPE_STATUS_WRITEOFF
        };
        String caseTypeStr = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)
                || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) ? "房源" : "客源";
        String content = "该" + caseTypeStr + "于任务审核期间被" + this.getCNMsgByStatus(trackType);
        erpAuditRuntimeMapper.cancelAuditTask(cityId, compId, caseId, caseType, trackTypes, content);
    }

    /**
     * 跳公盘、抢盘、注销、数据移交 -->（注销、内成交、外成交、封盘、预定、暂缓、电话查看）状态的审核任务都要变为失效
     *
     * @author 张宏利
     * @since 2017年10月13日
     */
    @Override
    public void cancelAuditTaskForWriteoff(Integer cityId, Integer compId, Integer caseId, Integer caseType, Byte trackType) {
        Byte[] trackTypes = new Byte[]{
                Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, Const.DIC_TRACK_TYPE_STATUS_OUTDEAL,
                Const.DIC_TRACK_TYPE_STATUS_WRITEOFF, Const.DIC_TRACK_TYPE_STATUS_SPECIAL,
                Const.DIC_TRACK_TYPE_STATUS_SCHEDULE,
        };
        String caseTypeStr = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)
                || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) ? "房源" : "客源";
        String content = "该" + caseTypeStr + "于任务审核期间被" + this.getCNMsgByStatus(trackType);
        erpAuditRuntimeMapper.cancelAuditTask(cityId, compId, caseId, caseType, trackTypes, content);
    }

    /**
     * 转租、转售 -->（内成交、外成交、电话查看）状态的审核任务都要变为失效
     *
     * @author 张宏利
     * @since 2017年10月13日
     */
    @Override
    public void cancelAuditTaskForTransHouse(Integer cityId, Integer compId, Integer caseId, Integer caseType, Byte trackType) {
        Byte[] trackTypes = new Byte[]{
                Const.DIC_TRACK_TYPE_STATUS_INNERDEAL, Const.DIC_TRACK_TYPE_STATUS_OUTDEAL,
                Const.DIC_TRACK_TYPE_VIEW_PHONE
        };
        String caseTypeStr = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)
                || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) ? "房源" : "客源";
        String content = "该" + caseTypeStr + "于任务审核期间被" + this.getCNMsgByStatus(trackType);
        erpAuditRuntimeMapper.cancelAuditTask(cityId, compId, caseId, caseType, trackTypes, content);
    }

    /**
     * 获取状态的中文说明
     *
     * @param status
     * @return
     * @author 张宏利
     * @since 2017年11月3日
     */
    private String getCNMsgByStatus(Byte trackType) {
        if (Const.DIC_TRACK_TYPE_STATUS_TRANSSALE.equals(trackType)) {
            return "转售";
        } else if (Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE.equals(trackType)) {
            return "转租";
        } else if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)) {
            return "转加密";
        } else if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
            return "内成交";
        } else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)) {
            return "外成交";
        } else if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {
            return "注销";
        } else if (Const.DIC_TRACK_TYPE_BORROW_KEY.equals(trackType)) {
            return "借出";
        } else if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(trackType)) {
            return "注销";
        } else if (Const.DIC_TRACK_TYPE_CASE_TRANSFER.equals(trackType)) {
            return "移交";
        }
        return "";
    }

    /**
     * 带看跟新
     *
     * @param erpFunTrack
     * @author 熊刚
     * @since 2017年10月16日
     */
    @Transactional
    @Override
    public void updateCaseDaikan4Cust(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer custInfoId = param.getCaseId();
        Integer custInfoType = param.getCaseType();
        Integer houseInfoId = param.getTargetId();
        Integer houseInfoType = erpFunTrack.getTargetType().intValue();
        Integer createAuditUid = param.getCreateAuditUser().getUserId();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();
        Date dateNow = new Date();
        String nowTime = DateTimeHelper.formatDateTimetoString(dateNow);
        // 更新房源信息
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(houseInfoType)) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, houseInfoId);
            caseInfoDto.setErpFunSale(erpFunSale);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(houseInfoType)) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, houseInfoId);
            caseInfoDto.setErpFunLease(erpFunLease);
        }
        boolean writeTrackTime4House = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, houseInfoType, createAuditUid);
        if (writeTrackTime4House) {
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(houseInfoType)) {
                ErpFunSale erpFunSale = new ErpFunSale();
                erpFunSale.setSaleId(houseInfoId);
                erpFunSale.setShardCityId(cityId);
                erpFunSale.setOrangeFlag(false);
                erpFunSale.setTrackTime(dateNow);
                erpFunSale.setUpdateTime(dateNow);
                erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(houseInfoType)) {
                ErpFunLease erpFunLease = new ErpFunLease();
                erpFunLease.setLeaseId(houseInfoId);
                erpFunLease.setShardCityId(cityId);
                erpFunLease.setOrangeFlag(false);
                erpFunLease.setTrackTime(dateNow);
                erpFunLease.setUpdateTime(dateNow);
                erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
            }
            erpFunPolicyControlService.resetPrivateDay(cityId, houseInfoId, houseInfoType, true, false, compId , createAuditUid);
        }
        ErpFunTrack trackPoCust = new ErpFunTrack();
        trackPoCust.setCaseId(custInfoId);
        trackPoCust.setCaseType(custInfoType.byteValue());
        trackPoCust.setCreatorUid(erpFunTrack.getCreatorUid());
        // 更新客源信息
        boolean writeTrackTime4Cust = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, custInfoType, createAuditUid);
        if (Const.DIC_CASE_TYPE_BUY_CUST.equals(custInfoType)) {
            ErpFunBuyCustomer erpFunBuyCustomer = new ErpFunBuyCustomer();
            erpFunBuyCustomer.setBuyCustId(custInfoId);
            erpFunBuyCustomer.setShardCityId(cityId);
            erpFunBuyCustomer.setHouseLook(true);
            erpFunBuyCustomer.setRedFlag(false);
            erpFunBuyCustomer.setActionTime(nowTime);
            erpFunBuyCustomer.setUpdateTime(dateNow);
            if (writeTrackTime4Cust) {
                erpFunBuyCustomer.setOrangeFlag(false);
                erpFunBuyCustomer.setTrackTime(nowTime);
            }
            erpFunBuyCustomerMapper.updateByPrimaryKeySelective(erpFunBuyCustomer);
        } else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(custInfoType)) {
            ErpFunRentCustomer erpFunRentCustomer = new ErpFunRentCustomer();
            erpFunRentCustomer.setRentCustId(custInfoId);
            erpFunRentCustomer.setShardCityId(cityId);
            erpFunRentCustomer.setHouseLook(true);
            erpFunRentCustomer.setRedFlag(false);
            erpFunRentCustomer.setActionTime(new Date());
            erpFunRentCustomer.setUpdateTime(dateNow);
            if (writeTrackTime4Cust) {
                erpFunRentCustomer.setOrangeFlag(false);
                erpFunRentCustomer.setTrackTime(dateNow);
            }
            erpFunRentCustomerMapper.updateByPrimaryKeySelective(erpFunRentCustomer);
        }
        erpFunPolicyControlService.resetPrivateDay(cityId, custInfoId, custInfoType, true, false, compId, createAuditUid);
    }

    /**
     * 房勘审核任务通过后更新房源数据的相关逻辑
     *
     * @param erpFunTrack
     * @author 熊刚
     * @since 2017年10月17日
     */
    @Transactional
    @Override
    public void updateCaseFangcan4House(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack) {
        Integer cityId = param.getCityId();
        Integer caseId = param.getCaseId();
        Integer caseType = param.getCaseType();
        Integer compId = param.getCompId();
        Integer createAuditUid = param.getCreateAuditUser().getUserId();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();

        // 是否跟新跟进橙色标记、红色标记和跟进时间
        boolean writeTrackTime = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, caseType, createAuditUid);
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setSaleId(caseId);
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setExplrthDatetime(new Date());
            erpFunSale.setSaleExplrth(true);
            erpFunSale.setRedFlag(false);
            erpFunSale.setHasFunkan((byte) 1);
            erpFunSale.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunSale.setOrangeFlag(false);
                erpFunSale.setTrackTime(new Date());
            }
            erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
            erpSalePeopleRelativeService.insertSalePeopleRelative(cityId, caseId, createAuditUid,
                    Const.HOUSE_RELATIVE_PEOPLE_TYPE_4, null);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setLeaseId(caseId);
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setExplrthDatetime(new Date());
            erpFunLease.setLeaseExplrth(true);
            erpFunLease.setRedFlag(false);
            erpFunLease.setHasFunkan((byte) 1);
            erpFunLease.setUpdateTime(new Date());
            if (writeTrackTime) {
                erpFunLease.setOrangeFlag(false);
                erpFunLease.setTrackTime(new Date());
            }
            erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
            erpLeasePeopleRelativeService.insertLeasePeopleRelative(cityId, caseId, createAuditUid,
                    Const.HOUSE_RELATIVE_PEOPLE_TYPE_4, null);
        }
        erpFunPolicyControlService.resetPrivateDay(cityId, caseId, caseType, true, false, compId, createAuditUid);
    }

    /**
     * 更新对象委托情况
     *
     * @param erpFunTrack
     * @param hongJICompModel
     * @author 熊刚
     * @since 2017年10月17日
     */
    @Transactional
    @Override
    public void updateCaseWeituo(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        Integer caseType = param.getCaseType();
        Integer createAuditUid = param.getCreateAuditUser().getUserId();
        Integer trackId = erpFunTrack.getTrackId();
        Byte trackType = erpFunTrack.getTrackType();
        String trackNo = erpFunTrack.getTrackNo();
        String proxyUrl = erpFunTrack.getProxyUrl();
        String photoUrls = param.getPhotoUrls();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();

        // 清空操作
        proxyUrl = (proxyUrl == null) ? "" : proxyUrl;
        // 是否跟新跟进橙色标记、红色标记和跟进时间
        boolean writeTrackTime = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, caseType, createAuditUid);
        if (writeTrackTime) {
            erpFunPolicyControlService.resetPrivateDay(cityId, caseId, caseType, true, false, compId, createAuditUid);
        }
        Byte consign = null;
        if (trackType.equals(Const.DIC_TRACK_TYPE_CASH)) {
            consign = Const.DIC_HOUSE_CONSIGN_CASH;
        } else if (trackType.equals(Const.DIC_TRACK_TYPE_ALONE)) {
            consign = Const.DIC_HOUSE_CONSIGN_ALONE;
        } else if (trackType.equals(Const.DIC_TRACK_TYPE_LIMITED)) {
            consign = Const.DIC_HOUSE_CONSIGN_LIMITED;
        } else if (trackType.equals(Const.DIC_TRACK_TYPE_RENT)) {
            consign = Const.DIC_HOUSE_CONSIGN_RENT;
        } else if (trackType.equals(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT)) {
            consign = Const.DIC_HOUSE_CONSIGN_GENERAL;
        } else {
            throw new ConfirmException("委托类型错误，请检查！");
        }
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale saleOld = caseInfoDto.getErpFunSale();
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setWeituoTime(new Date());
            erpFunSale.setEntrustCreateUser(createAuditUid);
            erpFunSale.setEntrustEndTime(erpFunTrack.getEntrustEndTime());
            erpFunSale.setSaleConsign(consign);
            erpFunSale.setSaleConsignNo(trackNo);
            erpFunSale.setProxyUrl(proxyUrl);
            erpFunSale.setUploadProxyUser(createAuditUid.toString());
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setSaleId(saleOld.getSaleId());
            erpFunSale.setUpdateTime(new Date());
            erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
            if (Const.DIC_HOUSE_CONSIGN_ALONE.equals(consign)) {
                erpSalePeopleRelativeService.insertSalePeopleRelative(cityId, caseId, createAuditUid,
                        Const.HOUSE_RELATIVE_PEOPLE_TYPE_5, "0");
            } else {
                erpSalePeopleRelativeService.insertSalePeopleRelative(cityId, caseId, createAuditUid,
                        Const.HOUSE_RELATIVE_PEOPLE_TYPE_5, "1");
            }
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease leaseOld = caseInfoDto.getErpFunLease();
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setLeaseId(leaseOld.getLeaseId());
            erpFunLease.setWeituoTime(new Date());
            erpFunLease.setEntrustCreateUser(createAuditUid);
            erpFunLease.setEntrustEndTime(erpFunTrack.getEntrustEndTime());
            erpFunLease.setLeaseConsign(consign.intValue());
            erpFunLease.setLeaseConsignNo(trackNo);
            erpFunLease.setProxyUrl(proxyUrl);
            erpFunLease.setUpdateTime(new Date());
            erpFunLease.setUploadProxyUser(createAuditUid.toString());
            erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
            if (Const.DIC_HOUSE_CONSIGN_ALONE.equals(consign)) {
                erpLeasePeopleRelativeService.insertLeasePeopleRelative(cityId, caseId, createAuditUid,
                        Const.HOUSE_RELATIVE_PEOPLE_TYPE_5, "0");
            } else {
                erpLeasePeopleRelativeService.insertLeasePeopleRelative(cityId, caseId, createAuditUid,
                        Const.HOUSE_RELATIVE_PEOPLE_TYPE_5, "1");
            }
        }
        if (erpFunTrack.getEntrustEndTime() != null) {
            AdminTrackCasestatusEndtask record = new AdminTrackCasestatusEndtask();
            record.setCityId(cityId);
            record.setCaseId(caseId);
            record.setCaseType(caseType.byteValue());
            record.setCompId(compId);
            record.setCreationTime(new Date());
            record.setTrackType(erpFunTrack.getTrackType());
            record.setResult(Byte.valueOf("0"));
            record.setTargetEndTime(erpFunTrack.getEntrustEndTime());
            record.setTrackId(erpFunTrack.getTrackId());
            adminTrackCasestatusEndtaskMapper.insertSelective(record);
        }
        //先写记录，然后写跟进
        if (StringUtils.isNotBlank(photoUrls)) {
            erpFunEntrustmentPhotoService.updateFunEntrustmentToInvalid(cityId, compId, caseType, caseId, null, null);
            erpFunEntrustmentPhotoService.addFunEntrustmentPhotos(cityId, compId, photoUrls, erpFunTrack.getCaseId(), erpFunTrack.getCaseType().intValue(), 0, trackId, createAuditUid);
        }
    }

    /**
     * 更新对象状态
     *
     * @param erpCreateTrackInfoParam
     * @param type
     * @return
     * @author 熊刚
     * @since 2017年10月18日
     */
    @Transactional
    @Override
    public Integer[] updateCaseStatus(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack) {
        String caseNo = param.getCaseNo();
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        Byte caseStatus = param.getStatus();
        Byte trackType = param.getTrackType();
        Integer caseType = param.getCaseType();
        Date targetTime = param.getTargetTime();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();
        ErpFunUsers createAuditUser = param.getCreateAuditUser();
        Integer createAuditUid = createAuditUser.getUserId();

        Integer[] currentArchiveId = erpFunSaleService.getCurrentArchiveId(cityId, caseId, caseType);
        String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
        Integer plateType = param.getCasePlateType();
        Integer oldStatus = param.getOldStatus();
        Boolean publish = param.getCasePublish();
        Byte isSaleLease = 0;
        Integer saleLeaseId = param.getSaleLeaseId();
        Map<String, Object> paramMap = new HashMap<>();
        // 修改状态时 将信息的级别变成普通--注意这些隐藏的业务逻辑
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            paramMap.put("saleId", caseId);
            paramMap.put("saleStatus", caseStatus);
            paramMap.put("saleLevel", Const.DIC_HOUSE_LEVEL_COMMON);
            ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
            isSaleLease = erpFunSale.getIsSaleLease();
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            paramMap.put("leaseId", caseId);
            paramMap.put("leaseStatus", caseStatus);
            paramMap.put("leaseLevel", Const.DIC_HOUSE_LEVEL_COMMON);
            ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
            isSaleLease = erpFunLease.getIsSaleLease();
        } else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
            paramMap.put("buyCustId", caseId);
            paramMap.put("buyCustStatus", caseStatus);
            paramMap.put("buyCustLevel", Const.DIC_HOUSE_LEVEL_COMMON);
        } else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
            paramMap.put("rentCustId", caseId);
            paramMap.put("rentCustStatus", caseStatus);
            paramMap.put("rentCustLevel", Const.DIC_HOUSE_LEVEL_COMMON);
        }
        if (oldStatus == null) {
            throw new ConfirmException("信息状态变更前的状态不能为空");
        }
        // 仅公房制 仅公客制 全公盘制 系统运行模式
        boolean isPublidModel = erpSysParaService.getSysRunModelIsPublic(caseType, cityId, compId);// 全公盘制
        // 删除房源转有效
        boolean writeoffToAvailable = (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType) // 转有效
                && Const.DIC_COMP_TYPE_1.equals(param.getCompType()) // link版
                && Const.DIC_HOUSE_STATUS_WRITEOFF.intValue() == oldStatus); // 删除状态
        boolean privateAndShareType = (!isPublidModel && Const.DIC_PLATE_TYPE_SHARE.equals(plateType));
        // 如果是私盘制下的公盘信息转为预订、封盘、成交、等涉及到改变状态的逻辑时则将其转为该申请人的私盘
        if (privateAndShareType || writeoffToAvailable) {
            paramMap.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
            // 跨店情况下的公盘数据转预定，需要把用户ID和门店ID一起修改
            Integer deptId = createAuditUser.getDeptId();
            paramMap.put("grId", createAuditUser.getGrId());
            paramMap.put("deptId", createAuditUser.getDeptId());
            paramMap.put("regId", createAuditUser.getRegId());
            paramMap.put("areaId", createAuditUser.getAreaId());
            paramMap.put("userId", createAuditUser.getUserId());
            paramMap.put("archiveId", createAuditUser.getArchiveId());
            paramMap.put("trackTime", nowTime);
            paramMap.put("actionTime", nowTime);
            ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKey(cityId, compId, caseId, caseType);
            if (erpFunKey != null) {
                erpFunKey.setDeptId(deptId);
                erpFunKey.setShardCityId(cityId);
                erpFunKeyMapper.updateByPrimaryKeySelective(erpFunKey);
            }
            ErpFunPhone erpFunPhone = new ErpFunPhone();
            erpFunPhone.setAreaId(createAuditUser.getAreaId());
            erpFunPhone.setRegId(createAuditUser.getRegId());
            erpFunPhone.setGrId(createAuditUser.getGrId());
            erpFunPhone.setDeptId(createAuditUser.getDeptId());
            erpFunPhone.setUserId(createAuditUser.getUserId());
            ErpFunPhoneExample phoneExample = new ErpFunPhoneExample();
            phoneExample.setShardCityId(cityId);
            phoneExample.createCriteria().andCompIdEqualTo(compId)
                    .andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
            erpFunPhoneMapper.updateByExampleSelective(erpFunPhone, phoneExample);
            HousePeopleRelativeParam housePeopleRelativeParam = null;
            // 删除数据转有效修改房源维护人
            if (writeoffToAvailable) {
                housePeopleRelativeParam = new HousePeopleRelativeParam();
                housePeopleRelativeParam.setCompId(compId);
                housePeopleRelativeParam.setSelfUserId(createAuditUser.getUserId());
                housePeopleRelativeParam.setCityId(cityId);
                housePeopleRelativeParam.setDelFlag(0);
                housePeopleRelativeParam.setCaseId(caseId);
                housePeopleRelativeParam.setCaseType(caseType);
                housePeopleRelativeParam.setPeopleType(2);
                housePeopleRelativeParam.setUserId(createAuditUser.getUserId());
                housePeopleRelativeParam.setDeptId(createAuditUser.getDeptId());
                housePeopleRelativeParam.setUserName(createAuditUser.getUserName());
            }
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
                if ("1".equals(isSaleLease.toString())) {
                    erpFunKey = erpFunKeyMapper.getErpFunKey(cityId, compId, saleLeaseId, Const.DIC_CASE_TYPE_LEASE_FUN);
                    if (erpFunKey != null) {
                        erpFunKey.setDeptId(deptId);
                        erpFunKey.setShardCityId(cityId);
                        erpFunKeyMapper.updateByPrimaryKeySelective(erpFunKey);
                    }
                    phoneExample = new ErpFunPhoneExample();
                    phoneExample.setShardCityId(cityId);
                    phoneExample.createCriteria().andCompIdEqualTo(compId)
                            .andCaseIdEqualTo(saleLeaseId).andCaseTypeEqualTo(Const.DIC_CASE_TYPE_LEASE_FUN);
                    erpFunPhoneMapper.updateByExampleSelective(erpFunPhone, phoneExample);
                }
                // 删除数据转有效改房源维护人
                if (writeoffToAvailable) {
                    // 先查询是否有房源维护人
                    ErpSalePeopleRelative erpSalePeopleRelative = erpSalePeopleRelativeMapper.getErpSalePeopleRelativeByCaseIdAndHouseType(cityId, caseId, 2);
                    if (null != erpSalePeopleRelative) {
                        housePeopleRelativeParam.setSaleRelativeId(erpSalePeopleRelative.getId());
                    }
                    erpSalePeopleRelativeService.updateHousePeopleRelative(housePeopleRelativeParam);
                }
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
                if ("1".equals(isSaleLease.toString())) {
                    erpFunKey = erpFunKeyMapper.getErpFunKey(cityId, compId, saleLeaseId, Const.DIC_CASE_TYPE_SALE_FUN);
                    if (erpFunKey != null) {
                        erpFunKey.setDeptId(deptId);
                        erpFunKey.setShardCityId(cityId);
                        erpFunKeyMapper.updateByPrimaryKeySelective(erpFunKey);
                    }
                    phoneExample = new ErpFunPhoneExample();
                    phoneExample.setShardCityId(cityId);
                    phoneExample.createCriteria().andCompIdEqualTo(compId)
                            .andCaseIdEqualTo(saleLeaseId).andCaseTypeEqualTo(Const.DIC_CASE_TYPE_SALE_FUN);
                    erpFunPhoneMapper.updateByExampleSelective(erpFunPhone, phoneExample);
                }
                // 删除数据转有效改房源维护人
                if (writeoffToAvailable) {
                    ErpLeasePeopleRelative erpLeasePeopleRelative = erpLeasePeopleRelativeMapper.getErpLeasePeopleRelativeByCaseIdAndHouseType(cityId, caseId, 2);
                    if (null != erpLeasePeopleRelative) {
                        housePeopleRelativeParam.setLeaseRelativeId(erpLeasePeopleRelative.getId());
                    }
                    erpLeasePeopleRelativeService.updateErpLeasePeopleRelative(housePeopleRelativeParam);
                }
            }
        }
        // 审核后转为抢盘的数据需要转到申请人名下--这种情况出现在，例如：暂缓后没审核之前，刚好被数据库作业变为抢盘了。
        if (Const.DIC_PLATE_TYPE_PUBLIC.equals(plateType)) {
            paramMap.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
            paramMap.put("grId", createAuditUser.getGrId());
            paramMap.put("deptId", createAuditUser.getDeptId());
            paramMap.put("regId", createAuditUser.getRegId());
            paramMap.put("areaId", createAuditUser.getAreaId());
            paramMap.put("userId", createAuditUser.getUserId());
            paramMap.put("archiveId", createAuditUser.getArchiveId());
            paramMap.put("trackTime", nowTime);
            paramMap.put("actionTime", nowTime);
        }
        // 写状态时间
        if (Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)) {// 变成封盘
            paramMap.put("specialTime", nowTime);
            paramMap.put("specialEndTime", targetTime);// 自定义的封盘保护到期时间
        } else if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)) {// 变成预定
            paramMap.put("scheduleTime", nowTime);
            paramMap.put("scheduleEndTime", targetTime);// 自定义的预订保护到期时间
        } else if (Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)) {// 变成暂缓
            paramMap.put("respiteEndTime", targetTime);// 自定义的暂缓保护到期时间
        } else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
                || Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
            paramMap.put("dealTime", nowTime);
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
                paramMap.put("isSaleLease", 0);
                paramMap.put("saleLevel", "1");
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
                paramMap.put("isSaleLease", 0);
                paramMap.put("leaseLevel", "1");
            }
            // 内外成交不取消真房源标记
        } else if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {// 变成注销
            paramMap.put("writeoffTime", nowTime);
            // 注销成交或下架微店时删除头条展示数据
            erpFunAdAuditMapper.deleteByCaseId(cityId, caseType, caseId);
        } else if (Const.DIC_HOUSE_STATUS_RESPITE.byteValue() == oldStatus
                || Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)) {// 变成暂缓后或者从暂缓变成其他状态时，需要更新数据重新计算抢盘时间和转抢盘的次数
            paramMap.put("trackTime", nowTime);
            paramMap.put("actionTime", nowTime);// 需要重新记录房勘的计算时间--策略参数控制
            paramMap.put("publicCount", 0);
            paramMap.put("fromPublic", 0);
        } else if (Const.DIC_TRACK_TYPE_STATUS_AVAILABLE.equals(trackType)) {// 状态转普通
            paramMap.put("trackTime", nowTime);
            paramMap.put("actionTime", nowTime);
            paramMap.put("availableTime", nowTime);
        } else if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)) {// 转有效类型设置跟进时间
            paramMap.put("trackTime", nowTime);
            paramMap.put("actionTime", nowTime);
            paramMap.put("availableTime", nowTime);
        }
        boolean writeTrackTime4House = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, cityId, compId, caseType, createAuditUid);
        if (writeTrackTime4House) {
            if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
                    || Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
                paramMap.put("updateTime", nowTime);
            } else {
                paramMap.put("trackTime", nowTime);
            }
        }
        // 如果有更新跟进时间，那就需要重新生成跳抢时间
        if (paramMap.get("trackTime") != null) {
            erpFunPolicyControlService.resetPrivateDay(cityId, caseId, caseType, true, false, compId, createAuditUid);
        }
        // 只要修改状态就更新标记
        paramMap.put("redFlag", 0);
        paramMap.put("orangeFlag", 0);
        // 注销、内成交、外成交、暂缓时去掉取消推广
        if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType) || Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
                || Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)
                || Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)) {
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
                paramMap.put("isSaleLease", 0);
                paramMap.put("salePublish", 0);
                paramMap.put("cityShareFlag", 0);
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
                paramMap.put("isSaleLease", 0);
                paramMap.put("leasePublish", 0);
                paramMap.put("cityShareFlag", 0);
            }
            // 已推广房源修改房源下架时间
            erpFunHouseBiddingMapper.updateBiddingEndTime(cityId, caseId, caseType, nowTime);
        }
        paramMap.put("updateTime", nowTime);
        // 修改房客源信息
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            erpFunSaleMapper.updateModelData(cityId, paramMap, caseId, null);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            erpFunLeaseMapper.updateModelData(cityId, paramMap, caseId, null);
        } else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
            erpFunBuyCustomerMapper.updateModelData(cityId, paramMap, caseId, null);
        } else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
            erpFunRentCustomerMapper.updateModelData(cityId, paramMap, caseId, null);
        }
        // 注销、内成交、外成交
        if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType) || Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
                || Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {

			/*if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				erpFunSaleService.cancelAds(cityId, compId, caseId, caseNo);
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				erpFunLeaseService.cancelAds(cityId, compId, caseId, caseNo);
			}*/
            this.downYYAndBidding(param, publish);
            this.downCooperatorData(cityId, caseId, caseType);
            // 处理成交注销后处理对应租售房源
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
                if (null != saleLeaseId && null != isSaleLease && 1 == isSaleLease) {
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setShardCityId(cityId);
                    funLease.setIsSaleLease(new Byte("0"));
                    funLease.setLeaseId(saleLeaseId);
                    funLease.setWriteoffTime(new Date());
                    if (null != param.getMakeSure() && 1 == param.getMakeSure().intValue()) {
                        funLease.setLeaseStatus((int) Const.HouseCustStatus.DIC_STATUS_WRITEOFF);
                    }
                    erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                }
                // 租房源
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
                if (null != saleLeaseId && null != isSaleLease && isSaleLease == 1) {
                    ErpFunSale funSale = new ErpFunSale();
                    funSale.setShardCityId(cityId);
                    funSale.setSaleId(saleLeaseId);
                    funSale.setIsSaleLease((byte) 0);
                    funSale.setWriteoffTime(new Date());
                    if (null != param.getMakeSure() && 1 == param.getMakeSure().intValue()) {
                        funSale.setSaleStatus(Const.HouseCustStatus.DIC_STATUS_WRITEOFF);
                    }
                    erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                }
            }
        }
        if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)) {
            // 售
            if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
                if (null != saleLeaseId && null != isSaleLease && 0 == isSaleLease) {
                    ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
                    erpFunLeaseExample.setShardCityId(cityId);
                    erpFunLeaseExample.createCriteria().andLeaseIdEqualTo(saleLeaseId).andLeaseStatusNotIn(Arrays.asList(new Integer[]{Const.DIC_HOUSE_STATUS_WRITEOFF.intValue(),
                            Const.DIC_HOUSE_STATUS_INNERDEAL.intValue(), Const.DIC_HOUSE_STATUS_DEAL.intValue()})).andSaleLeaseIdIsNotNull();
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setIsSaleLease(new Byte("1"));
                    int i = erpFunLeaseMapper.updateByExampleSelective(funLease, erpFunLeaseExample);
                    if (i > 0) {
                        ErpFunSale funSale = new ErpFunSale();
                        funSale.setShardCityId(cityId);
                        funSale.setSaleId(param.getCaseId());
                        funSale.setIsSaleLease((byte) 1);
                        erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                    }
                }
                // 租房源
            } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
                if (null != saleLeaseId && null != isSaleLease && isSaleLease == 0) {
                    ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
                    erpFunSaleExample.setShardCityId(cityId);
                    erpFunSaleExample.createCriteria().andSaleIdEqualTo(saleLeaseId).andSaleStatusNotIn(Arrays.asList(new Byte[]{Const.DIC_HOUSE_STATUS_WRITEOFF,
                            Const.DIC_HOUSE_STATUS_INNERDEAL, Const.DIC_HOUSE_STATUS_DEAL})).andSaleLeaseIdIsNotNull();
                    ErpFunSale funSale = new ErpFunSale();
                    funSale.setIsSaleLease((byte) 1);
                    int i = erpFunSaleMapper.updateByExampleSelective(funSale, erpFunSaleExample);
                    if (i > 0) {
                        ErpFunLease funLease = new ErpFunLease();
                        funLease.setShardCityId(cityId);
                        funLease.setIsSaleLease(new Byte("1"));
                        funLease.setLeaseId(param.getCaseId());
                        erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                    }
                }
            }
        }
        // 预订、封盘下架优优 并下架推广
        if (Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType) || Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)) {
            downYYAndBidding(param, publish);
        }
        // 内成交--->因为是从滴滴上转来的，大家的都是一套房源，有一套成交了，其他人拥有的就变为外成交
        if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType) || Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
            agencyVipErpRelationService.creatDiDiHouseDealTrack(cityId, caseId, caseType.byteValue());
        }
        return currentArchiveId;
    }

    /**
     * 封盘预定后清空房源查看核心信息的缓存
     *
     * @return
     * @author lcb
     * @date 2018/6/26
     */
    private void clearCaseViewLogCash(Integer cityId, Integer compId, Integer caseId, Byte caseType) {
        ErpFunViewLogExample example = new ErpFunViewLogExample();
        example.setShardCityId(cityId);
        String[] toDayTime = DateUtil.getToDayTime();
        example.createCriteria().andCompIdEqualTo(compId).andTargetIdEqualTo(caseId).andTargetTypeEqualTo(caseType).andViewCaseStatusIsNull().andViewTimeBetween(toDayTime[0], toDayTime[1]);
        List<ErpFunViewLog> viewLogList = erpFunViewLogMapper.selectByExample(example);

        // 清楚缓存
        for (ErpFunViewLog erpFunViewLog : viewLogList) {
            String key = Const.CacheStructure.BS_hfterpdb_funViewLogCache_By_USER_ID + erpFunViewLog.getViewUser() + "_TARGET_ID_" + caseId + "_TARGET_TYPE_" + caseType;
            cacheUtil.del(key);
        }
    }

    /**
     * @Title 下架合作数据
     * @Author lcb
     * @Date 2018/1/8
     * @Param
     **/
    private void downCooperatorData(Integer cityId, Integer caseId, Integer caseType) {
        ErpCityshareHouseExample erpCityshareHouseExample = new ErpCityshareHouseExample();
        erpCityshareHouseExample.setShardCityId(cityId);
        erpCityshareHouseExample.createCriteria().andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType.byteValue()).andHouseStateEqualTo((byte) 1);

        ErpCityshareHouse erpCityshareHouse = new ErpCityshareHouse();
        erpCityshareHouse.setHouseState((byte) 0);

        erpCityshareHouseMapper.updateByExampleSelective(erpCityshareHouse, erpCityshareHouseExample);
    }

    /**
     * 从优优上下架
     *
     * @param param
     * @param publish
     * @author 张宏利
     * @since 2017年11月4日
     */
    private void downYYAndBidding(ErpCreateTrackInfoParam param, Boolean publish) {
        // 之前没有发布到优优则返回
        if (!publish) {
            return;
        }
        ErpFunUsers createAuditUser = param.getCreateAuditUser();
        String caseNo = param.getCaseNo();
        Integer caseId = param.getCaseId();
        Integer caseType = param.getCaseType();
        Integer cityId = param.getCityId();
        Byte status = param.getStatus();

        // 熄灭图标
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setSalePublish(false);
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setSaleId(caseId);
            erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setLeasePublish(false);
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setLeaseId(caseId);
            erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
        }
        erpFunTrackService.writeFunTrackForPublish(param, false, null);
        // 判断是否进行可推广,如果推广就下架
        erpFunHouseBiddingService.downBiddingYY(cityId, caseId, caseType.intValue(), caseNo, status.intValue());
        ErpFunTrack erpFunTrack = new ErpFunTrack();
        String opStr = null;
        switch (status.intValue()) {
            case 2:
                opStr = "封盘";
                break;
            case 4:
                opStr = "预订";
                break;
            case 5:
                opStr = "内成交";
                break;
            case 6:
                opStr = "外成交";
                break;
            case 7:
                opStr = "注销";
                break;
            default:
                opStr = "";
                break;
        }
        String trackContent = param.getCreateCurrUserName() + " 将该房源状态改为 " + opStr + ",同时房源自动从优优好房下架。";
        erpFunTrack = new ErpFunTrack();
        erpFunTrack.setShardCityId(param.getCityId());
        erpFunTrack.setCaseId(caseId);
        erpFunTrack.setCaseNo(caseNo);
        erpFunTrack.setCaseType(caseType.byteValue());
        erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
        erpFunTrack.setTrackContent(trackContent);
        erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
        erpFunTrack.setCreatorUid(createAuditUser.getUserId());
        erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        erpFunTrack.setDeptId(createAuditUser.getDeptId());
        erpFunTrack.setCompId(createAuditUser.getCompId());
        erpFunTrack.setCaseUserId(param.getCaseUserId());
        erpFunTrack.setCaseDeptId(param.getCaseDeptId());
        erpFunTrack.setTrackWarm(false);
        erpFunTrack.setUseage((byte) 0);
        erpFunTrackMapper.updateByPrimaryKeySelective(erpFunTrack);
    }

    @Transactional
    @Override
    public void createDueWarmTask(ErpCreateTrackInfoParam param) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseDeptId = param.getCaseDeptId();
        String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
        Date targetTime = param.getTargetTime();
        if (targetTime == null) {
            return;
        }
        ErpFunTask erpFunTask = new ErpFunTask();
        erpFunTask.setCaseId(param.getCaseId());
        erpFunTask.setCaseNo(param.getCaseNo());
        erpFunTask.setCaseType(param.getCaseType().byteValue());
        erpFunTask.setTrackType(param.getTrackType());
        // 获取到期提醒时间
        String warmdayOfRentdue = erpSysParaService.getMLErpSysParamValByOrgId(cityId, compId, param.getCreateAuditUser().getOrganizationId(), "WARMDAY_OF_RENTDUE");
     /*   String warmdayOfRentdue = erpSysParaMapper.getParamValue(cityId, compId, "WARMDAY_OF_RENTDUE");*/
        Integer warmDayInt = StringUtil.parseInteger(warmdayOfRentdue, 1);
        Date targetWarmTime = DateTimeHelper.addDays(targetTime, -warmDayInt);
        // 提醒时间，到期前几天提醒
        String targetWarmTimeStr = DateTimeHelper.formatDatetoString(targetWarmTime);
        // 到期时间
        String targetWarmEnd = DateTimeHelper.formatDatetoString(targetTime);
        erpFunTask.setTaskSubject(Const.DIC_TASK_SUBJECT_HEAD_5 + " 该出租房源合同将于" + targetWarmEnd + "到期");
        erpFunTask.setTaskDesc("该信息的租赁合同将于" + targetWarmEnd + "到期");
        erpFunTask.setCompId(compId);
        erpFunTask.setDeptId(caseDeptId);
        erpFunTask.setTaskOwner(param.getCaseUserId());
        erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        erpFunTask.setTaskType(Const.DIC_TASK_TYPE_LEASE_REMIND);
        erpFunTask.setTrackWarm(true);
        erpFunTask.setIndexShow(1);
        erpFunTask.setWarmTime(targetWarmTimeStr);
        erpFunTask.setIsRead(false);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreatorUid(param.getCreateAuditUser().getUserId());
        erpFunTask.setCreationTime(nowTime);
        erpFunTask.setShardCityId(cityId);
        this.insertTask(cityId, erpFunTask, (byte) 0);
    }

    /**
     * 修改房源楼盘名
     *
     * @param buildiingInfo
     * @author 张宏利
     * @since 2017年10月25日
     */
    @Transactional
    @Override
    public void changeHouseBuild(Integer cityId, Integer caseId, Integer caseType, ErpBuildingInfoDto buildingInfo) {
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale record = new ErpFunSale();
            record.setSaleId(caseId);
            record.setShardCityId(cityId);
            record.setUpdateTime(new Date());
            record.setBuildId(buildingInfo.getBuildId());
            record.setBuildName(buildingInfo.getBuildName());
            record.setBuildCode(buildingInfo.getBuildCode());
            record.setSectionId(buildingInfo.getSectionId());
            record.setSectionName(buildingInfo.getSectionName());
            record.setSaleReg(buildingInfo.getBuildRegion());
            record.setRegionName(buildingInfo.getRegName());
            record.setSaleRound(buildingInfo.getBuildRound());
            record.setUpdateTime(new Date());
            erpFunSaleMapper.updateByPrimaryKeySelective(record);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease record = new ErpFunLease();
            record.setLeaseId(caseId);
            record.setShardCityId(cityId);
            record.setUpdateTime(new Date());
            record.setBuildId(buildingInfo.getBuildId());
            record.setBuildName(buildingInfo.getBuildName());
            record.setBuildCode(buildingInfo.getBuildCode());
            record.setSectionId(buildingInfo.getSectionId());
            record.setSectionName(buildingInfo.getSectionName());
            record.setLeaseReg(buildingInfo.getBuildRegion());
            record.setRegionName(buildingInfo.getRegName());
            record.setLeaseRound(buildingInfo.getBuildRound());
            record.setUpdateTime(new Date());
            erpFunLeaseMapper.updateByPrimaryKeySelective(record);
        }
        // 修改核心信息的楼盘ID
        ErpFunCoreInfo coreInfo = new ErpFunCoreInfo();
        coreInfo.setBuildId(buildingInfo.getBuildId());
        ErpFunCoreInfoExample example = new ErpFunCoreInfoExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
        erpFunCoreInfoMapper.updateByExampleSelective(coreInfo, example);
    }

    /**
     * 提交钥匙
     *
     * @param param
     * @author 张宏利
     * @since 2017年10月25日
     */
    @Transactional
    @Override
    public void createSubmitKey(ErpCreateTrackInfoParam param) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        Integer caseType = param.getCaseType();
        String caseNo = param.getCaseNo();
        Integer trackId = param.getTrackId();
        Byte trackType = param.getTrackType();
        String keyNum = param.getTargetNo();// 钥匙编号
        Integer keyDeptId = param.getKeyDeptId();// 钥匙所在门店
        boolean isPersonalVersion = param.getIsPersonalVersion();
        ErpFunUsers createAuditUser = param.getCreateAuditUser();
        Integer createAuditUid = createAuditUser.getUserId();
        Integer createAuditDeptId = createAuditUser.getDeptId();
        Integer archiveId = createAuditUser.getArchiveId();
        Integer saleLeaseId = param.getSaleLeaseId();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();
        Byte saleLeaseType = (byte) ((caseType == 1) ? 2 : 1);

        if (StringUtils.isBlank(keyNum)) {
            ErpFunDepts erpFunDept = null;
            if (!isPersonalVersion) {
                erpFunDept = erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
                keyNum = erpFunKeyService.getNewKeyNum(cityId, compId, keyDeptId, erpFunDept.getDeptNo(), null);
            } else {
                keyNum = erpFunKeyService.getNewKeyNum(cityId, compId, null, null, createAuditUid);
            }
        }

        if (!isPersonalVersion) {
            // 门店版判断钥匙是否已经存在
            erpFunKeyService.detectKeyNum(cityId, compId, keyDeptId, keyNum);
        } else {
            //精英版 判断钥匙是否已经存在
            erpFunKeyService.delectPersonlVersionKeyNum(cityId, compId, createAuditUid, keyNum);
        }
        // 判断是否已提交
        erpFunKeyService.detectHouseKey(cityId, compId, caseId, caseType.byteValue());
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
            // 判断是否为可租可售房源
            if (null != erpFunSale.getSaleLeaseId()) {
                ErpFunLease erpFunLease = new ErpFunLease();
                erpFunLease.setLeaseKey(true);
                erpFunLease.setKeyTime(new Date());
                erpFunLease.setLeaseKeyNum(keyNum);
                erpFunLease.setLeaseId(erpFunSale.getSaleLeaseId());
                erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, erpFunLease);
            }
            ErpFunSale updateModel = new ErpFunSale();
            updateModel.setSaleId(caseId);
            updateModel.setSaleKey(true);
            updateModel.setSaleKeyNum(keyNum);
            updateModel.setKeyTime(new Date());
            erpFunSaleMapper.updateFunSaleKeyNumById(cityId, updateModel);
            // 修改相关人
            erpSalePeopleRelativeService.insertSalePeopleRelative(cityId, caseId, createAuditUser.getUserId(),
                    Const.HOUSE_RELATIVE_PEOPLE_TYPE_3, null);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
            // 判断是否为可租可售房源
            if (null != erpFunLease.getSaleLeaseId()) {
                ErpFunSale erpFunSale = new ErpFunSale();
                erpFunSale.setSaleKey(true);
                erpFunSale.setSaleKeyNum(keyNum);
                erpFunSale.setKeyTime(new Date());
                erpFunSale.setSaleId(erpFunLease.getSaleLeaseId());
                erpFunSaleMapper.updateFunSaleKeyNumById(cityId, erpFunSale);
            }
            ErpFunLease updateModel = new ErpFunLease();
            updateModel.setLeaseId(caseId);
            updateModel.setLeaseKey(true);
            updateModel.setKeyTime(new Date());
            updateModel.setLeaseKeyNum(keyNum);
            erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, updateModel);
            // 修改相关人
            erpLeasePeopleRelativeService.insertLeasePeopleRelative(cityId, caseId, createAuditUser.getUserId(),
                    Const.HOUSE_RELATIVE_PEOPLE_TYPE_3, null);
        }
        // 写钥匙跟进
        ErpFunKey funKey = new ErpFunKey();
        funKey.setShardCityId(cityId);
        funKey.setCaseId(caseId);
        funKey.setCaseType(caseType.byteValue());
        funKey.setCaseNo(caseNo);
        funKey.setTrackId(trackId);
        funKey.setDeptId(createAuditDeptId);
        funKey.setUserId(createAuditUid);
        funKey.setKeyDeptId(keyDeptId);
        funKey.setKeyNum(keyNum);
        funKey.setKeyStatus(Const.DIC_KEY_STATUS_ARCHIVE.byteValue());
        funKey.setCompId(compId);
        funKey.setCreatorTime(DateTimeHelper.formatDateTimetoString(new Date()));
        erpFunKeyMapper.insertSelective(funKey);
        // (暂时不要这个)
//		ErpFunKeyOperationLog erpFunKeyOperationLog = new ErpFunKeyOperationLog();
//		erpFunKeyOperationLog.setShardCityId(cityId);
//		erpFunKeyOperationLog.setCompId(compId);
//		erpFunKeyOperationLog.setDeptId(keyDeptId);
//		erpFunKeyOperationLog.setKeyId(funKey.getKeyId());
//		erpFunKeyOperationLog.setConfirmUser(param.getSelfUserId());
//		erpFunKeyOperationLog.setOperationDesc(param.getTrackContent());
//		erpFunKeyOperationLog.setOperationUser(createAuditUid);
//		erpFunKeyOperationLog.setCreationTime(new Date());
//		erpFunKeyOperationLog.setKeyStatus((byte) 2);
//		erpFunKeyOperationLog.setKeyNum(keyNum);
//		erpFunKeyOperationLog.setCaseNo(caseNo);
//		erpFunKeyOperationLogMapper.insertSelective(erpFunKeyOperationLog);
        // 任务失效
        this.cancelAuditTaskForKey(cityId, compId, caseType.intValue(), caseId, trackType);
        if (saleLeaseId != null) {
            this.cancelAuditTaskForKey(cityId, compId, saleLeaseType.intValue(), saleLeaseId, trackType);
        }
    }

    /**
     * 借用钥匙
     *
     * @param param
     * @param trackContent
     * @author 张宏利
     * @since 2017年10月30日
     */
    @Transactional
    @Override
    public void createTrack4BorrowKey(ErpCreateTrackInfoParam param, String trackContent) {
        String caseNo = param.getCaseNo();
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        Integer keyId = param.getTargetId();
        Byte trackType = param.getTrackType();
        Integer selfUserId = param.getSelfUserId();
        ErpFunUsers createAuditUser = param.getCreateAuditUser();
        Integer createAuditUid = createAuditUser.getUserId();
        Integer createAuditDeptId = createAuditUser.getDeptId();
        ErpAuditRuntime auditRuntime = param.getAuditRuntime();

        Byte caseType = param.getCaseType().byteValue();
        Integer saleLeaseId = param.getSaleLeaseId();
        Byte saleLeaseType = (byte) ((caseType == 1) ? 2 : 1);

        String trackClassic = Const.DIC_TASK_TYPE_BUSINESS_TRACKING_STR;
        String timeNow = DateUtil.DateToString(new Date());
        ErpFunTask erpFunTask = new ErpFunTask();
        if (param.getTrackFromType() == 2) {
            trackClassic = Const.DIC_TASK_TYPE_AUTOMATIC_AUDIT_STR;
            erpFunTask.setTaskType(Const.DIC_TASK_TYPE_AUTOMATIC_AUDIT);
        } else if (param.getTrackFromType() == 3) {
            trackClassic = Const.DIC_TASK_TYPE_WORK_AUDIT_STR;
            erpFunTask.setTaskType(Const.DIC_TASK_TYPE_WORK_AUDIT);
        }
        ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKey(cityId, compId, caseId, caseType.intValue());
        if (Byte.valueOf("1").equals(erpFunKey.getKeyStatus())) {
            ErpFunKeyOperationLog funKeyOperationLogByKeyId = erpFunKeyOperationLogMapper.getFunKeyOperationLogByKeyId(cityId, erpFunKey.getKeyId());
            if (null != funKeyOperationLogByKeyId && null != funKeyOperationLogByKeyId.getOperationUser()) {
                ErpFunUsers erpFunUsers = erpFunUsersService.getUserInfoByUserId(param.getCityId(), funKeyOperationLogByKeyId.getOperationUser());
                String currUserName = erpFunUsersService.getCurrUserName(param.getCityId(), erpFunUsers.getUserId(), erpFunUsers.getDeptId());
                throw new ConfirmException("该钥匙已被" + currUserName + "借出");
            }
        }
        erpFunTask.setTaskSubject(trackClassic + " " + param.getTaskSubject());
        erpFunTask.setTaskDesc(trackContent);
        erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        erpFunTask.setWarmTime(timeNow);
        erpFunTask.setIsRead(false);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreatorUid(createAuditUid);
        erpFunTask.setCreationTime(timeNow);
        erpFunTask.setCaseId(caseId);
        erpFunTask.setCaseNo(caseNo);
        erpFunTask.setCaseType(caseType);
        erpFunTask.setCompId(compId);
        erpFunTask.setTaskOwner(selfUserId);
        erpFunTask.setDeptId(createAuditDeptId);
        erpFunTask.setShardCityId(cityId);
        this.insertTask(cityId, erpFunTask, (byte) 0);

        ErpFunKeyOperationLog erpFunKeyOperationLog = new ErpFunKeyOperationLog();
        erpFunKeyOperationLog.setShardCityId(cityId);
        erpFunKeyOperationLog.setCompId(compId);
        erpFunKeyOperationLog.setDeptId(erpFunKey.getDeptId());
        erpFunKeyOperationLog.setKeyId(erpFunKey.getKeyId());
        // 借用钥匙无需审核不写审核人
        if (null != auditRuntime && null != auditRuntime.getId()) {
            erpFunKeyOperationLog.setConfirmUser(selfUserId);
        }
        erpFunKeyOperationLog.setOperationDesc(param.getTrackContent());
        erpFunKeyOperationLog.setOperationUser(createAuditUid);
        erpFunKeyOperationLog.setCreationTime(new Date());
        erpFunKeyOperationLog.setKeyStatus((byte) 1);
        erpFunKeyOperationLog.setKeyNum(erpFunKey.getKeyNum());
        erpFunKeyOperationLog.setCaseNo(erpFunKey.getCaseNo());
        erpFunKeyOperationLogMapper.insertSelective(erpFunKeyOperationLog);
        // 改变钥匙状态
        erpFunKeyMapper.updateKeyStatusAndLogId(cityId, compId, keyId, null, Const.DIC_KEY_STATUS_LEND);
        // 任务失效
        this.cancelAuditTaskForKey(cityId, compId, caseType.intValue(), caseId, trackType);
        if (saleLeaseId != null) {
            this.cancelAuditTaskForKey(cityId, compId, saleLeaseType.intValue(), saleLeaseId, trackType);
        }
    }

    /**
     * 退还钥匙
     *
     * @param param
     * @author 张宏利
     * @since 2017年10月25日
     */
    @Transactional
    @Override
    public void createReturnKey(ErpCreateTrackInfoParam param, String trackContent) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        String caseNo = param.getCaseNo();
        Integer caseUserId = param.getCaseUserId();
        Integer createAuditUid = param.getCreateAuditUser().getUserId();
        Integer createDeptId = param.getSelfDeptId();
        Integer selfUserId = param.getSelfUserId();
        Byte trackType = param.getTrackType();

        Byte caseType = param.getCaseType().byteValue();
        Integer saleLeaseId = param.getSaleLeaseId();
        Byte saleLeaseType = (byte) ((caseType == 1) ? 2 : 1);

        String trackClassic = Const.DIC_TASK_TYPE_AUTOMATIC_AUDIT_STR;
        String timeNow = DateUtil.DateToString(new Date());
        // 审核通过
        if (param.getTrackFromType() == 3) {
            trackClassic = Const.DIC_TASK_TYPE_WORK_AUDIT_STR;
        }
        ErpFunTask erpFunTask = new ErpFunTask();
        erpFunTask.setTaskSubject(trackClassic + " " + param.getTaskSubject());
        erpFunTask.setTaskDesc(trackContent);
        erpFunTask.setTaskType(Const.DIC_TASK_TYPE_AUTOMATIC_AUDIT);
        erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        erpFunTask.setWarmTime(timeNow);
        erpFunTask.setIsRead(false);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreatorUid(createAuditUid);
        erpFunTask.setCreationTime(timeNow);
        erpFunTask.setCaseId(caseId);
        erpFunTask.setCaseNo(caseNo);
        erpFunTask.setCaseType(caseType);
        erpFunTask.setCompId(compId);
        erpFunTask.setTaskOwner(caseUserId);
        erpFunTask.setDeptId(createDeptId);
        erpFunTask.setShardCityId(cityId);
        this.insertTask(cityId, erpFunTask, (byte) 0);
        // 任务失效
        String taskSolute = "钥匙申请已被归还，此任务自动关闭！";
        erpFunTaskMapper.updateKeyTaskToClose(cityId, compId, caseId, caseType.intValue(), taskSolute);
        if (saleLeaseId != null) {
            erpFunTaskMapper.updateKeyTaskToClose(cityId, compId, saleLeaseId, saleLeaseType.intValue(), taskSolute);
        }
        List<ErpFunKey> keyList = erpFunKeyMapper.getListByCaseId(cityId, compId, caseId, caseType.intValue(), saleLeaseId, saleLeaseType);
        if (keyList == null || keyList.isEmpty()) {
            return;
        }
        ErpFunKey erpFunKey = keyList.get(0);
//		String returnDesc = "[ 同意钥匙归还 ] 归还说明：" + trackContent;
        String returnDesc = param.getTrackContent();
        // 归还钥匙单独写一条记录
        ErpFunKeyOperationLog erpFunKeyOperationLog = new ErpFunKeyOperationLog();
        erpFunKeyOperationLog.setShardCityId(cityId);
        erpFunKeyOperationLog.setCompId(compId);
        erpFunKeyOperationLog.setDeptId(createDeptId);
        erpFunKeyOperationLog.setKeyId(erpFunKey.getKeyId());
        erpFunKeyOperationLog.setConfirmUser(selfUserId);
        erpFunKeyOperationLog.setOperationDesc(returnDesc);
        erpFunKeyOperationLog.setOperationUser(createAuditUid);
        erpFunKeyOperationLog.setCreationTime(new Date());
        erpFunKeyOperationLog.setKeyStatus((byte) 2);
        erpFunKeyOperationLog.setKeyNum(erpFunKey.getKeyNum());
        erpFunKeyOperationLog.setCaseNo(erpFunKey.getCaseNo());
        erpFunKeyOperationLogMapper.insertSelective(erpFunKeyOperationLog);
        // 改变钥匙状态
        erpFunKeyMapper.updateKeyStatusAndLogId(cityId, compId, erpFunKey.getKeyId(), null, Const.DIC_KEY_STATUS_ARCHIVE);
        // 任务失效
        this.cancelAuditTaskForKey(cityId, compId, caseType.intValue(), caseId, trackType);
        if (saleLeaseId != null) {
            this.cancelAuditTaskForKey(cityId, compId, saleLeaseType.intValue(), saleLeaseId, trackType);
        }
    }

    /**
     * 注销钥匙
     *
     * @param param
     * @author 张宏利
     * @since 2017年10月25日
     */
    @Transactional
    @Override
    public void createTrack4DestroyKey(ErpCreateTrackInfoParam param) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer caseId = param.getCaseId();
        Integer caseType = param.getCaseType();
        Integer saleLeaseId = param.getSaleLeaseId();
        Byte trackType = param.getTrackType();
        CaseInfoDto caseInfoDto = param.getCaseInfoDto();
        ErpFunUsers createAuditUser = param.getCreateAuditUser();
        Byte saleLeaseType = (byte) ((caseType == 1) ? 2 : 1);

        erpFunKeyService.judgeDestroyHouseKey(cityId, compId, caseId, caseType.byteValue(), saleLeaseId);
        // 修改房源钥匙状态
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType.intValue())) {
            // 判断是否为可租可售房源
            ErpFunSale updateModel = caseInfoDto.getErpFunSale();
            if (null != updateModel.getSaleLeaseId()) {
                ErpFunLease erpFunLease = new ErpFunLease();
                erpFunLease.setLeaseKey(false);
                erpFunLease.setLeaseKeyNum(null);
                erpFunLease.setKeyTime(null);
                erpFunLease.setLeaseId(updateModel.getSaleLeaseId());
                erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, erpFunLease);
            }
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setSaleId(param.getCaseId());
            erpFunSale.setSaleKey(false);
            erpFunSale.setKeyTime(null);
            erpFunSale.setSaleKeyNum(null);
            erpFunSaleMapper.updateFunSaleKeyNumById(cityId, erpFunSale);
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType.intValue())) {
            // 判断是否为可租可售房源
            ErpFunLease updateModel = caseInfoDto.getErpFunLease();
            if (null != updateModel.getSaleLeaseId()) {
                ErpFunSale erpFunSale = new ErpFunSale();
                erpFunSale.setSaleKey(false);
                erpFunSale.setSaleKeyNum(null);
                erpFunSale.setKeyTime(null);
                erpFunSale.setSaleId(updateModel.getSaleLeaseId());
                erpFunSaleMapper.updateFunSaleKeyNumById(cityId, erpFunSale);
            }
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setLeaseId(param.getCaseId());
            erpFunLease.setLeaseKey(false);
            erpFunLease.setLeaseKeyNum(null);
            erpFunLease.setKeyTime(null);
            erpFunLease.setUpdateTime(new Date());
            erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, erpFunLease);
        }
        List<ErpFunKey> keyList = erpFunKeyMapper.getListByCaseId(cityId, compId, caseId, caseType, saleLeaseId, saleLeaseType);
        if (keyList == null || keyList.isEmpty()) {
            return;
        }
        Set<Integer> keySet = keyList.stream().collect(Collectors.mapping(ErpFunKey::getKeyId, Collectors.toSet()));
        Map<Integer, ErpFunKey> funKeyMap = keyList.stream().collect(Collectors.toMap(ErpFunKey::getKeyId, val -> val));
        Object[] keyArray = keySet.toArray();
        //
        for (Integer keyId : keySet) {
            ErpFunKey erpFunKey = funKeyMap.get(keyId);
            ErpFunKeyOperationLog erpFunKeyOperationLog = new ErpFunKeyOperationLog();
            erpFunKeyOperationLog.setShardCityId(cityId);
            erpFunKeyOperationLog.setCompId(compId);
            erpFunKeyOperationLog.setDeptId(erpFunKey.getDeptId());
            erpFunKeyOperationLog.setKeyId(keyId);
            erpFunKeyOperationLog.setConfirmUser(param.getSelfUserId());
            erpFunKeyOperationLog.setOperationDesc("注销钥匙");
            erpFunKeyOperationLog.setOperationUser(createAuditUser.getUserId());
            erpFunKeyOperationLog.setCreationTime(new Date());
            erpFunKeyOperationLog.setKeyStatus((byte) 3);
            erpFunKeyOperationLog.setKeyNum(erpFunKey.getKeyNum());
            erpFunKeyOperationLog.setCaseNo(erpFunKey.getCaseNo());
            erpFunKeyOperationLogMapper.insertSelective(erpFunKeyOperationLog);
        }
        erpFunKeyMapper.deleteFunKey(cityId, keyArray);
//		erpFunKeyOperationLogMapper.deleteFunKeyOperationLogByKeyIds(cityId, compId, keyArray);
//		erpFunKeyLogMapper.deleteFunKeyLogByKeyIds(cityId, compId, keyArray);
        // 任务失效
        this.cancelAuditTaskForKey(cityId, compId, caseType, caseId, trackType.byteValue());
        if (saleLeaseId != null) {
            this.cancelAuditTaskForKey(cityId, compId, saleLeaseType.intValue(), saleLeaseId, trackType.byteValue());
        }
    }

    /**
     * 创建提醒
     */
    @Transactional
    @Override
    public void createWarmTask(ErpCreateTrackInfoParam param, Byte renovationParam, Byte syncApp) {
        String userIds = param.getWarmedUsers();
        // 如果没有内容||没有提醒人则不管了，直接返回
        // 纯精英版提醒自己
        if (param.getIsPersonalVersion()) {
            userIds = param.getSelfUserId().toString();
        }
        if (StringUtils.isEmpty(param.getWarmContent()) || StringUtils.isBlank(userIds)) {
            return;
        }
        boolean isOlnyWarm = StringUtil.isNotBlank(param.getWarmContent());

        ErpFunTask erpFunTask = new ErpFunTask();
        String taskSubject = "";
        // 装修客户专用
        if (Const.DIC_TASK_TYPE_RENOVATION_REMIND.equals(renovationParam)) {
            taskSubject = Const.DIC_TASK_TYPE_RENOVATION_REMIND_STR;
            erpFunTask.setTaskType(Const.DIC_TASK_TYPE_RENOVATION_REMIND);
        } else {
            if (isOlnyWarm) {
                taskSubject = Const.DIC_TASK_TYPE_REMIND_TASK_STR;
                erpFunTask.setTaskType(Const.DIC_TASK_TYPE_REMIND_TASK);
            } else {
                taskSubject = Const.DIC_TASK_TYPE_TRACK_REMIND_STR;
                erpFunTask.setTaskType(Const.DIC_TASK_TYPE_TRACK_REMIND);
            }
        }
        taskSubject += " " + param.getCreateCurrUserName() + "创建了一条提醒任务。";
        // 是否是立即发送
        boolean isImmediate = (param.getIsImmediate() != null && param.getIsImmediate() == 1);
        if (isImmediate) {
            param.setWarmTime(new Date());
        }
        ErpFunUsers createUsers = param.getCreateAuditUser();
        erpFunTask.setCaseNo(param.getCaseNo());
        erpFunTask.setCaseId(param.getCaseId());
        erpFunTask.setCaseType(param.getCaseType().byteValue());
        erpFunTask.setTaskSubject(taskSubject);
        erpFunTask.setTaskDesc(param.getWarmContent());
        erpFunTask.setCompId(param.getCompId());
        erpFunTask.setDeptId(createUsers.getDeptId());
        erpFunTask.setCreatorUid(createUsers.getUserId());
        erpFunTask.setTypeFlag((byte) 1);
        erpFunTask.setTrackWarm(true);
        erpFunTask.setIndexShow(1);
        erpFunTask.setWarmTime(DateTimeHelper.formatDateTimetoString(param.getWarmTime()));
        erpFunTask.setIsRead(false);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        erpFunTask.setShardCityId(param.getCityId());
        erpFunTask.setTrackId(param.getTrackId());
        erpFunTask.setTrackType(param.getTrackType());
        // 写提醒人逻辑
        String[] userIdArr = userIds.split(",");
        Set<Integer> userIdSet = new HashSet<>();
        for (String userId : userIdArr) {
            userIdSet.add(Integer.valueOf(userId));
        }
        this.insertTask(param.getCityId(), erpFunTask, userIdSet, syncApp,0);
    }

    /**
     * 统一的插入FUN_TASK的方法，不能直接插入
     * 最主要的是生成提醒人的方式改了，统一处理，插入的地方多了不好统一
     *
     * @param cityId
     * @param erpFunTask
     * @author 张宏利
     * @since 2017年12月23日
     */
    @Transactional
    @Override
    public void insertTask(Integer cityId, ErpFunTask erpFunTask, Set<Integer> userIdSet, Byte syncApp,Integer sendIm) {
        if (userIdSet == null || userIdSet.isEmpty()) {
            return;
        }
        List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
        if (userList == null || userList.isEmpty()) {
            return;
        }
        if (erpFunTask.getShardCityId() == null) {
            erpFunTask.setShardCityId(cityId);
        }
        // 标题不用太长，数据库字段是600
        if (erpFunTask.getTaskSubject() != null && erpFunTask.getTaskSubject().length() >= 300) {
            erpFunTask.setTaskSubject(erpFunTask.getTaskSubject().substring(0, 290));
        }
        String userNames = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserName, Collectors.joining(",")));
        erpFunTask.setTaskOwner(null);
        if (userNames.length() > 500) {
            userNames = userNames.substring(0, 500) + "...";
        }
        erpFunTask.setWarmUsers(userNames);
        erpFunTaskMapper.insertSelective(erpFunTask);

        Date warmTime = DateTimeHelper.parseToDate(erpFunTask.getWarmTime());
        // 提醒时间在当前时间之前则为立即发送
        boolean isImmediate = DateTimeHelper.compareTwoDate(new Date(), warmTime) < 0;

        List<ErpFunTaskTimed> taskTimedList = new ArrayList<ErpFunTaskTimed>();
        List<AdminFunUserMessage> userMessageList = new ArrayList<AdminFunUserMessage>();
        userList.forEach(user -> {
            AdminFunUserMessage userMessage = new AdminFunUserMessage();
            userMessage.setMsgModule(10);
            userMessage.setModuleType(26);
            userMessage.setCityId(cityId);
            userMessage.setTargetId(erpFunTask.getTaskId());
            userMessage.setAppType(sendIm);
            userMessage.setArchiveId(user.getArchiveId());
            userMessage.setCompId(user.getCompId());
            userMessage.setCaseId(erpFunTask.getCaseId());
            userMessage.setCaseType(erpFunTask.getCaseType().intValue());
            userMessageList.add(userMessage);
            ErpFunTaskTimed erpFunTaskTimed = new ErpFunTaskTimed();
            erpFunTaskTimed.setCompId(erpFunTask.getCompId());
            erpFunTaskTimed.setArchiveId(user.getArchiveId());
            erpFunTaskTimed.setUserId(user.getUserId());
            erpFunTaskTimed.setAreaId(user.getAreaId());
            erpFunTaskTimed.setRegId(user.getRegId());
            erpFunTaskTimed.setDeptId(user.getDeptId());
            erpFunTaskTimed.setGrId(user.getGrId());
            erpFunTaskTimed.setTaskId(erpFunTask.getTaskId());
            erpFunTaskTimed.setTaskOwner(user.getUserId());
            erpFunTaskTimed.setTaskTime(warmTime);
            erpFunTaskTimed.setTaskCreate(erpFunTask.getCreatorUid());
            erpFunTaskTimed.setReadFlag((byte) 0);
            taskTimedList.add(erpFunTaskTimed);
        });
        // 立即发送
        if (isImmediate) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    TaskQueueThread.sendMessageList(userMessageList);
                }
            });

            if (1 == syncApp.intValue()) {
                userMessageList.stream().forEach(adminFunUserMessage -> {
                    // 同步推送掌通
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("templateId", "2");
                    jsonObject.put("receiver", adminFunUserMessage.getArchiveId());
                    jsonObject.put("content", erpFunTask.getTaskSubject());
                    KafkaBizUtils.pushMsgByTemplate(jsonObject);
                });
            }
        } else {
            // 生成需要扫描表的数据，到点提醒
            AdminFunUserTaskRemind record = new AdminFunUserTaskRemind();
            record.setCityId(cityId);
            record.setRemindTime(warmTime);
            record.setTaskId(erpFunTask.getTaskId());
            record.setTaskType(Const.DIC_TASK_TYPE_REMIND_TASK.intValue());
            record.setCreationTime(new Date());
            record.setSyncApp(syncApp);
            adminFunUserTaskRemindMapper.insertSelective(record);
        }
        // 生成提醒关联人员
        erpFunTaskTimedMapper.insertList(cityId, taskTimedList);
    }

    /**
     * 统一的插入FUN_TASK的方法，不能直接插入
     * 最主要的是生成提醒人的方式改了，统一处理，插入的地方多了不好统一
     *
     * @param cityId
     * @param erpFunTask
     * @author 张宏利
     * @since 2017年12月23日
     */
    @Transactional
    @Override
    public void insertTask(Integer cityId, ErpFunTask erpFunTask, Byte syncApp) {
        Set<Integer> userIdSet = new HashSet<>();
        userIdSet.add(erpFunTask.getTaskOwner());
        this.insertTask(cityId, erpFunTask, userIdSet, syncApp,0);
    }

    @Transactional
    @Override
    public void createViewLogTaskWarning(Integer cityId, Integer compId, Integer caseType, Integer casePlateType,
                                         String userName, Integer caseId, String caseNo, Integer caseDeptId, Integer selfDeptId, Integer selfUserId) {
        String plateTypeCN = casePlateType.equals(Const.DIC_PLATE_TYPE_SHARE) ? "公盘" : "私盘";
        String deptStr = caseDeptId.equals(selfDeptId) ? "本店" : "其他店";
        String caseTypeCN = "";
        // 事例内容:userName查看本店/其他店公盘OR私盘出售OR出租OR求购OR求租的核心信息已经达到系统参数设置的上限.
        if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
            caseTypeCN = "求租";
        } else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
            caseTypeCN = "求购";
        } else if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            caseTypeCN = "出售";
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            caseTypeCN = "出租";
        }
        String desc = userName + "一天内查看" + deptStr + plateTypeCN + caseTypeCN + "的核心信息条数已经达到系统参数设置的上限.";
        desc = Const.DIC_TASK_TYPE_CORE_INFORMATION_STR + " " + desc;
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCompId(compId);
        insertModel.setWarmTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setCaseId(caseId);
        insertModel.setCaseNo(caseNo);
        insertModel.setCaseType(caseType.byteValue());
        insertModel.setTrackWarm(false);
        insertModel.setTaskSubject(desc);
        insertModel.setTaskDesc(desc);
        insertModel.setTaskType(Const.DIC_TASK_TYPE_CORE_INFORMATION);
        insertModel.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(selfUserId);
        insertModel.setDeptId(selfDeptId);
        // 获取总经理和本门店店长
        List<ErpFunUsers> branchManagerList = erpFunUsersMapper.getDeptBranchManager(cityId, compId, null, null, selfDeptId, "BRANCH_MANAGER");
        ErpFunUsers generalManager = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
        //ErpFunUsers generalManager = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
        branchManagerList.add(generalManager);
        Set<Integer> userIdSet = branchManagerList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
        userIdSet.remove(selfUserId);
        this.insertTask(cityId, insertModel, userIdSet, (byte) 0,0);
    }

    @Override
    @AccessReadonlyDb
    public PageInfo<ErpFunTaskDto> getWarmTaskList(Integer cityId, BaseMapParam param) {
        String userId = param.getString("userId");
        String grId = param.getString("grId");
        String deptId = param.getString("deptId");
        String regId = param.getString("regId");
        String areaId = param.getString("areaId");
        boolean needUseFunUser = StringUtil.isHaveNotBlank(userId, grId, deptId, regId, areaId, param.getString("organizationId"));
        param.setInteger("needUseFunUser", needUseFunUser ? 1 : 0);

        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<ErpFunTaskDto> erpFunTaskDtos = erpFunTaskMapper.getWarmTaskList(cityId, param.getMap());
        PageInfo<ErpFunTaskDto> pageInfo = new PageInfo<ErpFunTaskDto>(erpFunTaskDtos);
        return pageInfo;
    }

    /**
     * @author 邓永洪
     * @tag 创建提醒任务, 数据移交用
     * @since 2018/4/24
     */
    @Transactional
    @Override
    public void createTaskForTransData(Integer cityId, List<Integer> caseIds, ErpFunUsers acceptUser, String[] caseNos, Integer caseType, int dataCount, DataTranslateParam param) {
        String srcUserId = param.getSrcUserId();
        Integer currentUserId = param.getCurrentUserId();
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCaseId(Integer.valueOf(caseIds.get(0)));
        insertModel.setCaseNo(caseNos[0]);
        insertModel.setCaseType(caseType.byteValue());
        insertModel.setTaskSubject(buildTaskSubjectForTransData(cityId, acceptUser, param.getSrcUserId(), param.getSrcDeptId(), caseType, param.getCurrentUserNamme()));
        insertModel.setTaskDesc("信息条数：" + dataCount);
        insertModel.setCompId(acceptUser.getCompId());
        insertModel.setDeptId(acceptUser.getDeptId());
        insertModel.setTaskOwner(acceptUser.getUserId());
        insertModel.setTaskType(Const.DIC_TASK_TYPE_DATA_TURN);
        insertModel.setTypeFlag((byte) 0);
        insertModel.setWarmTime(DateTimeHelper.getTimeNow());
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(currentUserId);
        insertModel.setCreationTime(DateTimeHelper.getTimeNow());
        insertModel.setTag(buildTagForTransData());
        erpFunTaskMapper.insertModel(cityId, insertModel);
        if (StringUtils.isNotBlank(srcUserId) && !"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId) && !currentUserId.toString().equals(srcUserId)) {
            ErpFunUsers userPO = erpFunUsersMapper.getUserInfoByUserId(cityId, Integer.valueOf(srcUserId));
            ErpFunTask yjFunTaskPo = new ErpFunTask();
            yjFunTaskPo.setCaseId(Integer.valueOf(caseIds.get(0)));
            yjFunTaskPo.setCaseNo(caseNos[0]);
            yjFunTaskPo.setCaseType(caseType.byteValue());
            yjFunTaskPo.setTaskSubject(buildTaskSubjectForTransData(cityId, acceptUser, srcUserId, param.getSrcDeptId(), caseType, param.getCurrentUserNamme()));
            yjFunTaskPo.setTaskDesc("信息条数：" + dataCount);
            yjFunTaskPo.setCompId(acceptUser.getCompId());
            yjFunTaskPo.setDeptId(acceptUser.getDeptId());
            yjFunTaskPo.setTaskOwner(acceptUser.getUserId());
            yjFunTaskPo.setTaskType(Const.DIC_TASK_TYPE_DATA_TURN);
            yjFunTaskPo.setTypeFlag((byte) 0);
            yjFunTaskPo.setWarmTime(DateTimeHelper.getTimeNow());
            yjFunTaskPo.setIsRead(false);
            yjFunTaskPo.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
            yjFunTaskPo.setCreatorUid(currentUserId);
            yjFunTaskPo.setCreationTime(DateTimeHelper.getTimeNow());
            yjFunTaskPo.setTag(buildTagForTransData());
            erpFunTaskMapper.insertModel(cityId, yjFunTaskPo);
        }
    }

    private String buildTaskSubjectForTransData(Integer cityId, ErpFunUsers acceptUser, String srcUserId, Integer srcDeptId, Integer caseType, String currentUserName) {
        String sourceUserDeptName = "";
        String sourceUserName = "未知用户";
        ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, srcDeptId);
        if (srcUserId.equalsIgnoreCase("public")) {
            sourceUserName = "抢盘";
        } else if (srcUserId.equalsIgnoreCase("share")) {
            sourceUserName = "公盘";
        } else if (StringUtils.isNotBlank(srcUserId)) {
            ErpFunUsers srcUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, Integer.valueOf(srcUserId));// 移交数据的来源
            if (srcUsers != null) {
                sourceUserName = srcUsers.getUserName() + "的";
            }
        }
        sourceUserDeptName = funDepts.getDeptName() + " ";
        String caseTypeStr = "";

        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            caseTypeStr = "出售房源";
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            caseTypeStr = "出租房源";
        } else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
            caseTypeStr = "求购客户";
        } else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
            caseTypeStr = "求租客户";
        }
        String result = Const.DIC_TASK_TYPE_DATA_TURN_STR;
        result += " " + currentUserName + "将" + sourceUserDeptName + sourceUserName + "的" + caseTypeStr
                + "信息向您做了移交，请点击查看详细";
        return result;
    }

    private String buildTagForTransData() {
        return null;
    }


    /**
     * @author 邓永洪
     * @tag 跳公盘、抢盘、注销、数据移交 -->（注销、内成交、外成交、封盘、预定、暂缓、电话查看）状态的审核任务都要变为失效
     * @since 2018/4/25
     */
    @Transactional
    @Override
    public void updateTaskForWriteoffAndStatusChange(Integer cityId, Integer compId, Integer caseType, Integer[] caseIds, Byte status) {
        List<Integer> list = new ArrayList<>();
        list.add(Const.DIC_HOUSE_STATUS_WRITEOFF.intValue());// 注销
        list.add(Const.DIC_HOUSE_STATUS_SPECIAL.intValue());// 封盘
        list.add(Const.DIC_HOUSE_STATUS_RESPITE.intValue());// 暂缓
        list.add(Const.DIC_HOUSE_STATUS_SCHEDULE.intValue());// 预订
        list.add(Const.DIC_HOUSE_STATUS_INNERDEAL.intValue());// 内成交
        list.add(Const.DIC_HOUSE_STATUS_DEAL.intValue());// 外成交
        String caseTypeStr = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)
                || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) ? "房源" : "客源";
        String content = "该" + caseTypeStr + "于任务审核期间被" + getCNMsgByStatus(status);
        Map<String, Object> param = new HashMap<>();
        param.put("compId", compId);
        param.put("caseType", caseType);
        param.put("caseIds", caseIds);
        param.put("caseStatus", list);
        //通过条件把跟进查处来，然后将审核任务中这批数据的状态更新为失效
        // 把所有内成交 外成交 电话的跟进ID查出来
        List<ErpFunTrack> funTrackList = erpFunTrackMapper.getErpFunTrackByMap(cityId, param);
        // 更新所有的状态为失效
        String[] ids = BeanUtil.buildQueryKeys(funTrackList, "trackId");
        if (ids == null || ids.length <= 0) {
            return;
        }
        String[][] idArr = CommonUtil.getCutArr(ids, 0);
        for (int i = 0; i < idArr.length; i++) {
            ErpFunTask taskUpdateModel = new ErpFunTask();
            taskUpdateModel.setTaskStatus(Const.DIC_TASK_STATUS_CANCEL);
            taskUpdateModel.setTaskSolute(content);
            ErpFunTaskExample funTaskExample = new ErpFunTaskExample();
            funTaskExample.setShardCityId(cityId);
            funTaskExample.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(Arrays.asList(caseIds)).
                    andTypeFlagEqualTo(Const.DIC_TASK_TYPE_FLAG_1)
                    .andTaskStatusEqualTo(Const.DIC_TASK_STATUS_NEW)
                    .andTaskTypeIn(Arrays.asList((new Byte[]{Const.DIC_TASK_TYPE_EXAMIN, Const.DIC_TASK_TYPE_VIEWEXAMIN})));
            erpFunTaskMapper.updateByExampleSelective(taskUpdateModel, funTaskExample);
            ErpFunTrack trackUpdateModel = new ErpFunTrack();
            trackUpdateModel.setTargetFlag(false);
            ErpFunTrackExample funTrackExample = new ErpFunTrackExample();
            funTrackExample.setShardCityId(cityId);
            funTrackExample.setShardCityId(cityId);
            funTrackExample.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(Arrays.asList(StringUtil.stringToInt(idArr[i])));
            erpFunTrackMapper.updateByExampleSelective(trackUpdateModel, funTrackExample);
        }
        //将审核任务中查看核心信息的状态更新为失效
        ErpFunTask UpdateModel = new ErpFunTask();
        UpdateModel.setTaskStatus(Const.DIC_TASK_STATUS_CANCEL);
        UpdateModel.setTaskSolute(content);
        ErpFunTaskExample funTaskExample = new ErpFunTaskExample();
        funTaskExample.setShardCityId(cityId);
        ErpFunTaskExample.Criteria criteria = funTaskExample.createCriteria().andTypeFlagEqualTo(Byte.valueOf(Const.DIC_TASK_TYPE_FLAG_1))
                .andTaskStatusEqualTo(Const.DIC_TASK_STATUS_NEW).andTaskTypeIn(Arrays.asList((new Byte[]{Const.DIC_TASK_TYPE_VIEWEXAMIN})))
                .andCaseTypeEqualTo(caseType.byteValue());
        if (caseIds != null && caseIds.length > 0) {
            criteria.andCaseIdIn(Arrays.asList(caseIds));
            erpFunTaskMapper.updateByExampleSelective(UpdateModel, funTaskExample);
        }
    }

    /**
     * @author 邓永洪
     * @tag 更新提醒任务信息, 数据移交用
     * @since 2018/4/25
     */
    @Transactional
    @Override
    public void updateTaskForTransData(ErpFunUsers acceptUser, Integer caseType, DataTranslateParam param, List<Integer> caseIdsList) {
        if (acceptUser == null) {
            return;
        }
        if (caseIdsList != null && caseIdsList.size() > 0) {// caseIds可能为空,此时更新该用户指定类型的所有数据
            ErpFunTaskExample erpFunTaskExample = new ErpFunTaskExample();
            erpFunTaskExample.setShardCityId(param.getCityId());
            erpFunTaskExample.createCriteria().andCompIdEqualTo(param.getCompId())
                    .andTaskOwnerEqualTo(StringUtil.paseInteger(param.getSrcUserId()))
                    .andCaseTypeEqualTo(caseType.byteValue()).andCaseIdIn(caseIdsList)
                    .andTaskTypeEqualTo(Const.DIC_TASK_TYPE_REMIND);
            ErpFunTask record = new ErpFunTask();
            record.setTaskOwner(acceptUser.getUserId());
            record.setDeptId(acceptUser.getDeptId());
            erpFunTaskMapper.updateByExampleSelective(record, erpFunTaskExample);
        } else {
            ErpFunTaskExample erpFunTaskExample = new ErpFunTaskExample();
            erpFunTaskExample.setShardCityId(param.getCityId());
            erpFunTaskExample.createCriteria().andCompIdEqualTo(param.getCompId())
                    .andTaskOwnerEqualTo(StringUtil.paseInteger(param.getSrcUserId()))
                    .andCaseTypeEqualTo(caseType.byteValue()).andTaskTypeEqualTo(Const.DIC_TASK_TYPE_REMIND);
            ErpFunTask record = new ErpFunTask();
            record.setTaskOwner(acceptUser.getUserId());
            record.setDeptId(acceptUser.getDeptId());
            erpFunTaskMapper.updateByExampleSelective(record, erpFunTaskExample);
        }
    }

    /**
     * @tag 写一条租期到期提醒, 内成交的发起方, 为租房合同时
     * @author 邓永洪
     * @since 2018/5/30
     */
    @Override
    public void rentOverWarmTask(ErpFunTrack trackModel, Integer caseUserId, Integer caseDeptId, InsertDealInfoParam param) {
        Integer orgId = 0;
        ErpFunUsers selfUser = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getSelfUserId());
        if (Objects.nonNull(selfUser)) {
            orgId = selfUser.getOrganizationId();
        }
        String warmdayOfRentdue = erpSysParaService.getMLErpSysParamValByOrgId(param.getCityId(), trackModel.getCompId(), orgId, "WARMDAY_OF_RENTDUE");
    	int warmDays = StringUtil.paseInteger(warmdayOfRentdue);
        ErpFunTask funTask = new ErpFunTask();
        String dueTime = param.getRentOverTime();
        if (dueTime == null) {
            dueTime = param.getDueTime();
        }
        // 手动录入业绩现在没有租期截止时间，直接不写到期提醒
        if (StringUtils.isBlank(dueTime)) {
            return;
        }
        String warmTime = DateTimeHelper.formatDateTimetoString(
                DateTimeHelper.addDays(DateTimeHelper.parseToDate(dueTime), -warmDays), "yyyy-MM-dd");
        funTask.setCaseId(trackModel.getCaseId());
        funTask.setCaseNo(trackModel.getCaseNo());
        funTask.setCaseType(trackModel.getCaseType());
        funTask.setTrackId(trackModel.getTrackId());
        funTask.setTrackType(Const.DIC_TRACK_TYPE_STATUS);
        funTask.setTaskSubject(Const.DIC_TASK_TYPE_LEASE_REMIND_STR + " 该出租房源合同将于"
                + DateTimeHelper.formatDateTimetoString(dueTime, "yyyy-MM-dd") + "到期");
        funTask.setTaskDesc("该出租房源合同将于" + DateTimeHelper.formatDateTimetoString(dueTime, "yyyy-MM-dd") + "到期");
        if (caseUserId == null) {// 如果是公盘数据的话就提醒 写成交的用户
            caseUserId = param.getSelfUserId();
            caseDeptId = param.getSelfDeptId();
        }
        funTask.setTaskOwner(caseUserId);
        funTask.setDeptId(caseDeptId);
        funTask.setCompId(trackModel.getCompId());
        funTask.setTaskType(Const.DIC_TASK_TYPE_LEASE_REMIND);
        funTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        funTask.setTrackWarm(true);
        funTask.setIndexShow(1);
        funTask.setWarmTime(warmTime);
        funTask.setIsRead(false);
        funTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        funTask.setCreatorUid(param.getSelfUserId());
        funTask.setCreationTime(DateTimeHelper.getTimeNow());
        erpFunTaskMapper.insertSelective(funTask);
        //TODO   同时写入到operator中,为创建合同提供必要字段
    }

    /**
     * @tag 合同相关提醒任务
     * @author 邓永洪
     * @since 2018/6/6
     */
    @Override
    @Transactional
    public void createDealWarmTask(Byte caseType, Integer caseId, String contractNo, List<ErpFunUsers> taskUserList, String taskSubJect, Byte taskType, String taskDesc, Integer userId, Integer cityId, Integer deptId, Integer compId) {
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCaseId(caseId);
        insertModel.setCaseType(caseType);

        insertModel.setCompId(compId);
        insertModel.setWarmTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setTrackWarm(false);
        insertModel.setTaskSubject(taskSubJect);
        insertModel.setTaskDesc(taskDesc);
        insertModel.setTaskType(taskType);
        insertModel.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(userId);
        insertModel.setDeptId(deptId);
        insertModel.setShardCityId(cityId);
        insertModel.setCaseNo(contractNo);
        Set<Integer> set = new HashSet<>();
        if (taskUserList != null) {
            set = taskUserList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toSet());
        }
        insertTask(cityId, insertModel, set, (byte) 0,0);
    }

    @Transactional
    @Override
    public List<AdminFunUserMessage> createDealTask(Byte caseType, Integer caseId, String contractNo, List<ErpFunUsers> taskUserList, String taskSubJect, Byte taskType,
                                                    String taskDesc, Integer userId, Integer cityId, Integer deptId, Integer compId, Integer creatorUid) {
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCaseId(caseId);
        insertModel.setCaseType(caseType);

        insertModel.setCompId(compId);
        insertModel.setWarmTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setTrackWarm(false);
        insertModel.setTaskSubject(taskSubJect);
        insertModel.setTaskDesc(taskDesc);
        insertModel.setTaskType(taskType);
        insertModel.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(userId);
        insertModel.setDeptId(deptId);
        insertModel.setShardCityId(cityId);
        insertModel.setCaseNo(contractNo);
        Set<Integer> set = new HashSet<>();
        if (taskUserList != null) {
            set = taskUserList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toSet());
        }
        insertTask(cityId, insertModel, set, (byte) 0,0);
//		erpFunTaskMapper.insertModel(cityId, insertModel);

        return null;
    }

    @Transactional
    @Override
    public void writeTaskForRuntimeStep(GeneralParam generalParam, ErpProcessRuntimeStep model, String nextStepName, List<Integer> taskUserIdList, String runstepName, String addStepName, String nextLimitTime) {
        Integer cityId = generalParam.getCityId();
        ErpFunDeal deal = erpFunDealMapper.getBaseDealInfo(cityId, model.getDealId());
        Byte dealType = deal.getDealType();
        String contractNo = deal.getContractNo();

        String buildName = null;
        Byte room = null;
        String area = null;
        String useage = null;

        String dealDesc = "";
        if (Const.DIC_CASE_TYPE_SALE_DEAL == dealType.intValue()) {
            dealDesc = "出售合同【";
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setSaleId(deal.getDealHouseId());
            erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
            if (null != erpFunSale) {
                buildName = erpFunSale.getBuildName();
                room = erpFunSale.getSaleRoom();
                area = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                useage = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_USEAGE", Optional.ofNullable(erpFunSale.getSaleUseage()).orElse(Byte.valueOf("1")).toString());
            }

        } else if (Const.DIC_CASE_TYPE_RENT_DEAL == dealType.intValue()) {
            dealDesc = "出租合同【";
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setLeaseId(deal.getDealHouseId());
            erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
            if (null != erpFunLease) {
                buildName = erpFunLease.getBuildName();
                room = erpFunLease.getLeaseRoom();
                area = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                useage = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_USEAGE", Optional.ofNullable(erpFunLease.getLeaseUseage()).orElse(Byte.valueOf("1")).toString());
            }
        }
        String houseInfo = (StringUtil.isNotBlank(buildName) ? " " + buildName : "") + (null != room ? " " + room + "室" : "") + (StringUtil.isNotBlank(area) ? " " + area + "㎡" : "") + (StringUtil.isNotBlank(useage) ? " " + useage : "");
        String simpleDealDesc = null;
        if (nextStepName == null && addStepName == null) {
            dealDesc = generalParam.getUserName() + " 已完成 " + dealDesc + contractNo + houseInfo + "】的" + runstepName + "步骤，提示完成了最后一个阶段";
            simpleDealDesc = dealDesc;
        } else if (nextStepName != null) {
            dealDesc = generalParam.getUserName() + " 已完成 " + dealDesc + contractNo + houseInfo + "】的" + runstepName + "步骤，请" + (StringUtil.isNotBlank(nextLimitTime) ? "在" + nextLimitTime + "前" : "") + "完成" + nextStepName + "。";
            simpleDealDesc = "请" + (StringUtil.isNotBlank(nextLimitTime) ? "在" + nextLimitTime + "前" : "") + "完成" + nextStepName + "。";
        } else if (addStepName != null) {
            dealDesc = generalParam.getUserName() + " 在 " + dealDesc + contractNo + houseInfo + "】的权证流程中添加了\"" + addStepName + "\"步骤";
            simpleDealDesc = dealDesc;
        }

        ErpFunUsersExample usersExample = new ErpFunUsersExample();
        usersExample.setShardCityId(cityId);
        usersExample.createCriteria().andCompIdEqualTo(generalParam.getCompId());
        List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(usersExample);
        Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
        for (Integer userId : taskUserIdList) {
            ErpFunTask funTask = new ErpFunTask();
            funTask.setWarmTime(DateTimeHelper.getTimeNow());
            funTask.setCaseId(model.getDealId());
            funTask.setCaseNo(contractNo);
            funTask.setCaseType(dealType);
            funTask.setIsRead(false);
            funTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
            funTask.setTaskType(Const.DIC_TASK_TYPE_AUTHORITY_REMIND);
            funTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
            funTask.setCreatorUid(generalParam.getUserId());
            funTask.setCreationTime(DateTimeHelper.getTimeNow());
            funTask.setTaskSubject(simpleDealDesc);
            funTask.setTaskDesc(dealDesc);
            funTask.setIndexShow(1);
            funTask.setTrackWarm(true);
            funTask.setCompId(generalParam.getCompId());
            ErpFunUsers user = usersMap.get(userId);
            if (null != user) {
                funTask.setTaskOwner(userId);
                funTask.setDeptId(user.getDeptId());
                funTask.setShardCityId(cityId);
                erpFunTaskMapper.insertSelective(funTask);

                String deptName = "";
                if (!generalParam.getDeptId().equals(user.getDeptId())) {
                    ErpFunDepts erpFunDepts = new ErpFunDepts();
                    erpFunDepts.setShardCityId(cityId);
                    erpFunDepts.setDeptId(generalParam.getDeptId());
                    deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                }
//				String taskSubject = deptName + user.getUserName() + " 提醒您:" + model.getWarmContent();

                // 实时提醒一条 xxx店xx人 提醒您：xxxx
                ErpFunTask erpFunTask = new ErpFunTask();
                erpFunTask.setWarmTime(DateTimeHelper.getTimeNow());
                erpFunTask.setCaseId(model.getDealId());
                erpFunTask.setCaseNo(contractNo);
                erpFunTask.setCaseType(dealType);
                erpFunTask.setIsRead(false);
                erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
                erpFunTask.setTaskType(Const.DIC_TASK_TYPE_AUTHORITY_REMIND);
                erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
                erpFunTask.setCreatorUid(generalParam.getUserId());
                erpFunTask.setCreationTime(DateTimeHelper.getTimeNow());
                erpFunTask.setTaskSubject(simpleDealDesc);
                erpFunTask.setTaskDesc(dealDesc);
                erpFunTask.setIndexShow(1);
                erpFunTask.setTrackWarm(true);
                erpFunTask.setCompId(generalParam.getCompId());
                erpFunTask.setWarmTime(DateTimeHelper.getTimeNow());
                erpFunTask.setTaskOwner(userId);
                erpFunTask.setDeptId(user.getDeptId());
                erpFunTask.setShardCityId(cityId);
                erpFunTaskMapper.insertSelective(erpFunTask);

                List<AdminFunUserMessage> userMessageList = new ArrayList<>();
                AdminFunUserMessage userMessage = new AdminFunUserMessage();
                userMessage.setMsgModule(10);
                userMessage.setModuleType(26);
                userMessage.setCityId(cityId);
                userMessage.setTargetId(erpFunTask.getTaskId());
                // 消息接收人档案ID
                userMessage.setArchiveId(user.getArchiveId());
                userMessage.setCompId(generalParam.getCompId());
                // 跟进提醒提醒全部端，否则只提醒erp
                userMessage.setAppType(0);
                userMessage.setCaseId(model.getDealId());
                userMessage.setCaseType(dealType.intValue());
                userMessageList.add(userMessage);
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
                        TaskQueueThread.sendMessageList(userMessageList);
                    }
                });

                ErpFunTaskTimed erpFunTaskTimed = new ErpFunTaskTimed();
                erpFunTaskTimed.setShardCityId(cityId);
                erpFunTaskTimed.setCompId(generalParam.getCompId());
                erpFunTaskTimed.setArchiveId(user.getArchiveId());
                erpFunTaskTimed.setUserId(user.getUserId());
                erpFunTaskTimed.setAreaId(user.getAreaId());
                erpFunTaskTimed.setRegId(user.getRegId());
                erpFunTaskTimed.setDeptId(user.getDeptId());
                erpFunTaskTimed.setGrId(user.getGrId());
                erpFunTaskTimed.setTaskId(funTask.getTaskId());
                erpFunTaskTimed.setTaskOwner(user.getUserId());
                erpFunTaskTimed.setTaskTime(new Date());
                erpFunTaskTimed.setTaskCreate(funTask.getCreatorUid());
                erpFunTaskTimed.setReadFlag((byte) 0);
                erpFunTaskTimedMapper.insertSelective(erpFunTaskTimed);

                if (StringUtil.isNotBlank(model.getWarnTime())) {
                    AdminFunUserTaskRemind adminFunUserTaskRemind = new AdminFunUserTaskRemind();
                    adminFunUserTaskRemind.setCityId(cityId);
                    adminFunUserTaskRemind.setCreationTime(new Date());
                    if (DateTimeHelper.parseToDate(model.getWarnTime()).getTime() < new Date().getTime()) {
                        adminFunUserTaskRemind.setRemindTime(new Date());
                    } else {
                        adminFunUserTaskRemind.setRemindTime(DateTimeHelper.parseToDate(model.getWarnTime() + " 09:00:00"));
                    }
                    adminFunUserTaskRemind.setSyncApp(Byte.valueOf("0"));
                    adminFunUserTaskRemind.setTaskId(funTask.getTaskId());
                    adminFunUserTaskRemind.setTaskType(Const.DIC_TASK_TYPE_CONTRACT_REMIND.intValue());
                    adminFunUserTaskRemindMapper.insertSelective(adminFunUserTaskRemind);
                }
            }

        }
    }

    @Transactional
    @Override
    public void updateTaskStatus(Integer cityId, Map<String, Object> map) {
        erpFunTaskMapper.updateTaskStatus(cityId, map);
        //更新表关联中
        erpFunTaskTimedMapper.updateTaskTimedByCondition(cityId, map);
        erpFunTaskMapper.updateTaskReadFlag(cityId, map);
    }

    @Transactional
    @Override
    public List<AdminFunUserMessage> createTask(Integer cityId, Integer compId, Integer deptId, String userName, Byte dealType,
                                                Integer caseId, String caseNo, Integer caseType, Integer selfUserId, Integer archiveId,
                                                Integer caseUserId, Integer dealId, String dealNo) {
        String taskSubject = "";

        switch (dealType) {
            // 出售合同对应出售和求购
            case 101: {
                if (caseType == 1) {
                    ErpFunSale erpFunSale = new ErpFunSale();
                    erpFunSale.setShardCityId(cityId);
                    erpFunSale.setSaleId(caseId);
                    erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
                    if (erpFunSale == null) {
                        break;
                    }
                    String buildName = erpFunSale.getBuildName();
                    Byte saleRoom = erpFunSale.getSaleRoom();
                    BigDecimal saleArea = erpFunSale.getSaleArea();
                    BigDecimal saleTotalPrice = erpFunSale.getSaleTotalPrice();

                    String deptName = "";
                    if (!deptId.equals(erpFunSale.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalSaleArea = removeZero(saleArea);
                    String finalSaleTotalPrice = removeZero(saleTotalPrice);

                    // xxx店xx人 将你 英郡 2室 69㎡ 70万 房源修改为内成交，并生成买卖合同
                    taskSubject = deptName + userName + " 将你 " + buildName + " " + (saleRoom == null ? "" : saleRoom + "室 ") +
                            finalSaleArea + "㎡ " + finalSaleTotalPrice + "万 房源修改为内成交，并生成买卖合同";
                } else if (caseType == 3) {
                    // xxx店xx人 将你 李先生求购2-3室 60-90㎡ 的客户修改为内成交，并生成买卖合同
                    ErpFunBuyCustomer funBuyCustomer = new ErpFunBuyCustomer();
                    funBuyCustomer.setShardCityId(cityId);
                    funBuyCustomer.setBuyCustId(caseId);
                    ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(funBuyCustomer);
                    if (erpFunBuyCustomer != null) {
                        String buyCustName = erpFunBuyCustomer.getBuyCustName();
                        // true=先生 false=女士
                        // 防止数据库性别为空报错
                        Boolean buyCustSex = Optional.ofNullable(erpFunBuyCustomer.getBuyCustSex()).orElse(true);
                        // 90-120平
                        BigDecimal houseAreaLow = erpFunBuyCustomer.getHouseAreaLow();
                        BigDecimal houseAreaHigh = erpFunBuyCustomer.getHouseAreaHigh();
                        // 2-3室
                        Byte houseRoom = erpFunBuyCustomer.getHouseRoom();
                        Byte houseRoom1 = erpFunBuyCustomer.getHouseRoom1();

                        String deptName = "";

                        if (!deptId.equals(erpFunBuyCustomer.getDeptId())) {
                            ErpFunDepts erpFunDepts = new ErpFunDepts();
                            erpFunDepts.setShardCityId(cityId);
                            erpFunDepts.setDeptId(deptId);
                            deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                        }

                        String finalHouseAreaLow = removeZero(houseAreaLow);
                        String finalHouseAreaHigh = removeZero(houseAreaHigh);

                        // xxx店xx人 将你 李先生求购2-3室 60-90㎡ 的客户修改为内成交，并生成买卖合同
                        taskSubject = deptName + userName + " 将你 " + buyCustName + (buyCustSex ? "先生" : "女士") + "求购" +
                                houseRoom + "-" + houseRoom1 + "室 " + finalHouseAreaLow + "-" + finalHouseAreaHigh + "㎡" + "的客户修改为内成交，并生成买卖合同";
                    }
                }

                break;
            }
            case 102: {
                if (caseType == 2) {
                    ErpFunLease erpFunLease = new ErpFunLease();
                    erpFunLease.setShardCityId(cityId);
                    erpFunLease.setLeaseId(caseId);
                    erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
                    if (erpFunLease == null) {
                        break;
                    }
                    String buildName = erpFunLease.getBuildName();
                    Byte leaseRoom = erpFunLease.getLeaseRoom();
                    Byte priceUnit = erpFunLease.getPriceUnit();

                    double leaseTotalPrice = Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue();
                    double leaseArea = Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(new BigDecimal(20)).doubleValue();
                    double totalPrice = com.myfun.framework.utils.CommonUtil.getLeaseMoneyByMonth(priceUnit, leaseTotalPrice, leaseArea);

                    String deptName = "";
                    if (!deptId.equals(erpFunLease.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalLeaseArea = removeZero(BigDecimal.valueOf(leaseArea));

                    // xxx店xx人 将你 英郡 2室 69㎡ 70万 房源修改为内成交，并生成租赁合同
                    taskSubject = deptName + userName + " 将你 " + buildName + " " + (leaseRoom == null ? "" : leaseRoom + "室 ") +
                            finalLeaseArea + "㎡ " + new DecimalFormat("#.00").format(totalPrice) + "元/月 房源修改为内成交，并生成租赁合同";

                } else if (caseType == 4) {
                    // xxx店xx人 将你 李先生求购2-3室 60-90㎡ 的客户修改为内成交，并生成租赁合同
                    ErpFunRentCustomerKey erpFunRentCustomerKey = new ErpFunRentCustomerKey(cityId, compId, caseId);
                    ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getFunRentCustomer(cityId, erpFunRentCustomerKey);
                    if (erpFunRentCustomer != null) {
                        String rentCustName = erpFunRentCustomer.getRentCustName();
                        // true=先生 false=女士
                        Boolean rentCustSex = Optional.ofNullable(erpFunRentCustomer.getRentCustSex()).orElse(true);
                        // 90-120平
                        BigDecimal houseAreaLow = erpFunRentCustomer.getHouseAreaLow();
                        BigDecimal houseAreaHigh = erpFunRentCustomer.getHouseAreaHigh();
                        // 2-3室
                        Byte houseRoom = erpFunRentCustomer.getHouseRoom();
                        Byte houseRoom1 = erpFunRentCustomer.getHouseRoom1();

                        String deptName = "";
                        if (!deptId.equals(erpFunRentCustomer.getDeptId())) {
                            ErpFunDepts erpFunDepts = new ErpFunDepts();
                            erpFunDepts.setShardCityId(cityId);
                            erpFunDepts.setDeptId(deptId);
                            deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                        }

                        String finalHouseAreaLow = removeZero(houseAreaLow);
                        String finalHouseAreaHigh = removeZero(houseAreaHigh);

                        // xxx店xx人 将你 李先生求租2-3室 60-90㎡ 的客户修改为内成交，并生成租赁合同
                        taskSubject = deptName + userName + " 将你 " + rentCustName + (rentCustSex ? "先生" : "女士") + "求租" +
                                houseRoom + "-" + houseRoom1 + "室 " + finalHouseAreaLow + "-" + finalHouseAreaHigh + "㎡" + "的客户修改为内成交，并生成租赁合同";
                    }
                }

                break;
            }
            default:
                break;
        }

        ErpFunTask erpFunTask = new ErpFunTask();
        erpFunTask.setShardCityId(cityId);
        erpFunTask.setCaseId(dealId);
        erpFunTask.setCaseNo(dealNo);
        erpFunTask.setCaseType(dealType);
        erpFunTask.setTaskSubject(taskSubject);
        erpFunTask.setTaskDesc(taskSubject);
        erpFunTask.setCompId(compId);
        erpFunTask.setDeptId(deptId);
        erpFunTask.setTaskOwner(caseUserId);
        erpFunTask.setTaskType(Const.DIC_TASK_TYPE_BARGAIN_REMIND);
        erpFunTask.setTypeFlag((byte) 0);
        erpFunTask.setIsRead(false);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreatorUid(selfUserId);
        erpFunTask.setCreationTime(getTimeNow());
        erpFunTask.setTrackWarm(false);
        erpFunTask.setWarmTime(getTimeNow());
        erpFunTask.setCreatorUid(999);
        erpFunTaskMapper.insertSelective(erpFunTask);

        List<AdminFunUserMessage> userMessageList = new ArrayList<>();

        AdminFunUserMessage userMessage = new AdminFunUserMessage();
        userMessage.setMsgModule(10);
        userMessage.setModuleType(26);
        userMessage.setCityId(cityId);
        userMessage.setTargetId(erpFunTask.getTaskId());
        // 消息接收人档案ID
        userMessage.setArchiveId(archiveId);
        userMessage.setCompId(compId);
        // 跟进提醒提醒全部端，否则只提醒erp
        userMessage.setAppType(0);
        userMessage.setCaseId(dealId);
        userMessage.setCaseType(dealType.intValue());
        userMessageList.add(userMessage);


        return userMessageList;
    }

    public static String getTimeNow() {
        return DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 总价如果是60.00万, 则取整为60万
     * 面积如果是100.00㎡, 则取整为100㎡
     */
    private String removeZero(BigDecimal zeroNumber) {
        String finalNumber = "";
        if (zeroNumber != null) {
            if (zeroNumber.toString().endsWith(".00") || zeroNumber.toString().endsWith(".0")) {
                finalNumber = String.valueOf(zeroNumber.intValue());
            } else {
                finalNumber = zeroNumber.toString();
            }
        }
        return finalNumber;
    }

    @Transactional
    @Override
    public void pushMsgForDealRemind(GeneralParam generalParam, ErpFunDeal erpFunDeal, String warmContent, Set<Integer> userIdSet) {
        ErpFunTask erpFunTask = new ErpFunTask();
        erpFunTask.setCaseId(erpFunDeal.getDealId());
        erpFunTask.setCaseNo(erpFunDeal.getContractNo());
        erpFunTask.setCaseType(erpFunDeal.getDealType());
        erpFunTask.setIsRead(false);
        erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        erpFunTask.setTaskType(Const.DIC_TASK_TYPE_CONTRACT_REMIND);
        erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        erpFunTask.setCreatorUid(generalParam.getUserId());
        erpFunTask.setCreationTime(DateTimeHelper.getTimeNow());
        erpFunTask.setTaskSubject(warmContent);
        erpFunTask.setTaskDesc(generalParam.getUserName() + " 提醒您：" + warmContent);
        erpFunTask.setIndexShow(1);
        erpFunTask.setTrackWarm(true);
        erpFunTask.setCompId(generalParam.getCompId());
        erpFunTask.setWarmTime(DateTimeHelper.getTimeNow());
        erpFunTask.setTaskOwner(generalParam.getUserId());
        erpFunTask.setDeptId(generalParam.getDeptId());
        erpFunTask.setShardCityId(generalParam.getCityId());
        insertTask(generalParam.getCityId(), erpFunTask, userIdSet, Byte.valueOf("0"),0);
		/*List<AdminFunUserMessage> userMessageList = new ArrayList<>();
		AdminFunUserMessage userMessage = new AdminFunUserMessage();
		userMessage.setMsgModule(10);
		userMessage.setModuleType(26);
		userMessage.setCityId(generalParam.getCityId());
		userMessage.setTargetId(erpFunTask.getTaskId());
		// 消息接收人档案ID
		userMessage.setArchiveId(erpFunUsers.getArchiveId());
		userMessage.setCompId(generalParam.getCompId());
		// 跟进提醒提醒全部端，否则只提醒erp
		userMessage.setAppType(0);
		userMessage.setCaseId(erpFunDeal.getDealId());
		userMessage.setCaseType(erpFunDeal.getDealType().intValue());
		userMessageList.add(userMessage);
		TaskQueueThread.sendMessageList(userMessageList);*/
    }
}


