package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.repository.erpdb.dto.CreateAuditResultDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpOaLeaveAuditParam;
import com.myfun.repository.erpdb.param.ErpOaOutAuditParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntime;
import com.myfun.repository.erpdb.po.ErpAuditUserTemplate;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ErpAuditRuntimeService extends BaseMapper<ErpAuditRuntime, ErpAuditRuntime>{
	
	/**
	 * 创建一个跟进的审核任务
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param mustAuditUserType 必须创建审核的类型，0或null为不是必须，否则为：6=信息归属方有权限的人
	 * @return 1=无需审核，2=已全部通过且处理完成，3=创建审核成功，4=创建审核成功且第一个环节没有审核人
	 */
	public Integer createAuditRuntimeForTrack(ErpCreateTrackInfoParam param, Integer mustAuditUserType);
	
	/**
	 * 创建请假审核任务
	 * @author 张宏利
	 * @since 2018年1月2日
	 * @param param
	 * @return
	 */
	public CreateAuditResultDto createAuditRuntimeForOaLeave(ErpOaLeaveAuditParam param);
	
	/**
	 * 创建外出审核任务
	 * @author 张宏利
	 * @since 2018年1月2日
	 * @param param
	 * @return
	 */
	public CreateAuditResultDto createAuditRuntimeForOaOut(ErpOaOutAuditParam param);
	
	/**
	 * 对流程进行跟进操作
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId 城市ID
	 * @param auditId 审核任务ID
	 * @param userId 跟进人
	 * @param trackType 跟进类型，0=普通跟进 1=发起申请 2=通过 3=拒绝
	 * @param trackContent 跟进内容
	 * @return
	 */
	public void createAuditTrack(Integer cityId, Integer auditId, Integer userId, Byte trackType, String trackContent);
	
	/**
	 * 对流程进行审核操作
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param auditId 
	 * @param auditUserId
	 * @param auditStatus 状态 0=不通过 1=通过
	 * @param trackContent 跟进内容
	 * @return true=审核完成
	 */
	public boolean auditRuntime(Integer cityId, ErpAuditRuntime erpAuditRuntimeParam, Integer auditUserId, Byte auditStatus,
			String trackContent, Date targetTime, String targetNo, Integer sureToAviliable);

	/**
	 * 创建审核人
	 * @author 张宏利
	 * @since 2017年11月15日
	 * @param template
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param createAuditUserId
	 * @param keyDeptId
	 * @return
	 */
	public List<ErpAuditUserRuntime> createAuditUser(Byte auditType, ErpAuditUserRuntime template, Integer cityId, Integer caseId, Integer caseType, 
			Integer createAuditUserId, Integer keyDeptId, Optional<Integer> nowRange);

	/**
	 * 判断角色是否有管理范围
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId 城市ID
	 * @param userRuntime 运行时用户模板
	 * @param compId 公司ID
	 * @return
	 */
	public void judgeHaveAuditUser(Integer cityId, ErpAuditUserTemplate userRuntime, Integer compId);
	
	/**
	 * 本人撤销申请
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param cityId 城市ID
	 * @param auditId 审核ID
	 * @param userId 用户ID
	 * @param trackContent 跟进内容
	 */
	void auditRevokeRuntime(Integer cityId, Integer auditId, Integer userId, String trackContent);

	/**
	 * 为角色创建审核人，当审核状态为待审，但该角色没有审核人的情况下操作
	 * @author 张宏利
	 * @since 2017年11月14日
	 * @param cityId
	 * @param compId
	 */
	public void createAuditUserForUserChange(Integer cityId, Integer compId, String roleId, Integer userId);

	public void createAuditUserForUserChangeNoTransactional(Integer cityId, Integer compId, String roleId, Integer userId, boolean isFangJidi);
	
	public void createAuditUserForFangJiDiRoleChangeNoTransactional(Integer cityId, Integer compId, String roleId, Integer userId, boolean isFangJidi);
	/**
	 *
	 * 内成交、外成交-->失效任务：预定  封盘 内成交 外成交
	 * @author 张宏利
	 * @since 2017年10月13日
	 */
	void cancelAuditTask4InnerOrOutBargain(Integer cityId, Integer compId, Integer caseType, Integer caseId, Byte trackType);

    Boolean audit(Integer cityId, Integer id, Integer auditUserId, Byte auditStatus, String trackContent, boolean isNewOrg) throws Exception;

	Integer commonCreateDealAudit(DealAuditCommonParam param) throws Exception;

    void createAuditUserForUserChangeNoTransactionalNewOrg(Integer cityId, Integer compId, String roleId, Integer userId);
    
    public void createAuditUserForOrgManagerChange(Integer cityId, Integer compId, Integer userId);
}


