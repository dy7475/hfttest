package com.myfun.service.jms.activeMQ;

import com.extension.framework.mq.context.MqUtil;
import com.myfun.erpWeb.openApi.user.param.DealNewOrgUserCountMessage;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.jms.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@Import(MqUtil.class)
public class ActiveMqPublisher {

    @Autowired
    MqUtil mqUtil;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;

    /**
     * 审核之后通知消息，因为要延迟发送，所以用jms发送消息
     * @author 张宏利
     * @since 2017年11月3日
     * @param cityId
     * @param auditId
     * @param auditSeq
     * @param auditStatus 审核状态，1=等待审核 2=审核通过 3=审核未通过 4=没有审核人
     * @param delaySeconds 延迟时间，秒
     */
    public void sendJmsMessageForAudit(Integer cityId, Integer auditId, Integer auditSeq,
                                              Integer auditStatus, Long delaySeconds) {
        AuditToastMessage message = new AuditToastMessage();
        message.setCityId(cityId);
        message.setAuditId(auditId);
        message.setAuditSeq(auditSeq);
        message.setAuditStatus(auditStatus);
        message.setQueneName(JmsMsgAction.AUDIT_TOAST);
        mqUtil.sendMessage(message);

    }
    /**
     * 跟进队列
     * 可用于与跟进相关的业务
     * @param cityId
     * @param trackId
     */
    public void sendTrackMsg(Integer cityId, Integer trackId) {

        TrackScoreMessage message = new TrackScoreMessage();
        message.setCityId(cityId);
        message.setTrackId(trackId);
        message.setQueneName(JmsMsgAction.TRACK_MESSAGE);
        mqUtil.sendMessage(message);
    }
    
    public void sendDealUserOperMsg(Integer cityId,Integer compId,List<String> roleIds,Set<String>  deleteOpers,Set<String>  repeatUpdateOperIds,Set<String>  ptOperAdd) {
    	DealUserOperMessage message = new DealUserOperMessage();
        message.setCityId(cityId);
        message.setCompId(compId);
        message.setRoleIds(roleIds);
        message.setDeleteOpers(deleteOpers);
        message.setRepeatUpdateOperIds(repeatUpdateOperIds);
        message.setPtOperAdd(ptOperAdd);
        message.setQueneName(JmsMsgAction.DEAL_USER_OPER);
        mqUtil.sendMessage(message);
    }

    /**
     * @Desc 修改类操作
     * @Author lcb
     * @Time 2019/9/25 0025
     **/
    public void sendWorkCountMessageForCaseStatusChange(Integer cityId, Const.StatisticDetailType countFieldName, Date auditCreationTime,
                                                        Integer userId, Integer caseType, Integer caseId, Integer trackId, Double dealMoney, Integer oldStatus, Integer dealId) {
        if(countFieldName == null) {
            return;
        }

        WorkCountCaseStatusChangeMessage message = new WorkCountCaseStatusChangeMessage();
        ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
        // 工作量算在审批当天
        String workCountExamineDay = erpSysParaMapper.getParamValue(cityId, erpFunUsers.getCompId(), "WORK_COUNT_EXAMINE_DAY");
        if("1".equals(workCountExamineDay)) {
            auditCreationTime = new Date();
        }
        Integer grId = erpFunUsers.getGrId();
        message.setCaseType(caseType);
        message.setCaseId(caseId);
        message.setTrackId(trackId + "");
        message.setDealMoney(dealMoney);
        message.setArchiveId(erpFunUsers.getArchiveId());
        message.setUserId(erpFunUsers.getUserId());
        message.setGrId(grId == null ? 0 : grId);
        message.setDeptId(erpFunUsers.getDeptId());
        message.setRegId(erpFunUsers.getRegId());
        message.setAreaId(erpFunUsers.getAreaId());
        message.setCompId(erpFunUsers.getCompId());
        message.setCityId(erpFunUsers.getCityId().intValue());
        message.setStatisticType(countFieldName.getIndex());
        message.setOldHouseStatus(oldStatus);
        // 必须是到日
        message.setCreateTime(auditCreationTime);
        // 扩展字段，增加哪一个工作量，和数据库表字段名一致
        message.setCountFieldName(countFieldName.name());
        // 增加的量，大于1时caseId是个数组[12,56,46]
        message.setCountSize(1);
        message.setDealId(dealId);
        message.setQueneName(JmsMsgAction.CASE_STATUS_CHANGE_CLASS_CONSUMER);
        mqUtil.sendMessage(message);
    }

    public void sendAgreementPictureMsg(Integer cityId,Integer entrustId,Integer ownerId) {
        AgreementPictureMessage message = new AgreementPictureMessage();
        message.setCityId(cityId);
        message.setEntrustId(entrustId);
        message.setOwnerId(ownerId);
        message.setQueneName(JmsMsgAction.AGREEMENT_PICTURE_MSG);
        mqUtil.sendMessage(message);
    }
    
    public void sendMoveOrgMsg(Integer cityId,Integer compId,Integer moveOrgId,Integer userId) {
    	OrgMoveConsumerMessage message = new OrgMoveConsumerMessage();
    	message.setCityId(cityId);
    	message.setCompId(compId);
    	message.setMoveOrgId(moveOrgId);
    	message.setQueneName(JmsMsgAction.ORG_MOVE_CONSUMER);
    	message.setMoveUserId(userId);
    	mqUtil.sendMessage(message);
    }

    public void removeListing(Integer cityId,Integer archiveId, Integer userId) {
        RemoveListingMessage message = new RemoveListingMessage();
    	message.setCityId(cityId);
        message.setArchiveId(archiveId);
        message.setUserId(userId);
    	message.setQueneName(JmsMsgAction.REMOVE_LISTING);
    	mqUtil.sendMessage(message);
    }
	public void sendDealNewOrgMove(DealNewOrgUserCountMessage message) {
    	message.setQueneName(JmsMsgAction.ORG_MOVE_COUNT_DEAL_CONSUMER);
    	mqUtil.sendMessage(message);
	}

	public void UpdateOrgUserNum(Integer cityId,Integer compId,String movePath) {
        UpdateOrgUserNumConsumerMessage message = new UpdateOrgUserNumConsumerMessage();
        message.setCityId(cityId);
        message.setCompId(compId);
        message.setMovePath(movePath);
        message.setQueneName(JmsMsgAction.UPDATE_ORG_USER_NUM);
        mqUtil.sendMessage(message);
    }
}
