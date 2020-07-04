package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.common.param.BuildInfoVoiceNoteLogParam;
import com.myfun.erpWeb.managecenter.axn.param.CallRecordListParam;
import com.myfun.erpWeb.usercenter.param.UcenterVoiceParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminIpCallLogExample;

public interface AdminIpCallLogMapper extends BaseMapper<AdminIpCallLog, String> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminIpCallLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminIpCallLogExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminIpCallLog> selectByExample(AdminIpCallLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminIpCallLog record,
			@Param("example") AdminIpCallLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminIpCallLog record, @Param("example") AdminIpCallLogExample example);

	List<AdminIpCallLog> getCallRecordingList(AdminIpCallLog adminIpCallLog);

	List<AdminIpCallLog> getRecordingByIds(String substring);

	Integer callBackByLogId(String logId);

	List<AdminIpCallLog> getMgrVoiceNoteLog(@Param("param") Map<String, Object> param);

	List<AdminIpCallLog> getRecordingByIdArr(@Param("recordIds") String[] recordIds);

	/**
	 * 隐号(IP)拨打统计报表
	 * @author 臧铁
	 * @since 2017年9月11日
	 * @param param dimension:组织机构维度  startTime：开始时间  endTime：结束时间
	 * @return
	 */
	List<Map<String,Object>> getIpCallLogReport(@Param("param") Map<String, Object> map);
	
	/**
	 * 获取楼盘资料ip拨号统计，用ErpFunBuildTrackMapper.getIpCallBuildData
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param cityId
	 * @param map
	 * @return
	 */
	@Deprecated
	List<Map<String, Object>> getIpCallBuildData(Map<String, Object> param);
	
	/**
	 * 获取楼盘资料ip拨号语音列表，用ErpFunBuildTrackMapper.getBuildDataIpCallList
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @param cityId
	 * @param map
	 * @return
	 */
	@Deprecated
	List<AdminIpCallLog> getBuildDataIpCallList(Map<String, Object> map);
	
	/**
	 * 获取IP电话拨打记录列表
	 * @param cityId,compId,archiveId,dateRange,dateStrat,dateEnd
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @return
	 *
	 */
	List<AdminIpCallLog> getDataList(@Param("cityId") Integer cityId, @Param("compId") Integer compId, @Param("archiveId") Integer archiveId, @Param("rangeDateStrat") Date rangeDateStrat, @Param("rangeDateEnd") Date rangeDateEnd, @Param("dateStrat") Date dateStrat, @Param("dateEnd") Date dateEnd, @Param("paidAccount") String paidAccount);

	List<AdminIpCallLog> getAdminIpCallLogList( @Param("param")UcenterVoiceParam param);
	
	List<AdminIpCallLog> getBuildInfoIpCallLog(@Param("cityId") Integer cityId, @Param("compId") Integer compId, @Param("param")BuildInfoVoiceNoteLogParam param, @Param("deptIds")List<Integer> deptIds, @Param("userIds")List<Integer> userIdList);
	
	List<AdminIpCallLog> getCallRecordList(@Param("param") CallRecordListParam param);

	/**
	 * @brief 根据lOGID查询记录
	 * @detail [2020-3-8] lxt 修改ml生产环境报错的问题，无需求ID
	 * @param voipId  ： logiD
	 * @return 语音记录
	 * @author lxt
	 * @note
	 **/
    AdminIpCallLog selectByLogId(@Param("voipId") String voipId);
}