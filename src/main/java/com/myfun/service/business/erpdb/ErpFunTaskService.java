package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpUpdateHouseBuildParam;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
public interface ErpFunTaskService extends BaseMapper<ErpFunTask, ErpFunTask>{
	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @throws BusinessException 
	 */
	public void checkApplyForCommitHouseKeyTaskStatus(Integer cityId, Integer compId, CreateHouseKeyParam param) throws BusinessException;

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param funTrackPO
	 * @throws Exception 
	 */	
	public void createHouseKeyTask(Integer cityId, Integer compId, ErpFunTrack funTrackPO) throws Exception;

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param updateModel
	 * @param conditionModel
	 */		
	public void updateFunTask(Integer cityId,ErpFunTask updateModel, ErpFunTask conditionModel,Object[] trackTypes);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param keyIds
	 */		
	public void updateKeyTask(Integer cityId, Integer compId,Object[] keyIds);

	/**
	 * @author 方李骥
	 * @since 2016年9月6日
	 * @param cityId
	 * @param conditionModel
	 * @return
	 */		
	public Integer countFunTask(Integer cityId, ErpFunTask conditionModel);
	
	/**
	 * 创建修改楼盘房源的所属楼盘任务和跟进
	 * @author 张宏利
	 * @since 2017年8月23日
	 */
	public void createUpdateHouseBuildTask(ErpUpdateHouseBuildParam param);
	
	/**
	 * 更新房源信息的议价标记
	 * @author 熊刚
	 * @since 2017年10月12日
	 * @param erpFunTrack
	 * @param caseInfoDto 
	 */
	public void updateCaseBargainFlag(ErpFunTrack erpFunTrack, CaseInfoDto caseInfoDto, ErpFunUsers createAuditUser);
	
	/**
	 * 级别审核任务通过后更新房源数据的相关逻辑
	 * @author 熊刚
	 * @since 2017年10月12日
	 * @param param
	 */
	public void updateCaseHouseLevel4House(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack);
	
	/**
	 * 跳公盘、抢盘、注销、数据移交 -->（注销、内成交、外成交、封盘、预定、暂缓、电话查看）状态的审核任务都要变为失效
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param caseType
	 * @param caseId
	 * @param trackType
	 * @param compId
	 */
	public void cancelAuditTaskForWriteoff(Integer cityId, Integer compId, Integer caseId, Integer caseType, Byte trackType);
	
	/**
	 * 转租转售失效
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 * @param trackType
	 */
	void cancelAuditTaskForTransHouse(Integer cityId, Integer compId, Integer caseId, Integer caseType, Byte trackType);
	
	/**
	 * 带看更新房源和客源的带看信息
	 * @author 熊刚
	 * @since 2017年10月16日
	 */
	public void updateCaseDaikan4Cust(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack);
	
	/**
	 * 房勘审核任务通过后更新房源数据的相关逻辑
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param trackPoQuery
	 * @throws Exception
	 */
	public void updateCaseFangcan4House(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack);
	
	/**
	 * 更新房源的委托逻辑
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param erpFunTrack
	 * @param hongJICompModel
	 */
	public void updateCaseWeituo(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack);

	/**
	 *  更新数据的状态// 返回是否是真房源
	 * @author 熊刚
	 * @since 2017年10月18日
	 * @param trackPO
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Integer[] updateCaseStatus(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack);

	public void createDueWarmTask(ErpCreateTrackInfoParam param);

	/**
	 * 修改房源楼盘名
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 * @param buildingInfo
	 */
	public void changeHouseBuild(Integer cityId, Integer caseId, Integer caseType, ErpBuildingInfoDto buildingInfo);
	
	/**
	 * 提交钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	public void createSubmitKey(ErpCreateTrackInfoParam param);
	
	/**
	 * 借用钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	public void createTrack4BorrowKey(ErpCreateTrackInfoParam param, String trackContent);
	
	/**
	 * 退还钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	public void createReturnKey(ErpCreateTrackInfoParam param, String trackContent);
	
	/**
	 * 注销钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	public void createTrack4DestroyKey(ErpCreateTrackInfoParam param);
	
	/**
	 * 创建提醒任务
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	public void createWarmTask(ErpCreateTrackInfoParam param, Byte renovationParam, Byte syncApp);
	
	/**
	 * 统一的插入FUN_TASK的方法，不能直接插入
	 * @author 张宏利
	 * @since 2017年12月23日
	 * @param cityId
	 * @param erpFunTask
	 */
	public void insertTask(Integer cityId, ErpFunTask erpFunTask, Byte syncApp);

	/**
	 * 统一的插入FUN_TASK的方法，提醒多个人的，不能直接插入
	 * @author 张宏利
	 * @since 2017年12月23日
	 * @param cityId
	 * @param erpFunTask
	 */
	public void insertTask(Integer cityId, ErpFunTask erpFunTask, Set<Integer> userIdSet, Byte syncApp,Integer sendIm);
	
	/**
	 * 增加提醒总经理查看条数达到上限
	 * @author 张宏利
	 * @since 2018年1月13日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param casePlateType
	 * @param userName
	 * @param caseId
	 * @param caseNo
	 */
	public void createViewLogTaskWarning(Integer cityId, Integer compId, Integer caseType, Integer casePlateType,
			String userName, Integer caseId, String caseNo, Integer caseDeptId, Integer selfDeptId, Integer selfUserId);
	
	/**
	 * 获取提醒任务列表
	 * @author 张宏利
	 * @since 2018年3月8日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public PageInfo<ErpFunTaskDto> getWarmTaskList(Integer cityId, BaseMapParam param);


	void createTaskForTransData(Integer cityId, List<Integer> caseIds,ErpFunUsers acceptUser, String[] caseNos, Integer caseType, int dataCount, DataTranslateParam param);
	void updateTaskForWriteoffAndStatusChange(Integer cityId, Integer compId, Integer caseType, Integer[] caseIds, Byte status);

    void updateTaskForTransData(ErpFunUsers acceptUser, Integer caseType, DataTranslateParam param,List<Integer> caseIds);

	void rentOverWarmTask(ErpFunTrack track, Integer caseUserId, Integer deptId, InsertDealInfoParam param);

	void createDealWarmTask(Byte dealType, Integer dealId, String contractNo, List<ErpFunUsers> taskUserList, String taskSubJect, Byte taskType, String taskSubJect1, Integer userId, Integer cityId, Integer deptId, Integer compId);

	void writeTaskForRuntimeStep(GeneralParam generalParam, ErpProcessRuntimeStep model, String nextStepName, List<Integer> taskUserIdList, String runstepName, String addStepName, String nextLimitTime);

	void updateTaskStatus(Integer cityId, Map<String,Object> map);

	List<AdminFunUserMessage> createDealTask(Byte dealType, Integer dealId, String contractNo, List<ErpFunUsers> taskUserList, String taskSubJect, Byte taskType,
						String taskSubJect1, Integer userId, Integer cityId, Integer deptId, Integer compId, Integer creatorUid);

	List<AdminFunUserMessage> createTask(Integer cityId, Integer compId, Integer deptId, String userName, Byte dealType,
										 Integer caseId, String caseNo, Integer caseType, Integer selfUserId, Integer archiveId,
                                         Integer caseUserId, Integer dealId, String dealNo);

	/**
	 * 推送合同中指定人的消息
	 */
	void pushMsgForDealRemind(GeneralParam generalParam, ErpFunDeal erpFunDeal, String warmContent, Set<Integer> userIdSet);
}
