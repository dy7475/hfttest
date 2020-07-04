package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.transaction.dto.HouseInfoDto;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpEarbestDepositCommService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ErpEarbestDepositCommServiceImpl implements ErpEarbestDepositCommService {

    @Autowired
    private AdminFunCompService adminFunCompService;
    @Autowired
    private ActiveMqPublisher activeMqPublisher;

    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
    @Autowired
    private ErpFunDepositMapper erpFunDepositMapper;

    @Autowired
    private AdminFunCompMapper adminFunCompMapper;
    @Autowired
    private ErpFunCompMapper erpFunCompMapper;

    @Autowired
    private ErpFunTrackService erpFunTrackService;






    private String getHouseStatusName(Integer status) {

        if (Objects.equals(Const.DIC_HOUSE_STATUS_AVAILABLE.intValue(), status)) {
            return "有效";
        }
        if (Objects.equals(Const.DIC_HOUSE_STATUS_SPECIAL.intValue(), status)) {
            return "封盘";
        }
        if (Objects.equals(Const.DIC_HOUSE_STATUS_RESPITE.intValue(), status)) {
            return "暂缓";
        }
        if (Objects.equals(Const.DIC_HOUSE_STATUS_SCHEDULE.intValue(), status)) {
            return "预订";
        }
        return "";
    }

    public void writeCaseStatusAndTrackForEarbestAdd(Integer cityId, ErpFunEarbestMoney obj) {

        Integer caseType = getCaseType(obj.getCaseNo());
        HouseInfoDto houseStatus = getHouseStatus(cityId, obj.getCompId(), obj.getCaseId(), getCaseType(obj.getCaseNo()));
        if (Objects.isNull(houseStatus)) {
            throw new BusinessException("房源不存在");
        }
        Integer caseStatus = houseStatus.getCaseStatus();
        if (Objects.equals(Const.DIC_HOUSE_STATUS_SCHEDULE.intValue(), caseStatus)) {
            //该房源已经是预定状态
            return;
        }
        //修改房源状态为预定状态
        updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_SCHEDULE, obj.getCaseId(), caseType);

        //写跟进
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, obj.getCreateUser());
        ErpFunTrack funTrack = createHouseTrack(cityId, erpFunUsers, houseStatus);
        String content = String.format("%s 修改该房源状态：<span style='color:#259cf3;'>%s</span> >> <span style='color:#259cf3;'>预订</span>跟进内容：该房源收到诚意金%d元，票据号%s",
                erpFunUsers.getUserName(), getHouseStatusName(houseStatus.getCaseStatus()),obj.getReceiptMoney(), obj.getBillCodeNo());
        funTrack.setTrackContent(content);
        funTrack.setTrackType(Const.DIC_TRACK_TYPE_STATUS_SCHEDULE);
        erpFunTrackMapper.insertSelective(funTrack);
        //添加工作流
        activeMqPublisher.sendTrackMsg(cityId, funTrack.getTrackId());
        //工作量
        erpFunTrackService.sendJmsMessageForWorkCount(cityId, Const.StatisticDetailType.YD_COUNT, new Date(), erpFunUsers.getUserId(),
                houseStatus.getCaseType(), houseStatus.getCaseId().toString(), funTrack.getTrackId(), 1, 0.0, null);
    }

    /**
     * 写定金
     * @param cityId c
     * @param obj o
     */
    public void writeCaseStatusAndTrackForDepositAdd(Integer cityId, ErpFunDeposit obj,boolean fromEarbest) {

        Integer caseType = getCaseType(obj.getCaseNo());
        HouseInfoDto houseStatus = getHouseStatus(cityId, obj.getCompId(), obj.getCaseId(), getCaseType(obj.getCaseNo()));
        if (Objects.isNull(houseStatus)) {
            throw new BusinessException("房源不存在");
        }
        Integer caseStatus = houseStatus.getCaseStatus();
        if (Objects.equals(Const.DIC_HOUSE_STATUS_COLLECT_DEPOSIT.intValue(), caseStatus)) {
            //该房源已经是预定状态
            return;
        }
        //修改房源状态为预定状态
        updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_COLLECT_DEPOSIT, obj.getCaseId(), caseType);

        //写跟进
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, obj.getCreateUserId());
        ErpFunTrack funTrack = createHouseTrack(cityId, erpFunUsers, houseStatus);

        String content = String.format("%s 修改该房源状态：<span style='color:#259cf3;'>%s</span> >> <span style='color:#259cf3;'>收定</span>跟进内容：该房源收到定金%d元，票据号%s",
                erpFunUsers.getUserName(), getHouseStatusName(houseStatus.getCaseStatus()),obj.getReceiptMoney().intValue(), obj.getBillCodeNo());
        if (fromEarbest) {
            content = String.format("%s 修改该房源状态：<span style='color:#259cf3;'>%s</span> >> <span style='color:#259cf3;'>收定</span>跟进内容：票据号为%s，金额%d元,由诚意金转为定金",
                    erpFunUsers.getUserName(), getHouseStatusName(houseStatus.getCaseStatus()), obj.getBillCodeNo(), obj.getReceiptMoney().intValue());

        }
        funTrack.setTrackContent(content);
        funTrack.setTrackType(Const.DIC_TRACK_TYPE_COLLECT_DEPOSIT);
        erpFunTrackMapper.insertSelective(funTrack);
        erpFunTrackService.sendJmsMessageForWorkCount(cityId, Const.StatisticDetailType.SD_COUNT, new Date(), erpFunUsers.getUserId(),
                houseStatus.getCaseType(), houseStatus.getCaseId().toString(), funTrack.getTrackId(), 1, 0.0, null);
    }




    /**
     *
     * @param cityId cityId
     * @param record 诚意金model
     */
    public void cancelHouseEarbest(Integer cityId, ErpFunEarbestMoney record) {
        Integer caseType = getCaseType(record.getCaseNo());
        HouseInfoDto houseStatus = getHouseStatus(cityId, record.getCompId(), record.getCaseId(), getCaseType(record.getCaseNo()));
        if (Objects.isNull(houseStatus)) {
            return;
        }
        Integer caseStatus = houseStatus.getCaseStatus();
        if (Objects.equals(caseStatus, Const.DIC_HOUSE_STATUS_SCHEDULE.intValue())) {
            updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_AVAILABLE, record.getCaseId(), caseType);
            //写跟进
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, record.getCreateUser());
            ErpFunTrack funTrack = createHouseTrack(cityId, erpFunUsers, houseStatus);
            String content = "该房源已退回诚意金";
            funTrack.setTrackContent(content);
            //取消预订跟进类型

            funTrack.setTrackType(Const.DIC_TRACK_TYPE_CANCEL_SCHEDULE);
            erpFunTrackMapper.insertSelective(funTrack);
        }
    }


    /**
     *取消收定金状态
     * @param cityId cityId
     * @param record 定金model
     */
    public void cancelHouseDeposit(Integer cityId, ErpFunDeposit record) {

        Integer caseType = Optional.ofNullable(record.getCaseType()).map(Integer::valueOf).orElse(null);
        HouseInfoDto houseStatus = getHouseStatus(cityId, record.getCompId(), record.getCaseId(), caseType);
        if (Objects.isNull(houseStatus)) {
            return;
        }
        Integer caseStatus = houseStatus.getCaseStatus();
        if (Objects.equals(caseStatus, Const.DIC_HOUSE_STATUS_COLLECT_DEPOSIT.intValue())) {
            updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_AVAILABLE, record.getCaseId(), caseType);
            //|写跟进
            //写跟进
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, record.getCreateUserId());
            ErpFunTrack funTrack = createHouseTrack(cityId, erpFunUsers, houseStatus);
            String content = "该房源已退回定金";
            funTrack.setTrackContent(content);
            funTrack.setTrackType(Const.DIC_TRACK__TYPE_CANCEL_COLLECT_DEPOSIT);
            erpFunTrackMapper.insertSelective(funTrack);
        }
    }

    public void judgeAndResetHouseEarbestStatus(Integer cityId, ErpFunEarbestMoney record){
        List<ErpFunEarbestMoney> list = getRelativeEarbestList(cityId, record);
        BigDecimal remainingBalance = getEarbestRemainingBalance(list);
        if (remainingBalance.compareTo(BigDecimal.ZERO) <= 0) {
            if (checkEarbestNeedResetHouseStatus(list)) {
                cancelHouseEarbest(cityId, record);
            }
        }
    }

    public void judgeAndResetHouseDepositStatus(Integer cityId, ErpFunDeposit record){
        List<DepositVO> list = getRelativeDepositList(cityId, record);
        BigDecimal remainingBalance = getDepositRemainingBalance(list);
        if (remainingBalance.compareTo(BigDecimal.ZERO) <= 0) {
            if (checkDepositNeedResetHouseStatus(list)) {
                cancelHouseDeposit(cityId, record);
            }
        }
    }

    public void makeEarbestBargainSuccess(Integer cityId, ErpFunEarbestMoney record){
        Integer caseType = getCaseType(record.getCaseNo());
        //修改房源状态为内成交
        updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_INNERDEAL, record.getCaseId(), caseType);
    }

    public void makeDepositBargainSuccess(Integer cityId, ErpFunDeposit record){
        Integer caseType = getCaseType(record.getCaseNo());
        //修改房源状态为内成交
        updateHouseStatus(cityId, Const.DIC_HOUSE_STATUS_INNERDEAL, record.getCaseId(), caseType);
    }

    /**
     * 根据余额 是否有代付、转定金记录确定是否需要取消预订
     * @param list 关联诚意金列表
     * @return
     */
    private boolean checkEarbestNeedResetHouseStatus(List<ErpFunEarbestMoney> list) {
        for (ErpFunEarbestMoney obj : list) {
            if (Objects.nonNull(obj.getDealId())) {
                //已有转成交
                return false;
            }
            if (obj.getOperationType() == Const.EarbestDepositOperator.OPTION_TYPE_PAY2OWNER.byteValue()) {
                return false;
            }
            if (obj.getOperationType() == Const.EarbestDepositOperator.OPTION_TYPE_TRANS2DEPOSIT.byteValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDepositNeedResetHouseStatus(List<DepositVO> list) {
        for (DepositVO obj : list) {
            if (Objects.nonNull(obj.getDealId())) {
                //已有转成交
                return false;
            }
            if (obj.getOperationType() == Const.EarbestDepositOperator.OPTION_TYPE_PAY2OWNER.byteValue()) {
                return false;
            }
        }
        return true;
    }


    private BigDecimal getEarbestRemainingBalance(List<ErpFunEarbestMoney> list) {
        BigDecimal balance = BigDecimal.ZERO;
        //OPERATION_TYPE	操作类别：默认0,  1.转房源，2.代付，3.转拥，4.退款，5.作废，6.业主佣金 7.转定金，
        for (int i=0;i<list.size();i++) {
            ErpFunEarbestMoney obj = list.get(i);
            if (Byte.valueOf("0").equals(obj.getOperationType()) && Byte.valueOf("1").equals(obj.getEarbestStatus())
                    || Byte.valueOf("0").equals(obj.getOperationType()) && Byte.valueOf("0").equals(obj.getEarbestStatus())) {//包含已审核，未审核
                balance = balance.add(new BigDecimal(obj.getReceiptMoney()));
            } else if (Byte.valueOf("3").equals(obj.getOperationType())|| Byte.valueOf("6").equals(obj.getOperationType())
                    || Byte.valueOf("2").equals(obj.getOperationType()) || Byte.valueOf("4").equals(obj.getOperationType())) {//转拥，代付，退款
                //转佣的，代付的，退款的
                balance = balance.subtract(new BigDecimal((obj.getReceiptMoney())));
            }
        }
        if (balance.compareTo(BigDecimal.ZERO) < 0) {//兼容老数据退款
            balance = BigDecimal.ZERO;
        }
        return balance;
    }

    private BigDecimal getDepositRemainingBalance(List<DepositVO> list) {
        BigDecimal balance = BigDecimal.ZERO;
        //OPERATION_TYPE	操作类别：0 1.转房源，2代付 3.客户转拥，4.退款 5=作废.6=业主转佣
        for (DepositVO vo:list) {
            if (Byte.valueOf("0").equals(vo.getOperationType())) {
                balance = balance.add(vo.getReceiptMoney());
            } else if (Byte.valueOf("3").equals(vo.getOperationType()) || Byte.valueOf("6").equals(vo.getOperationType()) || Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {
                //转佣的，代付的，退款的
                balance = balance.subtract(vo.getReceiptMoney());
            }
            if (StringUtil.isNotBlank(vo.getBillPhoto())) {
                vo.setBillPhoto(AppConfig.getUserPhotoPicDomainPath(vo.getBillPhoto()));
            }
        }
        if (balance.compareTo(BigDecimal.ZERO)<0) {
            balance = BigDecimal.ZERO;
        }
        return balance;
    }

    private List<DepositVO> getRelativeDepositList(Integer cityId,ErpFunDeposit deposit) {
        List<DepositVO> list = null;
        if (deposit.getDealId()!=null) {
            list = erpFunDepositMapper.selectDepositListByDealId(cityId, deposit.getCompId(), deposit.getDealId(), null);
        } else {
            list = erpFunDepositMapper.selectDepositListByHouseCustId(cityId, deposit.getCompId(), deposit.getCustId(), deposit.getCustType(), deposit.getCaseId(), deposit.getCaseType(), null);
        }
        return list;
    }

    private List<ErpFunEarbestMoney> getRelativeEarbestList(Integer cityId, ErpFunEarbestMoney record) {
        Integer compId = record.getCompId();
        List<ErpFunEarbestMoney> list = null;
        if (record.getDealId()!=null) {
            list = erpFunEarbestMoneyMapper.selectEarbestListByDealId(cityId, record.getCompId(), record.getDealId());
        } else {
            list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(cityId,compId,record.getCustNo(), record.getCustId(), record.getCaseNo(), record.getCaseId(),false);
        }
        if (list.isEmpty()) {//兼容没有房客源的老数据
            list = new ArrayList<>();
            list.add(record);
        }
        return list;
    }

    /**
     * 诚意金或定金创建跟进
     *
     * @param cityId 城市id
     * @param erpFunUsers erpUser
     * @param houseStatus houseInfo
     * @return
     */
    private ErpFunTrack createHouseTrack(Integer cityId, ErpFunUsers erpFunUsers, HouseInfoDto houseStatus) {
        ErpFunTrack funTrack = new ErpFunTrack();
        funTrack.setShardCityId(cityId);
        funTrack.setCompId(erpFunUsers.getCompId());
        funTrack.setCaseId(houseStatus.getCaseId());
        funTrack.setCaseNo(houseStatus.getCaseNo());
        funTrack.setCreatorUid(erpFunUsers.getUserId());
        funTrack.setIsUserTrack(0);
        funTrack.setDeptId(erpFunUsers.getDeptId());
        funTrack.setGrId(erpFunUsers.getGrId());
        funTrack.setCaseStatus(Optional.ofNullable(houseStatus.getCaseStatus()).map(Integer::byteValue).orElse(null));
        funTrack.setCaseType(Optional.ofNullable(houseStatus.getCaseType()).map(Integer::byteValue).orElse((byte) 1));
//        funTrack.setIsDeltrack((byte) 1);
        funTrack.setTrackClassic(Const.DIC_TASK_TYPE_BUSINESS_TRACKING_STR);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        funTrack.setCreationTime(dateTimeFormatter.format(LocalDateTime.now()));

        return funTrack;
    }

    /**
     * 修改房源状态
     * @param cityId cityId
     * @param houseStatus 房源状态
     * @param caseId 房源id
     * @param caseType 房源类型
     */
    private void updateHouseStatus(Integer cityId, byte houseStatus, Integer caseId, Integer caseType) {
        if (Objects.equals(Const.DIC_CASE_TYPE_SALE_FUN, caseType)) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setShardCityId(cityId);
            funSale.setSaleId(caseId);
            funSale.setSaleStatus(houseStatus);
            erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
        } else if (Objects.equals(Const.DIC_CASE_TYPE_LEASE_FUN, caseType)) {
            ErpFunLease funLease = new ErpFunLease(cityId, caseId);
            funLease.setLeaseStatus((int) houseStatus);
            erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
        }
    }

    private HouseInfoDto getHouseStatus(Integer cityId, Integer compId, Integer caseId, Integer caseType) {
        HouseInfoDto houseInfo = null;
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale funSale = erpFunSaleMapper.selectByPrimaryKey(new ErpFunSale(cityId, caseId));
            if (Objects.nonNull(funSale)) {
                houseInfo = new HouseInfoDto();
                houseInfo.setCaseId(funSale.getSaleId());
                houseInfo.setCaseType(1);
                houseInfo.setCaseStatus(Optional.ofNullable(funSale.getSaleStatus()).map(Integer::valueOf).orElse(null));
                houseInfo.setCaseNo(funSale.getSaleNo());
                houseInfo.setCompId(funSale.getCompId());
                houseInfo.setDeptId(funSale.getDeptId());
                houseInfo.setUserId(funSale.getUserId());
            }
        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
            ErpFunLease funLease = erpFunLeaseMapper.selectByPrimaryKey(new ErpFunLease(cityId, caseId));
            houseInfo = new HouseInfoDto();
            houseInfo.setCaseId(funLease.getLeaseId());
            houseInfo.setCaseType(2);
            houseInfo.setCaseStatus(funLease.getLeaseStatus());
            houseInfo.setCaseNo(funLease.getLeaseNo());
            houseInfo.setCompId(funLease.getCompId());
            houseInfo.setDeptId(funLease.getDeptId());
            houseInfo.setUserId(funLease.getUserId());
        }
        return houseInfo;
    }

    private Integer getCaseType(String caseNo) {
        if (StringUtil.isBlank(caseNo)) {
            return null;
        }
        if (caseNo.startsWith("CS")) {
            return 1;
        }
        if (caseNo.startsWith("CZ")) {
            return 2;
        }
        return null;
    }
}
