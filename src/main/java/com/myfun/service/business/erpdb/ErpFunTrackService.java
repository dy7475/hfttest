package com.myfun.service.business.erpdb;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.BorrowOrReturnKeyParam;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;

public interface ErpFunTrackService extends BaseMapper<ErpFunTrack, ErpFunTrack>{

	void insertBatch(Integer cityId, List<Map<String, Object>> resList);

	void insertFunTrack(ErpFunTrack erpFunTrack);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @param string
	 * @return
	 */
	ErpFunTrack writeTrackByHouseKeyTrack(Integer cityId, Integer compId, BorrowOrReturnKeyParam param, String string);

	Map<String, Object> selectMgrTrackList(BaseMapParam param) throws Exception;

	Map<String,Integer> getCaseInfo(Integer cityId,Integer caseId,Integer caseType);

	/**
	 * 公共写跟进
	 * @author 臧铁
	 * @param param  userName  deptName  cityShareName  currentUserId  currentCompId  currentDeptId
	 * @param type  类型
	 * @param flag  开关 0关 1开
	 * @since 2017年5月19日
	 * @return
	 */
	void addTrack(Integer caseId, String caseNo, String type, String flag, Integer caseType, BaseMapParam param) throws Exception;
	
	/**
	 * 转换核心信息<br/>
	 * 请使用
	 * {@link CommonUtil}的convertSecretInfo方法
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param trackContent 跟进内容
	 * @param caseType
	 * @param phoneShow 显示电话=true
	 * @return
	 */
	@Deprecated
	String convertSecretInfo(String trackContent,String caseType,boolean phoneShow);
	void insertHousePeopleRelativeTrack(HousePeopleRelativeParam param,ErpFunUsers erpFunUsers);
	
	/**
	 * 删除跟进日志
	 * @author 熊刚
	 * @since 2017年9月21日
	 * @param map
	 * @param cityId
	 */
	public void deleteFunTrack(@Param("shardCityId")Integer cityId,@Param("param")BaseMapParam param);
	
	List<ErpFunTrack> getNewExaminTask(@Param("shardCityId")Integer cityId,@Param("param")BaseMapParam param);
	
	/**
	 * 所有创建跟进的方法
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	Map<String, Object> createTrackInfo(ErpCreateTrackInfoParam param);
	
	/**
	 * 审核任务完成之后的操作
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param auditRuntime
	 * @param cityId
	 * @param auditUserId
	 * @throws Exception 
	 */
	public ErpCreateTrackInfoParam auditEndExec(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId ,Integer trackFromType, Integer sureToAviliable);
	/**
	 * 审核任务完成之后的操作
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param auditRuntime
	 * @param cityId
	 * @param auditUserId
	 * @throws Exception 
	 */
	public void autoLimitAuditEndExec(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId ,Integer trackFromType); 
	
	boolean getMustBeWriteTrackInfo(CaseInfoDto caseInfoDto, Integer cityId, Integer compId, Integer caseType, Integer selfUserId);
	
	/**
	 * 生成门店+用户名信息
	 * @author 张宏利
	 * @since 2017年12月12日
	 * @param selfDeptName
	 * @param currUname
	 * @param compType
	 * @param isPersonalVersion
	 * @return
	 */
	public String getCurrUserName(String selfDeptName,String currUname,Integer compType, boolean isPersonalVersion);
	
	/**
	 * 获取加密和推荐条数
	 * @author 熊刚
	 * @since 2017年10月13日
	 * @param cityId
	 * @param caseType
	 * @param infoOwnerUserId
	 * @return[推荐条数，加密条数]
	 */
	Integer[] getSpecialCaseCount(Integer cityId, Integer caseId, Integer caseType, Integer infoOwnerUserId, Integer compId, Integer depyId);
	
	public void writeFunTrackForPublish(ErpCreateTrackInfoParam param, Boolean publish, Boolean cooperate);
	
	public Map<String, Integer> getUserAndDeptByCaseIdOffCaseType(Integer cityId, Integer caseType, Integer caseId);
	
	/**
	 * 获取房/客源信息的对象，查询不到会抛异常
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	public CaseInfoDto getCaseInfoById(Integer cityId, Integer caseId, Integer caseType);
	
	/**
	 * 增加工作量
	 * @author 张宏利
	 * @since 2018年2月1日
	 * @param param
	 */
	public void sendJmsMessageForWorkCount(ErpCreateTrackInfoParam param);

	void sendJmsMessageForWorkCount(Integer cityId, Const.StatisticDetailType countFieldName, Date auditCreationTime,
									Integer userId, Integer caseType, String caseId, Integer trackId, int countSize, Double dealMoney, Integer delaySeconds);
	/**
	 * 总经理查看电话写跟进
	 * @author 张宏利
	 * @since 2017年10月31日
	 * @param erpFunViewLog
	 */
	Integer writeTrackByGeneralViewLog(ErpFunViewLog erpFunViewLog, Byte caseStatus, String currUserName, Integer caseDeptId, Integer creatorUid, String trackContract);

	Integer[] detectHouseOrCustRepeat(Integer cityId, Integer compId, Integer caseId,Integer selfUid, Integer selfDeptId,
									  Integer caseType,Boolean isPersonalVersion,CaseInfoDto caseInfoDto);
	
	/**
	 * 创建审批之后写一条申请的跟进
	 * @author 张宏利
	 * @since 2017年11月30日
	 * @param param
	 */
	void createTrackForCreateAudit(ErpCreateTrackInfoParam param, ErpFunTrackExtend erpFunTrackExtend, ErpAuditRuntime auditRuntime);
	
	public void writeFailAuditTrack(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId, Integer trackFromType ,String trackContent);
	
	/**
	 * 新版首页带看热度
	 *@author 朱科
	 *@param 
	 *@return List<Map<String,Object>>
	 *@since 2018年3月8日
	 */
	List<Map<String, Object>> getBasicDaiKanHotrank(Integer cityId, Integer compId, Integer userId, String startTime, Integer houseCusts);

	void createTrackForTransData(Integer cityId, ErpFunUsers acceptUser, Integer caseType, List<Integer> caseIds, String[] caseNos, Byte plateType, DataTranslateParam param);

	Map<String,Object> writeTrackInfoToDeal(Integer cityId, ErpFunDeal funDeal, String trackContent, InsertDealInfoParam param);

	void createTrackForUndoDeal(GeneralParam generalParam, ErpFunDeal deal);

	void writeTrackByCreateHouseInfo(ErpFunRentCustomerParam param);

	void writeTrackInfoToMgrProfit(Integer cityId, InsertDealInfoParam param, ErpFunDeal dealPO);

	String getCaseOrgPath(Integer cityId, Integer caseId, Integer caseType);

	//void createTrackForTransData(Integer cityId,Integer compId,String srcUserId, Integer srcDeptId, ErpFunUsers acceptUser, String caseType, String[] caseIds, String[] caseNos, Byte plateType,Integer acceptDeptId);
}

